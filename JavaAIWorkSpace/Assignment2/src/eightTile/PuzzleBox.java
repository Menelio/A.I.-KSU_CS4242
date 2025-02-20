package eightTile;

import java.util.Arrays;

public class PuzzleBox {
	//array of char for tiles, kept in order from position 1 to 9 ('*'= blank tile)
	private char[] tiles;
	//array of puzzle boxes for the moves
	private PuzzleBox[] moves;
	//distance from goal, value of h(n)
	private int hn;
	//distance from start, value of g(n)
	private int gn;
	
	/**<h1>No Args Constructor</h1>
	 * <p>
	 * @postioncondition		: an instance of the PuzzleBox class has 
	 * been instantiated with random tiles.
	 * */
	public PuzzleBox() {
		this.tiles = util.PuzzleBoxUtils.genTiles();
		this.hn = util.PuzzleBoxUtils.distanceToGoal(this.tiles);
		//no args constructor would only be used to create root PuzzleBox so gn=0
		this.gn=0;
	}
	
	/**<h1> Args Constructor</h1>
	 * <p>
	 * @param parentsGn         : gn of parent puzzel box
	 * @param tiles             : char[] of tiles for this puzzle box
	 * @postioncondition		: an instance of the PuzzleBox class has 
	 * been instantiated with given tiles.
	 * */
	public PuzzleBox(char[] tiles, int parentsGn) {
		this.tiles = tiles;
		this.hn = util.PuzzleBoxUtils.distanceToGoal(this.tiles);
		this.gn = parentsGn+1;
		
	}
	
	/**<h1>Copy Constructor</h1>
	 * Copies PuzzleBox
	 * <p>
	 * @param PuzzleBox 		: Given PuzzleBox to be copied
	 * @postcondition 			: A copy of given PuzzleBox has been made 
	 * */
	public PuzzleBox(PuzzleBox toCopy) {
		this.tiles = Arrays.copyOf(toCopy.getTiles(), toCopy.getTiles().length);
		this.hn = util.PuzzleBoxUtils.distanceToGoal(this.tiles);
		this.gn = toCopy.getGn();
	}
	
