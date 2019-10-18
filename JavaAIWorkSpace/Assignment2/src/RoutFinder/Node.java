package RoutFinder;
public class Node {
	//global Var
	//distance from goal
	private int hn;
	//Edges
	private Edge[] edges;
	//name
	private String name;
	
	/**<h1>Constructor</h1>
	 * Creats node based on given param
	 * <p>
	 * @param name				: String name of this distination
	 * @param hn 				: int value of h(n)
	 * @postcondition 			: A Node object has been instantiated 
	 */
	public Node(String name, int hn) {
		this.name = name;
		this.hn = hn;
		
	}
	
	/**<h1>Set Edges</h1>
	 * Set edges array associated with this node
	 * <p>
	 * @param edges				:Edge[] of this nodes edges
	 * @postconditions 			:the edges of this node have been set */
	public void setEdges(Edge[] edges) {
		this.edges = edges;
	}
	
	/**<h1>Get Edges</h1>
	 * Returns array of edges 
	 * <p>
	 * @return edges			: edges[] of edges
	 * @postcondition			: And array of edges has returned
	 * */
	public Edge[] getEdges() {
		return edges;
	}
	
	/**<h1>Get h(n)</h1>
	 * Gets the hn of this node
	 * <p>
	 * @return hn				: int of this node's h(n)
	 * @postcondition 			: h(n) has been returned
	 * */
	public int getHn() {
		return hn;
	}
	
	/**<h1>Get name</h1>
	 * Gets name of this node
	 * <p>
	 * @return name				: String name of this node
	 * @postcondition 			: String name has been returned
	 * */
	public String getName() {
		return name;
	}
}
