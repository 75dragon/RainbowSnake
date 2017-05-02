package Snake;

import java.awt.BorderLayout;

public class Driver
{
	public Driver(int x, int y, int pixWidth)
	{
		Frame frame = new Frame();
		Displayer dis = new Displayer(x * pixWidth, y * pixWidth);
		System.out.println("Made displayer");
		frame.add(dis, BorderLayout.CENTER);
		frame.pack();
		World world = new World(x, y, pixWidth, dis);
		System.out.println("not here?");
		Keyboard keys = new Keyboard(world);
		System.out.println("did I get here?");
		frame.addKeyListener(keys);
		world.gameTime();
	}
	
	public static void main(String args[])
	{
		new Driver(10, 10, 50);
	}
}
