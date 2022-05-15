package ik.com.anup.recursion;

//https://www.techiedelight.com/print-possible-solutions-n-queens-problem/


//do the recursive call- iteration for each row >> as only 1 cell in each row is valid


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
public class N_queen_problem2 {
   


    static ArrayList<ArrayList<String>> find_all_arrangements(Integer n) {
        // Write your code here.
        char[][] slate = new char[n][n];
        ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>();////////////////error
       
        //fill with empty dashes
        for(char[] data : slate) {
            Arrays.fill(data,'-');
            
        }
        helper(slate, resultList, 0, n);
        return resultList;
    }
    
    static void helper(char[][] slate, ArrayList<ArrayList<String>> list, int row, int n) {
        if(row == n) {
            ArrayList<String> data = new ArrayList<String>();
            for(char[] chararr:slate) {
                String str = String.valueOf(chararr);
                data.add(str);
            }
            list.add(data);
            return;
        }
        
        for(int col=0;col<n;col++) {//only checks for each column in single row( each row= one iteration of helper class)
        	 if (is_safe(slate, row, col, n))
             {
                 // Place a queen at (row, col).
        		 slate[row][col] = 'Q';
                 // Try to place any more queens (from the next row down).
                 
        		 helper(slate, list,row + 1,n);
                 // We have explored all the solutions with current value of "candidate";
                 // now we need to reset it in order to try the next candidate:
                 
                 slate[row][col] = '-';//backtracking
             }
        }
    }
    
    
   static boolean is_safe(char[][] slate, int row, int col, int n)
    {
        // Check the "backslash" diagonal.
        int cur_row = row, cur_col = col;
        while (cur_row >= 0 && cur_col >= 0)
        {
            if (slate[cur_row--][cur_col--] == 'Q')
            {
                return false;
            }
        }
        // Check column.
        cur_row = row;
        while (cur_row >= 0)
        {
            if (slate[cur_row--][col] == 'Q')
            {
                return false;
            }
        }
        // Check the "slash" diagonal.
        cur_row = row; cur_col = col;
        while (cur_row >= 0 && cur_col < n)
        {
            if (slate[cur_row--][cur_col++] == 'Q')
            {
                return false;
            }
        }
        return true;
    }

	
 
	}//class