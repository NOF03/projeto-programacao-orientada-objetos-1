import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Buttons
{
    private GreenfootImage image1, image2;

    public Play()
    {
        image1 = new GreenfootImage("play_white.png");
        image2 = new GreenfootImage("play.png");
        rescale(image2, 0.35);
        rescale(image1, 0.35);
    }
    
    public void act() {
        moveMouse(image2,image1);
        clickMouse();
    }
    
    //Função para iniciar o jogo
    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            //playClick();
            //setColor(Color.BLACK);
            GreenfootSound sound = new GreenfootSound("interact_sound.wav");
            sound.setVolume(85);
            sound.play();
            imageFade();
            Greenfoot.setWorld(new Story()); 
        }
    }  
}
