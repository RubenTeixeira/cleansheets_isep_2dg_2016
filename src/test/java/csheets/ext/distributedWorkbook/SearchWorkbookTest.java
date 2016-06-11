package csheets.ext.distributedWorkbook;

import csheets.AppSettings;
import csheets.ext.distributedWorkbook.ui.TcpService;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 * @author José Barros
 */
public class SearchWorkbookTest {

	TcpService tcpService = new TcpService();
	boolean hasRequested = false;

	/**
	 * Test of send request to another isntance.
	 */
	@Test
	public void testSendRequestToAnotherInstance() {
		// FIX THIS
		this.tcpService.server();
		tcpService.
			client("all:" + AppSettings.instance().get("TCP_PORT"), "request");

		assertFalse(hasRequested);
	}

	/**
	 * Test of setWorkbookToSearch method, of class SearchWorkbook.
	 */
	@Test
	public void testSetWorkbookToSearch() {
		// TODO
	}

	/**
	 * Test of result method, of class SearchWorkbook.
	 */
	@Test
	public void testResult() {
		//TODO
	}

	/**
	 * Test of findWorkbook method, of class SearchWorkbook.
	 */
	@Test
	public void testFindWorkbook() {
		//TODO
	}

	/**
	 * Test of searchDirectory method, of class SearchWorkbook.
	 */
	@Test
	public void testSearchDirectory() {
		//TODO
	}

	/**
	 * Test of getSummary method, of class SearchWorkbook.
	 */
	@Test
	public void testGetSummary() {
		//TODO
	}

	/**
	 * Test of displaySummary method, of class SearchWorkbook.
	 */
	@Test
	public void testDisplaySummary() {
		//TODO
	}

}
