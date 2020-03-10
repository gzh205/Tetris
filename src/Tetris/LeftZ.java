package Tetris;
//左Z型,也就是
//0	1 1
//1 1 0
//状态1
//1 0
//1 1
//0 1
//状态0
public class LeftZ extends Square{
	public LeftZ(Maps m,int color) {
		xPos=5;
		yPos=1;
		status = 0;
		IsStop = false;
		this.mp=m;
		this.color=color;
		mp.map[xPos][yPos-1]=color;
		mp.map[xPos+1][yPos]=color;
		mp.map[xPos+1][yPos+1]=color;
		mp.map[xPos][yPos]=color;
	}
	
	@Override
	public boolean Down() {
		// TODO Auto-generated method stub
		if(status==0&&yPos<mp.height-2) {
			if(mp.map[xPos][yPos+1]==0&&mp.map[xPos+1][yPos+2]==0) {
				mp.map[xPos][yPos+1]=color;
				mp.map[xPos+1][yPos+2]=color;
				mp.map[xPos][yPos-1]=0;
				mp.map[xPos+1][yPos]=0;
				yPos++;
				return true;
			}
		}
		else if(status==1&&yPos<mp.height-1) {
			if(mp.map[xPos][yPos+1]==0&&mp.map[xPos+1][yPos]==0&&mp.map[xPos-1][yPos+1]==0) {
				mp.map[xPos][yPos+1]=color;
				mp.map[xPos+1][yPos]=color;
				mp.map[xPos-1][yPos+1]=color;
				mp.map[xPos][yPos-1]=0;
				mp.map[xPos+1][yPos-1]=0;
				mp.map[xPos-1][yPos]=0;
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
		if(status==0&&xPos>0) {
			if(mp.map[xPos-1][yPos]==0&&mp.map[xPos-1][yPos-1]==0&&mp.map[xPos][yPos+1]==0) {
				mp.map[xPos-1][yPos]=color;
				mp.map[xPos-1][yPos-1]=color;
				mp.map[xPos][yPos+1]=color;
				mp.map[xPos+1][yPos]=0;
				mp.map[xPos+1][yPos+1]=0;
				mp.map[xPos][yPos-1]=0;
				xPos--;
				return true;
			}
		}
		else if(status==1&&xPos>1) {
			if(mp.map[xPos-2][yPos]==0&&mp.map[xPos-1][yPos-1]==0) {
				mp.map[xPos-2][yPos]=color;
				mp.map[xPos-1][yPos-1]=color;
				mp.map[xPos][yPos]=0;
				mp.map[xPos+1][yPos-1]=0;
				xPos--;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean Right() {
		// TODO Auto-generated method stub
		if(status==0&&xPos<mp.width-2) {
			if(mp.map[xPos+2][yPos]==0&&mp.map[xPos+2][yPos+1]==0&&mp.map[xPos+1][yPos-1]==0) {
				mp.map[xPos+2][yPos]=color;
				mp.map[xPos+2][yPos+1]=color;
				mp.map[xPos+1][yPos-1]=color;
				mp.map[xPos][yPos]=0;
				mp.map[xPos][yPos-1]=0;
				mp.map[xPos+1][yPos+1]=0;
				xPos++;
			return true;
			}
		}
		else if(status==1&&xPos<mp.width-2) {
			if(mp.map[xPos+1][yPos]==0&&mp.map[xPos+2][yPos-1]==0) {
				mp.map[xPos+1][yPos]=color;
				mp.map[xPos+2][yPos-1]=color;
				mp.map[xPos][yPos-1]=0;
				mp.map[xPos-1][yPos]=0;
				xPos++;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean Spin() {
		// TODO Auto-generated method stub
		/*	0->1变换
		 * 0 1 0	  0 0 0	
		 * 0 1 1  ->  0 1 1
		 * 0 0 1	  1 1 0	
		 * */
		if(status==0&&xPos>0) {
			if(mp.map[xPos+1][yPos-1]==0&&mp.map[xPos-1][yPos]==0) {
				mp.map[xPos+1][yPos-1]=color;
				mp.map[xPos-1][yPos]=color;
				mp.map[xPos+1][yPos]=0;
				mp.map[xPos+1][yPos+1]=0;
				status=1;
				return true;
			}
		}
		else if(status==1&&yPos<mp.height-1) {
			if(mp.map[xPos+1][yPos]==0&&mp.map[xPos+1][yPos+1]==0) {
				mp.map[xPos+1][yPos]=color;
				mp.map[xPos+1][yPos+1]=color;
				mp.map[xPos-1][yPos]=0;
				mp.map[xPos+1][yPos-1]=0;
				status=0;
				return true;
			}
		}
		return false;
	}

}
