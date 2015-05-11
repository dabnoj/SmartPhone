package containers;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import misc.Clock;
import components.MyLabel;
import components.MyPanel;
import components.MyTransparentButton;



@SuppressWarnings("serial")
public class Frame extends JFrame {

	private int posX = 0;
	private int posY = 0;
	private boolean inverted = false;

	//panneaux personnalisés
	private MyPanel panelCard;
	private PanelHome panelHome;
	private PanelContactList panelContact;
	private PanelContacts panelContactList;
	private PanelBrowserApp panelFacebook;
	private PanelBrowserApp panelTwitter;
	private PanelBrowserApp panelWiki;
	private PanelBrowserApp panelGmail;
	private PanelBrowserApp panelInternet;
	private PanelBrowserApp panelRadio;
	private PanelBrowserApp panelMeteo;


	//boxs relatifs à chaque Panel
	
	//panneaux de base (servant à la mise en forme du Frame)
	private JPanel panelNorth = new JPanel(new GridLayout(1, 3));
	private JPanel panelSouth = new JPanel();
	private JPanel panelBrand = new JPanel();

	//bouton Home
	private MyTransparentButton buttonHome = new MyTransparentButton("Home",new ImageIcon(
			"SmartPhoneImages/home.png"));

	//labels personnalisés
	private MyLabel labelBattery = new MyLabel(new ImageIcon(
			"SmartPhoneImages/battery.png"));
	private final MyLabel labelClock = new MyLabel("");
	private final MyLabel labelBrand = new MyLabel("Samsung");

	//instance de la classe clock
	private Clock clock = new Clock(labelClock);

