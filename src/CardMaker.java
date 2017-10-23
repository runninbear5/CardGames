import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class CardMaker {
	ArrayList<Card> fullDeck = new ArrayList<Card>();
	
	public CardMaker() throws IOException{
		String[] suits = {"Diamonds", "Hearts", "Spades", "Clubs"};
		int face = 1;
		for (; face <= 13; face++)
		{
<<<<<<< HEAD
			for (String suit: suits) {
				int index = fullDeck.length;  
				String fileName = "C:\\Users\\lieberb1400\\Documents\\Eclipse\\CardGames\\resources" + face + "_" + "of" + "_" + suit + ".png";
				fullDeck[index-1] = new Card(suit, face, true, false, false);
				//add back later to get buffered image ImageIO.read(new File (fileName))
=======
			for (String suit: suits) {  
				String fileName = "file:///D:/CardGame/resources/" + face + "_" + "of" + "_" + suit + ".png";
				fullDeck.add(new Card(suit, face, true, false, false));
				//add in later ImageIO.read(new File (fileName))
>>>>>>> be6a8a291715b4471092bde6a20dbf729889b66d
				//need to set it so that if suit = 0 spades, suit = 1 clubs, and so on 
			}
		}
		
	}
}
