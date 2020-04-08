package layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;

public class JPanelTest2 extends JFrame {
	
	public JPanelTest2 () {
		setTitle("여러가지 레이아웃");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JPanel totalPane = new JPanel();
		totalPane.setLayout(new BorderLayout());
		
		
		//상단에 보여줄 레이아웃 설정
		
		JPanel topPanel = new JPanel();
		JButton btn1 = new JButton("왼쪽");
		JButton btn2 = new JButton("가운데");
		JButton btn3 = new JButton("오른쪽");
		topPanel.add(btn1);
		topPanel.add(btn2);
		topPanel.add(btn3);
		totalPane.add(topPanel,BorderLayout.NORTH);
		
		//좌측에 보여줄 레이아웃 설정
		JPanel leftPanel = new JPanel();
		JButton btn4 = new JButton("수박");
		leftPanel.add(btn4);
		totalPane.add(leftPanel,BorderLayout.WEST);
		
		//우측에 보여줄 레이아웃 설정
		JPanel rightPanel = new JPanel();
		JButton btn5 = new JButton("apfhs");
		rightPanel.add(btn5);
		totalPane.add(rightPanel,BorderLayout.EAST);
		
		JPanel centerPanel = new JPanel();
		JLabel label = new JLabel("이름 ");
		JTextField field = new JTextField(10);
		JTree tree = new JTree();
		centerPanel.add(label);
		centerPanel.add(field);
		centerPanel.add(tree);
		totalPane.add(centerPanel, BorderLayout.CENTER);
		
		JButton btn6 = new JButton("남쪽 버튼");
		totalPane.add(btn6,BorderLayout.SOUTH);
		
		add(totalPane);
		
	}
	
	public static void main(String[] args) {
		JPanelTest2 paneltest = new JPanelTest2();
	}

}
