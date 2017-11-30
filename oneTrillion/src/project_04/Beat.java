package project_04;

import java.util.ArrayList;

public class Beat {
	private Ball ball;

	/** 장애물 구현을 위한 객체 */
	private ArrayList<Obstacle> obstacles;

	Beat(Ball ball, String musicTitle) {
		this.ball = ball;
		obstacles = new ArrayList<Obstacle>();
		// size 1
		if (musicTitle.equals("Tobu & Itro - Sunburst_Highlight.mp3")) {
		
		obstacles.add(new Obstacle(ball, -20, 0, 1850,"Up" )); // 바깥
		obstacles.add(new Obstacle(ball, 15, 0, 1850, "Down")); // 안
		obstacles.add(new Obstacle(ball, 55, 0, 1850, "Up")); // 바깥
		
		obstacles.add(new Obstacle(ball, 95, 145, 3850, "Up")); // 바깥
		obstacles.add(new Obstacle(ball, 140, 145, 3850, "Down")); // 안
		obstacles.add(new Obstacle(ball, 186, 145, 3850, "Up")); // 바깥
		obstacles.add(new Obstacle(ball, 232, 145, 3850, "Down")); // 안
	
		obstacles.add(new Obstacle(ball, 280, 1850, 5735, "Up")); // 바깥
		obstacles.add(new Obstacle(ball, 324, 1850, 5735, "Down")); // 안
		obstacles.add(new Obstacle(ball, 365, 1850, 5735, "Up")); // 바깥
		obstacles.add(new Obstacle(ball, 400, 1850, 5735, "Down")); // 안
		
		obstacles.add(new Obstacle(ball, 508, 3850, 7600, "Down")); // 안
		obstacles.add(new Obstacle(ball, 552, 3850, 7600, "Up")); // 바깥
		obstacles.add(new Obstacle(ball, 598, 3850, 7600, "Down")); // 안
		
		obstacles.add(new Obstacle(ball, 657, 5735, 9600, "Down")); // 안
		obstacles.add(new Obstacle(ball, 694, 5735, 9600, "Up")); // 바깥
		obstacles.add(new Obstacle(ball, 739, 5735, 9600, "Down")); // 안
		obstacles.add(new Obstacle(ball, 785, 5735, 9600, "Up")); // 바깥
	
		obstacles.add(new Obstacle(ball, 851, 7600, 11323, "Down")); // 안
		obstacles.add(new Obstacle(ball, 889, 7600, 11323, "Up")); // 바깥 
		obstacles.add(new Obstacle(ball, 932, 7600, 11323, "Down")); // 안
		obstacles.add(new Obstacle(ball, 970, 7600, 11323, "Up")); // 바깥
		
		obstacles.add(new Obstacle(ball, 1021, 9600, 13300, "Up")); // 바깥
		obstacles.add(new Obstacle(ball, 1066, 9600, 13300, "Down")); // 안
		obstacles.add(new Obstacle(ball, 1111, 9600, 13300, "Up")); // 바깥
		obstacles.add(new Obstacle(ball, 1155, 9600, 13300, "Down")); // 안
		
		obstacles.add(new Obstacle(ball, 1232, 11323, 15150, "Up")); // 바깥 
		
		obstacles.add(new Obstacle(ball, 1256, 11323, 15150, "Down")); // 안
		obstacles.add(new Obstacle(ball, 1262, 11323, 15150, "Down")); // 안
		obstacles.add(new Obstacle(ball, 1268, 11323, 15150, "Down")); // 안
	
		obstacles.add(new Obstacle(ball, 1290, 11323, 15150, "Up")); // 바깥
		obstacles.add(new Obstacle(ball, 1296, 11323, 15150, "Up")); // 바깥
		obstacles.add(new Obstacle(ball, 1302, 11323, 15150, "Up")); // 바깥

		obstacles.add(new Obstacle(ball, 1326, 11323, 15150, "Down")); // 안

		}
		
		// size 1.5
		else if (musicTitle.equals("BadNewsHighLight.mp3")) {
			
			obstacles.add(new Obstacle(ball, 10, 0, 1176, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 153, 100, 2470, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 180, 100, 2470, "Down")); // 안
			obstacles.add(new Obstacle(ball, 220, 100, 2470, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 245, 100, 2470, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 280, 1176, 3700, "Down")); // 안
			obstacles.add(new Obstacle(ball, 342, 1176, 3700, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 411, 1176, 3700, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 500, 2470, 5015, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 506, 2470, 5015, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 512, 2470, 5015, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 518, 2470, 5015, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 524, 2470, 5015, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 530, 2470, 5015, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 536, 2470, 5015, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 542, 2470, 5015, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 548, 2470, 5015, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 554, 2470, 5015, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 590, 2470, 5015, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 666, 3700, 6192, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 700, 3700, 6192, "Down")); // 안
			obstacles.add(new Obstacle(ball, 706, 3700, 6192, "Down")); // 안
			obstacles.add(new Obstacle(ball, 712, 3700, 6192, "Down")); // 안
			obstacles.add(new Obstacle(ball, 718, 3700, 6192, "Down")); // 안
			obstacles.add(new Obstacle(ball, 724, 3700, 6192, "Down")); // 안
			obstacles.add(new Obstacle(ball, 730, 3700, 6192, "Down")); // 안
			obstacles.add(new Obstacle(ball, 736, 3700, 6192, "Down")); // 안
			obstacles.add(new Obstacle(ball, 742, 3700, 6192, "Down")); // 안
			obstacles.add(new Obstacle(ball, 748, 3700, 6192, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 780, 3700, 6192, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 786, 3700, 6192, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 925, 5015, 7280, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 960, 5015, 7280, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 1093, 6192, 8570, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1134, 6192, 8570, "Down")); // 안
			obstacles.add(new Obstacle(ball, 1161, 6192, 8570, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 1242, 7280, 10200, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 1431, 8570, 11000, "Down")); // 안
			obstacles.add(new Obstacle(ball, 1468, 8570, 11000, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 1609, 10200, 12333, "Down")); // 안
			obstacles.add(new Obstacle(ball, 1654, 10200, 12333, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1701, 10200, 12333, "Down")); // 안

			obstacles.add(new Obstacle(ball, 1780, 11000, 13860, "Down")); // 안
			obstacles.add(new Obstacle(ball, 1872, 11000, 13860, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 1935, 12333, 15000, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 1975, 12333, 15000, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1981, 12333, 15000, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1987, 12333, 15000, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1993, 12333, 15000, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1999, 12333, 15000, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2005, 12333, 15000, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2011, 12333, 15000, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2017, 12333, 15000, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2023, 12333, 15000, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2029, 12333, 15000, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 2115, 13860, 15900, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2121, 13860, 15900, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2127, 13860, 15900, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2133, 13860, 15900, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2139, 13860, 15900, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2145, 13860, 15900, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2151, 13860, 15900, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2157, 13860, 15900, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2163, 13860, 15900, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2169, 13860, 15900, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2175, 13860, 15900, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2181, 13860, 15900, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2187, 13860, 15900, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2193, 13860, 15900, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2199, 13860, 15900, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 2335, 15000, 17450, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2370, 15000, 17450, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2395, 15000, 17450, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 2502, 15900, 18190, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2570, 15900, 18190, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 2655, 17450, 20200, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2703, 17450, 20200, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2748, 17450, 20200, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 2820, 18190, 21115, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2871, 18190, 21115, "Up")); // 바깥
			
	        obstacles.add(new Obstacle(ball, 3013, 20200, 22170, "Down")); // 안
			obstacles.add(new Obstacle(ball, 3082, 20200, 22170, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 3123, 20200, 22170, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 3190, 21115, 23310, "Up")); // 바깥
		    obstacles.add(new Obstacle(ball, 3196, 21115, 23310, "Up")); // 바깥
		    obstacles.add(new Obstacle(ball, 3202, 21115, 23310, "Up")); // 바깥
				
	     	obstacles.add(new Obstacle(ball, 3229, 21115, 23310, "Down")); // 안
			obstacles.add(new Obstacle(ball, 3235, 21115, 23310, "Down")); // 안
			obstacles.add(new Obstacle(ball, 3241, 21115, 23310, "Down")); // 안
			obstacles.add(new Obstacle(ball, 3247, 21115, 23310, "Down")); // 안
			obstacles.add(new Obstacle(ball, 3253, 21115, 23310, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 3293, 21115, 23310, "Up")); // 바깥
		    
		    obstacles.add(new Obstacle(ball, 3379, 22170, 24750, "Up")); // 바깥
		    obstacles.add(new Obstacle(ball, 3427, 22170, 24750, "Down")); // 안
		    obstacles.add(new Obstacle(ball, 3473, 22170, 24750, "Up")); // 바깥
		    
		    obstacles.add(new Obstacle(ball, 3555, 23310, 26015, "Down")); // 안
		    obstacles.add(new Obstacle(ball, 3595, 23310, 26015, "Up")); // 바깥
		    obstacles.add(new Obstacle(ball, 3635, 23310, 26015, "Down")); // 안
		    obstacles.add(new Obstacle(ball, 3685, 23310, 26015, "Up")); // 바깥
	
		    obstacles.add(new Obstacle(ball, 3738, 24750, 27500, "Down")); // 안
		    obstacles.add(new Obstacle(ball, 3805, 24750, 27500, "Up")); // 바깥
		    obstacles.add(new Obstacle(ball, 3860, 24750, 27500, "Down")); // 안
	
		    obstacles.add(new Obstacle(ball, 3945, 26015, 28150, "Up")); // 바깥
		    
		    obstacles.add(new Obstacle(ball, 4104, 27500, 29360, "Up")); // 바깥
		    obstacles.add(new Obstacle(ball, 4156, 27500, 29360, "Down")); // 안
		   
			
		}
		
		// size 2.0
		// 6시를 기준으로 12~6시의 장애물을 그리며 12시를 기준으로 6~12시의 장애물을 그린다.
		else if (musicTitle.equals("HeartBeatHighLight.mp3")) {
		
			obstacles.add(new Obstacle(ball, 40, 0, 930, "Up")); // 바깥 
			obstacles.add(new Obstacle(ball, 150, 0, 1850, "Down")); // 안
			obstacles.add(new Obstacle(ball, 200, 0, 1850, "Up")); // 바깥
			

			obstacles.add(new Obstacle(ball, 386, 930, 2800, "Up")); // 바깥
		
			
			obstacles.add(new Obstacle(ball, 505, 1850, 3800, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 540, 1850, 3800, "Down")); // 안
			obstacles.add(new Obstacle(ball, 580, 1850, 3800, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 665, 2800, 4700, "Down")); // 안
			obstacles.add(new Obstacle(ball, 710, 2800, 4700, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 760, 2800, 4700, "Down")); // 안 
			
			obstacles.add(new Obstacle(ball, 870, 3800, 5600, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 1050, 4700, 6600, "Down")); // 안
			obstacles.add(new Obstacle(ball, 1105, 4700, 6600, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1161, 4700, 6600, "Down")); // 안 
			
			obstacles.add(new Obstacle(ball, 1301, 5600, 7700, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 1430, 6600, 8700, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1465, 6600, 8700, "Down")); // 안
			obstacles.add(new Obstacle(ball, 1520, 6600, 8700, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 1598, 7700, 9400, "Down")); // 안
			obstacles.add(new Obstacle(ball, 1636, 7700, 9400, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1685, 7700, 9400, "Down")); // 안 
			
			obstacles.add(new Obstacle(ball, 1814, 8700, 10500, "Down")); // 안
			obstacles.add(new Obstacle(ball, 1865, 8700, 10500, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 1930, 9400, 11400, "Down")); // 안
			obstacles.add(new Obstacle(ball, 1980, 9400, 11400, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2055, 9400, 11400, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 2138, 10500, 12700, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2170, 10500, 12700, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 2308, 11400, 13150, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2420, 11400, 13150, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 2475, 12700, 14050, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2520, 12700, 14050, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2590, 12700, 14050, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 2700, 13150, 15050, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 2840, 14050, 16000, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2895, 14050, 16000, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2950, 14050, 16000, "Down")); // 안 
			
			obstacles.add(new Obstacle(ball, 3015, 15050, 17050, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 3080, 15050, 17050, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 3180, 16000, 17850, "Down")); // 안
			obstacles.add(new Obstacle(ball, 3285, 16000, 17850, "Up")); // 안
			obstacles.add(new Obstacle(ball, 3320, 16000, 17850, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 3380, 17050, 18600, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 3418, 17050, 18600, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 3612, 17850, 19700, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 3662, 17850, 19700, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 3748, 18600, 20550, "Down")); // 바깥
			obstacles.add(new Obstacle(ball, 3790, 18600, 20550, "Up")); // 안
			
			obstacles.add(new Obstacle(ball, 3882, 19700, 21850, "Down")); // 안
			obstacles.add(new Obstacle(ball, 3922, 19700, 21850, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 4010, 19700, 21850, "Down")); // 안
		
			obstacles.add(new Obstacle(ball, 4070, 20550, 22350, "Up")); // 안
			obstacles.add(new Obstacle(ball, 4130, 20550, 22350, "Down")); // 바깥
			obstacles.add(new Obstacle(ball, 4136, 20550, 22350, "Down")); // 바깥
			obstacles.add(new Obstacle(ball, 4142, 20550, 22350, "Down")); // 바깥
			obstacles.add(new Obstacle(ball, 4148, 20550, 22350, "Down")); // 바깥
			obstacles.add(new Obstacle(ball, 4154, 20550, 22350, "Down")); // 바깥
			obstacles.add(new Obstacle(ball, 4160, 20550, 22350, "Down")); // 바깥
			obstacles.add(new Obstacle(ball, 4166, 20550, 22350, "Down")); // 바깥
			obstacles.add(new Obstacle(ball, 4172, 20550, 22350, "Down")); // 바깥
			obstacles.add(new Obstacle(ball, 4178, 20550, 22350, "Down")); // 바깥
			obstacles.add(new Obstacle(ball, 4184, 20550, 22350, "Down")); // 바깥
			obstacles.add(new Obstacle(ball, 4190, 20550, 22350, "Down")); // 바깥
			obstacles.add(new Obstacle(ball, 4196, 20550, 22350, "Down")); // 바깥
			obstacles.add(new Obstacle(ball, 4202, 20550, 22350, "Down")); // 바깥
			
		}
			
	}
	
	

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public void setObstacles(ArrayList<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}

}
