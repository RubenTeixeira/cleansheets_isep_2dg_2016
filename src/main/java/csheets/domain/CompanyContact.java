/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Marcelo Barroso 1131399
 */
@Entity
@DiscriminatorValue("BUSINESS")
public class CompanyContact extends Contact {

	/**
	 * The Enterprise's designation
	 */
	private String designation;

	/**
	 *
	 * @param designation
	 * @param photo
	 */
	public CompanyContact(String designation, byte[] photo) {
		super(photo);
		if (designation == null || designation.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.designation = designation;
	}

	/**
	 * contruct JPA
	 */
	protected CompanyContact() {
	}

	/**
	 * Get Name
	 *
	 * @return name
	 */
	@Override
	public String name() {
		return this.designation;
	}

	/**
	 * Get Designation
	 *
	 * @return designation
	 */
	public String designation() {
		return designation;
	}

	/**
	 * Set Designation
	 *
	 * @param designation
	 */
	public void designation(String designation) {
		this.designation = designation;
	}

}
