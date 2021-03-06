package csheets.ext.address.ui;

import csheets.domain.Address;
import csheets.domain.Contact;
import csheets.ext.address.AddressController;
import csheets.ext.events.EventsExtension;
import csheets.notification.Notification;
import csheets.ui.ctrl.UIController;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author Martins
 */
public class AddressPanel extends javax.swing.JPanel implements Observer {

	private AddressController controller;
	private List<Contact> listContacts = new ArrayList();
	private int addresses = 0;

	/**
	 * Creates new form EventsPanel
	 *
	 * @param uiController The user interface controller.
	 */
	public AddressPanel(UIController uiController) {
		this.setName(EventsExtension.NAME);
		this.initComponents();
		this.controller = new AddressController(uiController, this);
		initContacts();
		Notification.addressInformer().addObserver(this);
		Notification.contactInformer().addObserver(this);
		this.update(null, null);
	}

	private void initContacts() {
		this.jComboBoxContact.removeAllItems();
		this.listContacts.clear();
		for (Contact contact : this.controller.allContacts()) {
			this.listContacts.add(contact);
			this.jComboBoxContact.addItem(contact.toString());
		}
		revalidate();
		repaint();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg == null) {
			this.addresses = 0;
			clearAddressList();
			if (this.jComboBoxContact.getSelectedIndex() != -1) {
				for (Address address : this.controller.
					allAddress(this.listContacts.get(this.jComboBoxContact.
						getSelectedIndex()))) {
					AddressPanelSingle panel = new AddressPanelSingle(this.controller, this.listContacts.
																	  get(this.jComboBoxContact.
																		  getSelectedIndex()), address);
					addAddressPanel(panel);
					this.addresses++;
				}
				if (this.addresses == 2) {
					this.jButtonAdd.setEnabled(false);
				} else {
					this.jButtonAdd.setEnabled(true);
				}
			}
		} else if (arg instanceof Address) {
			this.addresses++;
			if (this.addresses == 2) {
				this.jButtonAdd.setEnabled(false);
			} else {
				this.jButtonAdd.setEnabled(true);
			}
			clearAddressList();
			for (Address address : this.controller.
				allAddress(this.listContacts.get(this.jComboBoxContact.
					getSelectedIndex()))) {
				AddressPanelSingle panel = new AddressPanelSingle(this.controller, this.listContacts.
																  get(this.jComboBoxContact.
																	  getSelectedIndex()), address);
				addAddressPanel(panel);
			}
		} else if (arg instanceof Contact) {
			initContacts();
		}
		this.jPanelAddresses.revalidate();
		this.jPanelAddresses.repaint();
	}

	private void addAddressPanel(AddressPanelSingle panel) {
		this.jPanelAddresses.add(panel);
		addGridRow();
	}

	/*
    * Deletes all information from event list.
	 */
	private void clearAddressList() {
		this.jPanelAddresses.removeAll();
		defaultGridRow();
	}

	/*
    * Layout specific: set's the default number of rows (5)
	 */
	private void defaultGridRow() {
		((GridLayout) this.jPanelAddresses.getLayout()).setRows(5);
	}

	/*
    * Layout specific: add's a row to the panel's layout (to prevent adding a new colummn).
	 */
	private void addGridRow() {
		GridLayout layout = (GridLayout) this.jPanelAddresses.getLayout();
		layout.setRows(layout.getRows() + 1);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxContact = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelAddresses = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonImport = new javax.swing.JButton();

        jLabel1.setText("Contact:");

        jComboBoxContact.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxContactItemStateChanged(evt);
            }
        });
        jComboBoxContact.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jComboBoxContactHierarchyChanged(evt);
            }
        });
        jComboBoxContact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBoxContactMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBoxContactMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxContactMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBoxContactMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxContactMouseEntered(evt);
            }
        });
        jComboBoxContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBoxContactKeyReleased(evt);
            }
        });

        jPanelAddresses.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane1.setViewportView(jPanelAddresses);

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonImport.setText("Import");
        jButtonImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxContact, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonImport))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonImport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
		try {
			AddressPanelManager manager = new AddressPanelManager(this.controller, this.listContacts.
																  get(this.jComboBoxContact.
																	  getSelectedIndex()), null);
			int eventOption = JOptionPane.
				showConfirmDialog(null, manager, "Create/Edit Address", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (eventOption == JOptionPane.OK_OPTION) {
				try {
					manager.createAddress();
				} catch (IOException ex) {
					JOptionPane.
						showMessageDialog(null, "Cannot import the file", "Create/Edit Address", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (IllegalArgumentException ex) {
			JOptionPane.
				showMessageDialog(null, ex.getMessage(), "Create/Edit Address", JOptionPane.ERROR_MESSAGE);
		}
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jComboBoxContactItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxContactItemStateChanged
		this.update(null, null);
    }//GEN-LAST:event_jComboBoxContactItemStateChanged

    private void jComboBoxContactMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxContactMouseReleased

    }//GEN-LAST:event_jComboBoxContactMouseReleased

    private void jComboBoxContactMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxContactMousePressed

    }//GEN-LAST:event_jComboBoxContactMousePressed

    private void jComboBoxContactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxContactMouseClicked

    }//GEN-LAST:event_jComboBoxContactMouseClicked

    private void jComboBoxContactMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxContactMouseEntered

    }//GEN-LAST:event_jComboBoxContactMouseEntered

    private void jComboBoxContactMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxContactMouseExited

    }//GEN-LAST:event_jComboBoxContactMouseExited

    private void jComboBoxContactHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jComboBoxContactHierarchyChanged

    }//GEN-LAST:event_jComboBoxContactHierarchyChanged

    private void jComboBoxContactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxContactKeyReleased

    }//GEN-LAST:event_jComboBoxContactKeyReleased

    private void jButtonImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportActionPerformed
		try {
			this.controller.importPostalCodes();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(this, "Erro na leitura de ficheiro");
		}
    }//GEN-LAST:event_jButtonImportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonImport;
    private javax.swing.JComboBox<String> jComboBoxContact;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelAddresses;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
