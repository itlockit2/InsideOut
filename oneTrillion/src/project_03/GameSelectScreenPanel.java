package project_03;

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

public class GameSelectScreenPanel extends JPanel implements Runnable {

	// 배경 이미지를 담을 수 있는 객체
	private Image gameSelectBackGround;
	private Image musicSelectBackGround;
	private Image selectedImage; // 시작하고 들어 갔을 때의 이미지

	// 뒤로가기 버튼 이미지를 담을 수 있는 객체
	private ImageIcon backButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/backButtonImage.png"));
	// 왼쪽 버튼 이미지를 담을 수 있는 객체
	private ImageIcon leftButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/leftButtonImage.png"));
	// 오른쪽 버튼 이미지를 담을 수 있는 객체
	private ImageIcon rightButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/rightButtonImage.png"));
	// 노말 버튼 이미지를 담을 수 있는 객체
	private ImageIcon normalButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/normalButtonImage.png"));
	// 챌린지 버튼 이미지를 담을 수 있는 객체
	private ImageIcon challengeButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/challengeButtonImage.png"));
    // 연습 버튼 이미지를 담을 수 있는 객체
	private ImageIcon practiceButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/practiceButtonImage.png"));
	
	// 마우스가 버튼에 진입했을 때의 이미지
	private ImageIcon backButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/backButtonEnteredImage.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/leftButtonEnteredImage.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/rightButtonEnteredImage.png"));
	private ImageIcon normalButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/normalButtonEnteredImage.png"));
	private ImageIcon challengeButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/challengeButtonEnteredImage.png"));
	private ImageIcon practiceButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/practiceButtonEnteredImage.png"));
	


	// JButton 구현
	private JButton backButton = new JButton(backButtonImage);
	private JButton leftButton = new JButton(leftButtonImage);
	private JButton rightButton = new JButton(rightButtonImage);
	private JButton normalButton = new JButton(normalButtonImage);
	private JButton challengeButton = new JButton(challengeButtonImage);
	private JButton practiceButton = new JButton(practiceButtonImage);


	// 쓰레드 객체 선언
	private Thread thread;

	// fadeIn과 fadeOut 을 위한 변수
	private float fadeValue;
	private boolean isFadeOut;

	// MainScreen 제어를 위한 변수
	private boolean isMainScreen;
	// NormalGameScreen 제어를 위한 변수
	private boolean isNormalGameScreen;
	// ChallengeGameScreen 제어를 위한 변수
	private boolean isChallengeGameScreen;
	// PracticeGameScreen 제어를 위한 변수
	private boolean isPracticeGameScreen;
	
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	// 첫 번째 곡을 의미, 인덱스로 시작 , ArrayList는 인덱스 0부터 시작
	private int nowSelected = 0; 
	private Music selectedMusic;
	
	// 자신에게 맞는 판넬로 제어해야 하므로 insideout객체 선언을 통해 제어
	private InsideOut insideOut;

