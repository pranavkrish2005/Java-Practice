import java.util.Arrays;
public class WarmUp2
{
	public static String[] moreThanOneWord(String[] a)
	{
		int num = 0;
		for(int i = 0; i < a.length; i++)
			if(a[i].contains(" "))
				num++;
		String[]arr = new String[num];
		int count = 0;
		for(int i = 0; i < a.length; i++)
			if(a[i].contains(" "))
			{
//				arr[count] = a[i];
//				count++;
//				you can also do, this down, which means that it will increment count after it executes the line.
				arr[count++] = a[i];
			}
		return arr;
	}

	
	
	
	
	
	public static void main(String[] args) {
		String[] list = { "New Jersey", "Pennsylvania", "New York", "Delaware", "California", "Idaho", "Illinois",
				"New Mexico", "North Carolina", "Florida" };
		String[] b = moreThanOneWord(list);
		System.out.println(Arrays.toString(b));

	}
}
