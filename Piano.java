import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Piano here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Piano extends Furniture
{
    /**
     * Act - do whatever the Piano wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Piano(){
        rescale(getImage(),0.13);
    }
    public void act()
    {
        // Add your action code here.
        music();
    }
    public void music(){
        for (Players player : ((MyWorlds)getWorld()).allPlayer) {
            if (Greenfoot.isKeyDown(player.keyAction) && getOneIntersectingObject(Players.class) == player) {
                GreenfootSound sound = new GreenfootSound("piano1.wav");
                sound.setVolume(85);
                sound.play();
                break;
            }
        }
    }
}
