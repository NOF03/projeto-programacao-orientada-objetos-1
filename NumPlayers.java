import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;
/**
 * Write a description of class NumPlayers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumPlayers extends MyWorlds
{
    public int NumPlayers;
    private GreenfootImage blackImage;
    private int transparency = 255;
    
    public NumPlayers()
    {
        prepare();
        
        GreenfootImage background = new GreenfootImage("menu1.png");
        background.scale(getWidth(),getHeight());
        setBackground(background);
        
    }
  
    
    public void prepare(){
        addObject(new Text("Introduza o número de jogadores",45, new Color(255,255,255)),getWidth()/2,getHeight()/8);
        for(int i=0;i<3;i++){
            String a = Integer.toString(2+i);
            addObject(new Text(a,75, new Color(255,255,255)),((i+1)*getWidth()/4),getHeight()/2);
            addObject(new Select(i),((i+1)*getWidth()/4),getHeight()/2);
            
        }
        
    }
    

}
