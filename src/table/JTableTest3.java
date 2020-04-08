package table;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableTest3 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_age;
	private JTextField tf_s;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableTest3 frame = new JTableTest3();
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
	public JTableTest3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel lb_name = new JLabel("이름");
		panel.add(lb_name);
		
		tf_name = new JTextField();
		panel.add(tf_name);
		tf_name.setColumns(5);
		
		JLabel lb_age = new JLabel("나이");
		panel.add(lb_age);
		
		tf_age = new JTextField();
		tf_age.setColumns(5);
		panel.add(tf_age);
		
		JLabel lb_s = new JLabel("성별");
		panel.add(lb_s);
		
		tf_s = new JTextField();
		tf_s.setColumns(5);
		panel.add(tf_s);
		
		JButton btn_submit = new JButton("입력");
		btn_submit.addActionListener(this);
		panel.add(btn_submit);
		
		JButton btn_del = new JButton("삭제");
		btn_del.addActionListener(this);
		panel.add(btn_del);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		
		//컬럼명 작성
		String columnNames[] = {"이름","나이","성별"};
		model = new DefaultTableModel(columnNames,0);
		table = new JTable(model);
		scrollPane.setViewportView(table);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Action action = null;
		
		String cmd = e.getActionCommand();
		
		if(cmd.equals("입력")) {
		//사용자가 입력한 이름 나이 성별가져오기
		String name,gender;
		int age;
		
		name = tf_name.getText();
		age = Integer.parseInt(tf_age.getText());
		gender = tf_s.getText();
		
		//모델에 추가하기
		
		model = (DefaultTableModel)table.getModel();
		Object rowData[] = {name,age,gender};
//		Vector<String> rowData = new Vector<String>(); //전부다 String으로 받을때 가능
														//아니면 age를 String으로 변환해서 받으면 되는데 그러면 2중수고
//		rowData.add(name);
//		rowData.add(age);
//		rowData.add(gender);
		
		model.addRow(rowData);
		
		
		//다른 데이터를 입력할 수 있도록 기존 데이터 삭제
	
		tf_name.setText("");
		tf_age.setText("");
		tf_s.setText("");
		
		System.out.println(model.get);
		
		
		}else {//삭제
			int selectRow = table.getSelectedRow();
			model.removeRow(selectRow);
		}
	}

}
