/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Marcelo Barroso 1131399
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("COMPANY")
public class CompanyContact extends Contact {

	protected CompanyContact() {
	}

	public CompanyContact(String name, byte[] photo) {
		if (name == null || name.isEmpty() || photo == null || photo == null) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.photo = photo;
	}

	public String name() {
		return this.name;
	}

	public void changeName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int hashCode() {
		int hash = 5;
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
		final CompanyContact other = (CompanyContact) obj;
		return this.hashCode() == other.hashCode();
	}

}
