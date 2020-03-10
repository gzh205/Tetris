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
		gp.sq.Down();//ÿ���Զ��½�
		gp.sq.DisplayImage(gp.getGraphics());//��ʾ�µ���Ϸ���
		if(Main.Stop==false)
		if(gp.sq.testStop()==true) {//������鴥��
			gp.sq.mp.checkButton();//����Ƿ�����������ַ���
			for(int i=0;i<gp.sq.mp.getClearLine();i++)
				gp.sc.addLine().addScore().Display(gp.lblScore);
			if(gp.sq.mp.isGameOver()) {//�Ƿ�GameOver
				this.cancel();//ȡ����ʱ��
				gp.removeKeyListener(gp.mks);//�Ƴ����̼���
				JOptionPane.showMessageDialog(null, "��Ϸ����");//��ʾ
			}
			gp.squareRadom();//����������ɷ�����
			gp.squareFactory(gp.getNextSquare());//���ݷ������������ɷ���
			MyKeyListener.changeSquare(gp.sq);//������ҿ��Ƶķ���
			//gp.sq.Display(gp.getGraphics());//���»�����Ϸ���
		}
	}
}