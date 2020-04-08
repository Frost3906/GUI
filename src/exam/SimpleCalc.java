package exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SimpleCalc extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtOp1;
	private JTextField txtOp2;
	private JTextField txtResult;
	private JButton btnPlus, btnCancel;
	private JButton btnMinus;
	private JButton btnMul;
	private JButton btnDiv;
	private JLabel opLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalc frame = new SimpleCalc();
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
	public SimpleCalc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		txtOp1 = new JTextField();
		panel.add(txtOp1);
		txtOp1.setColumns(10);
		
		opLabel = new JLabel("?");
		panel.add(opLabel);
		
		txtOp2 = new JTextField();
		panel.add(txtOp2);
		txtOp2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("=");
		panel.add(lblNewLabel_1);
		
		txtResult = new JTextField();
		panel.add(txtResult);
		txtResult.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnPlus = new JButton("+");
		btnPlus.addActionListener(this);
		panel_1.add(btnPlus);
		
		
		btnMinus = new JButton("-");
		btnMinus.addActionListener(this);
		panel_1.add(btnMinus);
		
		btnMul = new JButton("*");
		btnMul.addActionListener(this);
		panel_1.add(btnMul);
		
		btnDiv = new JButton("/");
		btnDiv.addActionListener(this);
		panel_1.add(btnDiv);
		
		btnCancel = new JButton("reset");
		btnCancel.addActionListener(this);
		panel_1.add(btnCancel);
		
		
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton btn = (JButton)e.getSource();
		int op1 = Integer.parseInt(txtOp1.getText());
		int op2 = Integer.parseInt(txtOp2.getText());
		int result = 0;
		
		if(btn==btnPlus) {
			opLabel.setText("+");
			result = op1+op2;
		}
		else if(btn==btnMinus) {
			opLabel.setText("-");
			result = op1-op2;
		}
		else if(btn==btnMul) {
			opLabel.setText("*");
			result = op1*op2;
		}
		else if(btn==btnDiv) {
			opLabel.setText("/");
			result = op1/op2;
			
		}else {
			opLabel.setText("?");
			txtOp1.setText("");
			txtOp2.setText("");
			txtResult.setText("");
		}
		txtResult.setText(String.valueOf(result));
	}

	
	
	
}
