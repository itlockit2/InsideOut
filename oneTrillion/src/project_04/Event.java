package project_04;

import java.util.ArrayList;

public class Event {
	/** 장애물 구현을 위한 객체 */
	private ArrayList<SavePoint> savePoints;
	
	public Event(String musicTitle) {
		savePoints = new ArrayList<SavePoint>();
		if(musicTitle.equals("Tobu & Itro - Sunburst_Highlight.mp3")) {
		savePoints.add(new SavePoint(611,70,5735));
		} else if(musicTitle.equals("BadNewsHighLight.mp3")) {
			savePoints.add(new SavePoint(611,70,5735));
			savePoints.add(new SavePoint(611,70,15735));
			savePoints.add(new SavePoint(611,70,25735));
		}
	}

	public ArrayList<SavePoint> getSavePoint() {
		return savePoints;
	}

	public void setSavePoint(ArrayList<SavePoint> savePoint) {
		this.savePoints = savePoint;
	}
	
	

}
