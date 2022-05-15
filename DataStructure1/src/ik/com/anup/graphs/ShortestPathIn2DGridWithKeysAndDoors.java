package ik.com.anup.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;

/*Given a two-dimensional maze represented by a character grid, find the shortest path from start to goal cell. 
 * You can move vertically or horizontally—but not diagonally—one step at a time.

There are six types of cells:

'@' for start
'+' for goal
'.' for land
'#' for water
uppercase letter for door
lowercase letter for key
There's exactly one start and one goal cell. Other cells may appear any number of times. Water can never be visited.
 A door cell can only be visited after visiting a matching key, e.g. key 'a' for door 'A'. Other cells can be visited 
 unconditionally. It is allowed to visit a cell more than once.

Example
{
"grid": [
"...B",
".b#.",
"@#+."
]
}
Output:

[
[2, 0],
[1, 0],
[1, 1],
[0, 1],
[0, 2],
[0, 3],
[1, 3],
[2, 3],
[2, 2]
]
We start at [2, 0] where the start (@) is located, then we go up to [1, 0] where the adjacent piece of land (.) is, and so on. We visit the following cells on the way:
@ → . → b → . → . → B → . → . → +

To get to the goal we have to walk through door 'B', and for that we have to pass by the matching key 'b' first. We do all of that in the smallest number of steps possible.

Notes
Input is a list of strings. First character of the first string is cell [0, 0] of the maze, the top-left corner. The second character of that string is cell [0, 1] of the maze.
Output is a two-dimensional array of integers with the coordinates of the cells on the shortest path from the start cell to the goal.
The first cell in the output must be the start cell and the last must be the goal cell.
If there are multiple shortest paths, return any one.
We guarantee there will be a path from start to goal.
Constraints:

1 <= width of the maze <= 100
1 <= height of the maze <= 100
'a' <= key <= 'j'
'A' <= door <= 'J'
Multiple keys and doors of one type are possible*/
public class ShortestPathIn2DGridWithKeysAndDoors {

    static class Node {
        int x;
        int y;
        int keys;
        Node prev;
        public Node(int x, int y, Node prev) {
            this.x = x;
            this.y = y;
            this.prev = prev;
        }
    }
    
    
    private static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    
    
    static ArrayList<ArrayList<Integer>> find_shortest_path(ArrayList<String> grid) {
        char[][] matrix = getMatrix(grid);
        int m = matrix.length;
        int n = matrix[0].length;
        int x = -1;
        int y = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '@') {//@ is the goal is now found
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        ArrayList<ArrayList<Integer>> result = helper(matrix, x, y);
        return result;
    }
    private static ArrayList<ArrayList<Integer>> helper(char[][] matrix, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][][] visited = new boolean[m][n][1 << 10];
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(row, col, null));
        visited[row][col][0] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int[] dir : DIRS) {
                int x = cur.x + dir[0];
                int y = cur.y + dir[1];
                Node next = new Node(x, y, cur);
                if (!isValid(matrix, x, y, cur, next)) {
                    continue;
                }
                if (matrix[x][y] == '+') {
                    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
                    result.add(new ArrayList<Integer>(Arrays.asList(x, y)));
                    while (cur != null) {
                        result.add(new ArrayList<Integer>(Arrays.asList(cur.x, cur.y)));
                        cur = cur.prev;
                    }
                    Collections.reverse(result);
                    return result;
                }
                if (!visited[x][y][next.keys]) {
                    queue.offer(next);
                    visited[x][y][next.keys] = true;
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>();
    }
    
    
    
    private static boolean isValid(char[][] matrix, int x, int y, Node cur, Node next) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] == '#') {
            return false;
        }
        if (matrix[x][y] >= 'A' && matrix[x][y] <= 'J') {
            if ((cur.keys >> (matrix[x][y] - 'A') & 1) == 0) {
                return false;
            }
        }
        next.keys = cur.keys;
        if (matrix[x][y] >= 'a' && matrix[x][y] <= 'j') {
            int nextKeys = (1 << (matrix[x][y] - 'a'));
            next.keys |= nextKeys;
        }
        return true;
    }
    
    
    
    private static char[][] getMatrix(ArrayList<String> grid) {
        int m = grid.size();
        int n = grid.get(0).length();
        char[][] matrix = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = grid.get(i).charAt(j);
            }
        }
        return matrix;
    }

}
