package Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Displayer extends JPanel
{
	World world;

	public Displayer(int x, int y)
	{
		this.setPreferredSize(new Dimension(x, y));
		this.setVisible(true);
	}

	public void setWorld(World world)
	{
		this.world = world;
	}

	public void paint(Graphics g)
	{
		System.out.println("tried to paint");
		g.setColor(Color.WHITE);
		g.fillRect(0,0,this.getWidth(), this.getHeight());
		for (int i = 0; i < world.Snake.size(); i++)
		{
			world.Snake.get(i).drawMe(g);
		}
		if (world.food != null)
		{
			world.food.drawMe(g);
		}
	}

}
