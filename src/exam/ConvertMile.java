package exam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConvertMile extends JFrame implements ActionListener{
	JTextField txtField_1, txtField_2;
	public ConvertMile() {
		
		setTitle("마일을 킬로미터로 변환");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		JPanel totalPanel = new JPanel();
		totalPanel.setLayout(new BoxLayout(totalPanel,BoxLayout.Y_AXIS));
		
		
		JPanel topPanel = new JPanel();
		JLabel label_1 = new JLabel("거리를 마일 단위로 입력하세요");
		txtField_1 = new JTextField(10);
		topPanel.add(label_1);
		topPanel.add(txtField_1);
		totalPanel.add(topPanel);
		
		
		JPanel panel_1 = new JPanel();
		JButton btn_1 = new JButton("변환");
		btn_1.addActionListener(this);
		panel_1.add(btn_1);
		totalPanel.add(panel_1);
		
		
		
		JPanel panel_2 = new JPanel();
		txtField_2 = new JTextField(20);
		panel_2.add(txtField_2);
		totalPanel.add(panel_2);
		
		
		
		add(totalPanel);
		pack();
	}
	
	
	public static void main(String[] args) {
		
		ConvertMile converter = new ConvertMile();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		float mile = Float.parseFloat(txtField_1.getText());
		txtField_2.setText(String.valueOf(mile*1.6));
		
	}

}
