package csheets.ext.networkExplorer.ui;

import csheets.ext.events.EventsExtension;
import csheets.ext.networkExplorer.NetworkExplorerController;
import csheets.ui.ctrl.UIController;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Martins
 */
public class NetworkExplorerPanel extends javax.swing.JPanel implements Observer {

 private NetworkExplorerController controller;

	/**
	 * Creates new form EventsPanel
	 *
	 * @param uiController The user interface controller.
	 */
	public NetworkExplorerPanel(UIController uiController) {
		this.setName(EventsExtension.NAME);
		this.initComponents();
	}

	@Override
	public void update(Observable o, Object arg) {
		

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
