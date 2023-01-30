import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
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
		String company = "";
		long maxdays = 0;
		for(Date x : contents.keySet())
			for(Orders or : contents.get(x))
				for(Date j : contents.keySet())
					for(Orders ord : contents.get(j))
					{
						if(ord.getRestaurant().equals(or.getRestaurant()) && maxdays < Math.abs(x.getTime() - j.getTime()))
						{
							company = ord.getRestaurant();
							maxdays = Math.abs(x.getTime() - j.getTime());
						}
					}
		return company;
	}

	@Override
	public String mostItemCompany(String item, int year) {
		String company = "";
		int mostitem = 0;
		for(Date x : contents.keySet())
			if(x.getYear() == year)
				for(Orders or : contents.get(x))
				{
					if(mostitem < or.getEachitem().get(item))
					{
						mostitem = or.getEachitem().get(item);
						company = or.getRestaurant();
					}
				}
		return company;
	}

	@Override
	public Set<Orders> OrdersDay(int day) {
		Set<Orders> one = new HashSet<Orders>();
		for(Date x : contents.keySet())
			if(x.getDate() == day)
				for(Orders or : contents.get(x))
					one.add(or);
		return one;
	}

	@Override
	public Set<Orders> OrdersMonth(int month) {
		Set<Orders> one = new HashSet<Orders>();
		for(Date x : contents.keySet())
			if(x.getMonth() == month)
				for(Orders or : contents.get(x))
					one.add(or);
		return one;
	}

	@Override
	public Set<String> DuplicateOrders(Date day) {
		Map<String, Integer> temp = new HashMap<String, Integer>();
		Set<String> one = new HashSet<String>();
		day.setMonth(day.getMonth() - 1);
			for(Orders or : contents.get(day))
			{
				for(String str : or.getEachitem().keySet())
					if(or.getEachitem().get(str) != 0)
					{
						if(temp.containsKey(str) && (int)temp.get(str) == (int)or.getEachitem().get(str))
							one.add(str + "-" + or.getEachitem().get(str));
						else if(!temp.containsKey(str))
							temp.put(str, or.getEachitem().get(str));
					}
			}
		return one;
	}

	@Override
	public Set<String> CompanyItem(int leastnum, String item, int year) {
		Set<String> one = new TreeSet<String>();
		for(Date x : contents.keySet())
			if(x.getYear() == year)
				for(Orders or : contents.get(x))
					if(or.getEachitem().get(item) >= leastnum)
						one.add(or.getRestaurant());
		return one;
	}

	@Override
	public Set<Orders> CompanyOrders(Date start, Date end, String company) {
		end.setMonth(end.getMonth() - 1);
		start.setMonth(start.getMonth() - 1);
		Set<Orders> one = new HashSet<Orders>();
		for(Date x : contents.keySet())
			if(x.compareTo(start) > 0 && x.compareTo(end) < 0)
				for(Orders or : contents.get(x))
					if(or.getRestaurant().equals(company))
						one.add(or);
		return one;
	}

	@Override
	public Set<Double> CompanyTotal(Date start, Date end, String company) {
		Set<Double> one = new TreeSet<Double>();
		FoodPrices fp = new FoodPrices();
		for(Date x : contents.keySet())
			if(x.compareTo(start) > 0 && x.compareTo(end) < 0)
				for(Orders or : contents.get(x))
					if(or.getRestaurant().equals(company))
						one.add(fp.calcTotalCost(or.getEachitem()));
		return one;
	}

	@Override
	public int TotalProduct(String product, Date start, Date end) {
		int counter = 0;
		for(Date x : contents.keySet())
			if(x.compareTo(start) > 0 && x.compareTo(end) < 0)
				for(Orders or : contents.get(x))
					counter += or.getEachitem().get(product);
		return counter;
	}
	
	@Override
	public int TotalOrders(String company, Date start, Date end) {
		end.setMonth(end.getMonth() - 1);
		start.setMonth(start.getMonth() - 1);
		int total = 0;
		for(Date x : contents.keySet())
			if(x.compareTo(start) > 0 && x.compareTo(end) < 0)
				for(Orders or : contents.get(x))
					if(or.getRestaurant().equals(company))
						total += or.getNumboxes();
		return total;
	}

	@Override
	public String MostBoxes(Date start, Date end) {
		String company = "";
		int mostboxes = 0;
		for(Date x : contents.keySet())
			if(x.compareTo(start) > 0 && x.compareTo(end) < 0)
				for(Orders or : contents.get(x))
					if(or.getNumboxes() > mostboxes)
					{
						mostboxes = or.getNumboxes();
						company = or.getRestaurant();
					}
		return company;
	}

	@Override
	public double MoneyonDate(Date date) {
		date.setMonth(date.getMonth() - 1);
		double total = 0;
		FoodPrices fp = new FoodPrices();
		for(Orders or : contents.get(date))
			total += fp.calcTotalCost(or.getEachitem());
		return total;
	}

	@Override
	public double MoneyonDateInterval(Date start, Date end) {
		end.setMonth(end.getMonth() - 1);
		start.setMonth(start.getMonth() - 1);
		FoodPrices fp = new FoodPrices();
		double total = 0;
		for(Date x : contents.keySet())
			if(x.compareTo(start) > 0 && x.compareTo(end) < 0)
				for(Orders or : contents.get(x))
					total += fp.calcTotalCost(or.getEachitem());
		return total;
	}

	@Override
	public String BillingStatement(Date start, Date end, String company) {
		String statement  = "Date : \t\t TotalCost : \n";
		end.setMonth(end.getMonth() - 1);
		start.setMonth(start.getMonth() - 1);
		FoodPrices fp = new FoodPrices();
		double total = 0;
		for(Date x : contents.keySet())
			if(x.compareTo(start) > 0 && x.compareTo(end) < 0)
				for(Orders or : contents.get(x))
					if(or.getRestaurant().equals(company))
						statement += this.printDate(x) + "\t\t" + fp.calcTotalCost(or.getEachitem()) + "\n";
		return statement;
	}


	@Override
	public ArrayList<Double> EachItemCost(Date date) {
		ArrayList<Double> one = new ArrayList<Double>();
		date.setMonth(date.getMonth() - 1);
		FoodPrices fp = new FoodPrices();
		for(Orders or : contents.get(date))
			for(double x : fp.calcCost(or.getEachitem()))
				one.add(x);
		return one;
	}

	@Override
	public double ItemCost(Date date, String item) {
		date.setMonth(date.getMonth() - 1);
		FoodPrices fp = new FoodPrices();
		double numitems = 0;
		for(Orders or : contents.get(date))
			if(or.getEachitem().get(item) != 0)
				numitems += or.getEachitem().get(item);
		return numitems * fp.getEachitem().get(item);
	}
	
	

	
}
