package Tetris;

import java.awt.Color;
import java.util.Timer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stop=false;
		Square.SetImage();
		MyMenu.initMenu();
		gp = new GamePane(10,20);
		gp.getContentPane().setBackground(Color.WHITE);
		gp.setVisible(true);
		startGame();
	}
	
	public static void startGame() {
		t = new Timer();
		t.schedule(new MyTimer(gp), 1, 1000);
	}	
	
	static GamePane gp;
	static Timer t;
	static boolean Stop;
}