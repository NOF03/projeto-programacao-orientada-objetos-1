import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Door extends Objects
{
    private int lobby;

    public Door(int lobby) {
        this.lobby = lobby;
        rescale(getImage(), 0.075);
    }
    public void act()
    {
        changeWorld();
    }
    
    //Função para mudar o mundo conforme o mundo em que este objeto está colocado e em que jogos o jogador já esteve
    protected void changeWorld() {
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
        if (getWorld().getClass() == Game1.class) {
            ((TheGame) getWorld()).togglePlayedStatusFirst();
        } else if (getWorld().getClass() == Game2.class) {
            ((TheGame) getWorld()).togglePlayedStatusSecond();
        }
        Greenfoot.playSound("door_opening.wav");
        switch (lobby) {
            case 1: 
                    Greenfoot.setWorld(new Game1(((TheGame)getWorld()).getPlayers(),((TheGame)getWorld()).getNumberPlayers(), ((TheGame) getWorld()).getPlayedSecond(), ((TheGame) getWorld()).getNumVidas())); 
                    break;
            case 2:
                    Greenfoot.setWorld(new Game2(((TheGame)getWorld()).getPlayers(),((TheGame)getWorld()).getNumberPlayers(), ((TheGame) getWorld()).getPlayedFirst(), ((TheGame) getWorld()).getNumVidas())); 
                    break;
            default:
                    Greenfoot.setWorld(new Hall(((TheGame)getWorld()).getPlayers(),((TheGame)getWorld()).getNumberPlayers(), ((TheGame) getWorld()).getPlayedFirst(), ((TheGame) getWorld()).getPlayedSecond(), ((TheGame) getWorld()).getNumVidas()));
                    break;
        }
    }
}
