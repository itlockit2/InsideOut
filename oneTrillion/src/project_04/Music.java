package project_04;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

/** mp3파일을 실행시켜주는 클래스로 JavaZoom에서 지원하는 외부라이브러리를 사용했다.
 * 
 * @author SungHo Yun
 * @version 0.4
 * 
 */

public class Music extends Thread {
	/** AdvancedPlayer 클래스는 Javazoom 에서 개발하여 지원하는 라이브러리에 있는 클래스중 하나이다 
	 *  기존에는 Player 클래스를 통해서 개발을 했지만 Player클래스로는 특정 구간에서부터의 노래 시작이 불가능하므로 
	 *  AdvancedPlayer를 통해 개발 했다.
	 *  BufferedInputStream을 매개변수로 받아 해당 버퍼에 있는 내용을 실행시킨다.
	 */
	private AdvancedPlayer player;
	
	/** playerEvent를 통해 노래가 정지 했을때 정보를 가져올수 있다. */
	private PlaybackEvent playerEvent;
	
	/** 한번만 재생이 되는지 무한정 재생이 되는지 결정하는 값 
	 *  isLoop의 값이 True이면 반복재생 False이면 한번만 시작된다.
	 * */
	private boolean isLoop;
	
	/** 노래가 정지되었을때의 Frame 값을 저장하기 위한 변수 */
	private int pausedOnFrame = 0;

	/** InputStream을 통해 파일로부터 값을 받아온다 */
	private InputStream is;
	/** InputStream으로 받아온 값을 버퍼에 담는다. */
	private BufferedInputStream bis;
	
	/** 노래의 제목을 저장하는 필드값이다. */
	private String name;

	/** 생성자를 통해 곡의 제목과 반복유무 시작위치를 받는다.
	 * 
	 * @param name
	 * @param isLoop
	 * @param startPoint
	 */
	public Music(String name, boolean isLoop, int startPoint) {

		try {
			// name 초기화
			this.name = name;
			// isLoop값 초기화
			this.isLoop = isLoop;
			// startPoint 초기화
			pausedOnFrame = startPoint;
			// fis를 사용하면 Jar파일을 이용하게 될때 에러가 발생하므로 InputStream을 사용한다.
			is = getClass().getClassLoader().getResourceAsStream("music/" + name);
			// InputStream를 bis버퍼에 담아서 읽을수 있게 한다
			bis = new BufferedInputStream(is);
			// player는 이 버퍼를 담을수 있게 해준다.
			player = new AdvancedPlayer(bis);
			
			player.setPlayBackListener(new PlaybackListener() {
			    @Override
			    public void playbackFinished(PlaybackEvent event) {
			    	// pausedOnFrame은 노래가 시작되고 부터의 Frame값을 가져오기 때문에 기존값에 추가해줘야 한다.
			        pausedOnFrame += event.getFrame();
			    }
			});

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/** 음악을 종료시키는 메소드이다. */
	public void close() {
		isLoop = false;
		player.close();
		// 쓰레드를 중지상태로 만든다.
		this.interrupt();
	}

	/** 곡을 재생시킨다. */
	@Override
	public void run() {
		try {
			// isLoop가 true이면 곡은 무한재생된다.
			do {
				/** pausedOnFrame을 이벤트를 통해서 가져올때는 1초 일때 1000 이지만
				 * player.play 매개변수로 넣을때는 1초가 100이므로 /10을 해줘야한다. 
				 */
				player.play(pausedOnFrame/10, Integer.MAX_VALUE);
				is = getClass().getClassLoader().getResourceAsStream("music/" + name);
				// fis를 버퍼에 담아서 읽을수 있게 한다
				bis = new BufferedInputStream(is);
				// player는 이 버퍼를 담을수 있게 해준다.
				player = new AdvancedPlayer(bis);
			} while (isLoop);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/** AdvancedPlyaer를 리턴해줘서 다른 클래스에서 stop메소드를 통해 노래를 멈출수 있게끔 한다. 
	 * 
	 * @return player
	 */
	public AdvancedPlayer getPlayer() {
		return player;
	}

	/** pausedOnFrame을 리턴하여 정지된 시점의 Frame을 얻을수 있게 한다.
	 * 
	 * @return pausedOnFrame
	 */
	public int getPausedOnFrame() {
		return pausedOnFrame;
	}


}
