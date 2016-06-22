/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.chat;

import csheets.ext.chat.domain.Room;
import csheets.ext.chat.domain.User;
import csheets.notification.Notification;
import csheets.persistence.PersistenceContext;
import csheets.ui.ctrl.UIController;
import java.awt.Color;

/**
 *
 * @author Marcelo Barroso 1131399
 */
public class ChatController {

	private UIController uiController;
	private UdpService udpService;
	//private TcpService tcpService;
	private User user;

	public ChatController(UIController uiController) {
		for (User user : PersistenceContext.repositories().users().all()) {
			System.out.println("MORE -> " + user);
		}
		String name = System.getProperty("user.name");
		this.user = PersistenceContext.repositories().users().findName(name);
		if (this.user == null) {
			this.user = new User(name, "myNick", null, User.State.ONLINE);
			this.user = PersistenceContext.repositories().users().
				save(this.user);
		}
		this.uiController = uiController;
		this.udpService = new UdpService();
		this.udpService.user(this.user);
		this.udpService.client(5);
		this.udpService.server();
	}

	public Color stateColor(User.State state) {
		if (state == User.State.ONLINE) {
			return new Color(9, 80, 208, 255);
		} else if (state == User.State.AWAY) {
			return new Color(255, 255, 0, 255);
		} else {
			return new Color(255, 102, 102, 255);
		}
	}

	public String name() {
		return this.user.name();
	}

	public void nickname(String nickname) {
		if (nickname != null && !nickname.isEmpty() && !this.user.nickname().
			equals(nickname)) {
			this.user.nickname(nickname);
			this.saveUser();
		}
	}

	public String nickname() {
		return this.user.nickname();
	}

	public void state(User.State state) {
		if (state != null && !this.user.state().equals(state)) {
			this.user.state(state);
			this.saveUser();
		}
	}

	public User.State state() {
		return this.user.state();
	}

	public void image(byte[] image) {
		if (!this.user.image().equals(image)) {
			this.user.image(image);
			this.saveUser();
		}
	}

	public byte[] image() {
		return this.user.image();
	}

	public void saveUser() {
		this.user = PersistenceContext.repositories().users().save(this.user);
		this.udpService.user(this.user);
		Notification.chatMessageInformer().notifyChange(this.user);
		for (User user : PersistenceContext.repositories().users().all()) {
			System.out.println("MORE -> " + user + " status = " + user.state());
		}
	}

	public User addUser(String name, String nick, String status, String image) {
		if (name.equals(this.user.name())) {
			return this.user;
		}
		User user = PersistenceContext.repositories().users().findName(name);
		byte[] img = null;
		if (image != null && !image.isEmpty()) {
			img = image.getBytes();
		}
		User.State stts = User.State.ONLINE;
		if (status != null && !status.isEmpty()) {
			if (status.equals(User.State.AWAY)) {
				stts = User.State.AWAY;
			} else if (status.equals(User.State.OFFLINE)) {
				stts = User.State.OFFLINE;
			}
		}
		if (user == null) {
			user = new User(name, nick, img, stts);
		}
		user.nickname(nick);
		user.state(stts);
		user.image(img);
		user = PersistenceContext.repositories().users().save(user);
		Notification.chatMessageInformer().notifyChange(user);
		return user;
	}

	public Iterable<User> users() {
		return PersistenceContext.repositories().users().all();
	}

	public Iterable<Room> rooms() {
		return PersistenceContext.repositories().rooms().all();
	}

	public Room addRoom(String name, String creator, boolean isPrivate) {
		Room room = PersistenceContext.repositories().rooms().findName(name);
		if (room != null) {
			return room;
		}
		Room.Type type = Room.Type.PUBLIC;
		if (isPrivate) {
			type = Room.Type.PRIVATE;
		}
		User user = null;
		if (creator == null) {
			user = this.user;
		} else {
			user = PersistenceContext.repositories().users().findName(creator);
		}
		if (user == null) {
			return null;
		}
		room = new Room(name, this.user, type);
		PersistenceContext.repositories().rooms().save(room);
		Notification.chatMessageInformer().notifyChange(room);
		return room;
	}

	public void sendMessage(Room room, String message) {

	}

	public void sendMessage(User user, String message) {

	}

}
