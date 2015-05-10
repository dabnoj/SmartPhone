/**
 * BLABLA
 */

import javax.swing.SwingUtilities;

import containers.Frame;

public class TestSmartPhone {

	public static void main(String[] args) {

		Runnable r = new Runnable() {
			@Override
			public void run() {
				new Frame(550,900);
			}
		};
		SwingUtilities.invokeLater(r);

	}
}
