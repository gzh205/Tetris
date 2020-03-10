package Tetris;

public class Maps {
	public int[][] map;//0无方块
	public int width,height;//矩阵的宽度与高度
	public int line;
	public Maps(int wid,int len){
		this.width=wid;
		this.height=len;
		line=0;
		map = new int[wid][len];
		for(int i=0;i<wid;i++)
			for(int j=0;j<len;j++)
				map[i][j] = 0;
	}
	//判定是否存在可消除的行,然后调用clearLine消除该行
	public void checkButton() {
		for(int i=height-1;i>0;i--) {
			for(int j=0;j<width;j++) {
				if(map[j][i]==0)
					break;
				if(map[j][i]!=0&&j==width-1) {
					line++;
					clearLine(i);
					i++;
				}
			}
		}
	}
	//消除某一行
	public void clearLine(int line) {
		for(int m=0;m<width;m++) {
			for(int n=line-1;n>0;n--) {
				map[m][n+1]=map[m][n];
			}
		}
	}
	//判定方块是否到顶,即游戏结束
	public boolean isGameOver() {
		for(int i=0;i<width;i++) {
			if(map[i][0]!=0)
				return true;
		}
		return false;
	}
	public int getClearLine() {
		int tmp = line;
		line=0;
		return tmp;
	}
}