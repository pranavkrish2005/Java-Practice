import java.awt.*;
import javax.swing.JFrame;

public class Sonar2 extends JFrame
{
	public Sonar2()
	{
		super("Sonar2");
		this.setVisible(true);
		this.setSize(600, 600);
		repaint();
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.white);
		g.fillRect(0, 0, 600, 600);
		g2.setColor(Color.black);
		
		while(1 > 0)
		{
		g2.setColor(Color.black);
		int originx = (int)(Math.random() * 600);
		int originy = (int)(Math.random() * 600);
		
		for(int i = 0; i <= 540; i+= 30)
		{
			g.drawOval(originx - i/2, originy - i/2, 10 + i, 10 + i);
			try {Thread.currentThread().sleep(100);}
			catch(InterruptedException a){a.printStackTrace();}
			
		}
		
		g2.setColor(Color.white);
		for(int i = 540; i >= 0; i-= 30)
		{
			g.drawOval(originx - i/2, originy - i/2, 10 + i, 10 + i);
			try {Thread.currentThread().sleep(100);}
			catch(InterruptedException a){a.printStackTrace();}
		}
		}
	}
	
	public static void main(String args[])
	{
		Sonar2 app = new Sonar2();
	}
}
