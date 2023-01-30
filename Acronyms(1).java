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
		for(int i = 0; i < s.length; i++)
		{
			str = s[i];
			for(String x : acronymTable.keySet())
			{
				if(acronymTable.get(x).indexOf(" ") == -1 && acronymTable.get(x).equalsIgnoreCase(s[i]))
					str = x;
				else if(acronymTable.get(x).indexOf(" ") == -1)
					continue;
				else if(acronymTable.get(x).substring(0, 1).equalsIgnoreCase(s[i].substring(0, 1)))
				{
					String[] temp = acronymTable.get(x).split(" ");
					int j = 0;
					while(j < temp.length && i + j < s.length)
					{
						if(temp[j].equals(s[i + j]))
							j++;
						else
							break;
					}
					if(j == temp.length)
					{
						str = x;
						i += j - 1;
					}
				}
			}
			output += str + " ";
		}
		
		return output.substring(0, output.length() - 1) + ".";
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
