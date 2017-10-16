import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Deck {
	public Deck() {
Card [] handOfCards = new Card[5]; 
	if (handOfCards.length > 52) {
		System.out.println("Error. Please make sure that your hand has 15 or less cards");
	}
	/*
	 * need to:
	 * get random number 0-51
	 * use that to determine which card you draw
	 * check if the inDeck is true and inHand and inPlay are false
	 * put chosen card into hand
	 * set inDeck to false, inPlay to false, and in Hand to true
	 * repeat until hand is full
	 */
	
	// getting and casting random number
	int randomCard = (int)(Math.random() * 52);
	
	try
	{
	CardMaker cm = new CardMaker(); //throws IOException I need to put this in somewhere
	for (int i = 0; i < handOfCards.length; i++) {
		while (!(cm.fullDeck[randomCard].inDeck == true && cm.fullDeck[randomCard].inHand == false && cm.fullDeck[randomCard].inPlay == false)) {
			randomCard = (int)(Math.random() *52);
		}
		handOfCards[i] = cm.fullDeck[randomCard];
		handOfCards[i].inDeck = false;
		handOfCards[i].inHand = true;
		// Basic bool logic to figure out if a card can be drawn from the deck or not.
//		System.out.println(handOfCards[i]);
	}
	
	}
	catch (IOException e)
	{
			System.out.println("IOException Error");
	}
	
	
	
}
}
