import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GameButtons extends JPanel
{	
	protected JButton rollDice;	
	protected JButton buy;
    protected JButton drawCard;
    protected JButton improve;    
    protected JButton endTurn;
    protected JButton mortgage;
    GameManager gm = GameManager.getInstance();
    public GameButtons()
    {
    	JPanel buttonPanel = new JPanel();
    	buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false);
        setOpaque(false);
        buy = new JButton("Buy");
        drawCard = new JButton("Draw card");
        improve = new JButton("Buy House/Hotel");
        rollDice = new JButton("Roll Dice");
        endTurn = new JButton("End Turn");
        mortgage = new JButton("Mortgage");

        buttonPanel.add(rollDice);
        buttonPanel.add(buy, BorderLayout.CENTER);
        buttonPanel.add(endTurn);      
        buttonPanel.add(drawCard);
        buttonPanel.add(improve);
        buttonPanel.add(mortgage);
        this.setMaximumSize(buttonPanel.getMaximumSize());
        this.add(buttonPanel);
        
        buy.addActionListener(new ActionListener(){
        	public void actionPerformed( ActionEvent e)
        	{
        		gm.buy();
        		buy.setEnabled(false);
        		endTurn.setEnabled(true);
        		gm.publish("refresh");
        	}       	
        });
        
        rollDice.addActionListener(new ActionListener(){
        	public void actionPerformed( ActionEvent e)
        	{
        		gm.rollDice();
        		gm.movePlayer();
        		gm.handleCell();
        		rollDice.setEnabled(false);
        		endTurn.setEnabled(true);
        		gm.publish("refresh");
        	}      	
        });
        
        endTurn.addActionListener(new ActionListener(){
        	public void actionPerformed( ActionEvent e)
        	{
        		gm.nextTurn();
        		endTurn.setEnabled(false);
        		buy.setEnabled(false);
        		mortgage.setEnabled(false);
        		improve.setEnabled(false);
        		drawCard.setEnabled(false);
        		gm.publish("rollDice");
        		gm.publish("refresh");
        		//endTurn.setEnabled(false);
        	}      	
        });
        
        drawCard.addActionListener(new ActionListener(){
        	public void actionPerformed( ActionEvent e)
        	{
        		gm.playCard();
        		drawCard.setEnabled(false);
        		endTurn.setEnabled(true);
        		gm.publish("refresh");
        		
        	}      	
        });
        
        improve.addActionListener(new ActionListener(){
        	public void actionPerformed( ActionEvent e)
        	{
        		
        		Player p = gm.whoseTurn();
        		Cell cell = gm.getBoard().cellAt(p.getPosition());
        		PropertyCell prop = (PropertyCell)cell;
        		if( prop.getHotelNum() == 0)
        		{
        			gm.buyHouse();
        		}
        		if( prop.getHouseNum() == 4)
        		{
        			gm.buyHotel();
        		}
        		improve.setEnabled(false);
        		endTurn.setEnabled(true);
        		gm.publish("refresh");
        	}      	
        });
        
        mortgage.addActionListener(new ActionListener(){
        	public void actionPerformed( ActionEvent e)
        	{
        		gm.mortgage();
        		gm.publish("refresh");
        	}      	
        });
        
        buy.setEnabled(false);
        endTurn.setEnabled(false);
        drawCard.setEnabled(false);
        improve.setEnabled(false);
        rollDice.setEnabled(true);
        mortgage.setEnabled(false);
        this.setVisible(true);   
  
    }
    
    
    

}
