/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.support;

import csheets.ui.ctrl.UIController;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Marcelo Barroso 1131399
 */
public final class Converter {

	static private UIController controller;

	/*
	private Converter() {
	}

	static public Image getImage(byte[] bytes) throws IOException {
		InputStream in = new ByteArrayInputStream(bytes);
		BufferedImage bImageFromConvert = ImageIO.read(in);
		ImageIO.write(bImageFromConvert, "png", new File("photo.jpg"));
		return bImageFromConvert;
	}

	static public byte[] setImage(File selectedFile) throws IOException {
		ByteArrayOutputStream baos;
		ImageIcon imagem = new ImageIcon(selectedFile.getAbsolutePath());
		BufferedImage bfimg = ImageIO.read(selectedFile);
		baos = new ByteArrayOutputStream();
		ImageIO.write(bfimg, "png", baos);
		return baos.toByteArray();
	}
	 */
	public Image getImage(byte[] bytes) throws IOException {
		InputStream in = new ByteArrayInputStream(bytes);
		BufferedImage bImageFromConvert = ImageIO.read(in);
		ImageIO.write(bImageFromConvert, "png", new File("photo.jpg"));
		return bImageFromConvert;
	}

	public byte[] setImage(File selectedFile) throws IOException {
		ByteArrayOutputStream baos;
		ImageIcon imagem = new ImageIcon(selectedFile.getAbsolutePath());
		BufferedImage bfimg = ImageIO.read(selectedFile);
		baos = new ByteArrayOutputStream();
		ImageIO.write(bfimg, "png", baos);
		return baos.toByteArray();
	}

	public static UIController controller() {
		return Converter.controller;
	}

	public static void controller(UIController controller) {
		Converter.controller = controller;
	}

}
