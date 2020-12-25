import java.io.File;
import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.IOException;
public class GamePiece extends JPanel
{
	Player p;
	Point playerPos;
	Image pieceIm;
	BoardGui gmbrd = BoardGui.getInstance();
	
	public GamePiece(Player p /* , File f */)
	{
		playerPos = gmbrd.getCellCoor().get(0);
		this.p = p;
		
	}
	
	public Player getPlayer()
	{
		return this.p;
	}
	
	/*
	public Image getImage()
	{
		return pieceIm;
	}
	*/
	
	public void paint(Graphics g)
	{
		/*
		int playerIndex = p.getPosition();
		
		int posX = gmbrd.getCellCoor().get(playerIndex).x;
		int posY = gmbrd.getCellCoor().get(playerIndex).y;
		g.fillOval(posX, posY, 10, 10);
		//g.drawImage(pieceIm, posX, posY, null);
		 */
	}
	
	public void ciz()
	{
		repaint();
	}
	

	
}
