import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import javax.swing.JFrame;
import java.util.Random;

public class RandLines extends JFrame
{
	public RandLines()
	{
		super("RandLines");
		this.setVisible(true);
		this.setSize(600, 600);
		repaint();
	}
		
		public void paint(Graphics g)
		{
			super.paint(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setStroke(new BasicStroke(2));
			g2.setColor(Color.white);
			g.fillRect(0, 0, 600, 600);
			g2.setColor(Color.black);
			
			Point2D.Double point1 = new Point2D.Double(0, 0);
			Point2D.Double point2 = new Point2D.Double();
			int randx = 0, randy = 0;
			Random r = new Random();
			int changey = (int)(Math.random() * 100) + 11;
			
			for(int i = 0; i <= 10; i++)
			{
				r.setSeed(i);
				randx = r.nextInt(600);
				
				r.setSeed(i - changey);
				randy = r.nextInt(600);
				
				point2 = new Point2D.Double (randx, randy);
				g.drawLine((int)point1.x, (int)point1.y, (int)point2.x, (int)point2.y);
				point1 = point2;
				
				try {Thread.currentThread().sleep(500);}
				catch(InterruptedException a){a.printStackTrace();}
				
			}
			
			g2.setColor(Color.white);
			point1 = new Point2D.Double(0, 0);
			for(int i = 0; i <= 10; i++)
			{
				r.setSeed(i);
				randx = r.nextInt(600);
				
				r.setSeed(i - changey);
				randy = r.nextInt(600);
				
				point2 = new Point2D.Double (randx, randy);
				g.drawLine((int)point1.x, (int)point1.y, (int)point2.x, (int)point2.y);
				point1 = point2;
				
				try {Thread.currentThread().sleep(500);}
				catch(InterruptedException a){a.printStackTrace();}
				
			}
		}
		
		public static void main(String args[])
		{
			RandLines app = new RandLines();
		}
	}

