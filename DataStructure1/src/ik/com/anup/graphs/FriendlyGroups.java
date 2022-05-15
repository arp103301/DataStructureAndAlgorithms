package ik.com.anup.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*There are n people living in a town. Some of them dislike each other. 
 * Given the value of n and two equal length integer arrays called dislike1 and dislike2. 
 * For each i in [0, dislike1_size - 1], the person dislike1[i] dislikes the person dislike2[i]. 
 * Check if we can divide the people of the town into two sets such that each person belongs to exactly one set 
 * and no two persons disliking each other belong to the same set.

Example One
{
"num_of_people": 5,
"dislike1": [0, 1, 1, 2, 3],
"dislike2": [2, 2, 4, 3, 4]
}
Output:

1
The people can be partitioned into two sets [0, 1, 3] and [2, 4].

Example Two
{
"num_of_people": 4,
"dislike1": [0, 0, 0, 1, 2],
"dislike2": [1, 2, 3, 2, 3]
}
Output:

0
Notes
People are numbered from 0 to n - 1.

Constraints:

1 <= n <= 2*103
0 <= number of disliking pairs <= min((n * (n - 1))/2, 104)*/
public class FriendlyGroups {


    static Boolean can_be_divided(Integer num_of_people, ArrayList<Integer> dislike1, ArrayList<Integer> dislike2) {
        // Write your code here.
        
        //Build a graph
        ArrayList<ArrayList<Integer>> adjList = new ArrayList();
        int[] visited = new int[num_of_people];
        int[] nodeLevel = new int[num_of_people];
        
        for(int i = 0; i < num_of_people; i++){
            adjList.add(i, new ArrayList());
            visited[i] = -1;
        }
        
        for(int i = 0; i < dislike1.size(); i++){
            adjList.get(dislike1.get(i)).add(dislike2.get(i));
            adjList.get(dislike2.get(i)).add(dislike1.get(i));
        }
    
        
        //Invoke BFS
        for(int person = 0; person < num_of_people; person++){
            if(visited[person] == -1){
                if(!bfs(person, adjList, visited, nodeLevel)) return false;
            }
        }
    
        return true;
    }

    static boolean bfs(int person, ArrayList<ArrayList<Integer>> adjList, int[] visited, int[] nodeLevel){
        Queue<Integer> queue = new LinkedList();
        queue.add(person);
        
        visited[person] = 1;
        int level = 0;
        int initialQueueSize = 0;
        
        while(!queue.isEmpty()){
            
            initialQueueSize = queue.size();
            level++;
            
            while(initialQueueSize > 0) {
                int personn = queue.poll();
                for(Integer ind : adjList.get(personn)){
                    if(visited[ind] == -1){
                        queue.add(ind);
                        visited[ind] = 1;
                        nodeLevel[ind] = level;
                    } else {
                        if(nodeLevel[ind] % 2 == nodeLevel[personn] % 2) return false;
                        // if both are same color then total length will be even+1 (cross edge ) 
                        //makeing the totla length odd hence theyare not bipartite:: check the class notes
                    }
                }
                initialQueueSize--;
            }
        }
        
        return true;
    }
}
/*
Asymptotic complexity in terms of number of people `n` and number of disliking pairs `m`:
* Time: O(n + m).
* Auxiliary space: O(n).
* Total space: O(n + m).
*/