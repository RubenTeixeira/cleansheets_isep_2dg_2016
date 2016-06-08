/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import java.awt.Color;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Eduardo
 */
@Entity
@Table(uniqueConstraints = {
	@UniqueConstraint(columnNames = {"NAME"})})
public class Calendar implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Contact contact;

	private String name;

	private String description;

	private Color color;

	protected Calendar() {
	}

	public Calendar(String name, String text, Color color, Contact contato) {
		this.name = name;
		this.description = text;
		this.color = color;
		this.contact = contato;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return description;
	}

	public void setText(String text) {
		this.description = text;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
