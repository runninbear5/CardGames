import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card extends Actor
{
    /**
     * Act - do whatever the card wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String cardImage;
    int faceValue;
    public Card(String cardImage, int faceValue){
        setImage(cardImage);
        getImage().scale(75,100);
        this.cardImage = cardImage;
        this.faceValue = faceValue;
    }
    public void act() 
    {
    }   
    public int getFaceValue(){
        return faceValue;
    }
}
