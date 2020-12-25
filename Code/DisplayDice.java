import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class DisplayDice extends JPanel implements Observer
{
	private int face1;
	private int face2;
	
	private ArrayList<Image> imfaces;
	private File file1 = new File("./Dice/dieface1.jpeg");
	private File file2 = new File("./Dice/dieface2.jpeg");
	private File file3 = new File("./Dice/dieface3.jpeg");
	private File file4 = new File("./Dice/dieface4.jpeg");
	private File file5 = new File("./Dice/dieface5.jpeg");
	private File file6 = new File("./Dice/dieface6.jpeg");
	
	private Image dieface1,dieface2,dieface3,dieface4,dieface5,dieface6;
	
	
	private JLabel lbl1,lbl2;
	
	private JPanel face1pan;
	private JPanel face2pan;
	
	GameManager gm = GameManager.getInstance();
	
	private ImageIcon imface1;
	private ImageIcon imface2;
	
	public DisplayDice()
	{
		this.setLayout(new BorderLayout());
		this.setMaximumSize(new Dimension(160, 40));
		this.setBackground(Color.gray);
		
		face1pan = new JPanel();
		face2pan = new JPanel();
		
		
		
		imfaces = new ArrayList<Image>();
		
		defineImages();
		
		imface1 = new ImageIcon(imfaces.get(5));	
		face1pan.setMaximumSize(new Dimension(40,40));
        face1pan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        lbl1 = new JLabel();
		lbl1.setIcon(imface1);
		face1pan.removeAll();
		face1pan.add(lbl1);
		this.add(face1pan, BorderLayout.WEST);
		
		
		imface2 = new ImageIcon(imfaces.get(5));
		face2pan.setMaximumSize(new Dimension(40,40));
        face2pan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        lbl2 = new JLabel();
		lbl2.setIcon(imface2);
		face2pan.removeAll();
		face2pan.add(lbl2);
		this.add(face2pan,  BorderLayout.CENTER);
		gm.subscribe(this);
		this.validate();
       
	}
	
	public void defineImages()
	{
		try
		{
			dieface1 = ImageIO.read(file1);
			dieface1 = dieface1.getScaledInstance(((BufferedImage) dieface1).getWidth(), ((BufferedImage) dieface1).getHeight(), Image.SCALE_SMOOTH);
			dieface2 = ImageIO.read(file2);
			dieface2 = dieface2.getScaledInstance(((BufferedImage) dieface2).getWidth(), ((BufferedImage) dieface2).getHeight(), Image.SCALE_SMOOTH);
			dieface3 = ImageIO.read(file3);
			dieface3 = dieface3.getScaledInstance(((BufferedImage) dieface3).getWidth(), ((BufferedImage) dieface3).getHeight(), Image.SCALE_SMOOTH);
			dieface4 = ImageIO.read(file4);
			dieface4 = dieface4.getScaledInstance(((BufferedImage) dieface4).getWidth(), ((BufferedImage) dieface4).getHeight(), Image.SCALE_SMOOTH);
			dieface5 = ImageIO.read(file5);
			dieface5 = dieface5.getScaledInstance(((BufferedImage) dieface5).getWidth(), ((BufferedImage) dieface5).getHeight(), Image.SCALE_SMOOTH);
			dieface6 = ImageIO.read(file6);
			dieface6 = dieface6.getScaledInstance(((BufferedImage) dieface6).getWidth(), ((BufferedImage) dieface6).getHeight(), Image.SCALE_SMOOTH);
			imfaces.add(dieface1);
			imfaces.add(dieface2);
			imfaces.add(dieface3);
			imfaces.add(dieface4);
			imfaces.add(dieface5);
			imfaces.add(dieface6);		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void drawFace()
	{
		face1 = gm.getFace1();
		face2 = gm.getFace2();
		
		imface1 = new ImageIcon(imfaces.get(face1-1));
		lbl1 = new JLabel();
		lbl1.setIcon(imface1);
		face1pan.removeAll();
		face1pan.add(lbl1);
		
		imface2 = new ImageIcon(imfaces.get(face2-1));
		lbl2 = new JLabel();
		lbl2.setIcon(imface2);
		face2pan.removeAll();
		face2pan.add(lbl2);
		this.validate();
		repaint();
		//this.setVisible(true);
		//gm.subscribe(this);
	}
	
	public void observe(String message)
	{
		if(message.equals("refresh"))
		{
			this.drawFace();
		}
	}
	
	
	
	
	
	
	
	
	
}
