package util;

import java.util.Random;

public class PuzzleBoxUtils {
	/**<h1> Generate Tiles</h1>
	 * Generates a char array of tiles containing the chars 
	 * 1,2,3,4,5,6,7,8,* in a random order
	 * <p>
	 * @return tiles          : char[] containing tiles 
	 * @postcondition         : An array of 9 char has been returned
	 * */
	public static char[] genTiles() {

		//starting tiles
		char[] tiles= {'1','2','3','8','*','4','7','6','5'};
		//mix up
		int starIndx=0;
		Random r = new Random();
		//shuffle
		for(int i = 0; i <= 3 ; i++) {
			for(int j =0; j < tiles.length; j++) {
				if(tiles[j]=='*')
					starIndx=j;
			}
			//top left corner
			if(starIndx==0) {
				if( (r.nextInt((2 - 1) + 1) + 1)== 1 ) {
					tiles[0] = tiles[1];
					tiles[1] = '*';
				}else {
					tiles[0] = tiles[3];
					tiles[3] = '*';
				}
			}
			//top middle
			if(starIndx==1) {
				if( (r.nextInt((3 - 1) + 1) + 1)== 1 ) {
					tiles[1] = tiles[0];
					tiles[0] = '*';
				}else if( (r.nextInt((3 - 1) + 1) + 1)== 2 ) {
					tiles[1] = tiles[2];
					tiles[2] = '*';
				}else {
					tiles[1] = tiles[4];
					tiles[4] = '*';
				}
			}
			//top right corner
			if(starIndx==2) {
				if( (r.nextInt((2 - 1) + 1) + 1)== 1 ) {
					tiles[2] = tiles[1];
					tiles[1] = '*';
				}else {
					tiles[2] = tiles[5];
					tiles[5] = '*';
				}
			}
			//middle left
			if(starIndx==3) {
				if( (r.nextInt((3 - 1) + 1) + 1)== 1 ) {
					tiles[3] = tiles[0];
					tiles[0] = '*';
				}else if( (r.nextInt((3 - 1) + 1) + 1)== 2 ) {
					tiles[3] = tiles[4];
					tiles[4] = '*';
				}else {
					tiles[3] = tiles[6];
					tiles[6] = '*';
				}
			}
			//middle
			if(starIndx==4) {
				if( (r.nextInt((4 - 1) + 1) + 1)== 1 ) {
					tiles[4] = tiles[5];
					tiles[5] = '*';
				}else if( (r.nextInt((4 - 1) + 1) + 1)== 2 ) {
					tiles[4] = tiles[7];
					tiles[7] = '*';
				}else if( (r.nextInt((4 - 1) + 1) + 1)== 3 ) {
					tiles[4] = tiles[3];
					tiles[3] = '*';
				}else {
					tiles[4] = tiles[1];
					tiles[1] = '*';
				}
			}
			//middle right
			if(starIndx==5) {
				if( (r.nextInt((3 - 1) + 1) + 1)== 1 ) {
					tiles[5] = tiles[2];
					tiles[2] = '*';
				}else if( (r.nextInt((3 - 1) + 1) + 1)== 2 ) {
					tiles[5] = tiles[4];
					tiles[4] = '*';
				}else {
					tiles[5] = tiles[8];
					tiles[8] = '*';
				}
			}
			//bottom left corner
			if(starIndx==6) {
				if( (r.nextInt((2 - 1) + 1) + 1)== 1 ) {
					tiles[6] = tiles[3];
					tiles[3] = '*';
				}else {
					tiles[6] = tiles[7];
					tiles[7] = '*';
				}
			}
			//bottom middle 
			if(starIndx==7) {
				if( (r.nextInt((3 - 1) + 1) + 1)== 1 ) {
					tiles[7] = tiles[6];
					tiles[6] = '*';
				}else if( (r.nextInt((3 - 1) + 1) + 1)== 2 ) {
					tiles[7] = tiles[4];
					tiles[4] = '*';
				}else {
					tiles[7] = tiles[8];
					tiles[8] = '*';
				}
			}
			//bottom right corner
			if(starIndx==8) {
				if( (r.nextInt((2 - 1) + 1) + 1)== 1 ) {
					tiles[8] = tiles[5];
					tiles[5] = '*';
				}else {
					tiles[8] = tiles[7];
					tiles[7] = '*';
				}
			}
		}
		return tiles;
		
	}
	
	/**<h1> h(n) Distance from goal state</h1>
	 * Will determine distance from goal state by counting how manny tiles
	 * are different from goal state. This will server as h(n) in the A* 
	 * formula f(n)=(g)+h(n)
	 * <p>
	 * @param current tiles     : tiles to be compared to goal state
	 * @return distance			: int distance from goal state
	 * @postcondition			: an int reprasenting distance from goal 
	 * state is returned
	 * */
	public static int distanceToGoal(char[] tiles) {
		int d=0;
		char[] goal = {'1','2','3','8','*','4','7','6','5'};
		for(int i =0; i <tiles.length;i++) {
			if(tiles[i] != goal[i] && tiles[i] != '*') {
				d++;
			}
		}
		return d;
	}
	
	/**<h1> h(n) Distance from start </h1>
	 * Will determine distance from starting state by counting how manny tiles
	 * are different from starting  state. This will server as g(n) in the A* 
	 * formula f(n)=(g)+h(n)
	 * <p>
	 * @param starting tiles    : tiles of starting state
	 * @param current tiles     : tiles to be compared to starting state
	 * @return distance			: int distance from goal state
	 * @postcondition			: an int reprasenting distance from goal 
	 * state is returned
	 * */
	public static int distanceFromStart(char[] start, char[] tiles) {
		int d=0;
		
		for(int i =0; i <tiles.length;i++) {
			if(tiles[i]!= start[i]) {
				d++;
			}
		}
		return d;
	}
}
