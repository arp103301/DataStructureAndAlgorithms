package ik.com.anup.graphs;
// no visited inside the for/if block


public class DFS_Template {
	
		// …..
		//adjList is an array of lists
		 void DFS(int node) {
	//	 visited[node] = 1
	//	 for neighbor in adjList[node]:
	//	 	if visited[neighbor] == -1: parent [neighbor]= node;
	//					 DFS(neighbor)>> return true from here if any recursion gives backedge
			 			// else if  neigbor is not parent  and has alrady been visited >>> means backedge for DFS so cycle exists
		 
			 //else visited//( backedge, crossedge, forward edge exists
			 			// if (departure[neighbor]=-1 )
			 			// return true// cycle exists
			 
	
	//departure [neighbor]= timestamp++;
	//return false;
		 }
		
}
