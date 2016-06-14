/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import java.util.ArrayList;
import java.util.Calendar;
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
    @UniqueConstraint(columnNames = {"TITLE"})})
public class List {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "LISTID")
    private java.util.List<List> versions;

    private String title;
    private java.util.List<Line> lines;
    private int version;
    private boolean deleted;

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
            lines.add(new Line(line));
        }
        this.contact = contact;
        this.versions = new ArrayList<>();
        this.version = 1;
        this.time = Calendar.getInstance();
    }

    public String getTitle() {
        return title;
    }
    
    public java.util.List<Line> getLines() {
        return lines;
    }

    public Contact getContact() {
        return contact;
    }

    public void edit(String title, String text) {
        versions.add(this);
        this.title = title;
        lines = new ArrayList<>();
        for (String line : text.split("\n")) {
            lines.add(new Line(line));
        }
        this.version++;
        this.time = Calendar.getInstance();
    }
    
    public void changeState(String text, boolean state){
        for (Line line : lines) {
            if(line.compareTo(text) == 0) {
                if(line.getCheck() != state) {
                    if(state) {
                        line.check();
                    } else {
                        line.uncheck();
                    }
                }
                return;
            }
        }
    }

    public List getVersion(int versionNum) {
        if (versionNum == this.version) {
            return this;
        }
        for (List version : versions) {
            if (versionNum == version.getVersion()) {
                return version;
            }
        }
        return null;
    }
    
    public int getVersion() {
        return version;
    }

    public int[] getAllVersions() {
        int versions[] = new int[this.versions.size() + 1];
        int i = 0;
        for (List version : this.versions) {
            versions[i] = version.getVersion();
            i++;
        }
        return versions;
    }
    
    public Calendar getTime() {
        return time;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void delete() {
        deleted = true;
    }

    protected class Line implements Comparable<String> {

        private boolean check;
        private String text;

        public Line(String text) {
            this.text = text;
            this.check = false;
        }

        public String getText() {
            return text;
        }

        public boolean getCheck() {
            return check;
        }

        public void check() {
            check = true;
        }

        public void uncheck() {
            check = false;
        }

        @Override
        public int compareTo(String text) {
            return this.text.compareTo(text);
        }
    }
}
