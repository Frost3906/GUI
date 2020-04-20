package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;


class Ship2 extends JPanel{

	private BufferedImage img, img2;
	private int posX, posY;
	
	public Ship2() {
		URL url = getClass().getResource("ship.jpg");
		URL url2 = getClass().getResource("hubble.jpg");
		try {
			img = ImageIO.read(new File(url.getFile()));
			img2 = ImageIO.read(new File(url2.getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		posX = 0;
		posY = 250;
		
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//네개의 화살표에 따라 움직이기
				
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					
					posY -= 25;
					repaint();
					break;
					
				case KeyEvent.VK_DOWN:
					posY += 25;
					repaint();
					break;
					
				case KeyEvent.VK_LEFT:
					posX -= 25;
					repaint();
					break;
					
				case KeyEvent.VK_RIGHT:
					posX += 25;
					repaint();
					break;

				default:
					break;
				}
				
			}
			
		});
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawImage(img2, 0, 0, null);
		g.drawImage(img, posX, posY, null);
	
	}


	
}

public class ShipTest2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipTest2 frame = new ShipTest2();
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
	public ShipTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 640);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		add(new Ship2());
	}

}
