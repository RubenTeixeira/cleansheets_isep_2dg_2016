/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.chat.domain;

import csheets.support.DateTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marcelo Barroso 1131399
 */
@Entity
public class Message implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Room room;

	@ManyToOne(cascade = CascadeType.MERGE)
	private User user;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;

	private String content;

	@OneToOne(cascade = CascadeType.MERGE)
	private List<Message> answers;

	protected Message() {
	}

	public Message(Room room, User user, Calendar date, String content) {
		this.room = room;
		this.user = user;
		this.date = date;
		this.content = content;
		this.answers = new ArrayList();
	}

	public Calendar date() {
		return this.date;
	}

	public List<Message> answers() {
		return this.answers;
	}

	public Message addAnswers(Calendar date, String content) {
		Message answer = new Message(this.room, this.user, date, content);
		if (this.answers.add(answer)) {
			return answer;
		}
		return null;
	}

	@Override
	public String toString() {
		return DateTime.format(this.date, "YYYY/MM/dd hh:mm (") + this.user + ") " + this.content;
	}

	@Override
	public int hashCode() {
		int hash = 29;
		hash = hash * 11 + Objects.hashCode(this.room);
		hash = hash * 11 + Objects.hashCode(this.user);
		hash = hash * 11 + Objects.hashCode(this.date);
		hash = hash * 11 + Objects.hashCode(this.content);
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
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Message other = (Message) obj;
		return Objects.equals(this.hashCode(), other.hashCode());
	}

}
