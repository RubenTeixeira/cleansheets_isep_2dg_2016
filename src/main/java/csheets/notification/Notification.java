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
	private static Notifier extensionInformer = new Notifier() {
	};
	private static Notifier messageInformer = new Notifier() {
	};

	public static Notifier contactInformer() {
		return Notification.contactInformer;
	}

	public static Notifier eventInformer() {
		return Notification.eventInformer;
	}

	public static Notifier extensionInformer() {
		return Notification.extensionInformer;
	}

	public static Notifier messageInformer() {
		return Notification.messageInformer;
	}

}
