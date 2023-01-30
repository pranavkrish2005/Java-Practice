
public class SqrootApprox
{
	public static double squareRootGuess(double x, double g)
	{
		if(x + 0.001 > Math.pow(g, 2) && Math.pow(g, 2) > x - 0.001)
			return g;
		else
			return squareRootGuess(x, (g + x/g) / 2);
	}
	
	public static double squareRoot(double x)
	{
		return squareRootGuess(x, x);
	}
	
	public static void main(String args[])
	{
		System.out.println(squareRoot(100));
	}
}
