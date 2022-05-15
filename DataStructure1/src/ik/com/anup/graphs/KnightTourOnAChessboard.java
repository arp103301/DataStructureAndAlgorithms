package ik.com.anup.graphs;

import java.util.LinkedList;
import java.util.Queue;

/*You are given a chessboard with rows rows and cols columns and a knight - that moves like in normal chess - located at the start_row-th row and start_col-th column. The knight needs to reach the position at the end_row-th row and end_col-th column.

Find minimum number of moves that knight needs to make to get from starting position to ending position.

start_row, start_col, end_row and end_col are all zero-indexed.

Example
{
"rows": 5,
"cols": 5,
"start_row": 0,
"start_col": 0,
"end_row": 4,
"end_col": 1
}
Output:

3
3 moves to reach from (0, 0) to (4, 1):
(0, 0) → (1, 2) → (3, 3) → (4, 1).

Notes
If it is not possible to reach from starting position to ending position, then return -1.
Constraints:

1 <= rows * cols <= 105
0 <= start_row, end_row < rows
0 <= start_col, end_col < cols*/
public class KnightTourOnAChessboard {

	static Integer find_minimum_number_of_moves(Integer rows, Integer cols, 
		    Integer start_row, Integer start_col, Integer end_row, Integer end_col) {
		
		
		       int minMoves = 0;// required to find this 
		        boolean[][] visited = new boolean[rows][cols]; // initialize as false
		        int maxPossibleMoves = 8;//max possible moves =8
		        int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };//>>>(2,-1) two steps right  and 1 step down from current step
		        int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };
		       
		        Queue<Coordinates> queue = new LinkedList<>();
		        queue.add(new Coordinates(start_row, start_col));
		        visited[start_row][start_col] = true;

		        while (!queue.isEmpty()) {
		            int size = queue.size();
		            
		            //find the elements in the queue
		            for (int i = 0; i < size; i++) {
		                Coordinates currCoord = queue.poll();
		                int row = currCoord.row;//current.getRow
		                int col = currCoord.col;
		                
		                if (row == end_row && col == end_col) { //once reached to desired cell
		                    return minMoves;
		                }
		                for (int j=0 ; j<maxPossibleMoves; j++) {
		                    int newRow = row + xMoves[j];
		                    int newCol = col + yMoves[j];

		                    if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || visited[newRow][newCol]) {//valid moves
		                        continue;//next i occurs... skips this ith and next iteration continues
		                    }
		                    queue.add(new Coordinates(newRow, newCol));
		                    visited[newRow][newCol] = true;
		                }
		            }
		            minMoves++;// inside while but outside BFS
		        }

		        return -1;
		    }

		    static class Coordinates{
		        int row;
		        int col;
		        public Coordinates(int row, int col){
		            this.row = row;
		            this.col=col;
		            
		        }
		    }
}
