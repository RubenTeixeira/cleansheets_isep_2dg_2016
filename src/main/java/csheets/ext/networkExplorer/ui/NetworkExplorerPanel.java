package csheets.ext.networkExplorer.ui;

import csheets.ext.events.EventsExtension;
import csheets.ext.networkExplorer.NetworkExplorerController;
import csheets.notification.Notification;
import csheets.ui.ctrl.UIController;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Martins
 */
public class NetworkExplorerPanel extends javax.swing.JPanel implements Observer {

 private final NetworkExplorerController controller;
 
 private final UIController uiController;
 	/**
	 * Hostname
	 */
	private String host;

	/**
	 * Creates new form NetworkExplorerPanel
	 *
	 * @param uiController The user interface controller.

	 */
	public NetworkExplorerPanel(UIController uiController) {
                this.uiController = uiController;
                this.controller= new NetworkExplorerController();
		this.setName(EventsExtension.NAME);
		this.initComponents();
                final int defaultSeconds = 3;
                
                this.controller.startUdpService(this, defaultSeconds);
                Notification.cellInformer().addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
            //instanceList receber lista de hosts. ao receber hots crio um novo tcp service
            //para cada host da lista, receber a sua cleansheet(for each)
            controller.receiveCleansheets(host);
            
            
            
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTree1);

        jLabel1.setText("Network Explorer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 215, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
