package project_04;

/** 게임 실행을 위한 Main클래스 이다.
 * Inside_Out 객체를 만듬으로써 게임을 시작한다.
 * 
 * @author Yun
 * @version 0.4
 *
 */
public class Main {
	
	public static final int SCREEN_WIDTH = 1280; // 1280 x 720 사이즈로 출력
	public static final int SCREEN_HEIGHT = 720;
	
	public static void main(String[] args) {
	
		new InsideOut();

	}
}
