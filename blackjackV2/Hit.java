import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.IOException;
/**
 * Write a description of class Hit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hit extends Actor
{
    /**
     * Act - do whatever the Hit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Hit() throws IOException{
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            ((blackjackTable)getWorld()).playerHit();
        }
    }  
}
