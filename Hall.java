import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hall extends TheGame
{
    private static String[] plant = {"P", "L", "A", "N", "T"};
    
    public Hall(int numberPlayers)
    {    
        super(null, numberPlayers, false, false, numberPlayers*2);
        
        addObject(new Wall(), getWidth()/2, (int)(getHeight()*0.12f));
        addObject(new Carpet(), getWidth()/2, 3*getHeight()/5);
        addObject(new Mat(), getWidth()/5, (int)(getHeight()*0.945f)/3);
        addObject(new Mat(), 4*getWidth()/5, (int)(getHeight()*0.945f)/3);
        addObject(new Mat(), getWidth()/2, (int)(getHeight()*0.93f));
        addObject(new Door(1), getWidth()/5, (int)(getHeight()*1.04f)/6);
        addObject(new Door(2), 4*getWidth()/5, (int)(getHeight()*1.04f)/6);
        addObject(new Piano(),(int)(getWidth()*0.5f),(int)(getHeight()*0.2f));
        addObject(new Painting1(),(int)(getWidth()*0.35f),(int)(getHeight()*0.1f));
        addObject(new BookCase1(),(int)(getWidth()*0.67f), (int)(getHeight()*0.2f));
        addObject(new Statue(),(int)(getWidth()*0.95f), (int)(getHeight()*0.2f));
        addObject(new Table1(),(int)(getWidth()*0.5f),(int)(getHeight()*0.3f));
        addObject(new Decoration1(),(int)(getWidth()*0.1f),(int)(getHeight()*0.9f));
        addObject(new Decoration2(),(int)(getWidth()*0.9f),(int)(getHeight()*0.9f));
        addObject(new Table2(),(int)(getWidth()*0.7f),(int)(getHeight()*0.9f));
        addObject(new Table2(),(int)(getWidth()*0.3f),(int)(getHeight()*0.9f));
        addObject(new BookCase1(),(int)(getWidth()*0.08f), (int)(getHeight()*0.2f));
        
        createPlayers();
    }
    
    public Hall(Players[] allPlayer, int numberPlayers, boolean playedFirst, boolean playedSecond, int numVidas)
    {    
        super(allPlayer, numberPlayers, playedFirst, playedSecond, numVidas);
        
        addObject(new Wall(), getWidth()/2, (int)(getHeight()*0.12f));
        addObject(new Carpet(), getWidth()/2, 3*getHeight()/5);
        addObject(new Mat(), getWidth()/5, (int)(getHeight()*0.945f)/3);
        addObject(new Mat(), 4*getWidth()/5, (int)(getHeight()*0.945f)/3);
        addObject(new Mat(), getWidth()/2, (int)(getHeight()*0.93f));
        addObject(new Piano(),(int)(getWidth()*0.5f),(int)(getHeight()*0.2f));
        addObject(new Painting1(),(int)(getWidth()*0.35f),(int)(getHeight()*0.1f));
        addObject(new BookCase1(),(int)(getWidth()*0.67f), (int)(getHeight()*0.2f));
        addObject(new Statue(),(int)(getWidth()*0.95f), (int)(getHeight()*0.2f));
        addObject(new Table1(),(int)(getWidth()*0.5f),(int)(getHeight()*0.3f));
        addObject(new Decoration1(),(int)(getWidth()*0.1f),(int)(getHeight()*0.9f));
        addObject(new Decoration2(),(int)(getWidth()*0.9f),(int)(getHeight()*0.9f));
        addObject(new Table2(),(int)(getWidth()*0.7f),(int)(getHeight()*0.9f));
        addObject(new Table2(),(int)(getWidth()*0.3f),(int)(getHeight()*0.9f));
        addObject(new BookCase1(),(int)(getWidth()*0.08f), (int)(getHeight()*0.2f));
        
        createDoors();
        createPlayers();
    }
    
    public void act() {
        vidas();
    }
    
    private void createPlayers() {
        allPlayer = new Players[numberPlayers];
        
        for (int i = 0; i < numberPlayers; i++) {
            allPlayer[i] = new Players(i+1);
            addObject(allPlayer[i], getWidth()/(2+i), getHeight()/2);
        }
        
        
    }
    
    private void createDoors() {
        if (getPlayedFirst()) 
            addObject(new DoorClosed(), getWidth()/5, (int)(getHeight()*1.04f)/6);
            
        else
            addObject(new Door(1), getWidth()/5, (int)(getHeight()*1.04f)/6);
        if (getPlayedSecond()) 
            addObject(new DoorClosed(), 4*getWidth()/5, (int)(getHeight()*1.04f)/6);
        else
            addObject(new Door(2), 4*getWidth()/5, (int)(getHeight()*1.04f)/6);
        if (getPlayedFirst() && getPlayedSecond()) {
            addObject(new VictoryDoor(), getWidth(), getHeight()/2);
        }
    }
}
