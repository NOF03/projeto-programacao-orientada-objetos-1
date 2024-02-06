import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Game1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game1 extends TheGame
{
    private Generator[] worldGenerators;
    private boolean done;
    private final int TEXT_SIZE=25;
    private Text helpText = new Text("Dica:Sintonia é necessária",TEXT_SIZE,new Color(255,255,255));
    /**
     * Constructor for objects of class Game1.
     * 
     */
    public Game1(Players[] allPlayer, int numberPlayers, boolean playedSecond, int numVidas)
    {
        super(allPlayer, numberPlayers, false, playedSecond, numVidas);
        done = false;addObject(new BookCase2(),(int)(getWidth()*0.25f), (int)(getHeight()*0.78f));
        addObject(new BookCase2(),(int)(getWidth()*0.161f), (int)(getHeight()*0.78f));
        addObject(new DoorClosed(), (int)(getWidth()*0.2f), (int)(getHeight()*0.93f));
        worldGenerators = new Generator[numberPlayers];
        addObject(new Wall(),(int)(getWidth()*0.5f), (int)(getHeight()*0.11f));
        addObject(new Fireplace(),(int)(getWidth()*0.504f), (int)(getHeight()*0.2f));
        addObject(new Mat(),(int)(getWidth()*0.5f), (int)(getHeight()*0.385f));
        addObject(new Table1(),(int)(getWidth()*0.5f), (int)(getHeight()*0.38f));
        addObject(new Chair3(),(int)(getWidth()*0.5f), (int)(getHeight()*0.49f));
        addObject(new Chair1(),(int)(getWidth()*0.6f), (int)(getHeight()*0.38f));
        addObject(new Chair1(1),(int)(getWidth()*0.4f), (int)(getHeight()*0.38f));
        addObject(new BookWall(),(int)(getWidth()*0.3f), (int)(getHeight()*0.78f));
        addObject(new BookWall(),(int)(getWidth()*0.3f), (int)(getHeight()*0.93f));
        addObject(new BookCase2(),(int)(getWidth()*0.044f), (int)(getHeight()*0.4f));
        addObject(new Statue(),(int)(getWidth()*0.3f), (int)(getHeight()*0.15f));
        addObject(new Painting2(),(int)(getWidth()*0.15f), (int)(getHeight()*0.09f));
        addObject(new Painting3(),(int)(getWidth()*0.38f), (int)(getHeight()*0.09f));
        addObject(new Painting1(),(int)(getWidth()*0.85f), (int)(getHeight()*0.09f));
        addObject(new Mat(),(int)(getWidth()*0.5f), (int)(getHeight()*0.87f));
        addObject(new Piano(),(int)(getWidth()*0.5f), (int)(getHeight()*0.7f));
        addObject(new Table1(),(int)(getWidth()*0.5f), (int)(getHeight()*0.84f));
        addObject(new Decoration1(),(int)(getWidth()*0.4f), (int)(getHeight()*0.7f));
        addObject(new BookCase2(),(int)(getWidth()*0.63f), (int)(getHeight()*0.2f));
        addObject(new Statue(),(int)(getWidth()*0.75f), (int)(getHeight()*0.15f));
        addObject(new Chair2(),(int)(getWidth()*0.85f), (int)(getHeight()*0.23f));
        addObject(new Chair3(),(int)(getWidth()*0.85f), (int)(getHeight()*0.95f));
        addObject(new DoorClosed(), (int)(getWidth()*0.2f), (int)(getHeight()*0.93f));
        worldGenerators = new Generator[numberPlayers];
        for (int i = 0; i < numberPlayers; i++) {
            worldGenerators[i] = new Generator();
            addObject(worldGenerators[i], (int)(getWidth()*0.95), getHeight()*(i+1)/(numberPlayers+1));
        }
        
        for (int i = 0; i < numberPlayers; i++) {
            addObject(allPlayer[i], getWidth()/10+(i*40), getHeight()*8/9);
        }
        addObject(new Skeleton(), (int)(getWidth()*0.28f), (int)(getHeight()*0.6));
        addObject(new Skeleton(), (int)(getWidth()*0.28f), (int)(getHeight()*0.4));
        addObject(new Skeleton(),(int)(getWidth()*0.4f), (int)(getHeight()*0.55f));
        addObject(new Skeleton(),(int)(getWidth()*0.4f), (int)(getHeight()*0.9f));
        addObject(new Skeleton(),(int)(getWidth()*0.6f), (int)(getHeight()*0.5f));
        addObject(new Skeleton(),(int)(getWidth()*0.6f), (int)(getHeight()*0.9f));
        addObject(new Skeleton(),(int)(getWidth()*0.75f), (int)(getHeight()*0.4f));
        addObject(new Skeleton(),(int)(getWidth()*0.75f), (int)(getHeight()*0.8f));
        
        addObject(helpText,(int)(getWidth()*0.55f), (int)(getHeight()*0.05f));
        
    }
    
    public void act() {
        verifyExit();
        vidas();
        
    }
    
    public void verifyExit() {
        for (Generator oneGen : worldGenerators) {
            if (!oneGen.verifyTouchingPlayer()) return;
            if (!oneGen.verifyActionButtonDown()) return;
        }
        if (!done)
            openDoor();
        done = true;
    }
    
}