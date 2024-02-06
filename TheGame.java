import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TheGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheGame extends MyWorlds
{
    private boolean playedFirst, playedSecond;
    private static int numVidas;
    private final int TEXT_SIZE=45;
    private Text vida;
    
    public TheGame(Players[] allPlayer, int numberPlayers, boolean playedFirst, boolean playedSecond, int numVidas)
    {
        this.allPlayer = allPlayer;
        this.numberPlayers = numberPlayers;
        this.playedFirst = playedFirst;
        this.playedSecond = playedSecond;
        this.numVidas = numVidas;
        prepareLifes();
        setPaintOrder(Text.class, Objects.class);
        
    }
    
    public void togglePlayedStatusFirst() {
        playedFirst = !playedFirst;
    }
    
    public void togglePlayedStatusSecond() {
        playedSecond = !playedSecond;
    }
    
    public boolean getPlayedFirst() {
        return playedFirst;
    }
    
    public boolean getPlayedSecond() {
        return playedSecond;
    }
    
    public Players[] getPlayers() {
        return allPlayer;
    }
    
    public int getNumberPlayers() {
        return numberPlayers;
    }
    
    public int getNumVidas() {
        return numVidas;
    }
    
    public void hurtSound(){
        GreenfootSound hurtSound = new GreenfootSound("au.wav");
        hurtSound.setVolume(30);
        hurtSound.play();
    }
    
    public void decreaseNumVidas() {
        numVidas--;
        hurtSound();
    }
    
    public void openDoor() {
        DoorClosed oneDoor = getObjects(DoorClosed.class).get(0);
        addObject(new Door(0), oneDoor.getX(), oneDoor.getY());
        removeObject(oneDoor);
        
    }
    
    private void prepareLifes(){
        
        Text vidaImage = new Text();
        vidaImage.setImage("heart.png");
        new Objects().rescale(vidaImage.getImage(), 0.02);
        addObject(vidaImage, (int)(getWidth()*0.08f),(int)(getHeight()*0.08f));
        vida = new Text(""+numVidas,TEXT_SIZE, new Color(255,255,255));
        addObject(vida,(int)(getWidth()*0.1f),(int)(getHeight()*0.08f));
    }
    
    protected void vidas(){
        geralVidas();
        if (numVidas == 0) {
            Greenfoot.setWorld(new JumpScare());
        }
    }
    
    public void geralVidas(){
        vida.updateText(""+numVidas,vida,TEXT_SIZE, vida.getCor());
    }
    
    public void incrementHasVida(){
        numVidas++;
    }
    
}
