import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class AcroRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner sc = new Scanner(new File("C:\\Users\\23pk1139\\Downloads\\acro.dat"));
		Acronyms one = new Acronyms();
		int ind = Integer.parseInt(sc.nextLine());
		for(int i =0 ; i < ind; i++)
			one.putEntry(sc.nextLine());
		System.out.println(one.toString());
		while(sc.hasNext())
			System.out.println(one.convert(sc.nextLine()));
	}
}
