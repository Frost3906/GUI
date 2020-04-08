package event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class MyFrame6 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Scanner sc ;
	private JPanel panel;
	private JButton btnYellow;
	private JButton btnRed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame6 frame = new MyFrame6();
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
	public MyFrame6() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		btnYellow = new JButton("노랑");
		btnYellow.addActionListener(this);
		panel.add(btnYellow);
		
		btnRed = new JButton("빨강");
		btnRed.addActionListener(this);
		panel.add(btnRed);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnYellow) {
			contentPane.setBackground(Color.YELLOW);		
			panel.setBackground(Color.yellow);
			}
			else {
				contentPane.setBackground(Color.RED);		
				panel.setBackground(Color.red);
			}
			
		
		
	}

}
