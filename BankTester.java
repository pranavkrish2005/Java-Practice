
public class BankTester
{
	public static void main(String[] args)
	{
	Bank firstBankOfJava = new Bank();
	firstBankOfJava.addAccount(new BankAccount(1001, 20000));
	firstBankOfJava.addAccount(new BankAccount(1015, 10000));
	firstBankOfJava.addAccount(new BankAccount(1729, 15000));
	System.out.printf("Total of all Accounts: $%.2f \n",  + firstBankOfJava.getTotalBalance());
	double threshold = 15000;
	int c = firstBankOfJava.count(threshold);
	System.out.printf(c + " accounts with balance >= $%.2f \n", threshold);
	int accountNumber = 1015;
	BankAccount a = firstBankOfJava.find(accountNumber);
	if (a == null)
	System.out.println("No account with number " + accountNumber);
	else
	System.out.printf("Account with number %d has balance $%.2f \n", accountNumber, a.getBalance());
	BankAccount max = firstBankOfJava.getMaximum();
	System.out.printf("Account with number "
	+ max.getAccountNumber()
	+ " has the largest balance.");
	}
}
