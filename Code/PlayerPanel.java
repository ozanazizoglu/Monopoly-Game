import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlayerPanel extends JPanel implements Observer
{
	private GameManager gm = GameManager.getInstance();
	
	private JPanel panel;
    private JScrollPane scrollPane;
    private JPanel userPanel;
    private JTextArea textArea;
    ArrayList<Player> players;
    private int lastSelected = 0;
    ArrayList<JButton> playerButtons = new ArrayList<JButton>();
    public PlayerPanel() {
    	
        //this.setMaximumSize(new Dimension(500, 310));
    	this.setMaximumSize(new Dimension(700, 310));

        userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(userPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 300));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.black);
        panel.add(scrollPane);
        
        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(280, 300));
        //textArea.setEditable(false);
        textArea.setBackground(Color.LIGHT_GRAY);

        addPlayerButtons();
        this.add(panel);
        this.add(textArea);
        gm.subscribe(this);
    }

    public void paint(Graphics g) {
    	super.paint(g);
    	Player p = gm.whoseTurn();
    	//textArea.setText(players.get(lastSelected).toString());
    	
    	/*
        
        if (players.size() != 0) {
            textArea.setText(players.get(lastSelected).toString());
        }
        */
    }

    
    public void refreshPlayerButtons() {

        for (int i = 0; i < players.size(); i++) {

            Player player = players.get(i);

            if (player == gm.whoseTurn()) {
                playerButtons.get(i).setForeground(Color.GREEN);
            } else {
                playerButtons.get(i).setForeground(Color.BLACK);
            }      
            /*
            Player p2 = gm.whoseTurn();
            textArea.setText("Name: " + p2.getName() +", Money: " + p2.getMoney() );
            userPanel.validate();
            */
        }
    }
    

    public void addPlayerButtons() {
    	players = gm.getPlayers();
        
        for (int i = 0; i < players.size(); i++) {
            playerButtons.add(new JButton(players.get(i).getName()));
            
            playerButtons.get(i).setPreferredSize(new Dimension(100, 100));
            
            Player player = players.get(i);
            String color = player.getColor();
            if(color.equalsIgnoreCase("yellow"))
			{
            	playerButtons.get(i).setForeground(Color.YELLOW);
			}
			else if(color.equalsIgnoreCase("red"))
			{
				playerButtons.get(i).setForeground(Color.RED);
			}
			else if(color.equalsIgnoreCase("blue"))
			{
				playerButtons.get(i).setForeground(Color.BLUE);
			}
			else if(color.equalsIgnoreCase("orange"))
			{
				playerButtons.get(i).setForeground(Color.ORANGE);
			}
			else if(color.equalsIgnoreCase("green"))
			{
				playerButtons.get(i).setForeground(Color.GREEN);
			}
			else if(color.equalsIgnoreCase("gray"))
			{
				playerButtons.get(i).setForeground(Color.GRAY);
			}
			else if(color.equalsIgnoreCase("black"))
			{
				playerButtons.get(i).setForeground(Color.BLACK);
			}		
            
            if (player == gm.whoseTurn()) 
            {
            	Font newButtonFont=new Font(playerButtons.get(i).getFont().getName(),playerButtons.get(i).getFont().getStyle(),20);
            	playerButtons.get(i).setFont(newButtonFont);
                textArea.setText(player.toString());
            }
            
            else 
            {
            	Font newButtonFont=new Font(playerButtons.get(i).getFont().getName(),playerButtons.get(i).getFont().getStyle(),14);
            	playerButtons.get(i).setFont(newButtonFont);
                //playerButtons.get(i).setForeground(Color.BLACK);
            }
            
            int index = i;
            
            playerButtons.get(i).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	
                    Player p = gm.getPlayers().get(index);
                    textArea.setText(p.toString());
                    //lastSelected = currentPlayerIndex;
                    //PlayerController.getInstance().setChosen(player);
                }
            });
            
            userPanel.add(playerButtons.get(i));      
            userPanel.validate();
            
        }
    }
    
    public void refreshPanel()
    {
    	Player cp = gm.whoseTurn();
        textArea.setText(cp.toString() );
        //textArea.validate();
        //userPanel.validate();
        repaint();
    }

    public void observe(String message) 
    {
    	if (message.equals("refresh")) 
    	{
    		System.gc();
    		addPlayerButtons();
    		//refreshPanel();
    	}
    	
    }
}
