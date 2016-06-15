/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game.ui;

import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.support.ThreadManager;
import csheets.ui.ctrl.UIController;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import vendor.volt.Action;
import vendor.volt.Request;
import vendor.volt.Volt;
import vendor.volt.protocols.tcp.TcpClient;
import vendor.volt.protocols.tcp.TcpServer;

/**
 *
 * @author AB
 */
public class TestController implements CellListener {

    private TcpServer server;
    UIController uiController;
    String connection;
    boolean otherPlay;
    boolean turn;

    public TestController(UIController uiController, boolean turn, String ip) {
        this.turn = turn;
        this.uiController = uiController;
        connection = "192.168.1.105" + ":9449";
        startServer();

    }

    public void addListeners() {
        uiController.getActiveSpreadsheet().getCell(0, 0).addCellListener(this);
        uiController.getActiveSpreadsheet().getCell(0, 1).addCellListener(this);
        uiController.getActiveSpreadsheet().getCell(0, 2).addCellListener(this);
        uiController.getActiveSpreadsheet().getCell(1, 0).addCellListener(this);
        uiController.getActiveSpreadsheet().getCell(1, 1).addCellListener(this);
        uiController.getActiveSpreadsheet().getCell(1, 2).addCellListener(this);
        uiController.getActiveSpreadsheet().getCell(2, 0).addCellListener(this);
        uiController.getActiveSpreadsheet().getCell(2, 1).addCellListener(this);
        uiController.getActiveSpreadsheet().getCell(2, 2).addCellListener(this);
    }

    private void startServer() {
        ThreadManager.create("ipc.tictactoe-tcpServer", new Thread() {
            @Override
            public void run() {
                server = Volt.tcp(9449);

                server.expect(":game-play", new Action() {
                    @Override
                    public void run(Request request) {
                        String cellString = request.message();
                        
                        String params[] = cellString.split(";");
                        
                        Cell spreadcheetCell = uiController.
                                getActiveSpreadsheet().
                                getCell(Integer.
                                        parseInt(params[0]), Integer.
                                        parseInt(params[0]));
                        
                        try {
                            spreadcheetCell.
                                    setContent(params[2]);
                            otherPlay = true;
                        } catch (FormulaCompilationException ex) {
                            Logger.
                                    getLogger(TestController.class.
                                            getName()).
                                    log(Level.SEVERE, null, ex);
                        }
                    }
                });
                server.expect(":game-lost", new Action() {
                    @Override
                    public void run(Request request) {
                        
                        String cellString = request.message();
                        String params[] = cellString.
                                split(";");
                        Cell spreadcheetCell = uiController.
                                getActiveSpreadsheet().
                                getCell(Integer.
                                        parseInt(params[0]), Integer.
                                        parseInt(params[0]));
                        try {
                            spreadcheetCell.
                                    setContent(params[2]);
                            otherPlay = true;
                        } catch (FormulaCompilationException ex) {
                            Logger.
                                    getLogger(TestController.class.
                                            getName()).
                                    log(Level.SEVERE, null, ex);
                        }
                        diplayLoss();
                        stopThis();
                    }
                });

            }
        });

        ThreadManager.run("ipc.tictactoe-tcpServer");
    }

    /**
     * Stops all the TCP services.
     */
    public boolean winningPlay(Cell cell) {
        if (isWinningPlay()) {
            String message = cell.getAddress().getColumn() + ";" + cell.
                    getAddress().getRow() + ";" + cell.getContent();
            new TcpClient(0).send(":game-lost", connection, message);
            stopThis();
            diplayVictory();
            return true;
        }
        return false;
    }

    /**
     * Stops all the TCP services.
     */
    public void stopThis() {
        server.shutdown();
        ThreadManager.destroy("ipc.tictactoe-tcpServer");
    }

    private boolean isWinningPlay() {
        return false;
    }

    private void diplayLoss() {
        System.out.println("lost");
    }

    private void diplayVictory() {
        System.out.println("Won");
    }

    private boolean validate() {
        return true;
    }

    @Override
    public void contentChanged(Cell cell) {
        if (!cell.getSpreadsheet().equals(uiController.getActiveSpreadsheet())) {
            return;
        }

        if (turn) {
            if (validate()) {
                String message = cell.getAddress().getColumn() + ";" + cell.
                        getAddress().getRow() + ";" + cell.getContent();
                new TcpClient(0).send(":game-play", connection, message);
                turn = false;
            } else {
                cell.clear();
            }
        } else if (otherPlay) {
            otherPlay = false;
            turn = true;
        } else {
            cell.clear();
        }
    }

    @Override
    public void dependentsChanged(Cell cell) {
    }

    @Override
    public void cellCleared(Cell cell) {
    }

    @Override
    public void cellCopied(Cell cell, Cell source) {
    }

    @Override
    public void valueChanged(Cell cell) {
    }

}
