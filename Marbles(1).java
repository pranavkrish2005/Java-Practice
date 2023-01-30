import java.util.Scanner;
public class Marbles
{
	private int Marblesleft;
	private int winorLose;
	private int smart;
	
	public Marbles()
	{
		Marblesleft = this.Totalmarbles();
		winorLose = 2;
	}
	
	public void Prompt()
	{
		System.out.println("Welcome to my game of marbles : ");
		System.out.println("Whoever picks the last marble loses");
		System.out.println("I will let you go first");
	}
	
	public void SmartorNot()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("If you want the computer to be smart, enter 1 or enter 0 : ");
		smart = sc.nextInt();
	}
	
	public void Usercheck()
	{
		Scanner sc = new Scanner(System.in);
		int input = this.Userchoice();
		while(input > (Marblesleft / 2))
		{
			if(input > (Marblesleft / 2))
			{
				System.out.println("Actually you need to choose a marble between 1 and 1/2 out of how many"
						+ " marbles there are. \nThere are currently " + Marblesleft + "\nSo, you can " + 
						"pick upto " + (Marblesleft / 2) + " marbles.");
				
			}
			System.out.println("How many would you like to take. No more than half...");
			input = sc.nextInt();
		}
		Marblesleft -= input;
		if(Marblesleft == 1)
			winorLose = 0;
	}
	
	public int Userchoice()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("There are currently " + Marblesleft + " marbles remaining");
		System.out.println("How many would you like to take. No more than half...");
		int input = sc.nextInt();
		return input;
	}
	
	public void ComputerChoicesmart()
	{
		int Compchoice = -1;
		for(int i = 1; i <= 15; i++)
		{
			if(Math.pow(2, i) - 1 < (Marblesleft / 2) + 1 && Math.pow(2, i + 1) - 1 >= (Marblesleft / 2) + 1)
			{
				Compchoice = (int)(Math.pow(2, i) - 1);
				break;
			}
		}
		Marblesleft -= Compchoice;
		if(Compchoice == -1 || Marblesleft == 1)
		{
			System.out.println("The computer choose " + Compchoice);
			winorLose = 1;
		}
		if(winorLose != 1)
		{
			Marblesleft -= Compchoice;
			System.out.println("The computer choose " + Compchoice);
		}
	}
	
	public void ComputerChoicedumb()
	{
		if(winorLose != 0)
		{
			int Compchoice = (int)(Math.random() * (Marblesleft / 2)) + 1;
			Marblesleft -= Compchoice;
			System.out.println("The computer choose " + Compchoice);
			if(Marblesleft == 1)
				winorLose = 1;
		}
	}
	
	public void Win()
	{
		if(winorLose == 1)
			System.out.println("You lose!");
		else if(winorLose == 0)
			System.out.println("You win!");
	}
	
	public int Totalmarbles()
	{
		int Marblesleft = (int)(Math.random() * 90) + 10;
		return Marblesleft;
	}
	
	public void Play()
	{
		this.Prompt();
		this.SmartorNot();
		while(winorLose == 2)
		{
			Usercheck();
			if(smart == 1)
				ComputerChoicesmart();
			else if(smart == 0)
				ComputerChoicedumb();
			if(Marblesleft == 1)
				Win();
		}
	}
	
	public static void main(String args[])
	{
		Marbles m = new Marbles();
		m.Play();
		
	}
}
