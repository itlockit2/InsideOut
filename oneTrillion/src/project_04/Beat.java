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
	//	obstacles.add(new Obstacle(ball, 576, 3850, 7600, "Down")); // 안
		obstacles.add(new Obstacle(ball, 598, 3850, 7600, "Down")); // 바깥
	//	obstacles.add(new Obstacle(ball, 621, 3850, 7600, "Down")); // 안
		
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
		
		obstacles.add(new Obstacle(ball, 1256, 11323, 15150, "Down")); // 바깥
		obstacles.add(new Obstacle(ball, 1262, 11323, 15150, "Down")); // 바깥
		obstacles.add(new Obstacle(ball, 1268, 11323, 15150, "Down")); // 바깥
	
		obstacles.add(new Obstacle(ball, 1290, 11323, 15150, "Up")); // 바깥
		obstacles.add(new Obstacle(ball, 1296, 11323, 15150, "Up")); // 안
		obstacles.add(new Obstacle(ball, 1302, 11323, 15150, "Up")); // 안

		obstacles.add(new Obstacle(ball, 1326, 11323, 15150, "Down")); // 바깥

		}
		
		// size 1.5
		else if (musicTitle.equals("BadNewsHighLight.mp3")) {
			
			obstacles.add(new Obstacle(ball, 10, 0, 1176, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 153, 100, 2470, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 175, 100, 2470, "Down")); // 안
			obstacles.add(new Obstacle(ball, 215, 100, 2470, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 235, 100, 2470, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 280, 1176, 3620, "Down")); // 안
			obstacles.add(new Obstacle(ball, 342, 1176, 3620, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 411, 1176, 3620, "Down")); // 안
			
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
			obstacles.add(new Obstacle(ball, 560, 2470, 5015, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 566, 2470, 5015, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 590, 2470, 5015, "Down")); // 바깥
			
			obstacles.add(new Obstacle(ball, 666, 3620, 6192, "Up")); // 안
			
			obstacles.add(new Obstacle(ball, 700, 3620, 6192, "Up")); // 바깥 
			obstacles.add(new Obstacle(ball, 706, 3620, 6192, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 712, 3620, 6192, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 718, 3620, 6192, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 724, 3620, 6192, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 730, 3620, 6192, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 736, 3620, 6192, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 742, 3620, 6192, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 748, 3620, 6192, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 754, 3620, 6192, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 760, 3620, 6192, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 780, 3620, 6192, "Down")); // 안
			obstacles.add(new Obstacle(ball, 786, 3620, 6192, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 925, 5015, 7280, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 960, 5015, 7280, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 1093, 6192, 8570, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1134, 6192, 8570, "Down")); // 안
			obstacles.add(new Obstacle(ball, 1161, 6192, 8570, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 1201, 7280, 9885, "Down")); // 안
			obstacles.add(new Obstacle(ball, 1242, 7280, 9885, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 1431, 8570, 10940, "Down")); // 안
			obstacles.add(new Obstacle(ball, 1468, 8570, 10940, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 1609, 9885, 12250, "Down")); // 안
			obstacles.add(new Obstacle(ball, 1654, 9885, 12250, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1701, 9885, 12250, "Down")); // 안

			obstacles.add(new Obstacle(ball, 1780, 10940, 13860, "Down")); // 안
			obstacles.add(new Obstacle(ball, 1872, 10940, 13860, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 1935, 12250, 14600, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 1975, 12250, 14600, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1981, 12250, 14600, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1987, 12250, 14600, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1993, 12250, 14600, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1999, 12250, 14600, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2005, 12250, 14600, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2011, 12250, 14600, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2017, 12250, 14600, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2023, 12250, 14600, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2029, 12250, 14600, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2035, 12250, 14600, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 2115, 13860, 15900, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2121, 13860, 15900, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2127, 13860, 15900, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2133, 13860, 15900, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2139, 13860, 15900, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2145, 13860, 15900, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2151, 13860, 15900, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2157, 13860, 15900, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2163, 13860, 15900, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2169, 13860, 15900, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2175, 13860, 15900, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2181, 13860, 15900, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2187, 13860, 15900, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2193, 13860, 15900, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2199, 13860, 15900, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 2335, 14600, 17450, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2370, 14600, 17450, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2395, 14600, 17450, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 2502, 15900, 18190, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2570, 15900, 18190, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 2655, 17450, 20000, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2703, 17450, 20000, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2748, 17450, 20000, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 2820, 18190, 21115, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2871, 18190, 21115, "Up")); // 바깥
			
	        obstacles.add(new Obstacle(ball, 3013, 20000, 22170, "Down")); // 안
			obstacles.add(new Obstacle(ball, 3082, 20000, 22170, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 3123, 20000, 22170, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 3190, 21115, 23310, "Up")); // 바깥
		    obstacles.add(new Obstacle(ball, 3196, 21115, 23310, "Up")); // 바깥
		    obstacles.add(new Obstacle(ball, 3202, 21115, 23310, "Up")); // 바깥
				
	     	obstacles.add(new Obstacle(ball, 3229, 21115, 23310, "Down")); // 안
			obstacles.add(new Obstacle(ball, 3235, 21115, 23310, "Down")); // 안
			obstacles.add(new Obstacle(ball, 3241, 21115, 23310, "Down")); // 안
			obstacles.add(new Obstacle(ball, 3247, 21115, 23310, "Down")); // 안
			obstacles.add(new Obstacle(ball, 3253, 21115, 23310, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 3283, 21115, 23310, "Up")); // 바깥
		
		    obstacles.add(new Obstacle(ball, 3300, 21115, 23310, "Down")); // 안
		    
		    obstacles.add(new Obstacle(ball, 3379, 22170, 24650, "Up")); // 바깥
		    obstacles.add(new Obstacle(ball, 3417, 22170, 24650, "Down")); // 안
		    obstacles.add(new Obstacle(ball, 3463, 22170, 24650, "Up")); // 바깥
		    
		    obstacles.add(new Obstacle(ball, 3555, 23310, 26015, "Down")); // 안
		    
		    obstacles.add(new Obstacle(ball, 3580, 23310, 26015, "Up")); // 바깥
		      
		    obstacles.add(new Obstacle(ball, 3616, 23310, 26015, "Down")); // 안
		    
		    obstacles.add(new Obstacle(ball, 3641, 23310, 26015, "Up")); // 바깥
	
		    obstacles.add(new Obstacle(ball, 3738, 24650, 27500, "Down")); // 안
		    obstacles.add(new Obstacle(ball, 3789, 24650, 27500, "Up")); // 바깥
		    obstacles.add(new Obstacle(ball, 3834, 24650, 27500, "Down")); // 안
		    obstacles.add(new Obstacle(ball, 3880, 24650, 27500, "Up")); // 바깥
	
		    obstacles.add(new Obstacle(ball, 3916, 26015, 28150, "Down")); // 안
		    obstacles.add(new Obstacle(ball, 3945, 26015, 28150, "Up")); // 바깥
		    obstacles.add(new Obstacle(ball, 3970, 26015, 28150, "Down")); // 안
		    
		    obstacles.add(new Obstacle(ball, 4104, 27500, 29360, "Up")); // 바깥
		    obstacles.add(new Obstacle(ball, 4156, 27500, 29360, "Down")); // 안
		    
		    obstacles.add(new Obstacle(ball, 4267, 28150, 30475, "Up")); // 바깥
		    obstacles.add(new Obstacle(ball, 4314, 28150, 30475, "Down")); // 안
		    obstacles.add(new Obstacle(ball, 4341, 28150, 30475, "Up")); // 바깥
		    obstacles.add(new Obstacle(ball, 4377, 28150, 30475, "Down")); // 안
			
		}
		
		// size 3.0으로 할 것 
		// 6시를 기준으로 12~6시의 장애물을 그리며 12시를 기준으로 6~12시의 장애물을 그린다.
		else if (musicTitle.equals("HeartBeatHighLight.mp3")) {
		
			obstacles.add(new Obstacle(ball, 40, 0, 650, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 175, 0, 1250, "Down")); // 안
			obstacles.add(new Obstacle(ball, 215, 0, 1250, "Up")); // 바깥

			obstacles.add(new Obstacle(ball, 300, 650, 1930, "Down")); // 안
			obstacles.add(new Obstacle(ball, 340, 650, 1930, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 385, 650, 1930, "Down")); // 안 
		    
			obstacles.add(new Obstacle(ball, 453, 1250, 2440, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 580, 1250, 2440, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 708, 1845, 3090, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 845, 2440, 3650, "Down")); // 안
			obstacles.add(new Obstacle(ball, 905, 2440, 3650, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 960, 2440, 3650, "Down")); // 안
		
			obstacles.add(new Obstacle(ball, 1100, 3090, 4380, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 1225, 3650, 5035, "Down")); // 안
			obstacles.add(new Obstacle(ball, 1255, 3650, 5035, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1345, 3650, 5035, "Down")); // 안

			obstacles.add(new Obstacle(ball, 1380, 4380, 5635, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1442, 4380, 5635, "Down")); // 안
			obstacles.add(new Obstacle(ball, 1495, 4380, 5635, "Up")); // 바깥

			obstacles.add(new Obstacle(ball, 1617, 5035, 6200, "Down")); // 안

			obstacles.add(new Obstacle(ball, 1735, 5635, 6950, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1860, 5635, 6950, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 1930, 6200, 7250, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 1990, 6200, 7250, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 2125, 6950, 7935, "Up")); // 바깥

			obstacles.add(new Obstacle(ball, 2255, 7250, 8815, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2287, 7250, 8815, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 2387, 7250, 8815, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2425, 7250, 8815, "Up")); // 바깥
	
			obstacles.add(new Obstacle(ball, 2475, 7935, 9140, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2530, 7935, 9140, "Up")); // 바깥

			obstacles.add(new Obstacle(ball, 2630, 8815, 9990, "Down")); // 안
			obstacles.add(new Obstacle(ball, 2775, 8815, 9990, "Up")); // 바깥
			 
			obstacles.add(new Obstacle(ball, 2920, 9140, 10610, "Down")); // 안
		
			obstacles.add(new Obstacle(ball, 2975, 9990, 11337, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 3048, 9990, 11337, "Down")); // 안

			obstacles.add(new Obstacle(ball, 3180, 10610, 11780, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 3300, 10610, 11780, "Up")); // 바깥
		
			obstacles.add(new Obstacle(ball, 3330, 11337, 12365, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 3425, 11337, 12365, "Down")); // 안
			obstacles.add(new Obstacle(ball, 3463, 11337, 12365, "Up")); // 바깥
		   
			obstacles.add(new Obstacle(ball, 3511, 11780, 13110, "Down")); // 안
			obstacles.add(new Obstacle(ball, 3565, 11780, 13110, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 3681, 11780, 13110, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 3810, 12365, 13688, "Up")); // 바깥
	         // 6시 지나면 3개 
			obstacles.add(new Obstacle(ball, 3933, 13110, 14060, "Down")); // 안
			obstacles.add(new Obstacle(ball, 4010, 13110, 14060, "Up")); // 바깥
		   
			obstacles.add(new Obstacle(ball, 4180, 13688, 14800, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 4280, 14060, 15420, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 4335, 14060, 15420, "Down")); // 안
			obstacles.add(new Obstacle(ball, 4380, 14060, 15420, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 4490, 14800, 16330, "Down")); // 안
			obstacles.add(new Obstacle(ball, 4520, 14800, 16330, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 4640, 15420, 17110, "Down")); // 안
			obstacles.add(new Obstacle(ball, 4700, 15420, 17110, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 4850, 16330, 17760, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 5030, 17110, 18500, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 5140, 17760, 18800, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 5195, 17760, 18800, "Down")); // 안
			
			obstacles.add(new Obstacle(ball, 5345, 18500, 20000, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 5375, 18500, 20000, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 5405, 18500, 20000, "Down")); // 안
			obstacles.add(new Obstacle(ball, 5435, 18500, 20000, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 5525, 18800, 21130, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 5575, 18800, 21130, "Down")); // 안
			obstacles.add(new Obstacle(ball, 5625, 18800, 21130, "Up")); // 바깥
			
			obstacles.add(new Obstacle(ball, 6125, 20000, 21520, "Up")); // 바깥
			obstacles.add(new Obstacle(ball, 6175, 20000, 21520, "Down")); // 안
		}
			
	}
	
	

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public void setObstacles(ArrayList<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}

}
