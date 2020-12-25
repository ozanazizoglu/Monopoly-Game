import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameScreen extends JPanel implements Observer
{
	private GameManager gm = GameManager.getInstance();
	private BoardGui gmbrd = BoardGui.getInstance();
	GameButtons buttons;
	PlayerPanel playerPanel;
	DisplayDice dicePanel;
	JPanel distinct;
	CellBox cellBox;
	
	public GameScreen()
	{
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(gmbrd);
		distinct = new JPanel();
		distinct.setLayout( new BoxLayout(distinct,BoxLayout.Y_AXIS));
		buttons = new GameButtons();
		playerPanel = new PlayerPanel();
		dicePanel = new DisplayDice();
		cellBox = new CellBox();
		dicePanel.setMaximumSize(new Dimension(700,100));
		distinct.add(cellBox);
		distinct.add(playerPanel);
		distinct.add(dicePanel);
		distinct.add(buttons);
		distinct.setMaximumSize(new Dimension(700,700));
		this.add(distinct);
		gm.subscribe(this);
	}
	
	public void observe(String message)
	{
		if( message.equals("buyCell"))
		{
			buttons.buy.setEnabled(true);
		}
		else if(message.equals("drawCard"))
		{
			buttons.drawCard.setEnabled(true);
		}
		else if(message.equals("mortgage"))
		{
			buttons.mortgage.setEnabled(true);
		}
		else if(message.equals("buyHouseORmortgage"))
		{
			buttons.mortgage.setEnabled(true);
			buttons.improve.setEnabled(true);
		}
		else if(message.equals("rollDice"))
		{
			buttons.rollDice.setEnabled(true);
		}
	}
}
