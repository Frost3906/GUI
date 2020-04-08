package checkbox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

public class JCheckTest4 extends JFrame implements ItemListener{

	private JPanel contentPane;
	private JCheckBox ch_apple, ch_grape, ch_orange;
	private JLabel l_apple, l_grape, l_orange;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckTest4 frame = new JCheckTest4();
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
	public JCheckTest4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		ch_apple = new JCheckBox("Apple");
		ch_apple.addItemListener(this);
		panel_1.add(ch_apple);
		
		ch_grape = new JCheckBox("Grape");
		ch_grape.addItemListener(this);
		panel_1.add(ch_grape);
		
		ch_orange = new JCheckBox("Orange");
		ch_orange.addItemListener(this);
		panel_1.add(ch_orange);
		
		
		l_apple = new JLabel("");
		l_apple.setIcon(new ImageIcon(JCheckTest4.class.getResource("/checkbox/apple.gif")));
		panel.add(l_apple);
		
		l_grape = new JLabel("");
		l_grape.setIcon(new ImageIcon(JCheckTest4.class.getResource("/checkbox/grape.gif")));
		panel.add(l_grape);
		
		l_orange = new JLabel("");
		l_orange.setIcon(new ImageIcon(JCheckTest4.class.getResource("/checkbox/orange.gif")));
		panel.add(l_orange);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox check = (JCheckBox)e.getItem();
		ImageIcon icon = null;
		if(e.getStateChange()==ItemEvent.SELECTED) {
			if(check.getText().equals("Apple")) {
				icon = new ImageIcon(getClass().getResource("apple.gif"));
				l_apple.setIcon(icon);
			}else if(check.getText().equals("Grape")) {
				icon = new ImageIcon(getClass().getResource("grape.gif"));
				l_grape.setIcon(icon);
			}else if(check.getText().equals("Orange")) {
				icon = new ImageIcon(getClass().getResource("orange.gif"));
				l_orange.setIcon(icon);
			}
		}else {
			if(check.getText().equals("Apple")) {
				l_apple.setIcon(null);
			}else if(check.getText().equals("Grape")) {
				l_grape.setIcon(null);
			}else if(check.getText().equals("Orange")) {
				l_orange.setIcon(null);
			}
		}
	}

}
