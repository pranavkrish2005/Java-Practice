import static java.lang.System.*;

public class AtCounterRunner
{
	public static void main(String args[])
	{
		//instantiate an AtCounter
		AtCounter one = new AtCounter(6, 6);
		//test the code
		System.out.println(one.toString());
		
		System.out.println(one.countAts(1, 1));
	}
}
