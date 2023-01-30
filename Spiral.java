import java.awt.*;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import java.util.Random;

public class Spiral extends JFrame
{
	public Spiral()
	{
		super("Spiral");
		this.setVisible(true);
		this.setSize(600, 600);
		repaint();
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.white);
		g.fillRect(0, 0, 600, 600);
		g2.setColor(Color.red);
		
		Point2D.Double point1 = new Point2D.Double(270, 270);
		Point2D.Double point2 = new Point2D.Double();
		
		int count = 3, xval = 0, yval = 0;
		for(int i = 0; i <= 500; i+= 5)
		{
			count++;
			if(count % 4 == 0) {xval = i; yval = 0;}
			else if(count % 4 == 1) {xval = 0; yval = i;}
			else if(count % 4 == 2) {xval = -i; yval = 0;}
			else {xval = 0; yval = -i;}
			
			
			point2 = new Point2D.Double ((int)(point1.x + xval), (int)(point1.y + yval));
			g.drawLine((int)point1.x, (int)point1.y, (int)point2.x, (int)point2.y);
			point1 = point2;
			
			try {Thread.currentThread().sleep(100);}
			catch(InterruptedException a){a.printStackTrace();}
		}
		
	}
	
	public static void main(String args[])
	{
		Spiral app = new Spiral();
	}
}
