package project_04;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 게임을 진행하는 판넬이다.
 *
 * @author SungHo Yun
 * @version 0.4
 */
public class GameScreenPanel extends JPanel implements Runnable {

	/** 마우스 버튼 클릭에 의해 Ball이 원 안으로 들어 갈 때 일어나는 이벤트를 위한 이미지 */
	private Image innerCircleEventImage;
	/** 마우스 버튼 클릭에 의해 Ball이 원 밖으로 나갈 때 일어나는 이벤트를 위한 이미지 */
	private Image outsideCircleEventImage;
	/** 뒤로가기 버튼 이미지를 담을 수 있는 객체 */
	private ImageIcon backButtonImage;
	/** 게임 시작 버튼 이미지를 담을 수 있는 객체 */
	private ImageIcon gamePlayButtonImage;
	/** 마우스가 Back 버튼에 진입했을 때의 이미지 */
	private ImageIcon backButtonEnteredImage;
	/** 게임 시작 버튼에 진입했을 때의 이미지 */
	private ImageIcon gamePlayButtonEnteredImage;
	/** JButton으로 backButton 구현 */
	private JButton backButton;
	/** JButton으로 gamePlayButton 구현 */
	private JButton gamePlayButton;
	/** Thread 객체 */
	private Thread thread;
	/** Ball 위치 제어를 위한 객체 */
	private Ball ball;
	/** 게임의 스테이지인 원의 제어를 위한 객체 */
	private Circle circle;
	/** 장애물들의 집합인 Beat 클래스 객체 */
	private Beat beat;
	/** 이벤트들이 모여있는 Event 클래스의 객체 */
	private Event event;
	/** 장애물들을 배열 형태로 가고 있는 필드값 */
	private ArrayList<Obstacle> obstacles;
	/** 세이브포인트 지점들을 배열 형태로 가지고 있는 필드값 */
	private ArrayList<SavePoint> savePoints;
	/** 시야 제한 이벤트 지점들을 배열 형태로 가지고 있는 필드값 */
	private ArrayList<GameSightLimit> gameSightLimitScreen;
	/** fadeIn과 fadeOut 을 위한 변수 fade Value에 따라 투명도가 결정된다. */
	private float fadeValue;
	/** fadeIn과 fadeOut 을 위한 변수 isFadeOut에 FadeIn을 할건지 FadeOut을 한건지 결정된다.. */
	private boolean isFadeOut;
	/** Screen 제어를 위한 변수 true가되면 GameSelectScreen으로 넘어간다. */
	private boolean isGameSelectScreen;
	/** 화면제어를 위한 객체 Frame인 InsideOut을 가지고 있어야 insideOut에 있는 패널 변경 메소드를 사용할수 있다. */
	private InsideOut insideOut;
	/** 게임음악 타이틀을 저장하고 있는 필드값 */
	private String musicTitle;
	/** 게임음악을객체 */
	private Music gameMusic;
	/** 음악이 어디서부터 진행되는지를 의미하는 필드값 처음엔 0으로 초기화 시켜준다. */
	private long startPoint;
	/** 공의 Radian값을 가지고 있는 필드값 */
	private double ballRadian;
	/** music이 종료되고 노래 선택화면으로 돌아가기 위한 지점을 위해 long값을 얻어온다. */
	private long closedMusicTime;
	/** 난이도를 가지고 있는 필드값 */
	private String difficulty;
	/** 노래가 얼만큼 진행되고 있는지 값을 double 형태로 가지고 있는 필드값 */
	private double progressTime;
	/** 노래가 얼만큼 진행되고 있는 지를 string 형태로 가지고 있는 필드값 */
	private String progress;
	/** progress.txt에 저장되어 있는 값들을 배열형태로 저장되어 있는 필드값*/
	private String[] progressArray;
	/** 노래가 얼만큼 진행되고 있는지를 txt파일 형태로 관리하기 위한 객체 */
	private SongProgress songProgress;
	/** 화면 반짝임 이벤트를 위해 공이 안으로 들어왔는지를 확인하는 boolean 필드값 */
	private boolean isInnerCircleEvent;
	/** 화면 반짝임 이벤트를 위해 공이 밖으로 들어왔는지를 확인하는 boolean 필드값 */
	private boolean isOutsideCircleEvent;
	/** Timer를 통해 화면반짝임과 원의 떨림 이벤트를 관리한다 */
	Timer eventTimer;
	/** 공이 원안으로 들어왔을때 생기는 이벤트 */
	TimerTask innerCircleEvent;
	/** 공이 원 밖으로 나갔을때 생기는 이벤트 */
	TimerTask outsideCircleEvent;
	/** 공의 위치가 변경됫을때 생기는 이벤트 */
	TimerTask circleBeatEvent;

