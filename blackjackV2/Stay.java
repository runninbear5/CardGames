import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stay extends Actor
{
    /**
     * Act - do whatever the Stay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Stay(){
        getImage().scale(75,75);
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            ((blackjackTable)getWorld()).playerStay();
        }
    }    
}
