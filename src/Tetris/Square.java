package Tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Square {
	public abstract boolean Down();//����
	public abstract boolean Left();//����
	public abstract boolean Right();//����
	public abstract boolean Spin();//��ת
	//��ʾ
	public void Display(Graphics g) {
		g.clearRect(GamePane.sx, GamePane.sy, GamePane.rw*GamePane.w+GamePane.sx, GamePane.rl*GamePane.w+GamePane.sy);
		g.setColor(Color.WHITE);
		g.drawRect(GamePane.sx, GamePane.sy, GamePane.rw*GamePane.w, GamePane.rl*GamePane.w);
		for(int i=1;i<GamePane.rw;i++)
			g.drawLine(GamePane.sx+GamePane.w*i, GamePane.sy, GamePane.sx+GamePane.w*i, GamePane.rl*GamePane.w+GamePane.sy);
		for(int j=1;j<GamePane.rl;j++)
			g.drawLine(GamePane.sx, GamePane.sy+GamePane.w*j, GamePane.rw*GamePane.w+GamePane.sx, GamePane.sy+GamePane.w*j);
		for(int i=0;i<GamePane.rw;i++) {
			for(int j=0;j<GamePane.rl;j++) {
				if(mp.map[i][j]!=0) {
					if(mp.map[i][j]==1) {
						g.setColor(Color.WHITE);
						g.fill3DRect(GamePane.sx+i*GamePane.w, GamePane.sy+j*GamePane.w, GamePane.w, GamePane.w,true);
					}
					else if(mp.map[i][j]==2) {
						g.setColor(Color.BLUE);
						g.fill3DRect(GamePane.sx+i*GamePane.w, GamePane.sy+j*GamePane.w, GamePane.w, GamePane.w,true);
					}
					else if(mp.map[i][j]==3) {
						g.setColor(Color.RED);
						g.fill3DRect(GamePane.sx+i*GamePane.w, GamePane.sy+j*GamePane.w, GamePane.w, GamePane.w,true);
					}
					else if(mp.map[i][j]==4) {
						g.setColor(Color.GREEN);
						g.fill3DRect(GamePane.sx+i*GamePane.w, GamePane.sy+j*GamePane.w, GamePane.w, GamePane.w,true);
					}
					else if(mp.map[i][j]==5) {
						g.setColor(Color.YELLOW);
						g.fill3DRect(GamePane.sx+i*GamePane.w, GamePane.sy+j*GamePane.w, GamePane.w, GamePane.w,true);
					}
					else if(mp.map[i][j]==6) {
						g.setColor(Color.ORANGE);
						g.fill3DRect(GamePane.sx+i*GamePane.w, GamePane.sy+j*GamePane.w, GamePane.w, GamePane.w,true);
					}
					else if(mp.map[i][j]==7) {
						g.setColor(Color.PINK);
						g.fill3DRect(GamePane.sx+i*GamePane.w, GamePane.sy+j*GamePane.w, GamePane.w, GamePane.w,true);
					}
					else {
						break;
					}
				}
			}
		}
		if(IsStop==true) {
			System.gc();
		}
	}
	
	public static void SetImage() {
		img=new Image[7];
		try {
			img[0]=ImageIO.read(new File("./bin/Tetris/I.png"));
			img[1]=ImageIO.read(new File("./bin/Tetris/J.png"));
			img[2]=ImageIO.read(new File("./bin/Tetris/L.png"));
			img[3]=ImageIO.read(new File("./bin/Tetris/O.png"));
			img[4]=ImageIO.read(new File("./bin/Tetris/S.png"));
			img[5]=ImageIO.read(new File("./bin/Tetris/T.png"));
			img[6]=ImageIO.read(new File("./bin/Tetris/Z.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DisplayImage(Graphics g){
		g.clearRect(GamePane.sx, GamePane.sy, GamePane.rw*GamePane.w+GamePane.sx, GamePane.rl*GamePane.w+GamePane.sy);
		g.setColor(Color.BLACK);
		g.drawRect(GamePane.sx, GamePane.sy, GamePane.rw*GamePane.w, GamePane.rl*GamePane.w);
		for(int i=1;i<GamePane.rw;i++)
			g.drawLine(GamePane.sx+GamePane.w*i, GamePane.sy, GamePane.sx+GamePane.w*i, GamePane.rl*GamePane.w+GamePane.sy);
		for(int j=1;j<GamePane.rl;j++)
			g.drawLine(GamePane.sx, GamePane.sy+GamePane.w*j, GamePane.rw*GamePane.w+GamePane.sx, GamePane.sy+GamePane.w*j);
		for(int i=0;i<GamePane.rw;i++) {
			for(int j=0;j<GamePane.rl;j++) {
				if(mp.map[i][j]!=0) {
					g.drawImage(img[mp.map[i][j]-1],GamePane.sx+i*GamePane.w, GamePane.sy+j*GamePane.w, GamePane.w, GamePane.w, null);
				}
			}
		}
		if(IsStop==true) {
			System.gc();
		}
	}
	
	public void ClearAll(Graphics g) {
		g.clearRect(GamePane.sx, GamePane.sy, GamePane.rw*GamePane.w+GamePane.sx, GamePane.rl*GamePane.w+GamePane.sy);
	}
	
	public boolean testStop() {
		return IsStop;
	}
	
	public int xPos;//x����
	public int yPos;//y����
	int status;//����״̬
	boolean IsStop;//�Ƿ�ֹͣ
	Maps mp;//�����������
	int color;//������ɫID
	public static Image[] img;
}
