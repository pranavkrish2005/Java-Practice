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
		File fi = new File("H:\\Workspace_Pranav\\Maps\\supplyOrders.dat");
		Scanner sc = new Scanner(fi);
		FileWriter file = new FileWriter("FoodOrders.txt");
		BufferedWriter write = new BufferedWriter(file);
		
		FoodSupplier supply = new FoodSupplier();
		int ind = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < ind; i++)
			supply.addOrder(sc.nextLine());
		
		write.write(supply.mostItemDate("burgers") + "\n");
		write.write(supply.mostItemCompany("burgers") + "\n");
//		write.write(supply.LongestBetweenOrders());
		write.write(supply.mostItemCompany("burgers", 2011) + "\n");
//		write.write("\n" + supply.OrdersDay(12).toString());
//		write.write("\n\n" + supply.OrdersMonth(3).toString());
		
		write.write(supply.DuplicateOrders(new Date(2010, 1, 9)).toString());
//		write.write(supply.CompanyItem(2, "burgers", 2010).toString() + "\n");
//		write.write(supply.CompanyOrders(new Date(2010, 9, 1), new Date(2010, 12, 6), "BurgerKing").toString() + "\n");
//		write.write(supply.TotalProduct("burgers", new Date(2010, 9, 1), new Date(2010, 12, 6)) + "\n");
		write.close();
	}
}
