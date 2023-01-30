import java.util.Arrays;
import java.util.Random;

public class TwoDMethods
{
	private int[][] num;
	
	public TwoDMethods()
	{
		num = new int[][] {{1, 2}, {3, 4}, {5, 6}};
	}
	
	public TwoDMethods(int r, int c)
	{
		num = new int[r][c];
		this.randomizer();
	}
	
	public void randomizer()
	{
		Random rand = new Random();
		for(int row = 0; row < num.length; row++)
			for(int col = 0; col < num[row].length; col++)
				num[row][col] = rand.nextInt(100);
	}
	
	public void display()
	{
		for(int row = 0; row < num.length; row++)
		{
			for(int col = 0; col < num[row].length; col++)
				System.out.print(num[row][col] + " ");
			System.out.println();
		}
	}
	
	public void sidedisplay()
	{
		for(int col = 0; col < num[0].length; col++)
		{
			for(int row = 0; row < num.length; row++)
				System.out.print(num[row][col] + " ");
			System.out.println();
		}
	}
	
	public int maximum()
	{
		int max = num[0][0];
		for(int row = 0; row < num.length; row++)
			for(int col = 0; col < num[row].length; col++)
				if(num[row][col] > max)
					max = num[row][col];
		return max;	
	}
	
	public double average()
	{
		double avg = 0;
		for(int row = 0; row < num.length; row++)
			for(int col = 0; col < num[row].length; col++)
				avg += num[row][col];
		return avg / (num.length * num[0].length);
	}
	
	public int diagonal()
	{
		int product = 1;
		int col = 0;
		for(int row = 0; row < num.length; row++)
			product = product * num[row][col++];
		return product;
	}
	
	public int Revdiagonal()
	{
		int product = 1;
		int col = num[0].length - 1;
		for(int row = 0; row < num.length; row++)
			product = product * num[row][col--];
		return product;
	}
	
	public int[][] CopyArr()
	{
		int[][] copy = new int[num.length / 2][num[0].length / 2];
		int r = 0, c = 0;
		for(int row = copy.length; row < num.length; row++)
		{
			for(int col = copy[0].length; col < num[0].length; col++)
				copy[r][c++] = num[row][col];
			r++;
			c = 0;
		}
		return copy;
	}
	
	public static void main(String args[])
	{
		TwoDMethods one = new TwoDMethods();
		TwoDMethods two = new TwoDMethods(4, 4);
		two.display();
//		System.out.println(two.diagonal());
//		System.out.println(two.Revdiagonal());
		System.out.println(Arrays.deepToString(two.CopyArr()));
//		System.out.println(one.maximum());
//		System.out.println(one.average());
	}
}
