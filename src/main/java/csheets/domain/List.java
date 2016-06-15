/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Rui Bento
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CONTACT_ID","TITLE","VERSIONNUM"})})
public class List implements Notation<List>, Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Version version;

    private String title;
    private java.util.List<ListLine> lines;
    private int versionNum;

    @ManyToOne
    private Contact contact;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar time;

    protected List() {
    }

    public List(String title, String text, Contact contact) {
        this.title = title;
        lines = new ArrayList<>();
        for (String line : text.split("\n")) {
            lines.add(new ListLine(line));
        }
        this.contact = contact;
        this.time = Calendar.getInstance();
        this.version = new Version();
        this.versionNum = version.addVersion();
    }

    protected List(String title, String text, Contact contact, Version version) {
        this(title, text, contact);
        this.version = version;
        this.versionNum = version.addVersion();
    }
    
    public Version version() {
        return version;
    }

    public String getTitle() {
        return title;
    }
    
    public String getText() {
        String text = "";
        for (ListLine line : lines) {
            text += line.getText()+"\n";
        }
        // to remove last "\n"
        return text.substring(0, text.length()-1);
    }

    public java.util.List<ListLine> getLines() {
        return lines;
    }

    public Contact getContact() {
        return contact;
    }

    public void changeState(String text, boolean state) {
        for (ListLine line : lines) {
            if (line.compareTo(text) == 0) {
                if (line.getCheck() != state) {
                    if (state) {
                        line.check();
                    } else {
                        line.uncheck();
                    }
                }
                return;
            }
        }
    }

    public int getVersionNumber() {
        return this.versionNum;
    }

    public Calendar getTimeCreated() {
        return time;
    }

    public List newVersion(String title, String text) {
        List newList = new List(title, text, this.contact, this.version);
        return newList;
    }
    
    public boolean isDeleted() {
        return this.version.isDeleted();
    }

    public void delete() {
        this.version.delete();
    }
    
    @Override
    public boolean sameNotation(List l) {
        return l.version().equals(this.version);
    }

    @Override
    public String toString() {
        return title;
    }
}
