package csheets.framework.volt.protocols.udp;

import csheets.framework.volt.Action;
import csheets.framework.volt.Channel;
import csheets.support.Task;
import csheets.support.TaskManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import csheets.framework.volt.Server;

public class UdpServer extends Server {

    private DatagramSocket server;
    private InetAddress client;

    private int clientPort;
    
    private final Map<String, Action> routes;
    
    private final Map<String, String> hashedRoutes;
    
    protected final Map<String, Map<String, Map<Integer, String>>> packets;

    public UdpServer() {
        super();

        this.routes = new HashMap<>();
        this.packets = new HashMap<>();
        this.hashedRoutes = new HashMap<>();
    }

    public void close() {
        super.active = false;
    }

    public DatagramSocket server() {
        synchronized (this.server) {
            return this.server;
        }
    }

    protected InetAddress getClient() {
        synchronized (this.client) {
            return this.client;
        }
    }

    protected int getClientPort() {
        return this.clientPort;
    }

    @Override
    public void bootServer(int port) {
        try {
            if (this.server != null) {
                this.server.disconnect();
                this.server.close();
                this.server = new DatagramSocket(port);
            } else {
                this.server = new DatagramSocket(port);
            }
            
            this.server.setSoTimeout(1000);
        } catch (SocketException ex) {
            throw new IllegalArgumentException("Could not initiate the UDP service because the given port was already in use.");
        }

        this.active = true;
    }

    /**
     * Handles the given request route.
     *
     * @param request Request route.
     * @return True if successful in handling the route, false if they don't
     * match.
     */
    private synchronized Action getActionFromRequest(String request, String message, Map<String, Object> arguments) {
        Action action = null;
        String route = null;
        
        if (this.hashedRoutes.containsKey(request)) {
            route = this.hashedRoutes.get(request);
            action = this.routes.get(route);
        }
            
        if (action == null || route == null) {
            return null;
        }
        
        arguments.put("message", message);
        arguments.put("route", route);
        
        // Execute all the before channels.
        for (Channel channel : getRouteChannels(route)) {
            channel.before(arguments, dependencies);
        }
        
        // We have found an action to perform, but now we need the route arguments.
        // Since we can pass up as much information as possible in a Packet,
        // we'll control the messages using a cyclic route. This means that we
        // need to break the message for each route cycle. For example:
        // Route: :name|:file
        // Message: Students|Students.json|foobar|foobar.xml
        // Gives:
        // Variable :name -> [ Students, foobar ]
        // Variable :file -> [ Students.json, foobar.xml ]
        
        String[] routeTokens = route.split("\\|");
        String[] requestTokens = ((String) arguments.get("message")).split("\\|");
        
        int length = requestTokens.length / routeTokens.length;
        
        for (int i = 0; i < routeTokens.length; i++) {
            routeTokens[i] = routeTokens[i].substring(1);
            arguments.put(routeTokens[i], new ArrayList<>());
        }
        
        int item = 0;
        
        for (int i = 0; i < length; i++) {
            for (String routeToken : routeTokens) {
                ((List) arguments.get(routeToken)).add(requestTokens[item++]);
            }
        }

        return action;
    }
    
    /**
     * Gets the UDP packet headers.
     * 
     * @param packet Packet message.
     * @return Map containing the header names as key and header values as value.
     */
    private Map<String, String> getPacketHeaders(String packet) {
        Map<String, String> headers = new HashMap<>();

        String[] tokens = packet.split("@")[0].split(":");

        headers.put("id", tokens[0]);
        headers.put("count", tokens[1]);
        headers.put("route", tokens[2]);
        headers.put("checksum", tokens[3]);

        return headers;
    }
    
    /**
     * Serves the server in the given port.
     * 
     * @param port Service port.
     */
    @Override
    public void serve(int port)
    {
        this.stream(port);
    }
    
