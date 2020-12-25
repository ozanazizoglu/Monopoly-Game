import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainScreen extends JFrame implements Observer
{
	Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	GameManager gm = GameManager.getInstance();
	private static JPanel panel2;
	private CardLayout cardlayout = new CardLayout();
	private static MainScreen instance;
	
	public MainScreen()
	{
		 super("Monopoly Ankara");

	     int width = size.width;  
	     int height = size.height; 
	     
	     panel2 = new JPanel(cardlayout);
	     MenuScreen menu = new MenuScreen();
	     GameScreen game = new GameScreen();
	     JPanel content = new JPanel();
	     content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
	     content.setPreferredSize(new Dimension(width, height));
	     
	     this.setContentPane(content);    
	     
	     
	     panel2.add(menu, "Menu");
	     panel2.add(game,"Game");
	     content.add(panel2);
	     
	     this.setLayout(cardlayout);
	     
	     cardlayout.show(panel2, "Menu");
	     
	     
	     this.setSize(width, height);
	     gm.subscribe(this);
	}
	
	
	public void observe(String message)
	{
		if(message.equals("switch"))
		{
			cardlayout.show(panel2, "Game");
		}
			
	}
	
}
