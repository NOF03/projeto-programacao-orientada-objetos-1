import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chair1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chair1 extends Chairs
{
    /**
     * Act - do whatever the Chair1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int chair;
    public Chair1(){
        
    }
    public Chair1(int chair){
        this.chair = chair;
        if(chair==1){
            GreenfootImage img = getImage();
            img.mirrorHorizontally();
            setImage(img);  
        }
    }
    public void act()
    {
        // Add your action code here.
    }
}
