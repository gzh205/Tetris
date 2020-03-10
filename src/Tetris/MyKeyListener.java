package Tetris;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener{

	public MyKeyListener(Square square,Graphics g) {
		sq=square;
		this.g=g;
	}
	
	public static void changeSquare(Square square) {
		sq=square;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (sq.IsStop == false) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT: {
				sq.Left();
				break;
			}
			case KeyEvent.VK_RIGHT: {
				sq.Right();
				break;
			}
			case KeyEvent.VK_UP: {
				sq.Spin();
				break;
			}
			case KeyEvent.VK_DOWN: {
				sq.Down();
				break;
			}
			}
		}
		sq.DisplayImage(g);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static Square sq;
	Graphics g;
}
