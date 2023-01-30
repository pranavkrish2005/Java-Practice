import java.awt.*;
import javax.swing.JFrame;

public class LineArt2 extends JFrame
{
	public LineArt2()
	{
		super("LineArt2");
		this.setVisible(true);
		this.setSize(600, 600);
		repaint();
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(1));
		g2.setColor(Color.white);
		g.fillRect(0, 0, 600, 600);
		
		g2.setColor(Color.red);
		for(int i = 0; i <= 150; i += 10)
		{
			g.drawLine(500, 200 - i, 500 - i, 50);
			try {Thread.currentThread().sleep(100);}
			catch(InterruptedException a){a.printStackTrace();}
		}
		
		g2.setColor(Color.green);
		for(int i = 0; i <= 150; i += 10)
		{
			g.drawLine(200, 200 - i, 200 + i, 50);
			try {Thread.currentThread().sleep(100);}
			catch(InterruptedException a){a.printStackTrace();}
		}
		
		g2.setColor(Color.blue);
		for(int i = 0; i <= 150; i += 10)
		{
			g.drawLine(500, 200 + i, 500 - i, 350);
			try {Thread.currentThread().sleep(100);}
			catch(InterruptedException a){a.printStackTrace();}
		}
		
		g2.setColor(Color.magenta);
		for(int i = 0; i <= 150; i += 10)
		{
			g.drawLine(200, 200 + i, 200 + i, 350);
			try {Thread.currentThread().sleep(100);}
			catch(InterruptedException a){a.printStackTrace();}
		}
		
		
	}
	
	public static void main(String args[])
	{
		LineArt2 app = new LineArt2();
	}
}
