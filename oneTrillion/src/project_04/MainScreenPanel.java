package project_04;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** 게임의 MainScreen 즉, 시작 화면에 대한 정보를 담고있는 클래스
 *  
 *  @author Jimin Kim
 *  @version 0.4
 *
 */

public class MainScreenPanel extends JPanel implements Runnable {

	
	/** 시작 화면의 배경 이미지를 담는 객체 */
	private Image introBackground;
	/** 시작 화면의 배경 이미지(원)를 담는 객체 */
	private Image introBackgroundCircle;

	/** 시작 화면의 exitButton 이미지를 담는 객체 */
	private ImageIcon exitButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/exitButton.png"));
	/** 시작 화면의 helpButton 이미지를 담는 객체 */
	private ImageIcon helpButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/helpButton.png"));
	/** 시작 화면의 startButton 이미지를 담는 객체 */
	private ImageIcon startButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/startButton.png"));

	/** 마우스가 버튼에 올라 갔을 때에 대한 exitButton 이미지를 담는 객체 */
	private ImageIcon exitEnteredButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/exitButtonEntered.png"));
	/** 마우스가 버튼에 올라 갔을 때에 대한 helpButton 이미지를 담는 객체 */
	private ImageIcon helpEnteredButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/helpButtonEntered.png"));
	/** 마우스가 버튼에 올라 갔을 때에 대한 startButton 이미지를 담는 객체 */
	private ImageIcon startEnteredButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/startButtonEntered.png"));

	
	/** Exit JButton 객체 구현 */
	private JButton exitButton = new JButton(exitButtonImage);
	/** Help JButton 객체 구현 */
	private JButton helpButton = new JButton(helpButtonImage);
	/** Start JButton 객체 구현 */
	private JButton startButton = new JButton(startButtonImage);
	
	/** 시작 화면을 실행하면 실행되는 음악을 담을 수 있는 객체 */
	private Music introMusic;
	
	/** 음악이 화면 전환 등에 의해 정지 되었을 때 그 값을 저장하기 위한 변수 */
	private int stopPoint;

	/** fadeIn과 밝기 조절을 위한 변수 */
	private float fadeValue;
	/** fadeOut의 밝기 조절을 위한 변수 */
	private boolean isFadeOut;

	/** GameSelectScreen 전환을 제어할 boolean변수 */
	private boolean isGameSelectScreen ;
	/** HelpScreen 전환을 제어할 boolean변수 */
	private boolean isHelpScreen ;

	/** 화면 전환과 실행되는 Music 대한 제어를 수행하기 위한 Thread 객체*/
	private Thread thread;

	/** 프레임을 매개변수로 넘기기 위한 InsideOut 객체 */
	private InsideOut insideOut;
	
