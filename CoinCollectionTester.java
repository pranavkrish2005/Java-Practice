import java.util.ArrayList;

public class CoinCollectionTester {

	public static void main(String[] args) {
		ArrayList<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(1941, "penny"));
		coins.add(new Coin(2010, "dime"));
		coins.add(new Coin(2009, "quarter"));
		coins.add(new Coin(1954, "nickel"));
		coins.add(new Coin(1987, "dime"));
		coins.add(new Coin(1949, "penny"));
		coins.add(new Coin(1982, "dime"));
		coins.add(new Coin(1955, "penny"));
		coins.add(new Coin(2002, "quarter"));
		coins.add(new Coin(2008, "quarter"));
		coins.add(new Coin(1952, "nickel"));
		coins.add(new Coin(1931, "penny"));
		coins.add(new Coin(1989, "dime"));
		CoinCollection one = new CoinCollection(coins);
		System.out.println(one);
	}

}
