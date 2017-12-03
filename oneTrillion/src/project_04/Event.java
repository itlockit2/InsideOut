package project_04;

import java.util.ArrayList;

/**
 * 세이브포인트와 시야제한 이벤트를 위한 클래스 이다.
 * @author Sungho Yun
 * @version 0.4
 */
public class Event {
	/** 세이브포인트 지점들이 ArrayList로 되어있는 필드이다. */
	private ArrayList<SavePoint> savePoints;
	/** 게임시야제한 이벤트 지점들이 ArrayList로 되어있는 필드이다. */
	private ArrayList<GameSightLimit> gameSightLimitScreen;
	
	
	/**
	 * 생성자에서 musicTitle을 매개변수로 받아 그에 맞는 이벤트들이 배열에 추가된다.
	 * @param musicTitle
	 */
	public Event(String musicTitle) {
		savePoints = new ArrayList<SavePoint>();
		gameSightLimitScreen = new ArrayList<GameSightLimit>();
		
		if(musicTitle.equals("Tobu & Itro - Sunburst_Highlight.mp3")) {
		savePoints.add(new SavePoint(611,70,5735));
		
		} else if(musicTitle.equals("BadNewsHighLight.mp3")) {
			savePoints.add(new SavePoint(611,70,5735));
			savePoints.add(new SavePoint(611,70,15735));
			gameSightLimitScreen.add(new GameSightLimit(15735,25735));
			savePoints.add(new SavePoint(611,70,25735));
		} else if(musicTitle.equals("HeartBeatHighLight.mp3")) {
			savePoints.add(new SavePoint(611,70,10000));
			gameSightLimitScreen.add(new GameSightLimit(10000,24200));
		}
	}
	/**
	 * 시야제한 지점들이 모여있는 ArrayList를 반환한다.
	 * @return
	 */
	public ArrayList<GameSightLimit> getGameSightLimit() {
		return gameSightLimitScreen;
	}
	/**
	 * 세이브포인트 지점들이 모여있는 ArrayList를 반환한다.
	 * @return 
	 */
	public ArrayList<SavePoint> getSavePoint() {
		return savePoints;
	}
}