	/** 시작화면인 MainScreen의 구성 요소 및 정보를 담고 있는 생성자
	 * 
	 * @param insideOut
	 * @param stopPoint 
	 * */
	public MainScreenPanel(InsideOut insideOut, int stopPoint) 	{
		// 프레임을 매개변수로 받아 제어한다.
		this.insideOut = insideOut;
		// fadeOut의 값을 false로 초기화 시켜준다.
		isFadeOut = false;

		//stopPoint를 초기화 시켜준다
		this.stopPoint = stopPoint;
		
		// Music의 매개변수로 mp3파일 이름과 루프유무와 스타팅 포인트를 넣어준다. 시작화면에서 인트로뮤직이 무한 반복 게임이 시작함과 동시에 음악이 무한 재생
		introMusic = new Music("introMusic.mp3", true, stopPoint);
		introMusic.start();
		
		// isGameSelectScreen의 값을 false로 초기화 시켜준다.
		isGameSelectScreen = false;
		// isHelpScreen의 값을 false로 초기화 시켜준다.
		isHelpScreen = false;
		// 컨테이너의 크기가 변경될때 컴포넌트들의 크기와 위치가 자동적으로 변경되는데 그걸 해제한다
		setLayout(null);
		// 게임창 크기 설정
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// 게임 배경화면 색깔 검정으로 지정
		setBackground(Color.BLACK);
		// 화면 출력 설정 기본값은 false 이므로 설정 해줘야한다.
		setVisible(true);

		// Main 클래스의 위치를 기반으로 해서 Resource를 얻어서 그것의 이미지값을 변수에 대입시켜준다.
		// 배경이미지 , introBackground => Background로 변경
		introBackground = new ImageIcon(getClass().getClassLoader().getResource("images/MainBackGround.png"))
				.getImage();
		introBackgroundCircle = new ImageIcon(
				getClass().getClassLoader().getResource("images/MainBackGroundCircle.gif")).getImage();
		

		// 버튼들을 미리 설정해놓은 buttonSet 메소드를 통해 추가
		buttonSet(startButton, 110, 450, 228, 57);
		buttonSet(helpButton, 110, 515, 183, 55);
		buttonSet(exitButton, 110, 575, 148, 53);
		

		// 메뉴바 exitButton 설정
		buttonSet(insideOut.getMenubarExitButton(), 1200, 0, 64, 28);
		// 메뉴바 설정
		add(insideOut.getMenubar());

		// 쓰레드를 만들고 실행시켜준다.
		setThread(new Thread(this));

		// startButton의 마우스 이벤트를 처리해준다.
		startButton.addMouseListener(new MouseAdapter() {

			// 마우스가 아이콘 위에 있을때 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {
				// 아이콘 이미지를 Entered 이미지로 변경
				startButton.setIcon(startEnteredButtonImage);
				// 커서 이미지도 HAND_CURSOR로 변경해서 좀더 알아보기 쉽게한다.
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// 마우스가 아이콘을 벗어 났을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				// 아이콘 이미지를 기본이미졸 변경
				startButton.setIcon(startButtonImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 마우스가 startButton 아이콘 눌렀을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				isFadeOut = true;
				isGameSelectScreen = true;

			}
		});

		/**
		 * helpButton의 마우스 이벤트를 처리해준다.
		 */
		helpButton.addMouseListener(new MouseAdapter() {
			/**
			 * 마우스가 아이콘 위에 있을때 이벤트 처리
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// 아이콘 이미지를 Entered 이미지로 변경
				helpButton.setIcon(helpEnteredButtonImage);
				// 커서 이미지도 HAND_CURSOR로 변경해서 좀더 알아보기 쉽게한다.
				helpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// 마우스가 아이콘을 벗어 났을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				// 아이콘 이미지를 기본이미졸 변경
				helpButton.setIcon(helpButtonImage);
				helpButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 마우스가 helpButton 아이콘 눌렀을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				// 도움말 화면 변경 이벤트
				isFadeOut = true;
				isHelpScreen = true;
			}
		});

		/**
		 * exitButton의 마우스 이벤트를 처리해준다.
		 */
		exitButton.addMouseListener(new MouseAdapter() {
			/**
			 * 마우스가 아이콘 위에 있을때 이벤트 처리
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// 아이콘 이미지를 Entered 이미지로 변경
				exitButton.setIcon(exitEnteredButtonImage);
				// 커서 이미지도 HAND_CURSOR로 변경해서 좀더 알아보기 쉽게한다.
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// 마우스가 아이콘을 벗어 났을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				// 아이콘 이미지를 기본이미졸 변경
				exitButton.setIcon(exitButtonImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 마우스가 exitButton 아이콘 눌렀을때 이벤트 처리 => 종료
			@Override
			public void mousePressed(MouseEvent e) {
				// 게임종료 이벤트
				System.exit(0);
			}
		});
	}

	/** JButton의 위치나 다른 요소들을 제어하기 위한 함수
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

	/** fadeIn 효과를 설정하기 위한 함수
	 * 
	 * temp를 사용한 이유는 fadeIn값이 1.0을 넘어가면 에러가 발생한다.
	 * 하지만 float연산 특성상 0.1씩 10번 증가시키면 1.0이 아니라 1.000001이 되기 때문에 에러가 발생한다.
	 * 따라서 temp를 증가시키고 fadeIn에 대입시키는 방식을 사용한다. 여기서 temp가 1보다 커지면 temp를 1로 설정하고 대입시켜준다.
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
	
	/** fadeOut 효과를 설정하기 위한 함수
	 * 
	 * 마찬가지로, float연산의 특성상 0이하로 내려가게 되면 0이 아닌 값이 나오기 때문에 0보다 작아지면 0으로 설정한다.
	 */
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
	
    /** MainScreen의 배경 이미지를 그려주거나 투명도를 조정해 주는 paint함수 
     * 
     * @param g
     * */
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
	
    /** 시작화면(MainScreenPanel)의 Thread가 실행 될 시 수행되는 함수 */
	@Override
	public void run() {
		// fadeIn 효과를 넣어준다.
		fadeIn();
    while (true) {
			try {
				if (isFadeOut && isGameSelectScreen) {
					fadeOut();
					// 화면이 넘어갔으므로 introMusic을 종료시킨다. 또한, fadeOut()을 한 후의 music 종료가 가장 깔끔하다고 생각되므로
					// 위치를 fadeOut()다음으로 설정
					// 또한, 깔끔한 코딩을 위해 쓰레드의 run함수에서 종료시켰다.
					introMusic.close();
					insideOut.changeGameSelectScreen();
					return;
				} 
				else if(isFadeOut && isHelpScreen) {
					fadeOut();
					// 음악 진행을 받아서 실행
					introMusic.getPlayer().stop();
					stopPoint = introMusic.getPausedOnFrame();
					introMusic.close();
					insideOut.changeHelpScreen(stopPoint);
					return;
				}
				repaint();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
    
	/** 시작 화면의 Thread를 얻어오는 함수
	 * 
	 * @return thread
	 */
	public Thread getThread() {
		return thread;
	}

	/** 시작 화면의 Thread를 설정하는 함수
	 * 
	 * @param thread
	 */
	public void setThread(Thread thread) {
		this.thread = thread;
	}

}
