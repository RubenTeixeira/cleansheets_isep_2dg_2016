/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.chat.ui;

import csheets.ext.chat.ChatController;
import csheets.ext.chat.domain.User;
import csheets.notification.Notification;
import csheets.support.CirclePanel;
import csheets.support.Converter;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Marcelo Barroso 1131399
 */
public class UsersPanelRemake extends javax.swing.JPanel implements Observer {

	private ChatController controller;
	private JPanel jPanelColor;
	private JScrollPane jScrollPane;

	/**
	 * Creates new form ChatPanel
	 */
	public UsersPanelRemake(UIController uiController) {
		this.controller = new ChatController(uiController);
		this.initComponents();
		this.jComboBoxStatus.addItem(User.State.ONLINE.toString());
		this.jComboBoxStatus.addItem(User.State.AWAY.toString());
		this.jComboBoxStatus.addItem(User.State.OFFLINE.toString());
		//this.jScrollPane = new JScrollPane(this.jTabbedPaneUsers);
		//this.jScrollPane = new JScrollPane(this.jTabbedPaneRooms);
		this.jTabbedPaneUsers.setLayout(new GridLayout(1, 1));
		this.jTabbedPaneUsers.add(new UsersPanel(uiController));
		this.jTabbedPaneRooms.setLayout(new GridLayout(1, 1));
		this.jTabbedPaneRooms.add(new RoomsPanel(uiController));
		this.userUpdate();
		Notification.chatMessageInformer().addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Map) {

			Map<String, String> data = (Map) arg;
			for (Entry entry : data.entrySet()) {
				System.out.
					println("update - key: " + entry.getKey() + " - value: " + entry.
						getValue());
			}
			if (data.get("reference").equals("user")) {
				this.controller.
					addUser(data.get("name"), data.get("nick"), data.
							get("status"), data.get("image"));
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
 /*
			this.jTabbedPaneUsers.removeAll();
			this.jTabbedPaneUsers.setLayout(new GridLayout(5, 1));
			for (User user : this.controller.users()) {
				//if (!addUser.equals(this.controller.name())) {
				UsersPanelSingle panel = new UsersPanelSingle(this.controller, user);
				this.jTabbedPaneUsers.add(panel);
				GridLayout layout = (GridLayout) this.jTabbedPaneUsers.
					getLayout();
				layout.setRows(layout.getRows() + 1);
				//}
			}
			this.jTabbedPaneRoot.revalidate();
			this.jTabbedPaneRoot.repaint();
			 */
		}
	}

	public void userUpdate() {
		this.jPanelProfile.setBorder(javax.swing.BorderFactory.
			createTitledBorder(this.controller.name()));
		this.jTextFieldNick.setText(this.controller.nickname());
		if (this.controller.image() != null) {
			ImageIcon img = new ImageIcon(this.controller.image());
			Image newImg = img.getImage().getScaledInstance(this.jLabelPhoto.
				getWidth(), this.jLabelPhoto.getHeight(), Image.SCALE_SMOOTH);
			this.jLabelPhoto.setIcon(new ImageIcon(newImg));
		}
		this.jComboBoxStatus.
			setSelectedIndex(this.controller.state().ordinal());
		this.selectedStatus();
	}

	public void selectedPhoto() {
		final JFileChooser fileChooser = new JFileChooser();
		int value = fileChooser.showOpenDialog(fileChooser);
		if (value == JFileChooser.APPROVE_OPTION) {
			ImageIcon icon = null;
			try {
				File photoFile = fileChooser.getSelectedFile();
				this.controller.image(Converter.setImage(photoFile));
				BufferedImage img = ImageIO.read(photoFile);
				icon = new ImageIcon(img.getScaledInstance(this.jLabelPhoto.
					getWidth(), this.jLabelPhoto.getHeight(), Image.SCALE_SMOOTH));
			} catch (Exception e) {
			}
			this.jLabelPhoto.setIcon(icon);
		}
	}

