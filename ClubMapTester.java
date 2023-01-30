import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class ClubMapTester
{
	public static void main(String args[]) throws IOException
	{
		ClubMap cm = new ClubMap();
		Scanner scan = new Scanner(new File("H:\\Workspace_Pranav\\HashTables\\src\\student.txt"));
		String[] s;
		while(scan.hasNext())
		{
			s = scan.nextLine().split("\t", -1);
			cm.add(s);
		}
		
		System.out.println(cm.getStudents("Math"));
		System.out.println();
		System.out.println(cm.printAllStudents());
		
	}
}
