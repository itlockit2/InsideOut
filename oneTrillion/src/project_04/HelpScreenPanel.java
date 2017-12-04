package project_04;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/** 게임을 어떻게 진행해야 하는지 알려주는 클래스
 *  
 *  @author Jimin Kim
 *  @version 0.4
 */
public class HelpScreenPanel extends JPanel implements Runnable {

	/** HelpScreen의 배경 이미지를 담을 수 있는 객체  배경이미지는 어떻게 플레이해야 하는지 적혀있는 사진파일이다.*/
	private Image helpScreenBackGround;

	/** Back 버튼 이미지를 담을 수 있는 객체 */
	private ImageIcon backButtonImage;

	/** 마우스가 Back 버튼에 진입했을때 이미지 */
	private ImageIcon backButtonEnteredImage;

	/** JButton을 통한 backButton 구현 */
	private JButton backButton;

	/** 음악을 담을 수 있는 객체 , introMusic의 현재 진행 시간을 받아서 계속 진행시켜주어야 하므로 객체를 만든다. */
	private Music introMusic;

	/** 음악이 중지 되었을때의 frame을 담을수 있는 객체 */
	private int stopPoint;
	
	/** fadeIn과 fadeOut 을 위한 변수  fade Value에 따라 투명도가 결정된다.*/
	private float fadeValue;
	/** fadeIn과 fadeOut 을 위한 변수  isFadeOut에 FadeIn을 할건지 FadeOut을 한건지 결정된다..*/
	private boolean isFadeOut;

	/** boolean값을 통해 어떤 화면으로 전환할 지 가독성을 높일 수 있으며 값이 true가 되면 화면을 전환한다. */
	private boolean isMainScreen ;
	
	/** Thread 객체 */
	private Thread thread;

	/** 화면제어를 위한 객체 
	 * Frame인 InsideOut을 가지고 있어야 insideOut에 있는 패널 변경 메소드를 사용할수 있다. */
	private InsideOut insideOut;

	/** HelpScreenPanel의 생성자로 필드값들을 초기화 시켜주고.
	 * insideOut을 매개변수로 받아 화면제어를 하고
	 * stopPoint를 매개변수로 받아 그 시점부터 노래를 시작시킨다.
	 * 
	 * @param insideOut
	 * @param stopPoint
	 */
	HelpScreenPanel(InsideOut insideOut, int stopPoint) {
		// 프레임을 매개변수로 받아 제어한다.
		this.insideOut = insideOut;
		// introMusic 시작점을 정의해준다
		this.stopPoint = stopPoint;
		// backButton 이미지를 초기화 시켜준다.
		backButtonImage = new ImageIcon(
				getClass().getClassLoader().getResource("images/backButtonImage_2.png"));
		backButtonEnteredImage = new ImageIcon(
				getClass().getClassLoader().getResource("images/backButtonEnteredImage_2.png"));
		backButton = new JButton(backButtonImage);
		
		introMusic = new Music("introMusic.mp3", true, stopPoint);
		introMusic.start();
		// MainScreen의 값을 false로 초기화 시켜준다.
		isMainScreen = false;
		// fadeOut의 값을 false로 초기화 시켜준다.
		isFadeOut = false;
        // 컨테이너의 크기가 변경될때 컴포넌트들의 크기와 위치가 자동적으로 변경되는데 그걸 해제한다
		setLayout(null);
		// 게임창 크기 설정
		setSize(MainMain.SCREEN_WIDTH, MainMain.SCREEN_HEIGHT);
		setBounds(0, 0, MainMain.SCREEN_WIDTH, MainMain.SCREEN_HEIGHT);
		// 게임 배경화면 색깔 검정으로 지정
		setBackground(Color.BLACK);
		// 화면 출력 설정 기본값은 false 이므로 설정 해줘야한다.
		setVisible(true);

        // helpScreen 화면 설정 
		helpScreenBackGround = new ImageIcon(getClass().getClassLoader().getResource("images/helpScreen.png")).getImage();
		
		// 메뉴바 exitButton 설정
		buttonSet(insideOut.getMenubarExitButton(), 1200, 0, 64, 28);
		// 메뉴바 설정
		add(insideOut.getMenubar());
		
		// 쓰레드를 만들고 실행시켜준다.
		setThread(new Thread(this));

		// backButton의 위치 설정
		
		buttonSet(backButton, 20, 60, 228, 57);
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

			/**
			 * 마우스가 아이콘에 벗어났을때의 이벤트 처리
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				// 아이콘 이미지를 기본이미졸 변경
				backButton.setIcon(backButtonImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			/**
			 *  마우스가 backButton 아이콘 눌렀을때 이벤트 처리
			 */
			@Override
			public void mousePressed(MouseEvent e) {
				isFadeOut = true;
				isMainScreen = true;
			}
		});

	}
	

	/** 버튼 셋팅 메소드 모든 버튼마다 설정값을 넣기 편리하도록 메소드로 만들었다.
	 * JButton과 위치좌표와 크기를 지정해주면 자동으로 넣어준다.
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
	/**
	 * fadeOut 효과를 주기위한 메소드 temp를 사용한 이유는 fadeOut값이 0을 넘어가면 에러가 발생하기 때문에 float연산 특성상
	 * 0.1씩 10번 감소시키면 1.0이 아니라 -0.000001이 되서 에러가 발생한다. 따라서 temp를 감소시키고 fadeOut에 대입시키는
	 * 방식을 사용한다. 여기서 temp가 0보다 작아지면 temp를 0로 설정하고 대입시켜준다.
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

	/** helpScreenBackGround 이미지를 그려준다. */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// graphics를 2D로 변경
		Graphics2D g2 = (Graphics2D) g;
			// 투명도를 조절하기 위한 부분 fadeValue 가 1.0이면 불투명도 100%, 0.1이면 불투명도가 10% 이다.
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, fadeValue));
			g2.drawImage(helpScreenBackGround, 0, 0, null);
		}
    
	/** 쓰레드를 통해 음악중지와 화면전환을 한다. */
	@Override
	public void run() {
		// fadeIn 효과를 넣어준다.
		fadeIn();
    while (true) {
			try {
				if (isFadeOut && isMainScreen) {
					fadeOut();
					// 음악 진행을 받아서 실행
					introMusic.getPlayer().stop();
					stopPoint = introMusic.getPausedOnFrame();
					System.out.println("StopPoint : "  + stopPoint);
					introMusic.close();
					insideOut.changeMainScreen(stopPoint);
					return;
				} 
				repaint();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
			
    /** 도움말 화면의 Thread를 얻어오는 함수
     * 
     * @return thread
     */
	public Thread getThread() {
		return thread;
	}
	
	/** 도움말 화면의 Thread를 설정하는 함수 
	 * 
	 * @param thread
	 */
	public void setThread(Thread thread) {
		this.thread = thread;
	}

}
