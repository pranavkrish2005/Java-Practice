import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Factors
{
	public static ArrayList<Integer> getListOfFactors(int number)
	{
		int num = number;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 2; i < num; i++)
			if(num % i == 0)
				arr.add(i);
		return arr;
			
	}
	
	public static void keepOnlyCompositeNumbers( List<Integer> nums )
	{
		for(int i = 0; i < nums.size(); i++)
			if(getListOfFactors(nums.get(i)).size() == 0)
				nums.remove(i);
	}
}