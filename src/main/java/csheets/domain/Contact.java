/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * This class is an AggregateRoot. Represents an domain entity Contact.
 *
 * @author Rui Freitas
 */
@Entity
public class Contact implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private Agenda agenda;

	private String firstName;
	private String lastName;

	protected Contact() {
	}

	public Contact(String firstName, String lastName) {
		if (firstName == null || lastName == null) {
			throw new IllegalArgumentException();

		} else if (firstName.isEmpty() || lastName.isEmpty()) {
			throw new IllegalArgumentException();
		}

		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return this.firstName + " - " + this.lastName;
	}
}
