import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Generator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Generator extends Objects
{
    public Generator() {
        rescale(getImage(), 0.05);
    }
    
    //Função para verificar se está um jogador intersetando o Gerador
    public boolean verifyTouchingPlayer() {
        return getOneIntersectingObject(Players.class) != null;
    }
    
    //Função para verificar se o botão desse jogador está pressionado
    public boolean verifyActionButtonDown() {
        return Greenfoot.isKeyDown(((Players)getOneIntersectingObject(Players.class)).keyAction);
    }
}
