package Tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class GamePane extends JFrame {
	public static final int w=40;//定义单元格边长
	public static int rw,rl;//定义界面大小
	public static final int sx = 50;//左边起始宽度
	public static final int sy = 100;//上面起始高度
	public Maps mp;
	public Square sq;
	public int nextSquare;//下一个方块的编号
	public KeyListener mks;
	public static int seet=7;//方块的个数,用于控制随机数生成的范围,当前1~7
	public JTextArea lblScore;//分数显示的标签
	public Score sc;//分数类
	public static final int colorCount=7;//方块颜色种类
	
	public GamePane(int wSize,int lSize) {
		MyMenu.setMenu(this);
		rw=wSize;
		rl=lSize;
		this.setTitle("俄罗斯方块");
		setBounds(500, 100, rw*w+sx+300, rl*w+sy+50);
		setVisible(true);
		getContentPane().setLayout(null);   
		setResizable(false);
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
		}
		lblScore=new JTextArea("当前分数是:\n当前消除的行数是:");
		lblScore.setBounds(rw*w+sx+50, rl*w/5, 200, 50);
		lblScore.setFont(new Font("华文行楷",1,20));
		lblScore.setForeground(Color.BLACK);
		lblScore.setBackground(this.getBackground());
		this.add(lblScore);
		lblScore.setVisible(true);
		mp = new Maps(rw,rl);
		squareRadom();
		squareFactory(this.nextSquare);
		sq.Display(this.getGraphics());
		this.mks = new MyKeyListener(sq,this.getGraphics());
		this.addKeyListener(this.mks);
		sc=new Score().Display(lblScore);
		sq.DisplayImage(this.getGraphics());
	}
	
	// 方块工厂,生成指定方块的对象
	// 参数:index 生成的对象
	// 1 长条形"Elongated"对象
	// 2 正方形"Quadrate"对象
	// 3 左Z形
	// 4 右Z形
	// 5 三角形
	// 6左L形
	public void squareFactory(int index) {
		int tmp=(int)(new Random().nextInt(colorCount))+1;
		if (index == 1) {
			sq = new Elongated(mp,tmp);
		} else if (index == 2) {
			sq = new Quadrate(mp,tmp);
		} else if (index == 3) {
			sq = new LeftZ(mp,tmp);
		} else if (index == 4) {
			sq = new RightZ(mp,tmp);
		} else if (index == 5) {
			sq = new Triangle(mp,tmp);
		} else if (index == 6) {
			sq = new LeftL(mp,tmp);
		} else if (index == 7) {
			sq = new RightL(mp,tmp);
		} else {
			sq = null;
		}
	}

	// 随机生成方块编号
	public int squareRadom() {
		nextSquare=(int)(new Random().nextInt(seet))+1;
		return nextSquare;
	}
	//得到方块编号
	public int getNextSquare() {
		return this.nextSquare;
	}
	//重新游戏
	public void newGame() {
		Main.t.cancel();
		this.mp = null;
		this.removeKeyListener(this.mks);
		this.mp = new Maps(rw,rl);
		squareFactory(squareRadom());
		sq.Display(this.getGraphics());
		mks = new MyKeyListener(sq, this.getGraphics());
		this.addKeyListener(mks);
		Main.startGame();
	}
	
}
