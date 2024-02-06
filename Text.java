import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Texto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    /**
     * Act - do whatever the Texto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Color Cor;

    public Text(){}

    public Text(String text, int size , Color cor){
        GreenfootImage image = new GreenfootImage(text.toUpperCase(),size, cor, new Color(0,0,0,0));
        setImage(image);
        Cor=cor;
    }

    public void act()
    {
    }

    public Color getCor()
    {
        return Cor;
    }
    
    public static void updateText(String texto, Actor text, int size, Color cor){
        GreenfootImage image = new GreenfootImage(texto.toUpperCase(),size, cor, new Color(0,0,0,0));
        text.setImage(image);
    }
}
