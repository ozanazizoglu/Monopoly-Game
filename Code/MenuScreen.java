import java.util.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
public class MenuScreen extends JPanel implements Observer
{
	private GameManager gm = GameManager.getInstance();
	private BoardGui gmbrd = BoardGui.getInstance();
	private File backgr = new File("./Dice/mansur.jpeg");
	private Image im1;
	String[] colors = {"yellow", "green", "blue", "black", "gray", "orange", "red"};
	ArrayList<String> chosenColors = new ArrayList<String>();
	JPanel menuButtons;
	JPanel player;
	JButton startButton;
	JButton exitButton;
	JButton credits;
	JButton addPlayer;
	JTextField playerName;
	JComboBox whichPlayer;
	public MenuScreen()
	{
		setLayout(null);
		
		startButton = new JButton("Start Game");
		startButton.setBounds(159, 50, 97, 25);
		add(startButton);
		
		credits = new JButton("Credits");
		credits.setBounds(159, 109, 97, 25);
		add(credits);
		
		exitButton = new JButton("Quit Game");
		exitButton.setBounds(159, 171, 97, 25);
		add(exitButton);
		
		whichPlayer = new JComboBox(colors);
		whichPlayer.setBounds(520, 93, 211, 24);
		add(whichPlayer);
		
		JLabel lblNewLabel = new JLabel("Player Color");
		lblNewLabel.setBounds(434, 97, 78, 16);
		add(lblNewLabel);
		
		playerName = new JTextField();
		playerName.setBounds(520, 51, 211, 22);
		add(playerName);
		playerName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Player Name");
		lblNewLabel_1.setBounds(434, 54, 73, 16);
		add(lblNewLabel_1);
		
		addPlayer = new JButton("Add Player");
		addPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addPlayer.setBounds(579, 157, 97, 25);
		add(addPlayer);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 209, 800, 374);
		add(lblNewLabel_2);
		
		gm.subscribe(this);
		//add(menuButtons);
		try {
			im1 = ImageIO.read(backgr);
            im1 = im1.getScaledInstance(((BufferedImage) im1).getWidth(), ((BufferedImage) im1).getHeight(), Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		ImageIcon icon = new ImageIcon(im1); 
		lblNewLabel_2.setIcon(icon);
		
		startButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				    //GameManager game start
				  gm.publish("switch");
				  gm.publish("refresh");
				  } 
				} );
		
		credits.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				    //Credits basicaz
				  } 
				} );
		
		exitButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				    //GameManager game start
				  	System.exit(0);
				  } 
				} );
	
		playerName.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                playerName.setText("");
            }


            public void mousePressed(MouseEvent e) {
                playerName.setText("");
            }
		});
		
		 addPlayer.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	String nextColor = (String)whichPlayer.getSelectedItem();
	            	for (String clr : chosenColors)
	            	{
	            		if(nextColor.equals(clr))
	            		{
	            			JOptionPane box = new JOptionPane();
	            			box.showMessageDialog(null,"Selected color is alreaady chosen!");
	            			return;
	            		}
	            	}
	            	
	            	if (playerName.getText() != null)
	                {
	                    Player player = new Player( playerName.getText(),(String)whichPlayer.getSelectedItem());
	                    GamePiece piece = new GamePiece(player); 
	                    chosenColors.add((String)whichPlayer.getSelectedItem());
	                    gm.addPlayer(player);
	                    gmbrd.addGamePiece(piece);
	                    playerName.setText("Please enter player name");
	                }
	            }
	        });
	}
	
	public void observe( String message)
	{
		/**/
	}
	
	
	public void paint(Graphics g)
	{
		super.paint(g);
		//g.drawImage(im1, 0, 0, null);		
	}
	
}
