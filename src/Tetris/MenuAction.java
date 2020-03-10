package Tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JMenuItem;

public class MenuAction {
	public MenuAction setMenuRestart(JMenuItem j) {
		j.addActionListener(new MenuRestart());
		return this;
	}
	public MenuAction setMenuColor(JMenuItem j) {
		j.addActionListener(new MenuColor());
		return this;
	}
}

//"重新开始"事件监听
class MenuRestart implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			Main.gp.newGame();
	}
}

// "颜色"事件监听
class MenuColor implements ActionListener {
	MouseListener ml;
	MouseMotionListener mml;
	public int xPrevPos=-1;
	public int yPrevPos=-1;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Main.gp.addMouseMotionListener(new MouseMotionListener() {
			public final Graphics g = Main.gp.getGraphics();
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				mml=this;
				if(xPrevPos==-1&&yPrevPos==-1) {
					Main.Stop=true;
				}
				else if(xPrevPos>=0&&yPrevPos>=0) {
					g.clearRect(GamePane.sy+(GamePane.rw-1)*GamePane.w, GamePane.sy+yPrevPos*GamePane.w, GamePane.w, GamePane.w);
				}
				int xPos=(int)(e.getX()-GamePane.sx)/GamePane.w;
				int yPos=(int)(e.getY()-GamePane.sy)/GamePane.w;
				xPrevPos=xPos;
				yPrevPos=yPos;
				if(xPos>=0&&xPos<GamePane.rw&&yPos>=0&&yPos<GamePane.rl) {
					g.setColor(Color.LIGHT_GRAY);
					g.fillOval(GamePane.sy+(GamePane.rw-1)*GamePane.w, GamePane.sy+yPos*GamePane.w, GamePane.w, GamePane.w);
				}
			}
		});
		Main.gp.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				Main.gp.mp.clearLine(yPrevPos);
				xPrevPos=-1;
				yPrevPos=-1;
				Main.Stop=false;
				Main.gp.sq.IsStop=false;
				Main.gp.removeMouseMotionListener(mml);
				Main.gp.removeMouseListener(this);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}		
		});
	}
}