//Name -
//Date -

import static java.lang.System.*;
import java.awt.Color;

public class PlayerTestOne
{
	public static void main( String args[] )
	{
		Player player = new Player();	
		
		Deck deck = new Deck();
		deck.shuffle();
		
		player.addCardToHand(deck.nextCard());
		player.addCardToHand(deck.nextCard());

		System.out.println("\n\ntoString");
		System.out.println(player);	
		
		System.out.println("\n\nhandValue");
		System.out.println(player.getHandValue());					
		
		player.addCardToHand(deck.nextCard());
		player.addCardToHand(deck.nextCard());

		System.out.println("\n\ntoString");
		System.out.println(player);	
		
		System.out.println("\n\nhandValue");
		System.out.println(player.getHandValue());									
	}
}