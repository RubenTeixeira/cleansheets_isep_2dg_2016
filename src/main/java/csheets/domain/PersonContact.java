/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 *
 * @author Marcelo Barroso 1131399
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("PERSON")
public class PersonContact extends Contact {

	/**
	 * First name of the contact
	 */
	private String firstName;

	/**
	 * Last name of the contact
	 */
	private String lastName;

	/**
	 * Last name of the contact
	 */
	private String profession;

	/**
	 * The contact business of the contact.
	 */
	@ManyToOne(cascade = CascadeType.MERGE)
	private Contact company = null;

	protected PersonContact() {
	}

	public PersonContact(String firstName, String lastName, String profession,
						 CompanyContact company, byte[] photo) {
		if (firstName == null || firstName.isEmpty() || lastName == null || lastName.
			isEmpty() || photo == null) {
			throw new IllegalArgumentException();
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.profession = profession;
		this.company = company;
		this.photo = photo;
	}

	public String firstName() {
		return this.firstName;
	}

	public String lastName() {
		return this.lastName;
	}

	public void changeFirstName(String name) {
		this.firstName = name;
		this.name = this.toString();
	}

	public void changeLastName(String name) {
		this.lastName = name;
		this.name = this.toString();
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 29 * hash + Objects.hashCode(this.firstName);
		hash = 29 * hash + Objects.hashCode(this.lastName);
		hash = 29 * hash + Objects.hashCode(this.profession);
		hash = 29 * hash + Objects.hashCode(this.company);
		hash = 29 * hash + super.hashCode();
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final PersonContact other = (PersonContact) obj;
		return this.hashCode() == other.hashCode();
	}

}
