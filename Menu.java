import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;

public class Menu extends MyWorlds
{
    private boolean controlador=true;
    public GreenfootSound menuSound = new GreenfootSound("menu.wav");
    
    public Menu()
    {    
        addObject(new Play(), 3*getWidth()/4, getHeight()/5);
    }
    
    public void act(){
        menuMusic();
    }
    
    //
    private void menuMusic(){
        if(controlador){
            controlador=false;
            menuSound.setVolume(10);
            menuSound.playLoop();
            
        }    
        if(Greenfoot.mouseClicked(Select.class)){
            menuSound.pause();
        }
    }
    
    public GreenfootSound getMenuSound(){
        return this.menuSound;
    }
}
