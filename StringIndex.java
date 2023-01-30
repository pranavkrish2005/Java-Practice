public class StringIndex
{



	/**
	 * Determines if a string exists in a phrase.
	 * 
	 */
	public static int indexOf(String text, String str)
	{
		return indexOf(text, str, 0);
	}

	/**
	 * Determines if a string exists in a phrase.
	 * Helper method
	 */
	private static int indexOf(String text, String str, int num)  
	{
		if(text.length() < num + str.length())
			return -1;
		
		else if(text.substring(num, num + str.length()).equals(str))
			return num;
		
		else
			return indexOf(text, str, num + 1);
	}
	
	public static void main(String[] args)
	   {
	      System.out.println(StringIndex.indexOf("Mississippi", "sip"));
	      System.out.println("Expected: 6");
	      System.out.println(StringIndex.indexOf("Mississippi", "Miss"));
	      System.out.println("Expected: 0");
	      System.out.println(StringIndex.indexOf("shoe", "oe"));
	      System.out.println("Expected: 2");
	      System.out.println(StringIndex.indexOf("shoe", "foot"));
	      System.out.println("Expected: -1");
	   }
}