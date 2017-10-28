import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class CardMaker {
	ArrayList<CardNonImage> fullDeck = new ArrayList<CardNonImage>();
	
	public CardMaker() throws IOException{
		String[] suits = {"diamonds", "hearts", "spades", "clubs"};
		int face = 1;
		String[] cards = {"", "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
		for (; face <= 13; face++)
		{
			for (String suit: suits) {  
				String fileName = cards[face] + "_" + "of" + "_" + suit + ".png";
				fullDeck.add(new CardNonImage(suit, face, true, false, false, fileName));
				//add in later ImageIO.read(new File (fileName))
				//need to set it so that if suit = 0 spades, suit = 1 clubs, and so on 
			}
		}
		
	}
}
