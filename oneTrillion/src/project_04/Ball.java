package project_04;

/**
 * 플레이어가 실제로 플레이하게 되는 Ball을 제어(위치,회전 등)하기 위한 클래스
 * 
 * @author Jimin Kim
 * @version 0.4
 * 
 */
public class Ball implements Runnable {

	// x좌표 , y좌표 , radius , 중심좌표 값 x , y
	private int x, y, radius, circleX, circleY;
	// 증가시킬 크기
	private double size;
	// Radian 값
	private double radian;
	// Thread 객체

	private Thread thread;
	/** Ball을 그리게 되면 leftX, topY부터 그리기 때문에 그에 대한 거리를 조절하기 위한 변수 */
	private int adjustmentDistance;

	/** Ball의 중심좌표 값을 설정하기 위한 생성자 */
	Ball() {
		// 쓰레드를 만들고 객체에 넣어준다.
		setThread(new Thread(this));
		// Ball의 중심좌표 즉, 처음 시작좌표 x, y
		x = 640;
		y = 85;
		// 속이 빈 원의 반지름 265 + ball의 반지름 13 + 공이 살짝 떠있으므로 그에 대한 값으로 2를 주었다.

		// Ball의 중심좌표에서 Ball의 반지름 만큼인 13을 x좌표, y좌표에 각각 넣어주면 그리고자 하는 Ball을 그릴 수 있게된다.
		adjustmentDistance = 13;

		radius = 280;
		// 원의 중심 x좌표 = 375 + 265 = 640 , 속이 빈 원의 반지름은 265
		circleX = 640;
		// 원의 중심 y좌표 = 100 + 265 = 640 , 속이 빈 원의 반지름은 265
		circleY = 365;
		// size의 값을 초기화 3시를 기준으로 0도 이므로 , 실제로 값을 계산할 땐 90도를 빼주어서 12시를 기준으로 0을 맞춰줘야 한다.
		size = -90;
		// radian 값 초기화

	}

	/**
	 * Thread를 실행시키면 run함수가 실행 따라서, run함수 안의 while문을 통해 Ball이 회전하고자 하는 원을 계속 회전하게
	 * 된다.
	 */
	public void run() {
		// 곡이 끝날 때 까지 돌려줘야 하므로 계속 반복
		while (true) {
			try {
				// 삼각함수의 라디안 값을 통해 size를 증가시키면서 Ball을 곡이 끝날 때 까지 회전시킨다.
				// 원 중심값 + 반지름이므로 중심좌표 값을 더해야 한다.
				x = circleX + (int) (radius * Math.cos(radian));
				y = circleY + (int) (radius * Math.sin(radian));
				// 계속 변경시킬 x좌표, y좌표

				size += 1;
				// radian 값 계산
				radian = size / 180 * Math.PI;
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Ball의 x좌표를 얻어오는 getX 함수
	 * 
	 * @return x - adjustmentDistance
	 */
	public int getX() {
		// Ball을 그릴 때 11시 방향(leftX)을 기준으로 그려주므로 반지름인 13을 빼주어서 X좌표를 얻어온다.
		return x - adjustmentDistance;
	}

	/**
	 * Ball의 x좌표를 설정하는 setX 함수
	 * 
	 * @param int
	 *            x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Ball의 y좌표를 얻어오는 getY 함수
	 * 
	 * @return y - adjustmentDistance
	 */

	// y의 값을 얻어오는 함수

	public int getY() {
		// Ball을 그릴 때 11시 방향을 기준(topY)으로 그려주므로 반지름인 13을 빼주어서 Y좌표를 얻어온다.
		return y - adjustmentDistance;
	}

	/**
	 * Ball의 y좌표를 설정하는 setY 함수
	 * 
	 * @param int
	 *            y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Ball의 Thread를 얻어오는 함수
	 * 
	 * @return thread
	 */

	public Thread getThread() {
		return thread;
	}

	/**
	 * Ball의 Thread를 설정하는 함수
	 * 
	 * @param Thread
	 *            thread
	 */
	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public int getRadius() {
		return radius;
	}

	public int getCircleX() {
		return circleX;
	}

	public int getCircleY() {
		return circleY;
	}

	public double getRadian() {
		return radian;
	}

	public double getSize() {
		return size;
	}

}