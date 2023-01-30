import java.util.Arrays;
public class ChessComplete
{
	private int NumRecursionCall;
	private int[][] arr;
	private int Startrow;
	private int Startcol;
	private int num = 1;
	private int i = 0;
	
	public ChessComplete(int num)
	{
		arr = new int[num][num];
	}

	public void move(int i, int j)
	{
		Startrow = i;
		Startcol = j;
	}
	
	public void displayBoard()
	{
		arr[Startrow][Startrow] = num;
		displayBoard(Startrow, Startcol);
		String s = "";
		for(int r = 0; r < arr.length; r++)
		{
			for(int c = 0; c < arr[r].length; c++)
			{
					s += arr[r][c] + " ";
			}
			s += "\n";
		}
		System.out.println(s);
	}
	
	public boolean displayBoard(int r, int c)
	{
		if(num == arr.length * arr.length)
			return true;
		else
		{
			i = 0;
			ifstatement(r - 2, c - 1);
			ifstatement(r - 1, c - 2);
			ifstatement(r - 2, c + 1);
			ifstatement(r - 1, c + 2);
			ifstatement(r + 2, c - 1);
			ifstatement(r + 1, c - 2);
			ifstatement(r + 2, c + 1);
			ifstatement(r + 1, c + 2);
			if(i == 1)
				return true;
			else
			{
				arr[r][c] = 0;
				num -= 1;
				return false;
			}
		}
	}
	
	public void ifstatement(int r, int c)
	{
		if(notOutofBounds(r, c) && arr[r][c] == 0)
		{	NumRecursionCall += 1;
			num += 1;
			arr[r][c] = num;
			Startrow = r;
			Startcol = c;
			i = 1;
			displayBoard(Startrow, Startcol);
		}
	}
	
//	public boolean isComplete()
//	{
//		boolean bool = true;
//		for(int r = 0; r < arr.length; r++)
//			for(int c = 0; c < arr[r].length; c++)
//			{
//				if(arr[r][c] != 0)
//					bool = bool && true;
//				else
//					return false;
//			}
//		return bool;
//	}

	public boolean notOutofBounds(int r, int c)
	{
		if((r < arr.length && r >= 0) && (c < arr[0].length && c >= 0))
			return true;
		return false;
	}
	
	public int getSteps()
	{
		return NumRecursionCall;
	}
}
