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
		output += "The cars in the driveway are : \n";
		while(!Drivewaystack.isEmpty())
		{
			printdriveway.add(Drivewaystack.pop());
		}
		while(!printdriveway.isEmpty())
		{
			output += printdriveway.peek() + "\n";
			Drivewaystack.add(printdriveway.pop());
		}
		
		output += "\nThe cars in the street are : \n";
		while(!Streetstack.isEmpty())
		{
			printstreet.add(Streetstack.pop());
		}
		while(!printstreet.isEmpty())
		{
			output += printstreet.peek() + "\n";
			Streetstack.add(printstreet.pop());
		}
		
		return output;
	}
	
	public void realDriveway()
	{
		int in = 1;
		System.out.println("A positive number adds a car, \n" + 
				"A negative number removes the car\n" + "A 0 stops the simulation");
		while(in != 0)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("\nEnter the number of the car : ");
			in = sc.nextInt();
			if(Drivewaystack.contains(in))
			{
				System.out.println("Car already in the driveway.");
			}
			else if(!Drivewaystack.contains(in) && in != 0)
			{
				if(in > 0)
				{
					Drivewaystack.add(in);
					System.out.println(this.toString());
				}
				else if(Drivewaystack.contains(Math.abs(in)))
				{
					while(!(Math.abs(in) == (int)Drivewaystack.peek()))
					{
						Streetstack.add(Drivewaystack.pop());
						System.out.println(this.toString());
					}
					Drivewaystack.pop();
					System.out.println(this.toString());
					while(!Streetstack.isEmpty())
					{
						Drivewaystack.add(Streetstack.pop());
						System.out.println(this.toString());
					}
				}
				else
					System.out.println("The car " + in + " is not in the driveway");
			}
		}
	}
	
}
