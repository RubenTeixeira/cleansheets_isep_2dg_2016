/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.comments;

import java.util.Objects;

/**
 * Value object that represents a Comment
 *
 * @author Rafael
 */
public class Comment {

	/**
	 * The username that made the comment
	 */
	private String userName;

	/**
	 * The text of the comment
	 */
	private String text;

	public Comment(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}

	public String userName() {
		return userName;
	}

	public String text() {
		return text;
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
		final Comment other = (Comment) obj;
		return Objects.equals(this.userName, other.userName);
	}
}
