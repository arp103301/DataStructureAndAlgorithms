package ik.com.anup.graphs;

import java.util.ArrayList;

public class CountIslands_DFS {
	

    static Integer count_islands(ArrayList<ArrayList<Integer>> matrix) {
	   if (matrix.size() == 0 || matrix == null) {
           return 0;
       }

       int numRow = matrix.size();
       int numCol = matrix.get(0).size();
       int numberOfIslands = 0;

       for (int r=0; r < numRow; ++r) {
           for (int c=0; c<numCol; ++c) {
               if (matrix.get(r).get(c) == 1) {
                   ++numberOfIslands;
                   helper(matrix, r, c);
               }
           }
       }

       return numberOfIslands;
   }
   
   static void helper(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
       
	   matrix.get(row).set(col, 0);
	   
	   
       // left
       if (row - 1 >= 0 && matrix.get(row - 1).get(col) == 1) {
           helper(matrix, row - 1, col);
       }
       // right
       if (row + 1 < matrix.size() && matrix.get(row + 1).get(col) == 1) {
           helper(matrix, row + 1, col);
       }
       // up
       if (col - 1 >= 0 && matrix.get(row).get(col - 1) == 1) {
           helper(matrix, row, col - 1);
       }
       // down
       if (col + 1 < matrix.get(0).size() &&matrix.get(row).get(col + 1) == 1) {
           helper(matrix, row, col + 1);
       }
       // left up
       if (row - 1 >= 0 && col - 1 >= 0 && matrix.get(row - 1).get(col - 1) == 1) {
           helper(matrix, row - 1, col - 1);
       }
       // right up
       if (row + 1 < matrix.size() && col - 1 >= 0 && matrix.get(row + 1).get(col - 1) == 1) {
           helper(matrix, row + 1, col - 1);
       }
       // left down
       if (row - 1 >= 0 && col + 1 < matrix.get(0).size() && matrix.get(row - 1).get(col + 1) == 1) {
           helper(matrix, row - 1, col + 1);
       }
       // right down
       if (row + 1 < matrix.size() && col + 1 < matrix.get(0).size() &&matrix.get(row + 1).get(col + 1) == 1) {
           helper(matrix, row + 1, col + 1);
       }
       
   }
}
