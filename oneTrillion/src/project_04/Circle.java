package project_04;

import java.awt.BasicStroke;
import java.awt.Color;

/**
 * 게임 플레이를 위한 스테이지인 원에 관한 클래스이다.
 * @author SungHo Yun
 * @version 0.4
 */
public class Circle {
	/** 원의 좌표 원의 크기 에 관한 변수이다. */
	private int x,y, width, height;
	/** 원의 굴기에 관한 변수이다. */
	BasicStroke stroke;
	/** 원색깔을 위한 변수이다. */
	private Color color;
	
	/**
	 * 원의 좌표와 원의 크기 그리고 굴기와 색깔을 생성자를 통해서 초기화 시켜준다.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param stroke
	 * @param color
	 */
	public Circle(int x, int y, int width, int height, int stroke, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.stroke = new BasicStroke(stroke);
		this.color = color;
	}

	/**
	 * 원의 좌표값 x 를 리턴값으로 반환한다.
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * 원의 좌표값 x를 설정해준다.
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 원의 좌표값 y를 리턴값으로 반환한다.
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * 원의 좌표값 y를 설정해준다.
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 원의 가로길이를 리턴값으로 반환한다.
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 원의 가로길이를 설정해준다.
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * 원의 세로길이를 리턴값으로 반환한다.
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 원의 세로길이를 설정해준다.
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * 원의 굴기값을 리턴값으로 반환한다.
	 * @return stroke
	 */
	public BasicStroke getStroke() {
		return stroke;
	}

	/**
	 * 원의 굵기값을 설정해준다.
	 * @param stroke
	 */
	public void setStroke(int stroke) {
		this.stroke = new BasicStroke(stroke);
	}

	/**
	 * 원의 색깔을 리턴값으로 반환한다.
	 * @return color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * 원의 색깔을 설정해준다.
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
