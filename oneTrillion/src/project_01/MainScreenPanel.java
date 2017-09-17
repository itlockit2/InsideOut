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

	// 배경 이미지를 담을 수 있는 객체
	private Image background; // 화면이 전환 됨에 따라 intro 화면에 한정 되지 않으므로 변수 명을 background로 변경 
	private Image introBackgroundCircle; // 원은 intro 화면에 한정 되므로 변경하지 않음 

	// 버튼 이미지를 담을 수 있는 객체
	private ImageIcon exitButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/exitButton.png"));
	private ImageIcon helpButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/helpButton.png"));
	private ImageIcon startButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/startButton.png"));
	private ImageIcon leftButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/leftButtonBasic.png")); // 메인화면, left, right버튼 이미지
	private ImageIcon rightButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/rightButtonBasic.png"));

	// 마우스가 버튼에 진입했을때 이미지
	private ImageIcon startEnteredButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/startButtonEntered.png"));
	private ImageIcon helpEnteredButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/helpButtonEntered.png"));
	private ImageIcon exitEnteredButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/exitButtonEntered.png"));
	private ImageIcon leftEnteredButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/leftButtonEntered.png"));  // 메인화면, left, right버튼 이미지
	private ImageIcon rightEnteredButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/rightButtonEntered.png"));

	// JButton 구현
	private JButton exitButton = new JButton(exitButtonImage);
	private JButton helpButton = new JButton(helpButtonImage);
	private JButton startButton = new JButton(startButtonImage);
	private JButton leftButton = new JButton(leftButtonImage); // 메인화면 left, right 버튼 
	private JButton rightButton = new JButton(rightButtonImage);
    
	// 음악을 담을 수 있는 객체
	Music introMusic;

	// fadeIn과 fadeOut 을 위한 변수
	private float fadeValue;
	
	// 메인 화면인지 아닌지의 여부 , 처음에는 메인 화면이 아니므로 false를 부여 
	private boolean isMainScreen = false; 
	
	// 어떤 변수를 담을 수 있는 하나의 이미 만들어진 배열, 각각의 곡들을 담을 수 있음  
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	// 관리하기 쉽게 ArrayList 쪽으로 넣어줌 , selectedImage
  //private Image titleImage ; 곡 제목 넣을려면 넣읍시다.. 
	private Image selectedImage; // 현재 선택 된 곡의 이미지 객체 (곡 선택 화면)
	private Music selectedMusic; // 코드의 함수화를 통해 훨씬 더 간결히 작성
	private int nowSelected = 0; // 현재 선택된 곡을 의미 , 0(인덱스이므로)부터 시작 
	
	
	// Thread 객체
	private Thread thread;

	public MainScreenPanel() {
		/**
		 * Music의 매개변수로 mp3파일 이름과 루프유무를 넣어준다. 시작화면에서 인트로뮤직이 무한 반복 게임이 시작함과 동시에 음악이 무한 재생
		 */
		introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
		
		// 노래를 트랙에 맞추어서 추가 , 하이라이트 부분은 안만들어서 걍 넣어버림 , 각각의 파일 경로대로 넣어 줌
		// 넣어준 순서대로 인덱스를 부여 받음 0번째 인덱스
		trackList.add(new Track("Defending champion Start Image.png", "Defending champion Game image.png",
				                   "Defending Champions.mp3", "Defending Champions.mp3" ));
		// 1 번째 인덱스
		trackList.add(new Track("Sum41 Start Image.png", "Sum41 Game image.png",
                                   "Sum41 - Over My Head.mp3", "Sum41 - Over My Head.mp3" )); 
		// 2 번째 인덱스
		trackList.add(new Track("Metalika Start image.jpg", "Metalika Game image.png",
                                   "Master of puppets.mp3", "Master of puppets.mp3" )); 

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
		// 배경이미지 , introBackground => Background로 변경 
		background = new ImageIcon(getClass().getClassLoader().getResource("images/MainBackGround.png"))
				.getImage(); 
		introBackgroundCircle = new ImageIcon(
				getClass().getClassLoader().getResource("images/MainBackGroundCircle.gif")).getImage();
		selectedImage =  new ImageIcon(getClass().getClassLoader().getResource("images/Defending champion Start Image.png"))
				.getImage(); // 곡의 시작이미지를 의미 
		buttonSet(startButton, 110, 450, 228, 57);
		buttonSet(helpButton, 110, 515, 183, 55);
		buttonSet(exitButton, 110, 575, 148, 53);
		buttonSet(leftButton, 140, 310, 60, 60);
		buttonSet(rightButton, 1080, 310, 60, 60);
		
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
				introMusic.close(); // 메인화면으로 넘어 가므로 introMusic을 종료 시켜주어야 함 
				selectTrack(0); // 메인화면으로 넘어갔을 때 첫 번째 곡을 선택되게 하기 위함 
				startButton.setVisible(false); // 화면이 넘어 갓을 때 시작버튼 , 도움말 버튼 , exit 버튼을 보이지 않게 해줌
				helpButton.setVisible(false);
				exitButton.setVisible(false);
				leftButton.setVisible(true); // 메인화면 이므로 left, right버튼을 보이게 해주어야 함 
				rightButton.setVisible(true);
				background = new ImageIcon(getClass().getClassLoader().getResource("images/startBackGround.jpg"))
						.getImage();  // 화면이 넘어 갔을 때 배경을 startImage로 변경 , 일단, 이거 쓰고 Image는 나중에 다른 걸로 변경합시다. 
     			introBackgroundCircle = null; // startImage에선 돌아가는 원도 필요 없으므로 null값을 통해 지워줌 
     			isMainScreen = true; // start 버튼을 통해 메인화면으로 넘어가므로 true로 변경 
			}   // 노래선택 화면 변경 이벤트
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
		
		/**
		 * leftButton의 마우스 이벤트를 처리해준다.
		 */
		leftButton.setVisible(false); // 처음에는 보이지 않도록 함 , start 버튼을 눌렀을 때 보이게 끔 함  
		leftButton.addMouseListener(new MouseAdapter() {
			/**
			 * 마우스가 아이콘 위에 있을때 이벤트 처리
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// 아이콘 이미지를 Entered 이미지로 변경
				leftButton.setIcon(leftEnteredButtonImage);
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

			// 마우스가 leftButton 아이콘 눌렀을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				selectLeft();
			}
		});
		
		/**
		 * rightButton의 마우스 이벤트를 처리해준다.
		 */
		rightButton.setVisible(false); // 처음에는 보이지 않도록 함, start 버튼을 눌렀을 때 보이게 끔 함  
		rightButton.addMouseListener(new MouseAdapter() {
			/**
			 * 마우스가 아이콘 위에 있을때 이벤트 처리
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// 아이콘 이미지를 Entered 이미지로 변경
				rightButton.setIcon(rightEnteredButtonImage);
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

			// 마우스가 rightButton 아이콘 눌렀을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				selectRight();
			}
		});
		

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
		// graphics를 2D로 변경
		Graphics2D g2 = (Graphics2D) g;
		// 투명도를 조절하기 위한 부분 fadeValue 가 1.0이면 불투명도 100%, 0.1이면 불투명도가 10% 이다.
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, fadeValue));
		g2.drawImage(introBackgroundCircle, 275, 30, 1200, 676, null);
		g2.drawImage(background, 0, 0, null);
		// MainScreen으로 넘어 간 경우 아래의 이미지를 지정한 위치에 출력 ,촌스럽다 ....  
		if (isMainScreen) {
			g2.drawImage(selectedImage, 340, 100, null);
		}
	}

	@Override
	public void run() {
		// fadeIn 효과를 넣어준다.
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
    
	// 현재 선택된 곡에 번호를 넣어 줌으로써 해당 곡이 선택되었음을 알려줌 
	public void selectTrack(int nowSelected) {
	      if(selectedMusic != null) {
	    	  selectedMusic.close(); // 어떤 곡이 실행되고 있다면 그 곡을 바로 종료
	    	  selectedImage = new ImageIcon(getClass().getClassLoader().getResource("images/" + trackList.get(nowSelected).getStartImage()))
	  				.getImage(); // 현재 선택된 곡을 그 곡에 맞춰 이미지를 바꾸어 줌 
	    	  selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true); // 선택된 곡을 가져옴 , true로 무한 재생  
	    	  selectedMusic.start(); // 선택된 곡을 실행 
	      }
	}
	// 메인 화면에서 왼쪽 버튼을 눌렀을 때의 이벤트 
	public void selectLeft() {
	// 현재, 첫 번째 곡의 위치에 잇으므로 왼쪽버튼을 누르면 가장 오른쪽으로 가야하므로 크기에서 1을 빼준다.
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1;
		
		// 0이 아닌경우 하나씩 빼어서 왼쪽으로 이동하면 된다.
		else 
			nowSelected--;
		
		selectTrack(nowSelected);
	}
	
	// 메인 화면에서 오른쪽 버튼을 눌렀을 때의 이벤트 
		public void selectRight() {
	  // 현재 위치가 가장 오른쪽에 있다면 첫 번째 곡으로 이동하도록 변경 
			if(nowSelected == trackList.size()-1 ) 
				nowSelected = 0;
			
			// 0이 아닌경우 하나씩 더해서 오른쪽으로 이동시킴
			else 
				nowSelected++;
			
			selectTrack(nowSelected);
		}
}
