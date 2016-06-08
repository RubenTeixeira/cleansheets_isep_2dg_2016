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
	private boolean alert;

	public Reminder() {
	}

	public Reminder(String name, String description, Calendar ts, boolean alert) {
		if (name == null || description == null || ts == null) {
			throw new IllegalArgumentException("name of reminder can´t be null.");

		} else if (name.isEmpty() || description.isEmpty()) {
			throw new IllegalArgumentException("description of reminder can´t be null.");
		}
		this.name = name;
		this.description = description;
		this.timeStep = ts;
		this.alert = alert;
	}

	public String name() {
		return this.name;
	}

	public String description() {
		return this.description;
	}

	public Calendar timeOfReminder() {
		return this.timeStep;
	}

	public boolean alert() {
		return alert;
	}

	public void defineAlert(boolean alert) {
		this.alert = alert;
	}

	public void defineReminder(String name, String description, Calendar date,
							   boolean alert) {
		this.name = name;
		this.description = description;
		this.timeStep = date;
		this.alert = alert;
	}

	public void add(int field, int amount) {
		this.timeStep.add(field, amount);
	}

	public void alert(boolean active) {
		this.alert = active;
	}

	@Override
	public String toString() {
		return "Reminder: " + this.name + " - Description: " + this.description + " - " + DateTime.
			format(this.timeStep);
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