	public void selectedStatus() {
		switch (this.jComboBoxStatus.getSelectedIndex()) {
			case 0:
				this.controller.state(User.State.ONLINE);
				this.jPanelColor = CirclePanel.
					createCircle(new Dimension(40, 40), new Color(0, 0, 255, 255));
				break;
			case 1:
				this.controller.state(User.State.AWAY);
				this.jPanelColor = CirclePanel.
					createCircle(new Dimension(40, 40), new Color(0, 255, 0, 255));
				break;
			case 2:
				this.controller.state(User.State.OFFLINE);
				this.jPanelColor = CirclePanel.
					createCircle(new Dimension(40, 40), new Color(255, 0, 0, 255));
				break;
		}
		this.jPanelStatus.removeAll();
		this.jPanelStatus.add(this.jPanelColor);
		this.revalidate();
		this.repaint();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPhoto = new javax.swing.JPanel();
        jLabelPhoto = new javax.swing.JLabel();
        jPanelProfile = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jTextFieldNick = new javax.swing.JTextField();
        jPanelStatus = new javax.swing.JPanel();
        jTabbedPaneRoot = new javax.swing.JTabbedPane();
        jTabbedPaneUsers = new javax.swing.JTabbedPane();
        jTabbedPaneRooms = new javax.swing.JTabbedPane();

        jPanelPhoto.setBorder(javax.swing.BorderFactory.createTitledBorder("Photo"));
        jPanelPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelPhotoMouseClicked(evt);
            }
        });

        jLabelPhoto.setMaximumSize(new java.awt.Dimension(75, 70));
        jLabelPhoto.setMinimumSize(new java.awt.Dimension(75, 70));
        jLabelPhoto.setPreferredSize(new java.awt.Dimension(75, 70));
        jLabelPhoto.setSize(new java.awt.Dimension(75, 70));
        jLabelPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPhotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelPhotoLayout = new javax.swing.GroupLayout(jPanelPhoto);
        jPanelPhoto.setLayout(jPanelPhotoLayout);
        jPanelPhotoLayout.setHorizontalGroup(
            jPanelPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelPhotoLayout.setVerticalGroup(
            jPanelPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelProfile.setBorder(javax.swing.BorderFactory.createTitledBorder("Profile"));

        jLabel1.setText("Nick:");

        jLabel2.setText("Status:");

        jComboBoxStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxStatusItemStateChanged(evt);
            }
        });

        jTextFieldNick.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNickKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelStatusLayout = new javax.swing.GroupLayout(jPanelStatus);
        jPanelStatus.setLayout(jPanelStatusLayout);
        jPanelStatusLayout.setHorizontalGroup(
            jPanelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        jPanelStatusLayout.setVerticalGroup(
            jPanelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelProfileLayout = new javax.swing.GroupLayout(jPanelProfile);
        jPanelProfile.setLayout(jPanelProfileLayout);
        jPanelProfileLayout.setHorizontalGroup(
            jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProfileLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNick))
                    .addGroup(jPanelProfileLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 74, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelProfileLayout.setVerticalGroup(
            jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfileLayout.createSequentialGroup()
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPaneRoot.addTab("Users", jTabbedPaneUsers);
        jTabbedPaneRoot.addTab("Rooms", jTabbedPaneRooms);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPaneRoot)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxStatusItemStateChanged
		this.selectedStatus();
    }//GEN-LAST:event_jComboBoxStatusItemStateChanged

    private void jPanelPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelPhotoMouseClicked
		this.selectedPhoto();
    }//GEN-LAST:event_jPanelPhotoMouseClicked

    private void jLabelPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPhotoMouseClicked
		this.selectedPhoto();
    }//GEN-LAST:event_jLabelPhotoMouseClicked

    private void jTextFieldNickKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNickKeyReleased
		this.controller.nickname(this.jTextFieldNick.getText());
    }//GEN-LAST:event_jTextFieldNickKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelPhoto;
    private javax.swing.JPanel jPanelPhoto;
    private javax.swing.JPanel jPanelProfile;
    private javax.swing.JPanel jPanelStatus;
    private javax.swing.JTabbedPane jTabbedPaneRooms;
    private javax.swing.JTabbedPane jTabbedPaneRoot;
    private javax.swing.JTabbedPane jTabbedPaneUsers;
    private javax.swing.JTextField jTextFieldNick;
    // End of variables declaration//GEN-END:variables
}
