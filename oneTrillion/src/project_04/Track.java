package project_04;

/** 하나의 곡에 대한 정보를 담는 클래스 
 * @author Jimin Kim
 * @version 0.4
 */
public class Track {
 
	/** 타이틀 이미지파일 이름 */
	private String titleImage;
	/** 게임 선택시 보여지는 이미지 파일 이름 */
	private String startImage; 
	/** 게임 선택시 시작하는 음악 파일 이름 */
	private String startMusic; 
	/** 게임 진행시 시작되는 음악 파일 이름 */
	private String gameMusic; 
	/** 곡 제목이 출력되는 위치가 저장되어 있는 x값  */
	private int drawX;
	/** 곡 제목이 출력되는 위치가 저장되어 있는 y값  */
	private int drawY;
	
	private double gameSpeed;
	
	private long closedMusicTime;
	
	/** titleImage의 이름, StartImage의 이름, startMusic의 이름 gameMusic의 이름, 곡제목을 출력시킬 drawX, drawY값을 생성자로 받아 초기화시켜준다. 
	 * 
	 * @param titleImage
	 * @param startImage
	 * @param startMusic
	 * @param gameMusic
	 * @param drawX
	 * @param drawY
	 */
	public Track(String titleImage, String startImage, String startMusic, String gameMusic, int drawX, int drawY, double gameSpeed, long closedMusicTime) {
		super();
	    this.titleImage = titleImage;
		this.startImage = startImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.drawX = drawX;
		this.drawY = drawY;
		this.gameSpeed = gameSpeed;
		this.closedMusicTime = closedMusicTime;
	}

	/** titleImage의 이름 반환한다.
	 * 
	 * @return titleImage
	 */
	public String getTitleImage() {
		return titleImage;
	}
	/** startImage의 이름 반환한다.
	 * 
	 * @return startImage
	 */
	public String getStartImage() {
		return startImage;
	}
	/** startMusic의 이름 반환한다.
	 * 
	 * @return startMusic
	 */
	public String getStartMusic() {
		return startMusic;
	}
	/** gameMusic의 이름 반환한다.
	 * 
	 * @return gameMusic
	 */
	public String getGameMusic() {
		return gameMusic;
	}
	/** 곡 제목이 출력되는 위치가 저장되어 있는 x값 을 반환한다.
	 * 
	 * @return drawX
	 */
	public int getDrawX() {
		return drawX;
	}
	/** 곡 제목이 출력되는 위치가 저장되어 있는 y값을 반환한다.
	 *  
	 * @return drawY
	 */
	public int getDrawY() {
		return drawY;
	}

	public double getGameSpeed() {
		return gameSpeed;
	}

	public void setGameSpeed(double gameSpeed) {
		this.gameSpeed = gameSpeed;
	}	
	
	public long getClosedMusicTime() {
		return closedMusicTime;
	}

	public void setClosedMusicTime(long closedMusicTime) {
		this.closedMusicTime = closedMusicTime;
	}
	
}
