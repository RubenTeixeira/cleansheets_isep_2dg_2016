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

/**
 *
 * @author Diogo Azevedo
 */
public class Note {
    private final String titulo;
    private final String noteText;
    private ArrayList<Note> noteVersions;
    private Contact contact;
    private String timeStamp;
    
    public Note(String noteText){
       String[] lines = noteText.split(System.getProperty("\n"));
       titulo=lines[0];
       this.noteText=noteText;
       
       updateNote();   
    }
    
    private void updateNote(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   Date date = new Date();
	   timeStamp=dateFormat.format(date);
       
    }
    
}
