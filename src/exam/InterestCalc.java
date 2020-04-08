package exam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterestCalc extends JFrame implements ActionListener{

	private JTextField txtField_1, txtField_2, txtField_3;
	private JButton btn_1;
	
	
	public InterestCalc() {
		setTitle("이자계산기");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setVisible(true);
		
		JPanel	totalPanel = new JPanel();
		totalPanel.setLayout(new BoxLayout(totalPanel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		JLabel label_1 = new JLabel("원금을 입력하시오");
		txtField_1 = new JTextField(7);
		panel_1.add(label_1);
		panel_1.add(txtField_1);
		totalPanel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		JLabel label_2 = new JLabel("이율을 입력하시오");
		txtField_2 = new JTextField(7);
		panel_2.add(label_2);
		panel_2.add(txtField_2);
		totalPanel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		btn_1 = new JButton("변환");
		btn_1.addActionListener(this);
		panel_3.add(btn_1);
		totalPanel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		txtField_3 = new JTextField(20);
		panel_4.add(txtField_3);
		totalPanel.add(panel_4);
		
		add(totalPanel);
		
		pack();
	}
	
	public static void main(String[] args) {
		InterestCalc calc = new InterestCalc();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		float i1 = Float.parseFloat(txtField_1.getText()); 
		float i2 = Float.parseFloat(txtField_2.getText()); 
		txtField_3.setText(String.valueOf(i1*i2/100));
		
	}

}
