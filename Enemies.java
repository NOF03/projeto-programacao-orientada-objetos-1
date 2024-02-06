import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemies extends Objects
{
    protected boolean tooken = false;
    
    protected void touchingPlayer() {
        if (isTouching(Players.class)) {
            if (!tooken) {
                ((TheGame)getWorld()).decreaseNumVidas();
                tooken = true;
            }
        }
    }
}
