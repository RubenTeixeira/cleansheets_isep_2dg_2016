package csheets.ext.calendar.ui;

import csheets.domain.Calendar;
import csheets.ext.calendar.CalendarController;
import javax.swing.JOptionPane;

/**
 *
 * @author Valhalla
 */
public class CalendarPanelSingle extends javax.swing.JPanel {

	private CalendarController controller;
	private Calendar calendar;

	/**
	 * Creates new form ReminderPanel
	 *
	 * @param controller controller of events
	 * @param reminder
	 */
	public CalendarPanelSingle(CalendarController controller, Calendar calendar) {
		this.controller = controller;
		this.calendar = calendar;
		initComponents();
		init();
	}

	private void init() {
		this.labelContact.setText(this.calendar.getContact().name());
		this.labelName.setText(this.calendar.getName());
		this.labelDescription.setText(this.calendar.getText());
		this.jPanelColour.setBackground(this.calendar.getColor());
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
        labelContact = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelName = new javax.swing.JLabel();
        labelDescription = new javax.swing.JLabel();
        jButtonRemove = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanelColour = new javax.swing.JPanel();

        setBounds(new java.awt.Rectangle(0, 0, 250, 65));
        setMaximumSize(new java.awt.Dimension(250, 65));
        setMinimumSize(new java.awt.Dimension(250, 65));
        setPreferredSize(new java.awt.Dimension(250, 65));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalendarPanelSingle.this.mouseClicked(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        labelContact.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        labelContact.setText("contact");
        labelContact.setAutoscrolls(true);
        labelContact.setIgnoreRepaint(true);
        labelContact.setSize(new java.awt.Dimension(159, 19));
        labelContact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelContactMouseClicked(evt);
            }
        });

        labelName.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        labelName.setText("name");

        labelDescription.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        labelDescription.setText("description");

        jButtonRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/csheets/res/img/delete.gif"))); // NOI18N
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jButtonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/csheets/res/img/edit.png"))); // NOI18N
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jPanelColour.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelColourLayout = new javax.swing.GroupLayout(jPanelColour);
        jPanelColour.setLayout(jPanelColourLayout);
        jPanelColourLayout.setHorizontalGroup(
            jPanelColourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );
        jPanelColourLayout.setVerticalGroup(
            jPanelColourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanelColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelName)
                            .addComponent(labelContact, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEdit, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonRemove, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelContact, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelName))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jPanelColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDescription))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEdit)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void mouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClicked

    }//GEN-LAST:event_mouseClicked

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
		ManageCalendar calendar = new ManageCalendar(this.controller, this.calendar);
		int eventOption = JOptionPane.
			showConfirmDialog(null, calendar, "Edit Calendar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (eventOption == JOptionPane.OK_OPTION) {
			calendar.createCalendar();
		}
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed

		int op = JOptionPane.
			showConfirmDialog(this, "Do you want to remove " + this.labelName.
							  getText() + " " + "?", "Remove Calendar", JOptionPane.OK_CANCEL_OPTION);

		if (JOptionPane.OK_OPTION == op) {
			this.controller.removeCalendar(this.calendar);
		}
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void labelContactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelContactMouseClicked

    }//GEN-LAST:event_labelContactMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelColour;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelContact;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelName;
    // End of variables declaration//GEN-END:variables
}
