package misc;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class SelectionneurImage {

	private int width, height;
	String name;

	public SelectionneurImage(int width, int height, String name) {
		this.width = width;
		this.height = height;
		this.name = name;
	}

	public boolean testDuplicate(ArrayList<Contact> contacts) {

		for (Contact c : contacts) {
			if (name.equals(c.getImage()))
				return false;
		}
		return true;
	}

	public String choixImage() {

		JFileChooser chooser = new JFileChooser();
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				BufferedImage originalImage = ImageIO.read(new File(""
						+ chooser.getSelectedFile()));
				
				int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB
						: originalImage.getType();
				
				BufferedImage resizeImageJpg = redimensionnerImage(
						originalImage, type, width, height);
				
				ImageIO.write(resizeImageJpg, "png", new File(
						"imagesContact/"
								+ chooser.getSelectedFile().getName()));
				
				return chooser.getSelectedFile().getName();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return "default.png";
	}

	private static BufferedImage redimensionnerImage(
			BufferedImage originalImage, int type, int width, int height) {
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		final Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();

		return resizedImage;
	}
}
