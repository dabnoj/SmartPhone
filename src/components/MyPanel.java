package components;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author  Jmoulin
 */
@SuppressWarnings("unused")
public class MyPanel extends JPanel {

	
	private JFrame frame;
	/**
	 * @uml.property  name="myPanel"
	 * @uml.associationEnd  
	 */
	private Box myPanel;
	private int componentW;
	private int componentH;
	private int marginW;
	private int marginH;
	private Box box;


	public MyPanel(Box myPanel, int marginW, int marginH){
		box = createBox(this);
		this.myPanel = myPanel;
		this.marginH = marginH;
		this.marginW = marginW;
		this.componentW = myPanel.getWidth();
		this.componentH = myPanel.getHeight();
		setOpaque(false);

	}


	public MyPanel(JFrame frame, int marginW, int marginH){
		this.frame = frame;
		box = createBox(this);
		this.marginH = marginH;
		this.marginW = marginW;
		this.componentW = frame.getWidth();
		this.componentH = frame.getHeight();
		setOpaque(false);

	}

	private static final long serialVersionUID = 1L;

	@Override
	public Dimension getMinimumSize() {
		
		return new Dimension(componentW -marginW, componentH -marginH);
	}

	@Override
	public Dimension getMaximumSize() {
		return new Dimension(componentW -marginW, componentH -marginH);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(componentW -marginW, componentH - marginH);
	}
	
	
	
	public Box getBox() {
		return box;
	}


	public void setBox(Box box) {
		this.box = box;
	}


	public static Box createBox(JPanel panel) {
		Box box = new Box(BoxLayout.Y_AXIS);
		box.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		box.add(Box.createVerticalGlue());
		box.add(panel);
		box.add(Box.createVerticalGlue());
		return box;
	}
	
	


}
