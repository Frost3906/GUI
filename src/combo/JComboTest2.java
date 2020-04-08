package combo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JComboTest2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComboTest2 frame = new JComboTest2();
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
	public JComboTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//콤보박스에 들어갈 아이템 설정
//		String[] items = {"월","화","수","목","금","토"};
//		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(items);
//		
//		JComboBox<String> combo = new JComboBox<String>();
//		combo.setModel(model);

		Vector<String> vector = new Vector<String>();
		vector.add("사과");
		vector.add("배");
		vector.add("복숭아");
		vector.add("딸기");
		vector.add("바나나");
		field = new JTextField();
		contentPane.add(field,BorderLayout.NORTH);
		
		JComboBox<String> combo = new JComboBox<String>(vector);
		combo.addActionListener(this);
			
		
		combo.setSelectedIndex(-1);
		
		contentPane.add(combo,BorderLayout.SOUTH);
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JComboBox<String> combo2 = (JComboBox<String>) e.getSource();
		if(combo2.isEnabled()) {
			
			field.setText(combo2.getSelectedItem()+"");
		}
	}

	

}
