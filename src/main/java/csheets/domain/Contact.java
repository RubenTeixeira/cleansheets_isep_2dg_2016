/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * This class is an AggregateRoot. Represents an domain entity Contact.
 *
 * @author Rui Freitas
 */
@Entity
@Table(uniqueConstraints = {
	@UniqueConstraint(columnNames = {"NAME"})})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCRIMIN")
public abstract class Contact implements Serializable {

	/**
	 * Id of the contact it is for JPA
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	protected String name;

	/**
	 * The photo of the contact.
	 */
	@Lob
	@Basic(fetch = FetchType.EAGER)
	private byte[] photo = null;

	/**
	 *
	 * @param photo photo
	 */
	public Contact(byte[] photo) {
		if (photo == null) {
			throw new IllegalArgumentException();
		}
		this.photo = photo;
	}

	/**
	 * construct JPA
	 */
	protected Contact() {
	}

	/**
	 * Get Photo
	 *
	 * @return the photoFileName
	 */
	public byte[] photo() {
		return this.photo;
	}

	/**
	 * Set Photo
	 *
	 * @param photo photo
	 */
	public void photo(byte[] photo) {
		this.photo = photo;
	}

	/**
	 * Get Id
	 *
	 * @return identifier
	 */
	public long id() {
		return id;
	}

	/**
	 * Get Name
	 *
	 * @return nane
	 */
	public abstract String name();

	@Override
	public String toString() {
		return this.name().trim();
	}

	public void id(long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (!(obj instanceof Contact)) {
			return false;
		}
		Contact instance = (Contact) obj;
		return this.hashCode() == instance.hashCode();
	}

	@Override
	public int hashCode() {
		int hashcode = 27;
		hashcode = hashcode + 11 + this.name().hashCode();
		return hashcode;
	}

}
