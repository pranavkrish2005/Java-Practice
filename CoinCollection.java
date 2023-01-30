import java.util.ArrayList;

public class CoinCollection
{
	mySet<Coin> one;
	
	public CoinCollection()
	{
		one = new mySet<Coin>();
	}
	
	public CoinCollection(ArrayList<Coin> coins)
	{
		one = new mySet<Coin>();
		for(int i = 0; i < coins.size(); i++)
			for(int j = i + 1; j < coins.size(); j++)
			{
				if(i == j)
					continue;
				if(coins.get(i).equals(coins.get(j)))
				{
					coins.remove(j);
					j--;
				}
			}
		for(int i =0 ; i < coins.size(); i++)
			one.add(coins.get(i));
	}
	
	public String toString()
	{
		String out = "";
		for(int i = 0; i < one.size(); i++)
			out += one.get(i).toString();
		return out;
	}
	
}
