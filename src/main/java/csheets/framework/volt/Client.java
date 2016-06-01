package csheets.framework.volt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Renato Machado
 */
public abstract class Client {
    /**
     * Client socket.
     */
    private Socket socket;
    
    /**
     * Server IP Address.
     */
    private String ip;
    
    /**
     * Server Port.
     */
    private int port;
    
    /**
     * Client Input Stream.
     */
    public BufferedReader input;
    
    /**
     * Client Output Stream.
     */
    public PrintWriter output;
    
    /**
     * Client registered events.
     */
    private Map<String, Event> events;
    
    /**
     * Checks if the client is already connected.
     */
    private boolean active;
    
    protected Client() {
        this.events = new HashMap<>();
        this.active = false;
    }
    
    public Client(String connection) {
        this();
        
        String[] data = connection.split(":");
        
        this.ip = data[0];
        this.port = Integer.parseInt(data[1]);
    }
    
    public Client(String ip, int port) {
        this();
        
        this.ip = ip;
        this.port = port;
    }
    
    /**
     * Listens to an event.
     * 
     * @param key Event key.
     * @param event Event action.
     */
    public void listen(String key, Event event) {
        this.events.put(key, event);
    }
    
    /**
     * Triggers the event action from a event key.
     * 
     * @param key Event key.
     */
    public void trigger(String key) {
        int separator = key.indexOf("/");
        
        String message = key.substring(separator + 1);
        
        key = key.substring(0, separator);
        
        if (this.events.containsKey(key)) {
            this.events.get(key).run(key, message);
            return;
        }
        
        throw new IllegalArgumentException("Invalid event key.");
    }
    
    /**
     * Execute the client.
     */
    public void run() {
        if (this.isActive()) {
            return;
        }
        
        try {
            this.active = true;
            
            this.socket = new Socket(this.ip, this.port);
            
            this.input = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            
            this.output = new PrintWriter(this.socket.getOutputStream(), true);
            
            try {
                while (this.isActive()) {
                    this.protocol(this.input, this.output);
                }
            } catch (Exception ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                this.input.close();
                this.output.close();
                this.socket.close();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Checks if the client is already connected.
     * 
     * @return True if the client is connected, false otherwise.
     */
    public boolean isActive() {
        return this.active;
    }
    
    /**
     * Closes the connection of the client.
     */
    public void stop() {
        this.active = false;
    }
    
    /**
     * Client protocol.
     * @param input Client Input Stream.
     * @param output Client Output Stream.
     */
    protected abstract void protocol(BufferedReader input, PrintWriter output);
}
