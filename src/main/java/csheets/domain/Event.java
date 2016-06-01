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
import javax.persistence.Temporal;

/**
 *
 * @author Rui Freitas
 */
@Entity
public class Event implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Contact contact;

	private String description;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Calendar date;

	protected Event() {
	}

	public Event(Contact contact, String description, Calendar date) {
		if (contact == null || description == null || date == null) {
			throw new IllegalArgumentException();
		}
		this.contact = contact;
		this.description = description;
		this.date = date;
	}

	@Override
	public String toString() {
		return this.contact + " - \n" + this.description + " - " + DateTime.
			format(date);
	}
}
