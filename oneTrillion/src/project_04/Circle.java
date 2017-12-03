package project_04;

import java.awt.BasicStroke;
import java.awt.Color;

/**
 * 게임 플레이를 위한 스테이지인 원에 관한 클래스이다.
 * 
 * @author SungHo Yun
 * @version 0.4
 */
public class Circle implements Runnable {
	/** 원이 그려지는 시작점인 x좌표를 나타내는 필드 이다. 원의중심x좌표 - 반지름이다. */
	private int x;
	/** 원의 그려지는 시작점인 y좌표를 나타내는 필드 이다. 원의중심y좌표 - 반지름이다/ */
	private int y;
	/** 원의 넓이를 나타내는 필드 이다. radian의 2배이다. */
	private int width;
	/** 원의 폭을 나타는 필드 이다. radian의 2배이다. */ 
	private int height;
	/** 원의 반지름을 나타내는 필드이다. */
	private int radian;
	/** 원의 중심 x좌표를 나타내는 필드이다.*/
	private int circleX;
	/** 원의 중심 y좌표를 나타내는 필드이다. */
	private int circleY;
	/** 원의 크기를 변화시킬때 사용하는 필드값이다. */
	private int changeSize;
	/** 원의 굴기에 관한 변수이다. */
	BasicStroke stroke;
	/** 원색깔을 위한 변수이다. */
	private Color color;
	/** Circle의 크기를 변경시키기 위한 thread이다.*/
	private Thread thread;


	/**
	 * 원의 중심, 반지름, 굵기, 색깔들을 매개변수로 받아 초기화 시켜준다.
	 * @param circleX
	 * @param circleY
	 * @param radian
	 * @param stroke
	 * @param color
	 */
	public Circle(int circleX, int circleY, int radian, int stroke, Color color) {
		// 쓰레드를 만들고 객체에 넣어준다.
		setThread(new Thread(this));
		this.circleX = circleX;
		this.circleY = circleY;
		this.radian = radian;
		this.x = circleX - radian;
		this.y = circleY - radian;
		this.width = radian * 2;
		this.height = radian * 2;
		this.stroke = new BasicStroke(stroke);
		this.color = color;
		changeSize = 0;
	}

	/**
	 * 쓰레드가 시작됫을때 changeSize 값이 0이아니라면 원이 changeSize만큼 증가하고 
	 * 한계점에 도달하면 다시 원래 원의 크기로 돌아온다.
	 */
	@Override
	public void run() {
		int initialRadian = radian;
		while (true) {
			try {
				int limitedSize = initialRadian + changeSize;
				x = circleX - radian;
				y = circleY - radian;
				width = radian * 2;
				height = radian * 2;
				if (changeSize != 0)
					radian++;
				if (radian >= limitedSize) {
					radian = initialRadian;
				}
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 원의 크기를 변화시키는 정도를 설정해주는 메소드이다. 
	 * @param changeSize
	 */
	public void setChangeSize(int changeSize) {
		this.changeSize = changeSize;
	}

	/**
	 * 원의 중심 x좌표를 반환하는 메소드이다.
	 * @return
	 */
	public int getCircleX() {
		return circleX;
	}
	
	/**
	 * 원의 중심 y좌표를 반환하는 메소드이다.
	 * @return
	 */
	public int getCircleY() {
		return circleY;
	}

	/**
	 * Circle 객체의 Thread를 반환하는 메소드이다.
	 * @return
	 */
	public Thread getThread() {
		return thread;
	}

	/**
	 * Cricle 객체의 Thread를 설정해주는 메소드이다.
	 * @param thread
	 */
	public void setThread(Thread thread) {
		this.thread = thread;
	}

	/**
	 * 원의 반지름을 반환하는 메소드이다.
	 * @return
	 */
	public int getRadian() {
		return radian;
	}

	/**
	 * 원이 그려지는 x좌표를 반환하는 메소드이다.
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * 원이 그려지는 y좌표를 설정하는 메소드이다.
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * 원의 넓이를 반환하는 메소드이다.
	 * @return
	 */
	public int getWidth() {
		return width;
	}


	/**
	 * 원의 폭을 반환하는 메소드이다.
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 원의 굵기를 반환하는 메소드이다. 
	 * @return
	 */
	public BasicStroke getStroke() {
		return stroke;
	}


	/**
	 * 원의 색깔을 반환하는 메소드이다.
	 * @return
	 */
	public Color getColor() {
		return color;
	}
}
