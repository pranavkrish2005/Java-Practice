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
		FileWriter fw = new FileWriter("supplyOrders.dat", true);
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
		System.out.println("Enter the name of the file : ");
		String name = scan.nextLine();
		BufferedWriter write = new BufferedWriter(new FileWriter(name + ".txt"));
		FoodSupplier supply = new FoodSupplier();
		for(int i = 0; i < ind; i++)
			supply.addOrder(sc.nextLine());
		
		write.write(supply.DuplicateOrders(new Date(2010, 1, 9)).toString() + "\n");
		write.write(supply.mostItemDate("burgers") + "\n");
		write.write(supply.mostItemCompany("burgers") + "\n");
		write.write(supply.LongestBetweenOrders() + "\n");
		write.write(supply.mostItemCompany("burgers", 2011) + "\n");
		write.write("\n" + supply.OrdersDay(12).toString() + "\n");
		write.write("\n\n" + supply.OrdersMonth(3).toString() + "\n");
		write.write(supply.DuplicateOrders(new Date(2010, 1, 9)).toString() + "\n");
		write.write(supply.CompanyItem(2, "burgers", 2010).toString() + "\n");
		write.write(supply.CompanyOrders(new Date(2010, 9, 1), new Date(2010, 12, 6), "BurgerKing").toString() + "\n");
		write.write(supply.CompanyTotal(new Date(2010, 9, 1), new Date(2010, 12, 6), "BurgerKing").toString() + "\n");
		write.write(supply.TotalProduct("burgers", new Date(2010, 9, 1), new Date(2010, 12, 6)) + "\n");
		write.write(supply.TotalOrders("McDonalds", new Date(2010, 9, 1), new Date(2010, 12, 6)) + "\n");
		write.write(supply.MostBoxes(new Date(2010, 9, 1), new Date(2010, 12, 6)) + "\n");
		write.write(supply.MoneyonDate(new Date(2010, 9, 1)) + "\n");
		write.write(supply.MoneyonDateInterval(new Date(2010, 9, 1), new Date(2010, 12, 6)) + "\n");
		write.write(supply.BillingStatement(new Date(2010, 9, 1), new Date(2010, 12, 5), "McDonalds") + "\n");
		write.write(supply.EachItemCost(new Date(2010, 9, 1)) + "\n");
		write.write(supply.ItemCost(new Date(2010, 9, 1), "burgers") + "\n");
		write.close();
	}
}
