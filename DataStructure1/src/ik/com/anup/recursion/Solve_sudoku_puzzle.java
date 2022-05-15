package ik.com.anup.recursion;

//move in row loop while setting cloumn value

import java.util.ArrayList;

/*Given a partially filled two-dimensional array, fill all the unfilled cells 
such that each row, each column and each 3 x 3 subgrid (as highlighted below by bolder lines) 
has every digit from 1 to 9 exactly once.

Unfilled cells have a value of 0 on the given board.
You can assume that any given puzzle will have exactly one solution.

Constraints:

Size of the input array is exactly 9 x 9
0 <= value in the input array <= 9
*/

public class Solve_sudoku_puzzle {

	

 
    /*
    * Asymptotic complexity in terms of number of unfilled cells `k`
                        and number of rows(or columns) in `board` `n`.
    * Time: O(9^k).
    * Auxiliary space: O(k).
    * Total space: O(n^2).
    */
    static ArrayList<ArrayList<Integer>> solve_sudoku_puzzle(ArrayList<ArrayList<Integer>> board) {
        recursive_backtracking(board);
        return board;
    }

    static boolean recursive_backtracking(ArrayList<ArrayList<Integer>> board) {
        // Look for the next unfilled cell.
        int row = 0;
        int col = 0;
        boolean foundUnfilledCell = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.get(i).get(j) == 0) {
                    // Found unfilled cell.
                    row = i;
                    col = j;
                    foundUnfilledCell = true;
                    break;
                }
            }
            if (foundUnfilledCell) {
                break;
            }
        }

        if (!foundUnfilledCell) {
            // No unfilled cells left. That means a solution is found.
            return true;
        }

        // Look for a number (1..9) that "is safe", i.e. can feasibly be placed in this unfilled cell.
        for (int digit = 1; digit <= 9; digit++) {
            if (isValid(board, row, col, digit)) {
                // Found a safe number, put it to the board.
                board.get(row).set(col, digit);

                // Recurse to find and fill next unfilled cell.
                if (recursive_backtracking(board)) {
                    return true;
                } else {
                    // Placing number num to this unfilled cell does not lead to a solution.
                    // So we undo placing it to the board:
                    board.get(row).set(col, 0);//unfill == backtrack
                    // ... and continue with the `for` loop.
                    // That will lead to trying other numbers: backtracking. if no backtracking it does not work
                }
            }
        }

        // Starting from the state of the board passed to this call, no solution is possible.
        // This cannot be the initial call (root call in the recursion hierarchy of calls) because
        // problem statement guarantees that a solution exists for every test board.
        // So returning false will lead to backtracking.
        return false;
    }

    /**
     * Checks if number num is safe to place on board[row, col].
     */
    static boolean isValid(ArrayList<ArrayList<Integer>> board, int row, int col, int digit) {
        // Check if the number is already present in the row.
        // We could use hashtable (HashSet in Java) to get rid of the following cycle,
        // but with N=9 it's going to make things slower on many real CPUs. That's worth
        // considering for larger Sudoku boards though.
        for (int i = 0; i < 9; i++) {
            if (board.get(row).get(i) == digit) {
                return false;
            }
        }

        // Check if the number is already present in the column.
        for (int i = 0; i < 9; i++) {
            if (board.get(i).get(col) == digit) {
                return false;
            }
        }

        // Check if the number is already present in the corresponding 3 x 3 box.
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;

        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (board.get(i).get(j) == digit) {
                    return false;
                }
            }
        }

        return true;//if all three above cases do not violate this means the digit is valid 
    }
	
}


/*
 * Time Complexity O(9k), where k is the number of unfilled cells.
 * 
 * If there is only one unfilled cell, we need to try 9 digits for the position
 * in the worst case. With two unfilled cells, we’d try up to 9 possibilities
 * for the first position and up to 9 for the second position for every number
 * for the first position. And so on.
 * 
 * The backtracking algorithm indeed avoids explicitly trying many of the
 * impossible board positions by checking validity early, but the upper bound
 * remains O(9^k).
 * 
 * Auxiliary Space Used O(k), where k is the number of unfilled cells.
 * 
 * Every level of recursion fills one cell.
 * 
 * Space Complexity O(n^2), where n * n is the board size.
 * 
 * We can also say that it is O(1) since n = 9 always.
 */