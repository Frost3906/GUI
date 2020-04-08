package container;

import javax.swing.JFrame;

public class JFrameTest1 {
	public static void main(String[] args) {
		//컨테이너 생성하기
		
		JFrame f = new JFrame("첫번째 프로그램");
		
		//x를 누르면 프로그램 종료 - 코드가 없을시 창은 사라져도 프로그램은 돌아감
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//컨테이너의 크기를 지정
		f.setSize(300,300);
		//컨테이너 보여주기
		f.setVisible(true);
		
		
	}
}
