package exam;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

class MyButton extends JButton{
	static int count = 0;
	int index;
	
	public MyButton(String str) {
		super(str);
		index=count++;
	}
}


public class Puzzle extends JFrame implements ActionListener{
	
	
	
	JPanel contentPane,buttonPane;
	MyButton btns[] = new MyButton[9];
	JButton btn_reset;
	
	public Puzzle() {
		
		setTitle("puzzle");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		
		buttonPane = new JPanel();
		buttonPane.setLayout(new GridLayout(3,3));
		
		for (int i = 0; i < btns.length-1; i++) {
			
			btns[i] = new MyButton((i+1)+"");
			btns[i].addActionListener(this);
			buttonPane.add(btns[i]);
		}
		btns[8] = new MyButton("");
		btns[8].addActionListener(this);
		buttonPane.add(btns[8]);
		contentPane.add(buttonPane);
		
		
		btn_reset = new MyButton("RESET");
		btn_reset.setForeground(Color.ORANGE);
		btn_reset.setBackground(Color.BLACK);
		btn_reset.setFont(new Font("굴림", Font.BOLD, 16));
		btn_reset.addActionListener(this);
		
		contentPane.add(btn_reset,BorderLayout.SOUTH);
		
		
		
		for(int x = 0; x < btns.length ; x++){
			int i = (int)(Math.random()*btns.length);
			int j = (int)(Math.random()*btns.length);
			
			String tmp = btns[i].getText();
			btns[i].setText(btns[j].getText());
			btns[j].setText(tmp);
		}
		
		
		
		getContentPane().add(contentPane);
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		Puzzle puz = new Puzzle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MyButton b = (MyButton) e.getSource();
		if(b.index==0) {
			if(btns[1].getText().equals("")) {
				btns[1].setText(btns[0].getText());
				btns[0].setText("");
			}else if(btns[3].getText().equals("")) {
				btns[3].setText(btns[0].getText());
				btns[0].setText("");
			}
		}else if(b.index==1) {
			if(btns[0].getText().equals("")) {
				btns[0].setText(btns[1].getText());
				btns[1].setText("");
			}else if(btns[2].getText().equals("")) {
				btns[2].setText(btns[1].getText());
				btns[1].setText("");
			}else if(btns[4].getText().equals("")) {
				btns[4].setText(btns[1].getText());
				btns[1].setText("");
			}
		}else if(b.index==2) {
			if(btns[1].getText().equals("")) {
				btns[1].setText(btns[2].getText());
				btns[2].setText("");
			}else if(btns[5].getText().equals("")) {
				btns[5].setText(btns[2].getText());
				btns[2].setText("");
			}
		}else if(b.index==3) {
			if(btns[0].getText().equals("")) {
				btns[0].setText(btns[3].getText());
				btns[3].setText("");
			}else if(btns[4].getText().equals("")) {
				btns[4].setText(btns[3].getText());
				btns[3].setText("");
			}else if(btns[6].getText().equals("")) {
				btns[6].setText(btns[3].getText());
				btns[3].setText("");
			}
		}else if(b.index==4) {
			if(btns[1].getText().equals("")) {
				btns[1].setText(btns[4].getText());
				btns[4].setText("");
			}else if(btns[3].getText().equals("")) {
				btns[3].setText(btns[4].getText());
				btns[4].setText("");
			}else if(btns[5].getText().equals("")) {
				btns[5].setText(btns[4].getText());
				btns[4].setText("");
			}else if(btns[7].getText().equals("")) {
				btns[7].setText(btns[4].getText());
				btns[4].setText("");
			}
		}else if(b.index==5) {
			if(btns[2].getText().equals("")) {
				btns[2].setText(btns[5].getText());
				btns[5].setText("");
			}else if(btns[4].getText().equals("")) {
				btns[4].setText(btns[5].getText());
				btns[5].setText("");
			}else if(btns[8].getText().equals("")) {
				btns[8].setText(btns[5].getText());
				btns[5].setText("");
			}
		}else if(b.index==6) {
			if(btns[3].getText().equals("")) {
				btns[3].setText(btns[6].getText());
				btns[6].setText("");
			}else if(btns[7].getText().equals("")) {
				btns[7].setText(btns[6].getText());
				btns[6].setText("");
			}
		}else if(b.index==7) {
			if(btns[4].getText().equals("")) {
				btns[4].setText(btns[7].getText());
				btns[7].setText("");
			}else if(btns[6].getText().equals("")) {
				btns[6].setText(btns[7].getText());
				btns[7].setText("");
			}else if(btns[8].getText().equals("")) {
				btns[8].setText(btns[7].getText());
				btns[7].setText("");
			}
		}else if(b.index==8){
			if(btns[5].getText().equals("")) {
				btns[5].setText(btns[8].getText());
				btns[8].setText("");
			}else if(btns[7].getText().equals("")) {
				btns[7].setText(btns[8].getText());
				btns[8].setText("");
			}
		}else {
			for(int x = 0; x < btns.length ; x++){
				int i = (int)(Math.random()*btns.length);
				int j = (int)(Math.random()*btns.length);
				
				String tmp = btns[i].getText();
				btns[i].setText(btns[j].getText());
				btns[j].setText(tmp);
			}
//			int r = (int)(Math.random()*8)+1;
//			btns[r].setText("");
//			
//			for (int i = 0; i < btns.length; i++) {
//				if(i==r) continue;
//				btns[i].setText(String.valueOf(i+1));
//			}
		}


		
		
	}

}
