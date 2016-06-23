/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.chat;

import csheets.AppSettings;
import csheets.ext.NetworkManager;
import csheets.ext.chat.domain.Room;
import csheets.ext.chat.domain.User;
import csheets.notification.Notification;
import csheets.support.Task;
import csheets.support.TaskManager;
import csheets.support.ThreadManager;
import java.util.LinkedHashMap;
import java.util.Map;
import vendor.volt.Action;
import vendor.volt.Request;
import vendor.volt.protocols.udp.UdpClient;
import vendor.volt.protocols.udp.UdpServer;

/**
 *
 * @author Marcelo Barroso 1131399
 */
public class UdpService {

	/**
	 * Server instance.
	 */
	private UdpServer server;
	private UdpClient client;
	private User user;
	private Map<String, User> users;
	private Map<String, Room> rooms;

	public void user(User user) {
		this.user = user;
	}

	void users(Map<String, User> users) {
		this.users = users;
	}

	void rooms(Map<String, Room> rooms) {
		this.rooms = rooms;
	}

	/**
	 * Initializes a server following the UDP protocol.
	 *
	 * @param chatUserNickname Username
	 * @param chatUserIcon User icon
	 */
	public void server() {
		ThreadManager.create("ipc.chat2-udpServer", new Thread() {
							 @Override
							 public void run() {
								 server = NetworkManager.udp();

								 server.expect(":chat2broadcast", new Action() {
											   @Override
											   public void run(Request request) {
												   /*
												   if (request.same()) {
													   return;
												   }
												    */
												   // Destination = Target's IP and Port
												   String destination = server.
													   target(request.from());

												   String message = AppSettings.
													   instance().
													   get("TCP_PORT") + "|" + user.
													   name() + "|" + user.
													   nickname() + "|" + user.
													   state() + "|" + user.
													   image();
												   server.
													   send(":chat-port|:chat-name|:chat-nick|:chat-status|:chat-image", destination, message);

												   for (Room room : rooms.
													   values()) {
													   if (room.creator().
														   equals(user) && room.
														   type() == Room.Type.PUBLIC) {
														   message = "publicRoom|" + room.
															   name() + "|" + room.
															   creator().name();
														   System.out.
															   println("MENSAGEM = " + message);
														   server.
															   send(":chat-publicRoom|:chat-name|:chat-creator", destination, message);
													   }
												   }

											   }
										   });

								 server.
									 expect(":chat-publicRoom|:chat-name|:chat-creator", new Action() {
											@Override
											public void run(Request request) {
												/*
												if (request.same()) {
													return;
												}
												 */
												Map<String, String> hostInformations = new LinkedHashMap<>();
												hostInformations.
													put("reference", request.
														get("chat-publicRoom").
														get(0));
												hostInformations.
													put("ip", request.from());
												hostInformations.
													put("hostname", request.
														hostname());
												hostInformations.
													put("name", request.
														get("chat-name").get(0));
												hostInformations.
													put("creator", request.
														get("chat-creator").
														get(0));
												Notification.
													chatMessageInformer().
													notifyChange(hostInformations);
											}
										});

								 server.
									 expect(":chat-port|:chat-name|:chat-nick|:chat-status|:chat-image", new Action() {
											@Override
											public void run(Request request) {
												/*
												if (request.same()) {
													return;
												}
												 */
												Map<String, String> hostInformations = new LinkedHashMap<>();
												hostInformations.
													put("reference", "user");
												hostInformations.
													put("ip", request.from());
												hostInformations.
													put("hostname", request.
														hostname());
												hostInformations.
													put("port", request.
														get("chat-port").get(0));
												hostInformations.
													put("name", request.
														get("chat-name").get(0));
												hostInformations.
													put("nick", request.
														get("chat-nick").get(0));
												hostInformations.
													put("status", request.
														get("chat-status").
														get(0));
												hostInformations.
													put("image", request.
														get("chat-image").get(0));
												Notification.
													chatMessageInformer().
													notifyChange(hostInformations);
											}
										});

							 }
						 });

		ThreadManager.run("ipc.chat2-udpServer");

	}

	/**
	 * Initializes a client following the UDP protocol.
	 *
	 * @param seconds Time in seconds to send another request.
	 */
	public void client(int seconds) {
		ThreadManager.create("ipc.chat2-udpClient", new Thread() {
							 @Override
							 public void run() {
								 client = new UdpClient(0);

								 Task broadcast = new Task() {
									 @Override
									 public void fire() {
										 client.
											 send(":chat2broadcast", "all:" + AppSettings.
												  instance().get("UDP_PORT"), "check");
									 }
								 };
								 TaskManager manager = new TaskManager();
								 manager.after(1).every(seconds).
									 fire(broadcast);
							 }
						 });
		ThreadManager.run("ipc.chat2-udpClient");
	}

	/**
	 * Stops all the UDP services.
	 */
	public void stop() {
		//server.neglect(":chat-port|:chat-nickname|:chat-icon");
		server.neglect(":chat2broadcast");
		//server.neglect(":offline");

		ThreadManager.destroy("ipc.chat2-udpClient");
		//ThreadManager.destroy("ipc.chat-offline");
		ThreadManager.destroy("ipc.chat2-udpServer");
	}

}
