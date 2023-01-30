import java.util.Arrays;


public class TakeFour
{
	static int[] arr = {2, 5, 1, 7, 3, 9, 6, 9, 4, 8, 11, 0, 13, 8, 9, 1, 7, 5, 2, 6};

	public static void takeFour(int[] a)
	{
		int[] temp = new int[a.length];
		for(int i = 0; i < a.length; i++)
			temp[i] = a[(i + 1)%a.length] + a[(i + 2)%a.length] + a[(i + 3)%a.length] + a[(i + 4)%a.length];
		arr = temp;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(arr));
		takeFour(arr);
		System.out.println(Arrays.toString(arr));
		
	}

}