package combo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class JComboTest3 extends JFrame implements ItemListener{

	private JPanel contentPane;
	private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComboTest3 frame = new JComboTest3();
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
	public JComboTest3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String items[] = {"Bird", "Cat", "Dog", "Pig", "Rabbit"};
		JComboBox<String> combo = new JComboBox<String>(items);
		combo.addItemListener(this);
		contentPane.add(combo,BorderLayout.NORTH);
		combo.setSelectedIndex(0);
		
		
		label = new JLabel("",SwingConstants.CENTER);
		label.setIcon(new ImageIcon(getClass().getResource("Bird.gif")));
		contentPane.add(label,BorderLayout.CENTER);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
//		JComboBox<String> combo2 = (JComboBox<String>) e.getSource();
//		ImageIcon icon = null;
//		
//		if(combo2.getSelectedItem()!=null) {
//			
//			
//			if(combo2.getSelectedItem()=="Bird") {
//				icon = new ImageIcon(getClass().getResource("Bird.gif"));
//				label.setIcon(icon);
//			}else if(combo2.getSelectedItem().equals("Cat")) {
//				icon = new ImageIcon(getClass().getResource("Cat.gif"));
//				label.setIcon(icon);
//			}else if(combo2.getSelectedItem().equals("Dog")) {
//				icon = new ImageIcon(getClass().getResource("dog.gif"));
//				label.setIcon(icon);
//			}else if(combo2.getSelectedItem().equals("Pig")) {
//				icon = new ImageIcon(getClass().getResource("Pig.gif"));
//				label.setIcon(icon);
//			}else if(combo2.getSelectedItem().equals("Rabbit")) {
//				icon = new ImageIcon(getClass().getResource("Rabbit.gif"));
//				label.setIcon(icon);
//			}
//		}
		
		String animal = (String)e.getItem();
		updateIcon(animal);
		
		
		
	}
	public void updateIcon(String animal) {
		ImageIcon icon = new ImageIcon(getClass().getResource(animal+".gif"));
		label.setIcon(icon);
	}

}
