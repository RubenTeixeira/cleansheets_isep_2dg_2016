/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game.ui;

import csheets.ext.game.GameExtension;
import csheets.notification.Notification;
import csheets.support.Converter;
import csheets.support.Task;
import csheets.support.TaskManager;
import csheets.ui.DefaulListModel;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author João Martins
 */
public class GamePanel extends javax.swing.JPanel implements SelectionListener, Observer {

	/**
	 * Tic-tac-toe designation.
	 */
	private static final String TIC_TAC_TOE = "Tic-Tac-Toe";

	/**
	 * Battleships designation.
	 */
	private static final String BATTLESHIPS = "Battleships";

	private String username;

	/**
	 * Profile photo.
	 */
	private File photoFile;

	private final UIController uiController;

	/**
	 * Instance of the controller.
	 */
	private GameController gameController;

	/**
	 * Default instance list - instances.
	 */
	private DefaultListModel instanceListModel;

	/**
	 * Default instance list - list of games.
	 */
	private DefaultListModel instanceListModelGames;

	/**
	 * Hostname.
	 */
	private String host;

	/**
	 * Task Manager.
	 */
	private final TaskManager manager = new TaskManager();

	/**
	 * Creates new form GamePanel.
	 */
	public GamePanel(UIController uiController, GameController gameController) throws UnknownHostException {
		this.uiController = uiController;

		setName(GameExtension.NAME);

		// Create default lists
		instanceListModel = new DefaultListModel();
		instanceListModelGames = new DefaulListModel();
		Notification.gameInformer().addObserver(this);
		initComponents();

		uiController.addSelectionListener(this);

		//instancesList.setModel(instanceListModel);
		updateListOfGames();

		username = System.getProperty("user.name");

		jTextField1.setText(username);
		jTextField1.setEditable(false);

		jTextField2.setText(InetAddress.getLocalHost().getHostName());
		jTextField2.setEditable(false);

		// @IMPROVEMENT: Needs to get the timer from the configuration.
		// Maybe get it through a configuration file?
		final int defaultSeconds = 3;
		final int defaultPort = 20000;

		this.gameController = gameController;

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        sendButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        instancesList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        contactsPanel = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select the opponent and the game", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        jPanel2.setToolTipText("");

        sendButton.setText("Start Game");
        sendButton.setFocusPainted(false);
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        instancesList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                instancesList1ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(instancesList1);

        jLabel1.setText("Opponents");

        jLabel2.setText("Games");

        jLabel3.setText("Username:");

        jLabel4.setText("HostName:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        contactsPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contactsPanel.setLayout(new java.awt.GridLayout(5, 1));
        jScrollPane3.setViewportView(contactsPanel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2))
                .addGap(9, 9, 9))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(sendButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sendButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleDescription("Select the opponent and the game");
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed

		/**
		 * if (instancesList1.getSelectedValue() != null && contactsPanel.get) {
		 *
		 * }
		 */
    }//GEN-LAST:event_sendButtonActionPerformed

    private void instancesList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_instancesList1ValueChanged
		// TODO add your handling code here:
    }//GEN-LAST:event_instancesList1ValueChanged

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
		final JFileChooser fc = new JFileChooser();

		int returnVal = fc.showOpenDialog(fc);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			photoFile = fc.getSelectedFile();
			this.jLabel5.setIcon(iconImageFromFile(photoFile));

			try {
				this.gameController.startServices(this, username, Converter.
												  setImage(photoFile));
			} catch (IOException ex) {
				Logger.getLogger(GamePanel.class.getName()).
					log(Level.SEVERE, null, ex);
			}
		}
    }//GEN-LAST:event_jLabel5MouseClicked

	/**
	 * Update the list of "online" instances.
	 *
	 * @param addresses
	 */
	public void updateInstanceList(List<String> addresses) {
		for (String address : addresses) {
			if (!instanceListModel.contains(address)) {
				instanceListModel.addElement(address);

				manager.after(20).once(new Task() {
					public void fire() {
						instanceListModel.removeElement(address);
//						instancesList.setModel(instanceListModel);
					}
				});
			}
		}

		//instancesList.setModel(instanceListModel);
		repaint();
	}

	/**
	 * Fill the list with the available games.
	 */
	private void updateListOfGames() {
		instanceListModelGames.add(0, TIC_TAC_TOE);
		instanceListModelGames.add(1, BATTLESHIPS);
		instancesList1.setModel(instanceListModelGames);
	}

	private ImageIcon iconImageFromFile(File photoFile) {
		try {
			BufferedImage img = ImageIO.read(photoFile);
			return scaledImageIcon(img);
		} catch (IOException ex) {
			JOptionPane.
				showMessageDialog(this, "Error opening file!", "User Photo", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	private ImageIcon scaledImageIcon(Image theImage) {
		return new ImageIcon(theImage.getScaledInstance(100, 100,
														Image.SCALE_SMOOTH));
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contactsPanel;
    private javax.swing.JList<String> instancesList1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables

	@Override
	public void selectionChanged(SelectionEvent event) {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void update(java.util.Observable o, Object arg) {
		if (arg instanceof Map) {
			String image = (String) ((Map) arg).get("image");
			byte[] convertBytes = image.getBytes();
			try {
				BufferedImage img = ImageIO.
					read(new ByteArrayInputStream(convertBytes));
				ProfileOpponent p = new ProfileOpponent((String) ((Map) arg).
					get("username"), img);
				this.contactsPanel.add(p);
			} catch (IOException ex) {
				Logger.getLogger(GamePanel.class.getName()).
					log(Level.SEVERE, null, ex);
			}
			//instanceListModel.addElement(((Map) arg).get("from"));
			//ir buscar imagem e username
			//new ProfileOpponent();
		}
	}
}
