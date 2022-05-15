package ik.com.anup.graphs;

//need to find cycle and also arrival time/lowest time 

import java.util.ArrayList;

/*Given a network of servers where each server is connected to every other server directly or indirectly through the bidirectional connections in the network, find all the critical connections.

A connection in a connected network is said to be critical if removing it disconnects the network.

Example One
Example one

{
"number_of_servers": 5,
"connections": [
[0, 1],
[0, 2],
[0, 4],
[1, 2],
[1, 3]
]
}
Output:

[
[0, 4],
[1, 3]
]
Order of servers within a connection and order of connections in the output does not matter, so another one of several other correct outputs here is

[
[3, 1]
[0, 4],
]
Example Two
Example Two

{
"number_of_servers": 4,
"connections": [
[0, 1],
[0, 2],
[0, 3]
[1, 2],
[2, 3]
]
}
Output:

[
[-1, -1]
]
Removing any one connection won't disconnect the network.

Notes
Return [[-1,-1]] if there are no critical connections in the network.
Constraints:

1 <= number of servers <= 105
0 <= number of connections <= 105
Servers are numbered from 0 to (number of servers - 1)
There are no self-loops and no multiple edges*/
public class CriticalConnections {
	  static ArrayList<ArrayList<Integer>> find_critical_connections(Integer number_of_servers,
			  ArrayList<ArrayList<Integer>> connections) {
	        // Write your code here.
	        
	        //build graph
	        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(number_of_servers);
	        for(int i=0; i< number_of_servers; i++) {
	            adjList.add(new ArrayList<Integer>());
	        }
	        
	     // Creating adjacency list representation
	        for(int i=0; i< connections.size(); i++) {
	            int start = connections.get(i).get(0);//start
	            int end = connections.get(i).get(1);//end
	            
	            adjList.get(start).add(end);
	            adjList.get(end).add(start);
	        }
	        // Set discovery time and initialize lowest time.
	        
	        int[] arrival = new int[number_of_servers];//discoverytime
	        int[] lowest = new int[number_of_servers];
	        int[] visited = new int[number_of_servers];
	        int[] parent = new int[number_of_servers];
	        for(int i=0; i<number_of_servers; i++) {
	            visited[i] = 0;
	           // departure[i] = 0;
	            arrival[i] = 0;
	        }
	        
	        for(int i=0; i<number_of_servers; i++) {
	            parent[i] = -1;
	        }
	        
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        
	        for(int i=0; i<number_of_servers; i++) {
	            if(visited[i] == 0) {
	                dfs(i, adjList, result, visited, parent, arrival, lowest);
	            }
	        }
	        
	        if(result.size() == 0) {
	            //result.add(new ArrayList<>(Arrays.asList(-1, -1)));
	        }
	        return result;
	    }
	    
	  
	  
	    static int timestamp = 0;//************************************
	    
	    
	    
	    static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, ArrayList<ArrayList<Integer>> result, 
	    		int[] visited, int[] parent, int[] arrival, int[] lowest) {
	    	
	        visited[node] = 1;
	        arrival[node] = timestamp++;
	        lowest[node] = arrival[node];
	        // Note: discovery time won't change whereas lowest time might be updated.
	        
	        ArrayList<Integer> neighboursList = adjList.get(node);
	        
	        for(int i=0; i< neighboursList.size(); i++) {//a
	            
	            int neighbour = neighboursList.get(i);//b >> both a  and used to be for (Node v :adjList[u])
	            //skip the parent, since this is undirected graph
	            if(parent[node] == neighbour) continue;
	            
	            if(visited[neighbour] == 0) {
	                parent[neighbour] = node;
	                visited[neighbour] = 1;
	                dfs(neighbour, adjList, result, visited, parent, arrival, lowest);
	                
	                
	                //check if the edge is a bridge::::::/// if arr_node> lowest_neigh than it is backedge
	                if(lowest[neighbour] > arrival[node]) {
	                    ArrayList<Integer> resultList = new ArrayList<Integer>();
	                    resultList.add(node);
	                    resultList.add(neighbour);
	                    result.add(resultList);
	                }
	                
	            }
	            //check the lowest rank for this node and neightbor lowest rank
	            lowest[node] = Integer.min(lowest[node], lowest[neighbour]);// after ifelse check update the lowest 
	        }
	        
	        
	    }
}
/************optimal_solution.cpp
The concept of critical connection here is the famous concept in graph theory called “Bridges”. Question is to find out all the bridges in the given graph.

The idea is to use DFS (Depth First Search). In the DFS tree, any tree edge (u, v) where v is the parent node of u,
 is a bridge if none of the descendants of u has a back-edge to any of the ancestors of v. 
This means there is no way from u to v except for the edge (u, v). If a back-edge is found, this means there
 exists another path from u to v, and node u and v will still be connected if edge (u, v) is removed. Also,
  the back-edge can’t be a bridge because the edge (u, v) will keep the graph connected if the back-edge is removed.

We maintain an array that stores the discovery times of each vertex computed by DFS. 
Also, we store the earliest visited vertex (the vertex with minimum discovery time) that can be reached from 
subtree rooted at v. So we maintain an additional array lowest_time where lowest_time[v] is the minimum of:

discovery_time[v]
discovery_time[p], for all p for which (v, p) is a back-edge
lowest_time[u], for all u for which (v, u) is a tree edge, here u belongs to the subtree of v.
Now, for an edge (u, v), there is a back edge from vertex u or from one of its descendants to v or one of its 
ancestors if lowest_time[u] <= discovery_time[v]. Thus, if lowest_time[u] > discovery_time[v], edge (u, v) is a bridge.

Time Complexity
O(number_of_servers + number_of_connections).

To create adjacency list = O(number_of_connections).
DFS algorithm = O(number_of_servers + number_of_connections).

Auxiliary Space Used
O(number_of_servers + number_of_connections).

Memory used for adjacency list = O(number_of_servers + number_of_connections).
Memory used for visited, discovery time, lowest time array = O(number_of_servers).

Space Complexity
O(number_of_servers + number_of_connections).

Memory used for input = O(number_of_connections).
Memory used for output = O(number_of_connections).
Auxiliary space = O(number_of_servers + number_of_connections).
Total space complexity = O(number_of_servers + number_of_connections).
*******************/