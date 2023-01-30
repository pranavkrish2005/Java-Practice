public class CodingRecursionLesson02 {
	
	public static String reverseString(String text)
	{
		if(text.length() == 1)
			return text;
		else
			return text.substring(text.length() - 1) + reverseString(text.substring(0, text.length() - 1));
	}
	
	
	public static boolean isPalindrome(String text)
	{
		if(text.length() == 1)
			return true;
		else if(text.substring(0, 1).equals(text.substring(text.length() - 1)))
			return isPalindrome(text.substring(1, text.length() - 1));
		else
			return false;
			
	}
	
	
	public static int countOddDigits(int num)
	{
		if(num <= 0)
			return 0;
		else if((num % 10) % 2 == 1)
			return 1 + countOddDigits(num/10);
		else
			return countOddDigits(num/10);
	}
	
	
	
	public static void main(String[] args) {
		// Testers for reverse
		System.out.println("Result: " +  reverseString("Hello!"));
		System.out.println("Expected: !olleH");
		System.out.println("Result: " + reverseString("Odd"));
		System.out.println("Expected: ddO");
		System.out.println();
		
		// Testers for isPalindrome
		System.out.println("madam is " + isPalindrome("madam"));
		System.out.println("Madam is " + isPalindrome("Madam"));
		System.out.println("Frank is " + isPalindrome("Frank"));
		System.out.println("racecar is " + isPalindrome("racecar"));
		System.out.println();
		
		// Testers for countOddDigits
		System.out.println("# of odds in 4532: " + countOddDigits(4532));
		System.out.println("# of odds in 1114532: " + countOddDigits(1114532));
		System.out.println("# of odds in 2245327: " + countOddDigits(2245327));
		System.out.println("# of odds in 13579: " + countOddDigits(13579));

	}

}