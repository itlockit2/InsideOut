package project;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 게임의 전반적인 컨트롤을 해주는 클래스이다.
 * 
 * @author Yun
 *
 */
public class InsideOut extends JFrame {
	// 더블 버퍼링을 위해 전체 화면의 이미지를 담는 두 인스턴스 (screenImage, screenGraphic) import 필요
	private Image screenImage;
	private Graphics screenGraphic;

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

	public InsideOut() {
		// 시작화면에서 인트로뮤직이 무한 반복
		// 게임이 시작함과 동시에 음악이 무한 재생
		introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
		// 게임이름 설정
		setTitle("Inside Out");
		// 게임창 크기 설정
		setSize(Main.SCREENT_WIDTH, Main.SCREENT_HEIGHT);
		// 메뉴바가 보이지 않게끔 설정
		setUndecorated(true);
		// 사용자가 게임창을 임의로 줄이고 하는게 불가능, true로 하면 가능
		setResizable(false);
		// 게임창이 정 중앙에 출력
		setLocationRelativeTo(null);
		// 게임을 끄면 완전히 종료, 반드시 필요한 함수
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 화면 출력 설정 기본값은 false 이므로 설정 해줘야한다.
		setVisible(true);
		// paintComponent로 그릴때 배경색을 회색으로 지정
		setBackground(new Color(0, 0, 0, 0));
		// 컨테이너의 크기가 변경될때 컴포넌트들의 크기와 위치가 자동적으로 변경되는데 그걸 해제한다.
		setLayout(null);

		// Main 클래스의 위치를 기반으로 해서 Resource를 얻어서 그것의 이미지값을 변수에 대입시켜준다.
		// 배경이미지
		introBackground = new ImageIcon(getClass().getClassLoader().getResource("images/MainBackGround.png"))
				.getImage();
		introBackgroundCircle = new ImageIcon(
				getClass().getClassLoader().getResource("images/MainBackGroundCircle.gif")).getImage();
		buttonSet(startButton, 120, 450, 218, 38);
		buttonSet(helpButton, 95, 505, 218, 38);
		buttonSet(exitButton, 80, 565, 218, 38);

		// fadeIn 메소드 실행
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
	 * fadeIn 효과를 주기위한 메소드
	 * temp를 사용한 이유는 fadeIn값이 1.0을 넘어가면 에러가 발생하기 때문에
	 * float연산 특성상 0.1씩 10번 증가시키면 1.0이 아니라 1.000001이 되서 에러가 발생한다.
	 * 따라서 temp를 증가시키고 fadeIn에 대입시키는 방식을 사용한다.
	 * 여기서 temp가 1보다 커지면 temp를 1로 설정하고 대입시켜준다.
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
			if( temp < 0) {
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

	/**
	 * 하나의 약속된 즉 정의되어 있는 메소드이다. paint 메소드는 JFrame을 상속한 클래스에서 가장 첫번째로 화면을 그려주는 메소드이다.
	 */
	public void paint(Graphics g) {
		// 1280 x 720 만큼의 이미지를 생성뒤 넣어줌
		screenImage = createImage(Main.SCREENT_WIDTH, Main.SCREENT_HEIGHT);
		// screenImage 에서 그래픽값을 얻어서 변수에 대입
		screenGraphic = screenImage.getGraphics();
		/**
		 * screenDraw 함수를 통해서 그래픽 값을 screenGraphic에 그린다. Graphics2D로 변경해야 글씨가 깨지지 않는다.
		 */
		screenDraw((Graphics2D) screenGraphic);
		// screenImage 즉 screenDraw에서 그린 이미지를 화면에 띄워준다.
		g.drawImage(screenImage, 0, 0, null); // 화면에 스크린 이미지가 그려짐
	}

	/**
	 * mainScreen을 0,0에 그려준다. g.drawImage는 역동적인 그림을 그릴때 사용하고 항상 존재해야하는 그림은 항상 존재해야하는
	 * 그림은 paintComponents를 이용해서 그린다. paintComponents를 이용해서 그린다.
	 * 
	 * @param g
	 */
	public void screenDraw(Graphics2D g) {
		// 투명도를 조절하기 위한 부분 fadeValue 가 1.0이면 불투명도 100%, 0.1이면 불투명도가 10% 이다. 
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, fadeValue));
		g.drawImage(introBackgroundCircle, 275, 30, 1200, 676, null);
		g.drawImage(introBackground, 0, 0, null);

		paintComponents(g);

		// 다시 paint메소드를 호출한다
		this.repaint(); // 다시 페인트 함수를 불러옴 , 전체 이미지를 계속 반복하며 그려줌
	}
}
