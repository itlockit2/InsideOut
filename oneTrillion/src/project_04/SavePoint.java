package project_04;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class SavePoint {

	/** 장애물 이미지를 위한 객체 */
	private Image savePointImage;
	/** 장애물 의 구현위치 */
	private int x, y, rectX, rectY;
	private long startTime;
	private long endTime;

	private Rectangle2D rect;

	
	
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


	
	
	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}




	public int getX() {
		return x;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public Rectangle2D getRect() {
		return rect;
	}

	public void setRect(Rectangle2D rect) {
		this.rect = rect;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getSavePointImage() {
		return savePointImage;
	}

	public void setSavePointImage(Image savePointImage) {
		this.savePointImage = savePointImage;
	}
	
	
}
