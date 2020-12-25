import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
public class PlayerPanelTest 
{
	public static void main(String[] args)
	{
		MainScreen game = new MainScreen();
		game.setVisible(true);
		
		
		/*
		//DisplayDice dis = new DisplayDice();
		JFrame frame = new JFrame();
		GameScreen game = new GameScreen();
		//MenuScreen menu = new MenuScreen();
		frame.add(game);
		frame.setVisible(true);
		*/
		
		
		/*
		GameManager gm = GameManager.getInstance();
		Player ozan = new Player("Ozan");
		Player mert = new Player("Mert");
		Player veli = new Player("Veli");
		gm.addPlayer(ozan);
		gm.addPlayer(mert);
		gm.addPlayer(veli);
		DisplayDice dis = new DisplayDice();
		gm.rollDice();
		System.out.println(gm.getFace1());
		System.out.println(gm.getFace2());
		*/
		/*
		GameManager gm = GameManager.getInstance();
		//Player ozan = new Player("Ozan");
		Player mert = new Player("Mert");
		gm.addPlayer(ozan);
		gm.addPlayer(mert);
		ozan.setPosition(17);
		mert.setPosition(16);
		File harunfl = new File("C:/Users/Mert/Desktop/Dice/harun.jpg");
		GamePiece pc1 = new GamePiece(ozan,harunfl);
		//GamePiece pc2 = new GamePiece(mert);
		BoardGui gmbrd = BoardGui.getInstance();
		gmbrd.addGamePiece(pc1);
		//gmbrd.addGamePiece(pc2);
		
		gmbrd.a();
		//gmbrd.paint(Graphics g);
		
		JFrame frame = new JFrame();
		frame.add(gmbrd);
		frame.setVisible(true);
		*/
		/*
		
		
		gm.rollDice();
		gm.nextTurn();
		JFrame frame = new JFrame();
		GameButtons buttons = new GameButtons();
		PlayerPanel panel = new PlayerPanel();
		frame.add(buttons);
		frame.add(panel);
		frame.setVisible(true);
		*/
		//File file1 = new File("C:/Users/Mert/Desktop/Dice/dieface1.jpeg");
		
		//int a = 5;
		
		
		//gm.nextTurn();
		//panel.refreshPlayerButtons();
	}

}
