package csheets.framework.volt;

import java.util.Map;

public class Action {

    /**
     * Executes a action.
     *
     * @param args Arguments passed into the action.
     * 
     * Reserved arguments:
     * 
     * request:String - Gives the request from the client.
     * from:String    - Shows who made the request (IPv4:Port)
     * packets:String - Shows the number of total packets read.
     */
    public void run(Map<String, Object> args) {}
    
}
