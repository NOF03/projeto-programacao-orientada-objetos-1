import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skip extends Buttons
{
    private GreenfootImage image1, image2;
    
    public Skip() {
        image1 = new GreenfootImage("skip.png");
        image2 = new GreenfootImage("skip2.png");
        rescale(image2, 0.075);
        rescale(image1, 0.075);
    }
    
    public void act()
    {
        moveMouse(image2,image1);

        clickMouse();
    }
    
    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            GreenfootSound sound = new GreenfootSound("interact_sound.wav");
            sound.setVolume(85);
            sound.play();
            imageFade();
            Greenfoot.setWorld(new NumPlayers()); 
        }
    } 
}
