package csheets.ext.findNotesLists.ui;

import csheets.domain.List;
import csheets.domain.Note;
import csheets.ext.events.EventsExtension;
import csheets.ext.findNotesLists.FindController;
import csheets.ui.DefaulListModel;
import csheets.ui.ctrl.UIController;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;

/**
 *
 * @author Martins
 */
public class FindPanel extends javax.swing.JPanel implements Observer {

	private FindController controller;
	private DefaultListModel resultListModel = new DefaulListModel();

	/**
	 * Creates new form EventsPanel
	 *
	 * @param uiController The user interface controller.
	 */
	public FindPanel(UIController uiController) {
		this.setName(EventsExtension.NAME);
		this.controller = new FindController(uiController, this);
		this.initComponents();
		this.addListener();
		this.jListResults.setModel(this.resultListModel);
		this.update(null, null);
	}

	private void addListener() {
		jStartDateChooser.getDateEditor().addPropertyChangeListener(
			new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				if ("date".equals(event.getPropertyName())) {
					update(null, null);
				}
			}
		});
		jEndDateChooser.getDateEditor().addPropertyChangeListener(
			new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				if ("date".equals(event.getPropertyName())) {
					update(null, null);
				}
			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		this.resultListModel.removeAllElements();
		for (Note note : this.controller.searchNotes(this.jStartDateChooser.
			getCalendar(), this.jEndDateChooser.getCalendar(), this.jTextFieldExpression.
													 getText(), this.jCheckBoxContent.
													 isSelected())) {
			this.resultListModel.addElement("(Note) " + note);
		}
		for (List list : this.controller.searchLists(this.jStartDateChooser.
			getCalendar(), this.jEndDateChooser.getCalendar(), this.jTextFieldExpression.
													 getText(), this.jCheckBoxContent.
													 isSelected())) {
			this.resultListModel.addElement("(List) " + list);
		}
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

        jPanel1 = new javax.swing.JPanel();
        panelSearch = new javax.swing.JPanel();
        panelDate = new javax.swing.JPanel();
        jLabelStart = new javax.swing.JLabel();
        jLabelEnd = new javax.swing.JLabel();
        jEndDateChooser = new com.toedter.calendar.JDateChooser();
        jStartDateChooser = new com.toedter.calendar.JDateChooser();
        jTextFieldExpression = new javax.swing.JTextField();
        jPanelResultsList = new javax.swing.JPanel();
        jCheckBoxContent = new javax.swing.JCheckBox();
        jButtonExport = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jListResults = new javax.swing.JList<>();

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabelStart.setText("Start:");

        jLabelEnd.setText("End:");

        jEndDateChooser.setToolTipText("");
        jEndDateChooser.setDoubleBuffered(false);
        jEndDateChooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jEndDateChooserKeyReleased(evt);
            }
        });

        jStartDateChooser.setToolTipText("");
        jStartDateChooser.setDoubleBuffered(false);
        jStartDateChooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jStartDateChooserKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelDateLayout = new javax.swing.GroupLayout(panelDate);
        panelDate.setLayout(panelDateLayout);
        panelDateLayout.setHorizontalGroup(
            panelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDateLayout.createSequentialGroup()
                        .addComponent(jLabelStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jStartDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDateLayout.createSequentialGroup()
                        .addComponent(jLabelEnd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jEndDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDateLayout.setVerticalGroup(
            panelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jStartDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDateLayout.createSequentialGroup()
                        .addComponent(jLabelEnd)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDateLayout.createSequentialGroup()
                        .addComponent(jEndDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jTextFieldExpression.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldExpressionActionPerformed(evt);
            }
        });
        jTextFieldExpression.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldExpressionKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelResultsListLayout = new javax.swing.GroupLayout(jPanelResultsList);
        jPanelResultsList.setLayout(jPanelResultsListLayout);
        jPanelResultsListLayout.setHorizontalGroup(
            jPanelResultsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelResultsListLayout.setVerticalGroup(
            jPanelResultsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );

        jCheckBoxContent.setText("Content");
        jCheckBoxContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxContentMouseClicked(evt);
            }
        });
        jCheckBoxContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxContentActionPerformed(evt);
            }
        });

        jButtonExport.setText("Export");
        jButtonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportActionPerformed(evt);
            }
        });

        jListResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListResultsMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jListResults);

        javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
        panelSearch.setLayout(panelSearchLayout);
        panelSearchLayout.setHorizontalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jButtonExport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelSearchLayout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelResultsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSearchLayout.createSequentialGroup()
                        .addComponent(jTextFieldExpression, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxContent)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelSearchLayout.setVerticalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldExpression, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxContent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelResultsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jEndDateChooserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jEndDateChooserKeyReleased
		update(null, null);
    }//GEN-LAST:event_jEndDateChooserKeyReleased

    private void jStartDateChooserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jStartDateChooserKeyReleased
		update(null, null);
    }//GEN-LAST:event_jStartDateChooserKeyReleased

    private void jTextFieldExpressionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldExpressionActionPerformed

    }//GEN-LAST:event_jTextFieldExpressionActionPerformed

    private void jTextFieldExpressionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldExpressionKeyReleased
		update(null, null);
    }//GEN-LAST:event_jTextFieldExpressionKeyReleased

    private void jListResultsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListResultsMouseClicked
		if (evt.getClickCount() == 2) {
			new Informations(this.resultListModel.get(this.jListResults.
				getSelectedIndex()));
		}
    }//GEN-LAST:event_jListResultsMouseClicked

    private void jCheckBoxContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxContentMouseClicked
		update(null, null);
    }//GEN-LAST:event_jCheckBoxContentMouseClicked

    private void jCheckBoxContentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxContentActionPerformed

    }//GEN-LAST:event_jCheckBoxContentActionPerformed

    private void jButtonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportActionPerformed
		this.controller.export(this.resultListModel.toArray());
    }//GEN-LAST:event_jButtonExportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExport;
    private javax.swing.JCheckBox jCheckBoxContent;
    private com.toedter.calendar.JDateChooser jEndDateChooser;
    private javax.swing.JLabel jLabelEnd;
    private javax.swing.JLabel jLabelStart;
    private javax.swing.JList<String> jListResults;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelResultsList;
    private javax.swing.JScrollPane jScrollPane9;
    private com.toedter.calendar.JDateChooser jStartDateChooser;
    private javax.swing.JTextField jTextFieldExpression;
    private javax.swing.JPanel panelDate;
    private javax.swing.JPanel panelSearch;
    // End of variables declaration//GEN-END:variables
}