	/**
	 * 매개변수로 insideOut과 음악제목, 난이도, 게임스피드, 끝나는시간등을 받아서 초기화 시켜준다.
	 * @param insideOut
	 * @param musicTitle
	 * @param difficulty
	 * @param gameSpeed
	 * @param closedMusicTime
	 */
	public GameScreenPanel(InsideOut insideOut, String musicTitle, String difficulty, double gameSpeed,
			long closedMusicTime) {
		// 프레임을 매개변수로 받아 제어한다.
		this.insideOut = insideOut;
		// fadeOut값을 false로 초기화 시켜문다
		isFadeOut = false;
		this.startPoint = 0;
		this.musicTitle = musicTitle;
		this.ballRadian = -90;
		gameMusic = new Music(musicTitle, false, (int) startPoint);
		this.progress = "0.00%";
		this.difficulty = difficulty;
		this.closedMusicTime = closedMusicTime;
		songProgress = new SongProgress();
		progressArray = songProgress.getProgressArray();
		// 쓰레드를 만들고 실행시켜준다.
		setThread(new Thread(this));
		// Image들 초기화
		innerCircleEventImage = new ImageIcon(
				getClass().getClassLoader().getResource("images/innerCircleEventImage.png")).getImage();
		outsideCircleEventImage = new ImageIcon(
				getClass().getClassLoader().getResource("images/outsideCircleEventImage.png")).getImage();
		backButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/backButtonImage_2.png"));
		gamePlayButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/gamePlayButton.png"));
		backButtonEnteredImage = new ImageIcon(
				getClass().getClassLoader().getResource("images/backButtonEnteredImage_2.png"));
		gamePlayButtonEnteredImage = new ImageIcon(
				getClass().getClassLoader().getResource("images/gamePlayButtonEntered.png"));
		// 버튼들 생성
		backButton = new JButton(backButtonImage);
		gamePlayButton = new JButton(gamePlayButtonImage);
		// 원을 위한 객체 생성
		circle = new Circle(640, 365, 265, 8, Color.WHITE);
		// x,y 좌표를 받기 위한 객체 생성
		ball = new Ball(circle, gameSpeed, -90);
		// 장애물 생성
		beat = new Beat(circle, musicTitle);
		event = new Event(musicTitle);
		savePoints = event.getSavePoint();
		gameSightLimitScreen = event.getGameSightLimit();
		obstacles = beat.getObstacles();
		// 컨테이너의 크기가 변경될때 컴포넌트들의 크기와 위치가 자동적으로 변경되는데 그걸 해제한다
		setLayout(null);
		// 게임창 크기 설정
		setSize(MainMain.SCREEN_WIDTH, MainMain.SCREEN_HEIGHT);
		setBounds(0, 0, MainMain.SCREEN_WIDTH, MainMain.SCREEN_HEIGHT);
		// 검정색 바탕에 흰색 원 이므로 검정색으로 설정
		setBackground(Color.BLACK);
		// 화면 출력 설정 기본값은 false 이므로 설정 해줘야한다.
		setVisible(true);
		// backButton의 위치 설정
		buttonSet(backButton, 80, 60, 228, 57);
		buttonSet(gamePlayButton, 600, 300, 125, 135);
		// 메뉴바 exitButton 설정
		buttonSet(insideOut.getMenubarExitButton(), 1200, 0, 64, 28);
		// 메뉴바 설정
		add(insideOut.getMenubar());
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
				saveProgress();
			}
		});

		// 게임 실행시 볼의 전환을 제어하기 위한 MouseListener
		addMouseListener(new MouseAdapter() {
			// 마우스가 눌려졌을 때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				eventTimer = new Timer();
				circleBeatEvent = new TimerTask() {
					@Override
					public void run() {
						circle.setChangeSize(0);
					}
				};
				circle.setChangeSize(20);
				eventTimer.schedule(circleBeatEvent, 100);

				// Ball이 바깥을 돌고 있다면
				if (ball.isBallOutside()) {
					eventTimer = new Timer();
					innerCircleEvent = new TimerTask() {
						@Override
						public void run() {
							isInnerCircleEvent = false;
						}
					};
					isInnerCircleEvent = true;
					// Ball이 바깥을 돌고 있는 여부에 대한 설정을 false로 만든다.
					ball.setBallOutside(false);
					eventTimer.schedule(innerCircleEvent, 200);
					// Ball이 안쪽을 돌고 있다면 isBallOutside가 false값이므로 else문을 실행한다.
				} else {
					eventTimer = new Timer();
					outsideCircleEvent = new TimerTask() {
						@Override
						public void run() {
							isOutsideCircleEvent = false;
						}
					};
					isOutsideCircleEvent = true;
					// Ball이 바깥을 돌고 있는 여부에 대한 설정을 true로 만든다.
					ball.setBallOutside(true);
					// Circle과 Ball을 원래대로 설정해서 원래 위치를 돌게 한다.
					ball.setRotateRadius(ball.getRotateRadius() + 25);
					eventTimer.schedule(outsideCircleEvent, 100);
				}
			}

		});

		// 마우스가 이 Listener에 집중 할 수 있게 한다.
		setFocusable(true);

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
				//ball.getThread().start();
				circle.getThread().start();
				gameMusic.start();
			}
		});
	}

	/**
	 * 버튼 셋팅 메소드 모든 버튼마다 설정값을 넣기 편리하도록 메소드로 만들었다. JButton과 위치좌표와 크기를 지정해주면 자동으로
	 * 넣어준다.
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
	 * 게임상황을 기록하는 progress.txt 파일에 내용을 적는 메소드이다.
	 * 노래제목에 따라 인덱스가 결정되고 normal이면 +1 challenge면 +2를 통해
	 * progressArray에 해당 인덱스의 값을 바꿔주고
	 * SongProgress 클래스 안에 있는 write 메소드를 통해 
	 * progress.txt에 있는 모든 값들을 변경시켜준다.
	 */
	public void saveProgress() {
		int index = 0;
		if (musicTitle.equals("Tobu & Itro - Sunburst_Highlight.mp3")) {
			index = 0;
		} else if (musicTitle.equals("BadNewsHighLight.mp3")) {
			index = 3;
		} else if (musicTitle.equals("HeartBeatHighLight.mp3")) {
			index = 6;
		}

		if (difficulty.equals("normal")) {
			index += 1;
		} else if (difficulty.equals("challenge")) {
			index += 2;
		}
		if (Double.parseDouble(progressArray[index]) < progressTime)
			progressArray[index] = String.format("%.2f", progressTime);
		if (!difficulty.equals("practice"))
			songProgress.write(progressArray);
	}

	/**
	 * fadeOut 효과를 주기위한 메소드 temp를 사용한 이유는 fadeOut값이 0을 넘어가면 에러가 발생하기 때문에 float연산 특성상
	 * 0.1씩 10번 감소시키면 1.0이 아니라 -0.000001이 되서 에러가 발생한다. 따라서 temp를 감소시키고 fadeOut에
	 * 대입시키는 방식을 사용한다. 여기서 temp가 0보다 작아지면 temp를 0로 설정하고 대입시켜준다.
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

	/**
	 * 게임오버가 발생했는지를 판단해주는 메소드
	 * 만약 ball과 obstacle이 intersect 메소드를 통해 true가 된다면 
	 * 이 메소드는 true를 반환하게 된다.
	 * 만약 난이도가 practice라면 이 메소드는 항상 false를 반환한다.
	 * @return
	 */
	public boolean isGameOver() {
		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).getStartTime() <= gameMusic.getTime()
					&& gameMusic.getTime() <= obstacles.get(i).getEndTime()) {
				if (ball.getRect().intersects(obstacles.get(i).getRect()) && !difficulty.equals("practice")) {
					gameMusic.close();
					gameMusic = new Music(musicTitle, false, (int) startPoint);
					ball.setSize(ballRadian);
					gameMusic.start();
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * ball이 savePoint를 만났는지를 판단해주는 메소드
	 * ball이 intersect메소드를 통해 savePoint를 만났다면 
	 * ball의 위치값인 radian값과 음악의 현재위치가 저장되어서 
	 * gameOver가 됫을시 그 시점부터 시작하게끔 설정한다.
	 */
	public void saveEvent() {
		for (int i = 0; i < savePoints.size(); i++) {
			if (savePoints.get(i).getStartTime() <= gameMusic.getTime()
					&& gameMusic.getTime() <= savePoints.get(i).getEndTime()) {
				if (ball.getRect().intersects(savePoints.get(i).getRect())) {
					savePoints.get(i).setEndTime(gameMusic.getTime());
					ballRadian = ball.getSize();
					startPoint = gameMusic.getTime();
				}
			}
		}
	}

	/**
	 * GameScreenPanel에 각종 Component들을 그려주는 메소드이다.
	 * Ball, Circle, SavePoints, Obstacles, gameProgress등등을 그려준다.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// graphics를 2D로 변경
		Graphics2D g2 = (Graphics2D) g;

		// 투명도를 조절하기 위한 부분 fadeValue 가 1.0이면 불투명도 100%, 0.1이면 불투명도가 10% 이다.
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, fadeValue));
		// 안티앨리어싱 , 원이 깨지지 않게 출력
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		for (int i = 0; i < savePoints.size(); i++) {
			if (savePoints.get(i).getStartTime() <= gameMusic.getTime()
					&& gameMusic.getTime() <= savePoints.get(i).getEndTime() && !difficulty.equals("practice")
					&& !difficulty.equals("challenge")) {
				g2.drawImage(savePoints.get(i).getSavePointImage(), savePoints.get(i).getX(), savePoints.get(i).getY(),
						150, 150, null);
			}
		}

		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).getStartTime() <= gameMusic.getTime()
					&& gameMusic.getTime() <= obstacles.get(i).getEndTime()) {
				g2.drawImage(obstacles.get(i).getObstacleImage(), obstacles.get(i).getX(), obstacles.get(i).getY(),
						null);
			}
		}

		for (int i = 0; i < gameSightLimitScreen.size(); i++) {
			if (gameSightLimitScreen.get(i).getStartTime() <= gameMusic.getTime()
					&& gameMusic.getTime() <= gameSightLimitScreen.get(i).getEndTime()) {
				g2.drawImage(gameSightLimitScreen.get(i).getGameSightLimitImage(), ball.getX() - 1280,
						ball.getY() - 720, null);
			}
		}
		// 흰색으로 설정
		g2.setColor(circle.getColor());
		// 두께 설정
		g2.setStroke(circle.getStroke());
		// 속이 비어있는 원 , x좌표, y좌표, width, height
		g2.drawOval(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight());
		// 안이 가득 찬 원 , ball클래스에서 제어를 통해 좌표가 변경되므로 get메소드 이용 , 우리가 조종할 객체
		g2.fillOval(ball.getX(), ball.getY(), ball.getRadius() * 2, ball.getRadius() * 2);

		// 진행상황 출력
		g2.setFont(new Font("Alien Encounters", Font.BOLD, 50));
		g2.drawString(progress, 1053, 106);

		if (isInnerCircleEvent) {
			g2.drawImage(innerCircleEventImage, 0, 0, null);

		} else if (isOutsideCircleEvent) {
			g2.drawImage(outsideCircleEventImage, 0, 0, null);
		}
	}

	/**
	 * 쓰레드를 통해 현재 진행상황을 계산하고 GameClear시 화면전환을 하는 화면제어를 한다.
	 */
	@Override
	public void run() {
		fadeIn();
		while (true) {
			ball.moveBall();
			repaint();
			for (int i = 0; i < obstacles.size(); i++) {
				obstacles.get(i).resetLocation();
			}
			
			progressTime = (double) gameMusic.getTime() / (double) closedMusicTime * 100;
			if (progressTime < 0) {
				progressTime = 0;
			} else if (progressTime > 100) {
				progressTime = 100;
			}
			progress = String.format("%.2f", progressTime) + "%";

			try {
				saveEvent();
				if (isFadeOut && isGameSelectScreen) {
					gameMusic.close();
					fadeOut();
					insideOut.changeGameSelectScreen();
					return;
				} else if (closedMusicTime <= gameMusic.getTime()) {
					if(!difficulty.equals("practice"))
					saveProgress();
					fadeOut();
					insideOut.changeGameSelectScreen();
					return;
				}

				if (isGameOver() && difficulty.equals("challenge")) {
					saveProgress();
					fadeOut();
					insideOut.changeGameSelectScreen();
					gameMusic.close();
					return;

				}

				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 게임 화면의 Thread를 얻어오는 함수
	 * 
	 * @return thread
	 */
	public Thread getThread() {
		return thread;
	}

	/**
	 * 게임 화면의 Thread를 설정하는 함수
	 * 
	 * @param thread
	 */
	public void setThread(Thread thread) {
		this.thread = thread;
	}

}
