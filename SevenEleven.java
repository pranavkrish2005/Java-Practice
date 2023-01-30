import java.util.Scanner;
public class SevenEleven
{
	private int bank;
	private int bet;
	private int firstsum;
	private boolean doagain;
	
	public SevenEleven()
	{}
	public SevenEleven(int b, int betting)
	{
		bank = b;
		bet = betting;
		doagain = false;
	}
	
	public int rollDie()
	{
		int rand1 = (int)(Math.random() * 6) + 1;
		return rand1;
	}
	
	public void askQuestions()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how much is in your bank : ");
		bank = sc.nextInt();
		System.out.println();
	}
	
	public void Sleep()
	{
		try {Thread.currentThread().sleep(500);}
		catch(InterruptedException a){a.printStackTrace();}
	}
	
	public void firstGameOutcome()
	{
		int die1 = this.rollDie();
		int die2 = this.rollDie();
		firstsum = die1 + die2;
		System.out.println("Roll 1 : " + die1);
		this.Sleep();
		System.out.println("Roll 2 : " + die2);
		this.Sleep();
		System.out.println("Your sum is : " + firstsum);
		this.Sleep();
		System.out.println();
		
		if(firstsum == 7 || firstsum == 11)
		{
			bank += bet;
			System.out.println("You win $" + bet + ".");
			this.Sleep();
			System.out.println("Your total is : $" + bank + ".");
			this.Sleep();
			doagain = true;
		}
			
		else if(firstsum == 2 || firstsum == 3 || firstsum == 12)
		{
			bank -= bet;
			System.out.println("You lose $" + bet + ".");
			this.Sleep();
			System.out.println("Your total is : $" + bank);
			this.Sleep();
			doagain = true;
		}
	}
	
	public void SecondGame()
	{
		int die1 = this.rollDie();
		int die2 = this.rollDie();
		System.out.println("You need to roll : " + firstsum);
		System.out.println();
		this.Sleep();
		
		while(die1 + die2 != firstsum)
		{
			System.out.println("Roll 1 : " + die1);
			this.Sleep();
			System.out.println("Roll 2 : " + die2);
			this.Sleep();
			System.out.println("Your sum is : " + (die1 + die2));
			this.Sleep();
			System.out.println();
			this.Sleep();
			if(die1 + die2 == 7)
			{
				bank -= bet;
				System.out.println("You lose : $" + bet);
				this.Sleep();
				System.out.println("Your total is : $" + bank);
				this.Sleep();
				break;
			}
			die1 = this.rollDie();
			die2 = this.rollDie();
		}
		if(die1 + die2 == firstsum)
		{
			System.out.println("Roll 1 : " + die1);
			this.Sleep();
			System.out.println("Roll 2 : " + die2);
			this.Sleep();
			System.out.println("Your sum is : " + (die1 + die2));
			this.Sleep();
			bank += bet;
			System.out.println("You win : $" + bet + ".");
			this.Sleep();
			System.out.println("Your total is : $" + bank + ".");
			this.Sleep();
		}
	}
	
	public void play()
	{
		Scanner sc = new Scanner(System.in);
		this.askQuestions();
		String answer = "y";
		while(answer.equalsIgnoreCase("y"))
		{
			System.out.println("Enter your bet : ");
			bet = sc.nextInt();
			this.firstGameOutcome();
			if(doagain != true)
				this.SecondGame();
			System.out.println("\nDo you want to play again?");
			String str = sc.nextLine();
			answer = sc.nextLine();
			doagain = false;
			
		}
		
	}
	
	public static void main(String args[])
	{
		SevenEleven a = new SevenEleven();
		a.play();
	}
}
