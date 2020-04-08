package label;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.UIManager;

public class JRadioTest4 extends JFrame implements ActionListener, ItemListener{

	private JPanel contentPane;
	private ButtonGroup size, pizza, topping;
	private JRadioButton combopz, potatopz, bulgogipz, size_l, size_m, size_s, top_p, top_pp, top_c, top_b;
	private JLabel total_price;
	private JLabel lblNewLabel_1;
	private JButton cancel, check;
	private String pizza_o, topping_o, size_o;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRadioTest4 frame = new JRadioTest4();
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
	public JRadioTest4() {
		
		
		
		setTitle("피자주문");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("자바 피자에 오신 것을 환영합니다.");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\uD06C\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		combopz = new JRadioButton("콤보");
		panel_3.add(combopz);
		
		potatopz = new JRadioButton("포테이토");
		panel_3.add(potatopz);
		
		bulgogipz = new JRadioButton("불고기");
		panel_3.add(bulgogipz);
		
		combopz.addItemListener(this);
		potatopz.addItemListener(this);
		bulgogipz.addItemListener(this);
		
		pizza = new ButtonGroup();
		pizza.add(combopz);
		pizza.add(bulgogipz);
		pizza.add(potatopz);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "\uD06C\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		top_p = new JRadioButton("피망");
		panel_4.add(top_p);
		
		top_c = new JRadioButton("치즈");
		panel_4.add(top_c);
		
		top_pp = new JRadioButton("페퍼로니");
		panel_4.add(top_pp);
		
		top_b = new JRadioButton("베이컨");
		panel_4.add(top_b);
		
		top_b.addItemListener(this);
		top_c.addItemListener(this);
		top_pp.addItemListener(this);
		top_p.addItemListener(this);
		
		topping = new ButtonGroup();
		topping.add(top_pp);
		topping.add(top_b);
		topping.add(top_c);
		topping.add(top_p);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "\uD06C\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		size_s = new JRadioButton("Small");
		panel_5.add(size_s);
		
		size_m = new JRadioButton("Medium");
		panel_5.add(size_m);
		
		size_l = new JRadioButton("Large");
		panel_5.add(size_l);
		
		size_s.addItemListener(this);
		size_m.addItemListener(this);
		size_l.addItemListener(this);
		
		size = new ButtonGroup();
		size.add(size_l);
		size.add(size_s);
		size.add(size_m);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		check = new JButton("주문");
		check.addActionListener(this);
		panel_2.add(check);
		
		cancel = new JButton("취소");
		cancel.addActionListener(this);
		panel_2.add(cancel);
		
		lblNewLabel_1 = new JLabel("금액 :");
		panel_2.add(lblNewLabel_1);
		
		total_price = new JLabel("");
		panel_2.add(total_price);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		AbstractButton btn = (AbstractButton) e.getSource();
		
		if(btn==cancel) {
			pizza.clearSelection();
			topping.clearSelection();
			size.clearSelection();
			pizza_o=null;
			topping_o=null;
			size_o=null;
		}
		if(btn == check) {
			if(pizza_o==null||topping_o==null||size==null) {
				JOptionPane.showOptionDialog(this, "주문을 다시 확인해 주세요", "주문 에러", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			}
			else {
				
				JOptionPane.showOptionDialog(this, "주문내역\n종류 : "+pizza_o+"\n토핑 : "+topping_o+"\n크기 : "+size_o+"\n가격은 "+total_price.getText()+" 원 입니다. 주문하시겠습니까?", "주문 확인", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			}
		}
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		int price_size = 0;
		int price_pz = 0;
		int price_top = 0;
		int price = 0;
		
		if(combopz.isSelected()) {
			price_pz = 3000;
			pizza_o = combopz.getText();
		}else if (potatopz.isSelected()) {
			price_pz = 2000;
			pizza_o = potatopz.getText();
		}else if (bulgogipz.isSelected()) {
			price_pz = 1500;
			pizza_o = bulgogipz.getText();
		}
		
		if(size_l.isSelected()) {
			price_size = 8000;
			size_o = size_l.getText();
		}else if (size_m.isSelected()) {
			price_size = 5000;
			size_o = size_m.getText();
		}else if(size_s.isSelected()) {
			price_size = 3000;
			size_o = size_s.getText();
		}
		
		if(top_b.isSelected()) {
			price_top = 2000;
			topping_o = top_b.getText();
		}else if (top_c.isSelected()) {
			price_top = 1000;
			topping_o = top_c.getText();
		}else if (top_p.isSelected()) {
			price_top = 1000;
			topping_o = top_p.getText();
		}else if (top_pp.isSelected()) {
			price_top = 1500;
			topping_o = top_pp.getText();
		}
	
		price = price_pz + price_size + price_top;
		
		total_price.setText(""+price);
	
	}

}
