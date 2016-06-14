/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Rui Bento
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"TITULO"})})
public class List {

    @Id
    @GeneratedValue
    private Long id;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "NOTEID")
    private java.util.List<Note> versions;
    
    private String title;
    private String text;
    private boolean versionState;
    private boolean deleted;

    @ManyToOne
    private Contact contact;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private java.util.Calendar timeStamp;
    
    protected List() {
    }
    
    public List(String title, String text, Contact contact, boolean versionState) {
        this.title = title;
        this.text = text;
        this.contact = contact;
        this.versionState = versionState;
    }
    
    public Contact getContact() {
        return contact;
    }
}
