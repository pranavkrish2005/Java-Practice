import static java.lang.System.*;

public class AtCounter
{
   private String[][] atMat;

	public AtCounter(int row, int col)
	{
		//size the matrix
		atMat = new String[row][col];
		String[] arr = {"@", "-"};
		//use nested loops to randomly load the matrix
		//you will need to use Math.random()
		for(int r = 0; r < atMat.length; r++)
			for(int c = 0; c < atMat[r].length; c++)
			{
				atMat[r][c] = arr[(int)(Math.random() + 0.5)];
			}
	}

	public int countAts(int r, int c)
	{
		//add in recursive code to count up the # of @s connected
		//start checking at spot [r,c]
		if((r < atMat.length && r >= 0) && (c < atMat[0].length && c >= 0))
		{
			if(atMat[r][c].equals("-"))
				return 0;
			else
			{
				atMat[r][c] = "-";
				return 1 + countAts(r + 1, c) + countAts(r - 1, c) + 
						countAts(r, c + 1) + countAts(r, c - 1);
			}
		}
		return 0;
	}

	/*
	 *this method will return all values in the matrix
	 *this method should return a view of the matrix
	 *that looks like a matrix
	 */
	public String toString()
	{
		String s = "";
		for(int r = 0; r < atMat.length; r++)
		{
			for(int c = 0; c < atMat[r].length; c++)
				s += atMat[r][c] + " ";
			s += "\n";
		}
		return s;
	}
}
