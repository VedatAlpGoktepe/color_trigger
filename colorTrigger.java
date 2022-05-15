import javax.swing.JFrame;
import java.util.Scanner;
import java.lang.Thread;
import java.awt.event.InputEvent;
import java.awt.Color;

public class colorTrigger
{
	public static JFrame exit = new JFrame("Close To End Code");
	
	public static void main(String[] args)
	{
		computerControl click = new computerControl();
		Color mythic = new Color(-9826899);
		Color legendary = new Color(-65536);
		boolean magicFound = false;

		int leftX;
		int rightX;
		int height;
		int retryX;
		int retryY;
		int clickTimes;
		int delay;
		Scanner in = new Scanner(System.in);
        JFrame frame = new JFrame("Position Setter");
        frame.getContentPane().addMouseListener(new helpCenter());
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setOpacity((float) 0.8);
        frame.setVisible(true);
        
        exit.setSize(300, 100);
        exit.setAlwaysOnTop(true);
        exit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exit.setVisible(true);

        System.out.println("===HOW TO USE===");
        System.out.println("1. Align the spin area ingame with the window titled 'Position Setter'.");
        System.out.println("2. Click on the requested locations on your screen in 'Position Setter'.");
        System.out.println("3. Close the window titled 'Close To End Code' when you want to end the code.");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Click the left side of the spin result text.");

        while(true)
        {
        	try
        	{
        		Thread.sleep(10);
        	} catch(Exception e){}

        	clickTimes = helpCenter.getTimesClicked();
        	while(clickTimes >= 4)
        	{
        		leftX = helpCenter.getLeftX();
        		rightX = helpCenter.getRightX();
        		height = helpCenter.getHeight();
        		retryX = helpCenter.getRetryX();
        		retryY = helpCenter.getRetryY();
        		frame.dispose();

				System.out.print("Enter the delay time: ");
				delay = in.nextInt();
				click.setDelay(delay);

				System.out.println("Program will start in 3 seconds");

				try
				{
					Thread.sleep(3000);
				} catch(Exception e){}

				while(magicFound == false)
		        {
    		        for(int x = leftX; x < rightX; x = x+2)
    		        {
    		            Color current = click.getColor(x, height);
        		        if(current.equals(legendary) || current.equals(mythic))
        		        {
        		            magicFound = true;
        		            break;
        		        }
           			}
            
        		    if(magicFound == false)
        		    {
        		    	click.moveMouse(retryX+1, retryY+1);
        		        click.moveMouse(retryX, retryY);
        		        click.clickMouse(InputEvent.BUTTON1_MASK);
        		    }
        		}

				if(true)
				{
					break;
				}
        	}
        	if(clickTimes >= 4)
        	{
        		break;
        	}
        }
        System.out.println("Magic acquired. Ending program...");
        exit.dispose();
	}
}