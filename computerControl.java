import java.awt.*;
import java.awt.Color;

public class computerControl
{
    private Robot robot;
    private int delay;
    
    public computerControl() {
        try {
            robot = new Robot();
        }
        catch(Exception e){}
        delay = 5000;
    }
    
    public void moveMouse(int x, int y)
    {
        robot.mouseMove(x, y);
    }
    
    public void clickMouse(int button)
    {
        try
        {
            robot.mousePress(button);
            robot.delay(250);
            robot.mouseRelease(button);
            robot.delay(delay);
        }
        catch(Exception e){}
    }
    
    public void setDelay(int ms)
    {
        delay = ms;
    }
    
    public int getX()
    {
        Point p = MouseInfo.getPointerInfo().getLocation();
        int x = p.x;
        return x;
    }
    
    public int getY()
    {
        Point p = MouseInfo.getPointerInfo().getLocation();
        int y = p.y;
        return y;
    }
    
    public Color getColor()
    {
        
        Point p = MouseInfo.getPointerInfo().getLocation();
        int x = p.x;
        int y = p.y;
        return robot.getPixelColor(x, y);
    }
    
    public Color getColor(int x, int y)
    {
        return robot.getPixelColor(x, y);
    }
}