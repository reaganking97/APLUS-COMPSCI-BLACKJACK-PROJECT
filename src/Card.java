//Name - Reagan King
//Date - 11/7/22

public class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;

  	//constructors
	public Card( String s, int f)
  	{
  		suit = s;
  		face = f;
  	}

	// modifiers
	public void setFace( int f)
	{
		face = f;
	}
	public void setSuit( String s)
	{
		suit = s;
	}

  	//accessors
	
	public String getSuit()
	{
		return suit;
	}
	public int getFace()
	{
		return face;
	}
  	//public abstract int getValue();
  	
  	public int getValue()
  	{
  		return face;
  	}

	public boolean equals(Object obj)
	{
		 if (suit.equals(((Card) obj).getSuit()) &&face==((Card) obj).getFace())
			 return true;
	return false;
	}

  	//toString
  	public String toString()
  	{
  		return FACES[face] + " of " + suit + " | value";
  	}
 }