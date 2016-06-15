/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Rui Bento
 */
@Entity
public class Version implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    
    private int lastVersion;
    
    private boolean deleted;
    
    protected Version() {
        lastVersion = 0;
    }

    public Long id() {
        return id;
    }

    protected void id(Long id) {
        this.id = id;
    }
    
    protected boolean isLastVersion(int versionNum) {
        return lastVersion == versionNum;
    }
    
    protected int getLastVersion() {
        return lastVersion;
    }
    
    protected int addVersion() {
        return ++lastVersion;
    }
    
    protected boolean isDeleted() {
        return deleted;
    }

    protected void delete() {
        deleted = true;
    }
    
}
