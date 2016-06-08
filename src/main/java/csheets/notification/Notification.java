/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.notification;

/**
 *
 * @author Marcelo Barroso 1131399
 */
public class Notification {

	private static Notifier contactInformer = new Notifier() {
	};
	private static Notifier eventInformer = new Notifier() {
	};
	private static Notifier reminderInformer = new Notifier() {
	};
	private static Notifier extensionInformer = new Notifier() {
	};
	private static Notifier chatMessageInformer = new Notifier() {
	};
	private static Notifier panelMessageInformer = new Notifier() {
	};
	private static Notifier calendarInformer = new Notifier() {
	};
	private static Notifier noteInformer = new Notifier() {
	};

	public static Notifier contactInformer() {
		return Notification.contactInformer;
	}

	public static Notifier eventInformer() {
		return Notification.eventInformer;
	}

	public static Notifier reminderInformer() {
		return Notification.reminderInformer;
	}

	public static Notifier extensionInformer() {
		return Notification.extensionInformer;
	}

	public static Notifier chatMessageInformer() {
		return Notification.chatMessageInformer;
	}

	public static Notifier panelMessageInformer() {
		return Notification.panelMessageInformer;
	}

	public static Notifier calendarInformer() {
		return Notification.calendarInformer;
	}

	public static Notifier noteInformer() {
		return Notification.noteInformer;
	}

}
