package graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


//도화지 역할
class MyCanvas2 extends JPanel implements MouseMotionListener{
	private int x = 50, y = 50;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		//도화지 위에 무언인가를 그릴때 사용되는 메소드
		g.drawString("*", x, y);
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		x=e.getX();
		y=e.getY();
		repaint(); //paintComponent 호출
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	public MyCanvas2() {
		addMouseMotionListener(this);
	}
	
}

public class GraphicTest2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicTest2 frame = new GraphicTest2();
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
	public GraphicTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		add(new MyCanvas2());
	}

}
