/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.email.ui;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author João Martins
 */
public class PreviewSentEmailFrame extends javax.swing.JFrame {

	/**
	 * Creates new form PreviewSentEmailPanelJFrame
	 *
	 * @param destination
	 * @param subject
	 * @param body
	 */
	public PreviewSentEmailFrame(String destination, String subject,
								 String body) {
		initComponents();
		this.destinationCellText.setText(destination);
		this.destinationCellText.setEditable(false);
		this.subjectCellText.setText(subject);
		this.subjectCellText.setEditable(false);
		this.bodyCellText.setText(body);
		this.bodyCellText.setEditable(false);

		Dimension dimemsion = Toolkit.getDefaultToolkit().getScreenSize();
		this.
			setLocation(dimemsion.width / 2 - this.getSize().width / 2, dimemsion.height / 2 - this.
						getSize().height / 2);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.bodyCellText.setLineWrap(true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        bodyCellText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        bodyCellText.setEditable(false);
        bodyCellText.setColumns(20);
        bodyCellText.setRows(5);
        jScrollPane1.setViewportView(bodyCellText);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(destinationjLabel)
                    .addComponent(subjectjLabel)
                    .addComponent(bodyjLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(subjectCellText)
                    .addComponent(destinationCellText))
                .addGap(153, 153, 153))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destinationjLabel)
                    .addComponent(destinationCellText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectjLabel)
                    .addComponent(subjectCellText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bodyjLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void destinationCellTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationCellTextActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_destinationCellTextActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bodyCellText;
    private javax.swing.JLabel bodyjLabel;
    private javax.swing.JTextField destinationCellText;
    private javax.swing.JLabel destinationjLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField subjectCellText;
    private javax.swing.JLabel subjectjLabel;
    // End of variables declaration//GEN-END:variables
}