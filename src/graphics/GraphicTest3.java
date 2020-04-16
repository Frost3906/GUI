package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

class MyCanvas3 extends JPanel{
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		//직선
		g.drawLine(20, 20, 100, 100);
		
		//타원
		g.drawOval(120, 20, 80, 80);
		g.fillOval(120, 20, 80, 80);
		
		//사각형
		g.drawRect(220, 20, 80, 80);
		g.fillRect(220, 20, 80, 80);
		
		//둥근 사각형
		g.drawRoundRect(320, 20, 120, 80, 40, 60);
		
		//입체 사각형
		g.setColor(Color.LIGHT_GRAY);
		g.draw3DRect(500, 20, 500, 100, false);
	}
}

public class GraphicTest3 extends JFrame {

	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicTest3 frame = new GraphicTest3();
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
	public GraphicTest3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		add(new MyCanvas3());
	}

}
