package gui;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Utils {

	public static String getFileExtension(String name) {

		int pointIndex = name.lastIndexOf(".");

		if (pointIndex == -1) { // does not exist
			return null;
		}

		if (pointIndex == name.length() - 1) { // . is the end of string
			return null;
		}

		return name.substring(pointIndex + 1, name.length()); // string between
																// first
																// character
																// after dot to
																// the end
	}

	// Loading images
	public static ImageIcon createIcon(String path) {

		URL url = System.class.getResource(path);

		if (url == null) {
			// JOptionPane.showMessageDialog(Toolbar.this, "Unable to load
			// resuroce: " + path,"Icon problem",
			// JOptionPane.ERROR_MESSAGE);
		}
		ImageIcon icon = new ImageIcon(url);
		return icon;
	}
}
