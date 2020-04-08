package exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ButtonDemo extends JFrame implements ActionListener{
	
	private JButton btnLeft, btnMiddle, btnRight;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonDemo frame = new ButtonDemo();
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
	public ButtonDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		btnLeft = new JButton("Disable Middle Button");
		btnLeft.setActionCommand("disable");
		btnLeft.addActionListener(this);
		btnLeft.setMnemonic('D');
		btnLeft.setIcon(new ImageIcon(ButtonDemo.class.getResource("/exam/left.gif")));
		panel.add(btnLeft);
		
		btnMiddle = new JButton("Middle Button");
		btnMiddle.setActionCommand("middle");
		btnMiddle.addActionListener(this);
		btnMiddle.setMnemonic('M');
		btnMiddle.setIcon(new ImageIcon(ButtonDemo.class.getResource("/exam/middle.gif")));
		panel.add(btnMiddle);
		
		btnRight = new JButton("Enable Middle Button");
		btnRight.setActionCommand("enable");
		btnRight.addActionListener(this);
		btnRight.setMnemonic('E');
		btnRight.setIcon(new ImageIcon(ButtonDemo.class.getResource("/exam/right.gif")));
		panel.add(btnRight);
		
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// e.getSource()    / e.getActionCommand()
		
		String cmd = e.getActionCommand();
		if(cmd.equals("disable")) {
			btnMiddle.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(true);
		}else {
			btnMiddle.setEnabled(true);
			btnLeft.setEnabled(true);
			btnRight.setEnabled(false);
		}
		
	}

}
