import java.util.Collections;
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
		String key = entry.substring(0, entry.indexOf(" "));
		String val = entry.substring(entry.indexOf("-") + 2);
		acronymTable.put(key, val);
	}
	
	
	public String reconvert(String sent)
	{
		String output = "";
		String[] s = sent.split(" ");
		String[] periodindex = new String[s.length];
		for(int m = 0; m < s.length; m++)
			if(s[m].contains(".") || s[m].contains(",") || s[m].contains("!"))
			{
				periodindex[m] = s[m].substring(s[m].length() - 1, s[m].length());
				s[m] = s[m].substring(0, s[m].length() - 1);
			}
		for(int i = 0; i < s.length; i++)
		{
			Map<Integer,String> jtable = new TreeMap<Integer,String>();
			for(String x : acronymTable.keySet())
			{
				if(acronymTable.get(x).indexOf(" ") == -1 && acronymTable.get(x).equalsIgnoreCase(s[i]))
					jtable.put(1, x);
				else if(acronymTable.get(x).indexOf(" ") == -1)
					continue;
				else if(acronymTable.get(x).substring(0, 1).equalsIgnoreCase(s[i].substring(0, 1)))
				{
					String[] temp = acronymTable.get(x).split(" ");
					for(int m = 0; m < temp.length; m++)
					{
						if(temp[m].contains("."))
							temp[m] = temp[m].substring(0, temp[m].indexOf("."));
						else if(temp[m].contains(","))
							temp[m] = temp[m].substring(0, temp[m].indexOf(","));
						else if(temp[m].contains("!"))
							temp[m] = temp[m].substring(0, temp[m].indexOf("!"));
					}
					int j = 0;
					while(j < temp.length && i + j < s.length)
					{
						if(temp[j].equalsIgnoreCase(s[i + j]))
							j++;
						else
							break;
					}
					if(j == temp.length)
						jtable.put(j, x);
				}
			}
			if(jtable.isEmpty())
			{
				if(periodindex[i] != null)
					output += s[i] + periodindex[i] + " ";
				else
					output += s[i] + " ";
			}
			else
			{
				int coll = Collections.max(jtable.keySet());
				if(periodindex[i + coll - 1] != null)
					output += jtable.get(coll) + periodindex[i + coll - 1] + " ";
				else
					output += jtable.get(coll) + " ";
				i += coll - 1;
			}
		}
		
		return output.substring(0, output.length() - 1);
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
