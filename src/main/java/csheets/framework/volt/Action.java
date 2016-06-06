package csheets.framework.volt;

import java.util.Map;

public class Action {

    /**
     * Executes a action.
     * 
     * @param args Arguments passed into the action.
     * 
     * Sample declaration of a Action:
     * 
     * ```code
     * server.expect(":route", new Action() {
     *     @Override
     *     public void run(Map<String, Object> args) {
     *         // ...
     *     }
     * });
     * ```
     * 
     * Reserved arguments (UDP):
     * 
     * Name      Type           Description
     * 
     * message   :String      - Gives the request from the client.
     * length    :String      - Message length.
     * from      :String      - Shows who made the request (IPv4:Port).
     * packets   :String      - Shows the number of total packets read.
     * hostname  :String      - Host name of the request sender.
     * address   :InetAddress - Gives the InetAddress of the request sender.
     * 
     * 
     * Reserved arguments (TCP):
     * 
     * Name      Type              Description
     * 
     * route     :String         - Route that the request matched.
     * length    :String         - Message length.
     * message   :String         - Message received.
     * from      :String         - Request sender IPv4:Port.
     * hostname  :String         - Host name of the request sender.
     * input     :BufferedReader - Input Stream connected to the request sender.
     * output    :PrintWriter    - Output Stream connected to the request sender.
     * socket    :Socket         - Socket connected to the request sender.
     */
    public void run(Map<String, Object> args) {}
    
}
