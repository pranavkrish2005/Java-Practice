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
	
	public int Totalmarbles()
	{
		return (int)(Math.random() * 90) + 10;
	}
	
	public void initialQuestion()
	{
		System.out.println("Welcome to my game of marbles : ");
		System.out.println("Whoever picks the last marble loses");
		System.out.println("I will let you go first.");
	}
	
	public void choiceCheck()
	{
		int input = UserChoice();
		while(input > (Marblesleft / 2))
		{
			System.out.println("Actually you need to choose a marble between 1 and 1/2 out of how many marbles there are.\n" + 
					"There are currently " + Marblesleft + 
					"\nSo, you can pick upto " + (Marblesleft / 2) + " marbles.\n");
			input = this.UserChoice();
		}
		Marblesleft -= input;
		if(Marblesleft == 1)
			winorLose = 1;
	}
	
	public void Compchoice()
	{
		int Compnum = (int)(Math.random() * (Marblesleft / 2)) + 1;
		System.out.println("The computer choose " + Compnum + ".");
		Marblesleft -= Compnum;
		if(Marblesleft == 1)
			winorLose = 0;
	}
	
	public void Compchoicesmart()
	{
		int Compnum = 0;
		int count = 1;
		for(int i = 1; i <= Marblesleft / 2; i = (int)(Math.pow(2, count) - 1))
		{
			Compnum = i;
			count++;
		}
		
		System.out.println("The computer choose " + Compnum + ".");
		Marblesleft -= Compnum;
		if(Marblesleft == 1)
			winorLose = 0;
	}
	
	public void WinorLose()
	{
		if(winorLose == 1)
			System.out.println("You win!");
		else if(winorLose == 0)
			System.out.println("You lose!");
	}
	
	public int UserChoice()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("There are currently " + Marblesleft + " marbles remaining");
		System.out.println("How many would you like to take. No more than half...");
		int input = sc.nextInt();
		return input;
	}
	
	public void smartornot()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 if you want to play against a smart computer and 0 if not : ");
		smart = sc.nextInt();
	}
	
	public void Play()
	{
		this.initialQuestion();
		this.smartornot();
		while(winorLose == 2)
		{
			choiceCheck();
			if(smart == 1)
				Compchoicesmart();
			else
				Compchoice();
		}
		WinorLose();
	}
	
	public static void main(String args[])
	{
		Marbles m = new Marbles();
		m.Play();
		
	}
}
