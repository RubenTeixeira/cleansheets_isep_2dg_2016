/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.chatApp.ui;

import csheets.support.Task;
import csheets.support.TaskManager;
import csheets.ui.DefaulListModel;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author scarl
 */
public class ChatUI extends javax.swing.JFrame implements SelectionListener, Observer {

	/**
	 * UI controller
	 */
	private UIController uiController;
	/**
	 * Chat app controller
	 */
	private ChatAppController chatAppController;
	/**
	 * Default instance list
	 */
	private DefaultListModel instanceListModel;

	/**
	 * Default receive list
	 */
	private DefaultListModel receiveListModel;

	/**
	 * Received elements.
	 */
	private List<Map<String, String>> receivedElements;
	/**
	 * Message to send
	 */
	private String message;
	/**
	 * Hostname
	 */
	private String host;
	/**
	 * Task Manager
	 */
	private final TaskManager manager = new TaskManager();

	/**
	 *
	 * @param uiController User interface controller
	 * @param chatAppController chat app controller
	 */
	public ChatUI(UIController uiController, ChatAppController chatAppController) {
		this.uiController = uiController;
		this.setTitle("Chat");
		// Create default lists
		instanceListModel = new DefaultListModel();
		receiveListModel = new DefaulListModel();
		receivedElements = new ArrayList<>();
		//TODO

		initComponents();
		txtMessage.setText("Type here...");
		uiController.addSelectionListener(this);

		usersList.setModel(instanceListModel);
		messagesList.setModel(receiveListModel);

		// @IMPROVEMENT: Needs to get the timer from the configuration.
		// Maybe get it through a configuration file?
		final int defaultSeconds = 3;
		final int defaultPort = 20004;

		this.chatAppController = chatAppController;
		this.chatAppController.
			startUdpService(this, defaultPort, defaultSeconds);
		this.chatAppController.startTcpService(this, defaultPort);
		this.setVisible(true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        usersList = new javax.swing.JList<>();
        btnSend = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        messagesList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtMessage.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMessageFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMessageFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtMessage);

        usersList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                usersListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(usersList);

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(messagesList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
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

    private void usersListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_usersListValueChanged
		if (evt.getValueIsAdjusting() == false) {
			if (usersList.getSelectedIndex() == -1) {
				//No selection.
				btnSend.setEnabled(false);
			} else {
				btnSend.setEnabled(true);
				host = usersList.getSelectedValue();
			}
		}
    }//GEN-LAST:event_usersListValueChanged

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
		//Selection.
		message = txtMessage.getText();

		if (message.length() <= 0) {
			return;
		}
		try {
			receiveListModel.
				addElement(InetAddress.getLocalHost().getHostName() + ":" + message);
		} catch (UnknownHostException ex) {
			Logger.getLogger(ChatUI.class.getName()).log(Level.SEVERE, null, ex);
		}
		chatAppController.sendMessage(host, message);
		txtMessage.setText("");
    }//GEN-LAST:event_btnSendActionPerformed

    private void txtMessageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMessageFocusLost
		if (txtMessage.getText().isEmpty()) {
			txtMessage.setText("Type here...");
		}
    }//GEN-LAST:event_txtMessageFocusLost

    private void txtMessageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMessageFocusGained
		txtMessage.setText("");
    }//GEN-LAST:event_txtMessageFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> messagesList;
    private javax.swing.JTextPane txtMessage;
    private javax.swing.JList<String> usersList;
    // End of variables declaration//GEN-END:variables

	public void updateInstanceList(List<String> addresses) {
		for (String address : addresses) {
			if (!instanceListModel.contains(address)) {
				instanceListModel.addElement(address);

				manager.after(20).once(new Task() {
					public void fire() {
						instanceListModel.removeElement(address);
						usersList.setModel(instanceListModel);
					}
				});
			}
		}
		usersList.setModel(instanceListModel);
		repaint();
	}

	public void updateReceiveList(Map<String, String> mapMessages) {
		int size = mapMessages.size() - 1;
		String message = "";
		message = mapMessages.get("hostname") + ": " + mapMessages.
			get("message");
		new TimedPopupMessageDialog(null, "Message", chatAppController, message);
		usersList.setSelectedValue(mapMessages.get("from"), true);

		receiveListModel.addElement(message);
		messagesList.setModel(receiveListModel);
		repaint();
	}

	@Override
	public void selectionChanged(SelectionEvent event) {
		//
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Map) {
			Map<String, String> mapMessages = (Map<String, String>) arg;
			updateReceiveList(mapMessages);
		}
		if (arg instanceof List) {
			List<String> addresses = (List<String>) arg;
			updateInstanceList(addresses);
		}
	}
}
