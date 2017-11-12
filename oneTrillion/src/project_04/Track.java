package project_04;

//하나의 곡에 대한 정보를 담는 클래스 
public class Track {
 
	private String titleImage; // 제목 부분 이미지
	private String startImage; // 게임 선택 창 표지 이미지
	private String startMusic; // 게임 선택 창 음악
	private String gameMusic; // 해당 곡을 실행했을 때의 음악 
	
	private int drawX;
	private int drawY;
	
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	
	public int getDrawX() {
		return drawX;
	}
	
	public int getDrawY() {
		return drawY;
	}
	
	public Track(String titleImage, String startImage, String startMusic, String gameMusic, int drawX, int drawY) {
		super();
	    this.titleImage = titleImage;
		this.startImage = startImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.drawX = drawX;
		this.drawY = drawY;
	}
	
	
	
	
}
