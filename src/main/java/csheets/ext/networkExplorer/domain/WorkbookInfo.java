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
public class WorkbookInfo {
    private final int id;
    private String name;
    private Map<String,SpreadSheetInfo> sheetsMap;

    public WorkbookInfo(int index) {
       this.id=index;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the sheetsMap
     */
    public Map<String,SpreadSheetInfo> getSheetsMap() {
        return sheetsMap;
    }
    
    public String toString() {
        return id+";"+name;
    }

    void addSpreadSheet(String sheetId, SpreadSheetInfo newSpreadsheet) {
       sheetsMap.put(sheetId, newSpreadsheet);
    }
}


