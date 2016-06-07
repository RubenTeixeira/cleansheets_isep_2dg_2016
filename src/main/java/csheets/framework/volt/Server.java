package csheets.framework.volt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Renato Machado
 */
public abstract class Server {
    
    /**
     * Dependency Injection.
     */
    protected Map<String, Object> dependencies;
    
    /**
     * Route channels.
     */
    protected Map<String, List<Channel>> channels;
    
    /**
     * If the server is active.
     */
    protected boolean active;

    protected Server() {
        this.dependencies = new HashMap<>();
        this.channels = new HashMap<>();
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
    
    public abstract void stream(int port);
    
    public abstract void expect(String route, Action action);
    
    public abstract void neglect(String route);
    
    public abstract void send(String route, String target, String message);
    
    public abstract void shutdown();
    
    /**
     * Returns if the server is currently working.
     *
     * @return True if the server is active, false otherwise.
     */
    public boolean isActive() {
        return this.active;
    }
    
    /**
     * Allows Volt to access the given dependency through a key.
     * 
     * @param key Dependency key.
     * @param dependency Dependency.
     */
    public void use(String key, Object dependency)
    {
        this.dependencies.put(key, dependency);
    }
    
    /**
     * Allows Volt to access the given objects through its keys.
     * 
     * @param dependencies Multidimensional array containing in each row a String and a Object.
     */
    public void use(Object[][] dependencies)
    {
        for (Object[] dependency : dependencies) {
            this.use((String) dependency[0], dependency[1]);
        }
    }
    
    /**
     * Returns the object from the given key.
     * 
     * @param key Dependency key.
     * @return Dependency or null if key does not exist.
     */
    public Object get(String key)
    {
        return this.dependencies.get(key);
    }
    
    /**
     * Creates a new channel for a given route.
     * 
     * @param route Route that will trigger the channel.
     * @param channels Channels to be executed.
     */
    public void channel(String route, Channel... channels)
    {
        if (! this.channels.containsKey(route)) {
            this.channels.put(route, new ArrayList<>());
        }
        
        for (Channel channel : channels) {
            this.channels.get(route).add(channel);
        }
    }
    
    /**
     * Gets the channels of a route.
     * 
     * @param route Route.
     * @return Routes channels, or an empty list if no route was found.
     */
    public List<Channel> getRouteChannels(String route) 
    {
        if (this.channels.containsKey(route)) {
            return this.channels.get(route);
        }
        
        return new ArrayList<>();
    }
}
