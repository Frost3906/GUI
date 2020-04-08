package exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class Celsius extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	/**
	 * @wbp.nonvisual location=161,349
	 */
	private final JTextField textField_1 = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Celsius frame = new Celsius();
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
	public Celsius() {
		setTitle("온도변환기");
		textField_1.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Celsius");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Convert");
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Fahrenheit");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		pack();
		
		
	}

}
