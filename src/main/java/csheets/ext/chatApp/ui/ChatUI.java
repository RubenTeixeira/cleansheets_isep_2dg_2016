/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.chatApp.ui;

import com.sun.glass.events.KeyEvent;
import csheets.domain.ChatUser;
import csheets.ext.chatApp.application.ChatAppController;
import csheets.notification.Notification;
import csheets.ui.DefaulListModel;
import java.awt.Component;
import java.awt.GridLayout;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import org.eclipse.persistence.internal.oxm.conversion.Base64;

/**
 *
 * @author scarl
 */
public class ChatUI extends javax.swing.JFrame implements Observer {

	private static ChatUI atualInstance = null;

	private static final int defaultSeconds = 5;

	private ChatUserCard seletectUser;

	/**
	 * Chat app controller
	 */
	private ChatAppController chatAppController;

	/**
	 * Default receive list
	 */
	private DefaultListModel receiveListModel;

	/**
	 * Received elements.
	 */
	private Map<String, ChatUser> hosts;

	/**
	 * Message to send
	 */
	private String message;

	/**
	 * Hostname
	 */
	private String host;

	/**
	 * Ip of destination
	 */
	private String ipDestino;

	/**
	 *
	 * @param uiController User interface controller
	 * @param chatAppController chat app controller
	 */
	private ChatUI(ChatAppController chatAppController) {

		this.seletectUser = null;

		// Check if the current user has already a chat profile persisted
		// If not, a window is prompted asking for the profile creation.
		if (!chatAppController.isCurrentUserDefined()) {
			new CreateChatUserProfileUI(this, chatAppController);
		}

		// Get the current chat user
		ChatUser theUser = chatAppController.systemChatUser();

		// If not created, the window is closed. If yes, continues.
		if (theUser != null) {
			chatAppController.startUdpService(defaultSeconds, theUser);
			this.chatAppController = chatAppController;
			Notification.chatMessageInformer().addObserver(this);

			this.chatAppController.startTcpService();

			this.setTitle("Chat");

			receiveListModel = new DefaulListModel();
			hosts = new LinkedHashMap<>();

			initComponents();
			this.setLocationRelativeTo(null);
			messagesList.setModel(receiveListModel);

			addWindowListener(new java.awt.event.WindowAdapter() {
				@Override
				public void windowClosing(java.awt.event.WindowEvent windowEvent) {
					atualInstance = null;
					chatAppController.stop();
					dispose();
				}

			});
			this.setVisible(true);
		} else {
			dispose();
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

        jPanel1 = new javax.swing.JPanel();
        btnSend = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        messagesList = new javax.swing.JList<>();
        txtMessage = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(messagesList);

        txtMessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMessageKeyPressed(evt);
            }
        });

        usersPanel.setLayout(new java.awt.GridLayout(5, 1));
        jScrollPane1.setViewportView(usersPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSend)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
		sendMessage();
    }//GEN-LAST:event_btnSendActionPerformed

	private void sendMessage() {
		message = txtMessage.getText();
		if (message.length() <= 0) {
			return;
		}
		if (this.seletectUser != null) {
			host = seletectUser.nickname();

			for (String hostIP : hosts.keySet()) {
				if (hosts.get(hostIP).nickname().equals(host)) {
					ipDestino = hostIP;
					break;
				}
			}

			try {
				receiveListModel.
					addElement(InetAddress.getLocalHost().getHostName() + ": " + message);
			} catch (UnknownHostException ex) {
				Logger.getLogger(ChatUI.class.getName()).
					log(Level.SEVERE, null, ex);
			}
			chatAppController.sendMessage(host, ipDestino, message);
			txtMessage.setText("");
		}
	}

    private void txtMessageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMessageKeyPressed
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			sendMessage();
		}
    }//GEN-LAST:event_txtMessageKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> messagesList;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JPanel usersPanel;
    // End of variables declaration//GEN-END:variables

	private void updateInstanceState(Map<String, String> state) {
		if (hosts.containsKey(state.get("requester"))) {
			for (Component card : usersPanel.getComponents()) {
				ChatUserCard tmpCard = ((ChatUserCard) card);
				if (tmpCard.nickname().equals(hosts.get(state.get("requester")).
					nickname())) {
					tmpCard.changeState(false);
				}
			}
		}
	}

	public void updateInstanceList(Map<String, String> hostMap) {

		String fromIP = hostMap.get("ip") + ":" + hostMap.get("port");

		if (hosts.containsKey(fromIP)) {
			for (Component card : usersPanel.getComponents()) {
				ChatUserCard tmpCard = ((ChatUserCard) card);
				if (tmpCard.nickname().equals(hostMap.get("nickname"))) {
					tmpCard.changeState(true);
				}
			}

		} else {
			ChatUser tmp;
			tmp = new ChatUser(hostMap.get("nickname"), Base64.
							   base64Decode(hostMap.
								   get("icon").getBytes()));

			hosts.put(fromIP, tmp);
			usersPanel.add(new ChatUserCard(tmp, this));
			GridLayout layout = (GridLayout) this.usersPanel.
				getLayout();
			layout.setRows(layout.getRows() + 1);

		}

		usersPanel.revalidate();
		usersPanel.repaint();

	}

	public void updateReceiveList(Map<String, String> mapMessages) {

		//Adicionar mensagem à história de um user.
		int size = mapMessages.size() - 1;
		String message = "";
		message = mapMessages.get("hostname") + ": " + mapMessages.
			get("message");

		receiveListModel.addElement(message);
		messagesList.setModel(receiveListModel);
		repaint();
	}

	@Override
	public void update(Observable o, Object arg) {
		Map<String, String> hostdata = new LinkedHashMap((Map) arg);
		if ((hostdata).get("reference").equals("hosts")) {
			(hostdata).remove("reference");
			updateInstanceList(hostdata);
		}
		Map<String, String> message = new LinkedHashMap((Map) arg);
		if ((message).get("reference").equals("chatMessage")) {
			(message).remove("reference");
			updateReceiveList(message);
		}
		Map<String, String> state = new LinkedHashMap((Map) arg);
		if ((state).get("reference").equals("state")) {
			(state).remove("reference");
			updateInstanceState(state);
		}

	}

	public static ChatUI instance(ChatAppController chatAppController) {

		if (ChatUI.atualInstance == null) {
			ChatUI.atualInstance = new ChatUI(chatAppController);
		} else {
			ChatUI.atualInstance.toFront();
		}
		return ChatUI.atualInstance;
	}

	public void updateSelectedPanel(ChatUserCard aThis) {
		this.seletectUser = aThis;
		for (Component panel : this.usersPanel.getComponents()) {
			if (!((ChatUserCard) panel).equals(this.seletectUser)) {
				((ChatUserCard) panel).setBorder(new JPanel().getBorder());
			}
		}
		this.usersPanel.revalidate();
		this.usersPanel.repaint();
	}
}
