package components;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MyLabel extends JLabel {

	public MyLabel() {
		super();
		setForeground(new Color(52, 73, 94));
	}

	public MyLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		setForeground(new Color(255, 255, 255));
	}

	public MyLabel(Icon image) {
		super(image);
		setForeground(new Color(255, 255, 255));
	}

	public MyLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		setForeground(new Color(255, 255, 255));
		// TODO Auto-generated constructor stub
	}

	public MyLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		setForeground(new Color(52, 73, 94));
		// TODO Auto-generated constructor stub
	}

	public MyLabel(String text) {
		super(text);
		setForeground(new Color(255, 255, 255));
		// TODO Auto-generated constructor stub
	}
	
	

}
