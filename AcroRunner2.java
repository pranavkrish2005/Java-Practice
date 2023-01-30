import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class AcroRunner2
{
	public static void main( String args[] ) throws IOException
	{
		Scanner sc = new Scanner(new File("H:\\Workspace_Pranav\\Sets\\src\\acro4.dat"));
		Acronyms one = new Acronyms();
		int ind = Integer.parseInt(sc.nextLine());
		for(int i =0 ; i < ind; i++)
			one.putEntry(sc.nextLine());
		System.out.println(one.toString());
		while(sc.hasNext())
			System.out.println(one.reconvert(sc.nextLine()));
		
	}
}
