package project_04;

import java.util.ArrayList;

public class Event {
	/** 장애물 구현을 위한 객체 */
	private ArrayList<SavePoint> savePoints;
	
	public Event(String musicTitle) {
		savePoints = new ArrayList<SavePoint>();
		//if(musicTitle.equals("abcd))
		savePoints.add(new SavePoint(429,131,5735));
	}

	public ArrayList<SavePoint> getSavePoint() {
		return savePoints;
	}

	public void setSavePoint(ArrayList<SavePoint> savePoint) {
		this.savePoints = savePoint;
	}
	
	

}
