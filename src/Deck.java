import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Deck {
	public Deck() {
//	Card [] handOfCards = new Card[numOfCards]; 
//	if (handOfCards.length > 52) {
//		System.out.println("Error. Please make sure that your hand has 15 or less cards");
//	}
//	/*
//	 * need to:
//	 * get random number 0-51
//	 * use that to determine which card you draw
//	 * check if the inDeck is true and inHand and inPlay are false
//	 * put chosen card into hand
//	 * set inDeck to false, inPlay to false, and in Hand to true
//	 * repeat until hand is full
//	 */
//	
//	// getting and casting random number
//	int randomCard = (int)(Math.random() * 52);
//	
//	try
//	{
//		CardMaker cm = new CardMaker(); //throws IOException I need to put this in somewhere
//		for (int i = 0; i < handOfCards.length; i++) {
//			while (!(cm.fullDeck[randomCard].inDeck == true && cm.fullDeck[randomCard].inHand == false && cm.fullDeck[randomCard].inPlay == false)) {
//				randomCard = (int)(Math.random() *52);
//			}	
//			handOfCards[i] = cm.fullDeck[randomCard];
//			handOfCards[i].inDeck = false;
//			handOfCards[i].inHand = true;
//		// Basic bool logic to figure out if a card can be drawn from the deck or not.
////		System.out.println(handOfCards[i]);
//		}
//	
//	}
//	catch (IOException e)
//	{
//		System.out.println("IOException Error");
//	}
	
	
	
}
	public Card[] getCards(int numOfCards) {
		Card [] handOfCards = new Card[numOfCards]; 
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
		
<<<<<<< HEAD
			CardMaker cm = Player.getCardMaker(); //throws IOException I need to put this in somewhere
=======
			CardMaker cm = Player.getCardMaker();//throws IOException I need to put this in somewhere
>>>>>>> be6a8a291715b4471092bde6a20dbf729889b66d
			for (int i = 0; i < handOfCards.length; i++) {
				while (!(cm.fullDeck.get(randomCard).inDeck == true && cm.fullDeck.get(randomCard).inHand == false && cm.fullDeck.get(randomCard).inPlay == false)) {
					randomCard = (int)(Math.random() *52);
				}	
				handOfCards[i] = cm.fullDeck.get(randomCard);
				handOfCards[i].inDeck = false;
				handOfCards[i].inHand = true;
			// Basic bool logic to figure out if a card can be drawn from the deck or not.
//			System.out.println(handOfCards[i]);
			}
		
		return handOfCards;
	}
	public Card getCard() {
		Card [] singleHandOfCard = new Card[1]; 
		if (singleHandOfCard.length > 52) {
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
		
<<<<<<< HEAD
			CardMaker cm = Player.getCardMaker(); //throws IOException I need to put this in somewhere
=======
			CardMaker cm = Player.getCardMaker();//throws IOException I need to put this in somewhere
>>>>>>> be6a8a291715b4471092bde6a20dbf729889b66d
			for (int i = 0; i < singleHandOfCard.length; i++) {
				while (!(cm.fullDeck.get(randomCard).inDeck == true && cm.fullDeck.get(randomCard).inHand == false && cm.fullDeck.get(randomCard).inPlay == false)) {
					randomCard = (int)(Math.random() *52);
				}	
				singleHandOfCard[i] = cm.fullDeck.get(randomCard);
				singleHandOfCard[i].inDeck = false;
				singleHandOfCard[i].inHand = true;
			// Basic bool logic to figure out if a card can be drawn from the deck or not.
//			System.out.println(handOfCards[i]);
			}
		
		return singleHandOfCard[0];
	}
	
}

