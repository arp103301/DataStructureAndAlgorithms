package ik.com.anup.graphs;

import java.util.ArrayList;

/*A university has n courses to offer. To graduate from that university, a student must complete all those courses. Some courses have prerequisite courses. One can take a course only after completing all of its prerequisites. Dependencies between the courses are described by two arrays a and b of the same size: course a[i] must be taken before course b[i] for all valid indices. Is it possible to complete all the courses without violating constraints?

Example One
{
"n": 4,
"a": [1, 1, 3],
"b": [0, 2, 1]
}
Output:

1
One possible ordering is 3, 1, 0, 2.

Example Two
{
"n": 4,
"a": [1, 1, 3, 0],
"b": [0, 2, 1, 3]
}
Output:

0
Every possible ordering of the courses violates at least one of the constraints.

Notes
The courses are labeled from 0 to n - 1.
Constraints:

2 <= n <= 100000
1 <= size of a = size of b <= 100000
0 <= a[i], b[i] < n holds for any valid index i
a[i] != b[i] holds for any valid index i
No duplicate dependencies are present*/
public class CompleteAllCoursesWithDependencies {

	   static int time = 0;
	    static Boolean can_be_completed(Integer n, ArrayList<Integer> a, ArrayList<Integer> b) {
	        ArrayList<ArrayList<Integer>> prereq = new ArrayList<>(n);
	        for (int i = 0; i < n; i++) {
	            prereq.add(new ArrayList<>());
	        }
	        // directed edge from a[i] to b[i]
	        for (int i = 0; i < a.size(); i++) {
	            prereq.get(a.get(i)).add(b.get(i));
	        }
	        boolean[] visited = new boolean[n];
	        int[] arrival = new int[n];
	        int[] departure = new int[n];
	        time = 0;
	        for (int i = 0; i < n; i++) {
	            if (visited[i] == false) {
	                if (isCyclePresentDfs(i, visited, arrival, departure, prereq) == true)
	                    return false;
	            }
	        }
	        
	        return true;
	    }
	    
	    static boolean isCyclePresentDfs(int source, boolean[] visited, int[] arrival, int[] departure, ArrayList<ArrayList<Integer>> prereq) {
	        visited[source] = true;
	        arrival[source] = ++time;
	        for(int nbr: prereq.get(source)) {
	            if (visited[nbr] == false) {
	                if (isCyclePresentDfs(nbr, visited, arrival, departure, prereq) == true)
	                    return true;   
	            } else {
	                if (departure[nbr] == 0) // nbr is visited but processing not completed, so it is source's ancestor
	                    return true;
	            }
	        }
	        departure[source] = ++time;
	        return false;
	    }
}
