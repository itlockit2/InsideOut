package project_03;

//playable 캐릭터를 제어하기 위한 메소드
public class Ball implements Runnable {
	// x좌표 , y좌표 , radius , 중심좌표 값  x , y
	private int x, y, r , Ox , Oy;
	// 증가시킬 크기
	private double size;
	// Thread 객체
	private Thread thread;


	Ball() {
		// 쓰레드를 만들고 객체에 넣어준다.
		setThread(new Thread(this));
		// 시작지점 x, y
		x = 630;
		y = 73;
		r = 280;     
		 // 값이 적을수록 왼쪽으로 감 ( x좌표 ) 905 - 265 - 15 (x좌표(3시) - 반지름 - 적절히 수정) 625 , 왼쪽 3시부터 그림을 그림
		Ox = 625;  
		// 값이 적을수록 올라감 ( y좌표 ) 630 - 265 - 10 (y좌표(6시) - 반지름 - 적절히 수정) 355 , 12시부터 그림을 그림
		Oy = 355;  
	}

	public void run() {
		// 곡이 끝날 때 까지 돌려줘야 하므로 계속 반복
		while (true) {
			try {
				// 원 중심값 + 반지름이므로 중심좌표 값을  더해야 한다. 
				// 3시를 기준으로 0도 이므로 , 실제로 값을 계산할 땐 90도를 빼주어서 12시를 기준으로 0을 맞춰줘야 한다.
				x = Ox + (int) (r * Math.cos(  (size - 90)/ 180 * Math.PI ) + 3 );
				y = Oy + (int) (r * Math.sin(  (size - 90)/ 180 * Math.PI )  );
				// 계속 변경시킬 x좌표, y좌표 
				size += 0.5;
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	// x의 값을 얻어오는 함수
	public int getX() {
		return x;
	}

	// x의 값을 설정하는 함수
	public void setX(int x) {
		this.x = x;
	}

	// y의 값을 얻어오는 함수
	public int getY() {
		return y;
	}

	// y의 값을 설정하는 함수
	public void setY(int y) {
		this.y = y;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

}
