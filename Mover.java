import greenfoot.*;

/**
 * The class Mover provides some basic movement methods. Use this as a superclass
 * for other actors that should be able to move left and right, jump up and fall 
 * down.
 */
public class Mover extends Actor
{
    private int acceleration = 2;      // down (gravity)
    private int speed = 7;             // running speed (sideways)
    
    private int vSpeed = 0;                         // current vertical speed
    

    public void moveRight()
    {
        setLocation ( getX() + speed, getY() );
    }
        
    public void moveLeft()
    {
        setLocation ( getX() - speed, getY() );
    }
    
    public boolean onGround()
    {
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2-8 , null);
        return under != null;
    }

    public void setVSpeed(int speed)
    {
        vSpeed = speed;
    }
    
    public void fall()
    {
        setLocation ( getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
        if ( atBottom() )
            //removeObject(pengu);
            //addPengu(66, 1100-340);
            gameEnd();
    }
    
    private boolean atBottom()
    {
        return getY() >= getWorld().getHeight() - 2;
    }
    
    private void gameEnd()
    {
        Greenfoot.setWorld(new TodMenue());
    }
    
    public int getVSpeed()
    {
        return vSpeed;
    }
    
    public int getSpeed()
    {
        return speed;
    }
}
