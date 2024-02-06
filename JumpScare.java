import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;
/**
 * Write a description of class JumpScare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JumpScare extends MyWorlds
{
   
    private GreenfootImage image1, image2;
    GreenfootImage actualImage;
    /**
     * Constructor for objects of class JumpScare.
     * 
     */
    public JumpScare()
    {
        image1 = new GreenfootImage("jumpscare1.png");
        image1.scale (getWidth(), getHeight());
        image2 = new GreenfootImage("jumpscare2.png");
        image2.scale (getWidth(), getHeight());
        GreenfootSound sound = new GreenfootSound("jumpscare.wav");
        sound.setVolume(80);
        sound.play();
    }
    
    // Função para mudar de imagem conforme atualização do act
    private GreenfootImage changeImage() {
        if (actualImage == image1)
          actualImage = image2;
        else
          actualImage = image1;
        return actualImage;
    }
    
    public void act(){
        setBackground(changeImage());
    }
}
