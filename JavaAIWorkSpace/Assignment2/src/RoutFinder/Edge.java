package RoutFinder;

public class Edge {
	//cost of traversing edge
	private int gn;
	//first node associated with this edge
	private Node firstNode;
	//first node associated with this edge
	private Node secondNode;
	
	/**<h1>Constructor</h1>
	 * Constructs object based on given parameters
	 * <p>
	 * @param gn				: int indicating cost of traversing this edge
	 * @param firstNode			: First Node this edge is attached to 
	 * @param secondNode		: Second Node this edge is attached to
	 * @postioncondition		: An Edge object has been instantiated .
	 * */
	public Edge(int gn, Node firstNode, Node secondNode) {
		this.gn = gn;
		this.firstNode = firstNode;
		this.secondNode = secondNode;

	}
	
	/**<h1>Get firstNode</h1>
	 * Gets the firstNode of this edge
	 * <p>
	 * @return firstNode		: firstNode of this edge
	 * @postcondition 			: A node has been returned
	 * */
	public Node getFirstNode() {
		return firstNode;
	}
	
	/**<h1>Get SecondNode</h1>
	 * Gets the secondNode of this edge
	 * <p>
	 * @return secondNode		: SecondNode of this edge
	 * @postcondition 			: A node has been returned
	 * */
	public Node getSecondNode() {
		return secondNode;
	}
	
	/**<h1>Get g(n)</h1>
	 * Gets the gn of this edges
	 * <p>
	 * @return gn				: int of this edges's g(n)
	 * @postcondition 			: g(n) has been returned
	 * */
	public int getGn() {
		return gn;
	}
}
