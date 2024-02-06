import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.event.KeyEvent;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Players extends Objects
{
    private int contador;
    private int numeroJogador;
    protected int indice;
    private GreenfootImage[] animacaoFrente;
    private GreenfootImage[] animacaoDireita;
    private GreenfootImage[] animacaoEsquerda;
    private GreenfootImage[] animacaoTras;
    private String keyRight;
    private String keyLeft;
    private String keyDown;
    private String keyUp;
    public String keyAction;
    GreenfootSound floor = new GreenfootSound("floor_sound.wav");

    public Players(int numeroJogador) {
        this.numeroJogador = numeroJogador;
        contador=0;
        indice=0;
        selectPlayer();
        saveAnimations();
        setImage(animacaoTras[0]);
    }
    
    public Players() {}
    
    public void act()
    {
        move();   
    }

    //Função para o movimento do jogador e possíveis interseções
    private void move() {
        if(Greenfoot.isKeyDown(keyRight) && (verifyRight(Wall.class) && verifyRight(Skeleton.class) && verifyRight(Furniture.class))) {
            setLocation(getX()+3, getY());
            animateMove(animacaoDireita);
            floor.play();
        }
        if(Greenfoot.isKeyDown(keyLeft) && (verifyLeft(Wall.class) && verifyLeft(Skeleton.class) && verifyLeft(Furniture.class))) { 
            setLocation(getX()-3, getY());
            animateMove(animacaoEsquerda);
            floor.play();
        }
        if(Greenfoot.isKeyDown(keyDown) && (verifyDown(Wall.class) && verifyDown(Skeleton.class) && verifyDown(Furniture.class))) { 
            setLocation(getX(), getY()+3);
            animateMove(animacaoTras);
            floor.play();
        }
        if(Greenfoot.isKeyDown(keyUp) && (verifyUp(Wall.class) && verifyUp(Skeleton.class) && verifyUp(Furniture.class))) { 
            setLocation(getX(), getY()-3);
            animateMove(animacaoFrente);
            floor.play();
        }
    }
    
    //Funções para verificar presença de alguma classe perto do jogador
    protected boolean verifyRight(Class oneClass) {
        return getWorld().getObjectsAt(getX()+10, getY(), oneClass).isEmpty();
    }
    protected boolean verifyLeft(Class oneClass) {
        return getWorld().getObjectsAt(getX()-10, getY(), oneClass).isEmpty();
    }
    protected boolean verifyDown(Class oneClass) {
        return getWorld().getObjectsAt(getX(), getY()+40, oneClass).isEmpty();
    }
    protected boolean verifyUp(Class oneClass) {
        return getWorld().getObjectsAt(getX(), getY()-20, oneClass).isEmpty();
    }

    //Função para animação do jogador
    public void animateMove(GreenfootImage[] animacao){
        contador++;
        if (contador==4){
            if(indice<animacao.length-1)
            {
                indice++;
            }
            else
            {
                indice=1;
            }
            setImage(animacao[indice]);
            contador=0;
        }
    }
    
    //Função para salvar animações dos jogadores
    protected void saveAnimations() {
        
        animacaoDireita = new GreenfootImage[9];       
        for(int i=0; i < animacaoDireita.length;i++)
        {
            animacaoDireita[i]=new GreenfootImage("Animacoes/" + "Player (" + numeroJogador + ")/Direita (" + (i+1) + ").png");
            rescale(animacaoDireita[i], 0.06);
        }
        
        animacaoEsquerda = new GreenfootImage[9];      
        for(int i=0; i < animacaoEsquerda.length;i++)
        {
            animacaoEsquerda[i]=new GreenfootImage("Animacoes/" + "Player (" + numeroJogador + ")/Esquerda (" + (i+1) + ").png");
            rescale(animacaoEsquerda[i], 0.06);
        }
        
        animacaoFrente = new GreenfootImage[9]; 
        for(int i=0; i < animacaoFrente.length;i++)
        {
            animacaoFrente[i]=new GreenfootImage("Animacoes/" + "Player (" + numeroJogador + ")/Frente (" + (i+1) + ").png");
            rescale(animacaoFrente[i], 0.06);
        }
        
        animacaoTras = new GreenfootImage[9];
        for(int i=0; i < animacaoTras.length;i++)
        {
            animacaoTras[i]=new GreenfootImage("Animacoes/" + "Player (" + numeroJogador + ")/Tras (" + (i+1) + ").png");
            rescale(animacaoTras[i], 0.06);
        }
    }
    
    private void selectPlayer() {
        switch(numeroJogador) {
            case 1: 
                keyUp = "W"; 
                keyLeft = "A";
                keyDown = "S";
                keyRight = "D";
                keyAction = "E";
                break;
            case 2: 
                keyUp = "up"; 
                keyLeft = "left";
                keyDown = "down";
                keyRight = "right";
                keyAction = "space";
                break;
            case 3: 
                keyUp = "G"; 
                keyLeft = "V";
                keyDown = "B";
                keyRight = "N";
                keyAction = "H";
                break;
            case 4: 
                keyUp = "I"; 
                keyLeft = "J";
                keyDown = "K";
                keyRight = "L";
                keyAction = "O";
                break;
        }
    }
    
    public boolean touchingComputer()
    {
        return isTouching(Computer.class);
    }
    
    public boolean touchingFlower()
    {
        return isTouching(Flower.class);
    }
    
    public boolean touchingDoor()
    {
        return isTouching(Door.class);
    }
}
