import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PortaClosed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoorClosed extends Objects
{
    /**
     * Act - do whatever the PortaClosed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public DoorClosed() {
        rescale(getImage(), 0.075);
    }
    public void act()
    {
        // Add your action code here.
        //changeWorld();
        
    }
    /*private void changeWorld() {
        if (isTouching(Players.class)) {
            Greenfoot.playSound("door_opening.wav");
            Greenfoot.setWorld(new Hall(((Game1)getWorld()).getPlayers(),((Game1)getWorld()).getNumberPlayers()));            
        }
    }*/
}
