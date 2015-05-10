package components;

import java.awt.Color;

import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class MyTransparentButton extends JButton {

	public MyTransparentButton() {
		super();
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(new Color(255, 255, 255));

	}

	public MyTransparentButton(String toolTip, ImageIcon imageIcon) {
		super();
		setBorderPainted(false);
		setToolTipText(toolTip);

		setOpaque(false);
		setContentAreaFilled(false);
		setIcon(imageIcon);
		setFocusPainted(false);
		setCustomListener();
		setForeground(new Color(255, 255, 255));

	}

	public MyTransparentButton(String string) {
		super(string);
		setBorderPainted(false);

		setOpaque(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setCustomListener();
		setForeground(new Color(255, 255, 255));
	}

	/**
	 * 
	 */
	public void setCustomListener() {
		getModel().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				ButtonModel model = (ButtonModel) e.getSource();
				if (model.isRollover()) {
					setBorderPainted(true);
				} else {
					setBorderPainted(false);
				}
			}
		});
	}

}
