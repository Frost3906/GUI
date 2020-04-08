package label;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.Font;

public class JLabelTest2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLabelTest2 frame = new JLabelTest2();
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
	public JLabelTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("이미지를 보려면 클릭하세요");
		tglbtnNewToggleButton.addActionListener(this);
		tglbtnNewToggleButton.setFont(new Font("굴림", Font.PLAIN, 18));
		contentPane.add(tglbtnNewToggleButton, BorderLayout.SOUTH);
		
		lblNewLabel = new JLabel("");
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼 클릭시 라벨에 이미지 보여주기
		
		AbstractButton btn = (AbstractButton) e.getSource();
		
		if(btn.isSelected()) {
			ImageIcon dog = new ImageIcon(getClass().getResource("pu.jpg"));
			lblNewLabel.setIcon(dog);
			lblNewLabel.setText("그림이 나타났어요.");
		}else {
			lblNewLabel.setIcon(null);
			lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
			lblNewLabel.setText("그림이 사라졌어요");
		}
			
		
	}

}
