package table;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.MemberDAO;
import database.MemberVO;

import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;




public class MemberTable extends JFrame {

	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_age;
	private JTextField txt_gender;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_1;

	private MemberDAO dao;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberTable frame = new MemberTable();
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
	public MemberTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//DB객체 생성
		dao = new MemberDAO();
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("회원등록", null, panel, null);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("이름");
		panel.add(lblNewLabel);
		
		txt_name = new JTextField();
		panel.add(txt_name);
		txt_name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("나이");
		panel.add(lblNewLabel_1);
		
		txt_age = new JTextField();
		panel.add(txt_age);
		txt_age.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("성별");
		panel.add(lblNewLabel_2);
		
		txt_gender = new JTextField();
		panel.add(txt_gender);
		txt_gender.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("회원조회", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("회원번호");
		panel_4.add(lblNewLabel_3);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("조회");
		panel_4.add(btnNewButton);
		
		table = new JTable();
		panel_1.add(table, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("회원수정", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		textField_1 = new JTextField();
		textField_1.setText("수정할 회원 정보 입력");
		panel_2.add(textField_1, BorderLayout.NORTH);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("수정");
		panel_2.add(btnNewButton_1, BorderLayout.SOUTH);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("번호");
		panel_5.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		panel_5.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("나이");
		panel_5.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("회원삭제", null, panel_3, null);
		
		JLabel lblNewLabel_6 = new JLabel("회원번호");
		panel_3.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("삭제");
		panel_3.add(btnNewButton_2);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("회원전체조회", null, panel_6, null);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_6.add(scrollPane, BorderLayout.CENTER);
		
		
		//memberTBL의 전체 내용 가져오기
		String columnNames[] = { "번호","이름","나이","성별"};
		model = new DefaultTableModel(columnNames,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		
		table_1 = new JTable(model);
		list();
		scrollPane.setViewportView(table_1);
	}
	
	public void list() {
		Vector<MemberVO> vecList = dao.getList();
		
		//vecList에 들어있는 값을 table에 보여주기
		for (MemberVO vo : vecList) {
			Object[] objList = {vo.getNo(),vo.getName(),vo.getAge(),vo.getGender()};
			model.addRow(objList);
		}
		
	}
}
