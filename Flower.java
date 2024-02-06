import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Flower extends Objects
{
    public Flower() {
        rescale(getImage(), 0.03f);
    }
    
    public void act()
    {
        interactPlant();
    }

    // Função para que mal a planta possa ser interagida, após os 5 computadores serem usados, ao clicar nela, a porta abra e o jogador possa seguir o jogo
    protected void interactPlant(){
      for (Players player : ((MyWorlds)getWorld()).allPlayer) {
          if (Greenfoot.isKeyDown(player.keyAction) && isTouching(Players.class) && player.touchingFlower()){
            for (Computer computer : ((Game2)getWorld()).computers) {
                if (!computer.interacted) return;
            }
            ((Game2)getWorld()).incrementHasKey();
            ((Game2)getWorld()).removeObject(((Game2)getWorld()).clock);
            ((Game2)getWorld()).a = false;
            ((TheGame)getWorld()).openDoor();
            getWorld().removeObject(this);
            break;
            }
        }
    }

}