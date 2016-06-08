/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.conditionalFormatting.ui;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.Workbook;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ext.style.ui.BorderChooser;
import csheets.ext.style.ui.FontChooser;
import csheets.ext.style.ui.FormatChooser;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.awt.Font;
import java.text.Format;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.border.Border;

/**
 *
 * @author Diogo Leite
 */
public class ConditionalFormattingController {

	private UIController uiController;

	private boolean result;

	public ConditionalFormattingController(UIController uiController) {
		this.uiController = uiController;

	}

	public Cell createConditionalCell() {
		Workbook workbook = new Workbook(1);
		Spreadsheet spreadsheet = workbook.getSpreadsheet(0);
		return spreadsheet.getCell(0, 0);
	}

	public StylableCell createStylableCells(int nr) {
		Workbook workbook = new Workbook(1);
		Spreadsheet spreadsheet = workbook.getSpreadsheet(0);
		return (StylableCell) spreadsheet.getCell(0, nr).getExtension(
			StyleExtension.NAME);
	}

	public void apply(StylableCell style) {

		for (Cell[] row : this.uiController.focusOwner.getSelectedCells()) {
			for (Cell selectedCell : row) {
				StylableCell stylableCell = (StylableCell) selectedCell.
					getExtension(
						StyleExtension.NAME);
				stylableCell.setFont(style.getFont());
				stylableCell.setForegroundColor(style.
					getForegroundColor());
				stylableCell.setBackgroundColor(style.
					getBackgroundColor());
				stylableCell.setBorder(style.
					getBorder());
				stylableCell.setFormat(style.
					getFormat());
				stylableCell.setHorizontalAlignment(style.
					getHorizontalAlignment());
				stylableCell.setVerticalAlignment(style.
					getVerticalAlignment());
			}
		}

		uiController.setWorkbookModified(this.uiController.focusOwner.
			getSpreadsheet().getWorkbook());
		this.uiController.focusOwner.repaint();

	}

	public void changeFont(StylableCell theCell) {

		Font font = FontChooser.showDialog(
			null,
			"Choose Font",
			StylableCell.FONT);

		if (font != null) {
			theCell.setFont(font);
		}
	}

	public void changeForeground(StylableCell theCell) {

		Color color = JColorChooser.showDialog(
			null,
			"Choose Foreground Color",
			StylableCell.FOREGROUND);

		if (color != null) {
			theCell.setForegroundColor(color);
		}
	}

	public void changeBackground(StylableCell theCell) {

		Color color = JColorChooser.showDialog(
			null,
			"Choose Foreground Color",
			StylableCell.BACKGROUND);

		if (color != null) {
			theCell.setBackgroundColor(color);
		}
	}

	public void changeBorder(StylableCell theCell) {

		Border border = BorderChooser.showDialog(
			null,
			"Choose Border",
			StylableCell.BORDER);

		if (border != null) {
			theCell.setBorder(border);
		}
	}

	public void changeFormat(StylableCell theCell) {
		Format format = null;
		Date date = new Date();

		try {
			date = Value.parseDateValue("12/01/1996").toDate();
		} catch (ParseException | IllegalValueTypeException ex) {
			Logger.getLogger(ConditionalFormattingUI.class.getName()).
				log(Level.SEVERE, null, ex);
		}
		if (this.uiController.getActiveCell().getValue().getType() == Value.Type.NUMERIC) {
			format = new FormatChooser(
				StylableCell.NUMBER_FORMAT, 2
			).showDialog(null, "Choose Format");
		} else if (this.uiController.getActiveCell().getValue().getType() == Value.Type.DATE) {
			format = new FormatChooser(
				StylableCell.DATE_FORMAT, date
			).showDialog(null, "Choose Format");
		}

		if (format != null) {
			theCell.setFormat(format);
		}
	}

	public void changeHorizontalAlign(StylableCell theCell, int swing) {

		theCell.setHorizontalAlignment(swing);

	}

	public void changeVerticalAlign(StylableCell theCell, int swing) {

		theCell.setVerticalAlignment(swing);

	}

}
