package ik.com.anup.graphs;

import java.util.ArrayList;

/*There are zombies in Seattle. Some of them know each other directly. Others might know each other transitively, through others. For example, if zombies A<->B and B<->C know each other directly, then A and C know each other indirectly and all three belong to one cluster.

Knowing which zombies know each other directly, find the number of the zombie clusters.

Input is a square matrix where each cell, zombies[A][B], indicates whether zombie A knows zombie B directly.

Example One
Example one

{
"zombies": [
"1100",
"1110",
"0110",
"0001"
]
}
Output:

2
There are four zombies: z0, z1, z2 and z3.
Each zombie knows oneself, thus the matrix diagonal has all 1s.
Other than that, the green matrix cells indicate that z0<->z1 and z1<->z2 know each other directly.
Because of the transitive property, zombies z0, z1 and z2 form one cluster.
The remaining zombie, z3, doesn't know others and forms their own separate cluster.
This gives us a total of 2 zombie clusters.

Example Two
Example one

{
"zombies": [
"10000",
"01000",
"00100",
"00010",
"00001"
]
}
Output:

5
Each zombie forms their own cluster: {z0}, {z1}, {z2}, {z3}, and {z4}. The total number of clusters is 5.

Notes
Constraints:

1 <= number of zombies <= 1000*/
public class ZombieClusters {
	  /*
    Asymptotic complexity in terms of the size of `zombies` `n`:
    * Time: O(n^2).
    * Auxiliary space: O(n).
    * Total space: O(n^2).
    */
    static Integer zombie_cluster(ArrayList<String> zombies) {
        int clusters = 0, n = zombies.size();
        boolean[] visited = new boolean[n];

        // Call dfs on any zombie that has not been visited yet.
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                // Any unvisited zombie is a part of a cluster we have not seen until now.
                clusters++;
                // dfs() call will visit *all* zombies in that cluster.
                dfs(i, n, zombies, visited);
            }
        }
        return clusters;
    }

    // Traverse depth first starting from node x, mark all visited nodes visited.
    static void dfs(int x, int n, ArrayList<String> zombies, boolean[] visited) {
        
    	visited[x] = true;
        for(int i = 0; i < n; i++) {
            if(zombies.get(x).charAt(i) == '1' && !visited[i]) {
                dfs(i, n, zombies, visited);
            }
        }
    }
}
