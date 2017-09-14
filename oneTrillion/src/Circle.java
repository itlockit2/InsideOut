import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Circle extends JFrame {

	Container contentpane;
	MainPanel mainPanel;
		
	public Circle() {
		setTitle("Circle");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentpane = getContentPane();
		setSize(500, 550);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);		
		setVisible(true);
		mainPanel = new MainPanel();
		contentpane.add(mainPanel);
		
		KeyListener keyListener = new KeyListener(mainPanel);
		addKeyListener(keyListener);
	}
	
	public static void main(String[] args) {
		new Circle();

	}

}

class MainPanel extends JPanel implements Runnable {
	
	CirclePoint CP;
	int r = 150;
	double se = 1.0;
	
	Thread thread;
	
	public MainPanel() {
		setLayout(null);
		setSize(500, 500);
		setBounds(0, 0, 500, 500);
		setBackground(Color.WHITE);
		setVisible(true);
		CP = new CirclePoint(150, 250, 250, 0);	
		add(CP);
		thread = new Thread(this);
		thread.start();
		
	}
	
	public void run() {
		try {
			CP.thread.start();
			System.out.println("CP START!");
			while(true) {
				for(int i = 0; i < 50; i++) {
					CP.r++;
					repaint();
					Thread.sleep((long)(se * 10));
				}
				for(int i = 0; i < 50; i++) {
					CP.r--;
					repaint();
					Thread.sleep((long)(se * 10));
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawOval(CP.Ox - CP.r, CP.Oy - CP.r, 2 * CP.r, 2 * CP.r); // ¿ø Áß½É 250, 250 r = 150
		g2.fillOval(CP.Ox - CP.r, CP.Oy - CP.r, 2 * CP.r, 2 * CP.r);
		g2.setColor(Color.WHITE);
		g2.drawOval(CP.Ox - (CP.r - 10), CP.Oy - (CP.r - 10), 2 * (CP.r - 10), 2 * (CP.r - 10));
		g2.fillOval(CP.Ox - (CP.r - 10), CP.Oy - (CP.r - 10), 2 * (CP.r - 10), 2 * (CP.r - 10));
		

	}
}

class CirclePoint extends JLabel implements Runnable {
	int x, y, Ox, Oy, r;
	double th;
	Thread thread;
	boolean pointIn = false;

	
	public CirclePoint(int r, int Ox, int Oy, float t) {
		setLayout(null);
		setSize(6, 6);
		this.r = r;
		this.Ox = Ox;
		this.Oy = Oy;
		this.th = t;
		this.x = Ox + (int)((r + 7) * Math.sin(th / 180 * Math.PI));
		this.y = Oy + (int)((r + 7) * Math.cos(th / 180 * Math.PI));
		setBounds(x - 7, y - 7, 14, 14);
		setVisible(true);		
		thread = new Thread(this);
	}
	
	public void setTH(double t) {
		this.th = t;
	}

	public void run() {
		try {
			while(true) {
				th -= 1;
				if(pointIn == false) {
					this.x = Ox + (int)((r + 7) * Math.sin(th / 180 * Math.PI));
					this.y = Oy + (int)((r + 7) * Math.cos(th / 180 * Math.PI));
					setLocation(x - 7, y - 7);
					System.out.println(x + " " + y);
					Thread.sleep(10);
				} else {
					this.x = Ox + (int)((r - 17) * Math.sin(th / 180 * Math.PI));
					this.y = Oy + (int)((r - 17) * Math.cos(th / 180 * Math.PI));
					setLocation(x - 7, y - 7);
					System.out.println(x + " " + y);
					Thread.sleep(10);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		g2.drawOval(0, 0, 14, 14);
		g2.fillOval(0, 0, 14, 14);
	}


}

class KeyListener extends KeyAdapter {
	
	MainPanel main;
	
	public KeyListener(MainPanel main) {
		this.main = main;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(main.CP.pointIn == false) {
				main.CP.pointIn = true;
			} else {
				main.CP.pointIn = false;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_0) {
			main.se = 1.0;
		}
		else if(e.getKeyCode() == KeyEvent.VK_1) {
			main.se = 0.1;
		}
		else if(e.getKeyCode() == KeyEvent.VK_2) {
			main.se = 0.2;
		}
		else if(e.getKeyCode() == KeyEvent.VK_3) {
			main.se = 0.3;
		}
		else if(e.getKeyCode() == KeyEvent.VK_4) {
			main.se = 0.4;
		}
		else if(e.getKeyCode() == KeyEvent.VK_5) {
			main.se = 0.5;
		}
		else if(e.getKeyCode() == KeyEvent.VK_6) {
			main.se = 0.6;
		}
		else if(e.getKeyCode() == KeyEvent.VK_7) {
			main.se = 0.7;
		}
		else if(e.getKeyCode() == KeyEvent.VK_8) {
			main.se = 0.8;
		}
		else if(e.getKeyCode() == KeyEvent.VK_9) {
			main.se = 0.9;
		}
	}
}