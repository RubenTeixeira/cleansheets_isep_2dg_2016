/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game.controllers;

import csheets.AppSettings;
import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.NetworkManager;
import csheets.ext.game.domain.Battleship;
import csheets.ext.game.domain.Ship;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StylableSpreadsheet;
import csheets.ext.style.StyleExtension;
import csheets.support.ThreadManager;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import vendor.volt.Action;
import vendor.volt.Request;
import vendor.volt.protocols.tcp.TcpClient;
import vendor.volt.protocols.tcp.TcpServer;

/**
 *
 * @author Rui Bento
 */
public class BattleshipController implements SelectionListener, SpecificGameController {

    public static final String GAME_NAME = "Battleship";

    private final char START_CHAR = 'A';
    private final char END_CHAR = 'Z';
    private final String TCP_GAME_SERVER_NAME = "ipc.battleship-tcpServer";
    private final String REQUEST_PLAY = ":game-play";
    private final String REQUEST_RESPONSE = ":game-response";
    private final String RESPONSE_WIN = "win";
    private final String RESPONSE_SINK = "sink";
    private final String RESPONSE_HIT = "hit";
    private final String RESPONSE_WATER = "water";
    private final int CELL_WIDTH = 50;
    private final int CELL_HEIGHT = 50;
    private final Border cellBorder = BorderFactory.createMatteBorder(1, 1, 1, 1,
            Color.BLACK);

    private Battleship.BoardSize boardsize = Battleship.BoardSize.NORMAL;
    private int titleInfoCellColumn = 1, titleInfoCellRow = 1;
    private int infoCellColumn = 2, infoCellRow = 1;
    private int marginColumn = 2, marginRow = 4;
    private int columnShipStart = marginColumn + boardsize.size() + 1, rowShipStart = marginRow + 1;
    private int marginOwnBoardColumn = marginColumn + (boardsize.size() + 1) + 2;
    private int marginOwnBoardRow = marginRow;

    private UIController uiController;
    private TcpServer server;
    private Spreadsheet sheet;
    private StylableSpreadsheet styleSheet;
    private Battleship game;
    private String connection;
    private Map<Cell, Map.Entry<Ship.ShipType, Integer>> lstShips;
    private Map.Entry<Ship.ShipType, Integer> selectedShip;
    private boolean turn;
    private boolean readyToPlay;

    public BattleshipController(UIController uiController, boolean startTurn,
            String opponentIP) {
        this.uiController = uiController;
        this.turn = startTurn;
        this.connection = opponentIP + ":" + Integer.
                parseInt(AppSettings.instance().
                        get("TCP_PORT"));
        this.readyToPlay = false;
        this.lstShips = new HashMap<>();
    }

    /**
     * Add all playable cells Listenners
     */
    private void addListeners() {
        uiController.addSelectionListener(this);
        /*for (int i = 0; i < boardsize.size(); i++) {
            for (int j = 0; j < boardsize.size(); j++) {
                styleSheet.getCell(i + marginColumn, j + marginRow).addCellListener(this);
            }
        }*/
    }

    /**
     * Remove all playable cells Listenners
     */
    private void removeListeners() {
        for (int column = 0; column < sheet.getColumnCount(); column++) {
            for (int row = 0; row < sheet.getRowCount(); row++) {
                for (CellListener cellListener : uiController.getActiveSpreadsheet().getCellListeners()) {
                    sheet.getCell(column, row).removeCellListener(cellListener);
                    uiController.removeSelectionListener(this);
                }
            }
        }
    }

    @Override
    public void start() {
        game = new Battleship(boardsize, Battleship.BattleshipGameType.TYPE_1);
        startServer();
        createGameSpreedsheet();
        prepareShipsForEdit();
        //removeListeners();
        addListeners();
        createEditBoard();
        //repaintBoard();
    }

    private void startServer() {
        ThreadManager.create(TCP_GAME_SERVER_NAME, new Thread() {
            @Override
            public void run() {
                server = NetworkManager.tcp();
                server.expect(REQUEST_PLAY, new Action() {
                    @Override
                    public void run(Request request) {
                        String params[] = request.message().split(";");
                        int column = Integer.parseInt(params[0]);
                        int row = Integer.parseInt(params[1]);
                        verifyPlay(column, row);
                    }
                });
                server.expect(REQUEST_RESPONSE, new Action() {
                    @Override
                    public void run(Request request) {
                        switch (request.message()) {
                            case RESPONSE_WIN: {
                                break;
                            }
                            case RESPONSE_SINK: {
                                break;
                            }
                            case RESPONSE_HIT: {
                                break;
                            }
                            case RESPONSE_WATER: {
                                break;
                            }
                            default: {
                                // ignore
                            }
                        }
                    }
                });
            }
        });
        ThreadManager.run(TCP_GAME_SERVER_NAME);
    }

