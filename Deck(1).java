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
				deck.add(new Card(5 - i, 16 - j));
	}

// Print the stack - for uniformity,
// make 13 rows in four columns, filling
// in each row from left to right
	public String toString()
	{
		Stack<Card> temp = new Stack<Card>();
		for(int i = 1; i <= 4; i++)
			for(int j = 2; j <= 14; j++)
				temp.add(new Card(5 - i, 16 - j));
		
		String output = "";
		for(int i = 1; i <= 13; i++)
		{
			for(int j = 1; j <= 4; j++)
			{
				output += temp.peek() + "\t";
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
		Stack<Card> temp = new Stack<Card>();
		for(int i = 1; i <= 2; i++)
			for(int j = 2; j <= 14; j++)
				temp.add(deck.pop());
		
	}

// Split the deck at a random spot. Put the stack of cards above the random
// spot below the other cards
	public void cut() {
	}

// Complete a bridge shuffle and then cut the deck. Repeat 7 times
	public void completeShuffle() {
	}

// Reverse the order of the cards in the deck
	private void reverse() {
	}

// Given a Stack of cards as an explicit parameter,
// reverse the order of the cards in the deck
	private Stack<Card> reverse(Stack<Card> x) {
	}

// Combine two decks, one as the implicit
// parameter, the other as the explicit parameter
	public void combineDecks(Stack<Card> other) {
	}

	public static void main(String[] args) {
// example method calls - you should make your own
		Deck a = new Deck();
		System.out.println(a.getDeck());
		System.out.println(a);
//		a.bridgeShuffle();
//		System.out.println(a);
//		a.cut();
//
//		a.completeShuffle();
//		System.out.println("After 1 bridge shuffle");
//		System.out.println(a);
//		a.reverse();
//		for (int i = 1; i <= 5; i++)
//			System.out.println(a.deal());
	}
}