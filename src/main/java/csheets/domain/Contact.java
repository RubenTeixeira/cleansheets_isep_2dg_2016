/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

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

	@Lob
	@Column(name = "photo")
	private byte[] photo;

	protected Contact() {
	}

	public Contact(String firstName, String lastName, byte[] photo) {
		if (firstName == null || lastName == null) {
			throw new IllegalArgumentException();

		} else if (firstName.isEmpty() || lastName.isEmpty()) {
			throw new IllegalArgumentException();
		}

		this.firstName = firstName;
		this.lastName = lastName;
		this.photo = photo;
	}

	public String firstName() {
		return this.firstName;
	}

	public String lastName() {
		return this.lastName;
	}

	public byte[] photo() {
		return this.photo;
	}

	public void changePhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
}
