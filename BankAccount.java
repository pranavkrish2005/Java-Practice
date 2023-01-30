
public class BankAccount
{
	private int anAcountNumber;
	private double Balance;
	public BankAccount(int accnum)
	{
		anAcountNumber = accnum;
	}
	
	public BankAccount(int accnum, double innitialbal)
	{
		anAcountNumber = accnum;
		Balance = innitialbal;
	}
	
	public void deposit(double amount)
	{
		Balance += amount;
	}
	
	public int getAccountNumber()
	{
		return anAcountNumber;
	}
	
	public double getBalance()
	{
		return Balance;
	}
	
	public String toString()
	{
		return "The bank account is : " + anAcountNumber + " and the balance is " + Balance;
	}
	
	public void withdraw(double amount)
	{
		Balance -= amount;
	}
}
