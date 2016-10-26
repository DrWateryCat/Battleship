public class Battleship {
	public static void createShip(int[][] ocean) {
		boolean orientation = Utils.random();
		int shipx = Utils.random(7, 0);
		int shipy = Utils.random(7, 0);
		
		ocean[shipy][shipx] = 1;
		
		if(orientation) {
			//Horizontal
			for(int y = 0; y < ocean.length; y++) {
				if (y == shipy) {
					if(shipx > 3) {
						for(int x = (shipx - 2); x < (shipx + 2); x++) {
							ocean[y][x] = 1;
						}
					} else {
						for(int x = shipx; x < (shipx + 4); x++) {
							ocean[y][x] = 1;
						}
					}
				}
			}
		} else {
			//Vertical
			if(shipy > 3) {
				for(int y = (shipy - 2); y < (shipy + 2); y++) {
					ocean[y][shipx] = 1; 
				}
			} else {
				for(int y = shipy; y < (shipy + 4); y++) {
					ocean[y][shipx] = 1;
				}
			}
		}
	}
	
	
	public static void userLoop(int[][] ocean) {
		boolean won = false;
		int hit = 0;
		int missiles = 15;
		
		do {
			displayOcean(ocean);
			System.out.println("Missiles remaining: " + missiles);
			int x = Utils.errorCheck("Please enter a x-coordinate", 1, 8);
			int y = Utils.errorCheck("Please enter a y-coordinate", 1, 8);
			
			missiles--;
			int currentVal = ocean[y-1][x-1];
			
			if(currentVal == 0)
				ocean[y-1][x-1] = 2;
			
			if(currentVal == 1) { 
				ocean[y-1][x-1] = 3;
				System.out.println("Hit! X: " + x + " Y: " + y);
				hit++;
			}
			
			if(hit == 4) {
				won = true;
				System.out.println("You won!");
				displayOcean(ocean);
			}
			
			if (missiles < 1) {
				won = true;
				System.out.println("You lost!");
				displayOcean(ocean);
			}
		} while((!won) || (missiles > 0));
	}
	
	//0: Empty, not hit
	//1: Ship, not hit
	//2: Empty, Hit
	//3: Ship, Hit
	
	public static void displayOcean(int[][] ocean) {
		for(int y = 0; y < ocean.length; y++) {
			for(int x = 0; x < ocean[y].length; x++) {
				if(ocean[y][x] == 0 || ocean[y][x] == 1) {
					System.out.print(".");
				} else if(ocean[y][x] == 2) {
					System.out.print('m');
				} else if(ocean[y][x] == 3) {
					System.out.print('x');
				}
			}
			System.out.println();
		}
		
		System.out.println('\n');
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] ocean = new int[8][8];
		
		Utils.initializeArray(ocean, 0);
		
		createShip(ocean);
		
		userLoop(ocean);
	}

}
