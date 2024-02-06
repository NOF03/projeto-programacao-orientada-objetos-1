import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Computer extends Objects
{
    private String Letter;
    public boolean interacted;
    
    public Computer(String Letter) {
      this.Letter = Letter;
      interacted=false;
      
      rescale(getImage(), 0.05);
    }
    
    public void act()
    {
        codeMorse();
    }
    
    //Função para ativar o som que o computador irá produzir(depende da letra do código morse)
    protected void codeMorse(){
        for (Players player : ((MyWorlds)getWorld()).allPlayer) {
            if (Greenfoot.isKeyDown(player.keyAction) && getOneIntersectingObject(Players.class) == player) {
                GreenfootSound sound= new GreenfootSound(Letter+"-codigo morse.wav");
                sound.setVolume(40);
                sound.play();
                interacted=true;
                break;
            }
        }
        
    }
    
}
