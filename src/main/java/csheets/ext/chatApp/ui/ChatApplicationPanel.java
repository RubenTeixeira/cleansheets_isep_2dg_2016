/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.chatApp.ui;

import csheets.ext.chatApp.ChatAppExtension;
import csheets.notification.Notification;
import csheets.ui.ctrl.UIController;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author scarl
 */
public class ChatApplicationPanel extends javax.swing.JPanel implements Observer {

	/**
	 * Chat App Controller
	 */
	private ChatAppController chatAppController;
	/**
	 * User interface controller
	 */
	private UIController uiController;

	DefaultMutableTreeNode root;

	DefaultMutableTreeNode lastChild;

	/**
	 *
	 * @param uiController user interface controller
	 * @param chatAppController chat app controller
	 */
	public ChatApplicationPanel(UIController uiController,
								ChatAppController chatAppController) {

		this.uiController = uiController;
		this.chatAppController = chatAppController;
		setName(ChatAppExtension.NAME);
		initComponents();
		this.root = (DefaultMutableTreeNode) MessagesTree.getModel().getRoot();
		Notification.chatMessageInformer().addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Cheguei");
		if (arg instanceof Map) {
			if (((Map) arg).get("reference").equals("chatMessage")) {
				((Map) arg).remove("reference");
				String message = (String) ((Map) arg).get("message");
				String hostname = (String) ((Map) arg).get("hostname");

				String chatMessage = hostname + ": message";

				new TimedPopupMessageDialog(null, "Message: " + arg, chatAppController, message);

//				while (true) {
//					DefaultMutableTreeNode no = (DefaultMutableTreeNode) root.
//						children().nextElement();
//					if (no != null) {
//						String treeMessage = (String) no.getUserObject();
//						String ip = treeMessage.split(":")[0];
//						if (ip.equals(hostname)) {
//						}
//					} else {
//						break;
//					}
//				}
				root.add(new DefaultMutableTreeNode(chatMessage));

				this.revalidate();
				this.repaint();
			}
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

        chatApplicationPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MessagesTree = new javax.swing.JTree();

        chatApplicationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Messages History"));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Messages");
        MessagesTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        MessagesTree.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MessagesTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MessagesTreeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(MessagesTree);

        javax.swing.GroupLayout chatApplicationPanelLayout = new javax.swing.GroupLayout(chatApplicationPanel);
        chatApplicationPanel.setLayout(chatApplicationPanelLayout);
        chatApplicationPanelLayout.setHorizontalGroup(
            chatApplicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chatApplicationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addContainerGap())
        );
        chatApplicationPanelLayout.setVerticalGroup(
            chatApplicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chatApplicationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatApplicationPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatApplicationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MessagesTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagesTreeMouseClicked
		if (SwingUtilities.isLeftMouseButton(evt)
			&& evt.getClickCount() > 1) {
			ChatUI.instance(uiController, chatAppController);
		}
    }//GEN-LAST:event_MessagesTreeMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree MessagesTree;
    private javax.swing.JPanel chatApplicationPanel;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
