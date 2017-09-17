package project_01;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;

/**
 * 게임의 전반적인 컨트롤을 해주는 클래스이다.
 * 
 * @author Yun
 *
 */
public class InsideOut extends JFrame {
	
	// MainScreenPanel 객체이다.
	private MainScreenPanel mainScreenPanel;
	// 필요한 정보를 출력하는 부분이 contentpane 이다.
	private Container contentpane;
	
	public InsideOut() {
		// 게임이름 설정
		setTitle("Inside Out");
		// 게임을 끄면 완전히 종료, 반드시 필요한 함수
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// getContentPane 으로 contentpane 정보를 얻어온다.
		contentpane = getContentPane();
		// 게임창 크기 설정
		setSize(Main.SCREENT_WIDTH, Main.SCREENT_HEIGHT);
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
		// 메인 패널 생성
		mainScreenPanel = new MainScreenPanel();
		// 패널을 추가해준다.
		contentpane.add(mainScreenPanel);
		// MainPanel의 쓰레드 실행
		mainScreenPanel.getThread().start();
		// 화면 출력 설정 기본값은 false 이므로 설정 해줘야한다.
		setVisible(true);
	}
}