	GameSelectScreenPanel(InsideOut insideOut) {
		// 프레임을 매개변수로 받아 제어한다.
		this.insideOut = insideOut;
		// fadeOut값을 false로 초기화 시켜문다
		isFadeOut = false;
		// isMainScreen의 값을 false로 초기화 시켜준다.
		isMainScreen = false;
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
		
		trackList.add(new Track("Metalika Start image.jpg", "Metalika Start image.jpg",
				"Master of puppets.mp3", "Master of puppets.mp3"));
		trackList.add(new Track( "Defending champion Game image.png", "Defending Champions.mp3",
				"Defending Champions.mp3", "Defending Champions"));
		trackList.add(new Track( "Dasboot Game image.png", "Dasboot.mp3",
				"Dasboot.mp3", "Dasboot"));

		// Main 클래스의 위치를 기반으로 해서 Resource를 얻어서 그것의 이미지값을 변수에 대입시켜준다.
		gameSelectBackGround = new ImageIcon(
				getClass().getClassLoader().getResource("images/gameSelectScreenImage_2.png")).getImage();
		musicSelectBackGround = new ImageIcon(
				getClass().getClassLoader().getResource("images/sunburstGameselectImage_2.png")).getImage();
		
		// 메뉴바 exitButton 설정
		buttonSet(insideOut.getMenubarExitButton(),1200,0,64,28);
		// 메뉴바 설정
		add(insideOut.getMenubar());
		
		// leftButton의 위치 설정
		buttonSet(leftButton, 100, 310, 120, 120); // 73, 98 (원래 크기) 
		/**
		 * leftButton의 마우스 이벤트를 처리해준다.
		 */

		leftButton.addMouseListener(new MouseAdapter() {
			/**
			 * 마우스가 아이콘 위에 있을때 이벤트 처리
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// 아이콘 이미지를 Entered 이미지로 변경
				leftButton.setIcon(leftButtonEnteredImage);
				// 커서 이미지도 HAND_CURSOR로 변경해서 좀더 알아보기 쉽게한다.
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// 마우스가 아이콘을 벗어 났을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				// 아이콘 이미지를 기본이미졸 변경
				leftButton.setIcon(leftButtonImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 마우스가 leftbutton 아이콘 눌렀을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				// 왼쪽 버튼 이벤트 처리
				selectLeft();
			}
		});

		// rightButton의 위치 설정
		buttonSet(rightButton, 1050, 310, 120, 120); // 73 98 (원래 크기) 
		/**
		 * rightButton의 마우스 이벤트를 처리해준다.
		 */

		rightButton.addMouseListener(new MouseAdapter() {
			/**
			 * 마우스가 아이콘 위에 있을때 이벤트 처리
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// 아이콘 이미지를 Entered 이미지로 변경
				rightButton.setIcon(rightButtonEnteredImage);
				// 커서 이미지도 HAND_CURSOR로 변경해서 좀더 알아보기 쉽게한다.
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// 마우스가 아이콘을 벗어 났을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				// 아이콘 이미지를 기본이미졸 변경
				rightButton.setIcon(rightButtonImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 마우스가 leftbutton 아이콘 눌렀을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				// 오른쪽 버튼 이벤트 처리
				selectRight();
			}
		});
		
		// normalButton의 위치 설정 x좌표,y좌표,크기 (가로 x 세로)
		buttonSet(normalButton, 390, 360, 213, 40); //  
		/**
		 * normalButton의 마우스 이벤트를 처리해준다.
		 */

		normalButton.addMouseListener(new MouseAdapter() {
			/**
			 * 마우스가 아이콘 위에 있을때 이벤트 처리
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// 아이콘 이미지를 Entered 이미지로 변경
				normalButton.setIcon(normalButtonEnteredImage);
				// 커서 이미지도 HAND_CURSOR로 변경해서 좀더 알아보기 쉽게한다.
				normalButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// 마우스가 아이콘을 벗어 났을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				// 아이콘 이미지를 기본이미졸 변경
				normalButton.setIcon(normalButtonImage);
				normalButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 마우스가 practiceButton 아이콘 눌렀을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				// 노말 버튼 이벤트 처리
				isFadeOut = true;
				isNormalGameScreen = true;
			}
		});
		
		// challengeButton의 위치 설정 x좌표,y좌표,크기 (가로 x 세로)
		buttonSet(challengeButton, 680, 360, 234, 38); //  
		/**
		 * challengeButton의 마우스 이벤트를 처리해준다.
		 */

		challengeButton.addMouseListener(new MouseAdapter() {
			/**
			 * 마우스가 아이콘 위에 있을때 이벤트 처리
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// 아이콘 이미지를 Entered 이미지로 변경
				challengeButton.setIcon(challengeButtonEnteredImage);
				// 커서 이미지도 HAND_CURSOR로 변경해서 좀더 알아보기 쉽게한다.
				challengeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// 마우스가 아이콘을 벗어 났을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				// 아이콘 이미지를 기본이미졸 변경
				challengeButton.setIcon(challengeButtonImage);
				challengeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 마우스가 practiceButton 아이콘 눌렀을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				// 챌린지 버튼 이벤트 처리
				isFadeOut = true;
				isChallengeGameScreen = true;
			}
		});

		// practiceButton의 위치 설정 x좌표,y좌표,크기 (가로 x 세로)
		buttonSet(practiceButton, 540, 580, 213, 40); //  
		/**
		 * practiceButton의 마우스 이벤트를 처리해준다.
		 */

		practiceButton.addMouseListener(new MouseAdapter() {
			/**
			 * 마우스가 아이콘 위에 있을때 이벤트 처리
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// 아이콘 이미지를 Entered 이미지로 변경
				practiceButton.setIcon(practiceButtonEnteredImage);
				// 커서 이미지도 HAND_CURSOR로 변경해서 좀더 알아보기 쉽게한다.
				practiceButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// 마우스가 아이콘을 벗어 났을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				// 아이콘 이미지를 기본이미졸 변경
				practiceButton.setIcon(practiceButtonImage);
				practiceButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 마우스가 practiceButton 아이콘 눌렀을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				// 연습 버튼 이벤트 처리
				isFadeOut = true;
				isPracticeGameScreen = true;
			}
		});


		// backButton의 위치 설정
		buttonSet(backButton, 80, 60, 228, 57);
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
				isMainScreen = true;
			}
		});

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
				repaint();
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// graphics를 2D로 변경
		Graphics2D g2 = (Graphics2D) g;
		// 투명도를 조절하기 위한 부분 fadeValue 가 1.0이면 불투명도 100%, 0.1이면 불투명도가 10% 이다.
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, fadeValue));
		g2.drawImage(musicSelectBackGround, 0, 0, null);
		g2.drawImage(gameSelectBackGround, 0, 0, null);
		
	}

	// run 함수에서 while문을 통해 계속 화면을 그려줌으로써 다음 화면으로 넘어갈 수 있게 해준다.
	@Override
	public void run() {
		fadeIn();
		while (true) {
			repaint();
			try {
				if (isFadeOut && isMainScreen) {
					fadeOut();
					insideOut.changeMainScreen();
					return;
				}
				else if(isFadeOut && isNormalGameScreen) {
					fadeOut();
					insideOut.changeGameScreen();
					return;
				}
				else if(isFadeOut && isChallengeGameScreen) {
					fadeOut();
					insideOut.changeGameScreen();
					return;
				}
				else if(isFadeOut && isPracticeGameScreen) {
					fadeOut();
					insideOut.changeGameScreen();
					return;
				}
				
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	//  다음 작업해야 할 장소
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null) 
			selectedMusic.close();
		selectedImage = new ImageIcon(
				getClass().getClassLoader().getResource("images/gameSelectScreenImage.png")).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start(); // 무한 재생
	}
	
	// 왼쪽 버튼을 눌렀을 때의 이벤트 처리
	public void selectLeft() {
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1; // 첫 번째곡에서 왼쪽 버튼을 누르면 가장 오른쪽 곡이 선택되어야 하기 때문
		else
			nowSelected--; // 그 외의 경우는 1을 빼줌
		selectTrack(nowSelected);
	}
	
	// 오른쪽 버튼을 눌렀을 때의 이벤트 처리
	public void selectRight() {
		if(nowSelected == trackList.size() - 1)
			nowSelected = 0; // 왼쪽과 반대
		else
			nowSelected++; // 마찬가지로  그 외의 경우는 1을 더함 
		selectTrack(nowSelected);
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

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}
}
