import java.util.Collections;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Reagan King
//Date - 11/28/22

public class Dealer extends Player
{
	//define a deck of cards
	public Deck deck2 = new Deck();
	
	public Dealer() {
	}

	public void  shuffle()
	{
		deck2.shuffle();
	}

	public Card deal(){
		//addCardToHand(deck2.nextCard());
		return deck2.nextCard();
	}
	
	public int numCardsLeftInDeck()
	{
		return 0;
	}

	public boolean hit()
	{
	    
		return false;
    }
}
