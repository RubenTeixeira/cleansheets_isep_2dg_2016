package csheets.framework.volt;

import csheets.framework.volt.protocols.tcp.TcpServer;
import csheets.framework.volt.protocols.udp.UdpServer;
import java.util.HashMap;
import java.util.Map;

/**
 * Volt allows to create servers and extend them in the lifetime of a application.
 * 
 * @author Renato Machado
 */
public class Volt {
    
    /**
     * Current active Volt services.
     */ 
    private static final Map<Integer, Server> instances = new HashMap<>();
    
    /**
     * Builds a new instance of the UDP server, or gets the current server
     * that is bound to that port.
     * 
     * @param port Port.
     * @return UdpServer instance or throws an exception.
     */
    public static UdpServer udp(int port)
    {
        synchronized (instances) {
            if (instances.containsKey(port)) {
                if (instances.get(port) instanceof UdpServer) {

                    if (! instances.get(port).isActive()) {
                        new Thread() {
                            @Override
                            public void run() {
                                instances.get(port).stream(port);
                            }
                        }.start();
                    }

                    return (UdpServer) instances.get(port);
                } else {
                    throw new IllegalArgumentException("The given port is already bound to another service that is not a UDP Server.");
                }
            }

            UdpServer server = new UdpServer();
            instances.put(port, server);

            new Thread() {
                @Override
                public void run() {
                    server.stream(port);
                }
            }.start();

            return server;
        }
    }
    
    /**
     * Builds a new instance of the UDP server, or gets the current server that
     * is bound to that port. If unable to get a server on the given port, it
     * uses the fallback port.
     *
     * @param port Port.
     * @param fallback Fallback port.
     * @return UdpServer instance or throws an exception.
     */
    public static UdpServer udp(int port, int fallback)
    {
        try {
            return Volt.udp(port);
        } catch (Exception portException) {
            try {
                return Volt.udp(fallback);
            } catch (Exception fallbackException) {
                throw new IllegalArgumentException(fallbackException.getMessage());
            }
        }
    }
    
    /**
     * Builds a new instance of the TCP server, or gets the current server that
     * is bound to that port.
     *
     * @param port Port.
     * @return TcpServer instance or throws an exception.
     */
    public static TcpServer tcp(int port)
    {
        synchronized (instances) {
            if (instances.containsKey(port)) {
                if (instances.get(port) instanceof TcpServer) {
                    if (! instances.get(port).isActive()) {
                        instances.get(port).stream(port);
                    }

                    return (TcpServer) instances.get(port);
                } else {
                    throw new IllegalArgumentException("The given port is already bound to another service that is not a TCP Server.");
                }
            }

            TcpServer server = new TcpServer();
            instances.put(port, server);

            new Thread() {
                @Override
                public void run() {
                    server.stream(port);
                }
            }.start();

            return server;
        }
    }
    
    /**
     * Builds a new instance of the TCP server, or gets the current server that
     * is bound to that port. If unable to get a server on the given port, it
     * uses the fallback port.
     *
     * @param port Port.
     * @param fallback Fallback port.
     * @return TcpServer instance or throws an exception.
     */
    public static TcpServer tcp(int port, int fallback)
    {
        try {
            return Volt.tcp(port);
        } catch (Exception portException) {
            try {
                return Volt.tcp(fallback);
            } catch (Exception fallbackException) {
                throw new IllegalArgumentException(fallbackException.getMessage());
            }
        }
    }
    
    /**
     * Stops a service on the given port, but maintains it's instance stored.
     * If no service exists on the given port, it throws an exception.
     * 
     * @param port Service port.
     */
    public static void stop(int port)
    {
        synchronized (instances) {
            if (! instances.containsKey(port)) {
                throw new IllegalArgumentException("Volt does not know about any service running on port " + port);
            }

            instances.get(port).shutdown();
        }
    }
    
    /**
     * Kills a service on the given port, and deletes it's instance. 
     * If no service exists on the given port, it throws an exception.
     *
     * @param port Service port.
     */
    public static void kill(int port)
    {
        Volt.stop(port);
        
        synchronized (instances) {
            instances.remove(port);
        }
    }
}
