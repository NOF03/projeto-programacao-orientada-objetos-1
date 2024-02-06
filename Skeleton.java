import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Skeleton extends Players
{
    protected int indice;
    private int contador;
    private int direction=1;
    private final int DELTA=1;
    private GreenfootImage[] animacaoFrente;
    private GreenfootImage[] animacaoDireita;
    private GreenfootImage[] animacaoEsquerda;
    private GreenfootImage[] animacaoTras;
    private GreenfootImage[] animationWalking;
    protected boolean tooken = false;
    public Skeleton() {
        saveAnimations();
        contador=0;
        indice=0;
        animationWalking = animacaoFrente;
    }
    
    public void act()
    {
        move();
        collision();
        touchingPlayer();
    }
    
    private void move(){
        setLocation(getX(),getY()+direction*DELTA);
        animateMove(animationWalking);
    }
    
    //Função para detetar colisões com o mundo e/ou alguma mobilia presente
    private void collision(){
        if(isTouching(Skeleton.class)||getY()==0||getY()==getWorld().getHeight()-1 || isTouching(Furniture.class)){ 
            
            direction=-direction;
            if (direction == 1) {
                animationWalking = animacaoTras;
            } else
                animationWalking = animacaoFrente;
            
        }
    }
    
    //Função, em override, para salvar as animações dos esqueletos
    @Override
    protected void saveAnimations() {
        animacaoDireita = new GreenfootImage[9];       
        for(int i=0; i < animacaoDireita.length;i++)
        {
            animacaoDireita[i]=new GreenfootImage("Animacoes/" + "Bad/Direita (" + (i+1) + ").png");
            rescale(animacaoDireita[i], 0.04);
        }
        
        animacaoEsquerda = new GreenfootImage[9];      
        for(int i=0; i < animacaoEsquerda.length;i++)
        {
            animacaoEsquerda[i]=new GreenfootImage("Animacoes/" + "Bad/Esquerda (" + (i+1) + ").png");
            rescale(animacaoEsquerda[i], 0.04);
        }
        
        animacaoFrente = new GreenfootImage[9]; 
        for(int i=0; i < animacaoFrente.length;i++)
        {
            animacaoFrente[i]=new GreenfootImage("Animacoes/" + "Bad/Frente (" + (i+1) + ").png");
            rescale(animacaoFrente[i], 0.04);
        }
        
        animacaoTras = new GreenfootImage[9];
        for(int i=0; i < animacaoTras.length;i++)
        {
            animacaoTras[i]=new GreenfootImage("Animacoes/" + "Bad/Tras (" + (i+1) + ").png");
            rescale(animacaoTras[i], 0.04);
        }
    }
    
    //Função para verificar se está em contacto com um jogador
    protected void touchingPlayer() {
        if (isTouching(Players.class)) {
            if(isTouching(Skeleton.class)) return;
            if (!tooken) {
                ((TheGame)getWorld()).decreaseNumVidas();
                tooken = true;
            }
        } else
            tooken = false;
    }
}
