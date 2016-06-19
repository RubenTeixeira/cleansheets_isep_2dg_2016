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
import csheets.support.ThreadManager;
import csheets.ui.ctrl.UIController;
import java.util.logging.Level;
import java.util.logging.Logger;
import vendor.volt.Action;
import vendor.volt.Request;
import vendor.volt.protocols.tcp.TcpClient;
import vendor.volt.protocols.tcp.TcpServer;

/**
 *
 * @author Rui Bento
 */
public class BattleshipController implements CellListener, SpecificGameController {

    public static final String GAME_NAME = "Battleship";

    private final String TCP_GAME_SERVER_NAME = "ipc.battleship-tcpServer";
    private final String REQUEST_PLAY = ":game-play";
    private final String REQUEST_RESPONSE = ":game-response";
    private final String RESPONSE_WIN = "win";
    private final String RESPONSE_SINK = "sink";
    private final String RESPONSE_HIT = "hit";
    private final String RESPONSE_WATER = "water";
    private final String PLAY_SYMBOL = "X";

    private Battleship.BoardSize boardsize = Battleship.BoardSize.NORMAL;
    private int titleInfoCellColumn = 1, titleInfoCellRow = 1;
    private int infoCellColumn = 2, infoCellRow = 1;
    private int marginColumn = 2,marginRow = 4;
    private int marginOwnBoardColumn = marginColumn+(boardsize.size()+1)+2;
    private int marginOwnBoardRow = marginRow;

    private UIController uiController;
    private TcpServer server;
    private Spreadsheet sheet;
    private Battleship game;
    private String connection;
    private boolean turn;

    public BattleshipController(UIController uiController, boolean startTurn,
            String opponentIP) {
        this.uiController = uiController;
        this.turn = turn;
        connection = opponentIP + ":" + Integer.
                parseInt(AppSettings.instance().
                        get("TCP_PORT"));
    }

    /**
     * Add all playable cells Listenners
     */
    private void addListeners() {
        for (int i = 0; i < boardsize.size(); i++) {
            for (int j = 0; j < boardsize.size(); j++) {
                sheet.getCell(i + marginColumn, j + marginRow).addCellListener(this);
            }
        }
    }

    /**
     * Remove all playable cells Listenners
     */
    private void removeListeners() {
        for (int i = 0; i < boardsize.size(); i++) {
            for (int j = 0; j < boardsize.size(); j++) {
                sheet.getCell(i + marginColumn, j + marginRow).removeCellListener(this);
            }
        }
    }
    
    @Override
    public void start() {
        game = new Battleship(boardsize, Battleship.BattleshipGameType.TYPE_1);
        startServer();
        createGameSpreedsheet();
        addListeners();
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
                        verifyPlay(request.message());
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
    public void stopThis() {
        server.shutdown();
        ThreadManager.destroy(TCP_GAME_SERVER_NAME);
    }

    private void createGameSpreedsheet() {
        uiController.getActiveWorkbook().addSpreadsheet();
        Spreadsheet s = uiController.getActiveSpreadsheet();
        s.setTitle(BattleshipController.GAME_NAME);
    }

    public void repaintBoard() {
        /*for (int i = 0; i < tictactoe.getRowCount(); i++) {
            for (int j = 0; j < tictactoe.getColumnCount(); j++) {
                try {
                    String value = tictactoe.getValueAt(i, j);
                    sheet.getCell(i + 1, j + 1).setContent(value);
                } catch (FormulaCompilationException ex) {
                    Logger.getLogger(TicTacToeController.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
        }*/
    }

    public void verifyPlay(String message) {
        String params[] = message.split(";");
        int column = Integer.parseInt(params[0]);
        int row = Integer.parseInt(params[1]);
        Cell cell = sheet.getCell(column, row);
        int shoot = game.shoot(cell.getAddress());
        if (shoot == Battleship.SHOOT_SINK) {
            String playMessage = "Opponent sink a boat. ";
            if (game.allShipsDestroyed()) {
                new TcpClient(0).send(REQUEST_RESPONSE, connection, RESPONSE_WIN);
                playMessage += "=( YOU LOST =(";
            } else {
                new TcpClient(0).send(REQUEST_RESPONSE, connection, RESPONSE_SINK);
                playMessage += "Your turn ...";
            }
            printImage(Battleship.SHOOT_SINK, cell);
            showMessage(playMessage);
        } else if (shoot == Battleship.SHOOT_HIT) {
            new TcpClient(0).send(REQUEST_RESPONSE, connection, RESPONSE_HIT);
            printImage(Battleship.SHOOT_HIT, cell);
            showMessage("Opponent hit a boat. Your turn ...");
        } else {
            new TcpClient(0).send(REQUEST_RESPONSE, connection, RESPONSE_WATER);
            printImage(Battleship.SHOOT_FAIL, cell);
            showMessage("Opponent fail, he found water. Your turn ...");
        }
        //repaintBoard();
        turn = true;
    }

    private void printImage(int shootType, Cell cell) {
        switch(shootType) {
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
            sheet.getCell(infoCellColumn, infoCellRow).setContent(message);
        } catch (FormulaCompilationException ex) {
            Logger.getLogger(BattleshipController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contentChanged(Cell cell) {
        /*if (!cell.getContent().equalsIgnoreCase(PLAY_SYMBOL)) {
            repaintBoard();
            return;
        }
        if (turn) {
            int column = cell.getAddress().getColumn();
            int row = cell.getAddress().getRow();
            if (tictactoe.validatePlayerMove(column - 1, row - 1, symbol)) {
                String message = column + ";" + row + ";" + cell.getContent();
                tictactoe.play(column - 1, row - 1, cell.getContent());
                if (winningPlay(column, row, cell.getContent())) {
                    return;
                }
                if (draw(column, row, cell.getContent())) {
                    return;
                }
                new TcpClient(0).send(":game-play", connection, message);
                turn = false;
                repaintBoard();
                try {
                    sheet.getCell(1, 6).
                            setContent("Esperando pela outra resposta");
                    repaintBoard();
                } catch (FormulaCompilationException ex) {
                    Logger.getLogger(TicTacToeController.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    sheet.getCell(1, 6).setContent("A tua jogada nao é valida");
                    repaintBoard();
                } catch (FormulaCompilationException ex) {
                    Logger.getLogger(TicTacToeController.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }

        }
        repaintBoard();*/
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

}
