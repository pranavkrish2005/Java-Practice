import java.util.Arrays;
import java.util.Scanner;
public class OddsandEvens
{
	private int[]num;
	public OddsandEvens(int arr[])
	{
		num = arr;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array : ");
		int index = sc.nextInt();
		int arr[] = new int[index];
		for(int i = 0; i < index; i++)
		{
			System.out.println("Enter the " + (i + 1) + " element in the array : ");
			arr[i] = sc.nextInt();
		}
		OddsandEvens one = new OddsandEvens(arr);
		System.out.println("Evens : " + Arrays.toString(one.getEven()));
		System.out.println("Odds : " + Arrays.toString(one.getOdd()));
	}
	
	public int evenNum()
	{
		int evencount = 0;
		for(int x : num)
			if(x % 2 == 0)
				evencount++;
		return evencount;
	}
	
	public int[] getEven()
	{
		int count = 0;
		int[]even = new int[evenNum()];
		for(int i = 0; i < num.length; i++)
			if(num[i] % 2 == 0)
				even[count++] = num[i];
		return even;
	}
	
	public int oddNum()
	{
		int oddcount = 0;
		for(int x : num)
			if(x % 2 == 1)
				oddcount++;
		return oddcount;
	}
	
	public int[] getOdd()
	{
		int count = 0;
		int[]odd = new int[oddNum()];
		for(int i = 0; i < num.length; i++)
			if(num[i] % 2 == 1)
				odd[count++] = num[i];
		return odd;
	}
}
