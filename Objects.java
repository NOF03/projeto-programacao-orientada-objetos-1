import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;

public class Objects extends Actor
{
    public static int screenWidth = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
    public static float internalScale = 0.8f;
    
    protected GreenfootImage myImage;
    protected double constant; 
    
    // Função utilizada para dar mudar o tamanho dos objetos conforme o tamanho do ecrã
    protected void rescale(GreenfootImage image,double constant) {
        setImage(image);
        double imgWidth = image.getWidth();
        double imgHeight = image.getHeight();
        double proportion = imgHeight/imgWidth;
        int newWidth = (int)(screenWidth*internalScale*constant);
        image.scale(newWidth, (int)(newWidth*proportion));
    }
}
