package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class MyTextField extends JTextField {
	Font font = new Font("Comic Sans MS", Font.BOLD, 14);

	public MyTextField()
	{
		setOpaque(false);
		setFont(font);
		setForeground(new Color(255, 255, 255));

		setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(52, 73, 94)));
		setFocusListner();


	}


	private void setFocusListner(){
		addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(52, 73, 94)));

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,new Color(62, 73, 94)));

			}
		});

	}




}
