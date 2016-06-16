/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Bruno
 */
@Entity
@Table(uniqueConstraints = {
	@UniqueConstraint(columnNames = {"TITULO"})})
public class Task {

	@Id
	@GeneratedValue
	private Long id;

	private String taskName;
	private String description;
	private int priority;
	private float percentageofcompletion;

	@ManyToOne
	private Contact contact;

	protected Task() {
	}

	public Task(String taskName, String description, int priority,
				float percentageofcompletion, Contact contact) {
		if (taskName == null || description == null || percentageofcompletion < 0 || percentageofcompletion > 100 || contact == null) {
			throw new IllegalArgumentException("Illegal arguments!");
		} else if (taskName.isEmpty() || description.isEmpty()) {
			throw new IllegalArgumentException("Illegal arguments empty");
		}
		this.taskName = taskName;
		this.contact = contact;
		this.description = description;
		this.priority = priority;
		this.percentageofcompletion = percentageofcompletion;
	}

	public void defineTask(String name, String description, int priority,
						   float percentage) {
		if (name == null || description == null || percentage < 0 || percentage > 100) {
			throw new IllegalArgumentException("Illegal arguments!");
		} else if (name.isEmpty() || description.isEmpty()) {
			throw new IllegalArgumentException("Illegal arguments empty");
		}
		this.taskName = name;
		this.description = description;
		this.priority = priority;
		this.percentageofcompletion = percentage;
	}

	public String TaskName() {
		return this.taskName;
	}

	public String Description() {
		return this.description;
	}

	public int Priority() {
		return this.priority;
	}

	public float Percentage() {
		return this.percentageofcompletion;
	}

	public Contact getContact() {
		return this.contact;
	}

	@Override
	public String toString() {
		return this.taskName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (!(obj instanceof Task)) {
			return false;
		}
		Task instance = (Task) obj;
		return this.hashCode() == instance.hashCode();
	}

	@Override
	public int hashCode() {
		int hashcode = 21;
		hashcode += this.taskName.hashCode();
		hashcode += this.description.hashCode();
		hashcode += this.contact.hashCode();
		return hashcode;
	}
}
