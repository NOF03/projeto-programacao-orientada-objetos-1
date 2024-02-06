import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Table2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Table2 extends Enemies
{
    public Table2(){
        rescale(getImage(),0.12);
    }
    public void act()
    {
        touchingPlayer();
    }
    
    @Override
    public void touchingPlayer() {
        for (Players player : ((MyWorlds)getWorld()).allPlayer) {
            if (Greenfoot.isKeyDown(player.keyAction) && getOneIntersectingObject(Players.class) == player && !tooken) {
                ((TheGame)getWorld()).decreaseNumVidas();
                tooken = true;
                break;
            }
        }
    }
}
