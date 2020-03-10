package Tetris;
//正方形
public class Quadrate extends Square{
	public Quadrate(Maps m,int color){
		this.mp=m;
		xPos=5;
		yPos=1;
		status = 0;
		IsStop = false;
		this.color=color;
		mp.map[xPos][yPos]=color;
		mp.map[xPos][yPos-1]=color;
		mp.map[xPos+1][yPos]=color;
		mp.map[xPos+1][yPos-1]=color;
	}
	
	@Override
	public boolean Down() {
		// TODO Auto-generated method stub
		if(yPos<mp.height-1) {
			if(mp.map[xPos][yPos+1]==0&&mp.map[xPos+1][yPos+1]==0) {
				mp.map[xPos][yPos+1]=color;
				mp.map[xPos+1][yPos+1]=color;
				mp.map[xPos][yPos-1]=0;
				mp.map[xPos+1][yPos-1]=0;
				yPos++;
				return true;
			}
		}
		IsStop=true;
		return false;
	}

	@Override
	public boolean Left() {
		// TODO Auto-generated method stub
		if(xPos>0) {
			if(mp.map[xPos-1][yPos]==0&&mp.map[xPos-1][yPos-1]==0) {
				mp.map[xPos-1][yPos-1]=color;
				mp.map[xPos-1][yPos]=color;
				mp.map[xPos+1][yPos-1]=0;
				mp.map[xPos+1][yPos]=0;
				xPos--;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean Right() {
		// TODO Auto-generated method stub
		if(xPos<mp.width-2) {
			if(mp.map[xPos+2][yPos]==0&&mp.map[xPos+2][yPos-1]==0) {
				mp.map[xPos+2][yPos-1]=color;
				mp.map[xPos+2][yPos]=color;
				mp.map[xPos][yPos-1]=0;
				mp.map[xPos][yPos]=0;
				xPos++;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean Spin() {
		// TODO Auto-generated method stub
		//正方形根本不用旋转,但是为了复写抽象方法使用空函数
		return true;
	}

}
