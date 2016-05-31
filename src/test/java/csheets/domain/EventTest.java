/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author nervousDev
 */
public class EventTest {

	public EventTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of Description Not Null method
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDescriptionNotAcceptNull() {
		Calendar date = Calendar.getInstance();
		Event newEvent = new Event(null, date);

	}

	/**
	 * Test of Date Not Null method
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDateNotAcceptNull() {
		Event newEvent = new Event("Event about JAVA skills", null);

	}

	/**
	 * Test of Description Not Empty method
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDescriptionNotAcceptEmpty() {
		Calendar date = Calendar.getInstance();
		Event newEvent = new Event("", date);

	}

}
