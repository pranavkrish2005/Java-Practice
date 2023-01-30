
public class warmUp
{
	public static double avgNumVowels(String[] a)
	{
		double sum = 0;
		String vowel = "aeiouAEIOU";
		
		for(String s : a)
			for(int i = 0; i < s.length(); i++)
				if(vowel.indexOf(s.substring(i ,i + 1)) != -1)
					sum++;
		
		return sum / a.length;
	}

	public static void main(String[] args)
	{
		String[] list = { "New Jersey", "Pennsylvania", "New York", "Delaware", "California", "Idaho", "Illinois", 
				"New Mexico", "Florida" };
		System.out.println(avgNumVowels(list));
	}
}
