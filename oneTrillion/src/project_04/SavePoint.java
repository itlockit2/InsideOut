package project_04;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

/**
 * SavePoint 구현을 위한 클래스
 * @author Sungho Yun
 * @version 0.4
 */
public class SavePoint {

	/** 세이브 포인트 이미지를 위한 객체 */
	private Image savePointImage;
	/** 세이브 포인트의 구현위치 x좌표 */
	private int x;
	/** 세이브 포인트의 구현위치 y좌표*/
	private int y;
	/** 세이브포인트의 피격판정 범위의 x좌표 */
	private int rectX;
	/** 세이브 포인트의 피격판정 범위의 y좌표*/
	private int rectY;
	/** 세이브 포인트가 나타나는 시작지점*/
	private long startTime;
	/** 세이브 포인트가 사라지는 끝지점*/
	private long endTime;
	/** 세이브포인트 피격판정을 위한 Rectangle2D 클래스 객체 */
	private Rectangle2D rect;

	/**
	 * SavePoint의 구현위치인 x좌표와 y좌표
	 * 그리고 출현지점을 매개변수로 받아 초기화 시켜준다.
	 * @param x
	 * @param y
	 * @param startTime
	 */
	public SavePoint(int x, int y,int startTime) {
		this.startTime = startTime;
		savePointImage = new ImageIcon(
				getClass().getClassLoader().getResource("images/savePoint.gif")).getImage();
		
		this.x = x-37;
		this.y = y-37;
		this.rectX = x;
		this.rectY = y;
		rect = new Rectangle2D.Double(rectX,rectY ,80, 80);
		endTime = Long.MAX_VALUE;
	}

	/**
	 * 세이브포인트의 끝지점을 반환해주는 메소드
	 * @return
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * 세이브포인트의 끝지점을 설정해주는 메소드
	 * @param endTime
	 */
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	/**
	 * 세이브포인트의 출현위치 x좌표를 리턴해주는 메소드
	 * @return
	 */
	public int getX() {
		return x;
	}
	/**
	 * 세이브포인트의 출현지점을 리턴해주는 메소드
	 * @return
	 */
	public long getStartTime() {
		return startTime;
	}
	/**
	 * 세이브포인트의 피격판정 범위를 리턴해주는 메소드
	 * @return
	 */
	public Rectangle2D getRect() {
		return rect;
	}
	/**
	 * 세이브포인트의 출현위치 y좌표를 리턴해주는 메소드
	 * @return
	 */
	public int getY() {
		return y;
	}
	/**
	 * 세이브포인트의 이미지를 리턴해주는 메소드
	 * @return
	 */
	public Image getSavePointImage() {
		return savePointImage;
	}	
}
