package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;

public class KeyEventTest1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyEventTest1 frame = new KeyEventTest1();
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
	public KeyEventTest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("문자열 입력");
		panel.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
		textField = new JTextField();
		
		textField.setColumns(10);
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				//키보드에서 키를 누를때 발생
//				System.out.println(e.getKeyCode());
//				System.out.println(e.getKeyChar());
				int keyCode = e.getKeyCode();
				
				System.out.println(java.awt.event.KeyEvent.getKeyText(keyCode));
				if(keyCode>='a' && keyCode <='z' || keyCode >= 'A' && keyCode <= 'Z') {
					textArea.setText("영어입니다.");
				}else {
					textArea.setText("영어아닙니다.");
				}
				
			}
			
			
		});
		
		panel.add(textField);
	}

}
