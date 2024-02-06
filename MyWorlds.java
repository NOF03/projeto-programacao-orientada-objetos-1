import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;
/**
 * Write a description of class MyWorlds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorlds extends World
{
    public static float internalScale = 0.8f;
    public static int screenWidth = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
    public static int screenHeight = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight());
    
    protected Players[] allPlayer;
    protected int numberPlayers;
    private static GreenfootImage background;
    
    // Classe criada para adaptar o tamanho do jogo ao tamanho do ecrã
    public MyWorlds()
    {   
        super((int)(screenWidth*internalScale), (int)(screenHeight*internalScale), 1);
        background = getBackground();
        
        background.scale(getWidth(), getHeight());
    }
    
    
}
