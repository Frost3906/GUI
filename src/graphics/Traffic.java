package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;


class MyCanvas extends JPanel implements ActionListener{
	
	private JButton btn;
	private int lightnumber = 0;
	
	public MyCanvas() {
		btn = new JButton("traffic light turn on");
		btn.addActionListener(this);
		add(btn, BorderLayout.SOUTH);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawOval(50, 50, 100, 100);
		g.drawOval(170, 50, 100, 100);
		g.drawOval(290, 50, 100, 100);
	
		if(lightnumber==0) {
			g.setColor(Color.red);
			g.fillOval(50, 50, 100, 100);
		}else if(lightnumber==1) {
			g.setColor(Color.GREEN);
			g.fillOval(170, 50, 100, 100);
		}else {
			g.setColor(Color.blue);
			g.fillOval(290, 50, 100, 100);
		}
	
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn) {
			if(++lightnumber>2) {
				lightnumber=0;
			}
			repaint();
		}
	}
	
	
}

public class Traffic extends JFrame{

	private JPanel contentPane;
	private JButton btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Traffic frame = new Traffic();
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
	public Traffic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		getContentPane().add(new MyCanvas());
		
		
	}

	

}
