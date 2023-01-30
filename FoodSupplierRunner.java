import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class FoodSupplierRunner
{
	public static void main(String args[]) throws IOException
	{
		File fi = new File("C:\\Users\\Srinika\\Documents\\java_coding\\Pranav\\workspace\\Maps\\supplyOrders.dat");
		Scanner sc = new Scanner(fi);
		int ind = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Y if you want to add more to the file or N if no : ");
		Scanner scan = new Scanner(System.in);
		String check = scan.nextLine();
		FileWriter fw = new FileWriter("C:\\Users\\Srinika\\Documents\\java_coding\\Pranav\\workspace\\Maps\\supplyOrders.dat", true);
		while(check.equalsIgnoreCase("Y"))
		{
			System.out.println("Enter the date and order to add : ");
			String add = scan.nextLine();
			fw.write("\n" + add);
			ind++;
			System.out.println("Enter Y if you want to add more to the file or N if no : ");
			check = scan.nextLine();
		}
		fw.close();
		System.out.println("Enter F if you want the output to be in a file and W if you want to write in the console :");
		String out = scan.nextLine();
		FoodSupplier supply = new FoodSupplier();
		String name = "";
		if(out.equalsIgnoreCase("F"))
		{
			System.out.println("Enter the name of the file : ");
			name = scan.nextLine();
		}
		for(int i = 0; i < ind; i++)
			supply.addOrder(sc.nextLine());
		System.out.println("Enter the method you want to call : "
				+ "\nA to print out the orders"
				+ "\nB to print the date with most order of a item"
				+ "\nC to print the company with the most orders of a item"
				+ "\nD for Store with the longest between their orders"
				+ "\nE Company that ordered the most item in a given year"
				+ "\nF All orders in a day"
				+ "\nG all orders in a month"
				+ "\nH Duplicate orders in a given day"
				+ "\nI Companies that ordered at least a given number of burgers in a year"
				+ "\nJ Orders of a company in a given Date interval"
				+ "\nK give a summary/total of orders from a given company in a given date interval"
				+ "\nL total amount of one item ordered in a given Date interval"
				+ "\nM Boxes ordered by the given company in a given time"
				+ "\nN date in which a particular Order is ordered"
				+ "\nO company in which most boxes of orders were placed in a given time"
				+ "\nP Money collected on a given Date"
				+ "\nQ money collected in a Date interval"
				+ "\nR billing statement for a given company in a given Date interval"
				+ "\nS A list of each item ordered and their price given a date"
				+ "\nT total cost of a item in a given date"
				+ "\nU company that ordered the item with the highest cost within two dates"
				+ "\nZ to quit");
		String method = scan.nextLine();
		
		while(!method.equalsIgnoreCase("z"))
		{
			int year = 0;
			int month = 0;
			int day = 0;
			int num = 0;
			String company = "";
			Date d = new Date();
			Date d1 = new Date();
			String item = "";
			String put = "";
			switch(method){
				case "A" :
					put = "Orders : \n" + supply.toString();
					choose(out, put, name);
					break;
				case "B" :
					System.out.println("Enter the item you want to find : ");
					item = scan.nextLine();
					put = "Date with most orders of " + item + "\n" + supply.mostItemDate(item);
					choose(out, put, name);
					break;
				case "C" :
					System.out.println("Enter the item you want to find : ");
					item = scan.nextLine();
					put = "print the company with the most orders of " + item + "\n" + supply.mostItemCompany(item);
					choose(out, put, name);
					break;
				case "D" :
					put = "Store with the longest between their orders \n" + supply.LongestBetweenOrders();
					choose(out, put, name);
					break;
				case "E" :
					System.out.println("Enter the item you want to find : ");
					item = scan.nextLine();
					System.out.println("Enter the year : ");
					year = Integer.parseInt(scan.nextLine());
					put = "Company that ordered the most " + item + "\n" + supply.mostItemCompany(item, year);
					choose(out, put, name);
					break;
				case "F" :
					System.out.println("Enter the year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the day : ");
					day = Integer.parseInt(scan.nextLine());
					d = new Date(year, month, day);
					put = "All orders in the date " + supply.printDate(d) + "\n" + supply.OrdersDay(new Date(year, month, day));
					choose(out, put, name);
					break;
				case "G" :
					System.out.println("Enter the month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the day : ");
					day = Integer.parseInt(scan.nextLine());
					put = "All orders in a month " + month + 1 + " and year " + year + "\n" + supply.OrdersMonth(month, year);
					choose(out, put, name);
					break;
				case "H" :
					System.out.println("Enter the year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the day : ");
					day = Integer.parseInt(scan.nextLine());
					d = new Date(year, month, day);
					put = "Duplicate orders in the day " + supply.printDate(d) + "\n" + supply.DuplicateOrders(d);
					choose(out, put, name);
					break;
				case "I" :
					System.out.println("Enter the item you want to find : ");
					item = scan.nextLine();
					System.out.println("Enter the year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the least number of  : " + item);
					num = Integer.parseInt(scan.nextLine());
					put = "Companies that ordered at least " + num + " " + item + " in the year " + year + "\n" + supply.CompanyItem(num, item, year);
					choose(out, put, name);
					break;
				case "J" :
					System.out.println("Enter the company : ");
					company = scan.nextLine();
					System.out.println("Enter the start year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the start month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the start day : ");
					day = Integer.parseInt(scan.nextLine());
					d = new Date(year, month, day);
					System.out.println("Enter the end year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the end month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the end day : ");
					day = Integer.parseInt(scan.nextLine());
					d1 = new Date(year, month, day);
					put = "Orders of " + company + " between the dates " + supply.printDate(d) + " and " + supply.printDate(d1) + "\n" + supply.CompanyOrders(d, d1, company);
					choose(out, put, name);
					break;
				case "K" :
					System.out.println("Enter the company : ");
					company = scan.nextLine();
					System.out.println("Enter the start year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the start month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the start day : ");
					day = Integer.parseInt(scan.nextLine());
					d = new Date(year, month, day);
					System.out.println("Enter the end year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the end month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the end day : ");
					day = Integer.parseInt(scan.nextLine());
					d1 = new Date(year, month, day);
					put = "Summary/Total of " + company + " between the dates " + supply.printDate(d) + " and " + supply.printDate(d1) + "\n" + supply.CompanyTotal(d, d1, company);
					choose(out, put, name);
					break;
				case "L" :
					System.out.println("Enter the item : ");
					item = scan.nextLine();
					System.out.println("Enter the start year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the start month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the start day : ");
					day = Integer.parseInt(scan.nextLine());
					d = new Date(year, month, day);
					System.out.println("Enter the end year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the end month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the end day : ");
					day = Integer.parseInt(scan.nextLine());
					d1 = new Date(year, month, day);
					put = "total amount of " + item + " ordered between the dates " + supply.printDate(d) + " and " + supply.printDate(d1) + "\n" + supply.TotalProduct(item, d, d1);
					choose(out, put, name);
					break;
				case "M" :
					System.out.println("Enter the restauant : ");
					item = scan.nextLine();
					put = "The restuarant " + item + " that ordered the highest number of : \n" + supply.CompanyMostOrders(item);
					choose(out, put, name);
					break;
				case "N" :
					System.out.println("Enter the order : ");
					Orders ord = new Orders(scan.next());
					put = "date in which a particular Order is ordered\n" + supply.DateofOrder(ord);
					choose(out, put, name);
					break;
				case "O" :
					System.out.println("Enter the company : ");
					company = scan.nextLine();
					System.out.println("Enter the start year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the start month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the start day : ");
					day = Integer.parseInt(scan.nextLine());
					d = new Date(year, month, day);
					put = company + ", in the given date " + supply.printDate(d) + " did not order the items" + "\n" + supply.ItemsnotOrdered(company, d1);
					choose(out, put, name);
					break;
				case "P" :
					System.out.println("Enter the start year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the start month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the start day : ");
					day = Integer.parseInt(scan.nextLine());
					d = new Date(year, month, day);
					put = "Money collected on the date " + supply.printDate(d) + "\n$" + supply.MoneyonDate(d);
					choose(out, put, name);
					break;
				case "Q" :
					System.out.println("Enter the start year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the start month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the start day : ");
					day = Integer.parseInt(scan.nextLine());
					d = new Date(year, month, day);
					System.out.println("Enter the end year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the end month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the end day : ");
					day = Integer.parseInt(scan.nextLine());
					d1 = new Date(year, month, day);
					put = "Total money collected between the dates " + supply.printDate(d) + " and " + supply.printDate(d1) + "\n$" + supply.MoneyonDateInterval(d, d1);
					choose(out, put, name);
					break;
				case "R" : 
					System.out.println("Enter the company : ");
					company = scan.nextLine();
					System.out.println("Enter the start year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the start month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the start day : ");
					day = Integer.parseInt(scan.nextLine());
					d = new Date(year, month, day);
					System.out.println("Enter the end year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the end month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the end day : ");
					day = Integer.parseInt(scan.nextLine());
					d1 = new Date(year, month, day);
					put = "billing statement for the " + company + " between the dates " + supply.printDate(d) + " and " + supply.printDate(d1) + "\n" + supply.BillingStatement(d, d1, company);
					choose(out, put, name);
					break;
				case "S" :
					System.out.println("Enter the start year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the start month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the start day : ");
					day = Integer.parseInt(scan.nextLine());
					d = new Date(year, month, day);
					put = " A list of each item ordered and their price in the date " + supply.printDate(d) + "\n" + supply.EachItemCost(d);
					choose(out, put, name);
					break;
				case "T" :
					System.out.println("Enter the item : ");
					item = scan.nextLine();
					System.out.println("Enter the start year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the start month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the start day : ");
					day = Integer.parseInt(scan.nextLine());
					d = new Date(year, month, day);
					put = "total cost of " + item + " on " + supply.printDate(d) + "\n$" + supply.ItemCost(d, item);
					choose(out, put, name);
					break;
				case "U" :
					System.out.println("Enter the start year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the start month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the start day : ");
					day = Integer.parseInt(scan.nextLine());
					d = new Date(year, month, day);
					System.out.println("Enter the end year : ");
					year = Integer.parseInt(scan.nextLine());
					System.out.println("Enter the end month : ");
					month = Integer.parseInt(scan.nextLine()) - 1;
					System.out.println("Enter the end day : ");
					day = Integer.parseInt(scan.nextLine());
					d1 = new Date(year, month, day);
					put = "company that ordered the item with the highest cost between the dates " + supply.printDate(d) + " and " + supply.printDate(d1) + "\n$" + supply.CompanyHighestCost(d, d1);
					choose(out, put, name);
					break;
			}
			if(out.equalsIgnoreCase("F"))
				System.out.println("Done in file");
			else
				System.out.println("Done");
			System.out.println("Enter the method you want to call : "
					+ "\nA to print out the orders"
					+ "\nB to print the date with most order of a item"
					+ "\nC to print the company with the most orders of a item"
					+ "\nD for Store with the longest between their orders"
					+ "\nE Company that ordered the most item in a given year"
					+ "\nF All orders in a day"
					+ "\nG all orders in a month"
					+ "\nH Duplicate orders in a given day"
					+ "\nI Companies that ordered at least a given number of items in a year"
					+ "\nJ Orders of a company in a given Date interval"
					+ "\nK give a summary/total of orders from a given company in a given date interval"
					+ "\nL total amount of one item ordered in a given Date interval"
					+ "\nM Item that a restaurant has ordered the most"
					+ "\nN date in which a particular Order is ordered"
					+ "\nO items that were not ordered by a company in a given date"
					+ "\nP Money collected on a given Date"
					+ "\nQ money collected in a Date interval"
					+ "\nR billing statement for a given company in a given Date interval"
					+ "\nS A list of each item ordered and their price given a date"
					+ "\nT total cost of a item in a given date"
					+ "\nU company that ordered the item with the highest cost within two dates"
					+ "\nZ to quit");
			method = scan.nextLine();
		}
		
		

	}
	
	public static void choose(String out, String put, String name) throws IOException
	{
		BufferedWriter write = new BufferedWriter(new FileWriter(name + ".txt"));
		if(out.equalsIgnoreCase("F"))
		{
			write.write(put);
			write.close();
		}
		else if(out.equalsIgnoreCase("W"))
			System.out.println(put);
	}
}
