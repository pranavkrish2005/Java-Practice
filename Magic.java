import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Write a description of class test here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Magic
{
	// no instance variables or constructors needed
	// all methods are static


     /**  Precondition:  square is an initialized matrix, MAX rows x MAX columns
          0 <= row < MAX
          Postcondition: returns the sum of the values in row
     */
	public static int sumRow (int[][] square, int row)
	{
		int sum = 0;
		for(int i = 0; i < square[row].length; i++)
			sum += square[row][i];
		return sum;
	}
	
	public static int sumCol (int[][] square, int col)
	{
		int sum = 0;
		for(int i = 0; i < square[0].length; i++)
			sum += square[i][col];
		return sum;
	}
	
	public static int sumDiagonal (int[][] square)
	{
		int sum = 0;
		int col = 0;
		for(int row = 0; row < square.length; row++)
			sum = sum * square[row][col++];
		return sum;
	}
	
	public static int sumRevDiagonal (int[][] square)
	{
		int sum = 0;
		int col = square[0].length - 1;
		for(int row = 0; row < square.length; row++)
			sum = sum * square[row][col--];
		return sum;
	}
	
	/**Precondition: square is initialized with integers.
       Action: Inspects every value in square, checking that each one is
       a unique integer ranging from 1..MAX*MAX
       Postcondition: Returns true if each value is unique from 1..MAX*MAX,
       otherwise returns false
     */  
	boolean unique(int[][] square)
	{
		int[] arr = new int[17];
		for(int r = 0; r < square.length; r++)
			for(int c = 0; c < square[r].length; c++)
				arr[square[r][c]]++;
		for(int i = 1; i < arr.length; i++)
			if(arr[i] != 1)
				return false;
		return true;
	}

	/** Precondition: square is initialized with integers.
  		Action: Checks that row, col, and diagonal sums are equal and elements are unique
  		Postcondition: Returns true if magic else return false.
    */
	public boolean testMagic(int[][] square)
	{
		for(int r = 0; r < square.length; r++)
			for(int c = 0; c < square[r].length; c++)
				if(sumRow(square, r) != sumCol(square, c) && sumDiagonal(square) != sumRevDiagonal(square) && sumCol(square, c) != sumDiagonal(square))
					if(!unique(square))
						return false;
		return true;
						
	}
	
	public void printTable(int[][] square)
	{
		String toPrint = "";
		for(int i = 0; i < square.length; i++)
			toPrint = square[i].toString() + "\n";
		System.out.println(toPrint);
	}
	
//Add methods to sumCol, SumDiag, and print the arrays in matrix format. 

	public static void main(String[] args)
	{

		   int[][] one ={{13, 3, 2, 16},
		                {8, 10, 11, 5},
		                {12, 6, 7, 9},
		                {1, 15, 14, 4}};
		                
		   int[][] two ={{1, 14, 8, 11},
		                {15, 4, 10, 5},
		                {12, 7, 13, 2},
		                {6, 9, 3, 16}};
		                
		   int[][] three ={{8, 11, 14, 1},
		                {13, 2, 7, 12},
		                {3, 16, 9, 6},
		                {10, 5, 4, 15}};

		   int[][] four ={{16, 2, 5, 11},
		                {3, 4, 10, 8},
		                {9, 7, 3, 14},
		                {6, 12, 15, 1}};
		  
		  int[][] five ={{4, 9, 15, 16},
		                {15, 6, 10, 3},
		                {14, 7, 11, 2},
		                {1, 12, 8, 13}};
		               
		  int[][] six ={{1, 2, 3, 4},
		                {2, 3, 4, 1},
		                {3, 4, 1, 2},
		                {4, 1, 2, 3}};



			printTable(one);
			System.out.println("MAGIC SQUARE? " + testMagic(one));
			System.out.println();
			printTable(two);
			System.out.println("MAGIC SQUARE? " + testMagic(two));
			System.out.println();
			printTable(three);
			System.out.println("MAGIC SQUARE? " + testMagic(three));
			System.out.println();
			printTable(four);
			System.out.println("MAGIC SQUARE? " + testMagic(four));
			System.out.println();

			printTable(five);
			System.out.println("MAGIC SQUARE? " + testMagic(five));
			System.out.println();
			printTable(six);
			System.out.println("MAGIC SQUARE? " + testMagic(six));

		}


}