package containers;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import components.MyPanel;
import components.MyTransparentButton;

/**
 * @author  Jmoulin
 */
@SuppressWarnings("serial")
public class PanelHome extends MyPanel {

	//buttons !!! 
	
	private MyTransparentButton buttonContact = new MyTransparentButton("Contacts",
			new ImageIcon("smartPhoneImages/contact.png"));
	
	private MyTransparentButton buttonNote = new MyTransparentButton("Notes",
			new ImageIcon("smartPhoneImages/note.png"));
	
	private MyTransparentButton buttonCalendar = new MyTransparentButton("Calendrier",
			new ImageIcon("smartPhoneImages/calendar.png"));
	
	private MyTransparentButton buttonSettings = new MyTransparentButton("Configuration",
			new ImageIcon("smartPhoneImages/settings.png"));
	
	private MyTransparentButton buttonMessages = new MyTransparentButton("Messages",
			new ImageIcon("smartPhoneImages/message.png"));
	
	private MyTransparentButton buttonStore = new MyTransparentButton("Magasin",
			new ImageIcon("smartPhoneImages/playStore.png"));
	
	private MyTransparentButton buttonGmail = new MyTransparentButton("Gmail",
			new ImageIcon("smartPhoneImages/gmail.png"));
	
	private MyTransparentButton buttonTwitter = new MyTransparentButton("Twitter",
			new ImageIcon("smartPhoneImages/twitter.png"));
	
	private MyTransparentButton buttonFacebook = new MyTransparentButton("FaceBook",
			new ImageIcon("smartPhoneImages/facebook.png"));
	
	private MyTransparentButton buttonWiki = new MyTransparentButton("Wikipedia",
			new ImageIcon("smartPhoneImages/Wiki.png"));
	
	private MyTransparentButton buttonCamera = new MyTransparentButton("Camera",
			new ImageIcon("smartPhoneImages/camera.png"));
	
	private MyTransparentButton buttonRadio = new MyTransparentButton("Radio",
			new ImageIcon("smartPhoneImages/radio.png"));
	
	private MyTransparentButton buttonInternet = new MyTransparentButton("Internet",
			new ImageIcon("smartPhoneImages/internet.png"));
	
	private MyTransparentButton buttonPictures = new MyTransparentButton("Images",
			new ImageIcon("smartPhoneImages/pictures.png"));
	
	private MyTransparentButton buttonMeteo = new MyTransparentButton("Meteo",
			new ImageIcon("smartPhoneImages/meteo.png"));


	private JPanel panelCenter = new JPanel(new GridLayout(5, 3));

	public PanelHome(MyPanel panel, int marginW, int marginH) {
		super(panel, marginW, marginH);

		// premiere ligne
		panelCenter.add(buttonContact);
		panelCenter.add(buttonNote);
		panelCenter.add(buttonCalendar);

		// deuxieme ligne
		panelCenter.add(buttonSettings);
		panelCenter.add(buttonMessages);
		panelCenter.add(buttonCamera);

		// troisième ligne
		panelCenter.add(buttonStore);
		panelCenter.add(buttonGmail);
		panelCenter.add(buttonTwitter);

		// quatrieme ligne
		panelCenter.add(buttonFacebook);
		panelCenter.add(buttonWiki);
		panelCenter.add(buttonRadio);
		//cinquieme ligne
		panelCenter.add(buttonInternet);
		panelCenter.add(buttonPictures);
		panelCenter.add(buttonMeteo);


		setLayout(new BorderLayout());
		panelCenter.setOpaque(false);

		add(panelCenter, BorderLayout.CENTER);

	}

	public MyTransparentButton getButtonGmail() {
		return buttonGmail;
	}

	public MyTransparentButton getButtonMeteo() {
		return buttonMeteo;
	}

	public MyTransparentButton getButtonRadio() {
		return buttonRadio;
	}

	public MyTransparentButton getButtonContact() {
		return buttonContact;
	}

	public MyTransparentButton getButtonWiki() {
		return buttonWiki;
	}

	public MyTransparentButton getButtonFacebook() {
		return buttonFacebook;
	}

	public MyTransparentButton getButtonTwitter() {
		return buttonTwitter;
	}

	public MyTransparentButton getButtonInternet() {
		return buttonInternet;
	}
	
	
	
}
