import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class PlayerTotal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerTotal extends Actor
{
    /**
     * Act - do whatever the PlayerTotal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int playerTotal;
    public PlayerTotal(int playerTotal){
        setImage(new GreenfootImage("Player Total: "+playerTotal, 25, greenfoot.Color.RED, greenfoot.Color.BLACK));
        this.playerTotal = playerTotal;
    }
    public void act(){
        setTotal(playerTotal);
    }
    public void setTotal(int playerTotal) 
    {
        setImage(new GreenfootImage("Player Total: "+playerTotal, 25, greenfoot.Color.RED, greenfoot.Color.BLACK));
    }    
}
