import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Select here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Select extends Buttons
{
    public int numero;
    private GreenfootImage image1, image2;
    
    public Select(int numero){
        this.numero=numero;
        image1 = new GreenfootImage("select.png");
        image2 = new GreenfootImage("select1.png");
        rescale(image2, 0.19f);
        rescale(image1, 0.17f);
        
    }
    
    public void act()
    {
        clickMouse();
        moveMouse(image2,image1);
    }
    
    //Função para obter o valor selecionado e iniciar o mundo com esse mesmo número de jogadores
    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            imageFade();
            Greenfoot.setWorld(new Hall(numero + 2));
            GreenfootSound sound = new GreenfootSound("interact_sound.wav");
            sound.setVolume(85);
            sound.play();
        }
    }
}
