/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.networkExplorer;

import csheets.core.Workbook;
import csheets.ext.Extension;
import csheets.ext.networkExplorer.domain.AppInfo;
import csheets.ext.networkExplorer.domain.ExtensionInfo;
import csheets.ext.networkExplorer.domain.SpreadSheetInfo;
import csheets.ext.networkExplorer.domain.WorkbookInfo;
import csheets.ext.networkExplorer.ui.NetworkExplorerPanel;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
	

/**
 *
 * @author Diogo Azevedo
 */
public class NetworkExplorerController {
        private Map<String,AppInfo> infoMap;
        private final String LOCALHOST="localHost";
        private UIController uiController;
        /**
	 * The UDP Service.
	 */
	private UdpService udpService;
        
        public List<AppInfo> appInfoList() {
            List<AppInfo> list = new ArrayList();
            AppInfo app = new AppInfo("App");
            WorkbookInfo w1 = new WorkbookInfo("work.cls");
            WorkbookInfo w2 = new WorkbookInfo("work.cls");
            SpreadSheetInfo s1 = new SpreadSheetInfo("folha 1");
            SpreadSheetInfo s2 = new SpreadSheetInfo("folha 2");
            SpreadSheetInfo s3 = new SpreadSheetInfo("folha 2");
            app.addWorkbooks(w1);
            app.addWorkbooks(w2);
            w1.addSpreadSheet(s1);
            w1.addSpreadSheet(s2);
            w1.addSpreadSheet(s3);
            w2.addSpreadSheet(s1);
            w2.addSpreadSheet(s2);
            w2.addSpreadSheet(s3);
            app.addExtension(new ExtensionInfo(true,"extension1","3.8","todihss"));
            list.add(app);
            return list;
        }
        
    	/**
	 * Starts the UDP service.
	 *
	 * @param seconds The number of seconds to execute each request.
	 */
	private void startUdpService(int seconds) {
		if (seconds <= 0) {
			throw new IllegalArgumentException("Invalid seconds number given. It's not possible to register negative or zero seconds.");
		}

		try {
			this.udpService.server();
			this.udpService.client(seconds);
		} catch (IllegalArgumentException e) {
			this.udpService.stop();
			throw e;
		}
	}

	/**
	 * Starts the UDP service.
	 *
	 * @param panel The user interface.
	 * @param seconds The number of seconds to execute each request.
	 */
	public void startUdpService(NetworkExplorerPanel panel, int seconds) {
		if (panel == null) {
			throw new IllegalArgumentException("The user interface cannot be null.");
		}

		this.udpService = new UdpService();
		this.startUdpService(seconds);
		this.udpService.addObserver(panel);
	}
        public void receiveCleansheets(String target){
            new TcpService().client(target,"receive");
        }
        
        public void infoExplorer(){
            findExtension(LOCALHOST);
            findWorkbooks(LOCALHOST);
        }

    private void findExtension(String id) {
        for (UIExtension uiExtension : uiController.getExtensions()) {
            Extension extension = uiExtension.getExtension();
            //infoMap.get(id).addExtension(extension.getName(),new ExtensionInfo(extension.isEnabled(), extension.getName(), extension.getVersion(), extension.getDescription()));
        }
    }

    private void findWorkbooks(String id) {
        for (Workbook workbook : uiController.workbooks()) {
            int index = uiController.workbooks().indexOf(workbook);
            //WorkbookInfo newWorkbook = new WorkbookInfo(index);
            //infoMap.get(id).addWorkbooks(index, newWorkbook);
            findSpreadSheets(index, workbook);
        }
    }

    private void findSpreadSheets(int id, Workbook workbook) {
        for (int i = 0; i < workbook.getSpreadsheetCount(); i++) {
            //infoMap.get(id).addSpreadSheets(id, String.valueOf(i), new SpreadSheetInfo(i, workbook.getSpreadsheet(i).getTitle()));
        }
    }
}
    

