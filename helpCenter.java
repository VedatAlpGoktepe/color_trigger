import java.awt.*;
import java.awt.event.*;

public class helpCenter extends MouseAdapter {

	static int leftx;
	static int rightx;
	static int height;
	static int retryx;
	static int retryy;
	static int timesClicked = 0;

	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = MouseInfo.getPointerInfo().getLocation();
		int x = p.x;
		int y = p.y;
		System.out.println(x + ", " + y);
		if(timesClicked == 0)
		{
			leftx = x;
			System.out.println("Now click the right side of the spin result text.");
		}
		else if(timesClicked == 1)
		{
			rightx = x;
			System.out.println("Now click a height from the spin result text. (Selecting the upper or lower parts is suggested.)");
		}
		else if(timesClicked == 2)
		{
			height = y;
			System.out.println("Now click the retry button.");
		}
		else if(timesClicked == 3)
		{
			retryx = x;
			retryy = y;
			System.out.println("All necessary location data aquired.");
		}
		timesClicked++;
	}

	public static int getLeftX()
	{
		return leftx;
	}
	public static int getRightX()
	{
		return rightx;
	}
	public static int getHeight()
	{
		return height;
	}
	public static int getRetryX()
	{
		return retryx;
	}
	public static int getRetryY()
	{
		return retryy;
	}
	public static int getTimesClicked()
	{
		return timesClicked;
	}
}