package ik.com.anup.graphs;


//1. does not have multiple components and  2. does not have cycle

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Given an undirected graph, find out whether it is a tree.

The undirected edges are given by two arrays edge_start and edge_end of equal size.
 Edges of the given graph connect nodes edge_start[i] and edge_end[i] for all valid i.

Example One
Graph 1

{
"node_count": 4,
"edge_start": [0, 0, 0],
"edge_end": [1, 2, 3]
}
Output:

1
This graph is a tree because all the nodes are connected, and it does not have cycles.

Example Two
Graph 2

{
"node_count": 4,
"edge_start": [0, 0],
"edge_end": [1, 2]
}
Output:

0
This graph is not a tree because node 3 is not connected to the other nodes.

Example Three
Graph 3

{
"node_count": 4,
"edge_start": [0, 0, 1, 2],
"edge_end": [3, 1, 2, 0]
}
Output:

0
This graph is not a tree: nodes 0, 1 and 2 form a cycle.

Example Four
Graph 4

{
"node_count": 4,
"edge_start": [0, 0, 0, 1],
"edge_end": [1, 2, 3, 0]
}
Output:

0
This graph is not a tree because the two edges that connect nodes 0 and 1 form a cycle.

Notes
A tree is an undirected connected acyclic graph.
Constraints:

1 <= number of nodes <= 105
1 <= number of edges <= 105
0 <= node value < number of nodes*/
public class IsItATree {
	static Boolean is_it_a_tree(Integer node_count, ArrayList<Integer> edge_start, ArrayList<Integer> edge_end) {
        // Build the tree
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for (int i = 0; i < node_count; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int i = 0 ; i < edge_start.size() ; i++) {
            adjList.get(edge_start.get(i)).add(edge_end.get(i));
            adjList.get(edge_end.get(i)).add(edge_start.get(i));
        }
        
        // Outer Loop
        int[] visited = new int[node_count];
        Arrays.fill(visited, -1);
        int[] parent = new int[node_count];
        Arrays.fill(parent, -1);
        int components = 0;
        
        for (int i = 0; i < node_count; i++) {
            if  (visited[i] == -1) {
                if (components > 0 || bfs(i, adjList, visited, parent)) {
                    return false;
                }
                components++;// increase count if its not visited and is not cyclic
            }   
        }
        
        return true;
    }
    
    static Boolean bfs (int src, ArrayList<ArrayList<Integer>> adjList, int[] visited, int[] parent) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = 1;
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (Integer neighbor: adjList.get(curr)) {
                if (visited[neighbor] == -1) {
                    q.add(neighbor);
                    visited[neighbor] = 1;
                    parent[neighbor] = curr;
                } else {
                    if (parent[curr] != neighbor) {// found cycle::::::::::::::: this is for undirected so only backedge will trigger cycle
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
/*
Asymptotic complexity in terms of number of nodes `n` and number of edges `m`:
* Time: O(n + m).
* Auxiliary space: O(n + m).
* Total space: O(n + m).
*/
