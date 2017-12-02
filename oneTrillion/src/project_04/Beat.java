package project_04;

import java.util.ArrayList;

public class Beat {
	private Circle circle;
	
	private Music music;

	/** 장애물 구현을 위한 객체 */
	private ArrayList<Obstacle> obstacles;

	Beat(Circle circle, String musicTitle , Music music) {
		this.music = music;
		this.circle = circle;
		obstacles = new ArrayList<Obstacle>();
		// size 1
		if (musicTitle.equals("Tobu & Itro - Sunburst_Highlight.mp3")) {
		
		obstacles.add(new Obstacle(circle, -20, 0, 1850,"Up", music )); // 바깥
		obstacles.add(new Obstacle(circle, 15, 0, 1850, "Down", music)); // 안
		obstacles.add(new Obstacle(circle, 55, 0, 1850, "Up", music)); // 바깥
		
		obstacles.add(new Obstacle(circle, 95, 145, 3850, "Up", music)); // 바깥
		obstacles.add(new Obstacle(circle, 140, 145, 3850, "Down", music)); // 안
		obstacles.add(new Obstacle(circle, 186, 145, 3850, "Up", music)); // 바깥
		obstacles.add(new Obstacle(circle, 232, 145, 3850, "Down", music)); // 안
	
		obstacles.add(new Obstacle(circle, 280, 1850, 5735, "Up", music)); // 바깥
		obstacles.add(new Obstacle(circle, 324, 1850, 5735, "Down", music)); // 안
		obstacles.add(new Obstacle(circle, 365, 1850, 5735, "Up", music)); // 바깥
		obstacles.add(new Obstacle(circle, 400, 1850, 5735, "Down", music)); // 안
		
		obstacles.add(new Obstacle(circle, 508, 3850, 7600, "Down", music)); // 안
		obstacles.add(new Obstacle(circle, 552, 3850, 7600, "Up", music)); // 바깥
		obstacles.add(new Obstacle(circle, 598, 3850, 7600, "Down", music)); // 안
		
		obstacles.add(new Obstacle(circle, 657, 5735, 9600, "Down", music)); // 안
		obstacles.add(new Obstacle(circle, 694, 5735, 9600, "Up", music)); // 바깥
		obstacles.add(new Obstacle(circle, 739, 5735, 9600, "Down", music)); // 안
		obstacles.add(new Obstacle(circle, 785, 5735, 9600, "Up", music)); // 바깥
	
		obstacles.add(new Obstacle(circle, 851, 7600, 11323, "Down", music)); // 안
		obstacles.add(new Obstacle(circle, 889, 7600, 11323, "Up", music)); // 바깥 
		obstacles.add(new Obstacle(circle, 932, 7600, 11323, "Down", music)); // 안
		obstacles.add(new Obstacle(circle, 970, 7600, 11323, "Up", music)); // 바깥
		
		obstacles.add(new Obstacle(circle, 1021, 9600, 13300, "Up", music)); // 바깥
		obstacles.add(new Obstacle(circle, 1066, 9600, 13300, "Down", music)); // 안
		obstacles.add(new Obstacle(circle, 1111, 9600, 13300, "Up", music)); // 바깥
		obstacles.add(new Obstacle(circle, 1155, 9600, 13300, "Down", music)); // 안
		
		obstacles.add(new Obstacle(circle, 1232, 11323, 15150, "Up", music)); // 바깥 
		
		obstacles.add(new Obstacle(circle, 1256, 11323, 15150, "Down", music)); // 안
		obstacles.add(new Obstacle(circle, 1262, 11323, 15150, "Down", music)); // 안
		obstacles.add(new Obstacle(circle, 1268, 11323, 15150, "Down", music)); // 안
	
		obstacles.add(new Obstacle(circle, 1290, 11323, 15150, "Up", music)); // 바깥
		obstacles.add(new Obstacle(circle, 1296, 11323, 15150, "Up", music)); // 바깥
		obstacles.add(new Obstacle(circle, 1302, 11323, 15150, "Up", music)); // 바깥

		obstacles.add(new Obstacle(circle, 1326, 11323, 15150, "Down", music)); // 안

		}
		
		// size 1.5
		else if (musicTitle.equals("BadNewsHighLight.mp3")) {
			
			obstacles.add(new Obstacle(circle, 10, 0, 1176, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 153, 100, 2470, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 180, 100, 2470, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 220, 100, 2470, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 245, 100, 2470, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 280, 1176, 3700, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 342, 1176, 3700, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 411, 1176, 3700, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 500, 2470, 5015, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 506, 2470, 5015, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 512, 2470, 5015, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 518, 2470, 5015, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 524, 2470, 5015, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 530, 2470, 5015, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 536, 2470, 5015, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 542, 2470, 5015, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 548, 2470, 5015, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 554, 2470, 5015, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 590, 2470, 5015, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 666, 3700, 6192, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 700, 3700, 6192, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 706, 3700, 6192, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 712, 3700, 6192, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 718, 3700, 6192, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 724, 3700, 6192, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 730, 3700, 6192, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 736, 3700, 6192, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 742, 3700, 6192, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 748, 3700, 6192, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 780, 3700, 6192, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 786, 3700, 6192, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 925, 5015, 7280, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 960, 5015, 7280, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 1093, 6192, 8570, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 1134, 6192, 8570, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 1161, 6192, 8570, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 1242, 7280, 10200, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 1431, 8570, 11000, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 1468, 8570, 11000, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 1609, 10200, 12333, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 1654, 10200, 12333, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 1701, 10200, 12333, "Down", music)); // 안

			obstacles.add(new Obstacle(circle, 1780, 11000, 13860, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 1872, 11000, 13860, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 1935, 12333, 15000, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 1975, 12333, 15000, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 1981, 12333, 15000, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 1987, 12333, 15000, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 1993, 12333, 15000, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 1999, 12333, 15000, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 2005, 12333, 15000, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 2011, 12333, 15000, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 2017, 12333, 15000, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 2023, 12333, 15000, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 2029, 12333, 15000, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 2115, 13860, 15900, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2121, 13860, 15900, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2127, 13860, 15900, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2133, 13860, 15900, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2139, 13860, 15900, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2145, 13860, 15900, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2151, 13860, 15900, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2157, 13860, 15900, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2163, 13860, 15900, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2169, 13860, 15900, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2175, 13860, 15900, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2181, 13860, 15900, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2187, 13860, 15900, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2193, 13860, 15900, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2199, 13860, 15900, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 2335, 15000, 17450, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2370, 15000, 17450, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 2395, 15000, 17450, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 2502, 15900, 18190, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 2570, 15900, 18190, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 2655, 17450, 20200, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 2703, 17450, 20200, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2748, 17450, 20200, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 2820, 18190, 21115, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2871, 18190, 21115, "Up", music)); // 바깥
			
	        obstacles.add(new Obstacle(circle, 3013, 20200, 22170, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 3082, 20200, 22170, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 3123, 20200, 22170, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 3190, 21115, 23310, "Up", music)); // 바깥
		    obstacles.add(new Obstacle(circle, 3196, 21115, 23310, "Up", music)); // 바깥
		    obstacles.add(new Obstacle(circle, 3202, 21115, 23310, "Up", music)); // 바깥
				
	     	obstacles.add(new Obstacle(circle, 3229, 21115, 23310, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 3235, 21115, 23310, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 3241, 21115, 23310, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 3247, 21115, 23310, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 3253, 21115, 23310, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 3293, 21115, 23310, "Up", music)); // 바깥
		    
		    obstacles.add(new Obstacle(circle, 3379, 22170, 24750, "Up", music)); // 바깥
		    obstacles.add(new Obstacle(circle, 3427, 22170, 24750, "Down", music)); // 안
		    obstacles.add(new Obstacle(circle, 3473, 22170, 24750, "Up", music)); // 바깥
		    
		    obstacles.add(new Obstacle(circle, 3555, 23310, 26015, "Down", music)); // 안
		    obstacles.add(new Obstacle(circle, 3595, 23310, 26015, "Up", music)); // 바깥
		    obstacles.add(new Obstacle(circle, 3635, 23310, 26015, "Down", music)); // 안
		    obstacles.add(new Obstacle(circle, 3685, 23310, 26015, "Up", music)); // 바깥
	
		    obstacles.add(new Obstacle(circle, 3738, 24750, 27500, "Down", music)); // 안
		    obstacles.add(new Obstacle(circle, 3805, 24750, 27500, "Up", music)); // 바깥
		    obstacles.add(new Obstacle(circle, 3860, 24750, 27500, "Down", music)); // 안
	
		    obstacles.add(new Obstacle(circle, 3945, 26015, 28150, "Up", music)); // 바깥
		    
		    obstacles.add(new Obstacle(circle, 4104, 27500, 29360, "Up", music)); // 바깥
		    obstacles.add(new Obstacle(circle, 4156, 27500, 29360, "Down", music)); // 안
		   
			
		}
		
		// size 2.0
		// 6시를 기준으로 12~6시의 장애물을 그리며 12시를 기준으로 6~12시의 장애물을 그린다.
		else if (musicTitle.equals("HeartBeatHighLight.mp3")) {
		
			obstacles.add(new Obstacle(circle, 40, 0, 930, "Up", music)); // 바깥 
			obstacles.add(new Obstacle(circle, 150, 0, 1850, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 200, 0, 1850, "Up", music)); // 바깥
			

			obstacles.add(new Obstacle(circle, 386, 930, 2800, "Up", music)); // 바깥
		
			
			obstacles.add(new Obstacle(circle, 505, 1850, 3800, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 540, 1850, 3800, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 580, 1850, 3800, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 665, 2800, 4700, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 710, 2800, 4700, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 760, 2800, 4700, "Down", music)); // 안 
			
			obstacles.add(new Obstacle(circle, 870, 3800, 5600, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 1050, 4700, 6600, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 1105, 4700, 6600, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 1161, 4700, 6600, "Down", music)); // 안 
			
			obstacles.add(new Obstacle(circle, 1301, 5600, 7700, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 1430, 6600, 8700, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 1465, 6600, 8700, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 1520, 6600, 8700, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 1598, 7700, 9400, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 1636, 7700, 9400, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 1685, 7700, 9400, "Down", music)); // 안 
			
			obstacles.add(new Obstacle(circle, 1814, 8700, 10500, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 1865, 8700, 10500, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 1930, 9400, 11400, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 1980, 9400, 11400, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 2055, 9400, 11400, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 2138, 10500, 12700, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 2170, 10500, 12700, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 2308, 11400, 13150, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 2420, 11400, 13150, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 2475, 12700, 14050, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 2520, 12700, 14050, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2590, 12700, 14050, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 2700, 13150, 15050, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 2840, 14050, 16000, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 2895, 14050, 16000, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 2950, 14050, 16000, "Down", music)); // 안 
			
			obstacles.add(new Obstacle(circle, 3015, 15050, 17050, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 3080, 15050, 17050, "Up", music)); // 바깥
			
			obstacles.add(new Obstacle(circle, 3180, 16000, 17850, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 3285, 16000, 17850, "Up", music)); // 안
			obstacles.add(new Obstacle(circle, 3320, 16000, 17850, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 3380, 17050, 18600, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 3418, 17050, 18600, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 3612, 17850, 19700, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 3662, 17850, 19700, "Down", music)); // 안
			
			obstacles.add(new Obstacle(circle, 3748, 18600, 20550, "Down", music)); // 바깥
			obstacles.add(new Obstacle(circle, 3790, 18600, 20550, "Up", music)); // 안
			
			obstacles.add(new Obstacle(circle, 3882, 19700, 21850, "Down", music)); // 안
			obstacles.add(new Obstacle(circle, 3922, 19700, 21850, "Up", music)); // 바깥
			obstacles.add(new Obstacle(circle, 4010, 19700, 21850, "Down", music)); // 안
		
			obstacles.add(new Obstacle(circle, 4070, 20550, 22350, "Up", music)); // 안
			obstacles.add(new Obstacle(circle, 4130, 20550, 22350, "Down", music)); // 바깥
			obstacles.add(new Obstacle(circle, 4136, 20550, 22350, "Down", music)); // 바깥
			obstacles.add(new Obstacle(circle, 4142, 20550, 22350, "Down", music)); // 바깥
			obstacles.add(new Obstacle(circle, 4148, 20550, 22350, "Down", music)); // 바깥
			obstacles.add(new Obstacle(circle, 4154, 20550, 22350, "Down", music)); // 바깥
			obstacles.add(new Obstacle(circle, 4160, 20550, 22350, "Down", music)); // 바깥
			obstacles.add(new Obstacle(circle, 4166, 20550, 22350, "Down", music)); // 바깥
			obstacles.add(new Obstacle(circle, 4172, 20550, 22350, "Down", music)); // 바깥
			obstacles.add(new Obstacle(circle, 4178, 20550, 22350, "Down", music)); // 바깥
			obstacles.add(new Obstacle(circle, 4184, 20550, 22350, "Down", music)); // 바깥
			obstacles.add(new Obstacle(circle, 4190, 20550, 22350, "Down", music)); // 바깥
			obstacles.add(new Obstacle(circle, 4196, 20550, 22350, "Down", music)); // 바깥
			obstacles.add(new Obstacle(circle, 4202, 20550, 22350, "Down", music)); // 바깥
			
		}
			
	}

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public void setObstacles(ArrayList<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}
}
