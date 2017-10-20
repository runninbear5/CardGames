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
			for (String suit: suits) {  
				String fileName = "file:///D:/CardGame/resources/" + face + "_" + "of" + "_" + suit + ".png";
				fullDeck.add(new Card(suit, face, true, false, false));
				//add in later ImageIO.read(new File (fileName))
				//need to set it so that if suit = 0 spades, suit = 1 clubs, and so on 
			}
		}
		
	}
}
