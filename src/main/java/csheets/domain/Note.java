/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import csheets.support.DateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Diogo Azevedo
 */
@Entity
@Table(uniqueConstraints = {
	@UniqueConstraint(columnNames = {"TITLE"})})
public class Note {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "NOTEID")
	private List<Note> versions;

	private String title;
	private String noteText;
	private boolean versionState;

	@ManyToOne
	private Contact contact;

	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private java.util.Calendar time;

	protected Note() {
	}

	public Note(String noteText, Contact contact, boolean noteState) {
		String s[] = noteText.split("\\r?\\n");
		ArrayList<String> arrList = new ArrayList<>(Arrays.asList(s));
		System.out.println(arrList);
		title = arrList.get(0);
		this.noteText = noteText;
		this.contact = contact;
		this.time = DateTime.now();
		this.versionState = noteState;
	}

	private void updateNote() {
		Note n = new Note(this.noteText, this.contact, false);
		n.timeStamp(DateTime.now());
		versions.add(n);
	}

	public void editNote(String textNote) {
		String s[] = noteText.split("\\r?\\n");
		ArrayList<String> arrList = new ArrayList<>(Arrays.asList(s));
		System.out.println(arrList);
		title = arrList.get(0);
		this.noteText = textNote;

		updateNote();
	}

	public Contact getContact() {
		return this.contact;
	}

	private void timeStamp(Calendar now) {
		this.time = now;
	}

	public List<Note> versionByNote() {
		return this.versions;
	}

	public boolean noteState() {
		return this.versionState;
	}

	public Calendar date() {
		return time;
	}

	@Override
	public String toString() {
		return this.title;
	}
}
