package label;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class JRadioTest3 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRadioTest3 frame = new JRadioTest3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JRadioTest3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("어떤 크기의 피자를 주문하시겠습니까?");
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uC0AC\uC774\uC988", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_2);
		
		JRadioButton rdsmall = new JRadioButton("Small Size");
		rdsmall.addActionListener(this);
		panel_2.add(rdsmall);
		
		JRadioButton rdmed = new JRadioButton("Medium Size");
		rdmed.addActionListener(this);
		panel_2.add(rdmed);
		
		JRadioButton rdlar = new JRadioButton("Large Size");
		rdlar.addActionListener(this);
		panel_2.add(rdlar);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdsmall);
		group.add(rdlar);
		group.add(rdmed);
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(20);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		textField.setText(e.getActionCommand()+"가 선택되었습니다.");
	}

}
