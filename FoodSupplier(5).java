import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.LinkedList;

public class FoodSupplier implements FoodSupplierReports
{
	private Map<Date, LinkedList<Orders>> contents;
	
	public FoodSupplier()
	{
		contents = new TreeMap<Date, LinkedList<Orders>>();
	}
	
	public void addOrder(String line)
	{
		String[] d = line.substring(0, line.indexOf(" ")).split("-");
		String o = line.substring(line.indexOf(" ") + 1);
		Date date = new Date(Integer.parseInt(d[2]), Integer.parseInt(d[0]) - 1, Integer.parseInt(d[1]));
		Orders order = new Orders(o);
		LinkedList<Orders> arr = new LinkedList<Orders>();
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

	public Map<Date, LinkedList<Orders>> getContents() {
		return contents;
	}

	public void setContents(Map<Date, LinkedList<Orders>> contents) {
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

//	what date had the most orders of (burgers)? - Mr. S Created
	public String mostItemDate(String item) {
		Date maxdate = new Date();
		int max = 0;
		for(Date x : contents.keySet())
		{
			int total = 0;
			for(Orders or : contents.get(x))
				total += or.getEachitem().get(item);
			if(total > max)
			{
				maxdate = x;
				max = total;
			}
		}
		return this.printDate(maxdate);
	}

//	what company ordered the most (burgers)? - Mr. S Created
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

//	which store went the longest between orders, in days ? - Mr. S Created
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

//	which company ordered the most (burgers) in a (given year)? - Mr. S Created
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

//	return a set of all orders in a (given day) - Mr. S Created
	public Set<Orders> OrdersDay(int day) {
		Set<Orders> one = new HashSet<Orders>();
		for(Date x : contents.keySet())
			if(x.getDate() == day)
				for(Orders or : contents.get(x))
					one.add(or);
		return one;
	}

//	return a set of all orders in a (given month) - Mr. S Created
	public Set<Orders> OrdersMonth(int month) {
		Set<Orders> one = new HashSet<Orders>();
		for(Date x : contents.keySet())
			if(x.getMonth() == month)
				for(Orders or : contents.get(x))
					one.add(or);
		return one;
	}

//	return a set of duplicate orders of a given day - Mr. S Created
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

//	return a set of the companies that ordered at least a (given number) of (burgers) in a (given year) - Mr. S Created
	public Set<String> CompanyItem(int leastnum, String item, int year) {
		Set<String> one = new TreeSet<String>();
		for(Date x : contents.keySet())
			if(x.getYear() == year)
				for(Orders or : contents.get(x))
					if(or.getEachitem().get(item) >= leastnum)
						one.add(or.getRestaurant());
		return one;
	}

//	return a set of all of the orders for a given (company) in a given Date interval - Mr. S Created
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

//	print out a summary/total for orders from a given (company) in a given Date interval - Mr. S Created
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

//	print the total amount of one (product) ordered in a given Date interval - Mr. S Created
	public int TotalProduct(String product, Date start, Date end) {
		int counter = 0;
		for(Date x : contents.keySet())
			if(x.compareTo(start) > 0 && x.compareTo(end) < 0)
				for(Orders or : contents.get(x))
					counter += or.getEachitem().get(product);
		return counter;
	}
	
//	returns the total boxes ordered by the given company in a given time - Pranav Created
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

//	returns the company in which most boxes of orders were placed in a given time - Pranav Created
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
	
//	returns the date in which a particular Order is ordered - Pranav Created
	public String DateofOrder(Orders ord) {
		Date date = new Date();
		for(Date x : contents.keySet())
			for(Orders or : contents.get(x))
			{
				if(or.getRestaurant().equals(ord.getRestaurant()) && or.getEachitem() == ord.getEachitem() && or.getEachitem().equals(ord.getEachitem()))
					date = x;
			}
		if(this.printDate(date).equals("00-00-0000"))
			return "This order does not exist.";
		return this.printDate(date);
	}
	

//	how much money was collected on a given Date (parameter) - Mr. S Created
	public double MoneyonDate(Date date) {
		date.setMonth(date.getMonth() - 1);
		double total = 0;
		FoodPrices fp = new FoodPrices();
		for(Orders or : contents.get(date))
			total += fp.calcTotalCost(or.getEachitem());
		return total;
	}

//	how much money was collected in a given Date interval (2 parameters) - Mr. S Created
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

//	print a billing statement for a given company in a given Date interval (3 parameters) - Mr. S Created
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


//	find the cost of each of the items in the order given a date and return a Set of cost - Pranav Created
	public LinkedList<String> EachItemCost(Date date) {
		LinkedList<String> one = new LinkedList<String>();
		LinkedList<String> two = new LinkedList<String>();
		two.add("burgers");
		two.add("buns");
		two.add("cups");
		two.add("straws");
		two.add("fries");
		two.add("cokesyrup");
		two.add("napkins");
		date.setMonth(date.getMonth() - 1);
		FoodPrices fp = new FoodPrices();
		for(Orders or : contents.get(date))
		{
			int i = 0;
			for(double x : fp.calcCost(or.getEachitem()))
			{
				one.add(two.get(i) + " : " + Double.toString(x));
				i++;
			}
		}
		return one;
	}

//	find the total cost of a item in a given date and item - Pranav Created
	public double ItemCost(Date date, String item) {
		date.setMonth(date.getMonth() - 1);
		FoodPrices fp = new FoodPrices();
		double numitems = 0;
		for(Orders or : contents.get(date))
			if(or.getEachitem().get(item) != 0)
				numitems += or.getEachitem().get(item);
		return numitems * fp.getEachitem().get(item);
	}

//	find the company who ordered the item with the highest cost given a date interval - Pranav Created
	public String CompanyHighestCost(Date start, Date end) {
		end.setMonth(end.getMonth() - 1);
		start.setMonth(start.getMonth() - 1);
		FoodPrices fp = new FoodPrices();
		Map<String, Double> one = new HashMap<String, Double>();
		for(Date x : contents.keySet())
			if(x.compareTo(start) > 0 && x.compareTo(end) < 0)
				for(Orders or : contents.get(x))
				{
					if(one.get(or.getRestaurant()) == null)
						one.put(or.getRestaurant(), fp.calcTotalCost(or.getEachitem()));
					else
						one.put(or.getRestaurant(), fp.calcTotalCost(or.getEachitem()) + one.get(or.getRestaurant()));
				}
		double max = 0.0;
		String company = "";
		
		for(String x : one.keySet())
			if(one.get(x) > max)
			{
				max = one.get(x);
				company = x;
			}
		return company;
	}
	

	
}