    /**
     * Streams the server in the given port.
     * 
     * @param port Service port.
     */
    public void stream(int port) {
        if (this.isActive()) {
            return;
        }

        this.bootServer(port);
        
        while (isActive()) {
            try {
                
                final DatagramPacket request = new DatagramPacket(new byte[512], 512);

                this.server().receive(request);
                
                new Thread() {
                    @Override
                    public void run() {
                        final Map<String, String> headers;
                        final Map<String, Object> arguments = new HashMap<>();
                        final String packet;
                        final String client;
                        final String message;
                        final InetAddress address;
                        
                        synchronized (request) {
                            try {    
                                packet = new String(request.getData(), "UTF-8");
                                
                                headers = getPacketHeaders(packet);
                                address = request.getAddress();
                                message = packet.split("@")[1].trim();
                                
                                client = (request.getAddress() + ":" + request.getPort()).substring(1);
                               
                            } catch (UnsupportedEncodingException ex) {
                                Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
                                this.interrupt();
                                return;
                            }
                        }
                        
                        if (! headers.get("count").equals("1")) {
                            TaskManager manager = new TaskManager();
                            
                            synchronized (packets) {
                                if (! packets.containsKey(client)) {
                                    Map<String, Map<Integer, String>> map = new HashMap<>();
                                    
                                    map.put(headers.get("checksum"), new HashMap<>());
                                    map.get(headers.get("checksum")).put(Integer.parseInt(headers.get("id")), message);
                                    
                                    packets.put(client, map);
                                    
                                    // Only happens if the checksum wasn't available in the first time.
                                    manager.after(3).once(new Task() {
                                        public void fire() {
                                            packets.get(client).remove(headers.get("checksum"));
                                            this.kill();
                                            interrupt();
                                        }
                                    });
                                } else {
                                    
                                    if (packets.get(client).containsKey(headers.get("checksum"))) {
                                        packets.get(client).get(headers.get("checksum")).put(Integer.parseInt(headers.get("id")), message);
                                    } else {
                                        Map<Integer, String> id = new HashMap<>();
                                        id.put(Integer.parseInt(headers.get("id")), message);
                                        
                                        packets.get(client).put(headers.get("checksum"), id);
                                        
                                        // Only happens if the checksum wasn't available in the first time.
                                        manager.after(3).once(new Task() {
                                            @Override
                                            public void fire() {
                                                packets.get(client).remove(headers.get("checksum"));
                                                this.kill();
                                                interrupt();
                                            }
                                        });
                                    }
                                }
                                
                                int count = Integer.parseInt(headers.get("count"));
                                
                                if (packets.get(client).get(headers.get("checksum")).size() == count) {
                                    manager.destroy();
                                    
                                    final StringBuilder builder = new StringBuilder();
                                    
                                    for (int i = 1; i <= count; i++) {
                                        builder.append(packets.get(client).get(headers.get("checksum")).get(i));
                                    }
                                    
                                    String requestMessage = builder.toString();
                                    
                                    Action action = getActionFromRequest(headers.get("route"), requestMessage, arguments);

                                    if (action == null) {
                                        this.interrupt();
                                        return;
                                    }
                                    
                                    arguments.put("from", client);
                                    arguments.put("packets", headers.get("count"));
                                    arguments.put("hostname", address.getHostName());
                                    arguments.put("address", address);
                                    arguments.put("length", message.length());
                                    
                                    synchronized (action) {
                                        action.run(arguments);
                                    }
                                    
                                    // Execute all the after channels.
                                    for (Channel channel : getRouteChannels((String) arguments.get("route"))) {
                                        channel.after(arguments, dependencies);
                                    }
                                    
                                    this.interrupt();
                                    return;
                                }
                            }
                        } else {
                            Action action = getActionFromRequest(headers.get("route"), message, arguments);

                            if (action == null) {
                                this.interrupt();
                                return;
                            }

                            arguments.put("from", client);
                            arguments.put("packets", headers.get("count"));
                            arguments.put("hostname", address.getHostName());
                            arguments.put("address", address);
                            arguments.put("length", message.length());
                            
                            synchronized (action) {
                                action.run(arguments);
                            }
                            
                            // Execute all the after channels.
                            for (Channel channel : getRouteChannels((String) arguments.get("route"))) {
                                channel.after(arguments, dependencies);
                            }
                            
                            this.interrupt();
                            return;
                        }
                        this.interrupt();
                        return;
                    }
                }.start();
            } catch (IOException ex) {
                // Don't do anything.
            }
        }

        this.server().close();
    }
    
