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
        if(faceValue == 1){
            this.faceValue = 11;
        } else if(faceValue == 11){
            this.faceValue = 10;
        }else if(faceValue == 12){
            this.faceValue = 10;
        }else if(faceValue == 13){
            this.faceValue = 10;
        }
    }
    public void act() 
    {
    }   
    public int getFaceValue(){
        return faceValue;
    }
    public void setFaceValue(int faceValue){
        this.faceValue = faceValue;
    }
}
