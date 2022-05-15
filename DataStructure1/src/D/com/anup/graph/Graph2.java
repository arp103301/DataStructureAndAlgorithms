package D.com.anup.graph;

import java.util.LinkedList;
import java.util.Queue;
 
public class Graph2 {
	
	private LinkedList<Integer>[ ] adj;
	private int V; // number of vertices
	private int E; // number of edges
	
	public Graph2(int nodes) {
		this.V = nodes;
		this.E = 0;
		this.adj = new LinkedList[nodes];
		for(int v = 0; v < V; v++) {
			adj[v] = new LinkedList<>();
		}
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
		E++;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges " + "\n");
		for(int v = 0; v < V; v++) {
			sb.append(v + ": ");
			for(int w : adj[v]) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
	//search by level ##################################
	public void bfs(int s) {
		boolean[] visited = new boolean[V];
		
		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;//#####################
		q.offer(s);
		
		while(!q.isEmpty()) {
			int u = q.poll();////////////////poll and pop::::::: poll returns null
			System.out.print(u + " ");
			
			for(int v : adj[u]) {// all  neighbor to be viisted before pushing this node
				if(!visited[v]) {//every unvisited node V
					visited[v] = true;//////////////###########################
					q.offer(v);
				}
			}
		}
	}
 
	public static void main(String[] args) {
		Graph2 g = new Graph2(5);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		g.addEdge(2, 4);
		g.bfs(0);
	}
}