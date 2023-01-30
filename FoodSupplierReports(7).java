import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public interface FoodSupplierReports
{
//	what date had the most orders of (burgers)?
	public String mostItemDate(String item);
//	what company ordered the most (burgers)?
	public String mostItemCompany(String item);
//	which store went the longest between orders, in days ?
	public String LongestBetweenOrders();
//	which company ordered the most (burgers) in a (given year)?
	public String mostItemCompany(String item, int year);
//	return a set of all orders in a (method A - given day), (Method B - given month)
	public Set<Orders> OrdersDay(int day);
	public Set<Orders> OrdersMonth(int month);
//	return a set of duplicate orders of a given day - (use 1-9-2010 to test)
	public Set<String> DuplicateOrders(Date day);
//	return a set of the companies that ordered at least a (given number) of (burgers) in a (given year)
	public Set<String> CompanyItem(int leastnum, String item, int year);
//	return a set of all of the orders for a given (company) in a given Date interval
	public Set<Orders> CompanyOrders(Date start, Date end, String company);
//	print out a summary/total for orders from a given (company) in a given Date interval
	public Set<Double> CompanyTotal(Date start, Date end, String company);
//	print the total amount of one (product) ordered in a given Date interval
	public int TotalProduct(String product, Date start, Date end);
//	returns the total boxes ordered by the given company in a given time
	public int TotalOrders(String company, Date start, Date end);
//	return the company in which most boxes of orders were placed in a given time
	public String MostBoxes(Date start, Date end);
//	how much money was collected on a given Date (parameter)
	public double MoneyonDate(Date date);
//	how much money was collected in a given Date interval (2 parameters)
	public double MoneyonDateInterval(Date start, Date end);
//	print a billing statement for a given company in a given Date interval (3 parameters)
	public String BillingStatement(Date start, Date end, String company);
//	find the cost of each of the items in the order given a date and return a Set of cost
	public ArrayList<Double> EachItemCost(Date date);
//	find the total cost of a item in a given date and item
	public double ItemCost(Date date, String item);
	
}
