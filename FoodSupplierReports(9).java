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
	public Set<Orders> DuplicateOrders(Date day);
//	return a set of the companies that ordered at least a (given number) of (burgers) in a (given year)
	public Set<String> CompanyItem(int leastnum, String item, int year);
//	return a set of all of the orders for a given (company) in a given Date interval
	public Set<Orders> CompanyOrders(Date start, Date end, String company);
//	print out a summary/total for orders from a given (company) in a given Date interval
	public Set<Orders> CompanyTotal(Date start, Date end, String company);
//	print the total amount of one (product) ordered in a given Date interval
	public int TotalProduct(String product, Date start, Date end);
}
