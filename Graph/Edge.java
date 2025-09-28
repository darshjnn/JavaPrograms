package Graph;

public class Edge implements Comparable<Edge> {
	public int src, dest, wt;
	
	public Edge(int source, int dest) {
		this.src = source;
		this.dest = dest;
	}
	
	public Edge(int source, int dest, int wt) {
		this.src = source;
		this.dest = dest;
		this.wt = wt;
	}
	
	@Override
	public int compareTo(Edge e) {
		return this.wt - e.wt;
	}
}
