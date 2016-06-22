/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.email.ui;

import csheets.core.Cell;
import csheets.ext.email.Email;
import csheets.ext.email.EmailController;
import csheets.ui.ctrl.UIController;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao Martins
 */
public class EmailDialog extends javax.swing.JFrame {

	/**
	 * Instance email controller.
	 */
	private final EmailController controller;

	/**
	 * Ui controller.
	 */
	private final UIController uiController;

	/**
	 * Instance email.
	 */
	private Email mail;

	/**
	 * Create a email dialog.
	 *
	 * @param controller
	 * @param uiController
	 * @param mail
	 * @throws java.io.IOException
	 * @throws java.io.FileNotFoundException
	 * @throws javax.mail.MessagingException
	 */
	public EmailDialog(EmailController controller, UIController uiController,
					   Email mail) throws IOException, FileNotFoundException, MessagingException {
		initComponents();
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.
			setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.
						getSize().height / 2);

		this.uiController = uiController;
		this.controller = controller;

		try {
			configure();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Please start your session!");
			this.dispose();
		}
		this.bodyCellText.setEditable(true);
		this.destinationCellText.setEditable(true);
		this.subjectCellText.setEditable(true);
		this.bodyCellText.setLineWrap(true);
	}

	/**
	 * Configure properties and configure email, update properties.
	 *
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws MessagingException
	 */
	public void configure() throws FileNotFoundException, IOException, MessagingException {
		Properties props = new Properties();
		Reader r = new FileReader("mail.properties");
		props.load(r);
		this.mail
			= controller.
			configureEmail(props.getProperty("mail.username"), props.
						   getProperty("mail.password"), props.
						   getProperty("mail.smtp.host"));

		controller.updateProperties(this.mail.session().
			getProperties());
	}

	/**
	 * Select/returns the content of the selected cells.
	 *
	 * @return
	 */
	private String selectCellRangeText() {
		Cell[][] selectedCells = uiController.focusOwner.getSelectedCells();
		String selectedContent = "";
		for (int i = 0; i < selectedCells.length; i++) {
			for (int j = 0; j < selectedCells[0].length; j++) {
				selectedContent += selectedCells[i][j].getContent() + " ";
			}
		}
		return selectedContent;
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
        destinationjLabel = new javax.swing.JLabel();
        destinationCellText = new javax.swing.JTextField();
        subjectjLabel = new javax.swing.JLabel();
        subjectCellText = new javax.swing.JTextField();
        bodyjLabel = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bodyCellText = new javax.swing.JTextArea();
        selectContent = new javax.swing.JButton();
        selectSubject = new javax.swing.JButton();
        selectDestination = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        destinationjLabel.setText("Destination:");

        destinationCellText.setEditable(false);
        destinationCellText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationCellTextActionPerformed(evt);
            }
        });

        subjectjLabel.setText("Subject");

        subjectCellText.setEditable(false);

        bodyjLabel.setText("Body");

        sendButton.setForeground(new java.awt.Color(51, 153, 255));
        sendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/csheets/ext/email/res/img/paperfly-512.png"))); // NOI18N
        sendButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sendButton.setBorderPainted(false);
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        bodyCellText.setEditable(false);
        bodyCellText.setColumns(20);
        bodyCellText.setRows(5);
        jScrollPane1.setViewportView(bodyCellText);

        selectContent.setText("Select content");
        selectContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectContentActionPerformed(evt);
            }
        });

        selectSubject.setText("Select content");
        selectSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectSubjectActionPerformed(evt);
            }
        });

        selectDestination.setText("Select content");
        selectDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDestinationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(destinationjLabel)
                    .addComponent(subjectjLabel)
                    .addComponent(bodyjLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(subjectCellText)
                    .addComponent(destinationCellText))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectContent)
                    .addComponent(selectSubject)
                    .addComponent(selectDestination)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destinationjLabel)
                    .addComponent(destinationCellText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectDestination))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectjLabel)
                    .addComponent(subjectCellText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectSubject))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bodyjLabel)
                            .addComponent(selectContent))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sendButton)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
		SendingEmailPanel send = new SendingEmailPanel();
		send.setVisible(true);
		try {
			this.controller.sendEmail(this.mail, this.destinationCellText.
									  getText(), this.subjectCellText.getText(), this.bodyCellText.
									  getText());

			new EmailInstancePanel(this.destinationCellText.getText(), this.subjectCellText.
								   getText(), this.bodyCellText.getText());

			send.setVisible(false);
			JOptionPane.
				showMessageDialog(this, "Message sent successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

		} catch (SendFailedException ex) {
			send.setVisible(false);
			JOptionPane.
				showMessageDialog(this, "Invalid Address!", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (MessagingException | HeadlessException ex) {
			send.setVisible(false);
			JOptionPane.
				showMessageDialog(this, "There's been an error!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		dispose();
    }//GEN-LAST:event_sendButtonActionPerformed

    private void destinationCellTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationCellTextActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_destinationCellTextActionPerformed

    private void selectContentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectContentActionPerformed
		if (bodyCellText.getText() != null) {
			bodyCellText.
				setText(bodyCellText.getText() + selectCellRangeText() + " ");
		} else {
			bodyCellText.setText(selectCellRangeText());
		}
    }//GEN-LAST:event_selectContentActionPerformed

    private void selectSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectSubjectActionPerformed
		subjectCellText.setText(selectCellRangeText());
    }//GEN-LAST:event_selectSubjectActionPerformed

    private void selectDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDestinationActionPerformed
		destinationCellText.setText(selectCellRangeText());
    }//GEN-LAST:event_selectDestinationActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bodyCellText;
    private javax.swing.JLabel bodyjLabel;
    private javax.swing.JTextField destinationCellText;
    private javax.swing.JLabel destinationjLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton selectContent;
    private javax.swing.JButton selectDestination;
    private javax.swing.JButton selectSubject;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField subjectCellText;
    private javax.swing.JLabel subjectjLabel;
    // End of variables declaration//GEN-END:variables

}