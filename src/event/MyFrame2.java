package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;


public class MyFrame2 extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame2 frame = new MyFrame2();
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
	public MyFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		btnNewButton = new JButton("버튼을 누르세요");
		panel.add(btnNewButton);
		
		//버튼과 리스너를 연동하는 부분
		btnNewButton.addActionListener(new MyListener2());
		
		label = new JLabel("New label");
		
		
		panel.add(label);

	}
	class MyListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getSource());
			//버튼 위의 글자를 변경
		
			
				if(label.getText().equals("버튼을 또 눌렀습니다.")) {
					btnNewButton.setText("버튼을 눌렀군요!");
					label.setText("또 눌렀습니다.");
				}else {
					label.setText("버튼을 또 눌렀습니다.");
					btnNewButton.setText("버튼을 눌렀군요!~");
				}
		}
		
	}

}
