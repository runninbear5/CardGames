import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.IOException;
/**
 * Write a description of class PlayAgain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayAgain extends Actor
{
    /**
     * Act - do whatever the PlayAgain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            try{
                Greenfoot.setWorld(new blackjackTable());
            }catch(IOException e){
                
            }
        }
    }    
}
