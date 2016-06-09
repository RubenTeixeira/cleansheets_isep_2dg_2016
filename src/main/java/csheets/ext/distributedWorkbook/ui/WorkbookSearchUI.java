package csheets.ext.distributedWorkbook.ui;

import csheets.support.Task;
import csheets.support.TaskManager;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author José Barros
 */
public class WorkbookSearchUI extends javax.swing.JFrame implements SelectionListener, Observer {

	/**
	 * UI Controller
	 */
	private final UIController uiController;

	/**
	 * The distributed workbook search controller
	 */
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
	 * @param uiController UI Controller
	 * @param controller Distributed Workbook Search Controller
	 */
	public WorkbookSearchUI(UIController uiController,
							DistributedWorkbookSearchController controller) {
		this.uiController = uiController;
		this.controller = controller;
		instanceListModel = new DefaultListModel();

		setLocationRelativeTo(this);
		initComponents();
		this.waitingPanel.setVisible(false);
		this.searchingPanel.setVisible(false);

		uiController.addSelectionListener(this);
		instancesList.setModel(instanceListModel);

		// @IMPROVEMENT: Needs to get the timer from the configuration.
		// Maybe get it through a configuration file?
		final int defaultSeconds = 5;

		this.controller.startUdpService(this, defaultSeconds);
		this.controller.startTcpService(this);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				exit();
			}
		});

	}

	public void exit() {
		this.controller.stopServices();
		dispose();
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        instancePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        instancesList = new javax.swing.JList<String>();
        sendButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        waitingPanel = new javax.swing.JPanel();
        imgPanel = new javax.swing.JLabel();
        searchingPanel = new javax.swing.JPanel();
        searchingLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

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

        imgPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/csheets/res/img/please-wait.gif"))); // NOI18N

        javax.swing.GroupLayout waitingPanelLayout = new javax.swing.GroupLayout(waitingPanel);
        waitingPanel.setLayout(waitingPanelLayout);
        waitingPanelLayout.setHorizontalGroup(
            waitingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );
        waitingPanelLayout.setVerticalGroup(
            waitingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
        );

        searchingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/csheets/res/img/searching.gif"))); // NOI18N

        javax.swing.GroupLayout searchingPanelLayout = new javax.swing.GroupLayout(searchingPanel);
        searchingPanel.setLayout(searchingPanelLayout);
        searchingPanelLayout.setHorizontalGroup(
            searchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchingLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 408, Short.MAX_VALUE)
        );
        searchingPanelLayout.setVerticalGroup(
            searchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 246, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instancePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(waitingPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(searchingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(waitingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(searchingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
		this.setVisible(false);
		exit();
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

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
		this.controller.
			sendRequest(host, "You accept sharing your workbook information");

		this.instancePanel.setVisible(false);
		this.waitingPanel.setVisible(true);
    }//GEN-LAST:event_sendButtonActionPerformed

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
    private javax.swing.JLabel imgPanel;
    private javax.swing.JPanel instancePanel;
    private javax.swing.JList<String> instancesList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel searchingLabel;
    private javax.swing.JPanel searchingPanel;
    private javax.swing.JButton sendButton;
    private javax.swing.JPanel waitingPanel;
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

		if (object instanceof List) {
			List<String> addresses = (List<String>) object;
			updateInstanceList(addresses);
		}

		if (object instanceof String) {

			if (((String) object).compareTo("TRUE") == 0) {
				this.waitingPanel.setVisible(false);

				String workbook = JOptionPane.showInputDialog(
					this,
					"Enter the workbook name to search:",
					"Search Workbook",
					JOptionPane.WARNING_MESSAGE
				);

				if (workbook == null) {
					exit();
				}

				this.controller.sendNameOfWorkbookToSearch(host, workbook);
				this.searchingPanel.setVisible(true);

			} else if (((String) object).compareTo("FALSE") == 0) {

				this.waitingPanel.setVisible(false);
				JOptionPane.
					showMessageDialog(this, "This host doesnt wish to share workbooks.");
				exit();

			} else {
				this.searchingPanel.setVisible(false);
				JOptionPane.
					showMessageDialog(this, ((String) object), "Workbook Summary", JOptionPane.INFORMATION_MESSAGE);
				exit();
			}
		}

		if (object instanceof String[]) {
			this.controller.newSearch(uiController);

			String[] search = (String[]) object;
			boolean workbookFound = this.controller.
				searchWorkbook(uiController, search[1]);
			if (workbookFound) {
				this.controller.sendSearchResult(search[2], controller.
												 getWorkbookSummary());
			} else {
				this.controller.sendSearchResult(search[2], "Didn't find");
			}
		}
	}
}
