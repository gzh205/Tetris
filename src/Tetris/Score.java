package Tetris;

import javax.swing.JTextArea;

public class Score {
	int score;
	int line;
	public Score() {
		score=0;//�÷�
		line=0;//����������
	}
	public Score addScore() {
		score++;
		return this;
	}
	public Score addLine() {
		line++;
		return this;
	}
	public Score Display(JTextArea lblScore) {
		lblScore.setText("��ǰ�ĵ÷���:"+score+"\n��ǰ������������:"+line);
		return this;
	}
}
