import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{

    private int y = 1100;
    private int part = 1;
    
    Pengu pinguin = new Pengu();
    Hunter hunter = new Hunter();
    
    public Level1()
    {    
        super(1488, 837, 1);    // define size and resolution
        addHugeCliff(false, 75, y);
        addHugeCliff(false, 1200, y);
        
        addCloud(460, 830, 4, y-300);
        
        addHunter(1000, 690);
        
        addObject (pinguin, 85, 670 );
        pinguin.startLeben();
        
        setBackground(new GreenfootImage("images/bg.png"));
    }
    
    //All Map parts to add
    public void addCliff(Boolean flip, int x, int y){
        addObject ( new Cliff(flip), x, y);
    }
    
    public void addHugeCliff(Boolean flip, int x, int y){
        addObject ( new HugeCliff(flip), x, y);
    }
    
    public void addCloud(int minX, int maxX, int speed, int y){
        addObject ( new Cloud(minX, maxX, speed), minX, y);
    }
    
    public void addPengu(int x, int y){
        addObject ( new Pengu(), x, y);
    }
    
    public void addEnemy(int x, int y){
        addObject ( new Enemy(), x, y);
    }
    
    public void addHunter(int x, int y){
        addObject ( new Hunter(), x, y);
    }
    
    //When Pengu is on the right the method is executed
    public void goRight(Pengu pengu)
    {
        //Unload all Objects

        pinguin.setLocation(66,640);
        removeObjects(getObjects(Cliff.class));
        removeObjects(getObjects(HugeCliff.class));
        removeObjects(getObjects(Cloud.class));
        removeObjects(getObjects(Enemy.class));
        //Load next world
        loadNextWorld();
        part++;
    }
    //Load next part
    public void loadNextWorld(){
        //Each Case is a new part of map        
        switch (part) {
            case 1:
                addCliff(false, 40, y-100);
                addCliff(false, 240, y-200);
                addCliff(false, 440, y-300);
                addCliff(false, 640, y-400);
                addCliff(false, 840, y-500);
                addCliff(false, 1040, y-600);
                addCliff(false, 1240, y-700);
                addCliff(false, 1440, y-800);
                break;
            case 2:
                addCliff(false, 50, y);
                addCliff(false, 210, y-400);
                addCloud(740, 1060, 4, y-300);
                addCloud(440, 740, 4, y-500);
                addHugeCliff(false, 1465, y);
                break;
            case 3:
                addCliff(false, 40, y);
                addCloud(90, 260, 4, y-400);
                addCloud(240, 360, 2, y-600);
                addCloud(400, 560, 4, y-400);
                addCloud(600, 860, 4, y-500);
                addCloud(900, 1160, 4, y-600);
                addCloud(1200, 1460, 4, y-700);
                break;
            default:
                addCliff(false, 85, y);
                System.out.println("Welt Abgeschlossen");
                //Greenfoot.setWorld(new Weltenauswahl());
                //Go back to world selection
        }
        //addPengu(60, y-400);//addObject ( new Pengu(), 60, y-400 );
    }
    
    public void snowball(int sSpeed, int range, int yPos, int xPos)
    {
        addObject ( new Snowball(sSpeed), xPos, yPos);
    }
    
    public void bullet(int xPos, int yPos)
    {
        addObject ( new Bullet(14), xPos, yPos);
    }
}
