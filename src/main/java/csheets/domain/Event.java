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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Rui Freitas
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"DESCRIPTION", "DATE"})})
public class Event implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Contact contact;

	private String description;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Calendar date;

	private boolean alert;

	protected Event() {
	}

	public Event(Contact contact, String description, Calendar date,
				 boolean alert) {
		if (contact == null || description == null || date == null) {
			throw new IllegalArgumentException();
		} else if (description.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.contact = contact;
		this.description = description;
		this.date = date;
		this.alert = alert;
	}

	public Event(Contact contact, String description, Calendar date) {
		if (contact == null || description == null || date == null) {
			throw new IllegalArgumentException();
		}
		this.contact = contact;
		this.description = description;
		this.date = date;
		this.alert = true;
	}

	public Contact contact() {
		return contact;
	}

	public Calendar date() {
		return date;
	}

	public String description() {
		return description;
	}

	public boolean alert() {
		return alert;
	}

	public void defineAlert(boolean alert) {
		this.alert = alert;
	}

	public void defineEvent(Contact contact, String description, Calendar date,
							boolean alert) {
		this.contact = contact;
		this.description = description;
		this.date = date;
		this.alert = alert;
	}

	@Override
	public String toString() {
		return this.contact + " - " + this.description + " - " + DateTime.
			format(date);
	}

	public void add(int field, int amount) {
		this.date.add(field, amount);
	}

	public void alert(boolean active) {
		this.alert = alert;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (!(obj instanceof Event)) {
			return false;
		}
		Event instance = (Event) obj;
		return this.hashCode() == instance.hashCode();
	}

	@Override
	public int hashCode() {
		int hashcode = 21;
		hashcode += this.date.hashCode();
		hashcode += this.description.hashCode();
		return hashcode;
	}
}
