import java.util.ArrayList;
public class Bank
{
	ArrayList<BankAccount> baccount;
	public Bank()
	{
		baccount = new ArrayList<BankAccount>();
	}
	
	public void addAccount(BankAccount a)
	{
		baccount.add(a);
	}
	
	public int count(double atLeast)
	{
		int count = 0;
		for(BankAccount i : baccount)
			if(i.getBalance() >= atLeast)
				count++;
		return count;
	}
	
	public BankAccount find(int AccountNumber)
	{
		for(int i = 0; i < baccount.size(); i++)
			if(baccount.get(i).getAccountNumber() == AccountNumber)
				return baccount.get(i);
		return null;
	}
	
	public BankAccount getMaximum()
	{
		BankAccount largest = baccount.get(0);
		for(BankAccount i : baccount)
			if(i.getBalance() > largest.getBalance())
				largest = i;
		return largest;
	}
	
	public double getTotalBalance()
	{
		double sum = 0;
		for(int i = 0; i < baccount.size(); i++)
			sum += baccount.get(i).getBalance();
		return sum / baccount.size();
	}
}
