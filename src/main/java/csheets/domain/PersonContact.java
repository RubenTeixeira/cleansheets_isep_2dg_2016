/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author Marcelo Barroso 1131399
 */
@Entity
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
	 * The contact company of the contact.
	 */
	@OneToOne(cascade = CascadeType.MERGE)
	private Contact company = null;

	/**
	 * Profession of the contact
	 */
	private String profession = null;

	/**
	 *
	 * @param firstName
	 * @param lastName
	 * @param photo
	 */
	public PersonContact(String firstName, String lastName, String profession,
						 Contact company, byte[] photo) {
		super(photo);
		if (firstName == null || firstName.isEmpty() || lastName == null) {
			throw new IllegalArgumentException();
		}
		this.firstName = firstName;
		this.lastName = lastName;

	}

	/**
	 * contruct JAP
	 */
	protected PersonContact() {
	}

	/**
	 * Get Name
	 *
	 * @return name
	 */
	@Override
	public String name() {
		return this.firstName + " " + this.lastName;
	}

	/**
	 * Get First Name
	 *
	 * @return the first name
	 */
	public String firstName() {
		return this.firstName;
	}

	/**
	 * Set First Name
	 *
	 * @param firstName
	 */
	public void firstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get Last Name
	 *
	 * @return the last name
	 */
	public String lastName() {
		return this.lastName;
	}

	/**
	 * @param lastName
	 */
	public void lastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get Business
	 *
	 * @return Contact
	 */
	public Contact company() {
		return company;
	}

	/**
	 * Get Profession
	 *
	 * @return String
	 */
	public String profession() {
		return profession;
	}

	/**
	 * Set Business
	 *
	 * @param business
	 */
	public void company(Contact company) {
		this.company = company;
	}

	/**
	 * Set Profession
	 *
	 * @param profession
	 */
	public void profession(String profession) {
		this.profession = profession;
	}

}