    /**
     * Sends a given message to the route of the target.
     * 
     * @param route Route defined by the target.
     * @param target IPv4 and Port (separated by ":")
     * @param message Message to send, no headers.
     */
    @Override
    public void send(String route, String target, String message) {
        try {
            if (server() == null) {
                return;
            }
        } catch (NullPointerException e) {
            return;
        }
        
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("message", message);
        
        // Execute all the before channels.
        for (Channel channel : getRouteChannels(route)) {
            channel.before(arguments, dependencies);
        }

        message = (String) arguments.get("message");
        
        int parts = 0, length = message.length();
        
        CRC32 checkRoute = new CRC32();
        CRC32 checkMessage = new CRC32();
        
        try {
            checkRoute.update(route.getBytes("UTF-8"));
            checkMessage.update(route.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Check if the message is a multipart message.
        if (length > 512) {
            while (length > 0) {
                length -= 512;
                parts++;
            }

            // Simulate if we need more parts to complete the message.
            int overhead = 0;
            for (int i = 1; i <= parts; i++) {
                overhead += (i + ":" + parts + ":" + checkRoute.getValue() + ":" + checkMessage.getValue() + "@").length();
            }

            length += overhead;

            while (length > 512) {
                length -= 512;
                parts++;
            }
        }

        this.protocol(route, target, parts, message);
    }
    
    /**
     * Sets a action for a expected route.
     * 
     * @param route Expected route.
     * @param action Action to be executed.
     */
    @Override
    public void expect(String route, Action action) {
        CRC32 checksum = new CRC32();

        try {
            checksum.update(route.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        synchronized (this.routes) {
            this.routes.put(route, action);
            this.hashedRoutes.put(String.valueOf(checksum.getValue()), route);
        }
    }
    
    /**
     * Neglects an expected route.
     * 
     * @param route Route to be neglected.
     */
    public void neglect(String route) {
        synchronized (this.routes) {
            this.routes.remove(route);
            
            for (Map.Entry<String, String> entry : this.hashedRoutes.entrySet()) {
                if (entry.getValue().equals(route)) {
                    this.hashedRoutes.remove(entry.getKey());
                    break;
                }
            }
        }
        
        synchronized (this.channels) {
            this.channels.remove(route);
        }
    }
    
    /**
     * Gets all of the routes.
     * 
     * @return Routes.
     */
    public Map<String, Action> routes() {
        synchronized (this.routes) {
            return this.routes;
        }
    }

    /**
     * Protocol to be used by the server.
     *
     * @param route The target route.
     * @param target The target the server will contact.
     * @param parts The number of parts the server should send.
     * @param message The message to be sent.
     */
    protected void protocol(String route, String target, int parts, String message)
    {
        if (target.startsWith("255.255.255.255")) {
            try {
                this.server().setBroadcast(true);
            } catch (SocketException ex) {
                Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (target.startsWith("all")) {
            target = target.replace("all", "255.255.255.255");
            try {
                this.server().setBroadcast(true);
            } catch (SocketException ex) {
                Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        CRC32 checksumRoute = new CRC32();
        CRC32 checksumMessage = new CRC32();

        try {
            checksumMessage.update(message.getBytes("UTF-8"));
            checksumRoute.update(route.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (parts > 0) {
            String[] messages = new String[parts];

            for (int i = 1; i <= parts; i++) {
                String header = i + ":" + parts + ":" + checksumRoute.getValue()
                        + ":" + checksumMessage.getValue() + "@";
                int length = header.length();
                int cut = 512 - length;
                int messageLength = message.length();

                if (cut > messageLength) {
                    cut = messageLength;
                }

                String part = message.substring(0, cut);
                message = message.substring(cut, message.length());

                messages[i - 1] = header + part;

            }
            
            String[] targetData = target.split(":");

            if (targetData.length != 2) {
                throw new IllegalArgumentException("The target must be consisted of a IPv4 and a Port separated by \":\". Example: all:8000");
            }

            int port = Integer.parseInt(targetData[1]);
            
            for (String part : messages) {
                try {
                    DatagramPacket packet = new DatagramPacket(part.getBytes("UTF-8"), part.length(), InetAddress.getByName(targetData[0]), port);

                    this.server().send(packet);

                } catch (UnknownHostException | UnsupportedEncodingException | SocketException ex) {
                    Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            Map<String, Object> arguments = new HashMap<>();
            arguments.put("message", message);
            arguments.put("target", target);
            arguments.put("packets", parts);
            
            // Execute all the after channels.
            for (Channel channel : getRouteChannels(route)) {
                channel.after(arguments, dependencies);
            }
            
            try {
                this.server().setBroadcast(false);
                return;
            } catch (SocketException ex) {
                Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            String header = "1:1:" + checksumRoute.getValue()
                    + ":" + checksumMessage.getValue();

            String packetMessage = header + "@" + message;

            String[] targetData = target.split(":");
            
            if (targetData.length != 2) {
                throw new IllegalArgumentException("The target must be consisted of a IPv4 and a Port separated by \":\". Example: all:8000");
            }
            
            int port = Integer.parseInt(targetData[1]);

            try {
                DatagramPacket packet = new DatagramPacket(packetMessage.getBytes("UTF-8"), packetMessage.length(), InetAddress.getByName(targetData[0]), port);
                this.server().send(packet);
                this.server().setBroadcast(false);
                
                Map<String, Object> arguments = new HashMap<>();
                arguments.put("message", message);
                arguments.put("target", target);
                arguments.put("packets", parts);

                // Execute all the after channels.
                for (Channel channel : getRouteChannels(route)) {
                    channel.after(arguments, dependencies);
                }
            } catch (UnknownHostException | UnsupportedEncodingException | SocketException ex) {
                //Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                //Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Shuts the server down.
     */
    @Override
    public void shutdown()
    {
        try {
            synchronized (this.server) {
                try {
                    super.active = false;
                    
                    if (this.server == null) {
                        return;
                    }
                    
                    this.server.disconnect();
                    this.server.close();

                } catch (Exception e) {
                    throw new IllegalArgumentException(e.getMessage());
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    
    /**
     * Returns the signature of the server.
     * 
     * @return IPv4 and Port (separated by ":")
     */
    public synchronized String signature()
    {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            return "0.0.0.0";
        }
    }
    
    /**
     * Checks if the client connected to the server is the server.
     * 
     * Example: A server contacting itself on a broadcast message.
     * @param from IPv4 and Port (separated by ":")
     * @return True if they have the same signature, false otherwise.
     */
    public synchronized boolean same(Object from)
    {
        String signature = this.signature();
        
        String other = ((String) from).split(":")[0];
        
        return other.equals(signature) || signature.equals("0.0.0.0");
    }
    
}
