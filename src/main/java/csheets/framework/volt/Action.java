package csheets.framework.volt;

import java.util.Map;

public class Action {

    /**
     * Executes a action.
     * 
     * <p>Sample declaration of a Action:</p>
     * 
     * <pre>
     * <code>
     * server.expect(":route", new Action() {
     *     &#64;Override
     *     public void run(Map&lt;String, Object&gt; args) {
     *         // ...
     *     }
     * });
     * </code>
     * </pre>
     * 
     * <p>Reserved arguments for <strong>UDP</strong> Protocol:</p>
     * 
     * <table summary="Reserved arguments for the UDP Protocol">
     * <tr>
     * <th>Name</th>
     * <th>Type</th>
     * <th>Description</th>
     * </tr>
     * <tr>
     * <td>message</td>   <td>String</td>      <td>Gives the request from the client.</td>
     * </tr>
     * <tr>
     * <td>length</td>    <td>String</td>      <td>Message length.</td>
     * </tr>
     * <tr>
     * <td>from</td>      <td>String</td>      <td>Shows who made the request (IPv4:Port).</td>
     * </tr>
     * <tr>
     * <td>packets</td>   <td>String</td>      <td>Shows the number of total packets read.</td>
     * </tr>
     * <tr>
     * <td>hostname</td>  <td>String</td>      <td>Host name of the request sender.</td>
     * </tr>
     * <tr>
     * <td>address</td>   <td>InetAddress</td> <td>Gives the InetAddress of the request sender.</td>
     * </tr>
     * </table>
     * 
     * <p>Reserved arguments for <strong>TCP</strong> Protocol</p>
     * 
     * <table summary="Reserved arguments for the TCP Protocol">
     * <tr>
     * <th>Name</th>
     * <th>Type</th>
     * <th>Description</th>
     * </tr>
     * 
     * <tr>
     * <td>route</td>     <td>String</td>         <td>Route that the request matched.</td>
     * </tr>
     * <tr>
     * <td>length</td>    <td>String</td>         <td>Message length.</td>
     * </tr>
     * <tr>
     * <td>message</td>   <td>String</td>         <td>Message received.</td>
     * </tr>
     * <tr>
     * <td>from</td>      <td>String</td>         <td>Request sender IPv4:Port.</td>
     * </tr>
     * <tr>
     * <td>hostname</td>  <td>String</td>         <td>Host name of the request sender.</td>
     * </tr>
     * <tr>
     * <td>input</td>     <td>BufferedReader</td> <td>Input Stream connected to the request sender.</td>
     * </tr>
     * <tr>
     * <td>output</td>    <td>PrintWriter</td>    <td>Output Stream connected to the request sender.</td>
     * </tr>
     * <tr>
     * <td>socket</td>    <td>Socket</td>         <td>Socket connected to the request sender.</td>
     * </tr>
     * </table>
     * 
     * @param args Arguments passed into the action.
     */
    public void run(Map<String, Object> args) {
        throw new UnsupportedOperationException("The Action run method must be defined in a separate class or anonymously.");
    }
    
}
