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
		return this.printDate(maxdate) + " had " + max + " " + item + " ordered";
	}

//	what company ordered the most (burgers)? - Mr. S Created
	public String mostItemCompany(String item) {
		Map<String, Integer> one = new TreeMap<String, Integer>();
		for(Date x : contents.keySet())
			for(Orders or : contents.get(x))
			{
				if(one.get(or.getCompany()) == null)
					one.put(or.getCompany(), or.getEachitem().get(item));
				else
					one.put(or.getCompany(), one.get(or.getCompany()) + or.getEachitem().get(item));
			}
		
		String maxcompany = "";
		int maxorder = 0;
		for(String x : one.keySet())
			if(one.get(x) > maxorder)
			{
				maxcompany = x;
				maxorder = one.get(x);
			}
		System.out.println(one.toString());
		return maxcompany + " had " + maxorder + " " + item + " ordered";
	}

//	which store went the longest between orders, in days ? - Mr. S Created
	public String LongestBetweenOrders() {
		Map<String, Date> one = new  TreeMap<String, Date>();
		long longest = 0;
		String company = "";
		for(Date x : contents.keySet())
			for(Orders or : contents.get(x))
			{
				String order = or.getCompany() + "#" + or.getRestaurant();
				if(one.get(order) != null)
				{
					if(longest < Math.abs(one.get(order).getTime() - x.getTime())/(1000*3600*24))
					{
						longest =  Math.abs(one.get(order).getTime() - x.getTime())/(24 * 60 * 60 * 1000);
						company = or.getCompany();
					}
				}
				one.put(order, x);
			}
		return company + " took " + longest + " between orders";
}

//	which company ordered the most (burgers) in a (given year)? - Mr. S Created
	public String mostItemCompany(String item, int year) {
		Map<String, Integer> one = new TreeMap<String, Integer>();
		for(Date x : contents.keySet())
			if(x.getYear() == year)
				for(Orders or : contents.get(x))
				{
					if(one.get(or.getCompany()) == null)
						one.put(or.getCompany(), or.getEachitem().get(item));
					else
						one.put(or.getCompany(), one.get(or.getCompany()) + or.getEachitem().get(item));
				}
		
		String maxcompany = "";
		int maxorder = 0;
		for(String x : one.keySet())
			if(one.get(x) > maxorder)
			{
				maxcompany = x;
				maxorder = one.get(x);
			}
		return maxcompany + " ordered " + maxorder + " " + item + ".";
	}


//	return a set of all orders in a (given day) - Mr. S Created
	public Set<Orders> OrdersDay(Date day) {
		Set<Orders> one = new HashSet<Orders>();
		for(Orders or : contents.get(day))
			one.add(or);
		return one;
	}

//	return a set of all orders in a (given month) - Mr. S Created
	public Set<Orders> OrdersMonth(int month, int year) {
		Set<Orders> one = new HashSet<Orders>();
		for(Date x : contents.keySet())
			if(x.getMonth() == month && x.getYear() == year)
				for(Orders or : contents.get(x))
					one.add(or);
		return one;
	}

//	return a set of duplicate orders of a given day - Mr. S Created
	public Set<String> DuplicateOrders(Date day) {
		Map<String, Integer> temp = new HashMap<String, Integer>();
		Set<String> one = new HashSet<String>();
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
						one.add(or.getCompany());
		return one;
	}

//	return a set of all of the orders for a given (company) in a given Date interval - Mr. S Created
	public Set<Orders> CompanyOrders(Date start, Date end, String company) {
		Set<Orders> one = new HashSet<Orders>();
		for(Date x : contents.keySet())
			if(x.compareTo(start) > 0 && x.compareTo(end) < 0)
				for(Orders or : contents.get(x))
					if(or.getCompany().equals(company))
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
					if(or.getCompany().equals(company))
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
	
//	returns the item that a restaurant has ordered the most - Pranav Created
	public String CompanyMostOrders(String restuaurant) {
		int max = 0;
		String item = "";
		Map<String, Integer> one = new HashMap<String, Integer>();
		one.put("burgers", 0);
		one.put("buns", 0);
		one.put("cups", 0);
		one.put("straws", 0);
		one.put("fries", 0);
		one.put("cokesyrup", 0);
		one.put("napkins", 0);
		for(Date x : contents.keySet())
			for(Orders or : contents.get(x))
				if((or.getCompany() + "#" + or.getRestaurant()).equals(restuaurant))
					for(String m : or.getEachitem().keySet())
						one.put(m, one.get(m) + or.getEachitem().get(m));
		
		for(String x : one.keySet())
			if(one.get(x) > max)
			{
				item = x;
				max = one.get(x);
			}
		return item + " had " + max + " orders.";
	}

//	returns the items that were not ordered by a company in a given date - Pranav Created
	public Set<String> ItemsnotOrdered(String company, Date date) {
		Set<String> one = new HashSet<String>();
		for(Orders or : contents.get(date))
			if(or.getCompany().equals(company))
				for(String m : or.getEachitem().keySet())
					if(or.getEachitem().get(m) == 0)
						one.add(m);
		return one;
	}
	
//	returns the date in which a particular Order is ordered - Pranav Created
	public String DateofOrder(Orders ord) {
		Date date = new Date();
		for(Date x : contents.keySet())
			for(Orders or : contents.get(x))
			{
				if(or.getCompany().equals(ord.getCompany()) && or.getEachitem() == ord.getEachitem() && or.getEachitem().equals(ord.getEachitem()))
					date = x;
			}
		if(this.printDate(date).equals("00-00-0000"))
			return "This order does not exist.";
		return this.printDate(date);
	}
	

//	how much money was collected on a given Date (parameter) - Mr. S Created
	public double MoneyonDate(Date date) {
		double total = 0;
		FoodPrices fp = new FoodPrices();
		for(Orders or : contents.get(date))
			total += fp.calcTotalCost(or.getEachitem());
		return total;
	}

//	how much money was collected in a given Date interval (2 parameters) - Mr. S Created
	public double MoneyonDateInterval(Date start, Date end) {
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
		FoodPrices fp = new FoodPrices();
		double total = 0;
		for(Date x : contents.keySet())
			if(x.compareTo(start) > 0 && x.compareTo(end) < 0)
				for(Orders or : contents.get(x))
					if(or.getCompany().equals(company))
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
		FoodPrices fp = new FoodPrices();
		double numitems = 0;
		for(Orders or : contents.get(date))
			if(or.getEachitem().get(item) != 0)
				numitems += or.getEachitem().get(item);
		return numitems * fp.getEachitem().get(item);
	}

//	find the company who ordered the item with the highest cost given a date interval - Pranav Created
	public String CompanyHighestCost(Date start, Date end) {
		FoodPrices fp = new FoodPrices();
		Map<String, Double> one = new HashMap<String, Double>();
		for(Date x : contents.keySet())
			if(x.compareTo(start) > 0 && x.compareTo(end) < 0)
				for(Orders or : contents.get(x))
				{
					if(one.get(or.getCompany()) == null)
						one.put(or.getCompany(), fp.calcTotalCost(or.getEachitem()));
					else
						one.put(or.getCompany(), fp.calcTotalCost(or.getEachitem()) + one.get(or.getCompany()));
				}
		double max = 0.0;
		String company = "";
		
		for(String x : one.keySet())
			if(one.get(x) > max)
			{
				max = one.get(x);
				company = x;
			}
		return company + " with a cost of $" + max;
	}
	

	
}
