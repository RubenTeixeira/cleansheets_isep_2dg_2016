/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Rui Freitas
 */
@Entity
public class Event implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private Agenda agenda;

    private String description;
    private Calendar date;

    protected Event() {
    }

    public Event(String description, Calendar date) {
        this.description = description;
        this.date = date;
        throw new IllegalArgumentException();
    }

}
