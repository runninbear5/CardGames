import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CardMaker {
	Card [] fullDeck = new Card [52];
	
	public CardMaker() throws IOException{
		String[] suits = {"Diamonds", "Hearts", "Spades", "Clubs"};
		int face = 0;
		for (; face <= 13; face++)
		{
			for (String suit: suits) {
				int index = fullDeck.length;  
				String fileName = "C:\\Users\\lieberb1400\\Documents\\Eclipse\\CardGames\\resources" + face + "_" + "of" + "_" + suit + ".png";
				fullDeck[index-1] = new Card(suit, face, true, false, false);
				//add back later to get buffered image ImageIO.read(new File (fileName))
				//need to set it so that if suit = 0 spades, suit = 1 clubs, and so on 
			}
		}
		
	}
}
