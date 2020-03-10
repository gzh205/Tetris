package Tetris;
/*	ÓÒLÐÎ£¬´ó¸ÅÊÇ:
 * 0 1 0
 * 0 1 0	×´Ì¬0
 * 1 1 0
 * 
 * 1 0 0
 * 1 1 1	×´Ì¬1
 * 0 0 0
 * 
 * 0 1 1
 * 0 1 0	×´Ì¬2
 * 0 1 0
 * 
 * 0 0 0
 * 1 1 1	×´Ì¬3
 * 0 0 1
 * */
public class RightL extends Square{
	public RightL(Maps m,int color) {
		this.mp=m;
		xPos=5;
		yPos=2;
		status = 0;
		IsStop = false;
		this.color=color;
		mp.map[xPos][yPos-1]=color;
		mp.map[xPos][yPos+1]=color;
		mp.map[xPos-1][yPos+1]=color;
		mp.map[xPos][yPos]=color;
	}
	
	@Override
	public boolean Down() {
		// TODO Auto-generated method stub
		if(status==0&&yPos<mp.height-2) {
			if(mp.map[xPos][yPos+2]==0&&mp.map[xPos-1][yPos+2]==0) {
				mp.map[xPos][yPos+2]=color;
				mp.map[xPos-1][yPos+2]=color;
				mp.map[xPos-1][yPos+1]=0;
				mp.map[xPos][yPos-1]=0;
				yPos++;
				return true;
			}
		}
		else if(status==1&&yPos<mp.height-1) {
			if(mp.map[xPos][yPos+1]==0&&mp.map[xPos-1][yPos+1]==0&&mp.map[xPos+1][yPos+1]==0) {
				mp.map[xPos][yPos+1]=color;
				mp.map[xPos-1][yPos+1]=color;
				mp.map[xPos+1][yPos+1]=color;
				mp.map[xPos][yPos]=0;
				mp.map[xPos-1][yPos-1]=0;
				mp.map[xPos+1][yPos]=0;
				yPos++;
				return true;
			}
		}
		else if(status==2&&yPos<mp.height-2) {
			if(mp.map[xPos][yPos+2]==0&&mp.map[xPos+1][yPos]==0) {
				mp.map[xPos][yPos+2]=color;
				mp.map[xPos+1][yPos]=color;
				mp.map[xPos][yPos-1]=0;
				mp.map[xPos+1][yPos-1]=0;
				yPos++;
				return true;
			}
		}
		else if(status==3&&yPos<mp.height-2) {
			if(mp.map[xPos][yPos+1]==0&&mp.map[xPos+1][yPos+2]==0&&mp.map[xPos-1][yPos+1]==0) {
				mp.map[xPos][yPos+1]=color;
				mp.map[xPos+1][yPos+2]=color;
				mp.map[xPos-1][yPos+1]=color;
				mp.map[xPos][yPos]=0;
				mp.map[xPos-1][yPos]=0;
				mp.map[xPos+1][yPos]=0;
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
		if(status==0&&xPos>1) {
			if(mp.map[xPos-1][yPos]==0&&mp.map[xPos-1][yPos-1]==0&&mp.map[xPos-2][yPos+1]==0) {
				mp.map[xPos-1][yPos]=color;
				mp.map[xPos-1][yPos-1]=color;
				mp.map[xPos-2][yPos+1]=color;
				mp.map[xPos][yPos]=0;
				mp.map[xPos][yPos+1]=0;
				mp.map[xPos][yPos-1]=0;
				xPos--;
				return true;
			}
		}
		else if(status==1&&xPos>1) {
			if(mp.map[xPos-2][yPos]==0&&mp.map[xPos-2][yPos-1]==0) {
				mp.map[xPos-2][yPos]=color;
				mp.map[xPos-2][yPos-1]=color;
				mp.map[xPos+1][yPos]=0;
				mp.map[xPos-1][yPos-1]=0;
				xPos--;
				return true;
			}
		}
		else if(status==2&&xPos>0) {
			if(mp.map[xPos-1][yPos]==0&&mp.map[xPos-1][yPos-1]==0&&mp.map[xPos-1][yPos+1]==0) {
				mp.map[xPos-1][yPos]=color;
				mp.map[xPos-1][yPos-1]=color;
				mp.map[xPos-1][yPos+1]=color;
				mp.map[xPos][yPos]=0;
				mp.map[xPos][yPos+1]=0;
				mp.map[xPos+1][yPos-1]=0;
				xPos--;
				return true;
			}
		}
		else if(status==3&&xPos>1) {
			if(mp.map[xPos-2][yPos]==0&&mp.map[xPos][yPos+1]==0) {
				mp.map[xPos-2][yPos]=color;
				mp.map[xPos][yPos+1]=color;
				mp.map[xPos+1][yPos+1]=0;
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
		if(status==0&&xPos<mp.width-1) {
			if(mp.map[xPos+1][yPos]==0&&mp.map[xPos+1][yPos-1]==0&&mp.map[xPos+1][yPos+1]==0) {
				mp.map[xPos+1][yPos]=color;
				mp.map[xPos+1][yPos-1]=color;
				mp.map[xPos+1][yPos+1]=color;
				mp.map[xPos][yPos]=0;
				mp.map[xPos-1][yPos+1]=0;
				mp.map[xPos][yPos-1]=0;
				xPos++;
				return true;
			}
		}
		else if(status==1&&xPos<mp.width-2) {
			if(mp.map[xPos+2][yPos]==0&&mp.map[xPos][yPos-1]==0) {
				mp.map[xPos+2][yPos]=color;
				mp.map[xPos][yPos-1]=color;
				mp.map[xPos-1][yPos]=0;
				mp.map[xPos-1][yPos-1]=0;
				xPos++;
				return true;
			}
		}
		else if(status==2&&xPos<mp.width-2) {
			if(mp.map[xPos+1][yPos]==0&&mp.map[xPos+2][yPos-1]==0&&mp.map[xPos+1][yPos+1]==0) {
				mp.map[xPos+1][yPos]=color;
				mp.map[xPos+2][yPos-1]=color;
				mp.map[xPos+1][yPos+1]=color;
				mp.map[xPos][yPos]=0;
				mp.map[xPos][yPos+1]=0;
				mp.map[xPos][yPos-1]=0;
				xPos++;
				return true;
			}
		}
		else if(status==3&&xPos<mp.width-2) {
			if(mp.map[xPos+2][yPos]==0&&mp.map[xPos+2][yPos+1]==0) {
				mp.map[xPos+2][yPos]=color;
				mp.map[xPos+2][yPos+1]=color;
				mp.map[xPos+1][yPos+1]=0;
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
		if(status==0&&xPos<mp.width-1) {
			if(mp.map[xPos-1][yPos]==0&&mp.map[xPos+1][yPos]==0&&mp.map[xPos-1][yPos-1]==0) {
				mp.map[xPos-1][yPos]=color;
				mp.map[xPos+1][yPos]=color;
				mp.map[xPos-1][yPos-1]=color;
				mp.map[xPos][yPos-1]=0;
				mp.map[xPos][yPos+1]=0;
				mp.map[xPos-1][yPos+1]=0;
				status=1;
				return true;
			}
		}
		else if(status==1&&yPos<mp.height-1) {
			if(mp.map[xPos][yPos-1]==0&&mp.map[xPos][yPos+1]==0&&mp.map[xPos+1][yPos-1]==0) {
				mp.map[xPos][yPos-1]=color;
				mp.map[xPos][yPos+1]=color;
				mp.map[xPos+1][yPos-1]=color;
				mp.map[xPos+1][yPos]=0;
				mp.map[xPos-1][yPos]=0;
				mp.map[xPos-1][yPos-1]=0;
				status=2;
				return true;
			}
		}
		else if(status==2&&xPos>0) {
			if(mp.map[xPos-1][yPos]==0&&mp.map[xPos+1][yPos]==0&&mp.map[xPos+1][yPos+1]==0) {
				mp.map[xPos-1][yPos]=color;
				mp.map[xPos+1][yPos]=color;
				mp.map[xPos+1][yPos+1]=color;
				mp.map[xPos][yPos-1]=0;
				mp.map[xPos][yPos+1]=0;
				mp.map[xPos+1][yPos-1]=0;
				status=3;
				return true;
			}
		}
		else if(status==3) {
			if(mp.map[xPos][yPos-1]==0&&mp.map[xPos][yPos+1]==0&&mp.map[xPos-1][yPos+1]==0) {
				mp.map[xPos][yPos-1]=color;
				mp.map[xPos][yPos+1]=color;
				mp.map[xPos-1][yPos+1]=color;
				mp.map[xPos+1][yPos]=0;
				mp.map[xPos-1][yPos]=0;
				mp.map[xPos+1][yPos+1]=0;
				status=0;
				return true;
			}
		}
		return false;
	}

}
