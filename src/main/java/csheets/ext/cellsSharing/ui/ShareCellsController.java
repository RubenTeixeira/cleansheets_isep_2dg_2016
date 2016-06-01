package csheets.ext.cellsSharing.ui;

import csheets.core.Cell;

public class ShareCellsController {
    
    /**
     * The UDP Service.
     */
    private UdpService udpService;
    
    /**
     * The TCP Service.
     */
    private TcpService tcpService;
    
    /**
     * Starts the UDP service.
     *
     * @param port The target port that is defined by the user.
     * @param seconds The number of seconds to execute each request.
     */
    private void startUdpService(int port, int seconds)
    {
        if (port < 0 || port > 49151) {
            throw new IllegalArgumentException("Invalid port was defined. Please select a valid port.");
        }

        if (seconds <= 0) {
            throw new IllegalArgumentException("Invalid seconds number given. It's not possible to register negative or zero seconds.");
        }

        try {
            this.udpService.server(30600, port);
            this.udpService.client(seconds);
        } catch (IllegalArgumentException e) {
            this.udpService.stop();

            throw e;
        }
    }
    
    /**
     * Starts the UDP service.
     * 
     * @param panel The user interface.
     * @param port The target port that is defined by the user.
     * @param seconds The number of seconds to execute each request.
     */
    public void startUdpService(SharePanel panel, int port, int seconds)
    {
        if (panel == null) {
            throw new IllegalArgumentException("The user interface cannot be null.");
        }
        
        this.udpService = new UdpService();
        
        this.startUdpService(port, seconds);
        
        this.udpService.addObserver(panel);
    }
    
    /**
     * Starts the TCP service.
     *
     * @param port The target port that is defined by the user.
     */
    private void startTcpService(int port)
    {
        if (port < 0 || port > 49151) {
            throw new IllegalArgumentException("Invalid port was defined. Please select a valid port.");
        }

        try {
            this.tcpService.server(port);

        } catch (IllegalArgumentException e) {
            this.tcpService.stop();

            throw e;
        }
    }
    
    /**
     * Starts the TCP service.
     *
     * @param panel The user interface.
     * @param port The target port that is defined by the user.
     */
    public void startTcpService(SharePanel panel, int port)
    {
        if (panel == null) {
            throw new IllegalArgumentException("The user interface cannot be null.");
        }
        
        this.tcpService = new TcpService();
        
        this.startTcpService(port);
        
        this.tcpService.addObserver(panel);
    }
    
    /**
     * Restarts both the UDP and TCP services.
     * 
     * @param port The target port that is defined by the user.
     * @param seconds The number of seconds to execute each request.
     */
    public void restartServices(int port, int seconds)
    {
        this.tcpService.stop();
        this.udpService.stop();
        
        this.startUdpService(port, seconds);
        this.startTcpService(port);
    }
    
    /**
     * Sends a array of Cells to the targeted host.
     *
     * @param target Targeted Host (ip and port)
     * @param cells Array of Cells
     */
    public void sendCells(int port, String target, Cell[][] cells) {

        String message = "";
        int linhas = cells.length;
        int colunas = cells[0].length;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                Cell cell = cells[i][j];

                message += cell.getAddress().getColumn() + ";" + cell.getAddress().getRow() + ";" + cell.getValue().getType() + ";" + cell.getValue() + ";";
            }
        }
        
        new TcpService().client(target, message);
    }
}
