package project_03;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 게임의 전반적인 컨트롤을 해주는 클래스이다.
 * 
 * @author Yun
 *
 */
public class InsideOut extends JFrame {

	// MainScreenPanel 객체이다.
	private MainScreenPanel mainScreenPanel;
	// MusicSelectScreenPanel 객체이다.
	private GameSelectScreenPanel gameSelectScreenPanel;
	// GameScreenPanel 객체이다.
	private GameScreenPanel gameScreenPanel;
	// 필요한 정보를 출력하는 부분이 contentpane 이다.
	private Container contentpane;

	// MenuBar이미지
	private JLabel menubar;

	/**
	 * 현재 프로그램내에서 마우스의 X와 Y좌표를 받을수 있는 필드를 만든다. 메뉴바를 옮기기 위해서 필요하다.
	 */
	private int mouseX, mouseY;

	// Menubar Exit이미지
	private ImageIcon menubarImageBasic = new ImageIcon(
			getClass().getClassLoader().getResource("images/manubarExitButtonImage.png"));
	private ImageIcon menubarImageEntered = new ImageIcon(
			getClass().getClassLoader().getResource("images/manubarExitButtonImageEntered.png"));
	
	// Menubar Button
	private JButton menubarExitButton = new JButton(menubarImageBasic);

	public InsideOut() {
		// 게임이름 설정
		setTitle("Inside Out");
		// 게임을 끄면 완전히 종료, 반드시 필요한 함수
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// getContentPane 으로 contentpane 정보를 얻어온다.
		contentpane = getContentPane();
		// 게임창 크기 설정
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// 배경화면을 검정으로 설정해준다.
		setBackground(Color.BLACK);
		// 게임창이 정 중앙에 출력
		setLocationRelativeTo(null);
		// 컨테이너의 크기가 변경될때 컴포넌트들의 크기와 위치가 자동적으로 변경되는데 그걸 해제한다.
		setLayout(null);
		// 메뉴바가 보이지 않게끔 설정
		setUndecorated(true);
		// 사용자가 게임창을 임의로 줄이고 하는게 불가능, true로 하면 가능
		setResizable(false);

		// 메뉴바 이미지를 추가시켜준다.
		menubar = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("images/menubarImage.png")));
		// 메뉴바의 위치를 지정해준다.
		menubar.setBounds(0, 0, 1280, 28);
		// 메뉴바를 추가시켜준다.
		add(menubar);
		// 메뉴바 이벤트들을 처리해준다.
		// menuBar를 마우스를 통해서 조작할수 있도록 이벤트처리를 해준다.
		menubar.addMouseListener(new MouseAdapter() {
			// 마우스를 입력했을때 컴포넌트내의 마우스의 x좌표와 y좌표를 가져온다
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		// menuBar를 드래그 했을때 이벤트 처리를 해준다.
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			// 마우스를 입력했을때 스크린(모니터)내의 마우스의 x좌표와 y좌표를 가져온다
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				// 스크린내의 마우스의 좌표와 컴포넌트내의 마우스의 좌표의 차가 게임창의 위치이다.
				setLocation(x - mouseX, y - mouseY);
			}
		});
		
		// 메뉴바에 있는 menubarExitButton 이벤트 처리
		menubarExitButton.addMouseListener(new MouseAdapter() {
			// 마우스가 버튼에 들어왓을때 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {
				// Entered이미지로 변경 시켜준다.
				menubarExitButton.setIcon(menubarImageEntered);
				// 커서의 모양을 바꿔준다
				menubarExitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// 효과음 재생
			}

			// 마우스가 버튼에 나갔을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				menubarExitButton.setIcon(menubarImageBasic);
				// 커서의 모양을 바꿔준다
				menubarExitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			// 버튼을 클릭했을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				// 효과음 재생
				// 프로그램이 바로 꺼지지 않고 1초정도 있다가 꺼지게금 설정
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});

		// 메인 패널 생성
		mainScreenPanel = new MainScreenPanel(this);
		// 패널을 추가해준다.
		contentpane.add(mainScreenPanel);
		// MainPanel의 쓰레드 실행
		mainScreenPanel.getThread().start();
		// 화면 출력 설정 기본값은 false 이므로 설정 해줘야한다.되도록 맨마지막에 해준다.
		setVisible(true);
	}
	
	// Start 버튼을 누를시 전에 실행되던 판넬을 종료시키고 MusicSelectScreen화면으로 이동
	// 또한 GameScreen화면에서 Back버튼을 누를시 MusicSelectScreen화면으로도 이동
	public void changeGameSelectScreen() {
		// 현재 실행되고 있는 모든 판넬을 제거한다.
		contentpane.removeAll();
		// 새롭게 게임 스크린 판넬 객체를 만들어서 생성자를 실행
		gameSelectScreenPanel = new GameSelectScreenPanel(this);
		// 패널을 추가해준다.
		contentpane.add(gameSelectScreenPanel);
		// GamePanel의 쓰레드 실행
		gameSelectScreenPanel.getThread().start();
		// 화면 출력 설정 기본값은 false 이므로 설정 해줘야한다.
		setVisible(true);
	}
    
	// MusicSelectPanel에서 음악 선택시 실행되던 판넬을 종료시키고 GameScreen화면으로 이동
	public void changeGameScreen() {
		// 현재 실행되고 있는 모든 판넬을 제거한다.
		contentpane.removeAll();
		// 새롭게 게임 스크린 판넬 객체를 만들어서 생성자를 실행
		gameScreenPanel = new GameScreenPanel(this);
		// 패널을 추가해준다.
		contentpane.add(gameScreenPanel);
		// GamePanel의 쓰레드 실행
		gameScreenPanel.getThread().start();
		// 화면 출력 설정 기본값은 false 이므로 설정 해줘야한다.
		setVisible(true);
	}

	// MusicSelectPanel에서 실행되던 판넬을 종료시키고 MainScreen화면으로 이동
	public void changeMainScreen() {
		// 현재 실행되고 있는 모든 판넬을 제거한다.
		contentpane.removeAll();
		// 새롭게 게임 스크린 판넬 객체를 만들어서 생성자를 실행
		mainScreenPanel = new MainScreenPanel(this);
		// 패널을 추가해준다.
		contentpane.add(mainScreenPanel);
		// GamePanel의 쓰레드 실행
		mainScreenPanel.getThread().start();
		// 화면 출력 설정 기본값은 false 이므로 설정 해줘야한다.
		setVisible(true);
	}

	public JLabel getMenubar() {
		return menubar;
	}

	public void setMenubar(JLabel menubar) {
		this.menubar = menubar;
	}

	public JButton getMenubarExitButton() {
		return menubarExitButton;
	}

	public void setMenubarExitButton(JButton menubarExitButton) {
		this.menubarExitButton = menubarExitButton;
	}
	
	

}
