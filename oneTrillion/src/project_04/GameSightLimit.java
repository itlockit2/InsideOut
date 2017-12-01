package project_04;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GameSightLimit {
  
	
	/** 게임 진행중 시야 제한 이벤트를 위한 이미지 */
	private Image gameSightLimitImage;
	/** Screen 제한의 출현위치 및 시간 */
	private int x, y;
	private long startTime;
	private long endTime;
   
	public GameSightLimit( int startTime, int endTime) {
      	
		gameSightLimitImage = new ImageIcon(getClass().getClassLoader().getResource("images/sightLimitImage.png"))
				.getImage();
		
	    // x좌표
		this.x = x ;
	    // y좌표
		this.y = y;
		// 시야를 제한 할 시작 시간
		this.startTime = startTime;
		// 시야 제한을 끝낼 시간
		this.endTime = endTime;
			
	}

	public Image getGameSightLimitImage() {
		return gameSightLimitImage;
	}

	public void setGameSightLimitImage(Image gameSightLimitImage) {
		this.gameSightLimitImage = gameSightLimitImage;
	}

	public int getX() {
		return x;
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

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	
}
