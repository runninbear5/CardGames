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
				String fileName = "file:///D:/CardGame/resources/" + face + "_" + "of" + "_" + suit + ".png";
				fullDeck[index] = new Card(suit, face,ImageIO.read(new File (fileName)), true, false, false);
				//need to set it so that if suit = 0 spades, suit = 1 clubs, and so on 
			}
		}
		
	}
}
