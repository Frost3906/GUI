package container;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest4 extends JFrame{
	
	public JFrameTest4() {
		setTitle("네번째 프로그램");
		setBounds(200,300,100,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		//컴포넌트 생성하기
		JButton btn1 = new JButton("open");
		JButton btn2 = new JButton("save");
		JCheckBox check = new JCheckBox("GUI 프로그래밍");
		JColorChooser chooser = new JColorChooser();
		
		//컴포넌트 부착
		panel.add(btn1);
		panel.add(btn2);
		panel.add(check);
		panel.add(chooser);
		
		add(panel);
		
	}
	
	public static void main(String[] args) {
		
		JFrameTest4 f = new JFrameTest4();
		
		
		
	}
	
}
