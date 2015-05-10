package containers;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserPreferences;
import com.teamdev.jxbrowser.chromium.PopupContainer;
import com.teamdev.jxbrowser.chromium.PopupHandler;
import com.teamdev.jxbrowser.chromium.PopupParams;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import components.MyPanel;
import components.MyTransparentButton;

@SuppressWarnings("serial")
public class PanelBrowserApp extends MyPanel{


	private Browser browser;
	private Browser browser2;
	private JPanel panelNorth;
	private MyTransparentButton buttonBack = new MyTransparentButton("<<<");
	private MyTransparentButton buttonForward = new MyTransparentButton(">>>");
	private MyTransparentButton buttonReturn = new MyTransparentButton("Return");
	private String URL;
	private MyPanel parent;
	BrowserView browserViewLocal;
	BrowserView browserView;
	EcouteurNavigateur ecouteur = new EcouteurNavigateur();


	public PanelBrowserApp(final MyPanel myPanel, int marginW, int marginH) {
		super(myPanel, marginW, marginH);
		parent = myPanel;
		setLayout(new BorderLayout());
		panelNorth = new JPanel();
		panelNorth.add(buttonBack);
		buttonReturn.setVisible(false);
		panelNorth.add(buttonReturn);
		panelNorth.add(buttonForward);
		//very nice one //Mozilla/5.0 (Linux; Android 5.1; ro-ro; SAMSUNG SM-G900F Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Version/2.1 Chrome/34.0.1847.76 Mobile Safari/537.36 
		//meilleur //Mozilla/5.0 (Linux; Android 5.1; Nexus 4 Build/LMY47O) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.109 Mobile Safari/537.36
		//not bad // Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en) AppleWebKit/525.18.1 (KHTML, like Gecko) Version/3.1.1 Iris/1.1.7 Safari/525.20
		BrowserPreferences.setUserAgent("Mozilla/5.0 (Linux; Android 5.0.2; ro-ro;; LG-D802 Build/LMY47V; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/2.1 Chrome/42.0.2311.137 Mobile Safari/537.36");
		browser = new Browser();



		panelNorth.setOpaque(false);
		panelNorth.setLayout(new GridLayout(1,3));
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
					public void insertBrowser(final Browser arg0, Rectangle initialBounds) {
						browser2 = arg0;
						browserView = new BrowserView(browser2);
						buttonReturn.setVisible(true);
						buttonBack.setVisible(false);
						buttonForward.setVisible(false);
						remove(browserViewLocal);
						add(browserView);
						getBox().revalidate();
						parent.add(getBox(), BorderLayout.CENTER);
					}
				};
			}
		});
		add(BorderLayout.NORTH,panelNorth);
		add(BorderLayout.CENTER,browserViewLocal);

	}


	public void LoadUrl(String URL){
		this.URL = URL;
		browser.loadURL(URL);
	}


	class EcouteurNavigateur implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().equals("back")) {
				browser.goBack();
			}

			if (e.getActionCommand().equals("forward")) {
				browser.goForward();
			}
			if (e.getActionCommand().equals("return")) {
				if(!browser2.isDisposed())
				browser2.loadURL(URL);
				browserViewLocal = new BrowserView(browser);
				buttonReturn.setVisible(false);
				remove(browserView);
				add(browserViewLocal);
				getBox().revalidate();
				revalidate();
				parent.add(getBox(), BorderLayout.CENTER);
				buttonBack.setVisible(true);
				buttonForward.setVisible(true);
			}
		}
	}
}
