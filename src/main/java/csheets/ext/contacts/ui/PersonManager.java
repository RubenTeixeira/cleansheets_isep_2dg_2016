package csheets.ext.contacts.ui;

import csheets.domain.CompanyContact;
import csheets.domain.Contact;
import csheets.domain.PersonContact;
import csheets.ext.contacts.ContactsController;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import csheets.support.Converter;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Rui Freitas
 */
public class PersonManager extends javax.swing.JDialog implements Observer {

	private File photoFile;
	private ContactsController controller;
	private Contact contact;

	/**
	 * Creates new form AddContactDialog
	 *
	 * @param parent Parent frame.
	 * @param controller controller
	 * @param contact The contact to edit.
	 */
	public PersonManager(JFrame parent, ContactsController controller,
						 Contact contact) {
		super();
		this.controller = controller;
		this.contact = contact;
		initComponents();
		fillData();
		this.getRootPane().setDefaultButton(jButtonOk);
		pack();
		setLocationRelativeTo(parent);
		setModal(true);
		this.update(null, null);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.jComboBoxProfession.removeAllItems();
		for (String profession : this.controller.allProfissions()) {
			this.jComboBoxProfession.addItem(profession);
		}
		this.jComboBoxCompany.removeAllItems();
		for (Contact company : this.controller.allCompanies()) {
			this.jComboBoxCompany.addItem(company.name());
		}
		this.reloadOptions();
	}

	public void reloadOptions() {
		if (this.jCheckBoxPerson.isSelected() == true) {
			this.jLabelFistName.setText("First Name:");
			this.jLabelLastName.setVisible(true);
			this.jTextFieldLastName.setVisible(true);
			this.jLabelProfession.setVisible(true);
			this.jComboBoxProfession.setVisible(true);
			this.jLabelCompany.setVisible(true);
			this.jComboBoxCompany.setVisible(true);
		} else {
			this.jLabelFistName.setText("Name:");
			this.jLabelLastName.setVisible(false);
			this.jTextFieldLastName.setVisible(false);
			this.jLabelProfession.setVisible(false);
			this.jComboBoxProfession.setVisible(false);
			this.jLabelCompany.setVisible(false);
			this.jComboBoxCompany.setVisible(false);
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

        jLabelFistName = new javax.swing.JLabel();
        jLabelLastName = new javax.swing.JLabel();
        jTextFieldFirstName = new javax.swing.JTextField();
        jTextFieldLastName = new javax.swing.JTextField();
        jButtonOk = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabelPhoto = new javax.swing.JLabel();
        jLabelProfession = new javax.swing.JLabel();
        jComboBoxProfession = new javax.swing.JComboBox<>();
        jLabelCompany = new javax.swing.JLabel();
        jComboBoxCompany = new javax.swing.JComboBox<>();
        jCheckBoxPerson = new javax.swing.JCheckBox();
        jCheckBoxCompany = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabelFistName.setText("First Name:");

        jLabelLastName.setText("Last Name:");

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEditBtnAction(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.setToolTipText("");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnAction(evt);
            }
        });

