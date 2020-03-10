package Tetris;

import javax.swing.JTextArea;

public class Score {
	int score;
	int line;
	public Score() {
		score=0;//得分
		line=0;//消除的行数
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
		lblScore.setText("当前的得分是:"+score+"\n当前消除的行数是:"+line);
		return this;
	}
}
