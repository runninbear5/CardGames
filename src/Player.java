/*What does a player have?
 * Hand
 * Have they won or not?
 * Money (for betting games)
 * 
 */
import java.io.IOException;
import java.util.Scanner;
public class Player {
	
	private String playerName;
	private Deck hand;
	private boolean isDealer;
	private int money;
	private static CardMaker cm;
	
	public Player (String name) throws IOException
	{
		playerName = name;
		hand = new Deck();
		isDealer = false;
		cm = new CardMaker();
		
	}
	
	public void setName(String playerName) {
		this.playerName=playerName;
	}
	public String getName() {
		return playerName;
	}
	public static CardMaker getCardMaker() {
		return cm;
	}
	public void setDealer (boolean isDealer) {
		this.isDealer=isDealer;
	}
	public boolean getDealer() {
		return isDealer;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getMoney() {
		return money;
	}
	public void setHand(Deck hand) {
		this.hand = hand;
	}
	public Deck getHand() {
		return hand;
	}
	public Card getCard() {
		Deck dk = new Deck();
		return dk.getCard();
	}
	public Card[] getCards(int numOfCards) {
		Deck dk = new Deck();
		return dk.getCards(numOfCards);
	}
	public int hit(int totalCardValue, Card newCard) {
     	totalCardValue += newCard.getFaceValue();
     	System.out.println("Your new card is a " +newCard.faceName +" of " +newCard.suit);
     	System.out.println("Your total card value is " +totalCardValue);
     	return totalCardValue;
	}
     public boolean stay(int totalCardValue) {
    	 System.out.println("Your total card value is " +totalCardValue);
    	 return false;
     }
	
	
	//how do I get and set a players hand?

	public static void main (String[] args) {
		//debug (I think I don't need this)
//		Player p1 = new Player ("Player 1");
//		p1.setName("Armstrong");
//		p1.setDealer(false);
//		p1.setMoney(1000);
		
		/* in order to set players:
		 *ask how many players (set up for loop)
		 *ask for name
		 *ask for amount of money (or assign default amount) 
		 */
		
		/*To initialize dealer:
		 * Ask for name of dealer
		 */
	}
}
