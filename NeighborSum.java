import java.util.*;
import java.io.*;

public class NeighborSum {

	private int[][] chart = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 0 }, { 6, 7, 1, 2, 5 }, { 6, 7, 8, 9, 0 },
			{ 5, 4, 3, 2, 1 }, { 0, 0, 0, 0, 0 } };

	private int sum(int row, int col)
	{
		int sum = 0;
		for(int i = col - 1; i <= col + 1; i++)
		{
			if((0 <= row - 1 && row - 1 < chart.length) && (0 <= i && i < chart[0].length))
				sum += chart[row - 1][i];
			if((0 <= row + 1 && row + 1 < chart.length) && (0 <= i && i < chart[0].length))
				sum += chart[row + 1][i];
		}
		if((0 <= row && row < chart.length) && (0 <= col - 1 && col - 1 < chart[0].length))
			sum += chart[row][col - 1];
		if((0 <= row && row < chart.length) && (0 <= col + 1 && col + 1 < chart[0].length))
			sum += chart[row][col + 1];
		return sum;
	}

	public void go() throws Exception
	{
		Scanner file = new Scanner(new File("NeighborSumChart.dat"));
		int pairs = file.nextInt();
		for (int i = 0; i < pairs; i++)
		{
			int r = file.nextInt();
			int c = file.nextInt();
			System.out.println("The sum of " + r + "," + c + " is " + sum(r, c));
		}
	}

	public static void main(String[] args) throws Exception
	{
		NeighborSum x = new NeighborSum();
		x.go();
	}
}