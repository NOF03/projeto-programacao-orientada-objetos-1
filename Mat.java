import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tapete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mat extends Objects
{
    /**
     * Act - do whatever the Tapete wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Mat(int numero){
            rescale(getImage(),0.09);
    
    }
    public Mat() {
        rescale(getImage(), 0.14);
    }
    public void act()
    {
        // Add your action code here.
    }
}
