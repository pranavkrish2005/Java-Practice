import java.util.Stack;

public class Deck {
	Stack<Card> deck;

	public Deck() {
		deck = new Stack<Card>();
		loadDeck();
	}

	public Stack<Card> getDeck() {
		return deck;
	}

// Load the stack with 52 cards in order
	public void loadDeck()
	{
		for(int i = 1; i <= 4; i++)
			for(int j = 2; j <= 14; j++)
				deck.add(new Card(i, j));
	}

// Print the stack - for uniformity,
// make 13 rows in four columns, filling
// in each row from left to right
	public String toString()
	{
		Stack<Card> temp = new Stack<Card>();
		for(int i = 1; i <= 4; i++)
			for(int j = 2; j <= 14; j++)
				temp.add(deck.pop());
		
		String output = "";
		for(int i = 1; i <= 13; i++)
		{
			for(int j = 1; j <= 4; j++)
			{
				output += temp.peek() + "\t";
				deck.add(temp.peek());
				temp.pop();
			}
			output += "\n";
		}
		return output;
	}

// Return and remove the top card
	public Card deal()
	{
		return deck.pop();
	}

// Take the top half of the deck (26 cards) and alternate card by card with
// the bottom half
	public void bridgeShuffle()
	{
		Stack<Card> temp1 = new Stack<Card>();
		Stack<Card> temp2 = new Stack<Card>();
		for(int i = 1; i <= 26; i++)
			temp1.add(deck.pop());
		for(int i = 1; i <= 26; i++)
			temp2.add(deck.pop());
		for(int i = 1; i <= 52; i++)
		{
			if(i % 2 == 0)
				deck.add(temp1.pop());
			else
				deck.add(temp2.pop());
		}
		
	}

// Split the deck at a random spot. Put the stack of cards above the random
// spot below the other cards
	public void cut()
	{
		int tocut = (int)(Math.random() * 51) + 1;
		System.out.println("Random cut at " + (52 - tocut));
		Stack<Card> temp1 = new Stack<Card>();
		Stack<Card> temp2 = new Stack<Card>();
		for(int i = 1; i <= tocut; i++)
			temp1.add(deck.pop());
		for(int i = tocut + 1; i <= 52; i++)
			temp2.add(deck.pop());
		while(!temp1.isEmpty())
			deck.add(temp1.pop());
		while(!temp2.isEmpty())
			deck.add(temp2.pop());
	}

// Complete a bridge shuffle and then cut the deck. Repeat 7 times
	public void completeShuffle()
	{
		for(int i = 1; i <= 7; i++)
		{
			this.bridgeShuffle();
			this.cut();
		}
	}

// Reverse the order of the cards in the deck
	private void reverse()
	{
		Stack<Card> temp1 = new Stack<Card>();
		for(int i = 1; i <= 52; i++)
			temp1.add(deck.pop());
		deck = temp1;
	}

// Given a Stack of cards as an explicit parameter,
// reverse the order of the cards in the deck
	private Stack<Card> reverse(Stack<Card> x)
	{
		Stack<Card> temp1 = new Stack<Card>();
		for(int i = 1; i <= x.size(); i++)
			temp1.add(x.pop());
		x = temp1;
		return x;
	}

// Combine two decks, one as the implicit
// parameter, the other as the explicit parameter
	public void combineDecks(Stack<Card> other)
	{
		Stack<Card> temp1 = new Stack<Card>();
		for(int i = 1; i <= this.deck.size(); i++)
			temp1.add(deck.pop());
		for(int i = 1; i <= other.size() + this.deck.size(); i++)
		{
			if(i % 2 == 0)
				this.deck.add(temp1.pop());
			else
				this.deck.add(other.pop());
		}
	}

	public static void main(String[] args) {
// example method calls - you should make your own
		Deck a = new Deck();
		System.out.println(a.getDeck());
		System.out.println(a);
		a.bridgeShuffle();
		System.out.println("Brdge shuffle:\n\n" + a);
		a.cut();
		System.out.println("Cut:\n\n" + a);
//
		a.completeShuffle();
		System.out.println("After complete shuffle : ");
		System.out.println(a);
		a.reverse();
		System.out.println("After a reverse : \n" + a);
		for (int i = 1; i <= 5; i++)
			System.out.println(a.deal());
	}
}