package project_04;

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

	// ë°°ê²½ ?´ë¯¸ì?ë¥? ?‹´?„ ?ˆ˜ ?ˆ?Š” ê°ì²´
	private Image gameSelectBackGround;
	private Image musicSelectBackGround;
	private Image selectedImage; // ?‹œ?‘?•˜ê³? ?“¤?–´ ê°”ì„ ?•Œ?˜ ?´ë¯¸ì?

	// ?’¤ë¡œê?ê¸? ë²„íŠ¼ ?´ë¯¸ì?ë¥? ?‹´?„ ?ˆ˜ ?ˆ?Š” ê°ì²´
	private ImageIcon backButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/backButtonImage_2.png"));
	// ?™¼ìª? ë²„íŠ¼ ?´ë¯¸ì?ë¥? ?‹´?„ ?ˆ˜ ?ˆ?Š” ê°ì²´
	private ImageIcon leftButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/leftButtonImage_2.png"));
	// ?˜¤ë¥¸ìª½ ë²„íŠ¼ ?´ë¯¸ì?ë¥? ?‹´?„ ?ˆ˜ ?ˆ?Š” ê°ì²´
	private ImageIcon rightButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/rightButtonImage_2.png"));
	// ?…¸ë§? ë²„íŠ¼ ?´ë¯¸ì?ë¥? ?‹´?„ ?ˆ˜ ?ˆ?Š” ê°ì²´
	private ImageIcon normalButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/normalButtonImage_2.png"));
	// ì±Œë¦°ì§? ë²„íŠ¼ ?´ë¯¸ì?ë¥? ?‹´?„ ?ˆ˜ ?ˆ?Š” ê°ì²´
	private ImageIcon challengeButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/challengeButtonImage_2.png"));
	// ?—°?Šµ ë²„íŠ¼ ?´ë¯¸ì?ë¥? ?‹´?„ ?ˆ˜ ?ˆ?Š” ê°ì²´
	private ImageIcon practiceButtonImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/practiceButtonImage_2.png"));

	// ë§ˆìš°?Š¤ê°? ë²„íŠ¼?— ì§„ì…?–ˆ?„ ?•Œ?˜ ?´ë¯¸ì?
	private ImageIcon backButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/backButtonEnteredImage_2.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/leftButtonEnteredImage_2.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/rightButtonEnteredImage_2.png"));
	private ImageIcon normalButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/normalButtonEnteredImage_2.png"));
	private ImageIcon challengeButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/challengeButtonEnteredImage_2.png"));
	private ImageIcon practiceButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/practiceButtonEnteredImage_2.png"));

	// JButton êµ¬í˜„
	private JButton backButton = new JButton(backButtonImage);
	private JButton leftButton = new JButton(leftButtonImage);
	private JButton rightButton = new JButton(rightButtonImage);
	private JButton normalButton = new JButton(normalButtonImage);
	private JButton challengeButton = new JButton(challengeButtonImage);
	private JButton practiceButton = new JButton(practiceButtonImage);

	// ?“°? ˆ?“œ ê°ì²´ ?„ ?–¸
	private Thread thread;

	// fadeInê³? fadeOut ?„ ?œ„?•œ ë³??ˆ˜
	private float fadeValue;
	private boolean isFadeOut;

	// MainScreen ? œ?–´ë¥? ?œ„?•œ ë³??ˆ˜
	private boolean isMainScreen;
	// NormalGameScreen ? œ?–´ë¥? ?œ„?•œ ë³??ˆ˜
	private boolean isNormalGameScreen;
	// ChallengeGameScreen ? œ?–´ë¥? ?œ„?•œ ë³??ˆ˜
	private boolean isChallengeGameScreen;
	// PracticeGameScreen ? œ?–´ë¥? ?œ„?•œ ë³??ˆ˜
	private boolean isPracticeGameScreen;

	ArrayList<Track> trackList = new ArrayList<Track>();

	// ì²? ë²ˆì§¸ ê³¡ì„ ?˜ë¯?, ?¸?±?Š¤ë¡? ?‹œ?‘ , ArrayList?Š” ?¸?±?Š¤ 0ë¶??„° ?‹œ?‘
	private int nowSelected = 0;
	private Music selectedMusic;

	// ??‹ ?—ê²? ë§ëŠ” ?Œ?„¬ë¡? ? œ?–´?•´?•¼ ?•˜ë¯?ë¡? insideoutê°ì²´ ?„ ?–¸?„ ?†µ?•´ ? œ?–´
	private InsideOut insideOut;

	GameSelectScreenPanel(InsideOut insideOut) {
		// ?”„? ˆ?„?„ ë§¤ê°œë³??ˆ˜ë¡? ë°›ì•„ ? œ?–´?•œ?‹¤.
		this.insideOut = insideOut;
		// fadeOutê°’ì„ falseë¡? ì´ˆê¸°?™” ?‹œì¼œë¬¸?‹¤
		isFadeOut = false;
		// isMainScreen?˜ ê°’ì„ falseë¡? ì´ˆê¸°?™” ?‹œì¼œì??‹¤.
		isMainScreen = false;
		// ?“°? ˆ?“œë¥? ë§Œë“¤ê³? ?‹¤?–‰?‹œì¼œì??‹¤.
		setThread(new Thread(this));
		// ì»¨í…Œ?´?„ˆ?˜ ?¬ê¸°ê? ë³?ê²½ë ?•Œ ì»´í¬?„Œ?Š¸?“¤?˜ ?¬ê¸°ì? ?œ„ì¹˜ê? ??™? ?œ¼ë¡? ë³?ê²½ë˜?Š”?° ê·¸ê±¸ ?•´? œ?•œ?‹¤
		setLayout(null);
		// ê²Œì„ì°? ?¬ê¸? ?„¤? •
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// ê²?? •?ƒ‰ ë°”íƒ•?— ?°?ƒ‰ ?› ?´ë¯?ë¡? ê²?? •?ƒ‰?œ¼ë¡? ?„¤? •
		setBackground(Color.BLACK);
		// ?™”ë©? ì¶œë ¥ ?„¤? • ê¸°ë³¸ê°’ì? false ?´ë¯?ë¡? ?„¤? • ?•´ì¤˜ì•¼?•œ?‹¤.
		setVisible(true);
         
		// trackListë¥? ?†µ?•´ ?›?•˜?Š” ê³¡ê³¼ ?™”ë©´ì„ êµ¬í˜„ ?”°?¼?„œ, ?´?Ÿ° ?‹?œ¼ë¡? êµ¬í˜„?´ ê°??Š¥?•˜?‹¤. ê¸°ë³¸? ?œ¼ë¡? 4ê°? êµ¬ì„±?•´ë´?
		trackList.add(new Track("sunburstGameselectImage_2.png", "sunburstGameselectImage_2.png", "Tobu & Itro - Sunburst_Highlight.mp3",
				"Tobu & Itro - Sunburst.mp3"));
		trackList.add(new Track("Metalika Start image.jpg", "Metalika Start image.jpg", "Master of puppets.mp3",
				"Master of puppets.mp3"));
		trackList.add(new Track("Defending champion Start image.png", "Defending champions Start Image.mp3",
				"Defending Champions.mp3", "Defending Champions.mp3"));
		trackList.add(new Track("Dasboot Start image.png", "Dasboot Start Image.png", "Dasboot.mp3", "Dasboot.mp3"));

		// Main ?´?˜?Š¤?˜ ?œ„ì¹˜ë?? ê¸°ë°˜?œ¼ë¡? ?•´?„œ Resourceë¥? ?–»?–´?„œ ê·¸ê²ƒ?˜ ?´ë¯¸ì?ê°’ì„ ë³??ˆ˜?— ???…?‹œì¼œì??‹¤.
		gameSelectBackGround = new ImageIcon(
				getClass().getClassLoader().getResource("images/gameSelectScreenImage_2.png")).getImage();
		musicSelectBackGround = new ImageIcon(
				getClass().getClassLoader().getResource("images/sunburstGameselectImage_2.png")).getImage();

		// ë©”ë‰´ë°? exitButton ?„¤? •
		buttonSet(insideOut.getMenubarExitButton(), 1200, 0, 64, 28);
		// ë©”ë‰´ë°? ?„¤? •
		add(insideOut.getMenubar());
		// leftButton?˜ ?œ„ì¹? ?„¤? •
		buttonSet(leftButton, 100, 310, 120, 120); // 73, 98 (?›?˜ ?¬ê¸?)
        // ?„ ?ƒ?•  ê³¡ì„ ë³´ì—¬ì£¼ê³  ?“¤? ¤ì¤??‹¤. ?¸?±?Š¤?¸ nowSelectedê°’ì— ?”°?¼ ê³? ë³?ê²½ì´ ê°??Š¥?•¨ 
		selectTrack(nowSelected);
		
		
		/**
		 * leftButton?˜ ë§ˆìš°?Š¤ ?´ë²¤íŠ¸ë¥? ì²˜ë¦¬?•´ì¤??‹¤.
		 */

		leftButton.addMouseListener(new MouseAdapter() {
			/**
			 * ë§ˆìš°?Š¤ê°? ?•„?´ì½? ?œ„?— ?ˆ?„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// ?•„?´ì½? ?´ë¯¸ì?ë¥? Entered ?´ë¯¸ì?ë¡? ë³?ê²?
				leftButton.setIcon(leftButtonEnteredImage);
				// ì»¤ì„œ ?´ë¯¸ì??„ HAND_CURSORë¡? ë³?ê²½í•´?„œ ì¢??” ?•Œ?•„ë³´ê¸° ?‰½ê²Œí•œ?‹¤.
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// ë§ˆìš°?Š¤ê°? ?•„?´ì½˜ì„ ë²—ì–´ ?‚¬?„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			@Override
			public void mouseExited(MouseEvent e) {
				// ?•„?´ì½? ?´ë¯¸ì?ë¥? ê¸°ë³¸?´ë¯¸ì¡¸ ë³?ê²?
				leftButton.setIcon(leftButtonImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// ë§ˆìš°?Š¤ê°? leftbutton ?•„?´ì½? ?ˆŒ???„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			@Override
			public void mousePressed(MouseEvent e) {
				// ?™¼ìª? ë²„íŠ¼ ?´ë²¤íŠ¸ ì²˜ë¦¬
				selectLeft();
			}
		});

		// rightButton?˜ ?œ„ì¹? ?„¤? •
		buttonSet(rightButton, 1050, 310, 120, 120); // 73 98 (?›?˜ ?¬ê¸?)
		/**
		 * rightButton?˜ ë§ˆìš°?Š¤ ?´ë²¤íŠ¸ë¥? ì²˜ë¦¬?•´ì¤??‹¤.
		 */

		rightButton.addMouseListener(new MouseAdapter() {
			/**
			 * ë§ˆìš°?Š¤ê°? ?•„?´ì½? ?œ„?— ?ˆ?„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// ?•„?´ì½? ?´ë¯¸ì?ë¥? Entered ?´ë¯¸ì?ë¡? ë³?ê²?
				rightButton.setIcon(rightButtonEnteredImage);
				// ì»¤ì„œ ?´ë¯¸ì??„ HAND_CURSORë¡? ë³?ê²½í•´?„œ ì¢??” ?•Œ?•„ë³´ê¸° ?‰½ê²Œí•œ?‹¤.
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// ë§ˆìš°?Š¤ê°? ?•„?´ì½˜ì„ ë²—ì–´ ?‚¬?„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			@Override
			public void mouseExited(MouseEvent e) {
				// ?•„?´ì½? ?´ë¯¸ì?ë¥? ê¸°ë³¸?´ë¯¸ì¡¸ ë³?ê²?
				rightButton.setIcon(rightButtonImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// ë§ˆìš°?Š¤ê°? leftbutton ?•„?´ì½? ?ˆŒ???„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			@Override
			public void mousePressed(MouseEvent e) {
				// ?˜¤ë¥¸ìª½ ë²„íŠ¼ ?´ë²¤íŠ¸ ì²˜ë¦¬
				  selectRight();
			}
		});

		// normalButton?˜ ?œ„ì¹? ?„¤? • xì¢Œí‘œ,yì¢Œí‘œ,?¬ê¸? (ê°?ë¡? x ?„¸ë¡?)
		buttonSet(normalButton, 390, 360, 213, 40); //
		/**
		 * normalButton?˜ ë§ˆìš°?Š¤ ?´ë²¤íŠ¸ë¥? ì²˜ë¦¬?•´ì¤??‹¤.
		 */

		normalButton.addMouseListener(new MouseAdapter() {
			/**
			 * ë§ˆìš°?Š¤ê°? ?•„?´ì½? ?œ„?— ?ˆ?„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// ?•„?´ì½? ?´ë¯¸ì?ë¥? Entered ?´ë¯¸ì?ë¡? ë³?ê²?
				normalButton.setIcon(normalButtonEnteredImage);
				// ì»¤ì„œ ?´ë¯¸ì??„ HAND_CURSORë¡? ë³?ê²½í•´?„œ ì¢??” ?•Œ?•„ë³´ê¸° ?‰½ê²Œí•œ?‹¤.
				normalButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// ë§ˆìš°?Š¤ê°? ?•„?´ì½˜ì„ ë²—ì–´ ?‚¬?„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			@Override
			public void mouseExited(MouseEvent e) {
				// ?•„?´ì½? ?´ë¯¸ì?ë¥? ê¸°ë³¸?´ë¯¸ì¡¸ ë³?ê²?
				normalButton.setIcon(normalButtonImage);
				normalButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// ë§ˆìš°?Š¤ê°? practiceButton ?•„?´ì½? ?ˆŒ???„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			@Override
			public void mousePressed(MouseEvent e) {
				// ?…¸ë§? ë²„íŠ¼ ?´ë²¤íŠ¸ ì²˜ë¦¬
				isFadeOut = true;
				isNormalGameScreen = true;
			}
		});

		// challengeButton?˜ ?œ„ì¹? ?„¤? • xì¢Œí‘œ,yì¢Œí‘œ,?¬ê¸? (ê°?ë¡? x ?„¸ë¡?)
		buttonSet(challengeButton, 680, 360, 234, 38); //
		/**
		 * challengeButton?˜ ë§ˆìš°?Š¤ ?´ë²¤íŠ¸ë¥? ì²˜ë¦¬?•´ì¤??‹¤.
		 */

		challengeButton.addMouseListener(new MouseAdapter() {
			/**
			 * ë§ˆìš°?Š¤ê°? ?•„?´ì½? ?œ„?— ?ˆ?„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// ?•„?´ì½? ?´ë¯¸ì?ë¥? Entered ?´ë¯¸ì?ë¡? ë³?ê²?
				challengeButton.setIcon(challengeButtonEnteredImage);
				// ì»¤ì„œ ?´ë¯¸ì??„ HAND_CURSORë¡? ë³?ê²½í•´?„œ ì¢??” ?•Œ?•„ë³´ê¸° ?‰½ê²Œí•œ?‹¤.
				challengeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// ë§ˆìš°?Š¤ê°? ?•„?´ì½˜ì„ ë²—ì–´ ?‚¬?„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			@Override
			public void mouseExited(MouseEvent e) {
				// ?•„?´ì½? ?´ë¯¸ì?ë¥? ê¸°ë³¸?´ë¯¸ì¡¸ ë³?ê²?
				challengeButton.setIcon(challengeButtonImage);
				challengeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// ë§ˆìš°?Š¤ê°? practiceButton ?•„?´ì½? ?ˆŒ???„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			@Override
			public void mousePressed(MouseEvent e) {
				// ì±Œë¦°ì§? ë²„íŠ¼ ?´ë²¤íŠ¸ ì²˜ë¦¬
				isFadeOut = true;
				isChallengeGameScreen = true;
			}
		});

		// practiceButton?˜ ?œ„ì¹? ?„¤? • xì¢Œí‘œ,yì¢Œí‘œ,?¬ê¸? (ê°?ë¡? x ?„¸ë¡?)
		buttonSet(practiceButton, 540, 580, 213, 40); //
		/**
		 * practiceButton?˜ ë§ˆìš°?Š¤ ?´ë²¤íŠ¸ë¥? ì²˜ë¦¬?•´ì¤??‹¤.
		 */

		practiceButton.addMouseListener(new MouseAdapter() {
			/**
			 * ë§ˆìš°?Š¤ê°? ?•„?´ì½? ?œ„?— ?ˆ?„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// ?•„?´ì½? ?´ë¯¸ì?ë¥? Entered ?´ë¯¸ì?ë¡? ë³?ê²?
				practiceButton.setIcon(practiceButtonEnteredImage);
				// ì»¤ì„œ ?´ë¯¸ì??„ HAND_CURSORë¡? ë³?ê²½í•´?„œ ì¢??” ?•Œ?•„ë³´ê¸° ?‰½ê²Œí•œ?‹¤.
				practiceButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// ë§ˆìš°?Š¤ê°? ?•„?´ì½˜ì„ ë²—ì–´ ?‚¬?„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			@Override
			public void mouseExited(MouseEvent e) {
				// ?•„?´ì½? ?´ë¯¸ì?ë¥? ê¸°ë³¸?´ë¯¸ì¡¸ ë³?ê²?
				practiceButton.setIcon(practiceButtonImage);
				practiceButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// ë§ˆìš°?Š¤ê°? practiceButton ?•„?´ì½? ?ˆŒ???„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			@Override
			public void mousePressed(MouseEvent e) {
				// ?—°?Šµ ë²„íŠ¼ ?´ë²¤íŠ¸ ì²˜ë¦¬
				isFadeOut = true;
				isPracticeGameScreen = true;
			}
		});

		// backButton?˜ ?œ„ì¹? ?„¤? •
		buttonSet(backButton, 80, 60, 228, 57);
		/**
		 * backButton?˜ ë§ˆìš°?Š¤ ?´ë²¤íŠ¸ë¥? ì²˜ë¦¬?•´ì¤??‹¤.
		 */

		backButton.addMouseListener(new MouseAdapter() {
			/**
			 * ë§ˆìš°?Š¤ê°? ?•„?´ì½? ?œ„?— ?ˆ?„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				// ?•„?´ì½? ?´ë¯¸ì?ë¥? Entered ?´ë¯¸ì?ë¡? ë³?ê²?
				backButton.setIcon(backButtonEnteredImage);
				// ì»¤ì„œ ?´ë¯¸ì??„ HAND_CURSORë¡? ë³?ê²½í•´?„œ ì¢??” ?•Œ?•„ë³´ê¸° ?‰½ê²Œí•œ?‹¤.
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// ë§ˆìš°?Š¤ê°? ?•„?´ì½˜ì„ ë²—ì–´ ?‚¬?„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			@Override
			public void mouseExited(MouseEvent e) {
				// ?•„?´ì½? ?´ë¯¸ì?ë¥? ê¸°ë³¸?´ë¯¸ì¡¸ ë³?ê²?
				backButton.setIcon(backButtonImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// ë§ˆìš°?Š¤ê°? backButton ?•„?´ì½? ?ˆŒ???„?•Œ ?´ë²¤íŠ¸ ì²˜ë¦¬
			@Override
			public void mousePressed(MouseEvent e) {
				isFadeOut = true;
				isMainScreen = true;
			}
		});

	}

	/**
	 * fadeIn ?š¨ê³¼ë?? ì£¼ê¸°?œ„?•œ ë©”ì†Œ?“œ tempë¥? ?‚¬?š©?•œ ?´?œ ?Š” fadeInê°’ì´ 1.0?„ ?„˜?–´ê°?ë©? ?—?Ÿ¬ê°? ë°œìƒ?•˜ê¸? ?•Œë¬¸ì— float?—°?‚° ?Š¹?„±?ƒ
	 * 0.1?”© 10ë²? ì¦ê??‹œ?‚¤ë©? 1.0?´ ?•„?‹ˆ?¼ 1.000001?´ ?˜?„œ ?—?Ÿ¬ê°? ë°œìƒ?•œ?‹¤. ?”°?¼?„œ tempë¥? ì¦ê??‹œ?‚¤ê³? fadeIn?— ???…?‹œ?‚¤?Š”
	 * ë°©ì‹?„ ?‚¬?š©?•œ?‹¤. ?—¬ê¸°ì„œ tempê°? 1ë³´ë‹¤ ì»¤ì?ë©? tempë¥? 1ë¡? ?„¤? •?•˜ê³? ???…?‹œì¼œì??‹¤.
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

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// graphicsë¥? 2Dë¡? ë³?ê²?
		Graphics2D g2 = (Graphics2D) g;
		// ?ˆ¬ëª…ë„ë¥? ì¡°ì ˆ?•˜ê¸? ?œ„?•œ ë¶?ë¶? fadeValue ê°? 1.0?´ë©? ë¶ˆíˆ¬ëª…ë„ 100%, 0.1?´ë©? ë¶ˆíˆ¬ëª…ë„ê°? 10% ?´?‹¤.
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, fadeValue));
		g2.drawImage(musicSelectBackGround, 0, 0, null);
		g2.drawImage(gameSelectBackGround, 0, 0, null);
		g2.drawImage(selectedImage, 0, 0, null);
	}

	// run ?•¨?ˆ˜?—?„œ whileë¬¸ì„ ?†µ?•´ ê³„ì† ?™”ë©´ì„ ê·¸ë ¤ì¤Œìœ¼ë¡œì¨ ?‹¤?Œ ?™”ë©´ìœ¼ë¡? ?„˜?–´ê°? ?ˆ˜ ?ˆê²? ?•´ì¤??‹¤.
	@Override
	public void run() {
		fadeIn();
		while (true) {
			repaint();
			try {
				if (isFadeOut && (isMainScreen)) {
                	fadeOut();
              		insideOut.changeMainScreen(0);
              		// ë©”ì¸?œ¼ë¡? ?Œ?•„ê°??•¼ ?•˜ê¸? ?•Œë¬¸ì— ?˜„?¬ ?‹¤?–‰?•˜ê³? ?ˆ?Š” ?Œ?•…?„ ì¢…ë£Œ?•œ?‹¤.
					selectedMusic.close();
					return;

				} else if (isFadeOut && (isNormalGameScreen || isChallengeGameScreen || isPracticeGameScreen)) {
					fadeOut();
	            	insideOut.changeGameScreen();
	    			// ê²Œì„ ?™”ë©´ìœ¼ë¡?  ? „?™˜?•´?•¼ ?•˜ê¸? ?•Œë¬¸ì— ?˜„?¬ ?‹¤?–‰?•˜ê³? ?ˆ?Š” ?Œ?•…?„ ì¢…ë£Œ?•œ?‹¤.
					selectedMusic.close();
					return;
				}
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

    // ?…¸?˜ë¥? ?„ ?ƒ?•˜ê¸? ?œ„?•´ ë§Œë“  ë©”ì†Œ?“œ 
	public void selectTrack(int nowSelected) {
		if (selectedMusic != null)
			selectedMusic.close();
		// ?…¸?˜ ?„ ?ƒ?‹œ?˜ image êµ¬í˜„
		selectedImage = new ImageIcon(
				getClass().getClassLoader().getResource("images/" + trackList.get(nowSelected).getStartImage())).getImage();
		// Music ê°ì²´ë¥? ?ƒˆë¡? ë§Œë“¦?œ¼ë¡œì¨ ?‹¤?–‰?•˜ê³ ì ?•˜?Š” ê³¡ì„ ë¬´í•œ ë°˜ë³µ ?‹œ?‚¨?‹¤.
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true,0);
		selectedMusic.start(); // ë¬´í•œ ?¬?ƒ
	}

	// ?™¼ìª? ë²„íŠ¼?„ ?ˆŒ???„ ?•Œ?˜ ?´ë²¤íŠ¸ ì²˜ë¦¬
	public void selectLeft() {
		if (nowSelected == 0)
			nowSelected = trackList.size() - 1; // ì²? ë²ˆì§¸ê³¡ì—?„œ ?™¼ìª? ë²„íŠ¼?„ ?ˆ„ë¥´ë©´ ê°??¥ ?˜¤ë¥¸ìª½ ê³¡ì´ ?„ ?ƒ?˜?–´?•¼ ?•˜ê¸? ?•Œë¬?
		else
			nowSelected--; // ê·? ?™¸?˜ ê²½ìš°?Š” 1?„ ë¹¼ì¤Œ
		selectTrack(nowSelected);
	}

	// ?˜¤ë¥¸ìª½ ë²„íŠ¼?„ ?ˆŒ???„ ?•Œ?˜ ?´ë²¤íŠ¸ ì²˜ë¦¬
	public void selectRight() {
		if (nowSelected == trackList.size() - 1)
			nowSelected = 0; // ?™¼ìª½ê³¼ ë°˜ë?
		else
			nowSelected++; // ë§ˆì°¬ê°?ì§?ë¡? ê·? ?™¸?˜ ê²½ìš°?Š” 1?„ ?”?•¨
		selectTrack(nowSelected);
	}

	// ?¼?¼?´ ?‹¤ ?„¤? •?•˜ê¸? ?˜?“œë¯?ë¡? ë©”ì†Œ?“œë¥? ?†µ?•´ ?†?‰½ê²? ë²„íŠ¼?˜ ?œ„ì¹˜ë?? ?„¤? •
	public void buttonSet(JButton button, int x, int y, int width, int height) {
		button.setBounds(x, y, width, height);
		// ë²„íŠ¼ ?…Œ?‘ë¦? ? œê±?
		button.setBorderPainted(false);
		// ?ˆ„ë¥´ëŠ” ?Š?‚Œ ? œê±?
		button.setContentAreaFilled(false);
		// ê¸??”¨ ?…Œ?‘ë¦? ? œê±?
		button.setFocusPainted(false);
		// ë²„íŠ¼ ì¶”ê?
		add(button);
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}
}