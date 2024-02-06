import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Victory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Victory extends MyWorlds
{
    private final int TEXT_SIZE=100;
    public Text a;
    /**
     * Constructor for objects of class Victory.
     * 
     */
    public Victory()
    {        
        a();
        
    }
    public void act(){
        b();
    }
    public void a(){
        a = new Text("YOU ESCAPED",TEXT_SIZE, new Color(255,0,0));
        addObject(a, getWidth()/2,125);
    }
    public void b(){
        Greenfoot.ask("Did you enjoy the game?");
        Greenfoot.stop();
    }
}
