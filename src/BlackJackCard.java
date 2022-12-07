//Name -
//Date -

public class BlackJackCard extends Card
{
  	//constructors
	
	
	public BlackJackCard(int f, String s)
  	{
  		super( s, f );
  	}
	
	public int getValue()
	{
		if( getFace() == 1 )
			return 11;
		if( getFace() >= 10 )
			return 10;
		return getFace();
	}
	//enables you to build the value for the game into the card
		//this makes writing the whole program a little easier
  	
	//toString
  	public String toString()
  	{
  		return super.toString() + " " + getValue();
  	}
 }