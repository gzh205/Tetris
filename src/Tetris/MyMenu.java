package Tetris;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenu{
	public static JMenuBar jmb;
	
	public static void initMenu(){
		jmb = new JMenuBar();
		JMenu mFile = new JMenu("�ļ�(F)");
		JMenu mHelp = new JMenu("����(H)");
		mFile.setMnemonic('F');
		mHelp.setMnemonic('H');
		JMenuItem jmiStart = new JMenuItem("���¿�ʼ(S)"), jmiColor = new JMenuItem("������(C)");
		jmiStart.setMnemonic('S');
		jmiColor.setMnemonic('C');
		mFile.add(jmiStart);
		mFile.add(jmiColor);
		JMenuItem jmiHelp = new JMenuItem("����(H)");
		jmiHelp.setMnemonic('H');
		mHelp.add(jmiHelp);
		MenuAction ma = new MenuAction();
		ma.setMenuRestart(jmiStart).setMenuColor(jmiColor);
		jmb.add(mFile);
		jmb.add(mHelp);
	}
	
	public static void setMenu(GamePane gp) {
		gp.setJMenuBar(jmb);
		jmb.setVisible(true);
	}
	
}
