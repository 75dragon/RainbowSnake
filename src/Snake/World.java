package Snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

public class World
{
	ArrayList<SnakeSegment> Snake;
	int xDir;
	int yDir;
	int xDim;
	int yDim;
	int foodX;
	int foodY;
	Displayer dis;
	SnakeSegment food;
	int pixWidth;
	Timer worldTime;
	Random rand;

	public World(int xDim, int yDim, int pixWidth, Displayer dis)
	{
		Snake = new ArrayList<SnakeSegment>();
		Snake.add(new SnakeSegment(0, yDim / 2, pixWidth));
		this.pixWidth = pixWidth;
		this.xDim = xDim;
		this.yDim = yDim;
		xDir = 1;
		yDir = 0;
		rand = new Random();
		this.dis = dis;
		dis.setWorld(this);
		addFood();
	}

	public boolean checkCollison(int newX, int newY)
	{
		if (newX >= xDim || newX < 0)
		{
			System.out.println("out of X bounds");
			return true;
		} else if (newY >= yDim || newY < 0)
		{
			System.out.println("out of Y bounds");
			return true;
		}
		for (int i = 0; i < Snake.size() - 1; i++)
		{
			if (newX == Snake.get(i).getX() && newY == Snake.get(i).getY())
			{
				System.out.println("Hit a snake part" + newX + " : " + newY + " = " + i);
				return true;
			}
		}
		return false;
	}

	public void gameTime()
	{
		World wow = this;
		worldTime = new Timer(200, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (checkCollison(Snake.get(0).getX() + xDir, Snake.get(0).getY() + yDir))
				{
					System.out.println("STOP HELLO");
					wow.worldTime.stop();
					return;
				}
				if (checkFood(Snake.get(0).getX() + xDir, Snake.get(0).getY() + yDir))
				{
					Snake.add(0, food);
					food = null;
					addFood();
				} else
				{
					moveSnake(Snake.get(0).getX() + xDir, Snake.get(0).getY() + yDir);
				}
				dis.repaint();
				System.out.println("One Iteration");
			}
		});
		worldTime.start();
	}

	public void moveSnake(int newX, int newY)
	{
		int holdx;
		int holdy;

		for (int i = 0; i < Snake.size(); i++)
		{
			holdx = Snake.get(i).getX();
			holdy = Snake.get(i).getY();
			Snake.get(i).setCor(newX, newY);
			newX = holdx;
			newY = holdy;
		}
	}

	public void changeDirections(int x)
	{
		System.out.println("changing directions");
		switch (x)
		{
			case 1:
				xDir = -1;
				yDir = 0;
				break;
			case 2:
				xDir = 0;
				yDir = -1;
				break;
			case 3:
				xDir = 1;
				yDir = 0;
				break;
			case 4:
				xDir = 0;
				yDir = 1;
				break;
		}
	}

	public void addFood()
	{
		foodX = rand.nextInt(xDim);
		foodY = rand.nextInt(yDim);
		while (checkCollison(foodX, foodY))
		{
			foodX = rand.nextInt(xDim);
			foodY = rand.nextInt(yDim);
			System.out.println("why");
		}
		food = new SnakeSegment(foodX, foodY, pixWidth);
	}

	public boolean checkFood(int newX, int newY)
	{
		if (newX == food.getX() && newY == food.getY())
		{
			return true;
		} else
		{
			return false;
		}
	}
}
