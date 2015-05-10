package containers;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

import components.MyLabel;
import components.MyPanel;
import components.MyTextField;
import components.MyTransparentButton;

@SuppressWarnings("serial")
public class PanelContactList extends MyPanel {

	//buttons
	private MyTransparentButton buttonAjouter = new MyTransparentButton();
	private MyTransparentButton buttonAnnuler = new MyTransparentButton("reset Fields");
	private MyTransparentButton buttonSwitchePanel = new MyTransparentButton("go to contact Pan");
	private ImageIcon iconePhotoProfil = new ImageIcon("imagesContact/user.png");
	private MyTransparentButton buttonPhotoProfil = new MyTransparentButton("Photo",iconePhotoProfil);

	//labels
	private MyLabel labelAddresse = new MyLabel( "Adresse");
	private MyLabel labelGroup = new MyLabel( "Groupe");
	private MyLabel labelMail = new MyLabel( "Adresse Mail");
	private MyLabel labelNom = new MyLabel( "Nom");
	private MyLabel labelPrenom = new MyLabel( "Prénom");
	private MyLabel telPortable1 = new MyLabel( "Numéro mobile");

	//panels
	private final JPanel panelCentre = new JPanel();
	private final JPanel panelNord = new JPanel();
	private final JPanel panelSud = new JPanel();
	private JPanel panelCentre1 = new JPanel(new BorderLayout());


	//textField
	private MyTextField textFieldAdresse = new MyTextField();
	private MyTextField textFieldEmail = new MyTextField();
	private MyTextField textFieldPrenom = new MyTextField();
	private MyTextField textFieldGroupe = new MyTextField();
	private MyTextField textFieldName = new MyTextField();
	private MyTextField textFieldPrivatePhone = new MyTextField();
	//textFieldList
	private List<JTextField> textFieldList = new ArrayList<JTextField>();

	/**
	 * constructor
	 * @param myPanel to get the sizes 
	 * @param marginW
	 * @param marginH
	 */
	public PanelContactList(MyPanel myPanel, int marginW, int marginH) {
		super(myPanel, marginW, marginH);
		setLayout(new BorderLayout());
		panelCentre1.setOpaque(false);
		panelCentre.setLayout( new GridLayout(7, 2,0,15));
		panelCentre1.add(panelCentre);
		panelCentre.setOpaque(false);
		panelNord.setOpaque(false);
		panelSud.setOpaque(false);
		buttonPhotoProfil.setContentAreaFilled(false);

		//ajout des texfields dans l'arrayList
		textFieldList.add(textFieldAdresse);
		textFieldList.add(textFieldEmail);
		textFieldList.add(textFieldPrenom);
		textFieldList.add(textFieldGroupe);
		textFieldList.add(textFieldName);
		textFieldList.add(textFieldPrivatePhone);
		
		//panel nord
		panelNord.add(buttonPhotoProfil);
		//panel central
		panelCentre.add(labelNom);
		panelCentre.add(textFieldName);
		panelCentre.add(labelPrenom);
		panelCentre.add(textFieldPrenom);
		panelCentre.add(labelMail);
		panelCentre.add(textFieldEmail);
		panelCentre.add(labelAddresse);
		panelCentre.add(textFieldAdresse);
		panelCentre.add(labelGroup);
		panelCentre.add(textFieldGroupe);
		panelCentre.add(telPortable1);
		panelCentre.add(textFieldPrivatePhone);
		//panel sud
		panelSud.add(buttonAjouter);
		panelSud.add(buttonAnnuler);
		panelSud.add(buttonSwitchePanel);

		add(panelNord, BorderLayout.NORTH);
		add(panelCentre1, BorderLayout.CENTER);
		add(panelSud, BorderLayout.SOUTH);
		
		//ajout listener annuler
		buttonAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				resetTextField(textFieldList);
			}
		});
		
		
	}
	
	
	
	public void resetTextField(List<JTextField> list){
		for(JTextField tf : list)
			tf.setText("");
	}
	
	public MyTransparentButton getButtonSwitchePanel() {
		return buttonSwitchePanel;
	}	
}


