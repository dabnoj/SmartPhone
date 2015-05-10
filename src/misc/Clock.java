/*
 * 
 */
package misc;


import java.awt.Color;
import java.util.Calendar;

import javax.swing.JLabel;



public class Clock implements Runnable {

	

	private JLabel clockLabel;	
	private  String time; 

	
	public Clock(final JLabel clockLabel) {
		this.clockLabel = clockLabel;
		this.clockLabel.setForeground(Color.BLACK);
	}

	@Override
	public void run() {
		while (true)
			try {
				clockLabel.setText(timeNow());
				Thread.sleep(1000);
			} catch (final InterruptedException ex) {
				System.out.println(ex);
			}
	}

	public String timeNow() {
		final Calendar now = Calendar.getInstance();
		final int hrs = now.get(Calendar.HOUR_OF_DAY);
		final int min = now.get(Calendar.MINUTE);
		time =  zero(hrs) + ":" + zero(min);
		return time;
	}
	

	public String zero(final int num) {
		final String number = num < 10 ? "0" + num : "" + num;
		return number;
	}
}