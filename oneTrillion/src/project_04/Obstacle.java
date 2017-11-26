package project_04;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

/** 장애물 구현을 위한 클래스 이다.
 * 
 * @author SungHo Yun
 * @version 0.4
 */
public class Obstacle{
	/** 장애물 이미지를 위한 객체  */
	private Image obstacleImage;
	/** 장애물 의 구현위치 */
	private int x, y;
	/** 원중심의 위치와 반지름 */
	private int circleX, circleY, circleRadius;
	/** Ball 객체의 반지름 값  */
	private double radian;
	
	/** Thread 객체 */
	private Thread thread;
	
	private long startTime;
	private long endTime;
	
	private Rectangle2D rect;
	
	private Shape shape;
	
	private int rectX, rectY;
	
	/** 원의 반지름과 원 중심의 위치를 받아오고 라디안값을 받아와서 장애물을 구현한다. 
	 * 
	 * @param circleRadius
	 * @param circleX
	 * @param circleY
	 * @param radian
	 */
	public Obstacle(Ball ball, double radian, int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		obstacleImage = new ImageIcon(getClass().getClassLoader().getResource("images/obstacleImage.png")).getImage();
		this.circleRadius = ball.getRotateRadius();
		this.circleX = ball.getCircleX();
		this.circleY = ball.getCircleY();
		this.radian = radian;
		this.x =   obstacleImage.getWidth(null) /-2 + circleX + (int) (circleRadius * Math.cos(Math.toRadians(radian))  );
		this.y =   obstacleImage.getHeight(null) /-2 + circleY + (int) (circleRadius * Math.sin(Math.toRadians(radian) )  );
		this.rectX = obstacleImage.getWidth(null) /-2 + circleX + (int) ((circleRadius+10) * Math.cos(Math.toRadians(radian))  );
		this.rectY = obstacleImage.getHeight(null) /-2 + circleY + (int) ((circleRadius+10) * Math.sin(Math.toRadians(radian) )  );
		rect = new Rectangle2D.Double(rectX, rectY, obstacleImage.getWidth(null), obstacleImage.getHeight(null));
		rotateImage(radian+90);
		rotateRect(radian+90);
	}
	
	/** 라디안을 받아와서 해당 라디안에 맞는 각도로 이미지를 회전시켜준다.
	 * 
	 * @param radian
	 */
	public void rotateImage(double radian) {
		ImageIcon icon = new ImageIcon(this.obstacleImage);
		BufferedImage blankCanvas = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D)blankCanvas.getGraphics();
		g2.rotate(Math.toRadians(radian), icon.getIconWidth()/2 , icon.getIconHeight()/2);
		g2.drawImage(this.obstacleImage, 0, 0, null);
		this.obstacleImage = blankCanvas;
	}
	
	public void rotateRect(double radian) {
		AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(radian), rect.getCenterX(), rect.getCenterY());
		Shape rotatedRect = at.createTransformedShape(rect);
		this.shape = rotatedRect;
	}
	
	
	

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public Rectangle2D getRect() {
		return rect;
	}

	public void setRect(Rectangle2D rect) {
		this.rect = rect;
	}

	/** 장애물의 구현위치중 x의 값을 받아온다. 
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/** 장애물의 구현위치중 y의 값을 받아온다.
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/** 장애물의 이미지를 받아온다.
	 * 
	 * @return obstacleImage
	 */
	public Image getObstacleImage() {
		return obstacleImage;
	}

	public long getStartTime() {
		return startTime;
	}
	
	public long getEndTime() {
		return endTime;
	}

	public double getRadian() {
		return radian;
	}

	public void setRadian(double radian) {
		this.radian = radian;
	}
	
	
	
}
