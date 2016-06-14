/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Rui Bento
 */
interface Notation<E> {
    public String getTitle();
    public List getLines();
    public Contact getContact();
    public int getVersionNumber();
    public Calendar getTimeCreated();
    public E newVersion(String title, String text);
    public boolean isDeleted();
    public void delete();
    public boolean sameNotation(E e);
}
