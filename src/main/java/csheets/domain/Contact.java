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
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    @UniqueConstraint(columnNames = {"FIRSTNAME", "LASTNAME"})})
public class Contact implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private Agenda agenda;

    private String firstName;
    private String lastName;

    @Basic(fetch = LAZY)
    @Lob
    @Column(name = "photo")
    private byte[] photo;

    protected Contact() {
    }

    public Contact(String firstName, String lastName, byte[] photo) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException();

        } else if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
    }

    public String firstName() {
        return this.firstName;
    }

    public String lastName() {
        return this.lastName;
    }

    public byte[] photo() {
        return this.photo;
    }

    public void changeFirstName(String name) {
        this.firstName = name;
    }

    public void changeLastName(String name) {
        this.lastName = name;
    }

    public void changePhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return this.firstName + " - " + this.lastName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.agenda);
        hash = 29 * hash + Objects.hashCode(this.firstName);
        hash = 29 * hash + Objects.hashCode(this.lastName);
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
        if (!this.firstName.equals(other.firstName)) {
            return false;
        }
        if (!this.lastName.equals(other.lastName)) {
            return false;
        }
        return !Arrays.equals(this.photo, other.photo);
    }

}
