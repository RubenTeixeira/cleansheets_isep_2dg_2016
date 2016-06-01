/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.framework.volt.protocols.tcp;

import csheets.framework.volt.Action;
import java.util.Map;

/**
 *
 * @author oxy
 */
public class TcpServerTest {

	public static void main(String[] args) {
		TcpServer server = new TcpServer();

		server.expect(":hi", new Action() {
					  public void run(Map<String, Object> args) {
						  System.out.println(args.get("message"));

						  server.
							  send(":hi", (String) args.get("from"), "Hi back m8");
					  }
				  });

		server.expect(":olaaa", new Action() {
					  public void run(Map<String, Object> args) {
						  System.out.println(args.get("message"));

						  server.
							  send(":olaaa", (String) args.get("from"), "recebi");
					  }
				  });

		server.stream(8000);
	}
}
