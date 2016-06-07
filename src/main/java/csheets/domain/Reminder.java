/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import csheets.support.DateTime;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(uniqueConstraints = {
	@UniqueConstraint(columnNames = {"NAME"})})
public class Reminder implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    private String description;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar timeStep;

    public Reminder() {
    }

    public Reminder(String Name, String description, Calendar ts) {
        if (Name == null || description == null) {
            throw new IllegalArgumentException("name of reminder can´t be null.");

        } else if (Name.isEmpty() || description.isEmpty()) {
            throw new IllegalArgumentException("description of reminder can´t be null.");
        }
        if(DateTime.now().after(ts)){
            throw new IllegalArgumentException("the date of reminder is invalid.");
        }
        
        this.name = Name;
        this.description = description;
        this.timeStep = ts;
    }
    
    public String Name(){
        return this.name;
    }

    public String Description(){
        return this.description;
    }
    
    public Calendar TimeOfReminder(){
        return this.timeStep;
    }
    
    public void add(int field, int amount) {
	this.timeStep.add(field, amount);
    }
    @Override
    public String toString() {
	return "Reminder: "+this.name + " - Description: " + this.description + " - " + DateTime.format(this.timeStep);
    }

    @Override
    public boolean equals(Object obj) {
    if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (!(obj instanceof Reminder)) {
			return false;
		}
		Reminder instance = (Reminder) obj;
		return this.hashCode() == instance.hashCode();
	}

	@Override
	public int hashCode() {
		int hashcode = 21;
		hashcode += this.name.hashCode();
		hashcode += this.description.hashCode();
		hashcode += this.timeStep.hashCode();
		return hashcode;
	}

}
