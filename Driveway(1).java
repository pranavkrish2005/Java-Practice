import java.util.Stack;
import java.util.Scanner;

public class Driveway
{
	Stack<Object> Drivewaystack;
	Stack<Object> Streetstack;
	
	public Driveway()
	{
		Drivewaystack = new Stack<Object>();
		Streetstack = new Stack<Object>();
	}
	
	
	public String toString()
	{
		String output = "";
		Stack<Object> printdriveway = new Stack<Object>();
		Stack<Object> printstreet = new Stack<Object>();
		output += "The cars in the driveway are : ";
		while(!Drivewaystack.isEmpty())
		{
			printdriveway.add(Drivewaystack.pop());
		}
		while(!printdriveway.isEmpty())
		{
			output += printdriveway.peek() + " ";
			Drivewaystack.add(printdriveway.pop());
		}
		
		output += "\n\nThe cars in the street are : ";
		while(!Streetstack.isEmpty())
		{
			printstreet.add(Streetstack.pop());
		}
		while(!printstreet.isEmpty())
		{
			output += printstreet.peek() + " ";
			Streetstack.add(printstreet.pop());
		}
		
		return output;
	}
	
	public void realDriveway()
	{
		int in = 1;
		
		while(in != 0)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("\nEnter the lisence plate of the number");
			in = sc.nextInt();
			if(in != 0)
			{
				if(in > 0)
				{
					Drivewaystack.add(in);
					System.out.println(this.toString());
				}
				else
				{
					while(!(Math.abs(in) == (int)Drivewaystack.peek()))
					{
						Streetstack.add(Drivewaystack.pop());
						System.out.println(this.toString());
					}
					Drivewaystack.pop();
					while(!Streetstack.isEmpty())
					{
						Drivewaystack.add(Streetstack.pop());
						System.out.println(this.toString());
					}
				}
			}
		}
	}
	
}
