package containers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import misc.Contact;
import components.MyLabel;
import components.MyPanel;
import components.MyTransparentButton;


/**
 * @author  Jmoulin
 */
@SuppressWarnings("serial")
public class PanelContacts extends MyPanel {

	private ArrayList <Contact> listContact = new ArrayList<Contact>();
	private MyTransparentButton bajoutContacts= new MyTransparentButton("+");

	public PanelContacts(MyPanel mypanel,int marginW,int marginH){
		super(mypanel,marginW,marginH);

		setLayout(new BorderLayout());
		for(int i = 0; i < 10; i ++)
		{
			Contact c = new Contact();
			c.setNom("Moulin" + (int)(Math.random() * 10)+1);
			c.setPrenom("Jonathan");
			c.setImage("imagesContact/user.png");
			listContact.add(c);
			System.out.println(c.getImage() + " " +c.getNom());
		}

		Collections.sort(listContact);



		DefaultListModel<Contact> model = new DefaultListModel<Contact>();
		for(Contact c : listContact)
			model.addElement(c);
		JList<Contact> list = new JList<Contact>(model);
		list.setCellRenderer(new ContactListRenderer());

		JScrollPane scroll = new JScrollPane(list);
		setOpaque(false);
		scroll.setOpaque(false);
		list.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(new EmptyBorder(0,0,0,0));
		JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isVisible() {
				return true;
			}
		};

		scroll.setVerticalScrollBar(scrollBar);
		JScrollBar vertical = scroll.getVerticalScrollBar();
		vertical.setPreferredSize( new Dimension(0,0) );
		vertical.setUnitIncrement(32);

		Collections.sort(listContact);

		add(scroll,BorderLayout.CENTER);
		add(bajoutContacts, BorderLayout.NORTH);
		bajoutContacts.setActionCommand("ajoutc");
	}

	private class ContactListRenderer extends DefaultListCellRenderer {

		private static final long serialVersionUID = 1L;
		Font font = new Font("Comic Sans MS", Font.BOLD, 18);

		@SuppressWarnings("rawtypes")
		@Override
		public Component getListCellRendererComponent(
				JList list, Object value, int index,
				boolean isSelected, boolean cellHasFocus) {
			JLabel  l = (JLabel)super.getListCellRendererComponent(
					list, "    "+((Contact)value).getNom() + " " + ((Contact)value).getPrenom(), index, isSelected, cellHasFocus);

			JPanel panel2 = new JPanel();
			panel2.setOpaque(false);
			l.setOpaque(false);
			l.setForeground(new Color(52, 73, 94));

			l.setIcon(new ImageIcon(((Contact) value).getImage()));
			l.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(52, 73, 94)));


			l.setHorizontalTextPosition(MyLabel.LEFT);
			l.setFont(font);
			panel2.add(l);
			return panel2;
		}
	}
	
	

	public MyTransparentButton getBajoutContacts() {
		return bajoutContacts;
	}

	public void setBajoutContacts(MyTransparentButton bajoutContacts) {
		this.bajoutContacts = bajoutContacts;
	}
}
