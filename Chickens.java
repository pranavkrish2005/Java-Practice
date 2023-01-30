import static java.lang.System.*;

public class Chickens
{
	public static int countChickens(String word)
	{
		int index = word.indexOf("chicken");
		if(index == -1)
		return 0;
		else
			return 1 + countChickens(word.substring(0, index) + word.substring(index + 7));
	}
	
	public static void main(String args[])
	{
		System.out.println(countChickens("itatfun"));
		System.out.println(countChickens("itatchickenfun"));
		System.out.println(countChickens("chchickchickenenicken"));
		System.out.println(countChickens("chickchickfun"));
		System.out.println(countChickens("chickenbouncetheballchicken"));
	}
}