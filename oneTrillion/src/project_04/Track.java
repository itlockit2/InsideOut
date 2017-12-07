package project_04;

/**
 * 하나의 곡에 대한 정보를 담는 클래스
 * 
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
	/** 곡 제목이 출력되는 위치가 저장되어 있는 x값 */
	private int drawX;
	/** 곡 제목이 출력되는 위치가 저장되어 있는 y값 */
	private int drawY;
	/** 곡의 진행속도가 저장되어 있는 값 */
	private double gameSpeed;
	/** 곡이 끝나는 지점이 저장되어 있는 값 */
	private long closedMusicTime;

	/**
	 * 곡의 제목 이미지 경로, 곡의 배경이미지 경로, 곡의 하이라이트 경로, 곡의 게임음악 경로, 그려지는 x좌표, 그려지는 y좌표 곡의 속도,
	 * 끝나는 지점을 매개변수로 받아 초기화시켜준다.
	 * 
	 * @param titleImage
	 * @param startImage
	 * @param startMusic
	 * @param gameMusic
	 * @param drawX
	 * @param drawY
	 * @param gameSpeed
	 * @param closedMusicTime
	 */
	public Track(String titleImage, String startImage, String startMusic, String gameMusic, int drawX, int drawY,
			double gameSpeed, long closedMusicTime) {
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

	/**
	 * titleImage의 이름 반환한다.
	 * 
	 * @return
	 */
	public String getTitleImage() {
		return titleImage;
	}

	/**
	 * startImage의 이름 반환한다.
	 * 
	 * @return
	 */
	public String getStartImage() {
		return startImage;
	}

	/**
	 * startMusic의 이름 반환한다.
	 * 
	 * @return startMusic
	 */
	public String getStartMusic() {
		return startMusic;
	}

	/**
	 * gameMusic의 이름 반환한다.
	 * 
	 * @return
	 */
	public String getGameMusic() {
		return gameMusic;
	}

	/**
	 * 곡 제목이 출력되는 위치가 저장되어 있는 x값 을 반환한다.
	 * 
	 * @return
	 */
	public int getDrawX() {
		return drawX;
	}

	/**
	 * 곡 제목이 출력되는 위치가 저장되어 있는 y값을 반환한다.
	 * 
	 * @return
	 */
	public int getDrawY() {
		return drawY;
	}

	/**
	 * 곡의 속도를 리턴해주는 메소드
	 * 
	 * @return
	 */
	public double getGameSpeed() {
		return gameSpeed;
	}

	/**
	 * 곡의 끝지점을 리턴해주는 메소드
	 * 
	 * @return
	 */
	public long getClosedMusicTime() {
		return closedMusicTime;
	}
}