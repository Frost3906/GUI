package layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;

public class JPanelTest1 extends JFrame {
	
	public JPanelTest1 () {
		setTitle("MyFrame");
		setSize(600,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JPanel totalPane = new JPanel();
		totalPane.setLayout(new BorderLayout());
		
	
		
		JPanel centerPanel = new JPanel();
		JButton btn1 = new JButton("콤보피자");
		JButton btn2 = new JButton("포테이토피자");
		JButton btn3 = new JButton("불고기피자");
		JLabel label1 = new JLabel("개수");
		JTextField txtf = new JTextField(10);
		centerPanel.add(btn1);
		centerPanel.add(btn2);
		centerPanel.add(btn3);
		centerPanel.add(label1);
		centerPanel.add(txtf);
		totalPane.add(centerPanel,BorderLayout.CENTER);
		
	
		JPanel topPanel = new JPanel();
		JLabel label2 = new JLabel("자바 피자에 오신 것을 환영합니다.");
		topPanel.add(label2);
		totalPane.add(topPanel,BorderLayout.NORTH);
		

		
		
		
		add(totalPane);
		
	}
	
	public static void main(String[] args) {
		JPanelTest1 paneltest = new JPanelTest1();
	}

}
