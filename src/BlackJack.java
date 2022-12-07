//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Reagan King
//Date - 11-30-22

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack
{
	Player player1 = new Player();//add in Player instance variable
	Dealer dealer1 = new Dealer();//add in Dealer instance variable
	
	
	public BlackJack()
	{
		
		
		dealer1.shuffle();
		
		player1.addCardToHand(dealer1.deal());
		dealer1.addCardToHand(dealer1.deal());
		player1.addCardToHand(dealer1.deal());
		dealer1.addCardToHand(dealer1.deal());
	
		int playerTotal = player1.getHandValue();
		int dealerTotal = dealer1.getHandValue();
		
		out.println("\nPLAYER ");
		out.println("Hand Value :: " + playerTotal );
		out.println("Hand Size :: " + player1.getHandSize() );
		out.println("Cards in Hand :: " + player1.toString() );
		out.println("\nDEALER ");
		out.println("Hand Value :: " + dealerTotal );
		out.println("Hand Size :: " + dealer1.getHandSize() );
		out.println("Cards in Hand :: " + dealer1.toString() );
		
		if (playerTotal == 21 && dealerTotal != 21)
		{
			out.println();
			out.println("The player wins with a blackjack");
		}
		
		if (dealerTotal == 21 && playerTotal !=21)
		{
			out.println();
			out.println("The dealer wins with a blackjack");
		}
		
		if (dealerTotal == 21 && playerTotal == 21)
		{
			out.println("The game ends in a stand-off");
		}
	}

	public void playGame()
	{
		Scanner keyboard = new Scanner(System.in);
		String choice = "";
		int playerTurnCount = 0;
		int dealerTurnCount = 0;
		int dealerTotal = dealer1.getHandValue();
		int playerTotal = player1.getHandValue();
		int blackJackCheckIndex = 0;
		
		while (dealerTurnCount==0 || playerTurnCount==0 && blackJackCheckIndex ==0)
		{
			playerTotal = player1.getHandValue();
			out.println();
			if(dealerTotal ==21 || playerTotal ==21 && blackJackCheckIndex == 0)
			{
				blackJackCheckIndex++;
				break;
			}
				
				if(playerTurnCount==0 && playerTotal<21)
				{
				out.println("Player, do you want to hit? y/n");
				choice = keyboard.nextLine();
				}
				
			if (choice.equals("y") && playerTotal<21 && playerTurnCount == 0)
			{
				player1.addCardToHand(dealer1.deal());
			
				playerTotal = player1.getHandValue();
			
				out.println("\nPLAYER ");
				out.println("Hand Value :: " + playerTotal );
				out.println("Hand Size :: " + player1.getHandSize() );
				out.println("Cards in Hand :: " + player1.toString() );
			}
			
			if (choice.equals("n") && playerTurnCount ==0)
			{
				out.print("");
				out.print("The player stays\n");
				playerTurnCount++;
			}
			if (player1.getHandValue() > 21)
			{
				out.println("The Player Busted!");
				break;
			}
			
			//if(dealerTurnCount==0 && dealerTotal<21 && !(playerTurnCount ==0))
				//{
				//out.println();
				//out.println("Dealer, do you want to hit? y/n");
				//choice = keyboard.nextLine();
				//}
			
			
			if (choice.equals("n") && dealer1.getHandValue()<17 && dealerTotal<21 && dealerTurnCount == 0)
			{
				
				dealer1.addCardToHand(dealer1.deal());
			
				dealerTotal = dealer1.getHandValue();
			
				out.println("\nDealer ");
				out.println("Hand Value :: " + dealerTotal );
				out.println("Hand Size :: " + dealer1.getHandSize() );
				out.println("Cards in Hand :: " + dealer1.toString() );
			}
			else if(choice.equals("n") && dealer1.getHandValue()>17)
				{
					out.print("");
					out.print("\nThe Dealer stays");
					dealerTurnCount++;
					break;
				}
				if (dealer1.getHandValue() > 21)
				{
					out.println("The Dealer Busted!");
					break;
				}
			
			
			
		
		}
		out.println("");
		if(choice.equals("n") && dealer1.getHandValue() > player1.getHandValue() && dealer1.getHandValue()<22)
			{
			out.println("\nThe Dealer wins with a hand value of " + dealer1.getHandValue());
			}
		if(choice.equals("n") && dealer1.getHandValue() < player1.getHandValue() && player1.getHandValue()<22)
			{
			out.println("\nThe Player wins with a hand value of " + player1.getHandValue());
			}
		
		if(choice.equals("n") && dealer1.getHandValue() == player1.getHandValue() && dealer1.getHandValue()<22 && player1.getHandValue()<22)
		{
			out.println("The game ends in a stand-off");
		}
	
	}
	
	public static void main(String[] args)
	{
		BlackJack game = new BlackJack();
		game.playGame();
	}
}