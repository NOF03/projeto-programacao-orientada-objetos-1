import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Game2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game2 extends TheGame
{
    private int time;
    public String printClock;
    private final int TEXT_SIZE=45;
    private int counter;
    public Text clock;
    private Text helpText;
    public Computer[] computers;
    private static String[] plant = {"P", "L", "A", "N", "T"};
    private static int hasKey;
    private Text key;
    public boolean a;
    public boolean b;

    public Game2(Players[] allPlayer, int numberPlayers, boolean playedFirst, int numVidas)
    { 
        super(allPlayer, numberPlayers, playedFirst, false, numVidas);
        addObject(new BookCase1(),(int)(getWidth()*0.6f), (int)(getHeight()*0.4f));
        addObject(new Wall(), getWidth()/2, (int)(getHeight()*0.12f));
        
        a = true;
        b = true;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 2; j++){
                addObject(new BookWall(),(3+i*2)*getWidth()/12,(j*getHeight()/7)+getHeight()/5);
            }
        }
        addObject(new DoorClosed(), (int)(getWidth()*0.2f), (int)(getHeight()*0.93f));
        
        addObject(new Codigo(), getWidth()*9/10, (int)(getHeight()*0.55f));
        addObject(new BookCase1(), 3*getWidth()/12, (int)(getHeight()*0.49f));
        addObject(new BookWall(), (int)(getWidth()*0.22f), (int)(getHeight()*0.488f));
        addObject(new BookCase2(), (int)(getWidth()*0.19f),(int)(getHeight()*0.60f));
        addObject(new BookCase2(), (int)(getWidth()*0.418f), (int)(getHeight()*0.49f));
        addObject(new BookWall(), 7*getWidth()/12, (int)(getHeight()*0.49f));
        addObject(new BookCase2(), 7*getWidth()/12,(int)(getHeight()*0.64f));
        addObject(new BookCase2(), (int)(getWidth()*0.383f), (int)(getHeight()*0.89f));
        addObject(new BookWall(), (int)(getWidth()*0.35f), (int)(getHeight()*0.93f));
        addObject(new Chair1(),(int)(getWidth()*0.95f),(int)(getHeight()*0.85f));
        addObject(new Chair3(), (int)(getWidth()*0.88f),(int)(getHeight()*0.95f));
        addObject(new Chair3(), (int)(getWidth()*0.82f),(int)(getHeight()*0.95f));
        addObject(new Chair1(1),(int)(getWidth()*0.75f),(int)(getHeight()*0.85f));
        addObject(new Mat(),(int)(getWidth()*0.85f),(int)(getHeight()*0.85f));
        addObject(new Table1(),(int)(getWidth()*0.85f),(int)(getHeight()*0.85f));
        addObject(new Painting1(),(int)(getWidth()*0.9f), (int)(getHeight()*0.10f));
        addObject(new Painting2(),(int)(getWidth()*0.66f), (int)(getHeight()*0.10f));
        addObject(new Painting3(),(int)(getWidth()*0.329f), (int)(getHeight()*0.10f));
        addObject(new BookCase2(),(int)(getWidth()*0.045f), (int)(getHeight()*0.4f));
        addObject(new BookCase2(),(int)(getWidth()*0.719f), (int)(getHeight()*0.49f));
        addObject(new Statue(),(int)(getWidth()*0.05f), (int)(getHeight()*0.7f));
        
        addObject(new BookWall(),(int)(getWidth()*0.65f), (int)(getHeight()*0.94f));
        addObject(new BookCase2(),(int)(getWidth()*0.045f), (int)(getHeight()*0.19f));
        addObject(new Mat(),(int)(getWidth()*0.52f),(int)(getHeight()*0.90f));
        addObject(new Chair3(),(int)(getWidth()*0.52f),(int)(getHeight()*0.95f));
        addObject(new Table1(),(int)(getWidth()*0.29f), (int)(getHeight()*0.88f));
        addObject(new Chair3(), (int)(getWidth()*0.29f), (int)(getHeight()*0.95f));
        addObject(new Table1(),(int)(getWidth()*0.95f), (int)(getHeight()*0.3f));
        
        
        
        computers = new Computer[5];
        for (int i = 0; i < 5; i++) {
            computers[i] = new Computer(plant[i]);
            addObject(new Mat(i),getWidth()*(i+1)/6,(int)(getHeight()*0.3f));
            addObject(new Table(),getWidth()*(i+1)/6,getHeight()/4);
            addObject(computers[i],getWidth()*(i+1)/6,getHeight()/5);
            
        }

        addObject(new Flower(), (int)(getWidth()*0.835f),(int)(getHeight()*0.82f));
        for (int i = 0; i < numberPlayers; i++) {
            addObject(allPlayer[i], getWidth()/10+(i*40), getHeight()*8/9);
        }
        spawnBullet();
        
      counter = 0;
      time = 90;
      printClock = "1:30";
      prepare();    
      hasKey = 0;  
    }

    public void act(){
        updateClock();
        geral();
        vidas();
    }

    private void prepare(){
        clock = new Text(printClock,TEXT_SIZE, new Color(255,255,255));
        addObject(clock, getWidth()/2,125);
        helpText = new Text("Dica:Os computadores estão ordenados da esquerda para a direita", 25,new Color(255,255,255) );
        addObject(helpText, getWidth()/2,(int)(getHeight()*0.01));
        Text keyImage = new Text();
        keyImage.setImage("key.png");
        new Objects().rescale(keyImage.getImage(), 0.02);
        addObject(keyImage, getWidth()/2 - 20, 90);
        key = new Text(""+hasKey,TEXT_SIZE, new Color(0,0,0));
        addObject(key,getWidth()/2 +20, 90);
        
        
       
    }

    public void spawnBullet(){
        Bullet firstBullet = new Bullet();
        firstBullet.initialWidth = getWidth();
        firstBullet.initialHeight = (int)(getHeight()*0.75f);
        Bullet secondBullet = new Bullet();
        secondBullet.initialWidth = getWidth();
        secondBullet.initialHeight = (int)(getHeight()*0.75f);
        addObject(firstBullet, firstBullet.initialWidth, firstBullet.initialHeight);
        addObject(secondBullet, secondBullet.initialWidth/2, secondBullet.initialHeight);
        
    }
    
    public void geral(){
        key.updateText(""+hasKey,key,TEXT_SIZE, key.getCor());
    }
    
    public void incrementHasKey(){
        hasKey++;
    }
    
    private void updateClock()
    {
        if(a){    
            counter++;        
            if(counter%61==0)
            {
                time--;
                if(time%60<10)
                {
                    printClock = "" + time/60 + ":0" + time%60;
                }
                else
                {
                    printClock = "" + time/60 + ":" + time%60;
                }
            }
            if (time <=10 && counter%61<30)
            {
                clock.updateText(printClock,clock,TEXT_SIZE, Color.RED);
            }
            else
            {
                clock.updateText(printClock,clock,TEXT_SIZE, Color.WHITE);
            }
            if(time==0)
            {
                Greenfoot.setWorld(new JumpScare());
            }
        }
    }
}