        jLabelPhoto.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("winclassic_tab_sel_gradient"), 1, true));
        jLabelPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                photoAction(evt);
            }
        });

        jLabelProfession.setText("Profession:");

        jLabelCompany.setText("Company:");

        jCheckBoxPerson.setSelected(true);
        jCheckBoxPerson.setText("Person");
        jCheckBoxPerson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxPersonMouseClicked(evt);
            }
        });
        jCheckBoxPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPersonActionPerformed(evt);
            }
        });

        jCheckBoxCompany.setText("Company");
        jCheckBoxCompany.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxCompanyMouseClicked(evt);
            }
        });
        jCheckBoxCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCompanyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelFistName, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                            .addComponent(jLabelProfession)
                            .addComponent(jLabelCompany)))
                    .addComponent(jButtonOk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldFirstName)
                            .addComponent(jTextFieldLastName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBoxProfession, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxCompany, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(108, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBoxPerson)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCompany)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxPerson)
                    .addComponent(jCheckBoxCompany))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFistName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelProfession)
                            .addComponent(jComboBoxProfession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCompany)
                            .addComponent(jComboBoxCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOk)
                    .addComponent(jButtonCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void fillData() {
		if (this.contact != null) {
			jTextFieldFirstName.setText(contact.name());
			jTextFieldLastName.setText("algo");
			jLabelPhoto.
				setIcon(scaledImageIcon(new ImageIcon(contact.photo()).
					getImage()));
		}
	}

    private void addEditBtnAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEditBtnAction

		if (this.contact == null) {
			new AddContactWorker().execute();
		} else {
			new EditContactWorker().execute();
		}
    }//GEN-LAST:event_addEditBtnAction

    private void photoAction(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_photoAction

		final JFileChooser fc = new JFileChooser();

		int returnVal = fc.showOpenDialog(fc);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			photoFile = fc.getSelectedFile();
			this.jLabelPhoto.setIcon(iconImageFromFile(photoFile));
		}
    }//GEN-LAST:event_photoAction

	private ImageIcon iconImageFromFile(File photoFile) {
		try {
			BufferedImage img = ImageIO.read(photoFile);
			return scaledImageIcon(img);
		} catch (IOException ex) {
			JOptionPane.
				showMessageDialog(this, "Error opening file!", "Contact photo", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	private ImageIcon scaledImageIcon(Image theImage) {
		return new ImageIcon(theImage.getScaledInstance(100, 100,
														Image.SCALE_SMOOTH));
	}

    private void cancelBtnAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnAction
		this.dispose();
    }//GEN-LAST:event_cancelBtnAction

    private void jCheckBoxPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPersonActionPerformed
		this.jCheckBoxCompany.setSelected(!this.jCheckBoxPerson.isSelected());
		this.reloadOptions();
    }//GEN-LAST:event_jCheckBoxPersonActionPerformed

    private void jCheckBoxCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCompanyActionPerformed
		this.jCheckBoxPerson.setSelected(!this.jCheckBoxCompany.isSelected());
		this.reloadOptions();
    }//GEN-LAST:event_jCheckBoxCompanyActionPerformed

    private void jCheckBoxPersonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxPersonMouseClicked
    }//GEN-LAST:event_jCheckBoxPersonMouseClicked

    private void jCheckBoxCompanyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxCompanyMouseClicked

    }//GEN-LAST:event_jCheckBoxCompanyMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JCheckBox jCheckBoxCompany;
    private javax.swing.JCheckBox jCheckBoxPerson;
    private javax.swing.JComboBox<String> jComboBoxCompany;
    private javax.swing.JComboBox<String> jComboBoxProfession;
    private javax.swing.JLabel jLabelCompany;
    private javax.swing.JLabel jLabelFistName;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelPhoto;
    private javax.swing.JLabel jLabelProfession;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldLastName;
    // End of variables declaration//GEN-END:variables

	class AddContactWorker extends SwingWorker<Integer, Contact> {

		@Override
		protected Integer doInBackground() throws Exception {

			if (!jTextFieldFirstName.getText().isEmpty()) {
				try {
					if (jCheckBoxPerson.isSelected()) {
						String firstName = jTextFieldFirstName.getText();
						String lastName = jTextFieldLastName.getText();
						String profession = (String) jComboBoxProfession.
							getSelectedItem();
						Contact company = controller.
							getContact((String) jComboBoxCompany.
								getSelectedItem());
						controller.
							addPerson(firstName, lastName, profession, company, photoFile);
					} else {
						String name = jTextFieldFirstName.getText();
						controller.addCompany(name, photoFile);
					}
				} catch (DataIntegrityViolationException ex) {
					JOptionPane.
						showMessageDialog(rootPane, "Contact already exists!", "Contact edition", JOptionPane.ERROR_MESSAGE);
				} catch (IOException ex) {
					JOptionPane.
						showMessageDialog(rootPane, "Error opening file!", "Contact edition", JOptionPane.ERROR_MESSAGE);
				}
			}
			return 1;
		}

		@Override
		protected void done() {
			dispose();
		}
	}

	class EditContactWorker extends SwingWorker<Integer, Contact> {

		@Override
		protected Integer doInBackground() throws Exception {
			if (contact instanceof PersonContact) {
				PersonContact person = (PersonContact) contact;
				person.firstName(jTextFieldFirstName.getText());
				person.lastName(jTextFieldLastName.getText());
			} else if (contact instanceof CompanyContact) {
				CompanyContact company = (CompanyContact) contact;
				company.designation(jTextFieldFirstName.getText());
			}

			if (photoFile != null) {
				contact.photo(Converter.setImage(photoFile));
			}

			controller.editContact(contact);
			return 1;
		}

		@Override
		protected void done() {
			dispose();
		}
	}

}
