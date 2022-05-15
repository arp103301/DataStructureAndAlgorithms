package ik.com.anup.recursion;

//https://www.techiedelight.com/print-possible-solutions-n-queens-problem/


import java.util.ArrayList;

/*Given an integer n, find all possible ways to position n queens on an n×n chessboard so that no two queens attack each other. A queen in chess can move horizontally, vertically, or diagonally.

Do solve the problem using recursion first even if you see some non-recursive approaches.

Example One
{
"n": 4
}
Output:

[
["--q-",
 "q---",
 "---q",
 "-q--"],

["-q--",
 "---q",
 "q---",
 "--q-"]
]
There are two distinct ways four queens can be positioned on a 4×4 chessboard without attacking each other. The positions may appear in the output in any order. So the same two positions in different order would be another correct output.

Example Two
{
"n": 2
}
Output:

[
]
No way to position two queens on a 2×2 chessboard without them attacking each other - so empty array.

Notes
The function must return a two-dimensional array of strings representing the arrangements. Size of the array must be m×n where m is the number of distinct arrangements.

Each string must be n characters long, and the strings' characters may be either q (for a queen) or - (for an empty position on the chessboard). Valid arrangements may appear in the output in any order.

Constraints:

1 <= n <= 12*/

import java.util.Arrays;
public class N_queen_problem {
   

	 
	    private static void nQueenHelper(char[][] board, int n)
	    {
	        // if `N` queens are placed successfully, print the solution
	        if (n == board.length)// 2d matrix legnth is row ::: once all rows are filled we are done
	        {
	            printSolution(board);
	            return;
	        }
	 
	        // place queen at every square in the current row `r`
	        // and recur for each valid movement
	        for (int i = 0; i < board.length; i++)
	        {
	            // if no two queens threaten each other
	            if (isValid(board, n, i))
	            {
	                // place queen on the current square
	                board[n][i] = 'Q';
	 
	                // recur for the next row
	                nQueenHelper(board, n + 1);
	 
	                // backtrack and remove the queen from the current square since no solution is found for this cell
	                board[n][i] = '–';
	            }
	        }
	    }
	    // Function to check if two queens threaten each other or not
	    private static boolean isValid(char[][] board, int row, int col)
	    {
	        // return false if two queens share the same column
	        for (int i = 0; i < row; i++)
	        {
	            if (board[i][col] == 'Q') {
	                return false;
	            }
	        }
	 
	        // return false if two queens share the same `\` diagonal
	        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
	        {
	            if (board[i][j] == 'Q') {
	                return false;
	            }
	        }
	 
	        // return false if two queens share the same `/` diagonal
	        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++)
	        {
	            if (board[i][j] == 'Q') {
	                return false;
	            }
	        }
	 
	        return true;
	    }
	 
	    
	    private static void printSolution(char[][] mat)
	    {
	        for (char[] chars: mat) {
	            System.out.println(Arrays.toString(chars).replaceAll(",", ""));
	        }
	        System.out.println();
	    }
	    
	    
	    public static void main(String[] args)
	    {
	    	
	    	ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>> ();
	        // `N × N` chessboard
	        int N = 9;
	 
	        // `mat[][]` keeps track of the position of queens in
	        // the current configuration
	        char[][] mat = new char[N][N];
	        
	        ArrayList<Character> arrList = new ArrayList<Character>();
	        // initialize `mat[][]` by `-`
	        for (int i = 0; i < N; i++) {
	            Arrays.fill(mat[i], '–');
	        }
	       
	 
	        nQueenHelper(mat, 0);
	    }
	}