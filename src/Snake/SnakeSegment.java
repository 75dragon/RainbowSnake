package Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class SnakeSegment
{
	int x;
	int y; 
	int pixWidth;
	Random rand;
	Color color;
	
	public SnakeSegment(int x, int y, int pixWidth)
	{
		this.x = x;
		this.y = y;
		this.pixWidth = pixWidth;
		rand = new Random();
		color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}
	
	void setCor( int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	int getX()
	{
		return x;
	}
	
	int getY()
	{
		return y;
	}
	
	void drawMe(Graphics g)
	{
		g.setColor(color);
		g.fillRect(x * pixWidth, y * pixWidth, pixWidth, pixWidth);
		System.out.println(x + " : " + y);
	}
}
