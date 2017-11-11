package project_04;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Obstacle{
	private Image obstacleImage = new ImageIcon(getClass().getClassLoader().getResource("images/obstacleImage.png")).getImage();
	private int x, y;
	private int circleX, circleY, circleRadius;
	private double size;
	
	// Thread °´Ã¼
	private Thread thread;
	
	// ball °´Ã¼
	Ball b;
	
	public Obstacle(int circleRadius, int circleX, int circleY, double size) {
		this.circleRadius = circleRadius;
		this.circleX = circleX;
		this.circleY = circleY;
		this.size = size;
		this.x =   obstacleImage.getWidth(null) /-2 + circleX + (int) (circleRadius * Math.cos(Math.toRadians(size))  );
		this.y =   obstacleImage.getHeight(null) /-2 + circleY + (int) (circleRadius * Math.sin(Math.toRadians(size) )  );
		rotateImage(size+90);
	}
	
	public void rotateImage(double radian) {
		ImageIcon icon = new ImageIcon(this.obstacleImage);
		BufferedImage blankCanvas = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D)blankCanvas.getGraphics();
		g2.rotate(Math.toRadians(radian), icon.getIconWidth()/2 , icon.getIconHeight()/2);
		g2.drawImage(this.obstacleImage, 0, 0, null);
		this.obstacleImage = blankCanvas;
	}
	


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}

	public Image getObstacleImage() {
		return obstacleImage;
	}

	
}
