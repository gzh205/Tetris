package Tetris;
//≥§Ãı–Œ
class Elongated extends Square{
	public Elongated(Maps m,int color) {
		xPos=5;
		yPos=2;
		status = 0;
		IsStop = false;
		this.mp=m;
		this.color=color;
		mp.map[xPos][yPos-1]=color;
		mp.map[xPos][yPos-2]=color;
		mp.map[xPos][yPos+1]=color;
		mp.map[xPos][yPos]=color;
	}
	@Override
	public boolean Down() {
		// TODO Auto-generated method stub
		if(status == 0&&yPos<mp.height-2) {
			if(mp.map[xPos][yPos+2]==0) {
				mp.map[xPos][yPos+2]=color;
				mp.map[xPos][yPos-2]=0;
				yPos++;
				return true;
			}
		}
		else if (status == 1 && yPos < mp.height - 1) {
			if (mp.map[xPos][yPos + 1] == 0 && mp.map[xPos - 1][yPos + 1] == 0
					&& mp.map[xPos + 1][yPos + 1] == 0 && mp.map[xPos + 2][yPos + 1] == 0) {
				mp.map[xPos][yPos + 1] = color;
				mp.map[xPos - 1][yPos + 1] = color;
				mp.map[xPos + 1][yPos + 1] = color;
				mp.map[xPos + 2][yPos + 1] = color;
				mp.map[xPos][yPos] = 0;
				mp.map[xPos - 1][yPos] = 0;
				mp.map[xPos + 1][yPos] = 0;
				mp.map[xPos + 2][yPos] = 0;
				yPos++;
				return true;
			}
		}
		IsStop = true;
		return false;
	}
	@Override
	public boolean Left() {
		// TODO Auto-generated method stub
		if (status == 0 && xPos > 0) {
			if (mp.map[xPos - 1][yPos] == 0 && mp.map[xPos - 1][yPos - 1] == 0
					&& mp.map[xPos - 1][yPos + 1] == 0 && mp.map[xPos - 1][yPos - 2] == 0) {
				mp.map[xPos - 1][yPos + 1] = color;
				mp.map[xPos - 1][yPos - 2] = color;
				mp.map[xPos - 1][yPos] = color;
				mp.map[xPos - 1][yPos - 1] =color;
				mp.map[xPos][yPos + 1] = 0;
				mp.map[xPos][yPos - 2] = 0;
				mp.map[xPos][yPos] = 0;
				mp.map[xPos][yPos - 1] = 0;
				xPos--;
				return true;
			}
		} else if (status == 1 && xPos > 1) {
			if (mp.map[xPos - 2][yPos] == 0) {
				mp.map[xPos - 2][yPos] = color;
				mp.map[xPos + 2][yPos] = 0;
				xPos--;
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean Right() {
		// TODO Auto-generated method stub
		if (status == 0 && xPos < mp.width - 1) {
			if (mp.map[xPos + 1][yPos] == 0 && mp.map[xPos + 1][yPos - 1] == 0
					&& mp.map[xPos + 1][yPos + 1] == 0 && mp.map[xPos + 1][yPos - 2] == 0) {
				mp.map[xPos + 1][yPos + 1] = color;
				mp.map[xPos + 1][yPos - 2] = color;
				mp.map[xPos + 1][yPos] = color;
				mp.map[xPos + 1][yPos - 1] = color;
				mp.map[xPos][yPos + 1] = 0;
				mp.map[xPos][yPos - 2] = 0;
				mp.map[xPos][yPos] = 0;
				mp.map[xPos][yPos - 1] = 0;
				xPos++;
				return true;
			}
		} else if (status == 1 && xPos < mp.width - 3) {
			if (mp.map[xPos + 3][yPos] == 0) {
				mp.map[xPos - 1][yPos] = 0;
				mp.map[xPos + 3][yPos] = color;
				xPos++;
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean Spin() {
		// TODO Auto-generated method stub
		if (status == 0 && (xPos < mp.width - 2 && xPos > 0)) {
			if (mp.map[xPos - 1][yPos] == 0 && mp.map[xPos + 1][yPos] == 0 && mp.map[xPos + 2][yPos] == 0) {
				status = 1;
				mp.map[xPos][yPos - 1] = 0;
				mp.map[xPos][yPos - 2] = 0;
				mp.map[xPos][yPos + 1] = 0;
				mp.map[xPos - 1][yPos] = color;
				mp.map[xPos + 1][yPos] = color;
				mp.map[xPos + 2][yPos] = color;
				return true;
			}
		} else if (status == 1 && (yPos > 1 && yPos < mp.height - 1)) {
			if (mp.map[xPos][yPos - 1] == 0 && mp.map[xPos][yPos + 1] == 0 && mp.map[xPos][yPos - 2] == 0) {
				status = 0;
				mp.map[xPos][yPos - 1] = color;
				mp.map[xPos][yPos - 2] = color;
				mp.map[xPos][yPos + 1] = color;
				mp.map[xPos - 1][yPos] = 0;
				mp.map[xPos + 1][yPos] = 0;
				mp.map[xPos + 2][yPos] = 0;
				return true;
			}
		}
		return false;
	}
	
}