	/**<h1> Generate Moves <h1>
	 * Generates child puzzle box nodes based on possible moves, and populates
	 * PuzzleBox[] moves
	 * <p>
	 * @postcondition 			: PuzzleBox[] moves has been populated  
	 * */
	public void genMoves() {
		//index of *
		int sIndex=0;
		for(int i=0; i< tiles.length;i++) 
			if(tiles[i]=='*') 
				sIndex = i;
		//unmodified tile array for child puzzle mox
		char[] childTiles =Arrays.copyOf(tiles, tiles.length);
		//populate moves with all possible puzzle boxes based on sIndex
		if(sIndex==0) {//space is in top left corner
			//initials move[]
			moves= new PuzzleBox[2];
			//move space to top middle
			childTiles[1] = tiles[0];
			childTiles[0] = tiles[1];
			moves[0]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);;
			//move space to left middle
			childTiles[3] = tiles[0];
			childTiles[0] = tiles[3];
			moves[1]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);;
			
		}else if(sIndex==1) {//space is in top middle
			//initials move[]
			moves= new PuzzleBox[3];
			//move space to top left corner
			childTiles[0] = tiles[1];
			childTiles[1] = tiles[0];
			moves[0]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			//move space to middle
			childTiles[4] = tiles[1];
			childTiles[1] = tiles[4];
			moves[1]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			//move space to top right corner
			childTiles[2] = tiles[1];
			childTiles[1] = tiles[2];
			moves[2]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			
		}else if(sIndex==2) {//space is in top right corner
			//initials move[]
			moves= new PuzzleBox[2];
			//move space to top middle
			childTiles[1] = tiles[2];
			childTiles[2] = tiles[1];
			moves[0]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			//move space to right middle
			childTiles[5] = tiles[2];
			childTiles[2] = tiles[5];
			moves[1]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			
		}else if(sIndex==3) {//space is in left middle
			//initials move[]
			moves= new PuzzleBox[3];
			//move space to top bottom left corner
			childTiles[6] = tiles[3];
			childTiles[3] = tiles[6];
			moves[0]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			//move space to middle
			childTiles[4] = tiles[3];
			childTiles[3] = tiles[4];
			moves[1]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			//move space to top left corner
			childTiles[0] = tiles[3];
			childTiles[3] = tiles[0];
			moves[2]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			
		}else if(sIndex==4) {//space is in middle		
			//initials move[]
			moves= new PuzzleBox[4];
			//move space to top middle
			childTiles[1] = tiles[4];
			childTiles[4] = tiles[1];
			moves[0]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			//move space to top left middle
			childTiles[3] = tiles[4];
			childTiles[4] = tiles[3];
			moves[1]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			//move space to bottom middle
			childTiles[7] = tiles[4];
			childTiles[4] = tiles[7];
			moves[2]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			//move space to right middle
			childTiles[5] = tiles[4];
			childTiles[4] = tiles[5];
			moves[3]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
				
		}else if(sIndex==5) {//space is in right middle
			//initials move[]
			moves= new PuzzleBox[3];
			//move space to top right corner
			childTiles[2] = tiles[5];
			childTiles[5] = tiles[2];
			moves[0]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			//move space to middle
			childTiles[4] = tiles[5];
			childTiles[5] = tiles[4];
			moves[1]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			//move space to top bottom right corner
			childTiles[8] = tiles[5];
			childTiles[5] = tiles[8];
			moves[2]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			
		}else if(sIndex==6) {//space is in bottom left corner
			//initials move[]
			moves= new PuzzleBox[2];
			//move space to bottom middle
			childTiles[3] = tiles[6];
			childTiles[6] = tiles[3];
			moves[0]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			//move space to left middle
			childTiles[7] = tiles[6];
			childTiles[6] = tiles[7];
			moves[1]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			
		}else if(sIndex==7) {//space is in top middle
			//initials move[]
			moves= new PuzzleBox[3];
			//move space to bottom left corner
			childTiles[8] = tiles[7];
			childTiles[7] = tiles[8];
			moves[0]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			//move space to middle
			childTiles[4] = tiles[7];
			childTiles[7] = tiles[4];
			moves[1]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			//move space to bottom right corner
			childTiles[6] = tiles[7];
			childTiles[7] = tiles[6];
			moves[2]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			
		}else if(sIndex==8) {//space is in bottom left corner
			//initials move[]
			moves= new PuzzleBox[2];
			//move space to bottom middle
			childTiles[5] = tiles[8];
			childTiles[8] = tiles[5];
			moves[0]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
			//move space to right middle
			childTiles[7] = tiles[8];
			childTiles[8] = tiles[7];
			moves[1]= new PuzzleBox(childTiles, gn);
			//reset tiles
			childTiles = Arrays.copyOf(tiles, tiles.length);
		}
			
	}
	/**<h1>Get tiles </h1>
	 * Returns the tiles of this puzzle box
	 * <p>
	 * @return tiles			: char[] tiles 
	 * @postcondition			: tiles have been returned
	 * */
	public char[] getTiles() {
		return this.tiles;
	} 
	
	/**<h1>Get Moves </h1>
	 * Returns the moves of this puzzle box
	 * <p>
	 * @return moves			: PuzzleBox[] of moves 
	 * @postcondition			: moves have been returned
	 * */
	public PuzzleBox[] getMoves() {
		return this.moves;
	} 

	/**<h1> Get h(n)</h1>
	 * Returns iny value of hn
	 * <p>
	 * @return hn				: Return int value of h(n)
	 * @postcondition 			: value of h(n)
	 * */
	public int getHn() {
		return hn;
	}
	/**<h1> Get g(n)</h1>
	 * Returns iny value of gn
	 * <p>
	 * @return gn				: Return int value of g(n)
	 * @postcondition 			: value of g(n)
	 * */
	public int getGn() {
		return gn;
	}
	
	/**<h1> Get f(n)</h1>
	 * Returns iny value of g(n)+h(n)
	 * <p>
	 * @return gn				: Return int value of g(n)
	 * @postcondition 			: value of g(n)
	 * */
	public int getFn() {
		return gn+hn;
	}
}
