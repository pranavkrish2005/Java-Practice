import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class FoodSupplier
{
	private Map<Date, Orders> contents;
	
	public FoodSupplier()
	{
		contents = new TreeMap<Date, Orders>();
	}
	
	public void addOrder(String line)
	{
		String[] d = line.substring(0, line.indexOf(" ")).split("-");
		String o = line.substring(line.indexOf(" ") + 1);
		
		Date date = new Date(Integer.parseInt(d[2]), Integer.parseInt(d[0]), Integer.parseInt(d[1]));
		Orders order = new Orders(o);
		
		contents.put(date, order);
	}

	public Map<Date, Orders> getContents() {
		return contents;
	}

	public void setContents(Map<Date, Orders> contents) {
		this.contents = contents;
	}
	
	public String toString()
	{
		String output = "";
		for(Date x : contents.keySet())
			output += x.getMonth() + "-" + x.getDate() + "-" + x.getYear() + " " + contents.get(x).toString() + "\n";
		return output;
	}
	
}
