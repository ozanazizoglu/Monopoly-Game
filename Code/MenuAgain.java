import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuAgain extends JPanel {
	private JTextField playerName;

	/**
	 * Create the panel.
	 */
	public MenuAgain() {
		setLayout(null);
		
		JButton startButton = new JButton("Start Game");
		startButton.setBounds(159, 50, 97, 25);
		add(startButton);
		
		JButton credits = new JButton("Credits");
		credits.setBounds(159, 109, 97, 25);
		add(credits);
		
		JButton exitButton = new JButton("Quit Game");
		exitButton.setBounds(159, 171, 97, 25);
		add(exitButton);
		
		JComboBox whichPlayer = new JComboBox();
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
		
		JButton addPlayer = new JButton("Add Player");
		addPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addPlayer.setBounds(579, 157, 97, 25);
		add(addPlayer);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 209, 800, 374);
		add(lblNewLabel_2);
		
		

	}
}
