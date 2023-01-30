import java.util.Arrays;
public class CombineArrays
{
	// displays the array
	public static void display( int[] a)
	{
		for(int x : a)
			System.out.println(x);
	}
	// returns a new array where b is appended to the end of a
	public static int[] append (int[] a , int[] b)
	{
		int[] c = new int[a.length + b.length];
		for(int i =0; i < a.length; i++)
			c[i] = a[i];
		for(int i = a.length; i < c.length; i++)
			c[i] = b[i - a.length];
		return c;
	}
	// returns a new array with alternating values from a and b
	// (question: does it matter if the arrays have different lengths?
	public static int[] alternate( int[]a, int[] b)
	{
		int[]c = new int[a.length + b.length];
		int aIndex = 0;
		int bIndex = 0;
		int cIndex = 0;
		while(c.length > aIndex + bIndex)
		{
			if(aIndex < a.length && bIndex < b.length)
			{
				c[cIndex++] = a[aIndex++];
				c[cIndex++] = b[bIndex++];
			}
			else if(aIndex == a.length)
				c[cIndex++] = b[bIndex++];
			else if(bIndex == b.length)
				c[cIndex++] = a[aIndex++];
				
		}
		return c;
	}
	//returns a new ordered array
	// prerequisite a and b must be ordered
	// (and NO, you may NOT just append the arrays and then sort – individual
	// elements must be compared between the arrays to see what to add next)
	public static int[] merge( int[]a, int[] b)
	{
		int[]c = new int[a.length + b.length];
		int aIndex = 0;
		int bIndex = 0;
		int cIndex = 0;
		while(c.length > aIndex + bIndex)
		{
			if(aIndex < a.length && bIndex < b.length)
			{
				if(a[aIndex] > b[bIndex])
					c[cIndex++] = b[bIndex++];
				else
					c[cIndex++] = a[aIndex++];
			}
			else if(aIndex == a.length)
				c[cIndex++] = b[bIndex++];
			else if(bIndex == b.length)
				c[cIndex++] = a[aIndex++];
		}
		return c;
	}
	public static void main(String[] args)
	{
		int[] a = new int[]{1,4,9,16,25,36,49,64,81,100};
		int[] b = new int[] {3,10,11,12,21,26};
		System.out.println("APPEND");
		display(append(a,b));
		System.out.println() ;
		System.out.println("ALTERNATE") ;
		display(alternate(b,a));
		System.out.println() ;
		System.out.println("MERGE") ;
		display(merge(b,a));
	}
}