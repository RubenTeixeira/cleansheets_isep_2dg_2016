/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.cellsSharing.ui;

import java.util.List;

public class HostAddressContainer {
    
    private List<String> hostAddresses;
    
    // Empty constructor
    public HostAddressContainer () {
    }
    
    public HostAddressContainer (List<String> addresses) {
        this.hostAddresses = addresses;
    }
    
    protected List<String> hostAddresses(){
        return this.hostAddresses;
    }
    
    protected void setHostAddresses(List<String> addresses){
        this.hostAddresses = addresses;
    }
}
