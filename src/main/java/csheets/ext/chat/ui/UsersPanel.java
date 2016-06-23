/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.chat.ui;

import csheets.ext.chat.ChatController;
import csheets.ext.chat.domain.User;
import csheets.notification.Notification;
import java.awt.GridLayout;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JScrollPane;

/**
 *
 * @author Marcelo Barroso 1131399
 */
public class UsersPanel extends javax.swing.JPanel implements Observer {

	private ChatController controller;
	private JScrollPane jScrollPane;

	/**
	 * Creates new form ChatPanel
	 */
	public UsersPanel(ChatController controller) {
		this.controller = controller;
		this.initComponents();
		this.jScrollPane = new JScrollPane(this.jPanelUsers);
		this.update(null, null);
		Notification.chatMessageInformer().addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Map) {

			Map<String, String> data = (Map) arg;
			/*
			for (Entry entry : data.entrySet()) {
				System.out.
					println("update - key: " + entry.getKey() + " - value: " + entry.
						getValue());
			}
			 */
			if (data.get("reference").equals("user")) {
				this.controller.
					addUser(data.get("name"), data.get("nick"), data.
							get("status"), data.get("image"), data.get("ip") + ":" + data.
							get("port"));
			}

			/*
			if (data.get("reference").equals("chatMessage")) {
				((Map) messageData).remove("reference");
				String message = (String) ((Map) messageData).get("message");
				String fromIP = ((String) ((Map) messageData).get("nickname")).
					split(":")[0];
				String chatMessage = "Received from " + fromIP + ": " + message;
				new TimedPopupMessageDialog(null, chatMessage);
				receivedMessage(fromIP, message);
				this.chatAppController.
					addMessage(message, fromIP, ChatMessage.MessageType.RECEIVED);
			}
			 */
			this.jPanelUsers.removeAll();
			this.jPanelUsers.setLayout(new GridLayout(5, 1));
			//((GridLayout) this.jPanelUsers.getLayout()).setRows(5);
			for (User user : this.controller.users()) {
				//if (!addUser.equals(this.controller.name())) {
				UsersPanelSingle panel = new UsersPanelSingle(this.controller, user);
				this.jPanelUsers.add(panel);
				GridLayout layout = (GridLayout) this.jPanelUsers.
					getLayout();
				layout.setRows(layout.getRows() + 1);
				//}
			}
			this.jPanelUsers.revalidate();
			this.jPanelUsers.repaint();
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelUsers = new javax.swing.JPanel();

        jPanelUsers.setBorder(javax.swing.BorderFactory.createTitledBorder("Users"));

        javax.swing.GroupLayout jPanelUsersLayout = new javax.swing.GroupLayout(jPanelUsers);
        jPanelUsers.setLayout(jPanelUsersLayout);
        jPanelUsersLayout.setHorizontalGroup(
            jPanelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        jPanelUsersLayout.setVerticalGroup(
            jPanelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUsers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelUsers;
    // End of variables declaration//GEN-END:variables
}
