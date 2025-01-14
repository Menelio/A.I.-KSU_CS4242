package eightTile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*Class to preform A* search*/
public class AStarSearch {
	//Current PuzzleBox
	PuzzleBox current;
	//ArrayList of PuzzleBoxs to consider for moves
	ArrayList<PuzzleBox> possibleMoves; 
	
	//bool to indicated if goal has been reached goal reached
	boolean goalReached;
	
	/**<h1> Constructor </h1>
	 * Initializes A* search obj with given puzzle book(should be root
	 * <p>
	 * @param root			: First puzzle box considerd in A* search
	 * @postcondition A A* search obj has been instatiated with a root puzzle box
	 * */
	public AStarSearch(PuzzleBox root) {
		current = root;
		possibleMoves = new ArrayList<PuzzleBox>();
		possibleMoves.add(root);
		current.genMoves();
		
		possibleMoves.clear();
		//add them to ArrayList of possibleMoves
		for(int i=0; i < current.getMoves().length;i++) {
			possibleMoves.add(current.getMoves()[i]);
		}
		//sort possibleMoves
		for(int i=0; i < possibleMoves.size(); i++) {
			for(int j=0; j < possibleMoves.size(); j++) {
				if(possibleMoves.get(i).getFn() < possibleMoves.get(j).getFn() ) {
					Collections.swap(possibleMoves, i, j);
				}
			}
		}
	}
	
	/**<h1>step</h1>
	 * Finds the next move by finding lowest f(n) and expanding associated puzzle 
	 * boxes moves, then sorting them into possibleMoves by lowest f(n)
	 * <p>
	 * @postcondition current and possibleMoves has been updated 
	 * */
	public void step() {
		//generate moves
		current.genMoves();
		possibleMoves.clear();
		//add them to ArrayList of possibleMoves
		for(int i=0; i < current.getMoves().length;i++) {
			possibleMoves.add(current.getMoves()[i]);
		}
		//sort possibleMoves
		for(int i=0; i < possibleMoves.size(); i++) {
			for(int j=0; j < possibleMoves.size(); j++) {
				if(possibleMoves.get(i).getFn() < possibleMoves.get(j).getFn() ) {
					Collections.swap(possibleMoves, i, j);
				}
			}
		}
		//set current to puzzle box with lowest f(n) 
		current = possibleMoves.get(0);
		//test if goal is reached
		char[] goal = {'1','2','3','8','*','4','7','6','5'};
				
		goalReached = Arrays.equals(current.getTiles(), goal);
			
		//if goal reach check =true, return
		if(goalReached) { 
			return;
		}
	}
	
	/**<h1> Get status </h1>
	 * Returns boolean value indicating weather or no goal has  been reached
	 * <p>
	 * @param goalReached			: bool indicating status of A* search
	 * @postcondition 				: bool indicating status of search has been returned
	 * */
	public boolean getStatus() {
		return goalReached;
	}
	
	/**<h1>Get Current</h1>
	 * Retruns current Puzzle Box A* search if on 
	 * <p>
	 * @return current				:The current Puzzle Box
	 * @postcondition 				:A Puzzle Box has been returned
	 * */
	public PuzzleBox getCurrent() {
		return current;
	}
}
