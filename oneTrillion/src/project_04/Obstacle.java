package project_04;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

/**
 * 장애물 구현을 위한 클래스 이다.
 * 
 * @author SungHo Yun
 * @version 0.4
 */
public class Obstacle {
	/** 장애물 이미지를 위한 객체 */
	private Image obstacleImage;
	/** 장애물 의 구현위치의 x좌표 */
	private int x;
	/** 장애물 구현위치의 y좌표 */
	private int y;
	/** 원중심의 x좌표 */
	private int circleX;
	/** 원중심의 y좌표 */
	private int circleY;
	/** 원의 반지름 값 */
	private int circleRadius;
	/** 장애물이 가지고 있는 각값 */
	private double radian;
	/** obstacle이 그려지는 시작지점을 나타내는 필드값 */
	private long startTime;
	/** obstacle이 사라지는 지점을 나타내는 필드값*/
	private long endTime;
	/** obstacle의 피격판정을 나타내는 객체*/
	private Rectangle2D rect;
	/** Rectanngle2D를 회전하기 위한 Shape 객체 */
	private Shape shape;
	/** Rectangle2D의 위치 x좌표 */
	private int rectX;
	/** Rectangle2D의 위치 y좌표*/
	private int rectY;
	/** obstacle이 바깥쪽인지 안쪽인지를 나타내는 필드값 */
	private String location;
	/** 원의 반지름에 따라 만들어져야 하므로  Circle 객체를 가지고 있어야한다.*/
	private Circle circle;
	
	/**
	 * Circle 객체를 통해서 원의 반지름을 알아내고
	 * 장애물의 각값과 시작지점, 끝지점, 위치를 매개변수로 받아 초기화시킨다.
	 * @param circle
	 * @param radian
	 * @param startTime
	 * @param endTime
	 * @param location
	 */
	public Obstacle(Circle circle, double radian, int startTime, int endTime, String location) {
		this.circle = circle;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
		obstacleImage = new ImageIcon(
				getClass().getClassLoader().getResource("images/obstacle" + location + "Image.png")).getImage();
		if (location.equals("Up")) {
			this.circleRadius = circle.getRadian();
		} else {
			this.circleRadius = circle.getRadian() - 25;
		}
		this.circleX = circle.getCircleX();
		this.circleY = circle.getCircleY();
		this.radian = radian;
		this.x = obstacleImage.getWidth(null) / -2 + circleX + (int) (circleRadius * Math.cos(Math.toRadians(radian)));
		this.y = obstacleImage.getHeight(null) / -2 + circleY + (int) (circleRadius * Math.sin(Math.toRadians(radian)));
		if (location.equals("Up")) {
			this.rectX = obstacleImage.getWidth(null) / -2 + circleX
					+ (int) ((circleRadius + 10) * Math.cos(Math.toRadians(radian)));
			this.rectY = obstacleImage.getHeight(null) / -2 + circleY
					+ (int) ((circleRadius + 10) * Math.sin(Math.toRadians(radian)));
		} else {
			this.rectX = obstacleImage.getWidth(null) / -2 + circleX
					+ (int) ((circleRadius - 10) * Math.cos(Math.toRadians(radian)));
			this.rectY = obstacleImage.getHeight(null) / -2 + circleY
					+ (int) ((circleRadius - 10) * Math.sin(Math.toRadians(radian)));
		}
		rect = new Rectangle2D.Double(rectX, rectY, obstacleImage.getWidth(null), obstacleImage.getHeight(null));
		rotateImage(radian + 90);
		rotateRect(radian + 90);
	}

	/**
	 * 라디안을 받아와서 해당 라디안에 맞는 각도로 이미지를 회전시켜준다.
	 * @param radian
	 */
	public void rotateImage(double radian) {
		ImageIcon icon = new ImageIcon(this.obstacleImage);
		BufferedImage blankCanvas = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D) blankCanvas.getGraphics();
		g2.rotate(Math.toRadians(radian), icon.getIconWidth() / 2, icon.getIconHeight() / 2);
		g2.drawImage(this.obstacleImage, 0, 0, null);
		this.obstacleImage = blankCanvas;
	}

	/**
	 * 라디안을 받아와서 해당 라디안에 맞는 각도로 Rectangle2D를 회전시킨다.
	 * @param radian
	 */
	public void rotateRect(double radian) {
		AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(radian), rect.getCenterX(),
				rect.getCenterY());
		Shape rotatedRect = at.createTransformedShape(rect);
		this.shape = rotatedRect;
	}
	
	/**
	 * 원의 반지름이 달라질 경우 resetLocation 메소드를 통해 다시 Obstacle의 구현위치를 재계산해준다.
	 */
	public void resetLocation() {
		if (location.equals("Up")) {
			this.circleRadius = circle.getRadian() +15;
		} else {
			this.circleRadius = circle.getRadian() -15;
		}

		this.circleX = circle.getCircleX();
		this.circleY = circle.getCircleY();
		this.x = obstacleImage.getWidth(null) / -2 + circleX
				+ (int) (circleRadius * Math.cos(Math.toRadians(radian)));
		this.y = obstacleImage.getHeight(null) / -2 + circleY
				+ (int) (circleRadius * Math.sin(Math.toRadians(radian)));
		if (location.equals("Up")) {
			this.rectX = obstacleImage.getWidth(null) / -2 + circleX
					+ (int) ((circleRadius + 20) * Math.cos(Math.toRadians(radian)));
			this.rectY = obstacleImage.getHeight(null) / -2 + circleY
					+ (int) ((circleRadius + 20) * Math.sin(Math.toRadians(radian)));
		} else {
			this.rectX = obstacleImage.getWidth(null) / -2 + circleX
					+ (int) ((circleRadius - 20) * Math.cos(Math.toRadians(radian)));
			this.rectY = obstacleImage.getHeight(null) / -2 + circleY
					+ (int) ((circleRadius - 20) * Math.sin(Math.toRadians(radian)));
		}
		rect.setRect(rectX, rectY,  obstacleImage.getWidth(null),
				obstacleImage.getHeight(null));
		rotateRect(radian + 90);
	}

	/**
	 * 장애물의 피격판정 범위인 Shape를 반환해주는 메소드.
	 * @return
	 */
	public Shape getShape() {
		return shape;
	}
	/**
	 * 장애물의 구현위치중 x의 값을 받아온다.
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * 장애물의 구현위치중 y의 값을 받아온다.
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * 장애물의 이미지를 받아온다.
	 * 
	 * @return obstacleImage
	 */
	public Image getObstacleImage() {
		return obstacleImage;
	}

	/**
	 * 장애물의 시작지점을 리턴해주는 메소드이다.
	 * @return
	 */
	public long getStartTime() {
		return startTime;
	}
	/**
	 * 장애물의 끝지점을 리턴해주는 메소드이다.
	 * @return
	 */
	public long getEndTime() {
		return endTime;
	}
	/**
	 * 장애물의 각값인 라디안을 리턴해주는 메소드이다.
	 * @return
	 */
	public double getRadian() {
		return radian;
	}
	/**
	 * 장애물 피격판정을 위한 rect객체를 리턴해주는 메소드이다.
	 * @return
	 */
	public Rectangle2D getRect() {
		return rect;
	}
	
	
}
