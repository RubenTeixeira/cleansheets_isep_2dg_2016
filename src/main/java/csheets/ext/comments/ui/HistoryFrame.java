/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.comments.ui;

import csheets.ext.comments.Comment;
import csheets.notification.Notification;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author user
 */
public class HistoryFrame extends javax.swing.JFrame implements Observer {

	private CommentController controller;
	private Comment comment;

	/**
	 * Creates new form HistoryFram
	 */
	public HistoryFrame(CommentController controller, Comment comment) {
		this.controller = controller;
		this.comment = comment;
		this.initComponents();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.update(null, null);
		Notification.commentInformer().addObserver(this);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelVersions = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));

        jPanelVersions.setLayout(new java.awt.GridLayout());

        jLabelTitle.setText("History..");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelVersions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitle)
                        .addGap(0, 329, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelVersions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelVersions;
    // End of variables declaration//GEN-END:variables

	@Override
	public void update(Observable o, Object arg) {
		this.jPanelVersions.removeAll();
		((GridLayout) this.jPanelVersions.getLayout()).setRows(5);
		if (this.comment != null) {
			for (Comment comment : this.comment.commentHistory()) {
				HistoryPanelSingle panel = new HistoryPanelSingle(this.controller, comment);
				this.jPanelVersions.add(panel);
				GridLayout layout = (GridLayout) this.jPanelVersions.
					getLayout();
				layout.setRows(layout.getRows() + 1);
			}
		}
		this.jPanelVersions.revalidate();
		this.jPanelVersions.repaint();
	}
}