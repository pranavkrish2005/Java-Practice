import java.awt.*;
import javax.swing.JFrame;

public class Checkerboard extends JFrame
{
	public Checkerboard()
	{
		super("Checkerboard");
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
		
		int count = 0;
		for(int i = 30; i < 550; i += 60)
		{
			for(int j = 30; j < 550; j += 60)
			{
				count++;
				if(count % 2 == 1)
					g2.setColor(Color.black);
				else
					g2.setColor(Color.red);
				
				g.fillRect(i, j, 60, 60);
				try {Thread.currentThread().sleep(10);}
				catch(InterruptedException a){a.printStackTrace();}
			}
		}
			
		
	}
	
	public static void main(String args[])
	{
		Checkerboard app = new Checkerboard();
	}
}
