package csheets.ext.importExportData.ui;

import csheets.core.Cell;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.importExportData.FileHandler;
import csheets.ui.ctrl.UIController;
import java.util.Map;

public class ShareTextFileController {

	/**
	 * The UDP Service.
	 */
	private UdpService udpService;

	/**
	 * The TCP Service.
	 */
	private TcpService tcpService;

	/**
	 *
	 * @param path path of the file
	 * @return
	 */
	public String importFile(String path) {
		FileHandler fh = new FileHandler();
		return fh.getFileContents(path);
	}

	public void parse(String content, String separator, boolean header,
					  Cell[][] cells) throws FormulaCompilationException {
		String[] lines = content.split("\n");
		int k = 0;
		if (header == true) {
			cells[0][0].setContent(lines[0]);
			k++;
			int r = cells[0][0].getAddress().getRow();
			int c = cells[0][0].getAddress().getColumn();
			Cell cell = cells[0][0].getSpreadsheet().getCell(c, r + 1);
			for (int i = 1; i < lines.length; i++) {
				String[] col = lines[i].split(separator);
				for (int j = 0; j < col.length; j++) {
					cell.setContent(content);
					int column = cell.getAddress().getColumn() + 1;
					int row = cell.getAddress().getRow();
					cell = cell.getSpreadsheet().getCell(column, row);
				}
				cell = cell.getSpreadsheet().getCell(c, cell.getAddress().
													 getRow() + 1);
			}
		} else {
			/*for (int i = 0; i < cells.length; i++) {
			 for (int j = 0; j < cells[0].length; j++) {
			 cells[i][j].setContent(c[k]);
			 k++;
			 }
			 }*/
		}

	}

	public boolean exportFile(String content, String filename, Cell[][] cells) {
		FileHandler fh = new FileHandler();
		if (fh.createFile(filename)) {
			return fh.append(filename, content);
		}
		return false;
	}

	/**
	 * Starts the UDP service.
	 *
	 * @param port The target port that is defined by the user.
	 * @param seconds The number of seconds to execute each request.
	 */
	private void startUdpService(int port, int seconds) {
		if (port < 0 || port > 49151) {
			throw new IllegalArgumentException("Invalid port was defined. Please select a valid port.");
		}

		if (seconds <= 0) {
			throw new IllegalArgumentException("Invalid seconds number given. It's not possible to register negative or zero seconds.");
		}

		try {
			this.udpService.server(30603, port);
			this.udpService.client(seconds);
		} catch (IllegalArgumentException e) {
			this.udpService.stop();

			throw e;
		}
	}

	/**
	 * Starts the UDP service.
	 *
	 * @param panel The user interface.
	 * @param port The target port that is defined by the user.
	 * @param seconds The number of seconds to execute each request.
	 */
	public void startUdpService(SharePanel panel, int port, int seconds) {
		if (panel == null) {
			throw new IllegalArgumentException("The user interface cannot be null.");
		}

		this.udpService = new UdpService();

		this.startUdpService(port, seconds);

		this.udpService.addObserver(panel);
	}

	/**
	 * Starts the TCP service.
	 *
	 * @param port The target port that is defined by the user.
	 */
	private void startTcpService(int port) {
		if (port < 0 || port > 49151) {
			throw new IllegalArgumentException("Invalid port was defined. Please select a valid port.");
		}

		try {
			this.tcpService.server(port);

		} catch (IllegalArgumentException e) {
			this.tcpService.stop();

			throw e;
		}
	}

	/**
	 * Starts the TCP service.
	 *
	 * @param panel The user interface.
	 * @param port The target port that is defined by the user.
	 */
	public void startTcpService(SharePanel panel, int port) {
		if (panel == null) {
			throw new IllegalArgumentException("The user interface cannot be null.");
		}

		this.tcpService = new TcpService();

		this.startTcpService(port);

		this.tcpService.addObserver(panel);
	}

	/**
	 * Restarts both the UDP and TCP services.
	 *
	 * @param port The target port that is defined by the user.
	 * @param seconds The number of seconds to execute each request.
	 */
	public void restartServices(int port, int seconds) {
		this.tcpService.stop();
		this.udpService.stop();

		this.startUdpService(port, seconds);
		this.startTcpService(port);
	}

	/**
	 * Sends a array of Cells to the targeted host.
	 *
	 * @param target Targeted Host (ip and port)
	 * @param cells Selected Cells
	 */
	public void sendCells(String target, Cell[][] cells) {
		String message = "";

		int lines = cells.length;
		int columns = cells[0].length;

		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < columns; j++) {
				Cell cell = cells[i][j];
				message += ";" + cell.getAddress().getColumn() + ";" + cell.
					getAddress().getRow() + ";" + cell.getValue().getType() + ";" + cell.
					getValue().toString();
			}
		}

		message = message.substring(1);

		new TcpService().client(target, message);
	}

	/**
	 * Updates the active spreadsheet with the received cells.
	 *
	 * @param ui The user interface controller.
	 * @param cells Received cells information.
	 * @throws csheets.core.formula.compiler.FormulaCompilationException Cells
	 * can have the wrong value.
	 */
	public void updateCells(UIController ui, Map<String, String> cells) throws FormulaCompilationException {
		for (Map.Entry<String, String> entry : cells.entrySet()) {
			String[] addressData = entry.getKey().split(":");
			int column = Integer.parseInt(addressData[0]);
			int row = Integer.parseInt(addressData[1]);

			try {
				String value = "";
				String[] valueData = entry.getValue().split(";");

				if (valueData.length > 1) {
					value = valueData[1];
				} else {
					value = "";
				}

				ui.getActiveSpreadsheet().getCell(column, row).setContent(value);
			} catch (FormulaCompilationException ex) {
				throw new FormulaCompilationException();
			}
		}
	}
}