    @Override
    public void stopGame() {
        stopThis();
        removeListeners();
    }

    /**
     * Stops all the TCP services.
     */
    private void stopThis() {
        server.shutdown();
        ThreadManager.destroy(TCP_GAME_SERVER_NAME);
    }

    private void prepareShipsForEdit() {
        int shipCount = 0;
        for (Map.Entry<Ship.ShipType, Integer> entry : game.getShipCount().entrySet()) {
            lstShips.put(sheet.getCell(columnShipStart, rowShipStart + shipCount++), entry);
        }
    }

    private void createGameSpreedsheet() {
        uiController.getActiveWorkbook().addSpreadsheet();
        sheet = uiController.getActiveWorkbook().getSpreadsheet(
                uiController.getActiveWorkbook().getSpreadsheetCount() - 1);
        styleSheet = new StyleExtension().extend(sheet);
        //sheet = (StylableSpreadsheet)newSheet;
        styleSheet.setTitle(BattleshipController.GAME_NAME);
    }

    private void createEditBoard() {
        for (Cell cell : styleSheet.getCells()) {
            cell.clear();
        }
        try {
            styleSheet.getCell(infoCellColumn, infoCellRow).setContent("READY ?");
        } catch (FormulaCompilationException ex) {
            //Logger.getLogger(BattleshipController.class.getName()).log(Level.SEVERE, null, ex);
        }
        addCellConfig((StylableCell) styleSheet.getCell(titleInfoCellColumn,
                titleInfoCellRow), true);
        showBoard(marginColumn, marginRow);
        showShips();
    }

    private void showBoard(int startColumn, int startRow) {
        char charTitle = START_CHAR;
        StylableCell cell = (StylableCell) styleSheet.getCell(startColumn - 1,
                startRow - 1);
        cell.setBackgroundColor(Color.BLACK);
        //System.out.println(styleSheet.getRowHeight(startRow));
        for (int row = startRow, count = 1; count - 1 < boardsize.size(); row++, count++) {
            styleSheet.setRowHeight(row, CELL_HEIGHT);
            try {
                cell = (StylableCell) styleSheet.getCell(startColumn - 1, row);
                addCellConfig(cell, true);
                cell.setContent(String.valueOf(count));
            } catch (FormulaCompilationException ex) {
                //Logger.getLogger(BattleshipController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int column = startColumn, count = 1; count - 1 < boardsize.size(); column++, count++, charTitle++) {
            styleSheet.setColumnWidth(column, CELL_WIDTH);
            try {
                cell = (StylableCell) styleSheet.getCell(column, startRow - 1);
                addCellConfig(cell, true);
                cell.setContent(String.valueOf(charTitle));
            } catch (FormulaCompilationException ex) {
                //Logger.getLogger(BattleshipController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int column = startColumn; column < boardsize.size() + startColumn; column++) {
            for (int row = startRow; row < boardsize.size() + startRow; row++) {
                cell = (StylableCell) styleSheet.getCell(column, row);
                addCellConfig(cell, false);
            }
        }
    }

    private void addCellConfig(StylableCell cell, boolean bold) {
        cell.setBorder(cellBorder);
        cell.setHorizontalAlignment(SwingConstants.CENTER);
        cell.setVerticalAlignment(SwingConstants.CENTER);
        if (bold) {
            cell.setFont(cell.getFont().deriveFont(Font.BOLD));
        }
    }

    private void removeCellConfig(StylableCell cell) {
        cell.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,
                Color.WHITE));
        cell.setHorizontalAlignment(SwingConstants.LEFT);
        cell.setVerticalAlignment(SwingConstants.LEFT);
        cell.setFont(cell.getFont().deriveFont(Font.PLAIN));
    }

    private void showShips() {
        try {
            sheet.getCell(columnShipStart, rowShipStart - 1).setContent("SHIPS:");
            for (Map.Entry<Cell, Map.Entry<Ship.ShipType, Integer>> entry : lstShips.entrySet()) {
                entry.getKey().setContent(entry.getValue().getKey().name());
                sheet.getCell(entry.getKey().getAddress().getColumn() + 1,
                        entry.getKey().getAddress().getRow()).
                        setContent(entry.getValue().getValue().toString());
            }
        } catch (FormulaCompilationException ex) {
            System.out.println("Cannot write to cell. " + ex.toString());
        }
    }

