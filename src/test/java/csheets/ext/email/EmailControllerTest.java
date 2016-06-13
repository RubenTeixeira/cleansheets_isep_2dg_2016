/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.email;

import javax.mail.AuthenticationFailedException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Rui Bastos
 */
public class EmailControllerTest {

	EmailController instance;

	public EmailControllerTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		instance = new EmailController();
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of configureEmail method, of class EmailController, when
	 * authentication is wrong.
	 */
	@Test(expected = AuthenticationFailedException.class)
	public void testConfigureEmailAuthenticationFailed() throws Exception {
		String email = "lapr4_2dg@outlook.pt";
		String password = "1234";
		String server = "smtp.live.com";
		instance.configureEmail(email, password, server);
	}

	/**
	 * Test of configureEmail method, of class EmailController, when
	 * authentication is wrong
	 *
	 * @throws java.lang.Exception
	 */
	@Test(expected = Exception.class)
	public void testConfigureEmailWrongServer() throws Exception {
		String email = "lapr4_2dg@outlook.pt";
		String password = "LAPR42dg";
		String server = "smtp.google.com";
		instance.configureEmail(email, password, server);
	}

	/**
	 * Test of configureEmail method, of class EmailController.
	 */
	@Test
	public void testConfigureEmail() throws Exception {
		String email = "lapr4_2dg@outlook.pt";
		String password = "LAPR42dg";
		String server = "smtp.live.com";
		Email result = instance.configureEmail(email, password, server);
		assertNotEquals(null, result);
	}

	/**
	 * Test of sendEmail method, of class EmailController.
	 */
	@Test
	public void testSendEmail() throws Exception {
		String email = "lapr4_2dg@outlook.pt";
		String password = "LAPR42dg";
		String server = "smtp.live.com";
		Email mail = instance.configureEmail(email, password, server);
		String to = "lapr4_2dg@outlook.pt";
		String subject = "Unit test";
		String body = "Unit test";
		instance.sendEmail(mail, to, subject, body);
	}
}
