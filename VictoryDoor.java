import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VictoryDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VictoryDoor extends Objects
{
    
    public void act()
    {
        rescale(getImage(), 0.1);
        changeWorld();
    }
    
    //Verificar saída na porta de todos os jogadores
    private void changeWorld() {
        for (Players player : ((MyWorlds)getWorld()).allPlayer) {
            boolean checkExists = false;
            for (Players getPlayer : getIntersectingObjects(Players.class)) {
                if (player == getPlayer){
                    checkExists = true;
                    break;
                }   
            }
            if (!checkExists) return;
        }
        Greenfoot.setWorld(new Victory());
    }
}
