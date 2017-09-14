package project_01;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainScreenPanel extends JPanel implements Runnable{

	// 배경 이미지를 담을 수 있는 객체
	private Image introBackground;
	private Image introBackgroundCircle;

	// 버튼 이미지를 담을 수 있는 객체
	private ImageIcon exitButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/exitButton.png"));
	private ImageIcon helpButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/helpButton.png"));
	private ImageIcon startButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/startButton.png"));

	// 버튼
	private JButton exitButton = new JButton(exitButtonImage);
	private JButton helpButton = new JButton(helpButtonImage);
	private JButton startButton = new JButton(startButtonImage);

	// 음악을 담을 수 있는 객체
	Music introMusic;

	// fadeIn과 fadeOut 을 위한 변수
	private float fadeValue;
	
	// Thread 객체
	private Thread thread;

	public MainScreenPanel() {
		/**
		 *  Music의 매개변수로 mp3파일 이름과 루프유무를 넣어준다.
		 *  시작화면에서 인트로뮤직이 무한 반복
		 *  게임이 시작함과 동시에 음악이 무한 재생
		 */
		introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
		
		// 컨테이너의 크기가 변경될때 컴포넌트들의 크기와 위치가 자동적으로 변경되는데 그걸 해제한다
		setLayout(null);
		// 게임창 크기 설정
		setSize(Main.SCREENT_WIDTH, Main.SCREENT_HEIGHT);
		setBounds(0, 0, Main.SCREENT_WIDTH, Main.SCREENT_HEIGHT);
		// 게임 배경화면 색깔 검정으로 지정
		setBackground(Color.BLACK);
		// 화면 출력 설정 기본값은 false 이므로 설정 해줘야한다.
		setVisible(true);
		

		// Main 클래스의 위치를 기반으로 해서 Resource를 얻어서 그것의 이미지값을 변수에 대입시켜준다.
		// 배경이미지
		introBackground = new ImageIcon(getClass().getClassLoader().getResource("images/MainBackGround.png"))
				.getImage();
		introBackgroundCircle = new ImageIcon(
				getClass().getClassLoader().getResource("images/MainBackGroundCircle.gif")).getImage();
		buttonSet(startButton, 120, 450, 218, 38);
		buttonSet(helpButton, 95, 505, 218, 38);
		buttonSet(exitButton, 80, 565, 218, 38);
		
		// 쓰레드를 만들고 실행시켜준다.
		thread = new Thread(this);
		thread.start();
		
		// fadeIn 효과를 넣어준다.
		fadeIn();
		
	}

	/**
	 * 버튼 셋팅 메소드 모든 버튼마다 설정값을 넣기 귀찮으므로 메소드로 만들었다.
	 * 
	 * @param button
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void buttonSet(JButton button, int x, int y, int width, int height) {
		button.setBounds(x, y, width, height);
		// 버튼 테두리 제거
		button.setBorderPainted(false);
		// 누르는 느낌 제거
		button.setContentAreaFilled(false);
		// 글씨 테두리 제거
		button.setFocusPainted(false);
		// 버튼 추가
		add(button);
	}

	/**
	 * fadeIn 효과를 주기위한 메소드 temp를 사용한 이유는 fadeIn값이 1.0을 넘어가면 에러가 발생하기 때문에 float연산 특성상
	 * 0.1씩 10번 증가시키면 1.0이 아니라 1.000001이 되서 에러가 발생한다. 따라서 temp를 증가시키고 fadeIn에 대입시키는
	 * 방식을 사용한다. 여기서 temp가 1보다 커지면 temp를 1로 설정하고 대입시켜준다.
	 */
	public void fadeIn() {
		float temp = 0;
		fadeValue = 0;
		while (fadeValue < 1) {
			temp += 0.1;
			if (temp > 1) {
				temp = 1.0f;
			}
			fadeValue = temp;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void fadeOut() {
		float temp = 1.0f;
		fadeValue = 1.0f;
		while (fadeValue > 0) {
			temp -= 0.1;
			if (temp < 0) {
				temp = 0;
			}
			fadeValue = temp;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// graphics를 2D로 변경
		Graphics2D g2 = (Graphics2D) g;	
		// 투명도를 조절하기 위한 부분 fadeValue 가 1.0이면 불투명도 100%, 0.1이면 불투명도가 10% 이다.
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, fadeValue));
		g2.drawImage(introBackgroundCircle, 275, 30, 1200, 676, null);
		g2.drawImage(introBackground, 0, 0, null);
	}

	@Override
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}
