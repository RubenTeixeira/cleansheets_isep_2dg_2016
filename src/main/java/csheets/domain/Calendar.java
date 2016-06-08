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
	@ManyToOne
	private Contact m_Contact;
	private String name;
	private String text;
	private String color;

	protected Calendar() {
	}

	public Calendar(String name, String text, String color, Contact contato) {
		this.name = name;
		this.text = text;
		this.color = color;
		this.m_Contact = contato;
	}

	public Contact getM_contact() {
		return m_Contact;
	}

	public void setM_contact(Contact m_contact) {
		this.m_Contact = m_contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contact getM_Contact() {
		return m_Contact;
	}

	public void setM_Contact(Contact m_Contact) {
		this.m_Contact = m_Contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
