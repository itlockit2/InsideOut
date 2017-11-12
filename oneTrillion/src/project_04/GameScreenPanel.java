package project_04;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameScreenPanel extends JPanel implements Runnable {

	// 뒤로가기 버튼 이미지를 담을 수 있는 객체
	private ImageIcon backButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/backButtonImage_2.png"));
	// 게임 시작 버튼 이미지를 담을 수 있는 객체
	private ImageIcon gamePlayButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/gamePlayButton.png"));

	// 마우스가 버튼에 진입했을 때의 이미지
	private ImageIcon backButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/backButtonEnteredImage_2.png"));
	// 게임 시작 버튼에 진입했을 때의 이미지
	private ImageIcon gamePlayButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/gamePlayButtonEntered.png"));

	// JButton 구현
	private JButton backButton = new JButton(backButtonImage);
	private JButton gamePlayButton = new JButton(gamePlayButtonImage);
	
	// Thread 객체
	private Thread thread;
	
	// Ball 위치 제어를 위한 객체
	private Ball ball;

	// fadeIn과 fadeOut 을 위한 변수
	private float fadeValue;
	private boolean isFadeOut;

	// MainScreen 제어를 위한 변수
	private boolean isGameSelectScreen;
	
	// insideOut 객체를 생성해 자기 자신의 판넬을 받을 수 있도록 한다. 
	private InsideOut insideOut;

	public GameScreenPanel(InsideOut insideOut) {
		// 프레임을 매개변수로 받아 제어한다.
		this.insideOut = insideOut;
		// fadeOut값을 false로 초기화 시켜문다
		isFadeOut = false;
		// isGameSelectScreen의 값을 false로 초기화 시켜준다.
		isGameSelectScreen = false;
		// 쓰레드를 만들고 실행시켜준다.
		setThread(new Thread(this));
		// 컨테이너의 크기가 변경될때 컴포넌트들의 크기와 위치가 자동적으로 변경되는데 그걸 해제한다
		setLayout(null);
		// 게임창 크기 설정
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// 검정색 바탕에 흰색 원 이므로 검정색으로 설정
		setBackground(Color.BLACK);
		// 화면 출력 설정 기본값은 false 이므로 설정 해줘야한다.
		setVisible(true);
		// backButton의 위치 설정
		buttonSet(backButton, 80, 60, 228, 57);
		buttonSet(gamePlayButton, 600, 300, 125, 135);
	    
		
		// 메뉴바 exitButton 설정
		buttonSet(insideOut.getMenubarExitButton(),1200,0,64,28);
		// 메뉴바 설정
		add(insideOut.getMenubar());
		// x,y 좌표를 받기 위한 객체 생성
		ball = new Ball();
		/**
		 * backButton의 마우스 이벤트를 처리해준다.
		 */

		backButton.addMouseListener(new MouseAdapter() {
			/**
			 * 마우스가 아이콘 위에 있을때 이벤트 처리
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// 아이콘 이미지를 Entered 이미지로 변경
				backButton.setIcon(backButtonEnteredImage);
				// 커서 이미지도 HAND_CURSOR로 변경해서 좀더 알아보기 쉽게한다.
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// 마우스가 아이콘을 벗어 났을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				// 아이콘 이미지를 기본이미졸 변경
				backButton.setIcon(backButtonImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 마우스가 backButton 아이콘 눌렀을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				isFadeOut = true;
				isGameSelectScreen = true;
			}
		});

		/**
		 * gamePlayButton의 마우스 이벤트를 처리해준다.
		 */

		gamePlayButton.addMouseListener(new MouseAdapter() {
			/**
			 * 마우스가 아이콘 위에 있을때 이벤트 처리
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// 아이콘 이미지를 Entered 이미지로 변경
				gamePlayButton.setIcon(gamePlayButtonEnteredImage);
				// 커서 이미지도 HAND_CURSOR로 변경해서 좀더 알아보기 쉽게한다.
				gamePlayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// 마우스가 아이콘을 벗어 났을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				// 아이콘 이미지를 기본이미졸 변경
				gamePlayButton.setIcon(gamePlayButtonImage);
				gamePlayButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 마우스가 gamePlayButton 아이콘 눌렀을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				// 게임이 실행되는 이벤트
				// 게임 플레이 버튼이 사라져야 하므로 false값으로 지정을 통해 안보이게 함
				gamePlayButton.setVisible(false);
				// 쓰레드를 실행시켜 x좌표 , y좌표 변경 시작
				ball.getThread().start();
			}
		});

	}

	// 일일이 다 설정하기 힘드므로 메소드를 통해 손쉽게 버튼의 위치를 설정
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
				Thread.sleep(50);
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
				repaint();
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 페인트의 내용물을 그려주는 메소드
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// graphics를 2D로 변경
		Graphics2D g2 = (Graphics2D) g;
		// 투명도를 조절하기 위한 부분 fadeValue 가 1.0이면 불투명도 100%, 0.1이면 불투명도가 10% 이다.
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, fadeValue));
		// 안티앨리어싱 , 원이 깨지지 않게 출력
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// 흰색으로 설정
		g2.setColor(Color.WHITE);
		// 두께 설정
		g2.setStroke(new BasicStroke(8));
		// 속이 비어있는 원 , x좌표, y좌표, width, height 
		g2.drawOval(375, 100, 530, 530);
		// 안이 가득 찬 원 , ball클래스에서 제어를 통해 좌표가 변경되므로 get메소드 이용 , 우리가 조종할 객체
		g2.fillOval(ball.getX(), ball.getY() , 26, 26);
	}

	// run 함수에서 while문을 통해 계속 화면을 그려줌으로써 다음 화면으로 넘어갈 수 있게 해준다.
	@Override
	public void run() {
		fadeIn();
		while (true) {
			repaint();
			try {
				if (isFadeOut && isGameSelectScreen) {
					fadeOut();
					insideOut.changeGameSelectScreen();
					return;
				}
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

}
