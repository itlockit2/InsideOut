package project_04;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 게임 시야 제한 이벤트를 위한 클래스
 * @author Jimin Kim
 * @version 0.4
 */
public class GameSightLimit {
  
	
	/** 게임 진행중 시야 제한 이벤트를 위한 이미지 */
	private Image gameSightLimitImage;
	/** Screen 제한의 출현위치 x좌표를 나타내는 필드값 */
	private int x;
	/** Screen 제한의 출현위치 y좌표를 나타내는 필드값 */
	private int y;
	/** 시야제한 이벤트를 시작하는 시간을 나타내는 필드값*/
	private long startTime;
	/** 시야제한 이벤트를 끝내는 지점을 나타내는 필드값 */
	private long endTime;
   
	/**
	 * startTime과 endTime을 매개변수로 받아서 초기화 시켜준다.
	 * @param startTime
	 * @param endTime
	 */
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

	/** 시야제한 이미지를 리턴해주는 메소드이다. */
	public Image getGameSightLimitImage() {
		return gameSightLimitImage;
	}
	/** 시야제한 이미지의 x좌표를 리턴해주는 메소드이다. */
	public int getX() {
		return x;
	}
	/** 시야제한 이미지의 y좌표를 리턴해주는 메소드이다. */
	public int getY() {
		return y;
	}
	/** 시야 제한 이미지의 시작시간을 리턴해주는 메소드이다. */
	public long getStartTime() {
		return startTime;
	}
	/** 시야 제한 이미지의 끝나는 지점을 리턴해주는 메소드이다. */
	public long getEndTime() {
		return endTime;
	}	
}
