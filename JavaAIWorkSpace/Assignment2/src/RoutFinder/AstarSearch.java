package RoutFinder;

import java.util.ArrayList;

public class AstarSearch {
	//edges and nodes to search
	
	//current node in search
	private Node current;
	//goal node
	private Node goal;
	/**<h1>Constructor</h1>
	 * Creates an AstarSearch object based on given paramaters
	 * <p>
	 * @param nodes					: Node[] array of nodes to search through
	 * @precondition 				: Starting node must be first node in nodes and
	 * goal node must be last in nodes
	 * @postcondition				: an instance of the AstarSearch class has 
	 * been instantiated with nodes
	 *  */
	public AstarSearch(Node[] nodes) {

		this.current = nodes[0];//starting node must first
		this.goal = nodes[nodes.length-1];//goal node must be last
	}
	
	/**<h1>Step</h1>
	 * Step through search
	 * <p>
	 * @postcondition				: The A* search has been advance by one steps*/
	public void step() {
		if(!current.getName().equals(goal.getName())) {
			//create list possible moves
			ArrayList<Node> moves = new ArrayList<Node>();
			for(int i=0; i< current.getEdges().length;i++) {
				if(!current.getEdges()[i].getFirstNode().getName().equals(current.getName())) {
					moves.add(current.getEdges()[i].getFirstNode());
				}else {
					moves.add(current.getEdges()[i].getSecondNode());
				}
			}

			//find index lowest fn
			int fn=moves.get(0).getHn()+current.getEdges()[0].getGn();
			int index = 0;
			for(int i=0; i < moves.size();i++) {
				if(fn > moves.get(i).getHn()+current.getEdges()[i].getGn()) {
					fn=moves.get(i).getHn()+current.getEdges()[i].getGn();
					index =i;
				}
			}
			current = moves.get(index);
		}
	}
	
	/**<h1>Get Current</h1>
	 * Returns current node
	 * <p>
	 * @return current 				: Node the current node
	 * @postcondition 				: The current node has been returned			
	 * */
	public Node getCurrent() {
		return current;
	}
}
