//Name - Reagan King
//Date - 11/16/22

import java.util.*;

public class Player
{
   private ArrayList<Card> hand;
   private int winCount;

   public Player ()
   {
	   hand = new ArrayList<Card>();
   }

   public Player (int score)
   {
	   hand = new ArrayList<Card>();
   }

   public void addCardToHand( Card temp )
   {
   hand.add(temp);
   }

   public void resetHand( )
   {
   hand.clear();
   }

   public  void setWinCount( int numwins )
   {
   }

   public int getWinCount() { return 0; }

   public int getHandSize() { return hand.size(); }

   public int getHandValue()
   {
      int value = 0;
	   for (Card card:hand) 
      {
       value += card.getValue();
      }
	   return value;
   }

   public  boolean  hit( )
   {
      return false;
   }

   public String toString()
   {
      return "hand = " + hand.toString( );
   }
}