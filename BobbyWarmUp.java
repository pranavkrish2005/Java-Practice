import java.util.Arrays;
import java.util.ArrayList;
public class BobbyWarmUp
{
	public static void checkAlphabet(ArrayList<String> arr)
	{
		int count = 0;
		for(int i = arr.size() - 1; i > 0; i--)
			if(arr.get(i).compareTo(arr.get(i - 1)) < 0)
			{
				System.out.println("Bobby added " + arr.get(i));
				arr.remove(i);
				count = 1;
			}
		if(count == 0)
			System.out.println("The list is still alphabetical – I don’t know which word(s) Bobby put in.");
		System.out.println(arr.toString());
	}
	
	public static void main(String args[])
	{
		String[] temp = {"Airplane", "Ben", "Pranav", "Shekhar", "Zebra"};
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(temp));
		
		String[] temp1 = {"Airplane", "Ben", "Shekhar", "Zebra", "Pranav"};
		ArrayList<String> list1 = new ArrayList<String>(Arrays.asList(temp1));
		
		String[] temp2 = {"Ben", "Airplane", "Zebra","Shekhar" ,"Pranav"};
		ArrayList<String> list2 = new ArrayList<String>(Arrays.asList(temp2));
		
		checkAlphabet(list);
		checkAlphabet(list1);
		checkAlphabet(list2);
	}
}
