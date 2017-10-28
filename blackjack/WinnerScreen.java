import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class WinnerScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinnerScreen extends World
{
    /**
     * Constructor for objects of class WinnerScreen.
     * 
     */
    public WinnerScreen(ArrayList<Card> playerCards, ArrayList<Card> dealerCards)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        addObject(new PlayAgain(), 392, 545);
        addObject(new Quit(), 625, 545);
        int X = 425;
        for(int i=0; i<playerCards.size(); i++){
            addObject(playerCards.get(i), X+(i*80), 430);
        }
        for(int i=0; i<dealerCards.size(); i++){
            addObject(dealerCards.get(i), X+(i*80), 115);
        }
    }
}
