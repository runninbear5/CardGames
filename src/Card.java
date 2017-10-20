/*
 * 10/4/17
 * @author gClark
 * tutorial: https://www.youtube.com/watch?v=wRp3hlSV324&t=10s
 */
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card {
//instance variables. Most are private beacuse I don't want anything changing the name, value, ect of the cards. 
	private int faceValue; //ex "ace of spades"
	public String suit;
	public BufferedImage cardImage; //allows an image to be stored in the class
	public boolean inDeck;
	public boolean inHand;
	public boolean inPlay;
	
	public String[] suitName = new String[] {"spade", "club", "diamond", "heart"};
	public String[] faceName = new String[] {"", "ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
	
	//private so that nothing can change the value of the card except the class of card and the subclass
	/**
	 * The constructor for the Card class
	 * @param suit = "spades" "clubs" "hearts" or "diamonds"
	 * @param face = 2,3,4...9,10,Jack,Queen,King,Ace
	 * @param faceValue = 2,3,4... 12,13,14
	 * @param card = BufferedImage that represents the card
	 */
	public Card(String suit, int faceValue, BufferedImage card, boolean inDeck, boolean inHand, boolean inPlay) { //builds the card passing in value slots
		
		this.suit = suit; // this is now a local variable that belongs to the method, not the class
		//this.suit relates suit to the class suit instead of the constructor suit
		this.faceValue = faceValue;
		cardImage = card;
		this.inDeck = inDeck;
		this.inPlay = inPlay;
		this.inHand = inHand;
		
	}
	public Card(String suit, int faceValue, boolean inDeck, boolean inHand, boolean inPlay) { //builds the card passing in value slots
		
		this.suit = suit; // this is now a local variable that belongs to the method, not the class
		//this.suit relates suit to the class suit instead of the constructor suit
		this.faceValue = faceValue;
		cardImage = null;
		this.inDeck = inDeck;
		this.inPlay = inPlay;
		this.inHand = inHand;
		
	}
	/*
	 *This returns a String representation of a Card object
	 *@return
	 */
	
	      
	
	public String toString() {
		return faceName + " of " + suit; 
	}
	
	/**
	 * This returns the faceValue of the card object as an int
	 * @return
	 */
	public int getFaceValue() {
		return faceValue;
	}
	public Card[] getRandomCards(int numOfCards) {
		Deck deck = new Deck();
		Card[] decks = deck.getCards(2);
		return decks;
		
	}
	public Card getRandomCard() {
		Deck deck = new Deck();
		return deck.getCard();
	}
	
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	
	/*public static void main (String[] args) throws IOException {
		
		Card aceOfSpades = new Card("Spades","Ace",14,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\ace_of_spades.png")), true, false, false);
		Card aceOfHearts = new Card("Hearts","Ace",14,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\ace_of_hearts.png")), true, false, false);
		Card aceOfClubs = new Card("Clubs","Ace",14,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\ace_of_clubs.png")), true, false, false);
		Card aceOfDiamonds = new Card("Diamonds","Ace",14,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\ace_of_diamonds.png")), true, false, false);
		Card twoOfSpades = new Card("Spades","Two",2,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\2_of_spades.png")), true, false, false);
		Card twoOfHearts = new Card("Hearts","Two",2,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\2_of_hearts.png")), true, false, false);
		Card twoOfClubs = new Card("Clubs","Two",2,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\2_of_clubs.png")), true, false, false);
		Card twoOfDiamonds = new Card("Diamonds","Two",2,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\2_of_diamonds.png")), true, false, false);
		Card threeOfSpades = new Card("Spades","Three",3,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\3_of_spades.png")), true, false, false);
		Card threeOfHearts = new Card("Hearts","Three",3,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\3_of_hearts.png")), true, false, false);
		Card threeOfClubs = new Card("Clubs","Three",3,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\3_of_clubs.png")), true, false, false);
		Card threeOfDiamonds = new Card("Diamonds","Three",3,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\3_of_diamonds.png")), true, false, false);
		Card fourOfDiamonds = new Card("Diamonds","Four",4,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\4_of_diamonds.png")), true, false, false);
		Card fiveOfDiamonds = new Card("Diamonds","Five",5,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\5_of_diamonds.png")), true, false, false);
		Card sixOfDiamonds = new Card("Diamonds","Six",6,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\6_of_diamonds.png")), true, false, false);
		Card sevenOfDiamonds = new Card("Diamonds","Seven",7,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\7_of_diamonds.png")), true, false, false);
		Card eightOfDiamonds = new Card("Diamonds","Eight",8,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\8_of_diamonds.png")), true, false, false);
		Card nineOfDiamonds = new Card("Diamonds","Nine",9,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\9_of_diamonds.png")), true, false, false);
		Card tenOfDiamonds = new Card("Diamonds","Ten",10,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\10_of_diamonds.png")), true, false, false);
		Card jackOfDiamonds = new Card("Diamonds","Jack",11,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\jack_of_diamonds2.png")), true, false, false);
		Card queenOfDiamonds = new Card("Diamonds","Queen",12,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\queen_of_diamonds2.png")), true, false, false);
		Card kingOfDiamonds = new Card("Diamonds","King",13,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\king_of_diamonds2.png")), true, false, false);
		Card fourOfClubs = new Card("Clubs","Four",4,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\4_of_clubs.png")), true, false, false);
		Card fiveOfClubs = new Card("Clubs","Five",5,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\5_of_clubs.png")), true, false, false);
		Card sixOfClubs = new Card("Clubs","Six",6,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\6_of_clubs.png")), true, false, false);
		Card sevenOfClubs = new Card("Clubs","Seven",7,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\7_of_clubs.png")), true, false, false);
		Card eightOfClubs = new Card("Clubs","Eight",8,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\8_of_clubs.png")), true, false, false);
		Card nineOfClubs = new Card("Clubs","Nine",9,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\9_of_clubs.png")), true, false, false);
		Card tenOfClubs = new Card("Clubs","Ten",10,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\10_of_clubs.png")), true, false, false);
		Card jackOfClubs = new Card("Clubs","Jack",11,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\jack_of_clubs2.png")), true, false, false);
		Card queenOfClubs = new Card("Clubs","Queen",12,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\queen_of_clubs2.png")), true, false, false);
		Card kingOfClubs = new Card("Clubs","King",13,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\king_of_clubs2.png")), true, false, false);
		Card fourOfHearts = new Card("Hearts","Four",4,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\4_of_hearts.png")), true, false, false);
		Card fiveOfHearts = new Card("Hearts","Five",5,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\5_of_hearts.png")), true, false, false);
		Card sixOfHearts = new Card("Hearts","Six",6,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\6_of_hearts.png")), true, false, false);
		Card sevenOfHearts = new Card("Hearts","Seven",7,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\7_of_hearts.png")), true, false, false);
		Card eightOfHearts = new Card("Hearts","Eight",8,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\8_of_hearts.png")), true, false, false);
		Card nineOfHearts = new Card("Hearts","Nine",9,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\9_of_hearts.png")), true, false, false);
		Card tenOfHearts = new Card("Hearts","Ten",10,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\10_of_hearts.png")), true, false, false);
		Card jackOfHearts = new Card("Hearts","Jack",11,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\jack_of_hearts2.png")), true, false, false);
		Card queenOfHearts = new Card("Hearts","Queen",12,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\queen_of_hearts2.png")), true, false, false);
		Card kingOfHearts = new Card("Hearts","King",13,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\king_of_hearts2.png")), true, false, false);
		Card fourOfSpades = new Card("Spades","Four",14,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\4_of_spades.png")), true, false, false);
		Card fiveOfSpades = new Card("Spades","Five",14,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\5_of_spades.png")), true, false, false);
		Card sixOfSpades = new Card("Spades","Six",14,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\6_of_spades.png")), true, false, false);
		Card sevenOfSpades = new Card("Spades","Seven",14,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\7_of_spades.png")), true, false, false);
		Card eightOfSpades = new Card("Spades","Eight",14,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\8_of_spades.png")), true, false, false);
		Card nineOfSpades = new Card("Spades","Nine",14,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\9_of_spades.png")), true, false, false);
		Card tenOfSpades = new Card("Spades","Ten",14,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\10_of_spades.png")), true, false, false);
		Card jackOfSpades = new Card("Spades","Jack",14,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\jack_of_spades2.png")), true, false, false);
		Card queenOfSpades = new Card("Spades","Queen",14,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\queen_of_spades2.png")), true, false, false);
		Card kingOfSpades = new Card("Spades","King",14,ImageIO.read(new File ("C:\\Users\\clarkg0206\\eclipse-workspace\\CardGame\\resources\\king_of_spades2.png")), true, false, false);




debug
	
		
		//Creation of a JFrame to display the card image. Not the content just the outside
		JFrame window = new JFrame("Display for a Card object");
		window.setSize(600, 900); //in pixels
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //what happens when you try to close the window
		window.setVisible(true); //this makes it so that the window will show
		
		
		//Creation of a JPanel (it's what's inside the JFrame)
		JPanel contentPane = new JPanel(new BorderLayout());
		
	
		//Creation of a JLabel (holds images and text on your JPanel)
		JLabel cardLabel = new JLabel(new ImageIcon(kingOfDiamonds.cardImage));
	
		cardLabel.setSize(300,400);
		
		//puts these all together
		contentPane.add(cardLabel); //similar to adding something to write on the glass with
		window.add(contentPane); // similar to adding glass to the frame
		
		//debug
		System.out.println(twoOfHearts.toString());//prints the card name and suit
		System.out.println("The two of hearts has a value of " + twoOfSpades.faceValue); //prints the value
		
		
	}*/
}
