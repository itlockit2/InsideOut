package project_04;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

/**
 * mp3파일을 실행시켜주는 클래스로 JavaZoom에서 지원하는 외부라이브러리를 사용했다.
 * 
 * @author Yun
 */

public class Music extends Thread {
	// Player 클래스는 Javazoom 에서 지원하는 클래스중 하나이다
	private AdvancedPlayer player;
	
	// playerEvent를 통해 노래가 정지 했을때 정보를 가져올수 있다.
	private PlaybackEvent playerEvent;
	
	// 한번만 재생이 되는지 무한정 재생이 되는지 결정하는 값
	private boolean isLoop;
	
	// 노래가 정지되었을때의 Frame 값을 저장하기 위한 변수
	private int pausedOnFrame = 0;

	// 파일 입출력 관련된 필드값들
	private BufferedInputStream bis;
	private InputStream is;
	private String name;

	// 생성자를 통해서 곡의 이름과 반복결정값과 startPoint를 받는다.
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

	// 음악을 언제든지 종료 할 수 있다.
	public void close() {
		isLoop = false;
		player.close();
		// 쓰레드를 중지상태로 만든다.
		this.interrupt();
	}

	// Thread를 상속하면 무조건 넣어야 하는 메소드이다.
	// 곡을 재생시킨다.
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


	public AdvancedPlayer getPlayer() {
		return player;
	}


	public int getPausedOnFrame() {
		return pausedOnFrame;
	}


}
