import java.util.*;

public class Scramble {

	public static String scrambleWord(String word)
	{
		for(int i = 0; i < word.length() - 1; i++)
			if(word.substring(i, i + 1).equals("A") && !word.substring(i + 1, i + 2).equals("A"))
			{
				word = word.substring(0, i) + word.substring(i + 1, i + 2) + word.substring(i, i + 1)
						+ word.substring(i + 2);
				i++;
			}
		return word;
	}
	
	public static void scrambleOrRemove(List<String> wordList)
	{
		String check = "";
		for(int i = wordList.size() - 1; i >= 0; i--)
		{
			check = scrambleWord(wordList.get(i));
			if(wordList.get(i).equals(check))
				wordList.remove(i);
			else
				wordList.set(i, check);
		}
	}
	
	
	public static void main(String[] args) {
		
	String[] words = {"TAN", "ABRACADABRA", "WHOA", "AARDVARK", "EGGS", "A", ""};
	for (int i = 0; i < words.length; i++)
		System.out.println(scrambleWord(words[i]));
	
	String[] words2 = {"TAN", "ABRACADABRA", "WHOA", "APPLE", "EGGS",};
	List <String> list = new ArrayList<String>(Arrays.asList(words2));
	System.out.println(list);
	scrambleOrRemove(list);
	System.out.println(list);

	}

}