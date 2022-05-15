package ik.com.anup.graphs;

//course schdule LC210
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*There are n courses to take, they are referred to by numbers from 0 to n-1. Some of them have prerequisites, e.g., courses A and B must be completed before course C can be taken (in other words, course C depends on A and B).

Find and return an ordering in which all the given courses can be taken while satisfying all the prerequisites. If there exists more than one such ordering, any one of them would be a correct answer. If no such ordering exists, return a special value: [-1].

Example
{
"n": 4,
"prerequisites": [
[1, 0],
[2, 0],
[3, 1],
[3, 2]
]
}
Output:

[0, 2, 1, 3]
According to the input,

course 0 must be done before both 1 and 2,
courses 1 and 2 must be done before course 3.
There are two orderings in which one can take all four courses: [0, 2, 1, 3] and [0, 1, 2, 3]. Either is a correct answers.

Notes
Prerequisites are given as a list of pairs: a list of lists where each inner list has exactly two elements. Each pair [X, Y] represents one prerequisite: course Y has to be completed before X can be taken (X depends on Y, in other words).

Function must return a list of integers. If all given courses can be taken while satisfying all given prerequisites, the returned array must contain any of the possible orderings. Otherwise, the function must return [-1].

Constraints:

1 <= n <= 10000
0 <= number of prerequisites <= 10000*/
public class CourseSchedule {
	static int timestamp = 0;
	
	
    static ArrayList<Integer> course_schedule(Integer n, ArrayList<ArrayList<Integer>> prerequisites) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();
        int[] departure = new int[n];
        Arrays.fill(departure, -1);
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();
       
        
        //Section 1: Build graph 
        // convert prerequites to adjList
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());    
        }
        
        for(ArrayList<Integer> edge : prerequisites) {
            int startCourse = edge.get(1);
            int endCourse  = edge.get(0);
            adjList.get(startCourse).add(endCourse);
        }

        // Section 3:: Outer loop ::loop over all node and detect cycle while perform dfs on courses
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                if(dfsHelper(i, adjList, result, visited, departure)) {
                    // cycle detected
                   // result = new ArrayList<>();no need for this
                    result.add(-1);
                    return result;            
                }
            }
        }
        Collections.reverse(result);// topological sort for ascending order since result
        return result;
    }


    
    //SEction 2: DFS 
    static boolean dfsHelper(int sourceNode, List<List<Integer>> adjList, ArrayList<Integer> result,
    		boolean[] visited, int[] departure) {
    	
        visited[sourceNode] = true;
        List<Integer> neighList = adjList.get(sourceNode);
        for(Integer ngbr : neighList) {
            if(!visited[ngbr]) {////>>a; and b comes together to avoid infninte loop
                if(dfsHelper(ngbr, adjList, result, visited, departure)) {///b
                    return true; //loop detected
                }
            } else if (departure[ngbr] == -1) {
                return true;
            }
        }
        // 
        result.add(sourceNode);
        departure[sourceNode] = ++timestamp;
        return false;
    }
    

}
/*
Asymptotic complexity in terms of number of courses `n` and number of prerequisites `e`:
* Time: O(n + e).
* Auxiliary space: O(n + e).
* Total space: O(n + e).
*/