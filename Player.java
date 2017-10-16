/*What does a player have?
 * Hand
 * Have they won or not?
 * Money (for betting games)
 * 
 */
import java.util.Scanner;
public class Player {
	
	private String playerName;
	private Deck hand;
	private boolean isDealer;
	private int money;
	
	public Player (String name)
	{
		playerName = name;
		hand = new Deck();
		isDealer = false;
		
	}
	
	public void setName(String playerName) {
		this.playerName=playerName;
	}
	public String getName() {
		return playerName;
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
