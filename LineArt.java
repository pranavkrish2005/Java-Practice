import java.awt.*;
import javax.swing.JFrame;

public class LineArt extends JFrame
{
	public LineArt()
	{
		super("LineArt");
		this.setVisible(true);
		this.setSize(600, 600);
		repaint();
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.red);
			
		for(int i = 0; i <= 300; i+= 10)
		{
			g.drawLine(300, 0 + i, 340 + i, 300);
			
			try {Thread.currentThread().sleep(100);}
			catch(InterruptedException a){a.printStackTrace();}
		}
		g2.setColor(Color.green);
		for(int i = 0; i <= 300; i+= 10)
		{
			g.drawLine(300, 0 + i, 260 - i, 300);
			
			try {Thread.currentThread().sleep(100);}
			catch(InterruptedException a){a.printStackTrace();}
		}
		g2.setColor(Color.blue);
		for(int i = 0; i <= 300; i+= 10)
		{
			g.drawLine(300, 600 - i, 340 + i, 300);
			
			try {Thread.currentThread().sleep(100);}
			catch(InterruptedException a){a.printStackTrace();}
		}
		g2.setColor(Color.magenta);
		for(int i = 0; i <= 300; i+= 10)
		{
			g.drawLine(300, 600 - i, 260 - i, 300);
			
			try {Thread.currentThread().sleep(100);}
			catch(InterruptedException a){a.printStackTrace();}
		}
		
	}
	
	public static void main(String args[])
	{
		LineArt app = new LineArt();
	}
}
