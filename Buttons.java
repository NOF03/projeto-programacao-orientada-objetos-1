import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buttons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buttons extends Objects
{
    private GreenfootImage blackImage;
    private int transparency = 0;
    
    protected void moveMouse(GreenfootImage image1, GreenfootImage image2){
        if(Greenfoot.mouseMoved(this)){
            setImage(image1);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage(image2);
        }
    }
    
    //Função que dá black out do mundo
    protected void imageFade() {
        blackImage = getWorld().getBackground();
        blackImage.setColor(greenfoot.Color.BLACK);
        
        blackImage.fill();
        blackImage.setTransparency(transparency);
        blackImage.scale(getWorld().getWidth(), getWorld().getHeight());
        while(transparency != 100)
            {
                blackImage.setTransparency(transparency);
                transparency = transparency + 1;
                Greenfoot.delay(1);
            }
        
    }
}
