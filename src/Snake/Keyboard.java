package Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener
{
	World world;
	public Keyboard( World world )
	{
		this.world = world;
	}
	@Override
	public void keyPressed(KeyEvent arg0)
	{
		System.out.println("HITTING");
		switch ( arg0.getKeyCode() )
        {
            case KeyEvent.VK_LEFT:
                world.changeDirections(1);
                break;
            case KeyEvent.VK_UP:
                world.changeDirections(2);
                break;
            case KeyEvent.VK_RIGHT:
                world.changeDirections(3);
                break;
            case KeyEvent.VK_DOWN:
                world.changeDirections(4);
                break;
        }
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

}
