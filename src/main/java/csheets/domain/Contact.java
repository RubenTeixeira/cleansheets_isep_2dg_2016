/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

/**
 *
 * @author nervousDev
 */
public class Contact {

	private String firstName;
	private String lastName;

	public Contact(String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;
		throw new IllegalArgumentException();
	}

}
