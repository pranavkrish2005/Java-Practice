import java.util.Map;
import java.util.TreeMap;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class Acronyms
{
	private Map<String,String> acronymTable;

	public Acronyms()
	{
		acronymTable = new TreeMap<String, String>();
	}

	public void putEntry(String entry)
	{
		String letter = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		String key = entry.substring(0, entry.indexOf(" "));
		String val = entry.substring(entry.indexOf("-") + 2);
		acronymTable.put(key, val);
	}
	
	
	public String reconvert(String sent)
	{
		String output = "";
		String str = "";
		String[] s = sent.split(" ");
		Set<String> set = acronymTable.keySet();
		for(int i = 0; i < s.length; i++)
		{
			for(String x : set)
			{
				if(acronymTable.get(x).contains(s[i]))
				{
					str += s[i];
					int j = i;
					while(j < s.length)
					{
						if(acronymTable.get(x).contains(str))
						{
							str += s[j];
							j++;
						}
						else {
							j--;
							i = j;
							output += x;
							break;
						}
					}
				}
				else
					output += s[i];
			}
		}
		
		return output + ".";
	}
	
	
	
	public String convert(String sent)
	{
		String[] s = sent.split(" ");
		String output ="";
		for(int i = 0; i < s.length; i++)
		{
			if(s[i].indexOf(".") != -1)
			{
				s[i] = s[i].substring(0, s[i].length() - 1);
				if(acronymTable.get(s[i]) == null)
					output += s[i] + ".";
				else
					output += acronymTable.get(s[i]) + ".";
			}
			else
			{
				if(acronymTable.get(s[i]) == null)
					output += s[i] + " ";
				else
					output += acronymTable.get(s[i]) + " ";
			}
			
		}
		return output;
	}

	public String toString()
	{
		String output = "{";
		for(String x : acronymTable.keySet())
			output += x + " - " + acronymTable.get(x) + "\n";
		return output + "}";
	}
}
