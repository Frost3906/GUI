package exam;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class RSP extends JFrame implements ActionListener{
	
	JPanel contentPane, buttonPane;
	JButton btn_R, btn_S, btn_P;
	JLabel label;
	JTextField result;
	
	
	private static final int ROCK = 0;
	private static final int SCISSOR = 1;
	private static final int PAPER = 2;
	
	public RSP() {
		setTitle("가위바위보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(840,485);
		
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		
		label = new JLabel("아래의 버튼 중에서 하나를 클릭하시오!");
		contentPane.add(label,BorderLayout.NORTH);
		
		
		buttonPane = new JPanel();
		buttonPane.setLayout(new GridLayout(0,3,0,0));
		contentPane.add(buttonPane,BorderLayout.CENTER);
		
		
		btn_P = new JButton();
		btn_P.setIcon(new ImageIcon(RSP.class.getResource("/exam/paper.png")));
		btn_P.addActionListener(this);
		btn_P.setActionCommand("PAPER");
		btn_R = new JButton();
		btn_R.setIcon(new ImageIcon(RSP.class.getResource("/exam/rock.png")));
		btn_R.addActionListener(this);
		btn_R.setActionCommand("ROCK");
		btn_S = new JButton();
		btn_S.setIcon(new ImageIcon(RSP.class.getResource("/exam/scissor.png")));
		btn_S.addActionListener(this);
		btn_S.setActionCommand("SCISSOR");
		buttonPane.add(btn_R);
		buttonPane.add(btn_S);
		buttonPane.add(btn_P);
		
		
		
		result = new JTextField();
		contentPane.add(result,BorderLayout.SOUTH);
		
		getContentPane().add(contentPane);
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		RSP rsp = new RSP();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		JButton btntest = (JButton) e.getSource();
		System.out.println(btntest);
		Random random = new Random();
		int com = random.nextInt(3);
		
		if(cmd.equals("ROCK")) {
			if(com==ROCK) {
				result.setText("무");
			}else if(com==SCISSOR) {
				result.setText("승");
			}else if(com==PAPER) {
				result.setText("패");
			}
		}else if(cmd.equals("SCISSOR")) {
			if(com==ROCK) {
				result.setText("패");
			}else if(com==SCISSOR) {
				result.setText("무");
			}else if(com==PAPER) {
				result.setText("승");
			}
		}else if(cmd.equals("PAPER")) {
			if(com==ROCK) {
				result.setText("승");
			}else if(com==SCISSOR) {
				result.setText("패");
			}else if(com==PAPER) {
				result.setText("무");
			}
		}
	}
		
	

}
