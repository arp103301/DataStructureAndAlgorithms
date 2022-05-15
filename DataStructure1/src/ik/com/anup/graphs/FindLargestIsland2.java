package ik.com.anup.graphs;

//https://leetcode.com/problems/max-area-of-island/solution/

import java.util.ArrayList;
import java.util.Stack;

/*Given a two-dimensional grid of 0s and 1s, find the size of the largest island. If there is no island return 0.

An island is a group of 1s connected vertically or horizontally.

Example One
{
"grid": [
[1, 1, 0],
[1, 1, 0],
[0, 0, 1]
]
}
Output:

4
There are two islands:

[(0, 0), (0, 1), (1, 0), (1, 1)]
[(2, 2)]
Size of the largest (first) island is 4.

Example Two
{
"grid": [
[0, 0, 0],
[0, 0, 0],
[0, 0, 0]
]
}
Output:

0
Notes
Constraints:

1 <= number of rows <= 200
1 <= number of columns <= 200*/
public class FindLargestIsland2 {
	
	    public int maxAreaOfIsland(int[][] grid) {
	        boolean[][] seen = new boolean[grid.length][grid[0].length];
	        int[] dr = new int[]{1, -1, 0, 0};
	        int[] dc = new int[]{0, 0, 1, -1};

	        int result = 0;
	        for (int r0 = 0; r0 < grid.length; r0++) {
	            for (int c0 = 0; c0 < grid[0].length; c0++) {
	                if (grid[r0][c0] == 1 && !seen[r0][c0]) {
	                    int shape = 0;
	                    Stack<int[]> stack = new Stack();
	                    stack.push(new int[]{r0, c0});
	                    seen[r0][c0] = true;
	                    while (!stack.empty()) {
	                        int[] node = stack.pop();
	                        int r = node[0], c = node[1];
	                        shape++;
	                        for (int k = 0; k < 4; k++) {
	                            int nr = r + dr[k];
	                            int nc = c + dc[k];
	                            if (0 <= nr && nr < grid.length &&
	                                    0 <= nc && nc < grid[0].length &&
	                                    grid[nr][nc] == 1 && !seen[nr][nc]) {
	                                stack.push(new int[]{nr, nc});
	                                seen[nr][nc] = true;
	                            }
	                        }
	                    }
	                    result = Math.max(result, shape);
	                }
	            }
	        }
	        return result;
	    }
	
}
/*dfs_solution.cpp
 * 
 * We want to know the area of each connected shape in the grid, then take the maximum of these.
 
We can try the same approach using a stack based, (or "iterative") depth-first search.

Here, seen will represent squares that have either been visited or are added to our list of
 squares to visit (stack). For every starting land square that hasn't been visited,
  we will explore 4-directionally around it, adding land squares that haven't been added to seen to our stack.

On the side, we'll keep a count shape of the total number of squares seen 
during the exploration of this shape. We'll want the running max of these counts.
*/