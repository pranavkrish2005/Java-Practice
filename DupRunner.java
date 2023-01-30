import static java.lang.System.*;
import java.util.*;

public class DupRunner
{
	public static void main( String args[] )
	{
		String str1 = "a b c d e f g h a b c d e f g h i j k";
		System.out.println(UniquesDupes.toString(str1));
		System.out.println(UniquesDupes.getUniques(str1));
		System.out.println(UniquesDupes.getDupes(str1));
		
		String str2 = "one two three one two three six seven one two";
		System.out.println(UniquesDupes.toString(str2));
		System.out.println(UniquesDupes.getUniques(str2));
		System.out.println(UniquesDupes.getDupes(str2));
		
		String str3 = "1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6";
		System.out.println(UniquesDupes.toString(str3));
		System.out.println(UniquesDupes.getUniques(str3));
		System.out.println(UniquesDupes.getDupes(str3));
	}
}