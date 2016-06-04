package csheets.ext.distributedWorkbook.ui;

import csheets.support.Task;
import csheets.support.TaskManager;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;

/**
 *
 * @author José Barros
 */
public class WorkbookSearchUI extends javax.swing.JFrame implements SelectionListener, Observer {

	private final UIController uiController;
	private final DistributedWorkbookSearchController controller;

	/**
	 * Default instance list
	 */
	private final DefaultListModel instanceListModel;

	/**
	 * Hostname
	 */
	private String host;

	/**
	 * Task Manager
	 */
	private final TaskManager manager = new TaskManager();

	/**
	 * Creates new form WorkbookSearchUI
	 *
	 * @param uiController
	 * @param controller
	 */
	public WorkbookSearchUI(UIController uiController, DistributedWorkbookSearchController controller) {
		this.uiController = uiController;
		this.controller = controller;
		instanceListModel = new DefaultListModel();

		setLocationRelativeTo(this);
		initComponents();

		uiController.addSelectionListener(this);
		instancesList.setModel(instanceListModel);

		// @IMPROVEMENT: Needs to get the timer from the configuration.
		// Maybe get it through a configuration file?
		final int defaultSeconds = 3;
		final int defaultPort = 20000;

		this.controller.startUdpService(this, defaultPort, defaultSeconds);
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        instancePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        instancesList = new javax.swing.JList<>();
        sendButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        instancePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Choose Instance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        instancesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                instancesListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(instancesList);

        sendButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sendButton.setText("SEND REQUEST");
        sendButton.setEnabled(false);

        cancelButton.setText("CANCEL");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout instancePanelLayout = new javax.swing.GroupLayout(instancePanel);
        instancePanel.setLayout(instancePanelLayout);
        instancePanelLayout.setHorizontalGroup(
            instancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(instancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addGroup(instancePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        instancePanelLayout.setVerticalGroup(
            instancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(instancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instancePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
		this.setVisible(false);
		disable();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void instancesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_instancesListValueChanged
		if (evt.getValueIsAdjusting() == false) {
			if (instancesList.getSelectedIndex() == -1) {
				//No selection.
				sendButton.setEnabled(false);
			} else {
				//Selection.
				sendButton.setEnabled(true);
				host = instancesList.getSelectedValue();
			}
		}
    }//GEN-LAST:event_instancesListValueChanged

	public void updateInstanceList(List<String> addresses) {

		for (String address : addresses) {
			if (!instanceListModel.contains(address)) {
				instanceListModel.addElement(address);

				manager.after(20).once(new Task() {
					@Override
					public void fire() {
						instanceListModel.removeElement(address);
						instancesList.setModel(instanceListModel);
					}
				});
			}
		}

		instancesList.setModel(instanceListModel);
		repaint();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel instancePanel;
    private javax.swing.JList<String> instancesList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables

	@Override
	public void selectionChanged(SelectionEvent event) {
		// nothing to do
	}

	public void run() {
		this.setVisible(true);
	}

	@Override
	public void update(Observable o, Object object) {
		if (object instanceof Map) {
			// TODO
		}
		if (object instanceof List) {
			List<String> addresses = (List<String>) object;
			updateInstanceList(addresses);
		}
	}
}