	public Frame(final int width,final int height) {
		// set visible ici
		setResizable(false);
		// taille de la frame,bordures et couleur + misc
		setSize(width, height);
		panelNorth.setBorder(new EmptyBorder(15, 25, 0, 25));
		setUndecorated(true);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), 
				getHeight(), 25,25));
		getContentPane().setBackground(new Color(0,0,0));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ajout du drag and drop (sur mouse et mouseMotion #logicalRulez)
		addMouseListener(new DragAndDropListener());
		addMouseMotionListener(new DragAndDropListener());

		labelBrand.setForeground(Color.WHITE);

		// regler la batterie a droite
		labelBattery.setHorizontalAlignment(SwingConstants.RIGHT);

		// ajout et reglage des Jcomponents dans le southPanel
		panelSouth.setOpaque(false);
		panelSouth.add(buttonHome);
		panelCard = new MyPanel(this,50,69);
		panelCard.setLayout(new BorderLayout());

		// reglage horloge
		setClock();
		labelClock.setForeground(new Color(52, 73, 94));
		panelNorth.add(labelClock);
		// trailing space
		panelNorth.add(new MyLabel());
		panelNorth.add(labelBattery);
		panelNorth.setOpaque(false);
		panelBrand.add(labelBrand);
		panelBrand.setOpaque(false);
		// set mainPanel (background et position)

		panelCard.setBackground(new Color(50, 54, 85));
		panelCard.setOpaque(true);
		// ajout dans le content pane
		getContentPane().add(BorderLayout.CENTER, panelCard.getBox());
		getContentPane().add(BorderLayout.SOUTH, panelSouth);
		getContentPane().add(BorderLayout.NORTH, panelBrand);
		// set visible avant de choper longeur largeur des panel -> sinon null
		setVisible(true);

		//instanciation des différents Panels
		panelHome = new PanelHome(panelCard.getBox(), 25, 100);
		panelInternet = new PanelBrowserApp(panelCard.getBox(), 0, 0);
		panelContactList = new PanelContacts(panelCard.getBox(), 125, 100);
		panelContact  = new PanelContactList(panelCard.getBox(), 125, 100);
		panelFacebook = new PanelBrowserApp(panelCard.getBox(), 0, 0);
		panelTwitter = new PanelBrowserApp(panelCard.getBox(), 0, 0);
		panelWiki = new PanelBrowserApp(panelCard.getBox(), 0, 0);
		panelGmail = new PanelBrowserApp(panelCard.getBox(), 0, 0);
		panelRadio = new PanelBrowserApp(panelCard.getBox(), 0, 0);
		panelMeteo = new PanelBrowserApp(panelCard.getBox(), 0, 0);

		//instanctiation des box via la méthode createBox
		
		//ajout des Components dans les Panels correspondants
		//set invisible pour les panel contact et contacts		
		panelCard.add(panelHome.getBox(),BorderLayout.CENTER);
		panelCard.add(panelNorth,BorderLayout.PAGE_START);
		//reglage des listener
		EcouteurBouton ecouteurBouton = new EcouteurBouton();
		panelHome.getButtonContact().addActionListener(ecouteurBouton);
		panelHome.getButtonContact().setActionCommand("contacts");		
		panelContactList.getBajoutContacts().addActionListener(ecouteurBouton);
		panelContactList.getBajoutContacts().setActionCommand("ajoutContact");		
		panelContact.getButtonSwitchePanel().addActionListener(ecouteurBouton);
		panelContact.getButtonSwitchePanel().setActionCommand("retourPanneauContact");
		panelHome.getButtonFacebook().addActionListener(ecouteurBouton);
		panelHome.getButtonFacebook().setActionCommand("Facebook");
		panelHome.getButtonTwitter().addActionListener(ecouteurBouton);
		panelHome.getButtonTwitter().setActionCommand("Twitter");
		panelHome.getButtonWiki().addActionListener(ecouteurBouton);
		panelHome.getButtonWiki().setActionCommand("Wiki");
		panelHome.getButtonGmail().addActionListener(ecouteurBouton);
		panelHome.getButtonGmail().setActionCommand("Gmail");
		panelHome.getButtonRadio().addActionListener(ecouteurBouton);
		panelHome.getButtonRadio().setActionCommand("Radio");
		panelHome.getButtonMeteo().addActionListener(ecouteurBouton);
		panelHome.getButtonMeteo().setActionCommand("Meteo");
		
		panelHome.getButtonInternet().addActionListener(ecouteurBouton);
		panelHome.getButtonInternet().setActionCommand("Internet");
		//regla du listener sur le boutton Home
		buttonHome.addActionListener(ecouteurBouton);
		buttonHome.setActionCommand("home");

		//ajout du lisnter double click sur la frame (portrait paysage)
		// à retravailler c'est un beta fait en 2mn
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {
					
						if(!inverted){
							dispose();
							Frame f = new Frame(900,500);
							f.inverted = true;
							
						}
						else{
							dispose();
							new Frame(500,900);
							
						}
					}
				
			}});

	}

	

	/**
	 * void method pour mettre la putain d'heure
	 */
	public void setClock() {
		Thread thread1 = new Thread(clock);
		thread1.start();
	}


	/**
	 * class pour permettre le drag and drop
	 * easy! peasy! take it easy
	 * 
	 * @author Jmoulin
	 *
	 */
	class DragAndDropListener extends MouseAdapter {
		@Override
		public void mouseDragged(final MouseEvent evt) {
			setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
		}

		@Override
		public void mousePressed(final MouseEvent evt) {
			posX = evt.getX();posY = evt.getY();
		}
	}


	class EcouteurBouton implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().equals("retourPanneauContact")) {
				panelNorth.setVisible(true);
				panelContactList.getBox().setVisible(true);
				panelCard.add(panelContactList.getBox());
				panelContact.getBox().setVisible(false);
				panelHome.getBox().setVisible(false);	
			}

			if (e.getActionCommand().equals("contacts")) {
				panelNorth.setVisible(true);
				panelContactList.getBox().setVisible(true);
				panelCard.add(panelContactList.getBox());
				panelHome.getBox().setVisible(false);
			}

			if (e.getActionCommand().equals("Facebook")) {
				panelNorth.setVisible(false);
				panelFacebook.getBox().setVisible(true);
				panelCard.add(panelFacebook.getBox());
				panelHome.getBox().setVisible(false);
				panelFacebook.LoadUrl("https://m.facebook.fr");

			}

			if (e.getActionCommand().equals("Twitter")) {
				panelNorth.setVisible(false);
				panelTwitter.getBox().setVisible(true);
				panelCard.add(panelTwitter.getBox());
				panelHome.getBox().setVisible(false);
				panelTwitter.LoadUrl("https://m.Twitter.com/fr");

			}

			if (e.getActionCommand().equals("Wiki")) {
				panelNorth.setVisible(false);
				panelWiki.getBox().setVisible(true);
				panelCard.add(panelWiki.getBox());
				panelHome.getBox().setVisible(false);
				panelWiki.LoadUrl("https://fr.m.wikipedia.org");

			}
			if (e.getActionCommand().equals("Gmail")) {
				panelNorth.setVisible(false);
				panelGmail.getBox().setVisible(true);
				panelCard.add(panelGmail.getBox());
				panelHome.getBox().setVisible(false);
				panelGmail.LoadUrl("http://m.Gmail.com");

			}

			if (e.getActionCommand().equals("home")) {
				panelNorth.setVisible(true);
				panelHome.getBox().setVisible(true);
				panelRadio.getBox().setVisible(false);
				panelTwitter.getBox().setVisible(false);
				panelWiki.getBox().setVisible(false);
				panelFacebook.getBox().setVisible(false);
				panelContact.getBox().setVisible(false);
				panelContactList.getBox().setVisible(false);
				panelGmail.getBox().setVisible(false);
				panelInternet.getBox().setVisible(false);
				panelMeteo.getBox().setVisible(false);

			}

			if (e.getActionCommand().equals("ajoutContact")) {
				panelNorth.setVisible(true);
				panelContact.getBox().setVisible(true);			
				panelCard.add(panelContact.getBox());
				panelHome.getBox().setVisible(false);
				panelContactList.getBox().setVisible(false);
			}

			if (e.getActionCommand().equals("Internet")) {
				panelNorth.setVisible(false);
				panelInternet.getBox().setVisible(true);
				panelCard.add(panelInternet.getBox());
				panelHome.getBox().setVisible(false);
				panelInternet.LoadUrl("google.fr");
			}
			if (e.getActionCommand().equals("Radio")) {
				panelNorth.setVisible(false);
				panelRadio.getBox().setVisible(true);
				panelCard.add(panelRadio.getBox());
				panelHome.getBox().setVisible(false);
				panelRadio.LoadUrl("www.internet-radio.com");
			}
			
			if (e.getActionCommand().equals("Meteo")) {
				panelNorth.setVisible(false);
				panelMeteo.getBox().setVisible(true);
				panelCard.add(panelMeteo.getBox());
				panelHome.getBox().setVisible(false);
				panelMeteo.LoadUrl("http://www.meteosuisse.admin.ch/home.html?tab=overview");
			}
		}
	}
}
