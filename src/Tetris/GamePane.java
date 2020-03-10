package Tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class GamePane extends JFrame {
	public static final int w=40;//���嵥Ԫ��߳�
	public static int rw,rl;//��������С
	public static final int sx = 50;//�����ʼ���
	public static final int sy = 100;//������ʼ�߶�
	public Maps mp;
	public Square sq;
	public int nextSquare;//��һ������ı��
	public KeyListener mks;
	public static int seet=7;//����ĸ���,���ڿ�����������ɵķ�Χ,��ǰ1~7
	public JTextArea lblScore;//������ʾ�ı�ǩ
	public Score sc;//������
	public static final int colorCount=7;//������ɫ����
	
	public GamePane(int wSize,int lSize) {
		MyMenu.setMenu(this);
		rw=wSize;
		rl=lSize;
		this.setTitle("����˹����");
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
		lblScore=new JTextArea("��ǰ������:\n��ǰ������������:");
		lblScore.setBounds(rw*w+sx+50, rl*w/5, 200, 50);
		lblScore.setFont(new Font("�����п�",1,20));
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
	
	// ���鹤��,����ָ������Ķ���
	// ����:index ���ɵĶ���
	// 1 ������"Elongated"����
	// 2 ������"Quadrate"����
	// 3 ��Z��
	// 4 ��Z��
	// 5 ������
	// 6��L��
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

	// ������ɷ�����
	public int squareRadom() {
		nextSquare=(int)(new Random().nextInt(seet))+1;
		return nextSquare;
	}
	//�õ�������
	public int getNextSquare() {
		return this.nextSquare;
	}
	//������Ϸ
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
