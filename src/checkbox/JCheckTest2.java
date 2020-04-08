package checkbox;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class JCheckTest2 extends JFrame implements ItemListener{

	private JPanel contentPane;
	private JCheckBox apple, peach, grape;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckTest2 frame = new JCheckTest2();
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
	public JCheckTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		apple= new JCheckBox("사과");
		apple.addItemListener(this);
		panel_1.add(apple);
		
		peach = new JCheckBox("복숭아");
		peach.addItemListener(this);
		panel_1.add(peach);
		
		grape = new JCheckBox("포도");
		grape.addItemListener(this);
		panel_1.add(grape);
		
		textArea = new JTextArea();
		panel.add(textArea);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// 각 체크박스가 체크되면 체크된 과일의 이름을 textArea 보여주기
		// 체크가 해제되면 textArea에 있던 과일의 이름은 삭제
		// textArea => setText(), append()
		JCheckBox check = (JCheckBox)e.getItem();
		if(e.getStateChange()==ItemEvent.SELECTED) {
			textArea.append(check.getText()+" ");
		}else {
			String contents = textArea.getText();
			
			String delTxt = check.getText();
			
			StringBuffer buf = new StringBuffer(contents);
			int start = buf.indexOf(delTxt);
			int end = start+delTxt.length();
			buf.delete(start,end);
			textArea.setText(buf.toString());
		}
	
	}

}
