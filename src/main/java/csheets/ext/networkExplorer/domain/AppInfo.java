/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.networkExplorer.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Diogo Azevedo
 */
public class AppInfo {
    private List<ExtensionInfo> extensions;
    private List<WorkbookInfo> workbooks;
    private String name="default";


    public AppInfo(String name) {
        this.name = name;
        this.extensions = new ArrayList();
        this.workbooks = new ArrayList();
    }
 
    

    /**
     * @return the extensionMap
     */
    public List<ExtensionInfo> getExtensions() {
        return extensions;
    }

    /**
     * @return the workbookMap
     */
    public List<WorkbookInfo> getWorkbooks() {
        return workbooks;
    }

    public void addExtension(ExtensionInfo extesion) {
        extensions.add(extesion);
    }

    public void addWorkbooks(WorkbookInfo newWorkbook) {
        workbooks.add(newWorkbook);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
