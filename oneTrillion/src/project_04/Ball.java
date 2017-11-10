package project_04;

//playable 캐릭터를 제어하기 위한 메소드
public class Ball implements Runnable {
	// x좌표 , y좌표 , radius , 중심좌표 값  x , y
	private int x, y, r , Ox , Oy;
	// 증가시킬 크기
	private double size;
	// Thread 객체
	private Thread thread;
	// 거리 조정 변수
    private int adjustmentDistance = 13; 

	Ball() {
		// 쓰레드를 만들고 객체에 넣어준다.
		setThread(new Thread(this));
		// 시작지점 x, y 
		x = 640;
		y = 85;
		// 속이 빈 원의 반지름 265 + ball의 반지름 13 + 공이 살짝 떠있으므로 그에 대한 값으로 2를 주었다. 
		r = 280;     
		 // 원의 중심 x좌표 = 375 + 265 = 640 , 속이 빈 원의 반지름은 265
		Ox = 640;  
		 // 원의 중심 y좌표 = 100 + 265 = 640 , 속이 빈 원의 반지름은 265
		Oy = 365;  
	}

	public void run() {
		// 곡이 끝날 때 까지 돌려줘야 하므로 계속 반복
		while (true) {
			try {
				// 원 중심값 + 반지름이므로 중심좌표 값을  더해야 한다. 
				// 3시를 기준으로 0도 이므로 , 실제로 값을 계산할 땐 90도를 빼주어서 12시를 기준으로 0을 맞춰줘야 한다.
				x = Ox + (int) (r * Math.cos(  (size - 90)/ 180 * Math.PI )  );
				y = Oy + (int) (r * Math.sin(  (size - 90)/ 180 * Math.PI )  );
				// 계속 변경시킬 x좌표, y좌표 
				size += 1;
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	// x의 값을 얻어오는 함수
	public int getX() {
		// Ball을 그릴 때 11시 방향을 기준으로 그려주므로 반지름인 13을 빼주어서 X좌표를 얻어온다. 
		return x - adjustmentDistance ;
	}

	// x의 값을 설정하는 함수
	public void setX(int x) {
		this.x = x;
	}

	// y의 값을 얻어오는 함수
	public int getY() {
		// Ball을 그릴 때 11시 방향을 기준으로 그려주므로 반지름인 13을 빼주어서 Y좌표를 얻어온다. 
		return y - adjustmentDistance;
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
