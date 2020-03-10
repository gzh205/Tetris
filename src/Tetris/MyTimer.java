package Tetris;

import java.util.TimerTask;
import javax.swing.JOptionPane;

public class MyTimer extends TimerTask{
	public MyTimer(GamePane gp){
		this.gp = gp;
	}
	public GamePane gp;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		gp.sq.Down();//每秒自动下降
		gp.sq.DisplayImage(gp.getGraphics());//显示新的游戏面板
		if(Main.Stop==false)
		if(gp.sq.testStop()==true) {//如果方块触底
			gp.sq.mp.checkButton();//检查是否可以消除部分方块
			for(int i=0;i<gp.sq.mp.getClearLine();i++)
				gp.sc.addLine().addScore().Display(gp.lblScore);
			if(gp.sq.mp.isGameOver()) {//是否GameOver
				this.cancel();//取消计时器
				gp.removeKeyListener(gp.mks);//移除键盘监听
				JOptionPane.showMessageDialog(null, "游戏结束");//提示
			}
			gp.squareRadom();//重新随机生成方块编号
			gp.squareFactory(gp.getNextSquare());//根据方块编号重新生成方块
			MyKeyListener.changeSquare(gp.sq);//更改玩家控制的方块
			//gp.sq.Display(gp.getGraphics());//重新绘制游戏面板
		}
	}
}