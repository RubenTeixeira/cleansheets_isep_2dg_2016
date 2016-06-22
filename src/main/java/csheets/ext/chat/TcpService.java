/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.chat;

import csheets.ext.NetworkManager;
import csheets.ext.chat.domain.Room;
import csheets.ext.chat.domain.User;
import csheets.notification.Notification;
import csheets.support.ThreadManager;
import java.util.LinkedHashMap;
import java.util.Map;
import vendor.volt.Action;
import vendor.volt.Request;
import vendor.volt.protocols.tcp.TcpClient;
import vendor.volt.protocols.tcp.TcpServer;

/**
 *
 * @author Marcelo Barroso 1131399
 */
public class TcpService {

	/**
	 * Server instance.
	 */
	private TcpServer server;

	/**
	 * Initializes a server following the UDP protocol.
	 *
	 */
	public void server() {
		ThreadManager.create("ipc.chat2-tcpServer", new Thread() {
							 @Override
							 public void run() {
								 server = NetworkManager.tcp();

								 server.expect(":chat-tcp", new Action() {
											   @Override
											   public void run(Request request) {

												   String[] data = request.
													   message().split(";");
												   Map<String, String> mapMessage = new LinkedHashMap<>();
												   if (true) {

												   }
												   mapMessage.
													   put("reference", "chatMessage");
												   mapMessage.
													   put("nickname", request.
														   message().split(";")[0]);
												   mapMessage.
													   put("from", request.
														   from());
												   mapMessage.
													   put("message", request.
														   message().split(";")[1]);

												   Notification.
													   chatMessageInformer().
													   notifyChange(mapMessage);
											   }
										   });
							 }
						 });

		ThreadManager.run("ipc.chat2-tcpServer");
	}

	/**
	 * Initializes a client following the TCP protocol.
	 *
	 * @param target The target IPv4:Port
	 * @param message Message to send to the target.
	 */
	public void client(String target, String message) {
		ThreadManager.create("ipc.chat2-tcpClient", new Thread() {
							 @Override
							 public void run() {
								 new TcpClient(0).
									 send(":chat2", target, message);
							 }
						 });

		ThreadManager.run("ipc.chat2-tcpClient");
	}

	public void sendMessage(Room room, String message) {
		ThreadManager.create("ipc.chatSendMessageRoom", new Thread() {
							 @Override
							 public void run() {
								 String data = "chatSendMessageRoom|" + room.
									 name() + "|" + message;
								 new TcpClient(0).
									 send(":reference|:room|:message", room.
										  creator().target(), data);
							 }
						 });
		ThreadManager.run("ipc.chatSendMessageRoom");
	}

	public void sendMessage(User user, String message) {
		ThreadManager.create("ipc.chatSendMessageUser", new Thread() {
							 @Override
							 public void run() {
								 new TcpClient(0).
									 send(":chatSendMessageUser", user.target(), message);
							 }
						 });
		ThreadManager.run("ipc.chatSendMessageUser");
	}

	/**
	 * Stops all the TCP services.
	 */
	public void stop() {
		server.neglect(":chat2");
		ThreadManager.destroy("ipc.chat2-tcpClient");
		ThreadManager.destroy("ipc.chat2-tcpServer");
	}

}
