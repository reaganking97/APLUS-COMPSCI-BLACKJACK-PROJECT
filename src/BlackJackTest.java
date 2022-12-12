//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Reagan King
//Date - 11-30-22

import static java.lang.System.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class BlackJackTest
{
	Player player1 = new Player();//add in Player instance variable
	Player player2 = new Player();
	Player player3 = new Player();
	Player player4 = new Player();
	Player player5 = new Player();
	Player player6 = new Player();
	Player player7 = new Player();
	int num = 0;
	
	Dealer dealer1 = new Dealer();//add in Dealer instance variable
	
	public Stack<Player> playerList = new Stack<Player>(); 
	
	public BlackJackTest()
	{
		
		
		Scanner numplayers = new Scanner(System.in);
		out.println("How many players? 1-7");		
		int playerValidation =0;
		while(playerValidation==0)
		{
			try 
			{
				int test = numplayers.nextInt();
				numplayers.nextLine();
				if((test <=7) && (test >0))
				{
					num = test;
					playerValidation++;
				}
				else {
					out.println("Make sure to enter a number 1-7");
				}
			}
			catch(InputMismatchException ex)
			{
				out.println("Make sure to enter a number 1-7");
			
				numplayers.nextLine(); // clear scanner wrong input
			    continue;
			}
			
			
			
		}
		if (num ==1) {playerList.push(player1);}
		if (num ==2) {playerList.push(player1); playerList.push(player2);}
		if (num ==3) {playerList.push(player1); playerList.push(player2); playerList.push(player3);}
		if (num ==4) {playerList.push(player1); playerList.push(player2); playerList.push(player3); playerList.push(player4);}
		
		if (num ==5) 
			{
			playerList.push(player1); 
			playerList.push(player2); 
			playerList.push(player3); 
			playerList.push(player4);
			playerList.push(player5);
			}
		if (num ==6) 
		{
		playerList.push(player1); 
		playerList.push(player2); 
		playerList.push(player3); 
		playerList.push(player4);
		playerList.push(player5);
		playerList.push(player6);
		}
		if (num ==7) 
		{
		playerList.push(player1); 
		playerList.push(player2); 
		playerList.push(player3); 
		playerList.push(player4);
		playerList.push(player5);
		playerList.push(player6);
		playerList.push(player7);
		}
		dealer1.shuffle();
		
		
		for (Player player: playerList)
		{
			player.addCardToHand(dealer1.deal());
		}
		dealer1.addCardToHand(dealer1.deal());
		
		for (Player player: playerList)
		{
			player.addCardToHand(dealer1.deal());
		}
		dealer1.addCardToHand(dealer1.deal());
	
		
		
		int playerTotal = player1.getHandValue();
		int dealerTotal = dealer1.getHandValue();
		
	}

	public void playGame()
	{
		
		Scanner keyboard = new Scanner(System.in);
		String choice = "";
		int dealerTurnCount = 0;
		int whichPlayer;
		while (dealerTurnCount==0)
		{
			for(int i=0; i <num; i++)
			{
				int playerTurnIndex = 0;
				whichPlayer =0;
				whichPlayer = (i+1);
				out.println("\nPLAYER "+(whichPlayer));
				out.println("Hand Value :: " + playerList.elementAt(i).getHandValue());
				out.println("Hand Size :: " + playerList.elementAt(i).getHandSize());
				out.println("Cards in Hand :: " + playerList.elementAt(i));
				
				while(playerTurnIndex ==0 && dealerTurnCount==0 && playerList.elementAt(i).getHandValue()<21)
				{
					out.println("Player " +whichPlayer+", do you want to hit? y/n");
					choice = keyboard.nextLine();
					if (choice.equals("Y") || choice.equals("y"))
					{
						playerList.elementAt(i).addCardToHand(dealer1.deal());
						
						out.println("\nPLAYER "+(whichPlayer));
						out.println("Hand Value :: " + playerList.elementAt(i).getHandValue());
						out.println("Hand Size :: " + playerList.elementAt(i).getHandSize());
						out.println("Cards in Hand :: " + playerList.elementAt(i));
					}
					if (choice.equals("n") || choice.equals("N"))
					{
						out.print("Player "+whichPlayer+" stays\n");
						playerTurnIndex++;
					}
				
					if (playerList.elementAt(i).getHandValue()>21)
					{
						out.print("Player "+whichPlayer+" busted\n");
						playerTurnIndex++;
					}
				}
			
			}
			
			
			
			while(dealer1.getHandValue()<21 && dealerTurnCount ==0)
			{
				
				
			out.println("\nDealer");
			out.println("Hand Value :: " + dealer1.getHandValue());
			out.println("Hand Size :: " + dealer1.getHandSize());
			out.println("Cards in Hand :: " + dealer1);
			
			if (dealer1.getHandValue()<17)
			{
				dealer1.addCardToHand(dealer1.deal());
				out.println("\nThe Dealer hits\n");
				
				out.println("\nDealer");
				out.println("Hand Value :: " + dealer1.getHandValue());
				out.println("Hand Size :: " + dealer1.getHandSize());
				out.println("Cards in Hand :: " + dealer1);
			}
			if (dealer1.getHandValue()<=21 && dealer1.getHandValue()>=17)
			{
				out.println("\nThe Dealer stays");
				dealerTurnCount++;
			}
			if (dealer1.getHandValue()>21)
			{
				out.println("The Dealer busted");
				dealerTurnCount++;
			}
			}
		}
		
		if (dealer1.getHandValue()>21)
		{
			out.println("The Dealer busted");
			dealerTurnCount++;
		}
		
		//for loop to check the value of all player hands
		/*
		 * int highestPlayerHand =0; int highestPlayerHandValue = 0; whichPlayer = 0;
		 * for (int i=0; i <num; i++) { whichPlayer = 0; whichPlayer = (i+1); if
		 * (playerList.elementAt(i).getHandValue()>highestPlayerHandValue &&
		 * playerList.elementAt(i).getHandValue()<=21) { highestPlayerHandValue =
		 * playerList.elementAt(i).getHandValue(); highestPlayerHand = whichPlayer; } if
		 * (playerList.elementAt(i).getHandValue() ==highestPlayerHandValue) {
		 * 
		 * }
		 * 
		 * 
		 * }
		 */
		
		for(int i=0; i <num; i++)
		{
			whichPlayer = 0;
			whichPlayer = (i+1);
			if (playerList.elementAt(i).getHandValue()>dealer1.getHandValue() && playerList.elementAt(i).getHandValue()<=21)
			{
				out.println("\nPlayer "+whichPlayer+" beat the Dealer with a score of "+playerList.elementAt(i).getHandValue()+" to "+dealer1.getHandValue());
			}
			if (playerList.elementAt(i).getHandValue()==dealer1.getHandValue() && playerList.elementAt(i).getHandValue()<=21)
			{
				out.println("\nPlayer "+whichPlayer+" tied the Dealer with a score of "+playerList.elementAt(i).getHandValue());
			}
		
		}
		
		/*
		 * if(dealer1.getHandValue()<highestPlayerHandValue) {
		 * out.println("\nPlayer "+whichPlayer+" won with a score of "
		 * +highestPlayerHandValue); }
		 */
		
		if(dealer1.getHandValue()>21)
		{
			out.println("\nThe Dealer busted");
			dealerTurnCount++;
		}
		
		/*
		 * if(dealer1.getHandValue()>highestPlayerHandValue) {
		 * out.println("\nThe Dealer Won"); dealerTurnCount++; }
		 * 
		 * if(dealer1.getHandValue()==highestPlayerHandValue) {
		 * out.println("\nThe game ends in a standoff"); dealerTurnCount++; }
		 */
	
	}
	
	public static void main(String[] args)
	{
		BlackJackTest game = new BlackJackTest();
		game.playGame();
	}
}