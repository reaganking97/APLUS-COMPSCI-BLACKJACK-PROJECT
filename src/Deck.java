//Name - Reagan King
//Date - 11/11/22
import java.util.Stack;
import java.util.Collections;
public class Deck
{
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;
	public int tester = 0;
	public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

	//create a private Stack of Cards
	private Stack<Card> Deck1; 
	
	
	public Deck ()
	{
		int t = 0;
		int y = 0;
		//make a new Stack
		Deck1 = new Stack<Card>();
		//add 52 cards to the stack
		for (int i = 1; i<=13; i++)
		{
			for(int j=0; j<4; j++)
			{
				Card card = new BlackJackCard(i,SUITS[j]);
				Deck1.push(card);
				t++;
				
				if(j>4 && t<16)
					{
					j=0;
					}
			y++;
			if (i>=13 && y<4)
				{
				i=0;
				}
			}
		}
		//call a method maybe??
	
	}

	//modifiers
   public void shuffle ()
	{
	   int t = 0;
	   int y = 0;
	   //add 52 cards to the stack
	   for (int i = 1; i<=13; i++)
		{
			for(int j=0; j<4; j++)
			{
				Card card = new BlackJackCard(i,SUITS[j]);
				Deck1.push(card);
				t++;
				
				if(j>4 && t<16)
					{
					j=0;
					}
			y++;
			if (i>=13 && y<4)
				{
				i=0;
				}
			}
		}
	   Collections.shuffle(Deck1);
	   System.out.println("");
	   for( int i=0; i<Deck.NUMCARDS; i++ ) {
			  System.out.println(Deck1.pop());
			}
	}	

   //accessors
	public int  size ()
	{
		
		return Deck1.size();
	}

	public int numCardsLeft()
	{
		
		return Deck1.size();
		
	}

	public Card nextCard()
	{
		return Deck1.pop();
	}

	public String toString()
	{
		return "";
	}
 }