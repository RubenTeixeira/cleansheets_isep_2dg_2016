/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCRIMIN")
@Table(uniqueConstraints = {
	@UniqueConstraint(columnNames = {"NAME"})})
public abstract class Contact implements Serializable {

	@Id
	@GeneratedValue
	protected Long id;

	protected String name;

	@Basic(fetch = LAZY)
	@Lob
	@Column(name = "photo")
	protected byte[] photo;

	protected Contact() {
	}

	protected Contact(byte[] photo) {
		if (photo == null) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.photo = photo;
	}

	public String name() {
		return name;
	}

	public byte[] photo() {
		return this.photo;
	}

	public void changePhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 29 * hash + Objects.hashCode(this.name);
		hash = 29 * hash + Arrays.hashCode(this.photo);
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
		final Contact other = (Contact) obj;
		return this.hashCode() == other.hashCode();
	}

}