    private void repaintBoard() {
        /*for (int i = 0; i < tictactoe.getRowCount(); i++) {
            for (int j = 0; j < tictactoe.getColumnCount(); j++) {
                try {
                    String value = tictactoe.getValueAt(i, j);
                    styleSheet.getCell(i + 1, j + 1).setContent(value);
                } catch (FormulaCompilationException ex) {
                    Logger.getLogger(TicTacToeController.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
        }*/
    }

    private void verifyPlay(int column, int row) {
        Cell cell = styleSheet.getCell(column, row);
        int shoot = game.shoot(cell.getAddress());
        String message = column + ";" + row;
        if (shoot == Battleship.SHOOT_SINK) {
            String playMessage = "Opponent sink a boat. ";
            if (game.allShipsDestroyed()) {
                new TcpClient(0).send(REQUEST_RESPONSE, connection, message + RESPONSE_WIN);
                playMessage += "=( YOU LOST =(";
            } else {
                new TcpClient(0).send(REQUEST_RESPONSE, connection, message + RESPONSE_SINK);
                playMessage += "Your turn ...";
            }
            printImage(Battleship.SHOOT_SINK, cell);
            showMessage(playMessage);
        } else if (shoot == Battleship.SHOOT_HIT) {
            new TcpClient(0).send(REQUEST_RESPONSE, connection, message + RESPONSE_HIT);
            printImage(Battleship.SHOOT_HIT, cell);
            showMessage("Opponent hit a boat. Your turn ...");
        } else {
            new TcpClient(0).send(REQUEST_RESPONSE, connection, message + RESPONSE_WATER);
            printImage(Battleship.SHOOT_FAIL, cell);
            showMessage("Opponent fail, he found water. Your turn ...");
        }
        //repaintBoard();
        turn = true;
    }

    private void printImage(int shootType, Cell cell) {
        switch (shootType) {
            case Battleship.SHOOT_SINK:
            case Battleship.SHOOT_HIT: {
                break;
            }
            case Battleship.SHOOT_FAIL: {
                break;
            }
        }
    }

    private void showMessage(String message) {
        try {
            styleSheet.getCell(infoCellColumn, infoCellRow).setContent(message);
        } catch (FormulaCompilationException ex) {
            Logger.getLogger(BattleshipController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void selectionChanged(SelectionEvent event) {
        if (event.getSpreadsheet().equals(sheet) && turn
                && !event.getCell().equals(sheet.getCell(0, 0))) {
            //uiController.setActiveCell(sheet.getCell(0, 0));
            //uiController.focusOwner.setCellSelectionEnabled(false);
            Cell cell = event.getCell();
            if (cell == null) {
                return;
            }
            if (isInsideBoardCell(cell)) {
                doBoardAction(cell);
                return;
            }
            if (isShip(cell)) {
                selectShip(cell);
                return;
            }
            if (isReadyCell(cell)) {
                setReady(cell, true);
                return;
            }
            return;
        }
    }

    private boolean isInsideBoardCell(Cell cell) {
        return cell.getAddress().getColumn() >= marginColumn
                && cell.getAddress().getColumn() <= marginColumn + boardsize.size()
                && cell.getAddress().getRow() <= marginRow
                && cell.getAddress().getRow() <= marginRow + boardsize.size();
    }

    private boolean isShip(Cell cell) {
        return !readyToPlay && lstShips.containsKey(cell);
    }

    private boolean isReadyCell(Cell cell) {
        return cell.getAddress().getColumn() == titleInfoCellColumn
                && cell.getAddress().getRow() == titleInfoCellRow
                && !readyToPlay;
    }

    private void doBoardAction(Cell cell) {
        //if () {
        //    
        //}
    }

    private void selectShip(Cell cell) {
        selectedShip = lstShips.get(cell);
    }

    private void setReady(Cell cell, boolean ready) {
        if (!game.isReadyToPlay()) {
            JOptionPane.showMessageDialog(null, "You are not ready to play. "
                    + "Place the missing ships to start the game.", "CANNOT BE "
                    + "READY", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            cell.setContent("X");
            this.readyToPlay = ready;
        } catch (FormulaCompilationException ex) {
            System.out.println("Unable to change cell content. " + ex);
        }
    }

    /*@Override
    public void contentChanged(Cell cell) {
        if (!cell.getContent().equals("")) {
            System.out.println("LALALALA");
            if (!turn) {
                cell.clear();
                return;
            }
            StringBuilder cellInfo = new StringBuilder(cell.getAddress().getColumn()
                    + ";" + cell.getAddress().getRow());
            new TcpClient(0).send(REQUEST_PLAY, connection, cellInfo.toString());
            turn = false;
        }
    }

    @Override
    public void valueChanged(Cell cell) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dependentsChanged(Cell cell) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cellCleared(Cell cell) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cellCopied(Cell cell, Cell source) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     */
}
