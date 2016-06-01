package csheets.framework.volt;

import java.io.IOException;

/**
 *
 * @author Renato Machado
 */
public abstract class Server {

    /**
     * If the server is active.
     */
    protected boolean active;

    protected Server() {
        this.active = false;
    }

    /**
     * Boots the server.
     *
     * @param port The port number.
     * @throws IOException Should throw a IOException if any I/O operation fails.
     */
    protected abstract void bootServer(int port) throws IOException;

    /**
     * Serves the server in the given port.
     *
     * @param port The port number.
     */
    public abstract void serve(int port);

    /**
     * Returns if the server is currently working.
     *
     * @return True if the server is active, false otherwise.
     */
    public boolean isActive() {
        return this.active;
    }
    
}
