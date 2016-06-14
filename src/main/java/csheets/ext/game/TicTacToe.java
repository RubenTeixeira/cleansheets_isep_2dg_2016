/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game;

import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.ext.SpreadsheetExtension;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.UIController;

/**
 * Dummy Class
 *
 * @author João Martins
 */
public class TicTacToe extends SpreadsheetExtension {

	private UIController uiController;

	/**
	 * The base of the titles of new spreadsheets
	 */
	public static final String BASE_TITLE = "Sheet ";

	/**
	 * The workbook to which the spreadsheet belongs
	 */
	private Workbook workbook;

	public TicTacToe(Spreadsheet sheet) {
		super(sheet, StyleExtension.NAME);
	}

//	public void addNewWorkbook() {
//
//		Workbook workBook = new Workbook(1);
//		Spreadsheet spreadSheet = workBook.getSpreadsheet(0);
//		String[][] content = new String[2][2];
////		Cell cell;// = spreadSheet.getCell(0, 0);
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
////				spreadSheet.getCell(i, j);
//				content[i][j] = "";
//			}
//		}
//	}
//	public void addNewSpreadsheet() {
//		Workbook activeWorkbook = this.uiController.getActiveWorkbook();
//
//		String name = "TicTacToe";
//		String[][] content = new String[2][2];
//
//		Spreadsheet sheet2 = activeWorkbook.getSpreadsheet(0).getExtension(name);
//		//SpreadsheetExtension sheetExt = activeWorkbook.getSpreadsheet(0);
////		String[][] content = new String[2][2];
////		for (int i = 0; i < 3; i++) {
////			for (int j = 0; j < 3; j++) {
////				content[i][j] = "";
////			}
////		}
////		Spreadsheet sheet2 = activeWorkbook
////		Spreadsheet sheet = activeWorkbook.getSpreadsheet(activeWorkbook.
////			getSpreadsheetCount() - 1);
////		sheet.setTitle("");
////		SpreadsheetTable sst = new SpreadsheetTable(sheet, uiController);
////
////		activeWorkbook.addSpreadsheet(content);
////		uiController.focusOwner = sst;
//
//	}
	/**
	 * Tic Tac Toe designation.
	 *
	 * @return "TIC-TAC-TOE"
	 */
	@Override
	public String toString() {
		return "TIC-TAC-TOE";
	}

//	@Override
//	public Workbook getWorkbook() {
//		return this.uiController.getActiveWorkbook();
//	}
//
//	@Override
//	public String getTitle() {
//		return this.title;
//	}
//
//	@Override
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	@Override
//	public int getColumnCount() {
//		return this.columns;
//	}
//
//	@Override
//	public int getRowCount() {
//		return this.rows;
//	}
//
//	@Override
//	public Cell getCell(Address address) {
//		// Updates spreadsheet dimensions
//		if (address.getRow() > rows) {
//			rows = address.getRow();
//		}
//		if (address.getColumn() > columns) {
//			columns = address.getColumn();
//		}
//
//		// Looks for a previously used cell with this address
//		Cell cell = cells.get(address);
//
//		// If the cell has never been requested, create a new one
//		if (cell == null) {
//			cell = new CellImpl(this, address);
//			cell.addCellListener(eventForwarder);
//			cells.put(address, cell);
//		}
//		return cell;
//	}
//
//	@Override
//	public Cell getCell(int column, int row) {
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//	}
//
//	@Override
//	public SortedSet<Cell> getCells(Address address1, Address address2) {
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//	}
//
//	@Override
//	public Cell[] getColumn(int index) {
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//	}
//
//	@Override
//	public Cell[] getRow(int index) {
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//	}
//
//	@Override
//	public void addCellListener(CellListener listener) {
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//	}
//
//	@Override
//	public void removeCellListener(CellListener listener) {
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//	}
//
//	@Override
//	public CellListener[] getCellListeners() {
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//	}
//
//	@Override
//	public Iterator<Cell> iterator() {
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//	}
//
//	/**
//	 * A cell listener that forwards events from all cells to registered
//	 * listeners.
//	 */
//	private class EventForwarder implements CellListener {
//
//		/**
//		 * Creates a new event forwarder.
//		 */
//		public EventForwarder() {
//		}
//
//		public void valueChanged(Cell cell) {
//			for (CellListener listener : cellListeners) {
//				listener.valueChanged(cell);
//			}
//		}
//
//		public void contentChanged(Cell cell) {
//			for (CellListener listener : cellListeners) {
//				listener.contentChanged(cell);
//			}
//		}
//
//		public void dependentsChanged(Cell cell) {
//			for (CellListener listener : cellListeners) {
//				listener.dependentsChanged(cell);
//			}
//		}
//
//		public void cellCleared(Cell cell) {
//			for (CellListener listener : cellListeners) {
//				listener.cellCleared(cell);
//			}
//		}
//
//		public void cellCopied(Cell cell, Cell source) {
//			for (CellListener listener : cellListeners) {
//				listener.cellCopied(cell, source);
//			}
//		}
//	}
//
//	/*
//	 * EXTENSIONS
//	 */
//	@Override
//	public Spreadsheet getExtension(String name) {
//		// Looks for an existing spreadsheet extension
//		SpreadsheetExtension extension = extensions.get(name);
//		if (extension == null) {
//			// Creates a new spreadsheet extension
//			Extension x = ExtensionManager.getInstance().getExtension(name);
//			if (x != null) {
//				extension = x.extend(this);
//				if (extension != null) {
//					extensions.put(name, extension);
//				}
//			}
//		}
//		return extension;
//	}
//
//	/*
//	 * GENERAL
//	 */
//	/**
//	 * Customizes deserialization by catching exceptions when extensions are not
//	 * found.
//	 *
//	 * @param stream the object input stream from which the object is to be read
//	 * @throws IOException If any of the usual Input/Output related exceptions
//	 * occur
//	 * @throws ClassNotFoundException If the class of a serialized object cannot
//	 * be found.
//	 */
//	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
//		stream.defaultReadObject();
//
//		// Sets up event forwarder
//		eventForwarder = new EventForwarder();
//		for (Cell cell : cells.values()) {
//			cell.addCellListener(eventForwarder);
//		}
//		cellListeners = new ArrayList<CellListener>();
//
//		// Reads extensions
//		extensions = new HashMap<String, SpreadsheetExtension>();
//		int extCount = stream.readInt();
//		for (int i = 0; i < extCount; i++) {
//			try {
//				SpreadsheetExtension extension = (SpreadsheetExtension) stream.
//					readObject();
//				extensions.put(extension.getName(), extension);
//			} catch (ClassNotFoundException e) {
//				System.err.println(e);
//			}
//		}
//	}
//
//	/**
//	 * Customizes serialization, by writing extensions separately.
//	 *
//	 * @param stream the object output stream to which the object is to be
//	 * written
//	 * @throws IOException If any of the usual Input/Output related exceptions
//	 * occur
//	 */
//	private void writeObject(ObjectOutputStream stream) throws IOException {
//		stream.defaultWriteObject();
//
//		// Writes extensions
//		stream.writeInt(extensions.size());
//		for (SpreadsheetExtension extension : extensions.values()) {
//			stream.writeObject(extension);
//		}
//	}
}
