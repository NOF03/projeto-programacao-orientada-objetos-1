import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends Enemies
{
    private final int DELTA=6;
    public int initialWidth, initialHeight;

    public Bullet(){
        rescale(getImage(),0.05);
    }
    
    public void act()
    {
        move();
        collision();
        touchingPlayer();
    }
    
    // Função para o movimento do Fantasma
    private void move(){
        setLocation(getX()-DELTA,getY());
    }
    
    // Função para detetar a colisão com a parede da esquerda e voltar à posição inicial
    private void collision(){
        if(getX()==0){
            ((Game2)getWorld()).b = true;
            tooken = false;
            setLocation(initialWidth, initialHeight);
        }
        
    }
}
