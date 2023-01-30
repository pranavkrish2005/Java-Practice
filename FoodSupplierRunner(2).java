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
		File fi = new File("H:\\Workspace_Pranav\\Maps\\src\\supplyOrders.dat");
		Scanner sc = new Scanner(fi);
		int ind = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Y if you want to add more to the file or N if no : ");
		Scanner scan = new Scanner(System.in);
		String check = scan.nextLine();
		FileWriter fw = new FileWriter("H:\\Workspace_Pranav\\Maps\\src\\supplyOrders.dat", true);
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
//		
		BufferedWriter write = new BufferedWriter(new FileWriter("Orders.txt"));
//		System.out.println("Enter the method you want to call : " + "\nA to print out the orders\nB to print the date with most order of a item"
//				+ "\nC to print the company with the most orders of a item\nD for Store with the longest between their orders"
//				+ "\nE Company that ordered the most item\nF all orders in a day\nG all orders in a month\\nH Duplicate orders in a given day"
//				+ "\nI Companies that ordered at least a given number of burgers in a year\nJ Orders of a company in a given Date interval"
//				+ "\nK give a summary/total of orders from a given company in a given date interval\nL total amount of one item ordered in a "
//				+ "given Date interval\nM Boxes ordered by the given company in a given time\nN company in which most boxes of orders were "
//				+ "placed in a given time\nO Money collected on a given Date\nP money collected in a Date interval\nP billing statement for a "
//				+ "given company in a given Date interval\nQ A list of each item ordered and their price\nR total cost of a item in a given date"
//				+ "\nR company that ordered the item with the highest cost within two dates\n Z to quit");
//		String method = scan.nextLine();
//		
//		while(!method.equalsIgnoreCase("z"))
//		{
//			String put = "";
//			switch(method){
//				case "A" :
//					put = "Orders : \n" + supply.toString();
//					choose(out, put, name);
//					break;
//				case "B" :
//					System.out.println("Enter the item you want to find : ");
//					String item = scan.nextLine();
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//				case "C" :
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//				case "D" :
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//				case "E" :
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//				case "F" :
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//				case "G" :
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//				case "H" :
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//				case "I" :
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//				case "J" :
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//				case "K" :
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//				case "L" :
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//				case "M" :
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//				case "N" :
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//				case "O" :
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//				case "P" :
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//				case "Q" :
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//				case "R" :
//					put = "Date with most orders of " + item + "\n" + supply.mostItemDate("burgers");
//					choose(out, put, name);
//					break;
//			}
//			System.out.println("Enter the method you want to call : " + "\nA to print out the orders\nB to print the date with most order of a item"
//					+ "\nC to print the company with the most orders of a item\nD for Store with the longest between their orders"
//					+ "\nE Company that ordered the most item\nF all orders in a day\nG all orders in a month\\nH Duplicate orders in a given day"
//					+ "\nI Companies that ordered at least a given number of burgers in a year\nJ Orders of a company in a given Date interval"
//					+ "\nK give a summary/total of orders from a given company in a given date interval\nL total amount of one item ordered in a "
//					+ "given Date interval\nM Boxes ordered by the given company in a given time\nN company in which most boxes of orders were "
//					+ "placed in a given time\nO Money collected on a given Date\nP money collected in a Date interval\nP billing statement for a "
//					+ "given company in a given Date interval\nQ A list of each item ordered and their price\nR total cost of a item in a given date"
//					+ "\nR company that ordered the item with the highest cost within two dates\n Z to quit");
//			method = scan.nextLine();
//		}
//		
//		
////		write.write("Orders : \n" + supply.toString());
//		write.write(supply.mostItemDate("straws") + "\n\n");
//		write.write(supply.mostItemCompany("napkins") + "\n\n");
////		write.write("Store with longest between orders\n" + supply.LongestBetweenOrders() + "\n\n");
//		write.write(supply.mostItemCompany("napkins", 2014) + "\n\n");
//		write.write(supply.OrdersDay(new Date(2010, 9, 1)).toString() + "\n\n");
		write.write(supply.OrdersMonth(9, 2010).toString() + "\n\n");
////		write.write(supply.DuplicateOrders(new Date(2010, 1, 9)).toString() + "\n\n");
///		write.write(supply.CompanyItem(3, "burgers", 2010).toString() + "\n\n");
////		write.write(supply.CompanyOrders(new Date(2010, 9, 1), new Date(2010, 12, 6), "BurgerKing").toString() + "\n\n");
////		write.write(supply.CompanyTotal(new Date(2010, 9, 1), new Date(2010, 12, 6), "BurgerKing").toString() + "\n\n");
////		write.write(supply.TotalProduct("burgers", new Date(2010, 9, 1), new Date(2010, 12, 6)) + "\n\n");
////		write.write(supply.TotalOrders("McDonalds", new Date(2010, 9, 1), new Date(2010, 12, 6)) + "\n\n");
////		write.write(supply.MostBoxes(new Date(2010, 9, 1), new Date(2010, 12, 6)) + "\n\n");
////		write.write(supply.MoneyonDate(new Date(2010, 1, 9)) + "\n\n");
////		write.write(supply.MoneyonDateInterval(new Date(2010, 9, 1), new Date(2010, 12, 6)) + "\n\n");
////		write.write(supply.BillingStatement(new Date(2010, 9, 1), new Date(2010, 12, 5), "McDonalds") + "\n\n");
////		write.write(supply.EachItemCost(new Date(2010, 9, 1)) + "\n\n");
////		write.write(supply.ItemCost(new Date(2010, 9, 1), "burgers") + "\n\n");
		write.close();
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
