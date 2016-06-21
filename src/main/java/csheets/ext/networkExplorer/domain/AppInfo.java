/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.networkExplorer.domain;

import java.util.Map;

/**
 *
 * @author Diogo Azevedo
 */
public class AppInfo {
    private Map<String,ExtensionInfo> extensionMap;
    private Map<Integer,WorkbookInfo> workbookMap;

    /**
     * @return the extensionMap
     */
    public Map<String,ExtensionInfo> getExtensionMap() {
        return extensionMap;
    }

    /**
     * @return the workbookMap
     */
    public Map<Integer,WorkbookInfo> getWorkbookMap() {
        return workbookMap;
    }

    public void addExtension(String id, ExtensionInfo extesion) {
        extensionMap.put(id, extesion);
    }

    public void addWorkbooks(int index, WorkbookInfo newWorkbook) {
        workbookMap.put(index, newWorkbook);
    }

    public void addSpreadSheets(int workbookIndex, String sheetId, SpreadSheetInfo newSpreadsheet) {
       workbookMap.get(workbookIndex).addSpreadSheet(sheetId, newSpreadsheet);
    }
}
