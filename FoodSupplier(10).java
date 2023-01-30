import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;

public class FoodSupplier implements FoodSupplierReports
{
	private Map<Date, ArrayList<Orders>> contents;
	
	public FoodSupplier()
	{
		contents = new TreeMap<Date, ArrayList<Orders>>();
	}
	
	public void addOrder(String line)
	{
		String[] d = line.substring(0, line.indexOf(" ")).split("-");
		String o = line.substring(line.indexOf(" ") + 1);
		
		Date date = new Date(Integer.parseInt(d[2]), Integer.parseInt(d[0]) - 1, Integer.parseInt(d[1]));
		Orders order = new Orders(o);
		ArrayList<Orders> arr = new ArrayList<Orders>();
		if(contents.get(date) == null)
		{
			arr.add(order);
			contents.put(date, arr);
		}
		else
		{
			arr = contents.get(date);
			arr.add(order);
			contents.put(date, arr);
		}
	}

	public Map<Date, ArrayList<Orders>> getContents() {
		return contents;
	}

	public void setContents(Map<Date, ArrayList<Orders>> contents) {
		this.contents = contents;
	}
	
	public String toString()
	{
		String output = "";
		for(Date x : contents.keySet())
			for(Orders or : contents.get(x))
				output += this.printDate(x) + " " + or.toString() + "\n";
		return output;
	}
	
	public String printDate(Date x)
	{
		String output = "";
		if(x.getMonth() + 1 < 10)
			output += "0" + (x.getMonth() + 1);
		else
			output += x.getMonth() + 1;
		output += "-";
		if(x.getDate() < 10)
			output += "0" + x.getDate();
		else
			output += x.getDate();
		output += "-";
		return output + x.getYear();
	}

	@Override
	public String mostItemDate(String item) {
		Date maxdate = new Date();
		int max = 0;
		for(Date x : contents.keySet())
			for(Orders or : contents.get(x))
				if(or.getEachitem().get(item) >= max)
				{
					maxdate = x;
					max = or.getEachitem().get(item);
				}
		return this.printDate(maxdate);
	}

	@Override
	public String mostItemCompany(String item) {
		Map<String, Integer> one = new TreeMap<String, Integer>();
		for(Date x : contents.keySet())
			for(Orders or : contents.get(x))
			{
				if(one.get(or.getRestaurant()) == null)
					one.put(or.getRestaurant(), or.getEachitem().get(item));
				else
					one.put(or.getRestaurant(), one.get(or.getRestaurant()) + or.getEachitem().get(item));
			}
		
		String maxcompany = "";
		int maxorder = 0;
		for(String x : one.keySet())
			if(one.get(x) > maxorder)
			{
				maxcompany = x;
				maxorder = one.get(x);
			}
		return maxcompany;
	}

	@Override
	public String LongestBetweenOrders() {
//		for(Date x : contents.keySet())
//			for(Orders or : contents.get(x))
//				for(Date j : contents.keySet())
//					for(Orders ord : contents.get(j))
		return null;
	}

	@Override
	public String mostItemCompany(String item, int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Orders> OrdersDay(String day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Orders> OrdersMonth(String month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Orders> DuplicateOrders(Date day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Orders> CompanyItem(int leastnum, String item, String year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Orders> CompanyOrders(Date start, Date end, String company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Orders> CompanyTotal(Date start, Date end, String company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int TotalProduct(String product, Date start, Date end) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
