import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class BoardGui extends JPanel implements Observer
{
	
	private GameManager gm = GameManager.getInstance();
	private File boardIm = new File("./Dice/monop.png");
	private Image im1;
	private ArrayList<GamePiece> pieces;
	
	private static BoardGui instance;
	private HashMap<Integer, Point> cellCoor;
	
	private BoardGui()
	{
		cellCoor = new HashMap<Integer, Point>();
		try {
            im1 = ImageIO.read(boardIm);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		initializeCoor();
		pieces = new ArrayList<GamePiece>();
		gm.subscribe(this);
	}
	
	public static BoardGui getInstance() 
	{
		if (instance == null)
		{
            instance = new BoardGui();
        }
        return instance;
	}
	
	public void initializeCoor()
	{
		int[] x = new int[40];
        int[] y = new int[40];

        x[0] = 953;
        x[1] = 866;
        x[2] = 777;
        x[3] = 687;
        x[4] = 596;
        x[5] = 506;
        x[6] = 418;
        x[7] = 328;
        x[8] = 238;
        x[9] = 151;
        x[10] = 59;
        x[11] = 58;
        x[12] = 61;
        x[13] = 59;
        x[14] = 59;
        x[15] = 59;
        x[16] = 60;
        x[17] = 59;
        x[18] = 59;
        x[19] = 59;
        x[20] = 58;
        x[21] = 148;
        x[22] = 237;
        x[23] = 329;
        x[24] = 417;
        x[25] = 507;
        x[26] = 597;
        x[27] = 686;
        x[28] = 776;
        x[29] = 866;
        x[30] = 953;
        x[31] = 953;
        x[32] = 953;
        x[33] = 954;
        x[34] = 954;
        x[35] = 954;
        x[36] = 953;
        x[37] = 954;
        x[38] = 954;
        x[39] = 954;

        y[0] = 917;
        y[1] = 919;
        y[2] = 919;
        y[3] = 918;
        y[4] = 919;
        y[5] = 919;
        y[6] = 918;
        y[7] = 918;
        y[8] = 920;
        y[9] = 920;
        y[10] = 918;
        y[11] = 830;
        y[12] = 743;
        y[13] = 656;
        y[14] = 570;
        y[15] = 483;
        y[16] = 399;
        y[17] = 311;
        y[18] = 225;
        y[19] = 141;
        y[20] = 55;
        y[21] = 54;
        y[22] = 53;
        y[23] = 53;
        y[24] = 53;
        y[25] = 53;
        y[26] = 53;
        y[27] = 53;
        y[28] = 53;
        y[29] = 53;
        y[30] = 53;
        y[31] = 140;
        y[32] = 225;
        y[33] = 312;
        y[34] = 397;
        y[35] = 483;
        y[36] = 569;
        y[37] = 652;
        y[38] = 740;
        y[39] = 827;
        
        for(int i = 0; i < x.length; i++){
            x[i] = 4 * x[i];
            y[i] = 4 * y[i];
            x[i] = x[i] / 5;
            y[i] = y[i] / 5;
        }
		cellCoor.put(0, new Point(x[0],y[0]));
		cellCoor.put(1, new Point(x[1],y[1]));
		cellCoor.put(2, new Point(x[2],y[2]));
		cellCoor.put(3, new Point(x[3],y[3]));
		cellCoor.put(4, new Point(x[4],y[4]));
		cellCoor.put(5, new Point(x[5],y[5]));
		cellCoor.put(6, new Point(x[6],y[6]));
		cellCoor.put(7, new Point(x[7],y[7]));
		cellCoor.put(8, new Point(x[8],y[8]));
		cellCoor.put(9, new Point(x[9],y[9]));
		cellCoor.put(10, new Point(x[10],y[10]));
		cellCoor.put(11, new Point(x[11],y[11]));
		cellCoor.put(12, new Point(x[12],y[12]));
		cellCoor.put(13, new Point(x[13],y[13]));
		cellCoor.put(14, new Point(x[14],y[14]));
		cellCoor.put(15, new Point(x[15],y[15]));
		cellCoor.put(16, new Point(x[16],y[16]));
		cellCoor.put(17, new Point(x[17],y[17]));
		cellCoor.put(18, new Point(x[18],y[18]));
		cellCoor.put(19, new Point(x[19],y[19]));
		cellCoor.put(20, new Point(x[20],y[20]));
		cellCoor.put(21, new Point(x[21],y[21]));
		cellCoor.put(22, new Point(x[22],y[22]));
		cellCoor.put(23, new Point(x[23],y[23]));
		cellCoor.put(24, new Point(x[24],y[24]));
		cellCoor.put(25, new Point(x[25],y[25]));
		cellCoor.put(26, new Point(x[26],y[26]));
		cellCoor.put(27, new Point(x[27],y[27]));
		cellCoor.put(28, new Point(x[28],y[28]));
		cellCoor.put(29, new Point(x[29],y[29]));
		cellCoor.put(30, new Point(x[30],y[30]));
		cellCoor.put(31, new Point(x[31],y[31]));
		cellCoor.put(32, new Point(x[32],y[32]));
		cellCoor.put(33, new Point(x[33],y[33]));
		cellCoor.put(34, new Point(x[34],y[34]));	
		cellCoor.put(35, new Point(x[35],y[35]));
		cellCoor.put(36, new Point(x[36],y[36]));
		cellCoor.put(37, new Point(x[37],y[37]));
		cellCoor.put(38, new Point(x[38],y[38]));
		cellCoor.put(39, new Point(x[39],y[39]));	
	}
	
	public void addGamePiece( GamePiece piece)
	{
		pieces.add(piece);
	}
	
	public HashMap<Integer,Point> getCellCoor()
	{
		return cellCoor;
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(im1 , 0, 0,null);

		for(GamePiece piece:pieces)
		{
			Player p = piece.getPlayer();
			int playerIndex = p.getPosition();
			int posX = cellCoor.get(playerIndex).x;
			int posY = cellCoor.get(playerIndex).y;
			String color = p.getColor();
			if(color.equalsIgnoreCase("yellow"))
			{
				g.setColor(Color.YELLOW);
			}
			else if(color.equalsIgnoreCase("red"))
			{
				g.setColor(Color.RED);
				posX += 5;
				posY += 5;
			}
			else if(color.equalsIgnoreCase("blue"))
			{
				g.setColor(Color.BLUE);
				posX -= 5;
				posY -= 5;
			}
			else if(color.equalsIgnoreCase("orange"))
			{
				g.setColor(Color.ORANGE);
				posX += 10;
				posY += 10;
			}
			else if(color.equalsIgnoreCase("green"))
			{
				g.setColor(Color.GREEN);
				posX -= 10;
				posY -= 10;
			}
			else if(color.equalsIgnoreCase("gray"))
			{
				g.setColor(Color.GRAY);
				posX += 15;
				posY += 15;
			}
			else if(color.equalsIgnoreCase("black"))
			{
				g.setColor(Color.BLACK);
				posX -= 15;
				posY -= 15;
			}		
			g.fillOval(posX, posY, 10, 10);
		}
	}
	
	public void observe(String message)
	{
		if(message.equals("refresh"))
		{
			repaint();
		}
		
	}

}
