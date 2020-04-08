package container;

import javax.swing.JFrame;

public class JFrameTest2 extends JFrame{
	
	public JFrameTest2() {
		setTitle("세번째 프로그램");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		JFrameTest2 f = new JFrameTest2();
		
		
	}
	
}
