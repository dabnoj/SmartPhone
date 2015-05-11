package containers;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JPanel;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserPreferences;
import com.teamdev.jxbrowser.chromium.PopupContainer;
import com.teamdev.jxbrowser.chromium.PopupHandler;
import com.teamdev.jxbrowser.chromium.PopupParams;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import components.MyPanel;
import components.MyTransparentButton;
import containers.Frame.DragAndDropListener;

@SuppressWarnings("serial")
public class PanelBrowserApp extends MyPanel {

	private Browser browser;
	private Browser browser2;
	private JPanel panelNorth;
	private MyTransparentButton buttonBack = new MyTransparentButton("<<<");
	private MyTransparentButton buttonForward = new MyTransparentButton(">>>");
	private MyTransparentButton buttonReturn = new MyTransparentButton("Return");
	private String URL;
	BrowserView browserViewLocal;
	BrowserView browserView;
	EcouteurNavigateur ecouteur = new EcouteurNavigateur();

	public PanelBrowserApp(Box myPanel, int marginW, int marginH) {
		super(myPanel, marginW, marginH);
	
		setLayout(new BorderLayout());
		panelNorth = new JPanel();
		panelNorth.add(buttonBack);
		buttonReturn.setVisible(false);
		panelNorth.add(buttonReturn);
		panelNorth.add(buttonForward);
		// very nice one //Mozilla/5.0 (Linux; Android 5.1; ro-ro; SAMSUNG
		// SM-G900F Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko)
		// Version/2.1 Chrome/34.0.1847.76 Mobile Safari/537.36
		// meilleur //Mozilla/5.0 (Linux; Android 5.1; Nexus 4 Build/LMY47O)
		// AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.109 Mobile
		// Safari/537.36
		// not bad // Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en)
		// AppleWebKit/525.18.1 (KHTML, like Gecko) Version/3.1.1 Iris/1.1.7
		// Safari/525.20
		// Mozilla/5.0 (Linux; U; Android 7.4.4; en-US; SM-G530H Build/KTU84P)
		// AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0
		BrowserPreferences
				.setUserAgent("Mozilla/5.0 (Linux; Android 5.1.1; Nexus 6 Build/LMY47V) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.111 Mobile Safari/537.36 ");
		browser = new Browser();

		panelNorth.setOpaque(false);
		panelNorth.setLayout(new GridLayout(1, 3));
		buttonBack.addActionListener(new EcouteurNavigateur());
		buttonBack.setActionCommand("back");
		buttonForward.addActionListener(new EcouteurNavigateur());
		buttonReturn.addActionListener(new EcouteurNavigateur());
		buttonReturn.setActionCommand("return");
		buttonForward.setActionCommand("forward");
		browserViewLocal = new BrowserView(browser);
		browserViewLocal.setOpaque(false);
		browser.setPopupHandler(new PopupHandler() {
			public PopupContainer handlePopup(PopupParams params) {
				return new PopupContainer() {
					public void insertBrowser(final Browser arg0,
							Rectangle initialBounds) {
						browser2 = arg0;
						browserView = new BrowserView(browser2);

						buttonReturn.setVisible(true);

						buttonBack.setVisible(false);
						buttonForward.setVisible(false);

						remove(browserViewLocal);
						add(BorderLayout.CENTER, browserView);
						getBox().revalidate();
						add(getBox(), BorderLayout.CENTER);
					}
				};
			}
		});
	
		add(BorderLayout.NORTH, panelNorth);
		panelNorth.setVisible(false);
		add(BorderLayout.CENTER, browserViewLocal);
		
	

		getBox().addMouseMotionListener(new DragAndDropListener());
		getBox().addMouseListener(new DragAndDropListener());
	}

	public void LoadUrl(String URL) {
		this.URL = URL;
		browser.loadURL(URL);
	}



	class EcouteurNavigateur implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().equals("back")) {
				if (!browser.isDisposed())
				browser.goBack();
			}

			if (e.getActionCommand().equals("forward")) {
				if (!browser.isDisposed())
				browser.goForward();
			}
			if (e.getActionCommand().equals("return")) {
				if (!browser2.isDisposed())
					browser2.loadURL(URL);

				browserViewLocal = new BrowserView(browser);

				remove(browserView);
				add(browserViewLocal);

				buttonReturn.setVisible(false);
				buttonBack.setVisible(true);
				buttonForward.setVisible(true);
				add(getBox(), BorderLayout.CENTER);
				getBox().revalidate();
				revalidate();
			}
		}
	}
	
	class DragAndDropListener extends MouseAdapter {
		
		@Override
		public void mouseMoved(MouseEvent evt) {
			System.out.println("evtX " + evt.getX() + " screenX " + getX());
			System.out.println("evtY " + evt.getY() + " screenX " + getY());
			if((evt.getY() < getY() + 20))
				panelNorth.setVisible(true);
			else
				panelNorth.setVisible(false);
		}
		
		
	}
}
