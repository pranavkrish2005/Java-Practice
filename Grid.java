import java.util.ArrayList;
import java.util.Random;

public class Grid
{
   private String[][] grid;

   //load vals into the rows x cols grid randomly
	public Grid(int rows, int cols, String[] vals)
	{
		grid = new String[rows][cols];
		Random rand = new Random();
		for(int r = 0; r < rows; r++)
			for(int c = 0; c < cols; c++)
				grid[r][c] = vals[rand.nextInt(vals.length)];
	}

	//find out which of the vals occurs the most
	public String findMax(String[] vals)
	{
		int max = this.countVals(vals[0]);
		String m = vals[0];
		for(int i = 1; i < vals.length; i++)
			if(this.countVals(vals[i]) > max)
			{
				max = this.countVals(vals[i]);
				m = vals[i];
			}
		return m;
	}

	//returns a count of how many times val occurs in the matrix
	public int countVals(String val)
	{
		int count = 0;
		for(int r = 0; r < grid.length; r++)
			for(int c = 0; c < grid[r].length; c++)
				if(grid[r][c].equals(val))
					count++;
		return count;
	}

	//display the grid
	public String toString()
	{
		String output = "";
		for(int row = 0; row < grid.length; row++)
		{
			for(int col = 0; col < grid[row].length; col++)
				output += grid[row][col] + " ";
			output += "\n";
		}
		return output;
	}
}