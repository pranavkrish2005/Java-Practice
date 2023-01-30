import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class GridRunner
{
	public static void main( String args[] ) throws IOException
	{
		String[] vals = {"a", "b", "c", "7", "9", "x", "2"};
		Grid one = new Grid(10, 10, vals);
		System.out.println(one);
		
		for(int i = 0; i < vals.length; i++)
			System.out.println(vals[i] + " count is " + one.countVals(vals[i]));
		
		System.out.println(one.findMax(vals) + " occurs the most.");
	}
}