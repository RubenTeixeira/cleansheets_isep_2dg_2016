package csheets.ext.secureCommunications.ui;

import csheets.ext.cellsSharing.ShareExtension;
import csheets.support.Task;
import csheets.support.TaskManager;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 *
 * The extension panel to show the exchanged messages between CleanSheets instances.
 */
public class SecureCommunicationsUI extends javax.swing.JPanel implements SelectionListener, Observer {

	DefaultCategoryDataset dataset = new DefaultCategoryDataset();

	private final UIController uiController;

	/**
	 * The assertion controller
	 */
	private final SecureCommunicationsController controller;

	/**
	 * Default messages model.
	 */
	private final DefaultListModel messagesListModel;

	/**
	 * Incomming message size
	 */
	private int sizeI;

	/**
	 * Secure Incomming message size
	 */
	private int sizeSI;

	/**
	 * Outgoing message size
	 */
	private int sizeO;

	/**
	 * Secure outgoing message size
	 */
	private int sizeSO;

	/**
	 * Task Manager
	 */
	private final TaskManager manager = new TaskManager();

	public SecureCommunicationsUI(UIController uiController,
								  SecureCommunicationsController controller) {
		this.uiController = uiController;
		setName(ShareExtension.NAME);

		messagesListModel = new DefaultListModel();
		initComponents();
		uiController.addSelectionListener(this);
		messagesList.setModel(messagesListModel);

		dataset.setValue(0, "Amount of information", "Icomming");
		dataset.setValue(0, "Amount of information", "Outgoing");
		dataset.setValue(0, "Amount of information", "Secure I.");
		dataset.setValue(0, "Amount of information", "Secure O.");

		this.controller = controller;
		this.controller.startServices(this);

		Task clean = new Task() {
			@Override
			public void fire() {
				messagesListModel.clear();
				messagesList.setModel(messagesListModel);

			}
		};

		Task updateChart = new Task() {
			@Override
			public void fire() {
				createPane();
			}
		};

		manager.after(30).every(30).fire(clean)
			.after(1).every(5).fire(updateChart);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneSecureCommunications = new javax.swing.JTabbedPane();
        jPanelMessages = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messagesList = new javax.swing.JList<>();
        sendButton = new javax.swing.JButton();
        secureCheckBox = new javax.swing.JCheckBox();
        messageText = new javax.swing.JTextField();
        jPanelNetworkAnalizer = new javax.swing.JPanel();
        jPanelChart = new javax.swing.JPanel();

        jTabbedPaneSecureCommunications.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Messages", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        jPanel2.setName(""); // NOI18N

        messagesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                messagesListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(messagesList);

        sendButton.setText("Send");
        sendButton.setEnabled(false);
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        secureCheckBox.setActionCommand("setSecureConnection");
        secureCheckBox.setLabel("Secure");

        messageText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                messageTextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(secureCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                .addComponent(sendButton))
            .addComponent(messageText)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendButton)
                    .addComponent(secureCheckBox))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout jPanelMessagesLayout = new javax.swing.GroupLayout(jPanelMessages);
        jPanelMessages.setLayout(jPanelMessagesLayout);
        jPanelMessagesLayout.setHorizontalGroup(
            jPanelMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelMessagesLayout.setVerticalGroup(
            jPanelMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPaneSecureCommunications.addTab("Messages", jPanelMessages);

        jPanelNetworkAnalizer.setBackground(new java.awt.Color(255, 255, 255));

        jPanelChart.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelChartLayout = new javax.swing.GroupLayout(jPanelChart);
        jPanelChart.setLayout(jPanelChartLayout);
        jPanelChartLayout.setHorizontalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        jPanelChartLayout.setVerticalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelNetworkAnalizerLayout = new javax.swing.GroupLayout(jPanelNetworkAnalizer);
        jPanelNetworkAnalizer.setLayout(jPanelNetworkAnalizerLayout);
        jPanelNetworkAnalizerLayout.setHorizontalGroup(
            jPanelNetworkAnalizerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNetworkAnalizerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanelNetworkAnalizerLayout.setVerticalGroup(
            jPanelNetworkAnalizerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNetworkAnalizerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneSecureCommunications.addTab("NetworkAnalizer", jPanelNetworkAnalizer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneSecureCommunications, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneSecureCommunications)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void messageTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageTextKeyReleased
		if (messageText.getText().trim().isEmpty()) {
			sendButton.setEnabled(false);
		} else {
			sendButton.setEnabled(true);
		}
    }//GEN-LAST:event_messageTextKeyReleased

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
		if (secureCheckBox.isSelected()) {
			this.controller.send(this, messageText.getText().trim(), true);
		} else {
			this.controller.send(this, messageText.getText().trim(), false);
		}

		messageText.setText("");
		sendButton.setEnabled(false);
    }//GEN-LAST:event_sendButtonActionPerformed

    private void messagesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_messagesListValueChanged

    }//GEN-LAST:event_messagesListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelChart;
    private javax.swing.JPanel jPanelMessages;
    private javax.swing.JPanel jPanelNetworkAnalizer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPaneSecureCommunications;
    private javax.swing.JTextField messageText;
    private javax.swing.JList<String> messagesList;
    private javax.swing.JCheckBox secureCheckBox;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables

	@Override
	public void update(Observable o, Object object) {
		String[] message = object.toString().split(":");

		if (message.length == 0) {
			return;
		}

		if (message[0].isEmpty()) {
			return;
		}

		try {
			if (message[0].equals("R")) {
				sizeI += Integer.parseInt(message[1]);
			} else if (message[0].equals("S")) {
				sizeO += Integer.parseInt(message[1]);
			} else if (message[0].equals("RE")) {
				sizeSI += Integer.parseInt(message[1]);
			} else if (message[0].equals("SE")) {
				sizeSO += Integer.parseInt(message[1]);
			} else {
				messagesListModel.addElement(object);
			}
		} catch (Exception e) {
		}
	}

	@Override
	public void selectionChanged(SelectionEvent event) {

	}

	/**
	 * Create a new chartPanel
	 *
	 *
	 * @return chartPanel User Interface to observe the communications.
	 */
	private void createPane() {

		dataset.setValue(dataset.getValue("Amount of information", "Icomming").
			intValue() + sizeI, "Amount of information", "Icomming");
		sizeI = 0;

		dataset.setValue(dataset.getValue("Amount of information", "Outgoing").
			intValue() + sizeO, "Amount of information", "Outgoing");
		sizeO = 0;

		dataset.setValue(dataset.getValue("Amount of information", "Secure I.").
			intValue() + sizeSI, "Amount of information", "Secure I.");
		sizeSI = 0;

		dataset.setValue(dataset.getValue("Amount of information", "Secure O.").
			intValue() + sizeSO, "Amount of information", "Secure O.");
		sizeSO = 0;

		String unit = compareSize(dataset.
			getValue("Amount of information", "Icomming").
			intValue(),
								  dataset.
								  getValue("Amount of information", "Outgoing").
								  intValue(),
								  dataset.
								  getValue("Amount of information", "Secure I.").
								  intValue(),
								  dataset.
								  getValue("Amount of information", "Secure O.").
								  intValue());
		JFreeChart chart = ChartFactory.
			createBarChart("Network Analizer", "Network traffic", unit, dataset, PlotOrientation.VERTICAL, true, true, true);

		CategoryPlot p = chart.getCategoryPlot();
		p.setRangeGridlinePaint(Color.BLACK);

		jPanelChart = new ChartPanel(chart);

		jPanelChart.
			setSize(400, 400);
		jPanelChart.setVisible(true);

		jPanelNetworkAnalizer.removeAll();
		jPanelNetworkAnalizer.add(jPanelChart);

	}

	/**
	 * Change the units base on window size
	 *
	 * @param sizeI size incomming
	 * @param sizeO size outgoing
	 * @param sizeSI size secure incomming
	 * @param sizeSO size secure outgoing
	 * @return unit name
	 */
	public String compareSize(int sizeI, int sizeO, int sizeSI, int sizeSO) {

		int size = sizeI + sizeO + sizeSI + sizeSO;
		int media = size / 4;
		return controller.unitToBeUsed(media);

	}

}
