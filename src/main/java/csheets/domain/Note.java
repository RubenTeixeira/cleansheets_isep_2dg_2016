/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Diogo Azevedo
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"TITULO"})})
public class Note {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Note note;
    private  String titulo;
    private  String noteText;
    @ManyToOne
    private Contact contact;
    private String timeStamp;//change to DATE

    protected Note(){
        
    }
    
    public Note(String noteText) {
        String[] lines = noteText.split(System.getProperty("\n"));
        titulo = lines[0];
        this.noteText = noteText;

        updateNote();
    }

    private void updateNote() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();
        timeStamp = dateFormat.format(date);//DATE

    }

   
}
