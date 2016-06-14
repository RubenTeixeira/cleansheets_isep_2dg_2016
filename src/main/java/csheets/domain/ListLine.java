/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Rui Bento
 */
@Embeddable
public class ListLine implements Comparable<String>, Serializable {

    private boolean check;
    private String text;

    public ListLine(String text) {
        this.text = text;
        this.check = false;
    }

    public String getText() {
        return text;
    }

    public boolean getCheck() {
        return check;
    }

    public void check() {
        check = true;
    }

    public void uncheck() {
        check = false;
    }

    @Override
    public int compareTo(String text) {
        return this.text.compareTo(text);
    }
}
