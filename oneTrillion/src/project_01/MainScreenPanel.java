package project_01;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainScreenPanel extends JPanel implements Runnable {

	// ��� �̹����� ���� �� �ִ� ��ü
	private Image background; // ȭ���� ��ȯ �ʿ� ���� intro ȭ�鿡 ���� ���� �����Ƿ� ���� ���� background�� ���� 
	private Image introBackgroundCircle; // ���� intro ȭ�鿡 ���� �ǹǷ� �������� ���� 

	// ��ư �̹����� ���� �� �ִ� ��ü
	private ImageIcon exitButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/exitButton.png"));
	private ImageIcon helpButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/helpButton.png"));
	private ImageIcon startButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/startButton.png"));
	private ImageIcon leftButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/leftButtonBasic.png")); // ����ȭ��, left, right��ư �̹���
	private ImageIcon rightButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/rightButtonBasic.png"));

	// ���콺�� ��ư�� ���������� �̹���
	private ImageIcon startEnteredButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/startButtonEntered.png"));
	private ImageIcon helpEnteredButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/helpButtonEntered.png"));
	private ImageIcon exitEnteredButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/exitButtonEntered.png"));
	private ImageIcon leftEnteredButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/leftButtonEntered.png"));  // ����ȭ��, left, right��ư �̹���
	private ImageIcon rightEnteredButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/rightButtonEntered.png"));

	// JButton ����
	private JButton exitButton = new JButton(exitButtonImage);
	private JButton helpButton = new JButton(helpButtonImage);
	private JButton startButton = new JButton(startButtonImage);
	private JButton leftButton = new JButton(leftButtonImage); // ����ȭ�� left, right ��ư 
	private JButton rightButton = new JButton(rightButtonImage);
    
	// ������ ���� �� �ִ� ��ü
	Music introMusic;

	// fadeIn�� fadeOut �� ���� ����
	private float fadeValue;
	
	// ���� ȭ������ �ƴ����� ���� , ó������ ���� ȭ���� �ƴϹǷ� false�� �ο� 
	private boolean isMainScreen = false; 
	
	// � ������ ���� �� �ִ� �ϳ��� �̹� ������� �迭, ������ ����� ���� �� ����  
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	// �����ϱ� ���� ArrayList ������ �־��� , selectedImage
  //private Image titleImage ; �� ���� �������� �����ô�.. 
	private Image selectedImage; // ���� ���� �� ���� �̹��� ��ü (�� ���� ȭ��)
	private Music selectedMusic; // �ڵ��� �Լ�ȭ�� ���� �ξ� �� ������ �ۼ�
	private int nowSelected = 0; // ���� ���õ� ���� �ǹ� , 0(�ε����̹Ƿ�)���� ���� 
	
	
	// Thread ��ü
	private Thread thread;

	public MainScreenPanel() {
		/**
		 * Music�� �Ű������� mp3���� �̸��� ���������� �־��ش�. ����ȭ�鿡�� ��Ʈ�ι����� ���� �ݺ� ������ �����԰� ���ÿ� ������ ���� ���
		 */
		introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
		
		// �뷡�� Ʈ���� ���߾ �߰� , ���̶���Ʈ �κ��� �ȸ��� �� �־���� , ������ ���� ��δ�� �־� ��
		// �־��� ������� �ε����� �ο� ���� 0��° �ε���
		trackList.add(new Track("Defending champion Start Image.png", "Defending champion Game image.png",
				                   "Defending Champions.mp3", "Defending Champions.mp3" ));
		// 1 ��° �ε���
		trackList.add(new Track("Sum41 Start Image.png", "Sum41 Game image.png",
                                   "Sum41 - Over My Head.mp3", "Sum41 - Over My Head.mp3" )); 
		// 2 ��° �ε���
		trackList.add(new Track("Metalika Start image.jpg", "Metalika Game image.png",
                                   "Master of puppets.mp3", "Master of puppets.mp3" )); 

		// �����̳��� ũ�Ⱑ ����ɶ� ������Ʈ���� ũ��� ��ġ�� �ڵ������� ����Ǵµ� �װ� �����Ѵ�
		setLayout(null);
		// ����â ũ�� ����
		setSize(Main.SCREENT_WIDTH, Main.SCREENT_HEIGHT);
		setBounds(0, 0, Main.SCREENT_WIDTH, Main.SCREENT_HEIGHT);
		// ���� ���ȭ�� ���� �������� ����
		setBackground(Color.BLACK);
		// ȭ�� ��� ���� �⺻���� false �̹Ƿ� ���� ������Ѵ�.
		setVisible(true);

		// Main Ŭ������ ��ġ�� ������� �ؼ� Resource�� �� �װ��� �̹������� ������ ���Խ����ش�.
		// ����̹��� , introBackground => Background�� ���� 
		background = new ImageIcon(getClass().getClassLoader().getResource("images/MainBackGround.png"))
				.getImage(); 
		introBackgroundCircle = new ImageIcon(
				getClass().getClassLoader().getResource("images/MainBackGroundCircle.gif")).getImage();
		selectedImage =  new ImageIcon(getClass().getClassLoader().getResource("images/Defending champion Start Image.png"))
				.getImage(); // ���� �����̹����� �ǹ� 
		buttonSet(startButton, 110, 450, 228, 57);
		buttonSet(helpButton, 110, 515, 183, 55);
		buttonSet(exitButton, 110, 575, 148, 53);
		buttonSet(leftButton, 140, 310, 60, 60);
		buttonSet(rightButton, 1080, 310, 60, 60);
		
		// �����带 ����� ��������ش�.
		setThread(new Thread(this));

		// startButton�� ���콺 �̺�Ʈ�� ó�����ش�.
		startButton.addMouseListener(new MouseAdapter() {

			// ���콺�� ������ ���� ������ �̺�Ʈ ó��
			@Override
			public void mouseEntered(MouseEvent e) {
				// ������ �̹����� Entered �̹����� ����
				startButton.setIcon(startEnteredButtonImage);
				// Ŀ�� �̹����� HAND_CURSOR�� �����ؼ� ���� �˾ƺ��� �����Ѵ�.
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// ���콺�� �������� ���� ������ �̺�Ʈ ó��
			@Override
			public void mouseExited(MouseEvent e) {
				// ������ �̹����� �⺻�̹��� ����
				startButton.setIcon(startButtonImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// ���콺�� startButton ������ �������� �̺�Ʈ ó��
			@Override
			public void mousePressed(MouseEvent e) {
				introMusic.close(); // ����ȭ������ �Ѿ� ���Ƿ� introMusic�� ���� �����־�� �� 
				selectTrack(0); // ����ȭ������ �Ѿ�� �� ù ��° ���� ���õǰ� �ϱ� ���� 
				startButton.setVisible(false); // ȭ���� �Ѿ� ���� �� ���۹�ư , ���� ��ư , exit ��ư�� ������ �ʰ� ����
				helpButton.setVisible(false);
				exitButton.setVisible(false);
				leftButton.setVisible(true); // ����ȭ�� �̹Ƿ� left, right��ư�� ���̰� ���־�� �� 
				rightButton.setVisible(true);
				background = new ImageIcon(getClass().getClassLoader().getResource("images/startBackGround.jpg"))
						.getImage();  // ȭ���� �Ѿ� ���� �� ����� startImage�� ���� , �ϴ�, �̰� ���� Image�� ���߿� �ٸ� �ɷ� �����սô�. 
     			introBackgroundCircle = null; // startImage���� ���ư��� ���� �ʿ� �����Ƿ� null���� ���� ������ 
     			isMainScreen = true; // start ��ư�� ���� ����ȭ������ �Ѿ�Ƿ� true�� ���� 
			}   // �뷡���� ȭ�� ���� �̺�Ʈ
		});

		/**
		 * helpButton�� ���콺 �̺�Ʈ�� ó�����ش�.
		 */
		helpButton.addMouseListener(new MouseAdapter() {
			/**
			 * ���콺�� ������ ���� ������ �̺�Ʈ ó��
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// ������ �̹����� Entered �̹����� ����
				helpButton.setIcon(helpEnteredButtonImage);
				// Ŀ�� �̹����� HAND_CURSOR�� �����ؼ� ���� �˾ƺ��� �����Ѵ�.
				helpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// ���콺�� �������� ���� ������ �̺�Ʈ ó��
			@Override
			public void mouseExited(MouseEvent e) {
				// ������ �̹����� �⺻�̹��� ����
				helpButton.setIcon(helpButtonImage);
				helpButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// ���콺�� helpButton ������ �������� �̺�Ʈ ó��
			@Override
			public void mousePressed(MouseEvent e) {
				// ���� ȭ�� ���� �̺�Ʈ
			}
		});

		/**
		 * exitButton�� ���콺 �̺�Ʈ�� ó�����ش�.
		 */
		exitButton.addMouseListener(new MouseAdapter() {
			/**
			 * ���콺�� ������ ���� ������ �̺�Ʈ ó��
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// ������ �̹����� Entered �̹����� ����
				exitButton.setIcon(exitEnteredButtonImage);
				// Ŀ�� �̹����� HAND_CURSOR�� �����ؼ� ���� �˾ƺ��� �����Ѵ�.
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// ���콺�� �������� ���� ������ �̺�Ʈ ó��
			@Override
			public void mouseExited(MouseEvent e) {
				// ������ �̹����� �⺻�̹��� ����
				exitButton.setIcon(exitButtonImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// ���콺�� exitButton ������ �������� �̺�Ʈ ó�� => ����
			@Override
			public void mousePressed(MouseEvent e) {
				// �������� �̺�Ʈ
				System.exit(0);
			}
		});
		
		/**
		 * leftButton�� ���콺 �̺�Ʈ�� ó�����ش�.
		 */
		leftButton.setVisible(false); // ó������ ������ �ʵ��� �� , start ��ư�� ������ �� ���̰� �� ��  
		leftButton.addMouseListener(new MouseAdapter() {
			/**
			 * ���콺�� ������ ���� ������ �̺�Ʈ ó��
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// ������ �̹����� Entered �̹����� ����
				leftButton.setIcon(leftEnteredButtonImage);
				// Ŀ�� �̹����� HAND_CURSOR�� �����ؼ� ���� �˾ƺ��� �����Ѵ�.
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// ���콺�� �������� ���� ������ �̺�Ʈ ó��
			@Override
			public void mouseExited(MouseEvent e) {
				// ������ �̹����� �⺻�̹��� ����
				leftButton.setIcon(leftButtonImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// ���콺�� leftButton ������ �������� �̺�Ʈ ó��
			@Override
			public void mousePressed(MouseEvent e) {
				selectLeft();
			}
		});
		
		/**
		 * rightButton�� ���콺 �̺�Ʈ�� ó�����ش�.
		 */
		rightButton.setVisible(false); // ó������ ������ �ʵ��� ��, start ��ư�� ������ �� ���̰� �� ��  
		rightButton.addMouseListener(new MouseAdapter() {
			/**
			 * ���콺�� ������ ���� ������ �̺�Ʈ ó��
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// ������ �̹����� Entered �̹����� ����
				rightButton.setIcon(rightEnteredButtonImage);
				// Ŀ�� �̹����� HAND_CURSOR�� �����ؼ� ���� �˾ƺ��� �����Ѵ�.
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// ���콺�� �������� ���� ������ �̺�Ʈ ó��
			@Override
			public void mouseExited(MouseEvent e) {
				// ������ �̹����� �⺻�̹��� ����
				rightButton.setIcon(rightButtonImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// ���콺�� rightButton ������ �������� �̺�Ʈ ó��
			@Override
			public void mousePressed(MouseEvent e) {
				selectRight();
			}
		});
		

	}


	
	

	/**
	 * ��ư ���� �޼ҵ� ��� ��ư���� �������� �ֱ� �������Ƿ� �޼ҵ�� �������.
	 * 
	 * @param button
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void buttonSet(JButton button, int x, int y, int width, int height) {
		button.setBounds(x, y, width, height);
		// ��ư �׵θ� ����
		button.setBorderPainted(false);
		// ������ ���� ����
		button.setContentAreaFilled(false);
		// �۾� �׵θ� ����
		button.setFocusPainted(false);
		// ��ư �߰�
		add(button);
	}

	/**
	 * fadeIn ȿ���� �ֱ����� �޼ҵ� temp�� ����� ������ fadeIn���� 1.0�� �Ѿ�� ������ �߻��ϱ� ������ float���� Ư����
	 * 0.1�� 10�� ������Ű�� 1.0�� �ƴ϶� 1.000001�� �Ǽ� ������ �߻��Ѵ�. ���� temp�� ������Ű�� fadeIn�� ���Խ�Ű��
	 * ����� ����Ѵ�. ���⼭ temp�� 1���� Ŀ���� temp�� 1�� �����ϰ� ���Խ����ش�.
	 */
	public void fadeIn() {
		try {
			float temp = 0;
			fadeValue = 0;
			while (fadeValue < 1) {
				temp += 0.1;
				if (temp > 1) {
					temp = 1.0f;
				}
				fadeValue = temp;
				repaint();

				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void fadeOut() {
		try {
			float temp = 1.0f;
			fadeValue = 1.0f;
			while (fadeValue > 0) {
				temp -= 0.1;
				if (temp < 0) {
					temp = 0;
				}
				fadeValue = temp;

				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// graphics�� 2D�� ����
		Graphics2D g2 = (Graphics2D) g;
		// ������ �����ϱ� ���� �κ� fadeValue �� 1.0�̸� ������ 100%, 0.1�̸� �������� 10% �̴�.
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, fadeValue));
		g2.drawImage(introBackgroundCircle, 275, 30, 1200, 676, null);
		g2.drawImage(background, 0, 0, null);
		// MainScreen���� �Ѿ� �� ��� �Ʒ��� �̹����� ������ ��ġ�� ��� ,�̽����� ....  
		if (isMainScreen) {
			g2.drawImage(selectedImage, 340, 100, null);
		}
	}

	@Override
	public void run() {
		// fadeIn ȿ���� �־��ش�.
		fadeIn();
		while (true) {
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}
    
	// ���� ���õ� � ��ȣ�� �־� �����ν� �ش� ���� ���õǾ����� �˷��� 
	public void selectTrack(int nowSelected) {
	      if(selectedMusic != null) {
	    	  selectedMusic.close(); // � ���� ����ǰ� �ִٸ� �� ���� �ٷ� ����
	    	  selectedImage = new ImageIcon(getClass().getClassLoader().getResource("images/" + trackList.get(nowSelected).getStartImage()))
	  				.getImage(); // ���� ���õ� ���� �� � ���� �̹����� �ٲپ� �� 
	    	  selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true); // ���õ� ���� ������ , true�� ���� ���  
	    	  selectedMusic.start(); // ���õ� ���� ���� 
	      }
	}
	// ���� ȭ�鿡�� ���� ��ư�� ������ ���� �̺�Ʈ 
	public void selectLeft() {
	// ����, ù ��° ���� ��ġ�� �����Ƿ� ���ʹ�ư�� ������ ���� ���������� �����ϹǷ� ũ�⿡�� 1�� ���ش�.
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1;
		
		// 0�� �ƴѰ�� �ϳ��� ��� �������� �̵��ϸ� �ȴ�.
		else 
			nowSelected--;
		
		selectTrack(nowSelected);
	}
	
	// ���� ȭ�鿡�� ������ ��ư�� ������ ���� �̺�Ʈ 
		public void selectRight() {
	  // ���� ��ġ�� ���� �����ʿ� �ִٸ� ù ��° ������ �̵��ϵ��� ���� 
			if(nowSelected == trackList.size()-1 ) 
				nowSelected = 0;
			
			// 0�� �ƴѰ�� �ϳ��� ���ؼ� ���������� �̵���Ŵ
			else 
				nowSelected++;
			
			selectTrack(nowSelected);
		}
}
