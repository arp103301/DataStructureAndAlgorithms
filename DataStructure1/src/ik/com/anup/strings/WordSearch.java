package ik.com.anup.strings;


//Hint:: . for_loopRow; for_loopCol, if matrix[i][j] matches word[0] then vistedArr and call DFS with (i,j,0(currIndex))
//DFS:: base cases ; visited[i]j]=true ; call dfs for 4 directions and OR it to get result.

//https://github.com/Sunchit/Coding-Decoded/blob/master/October2021/WordSearch.java
	
	
public class WordSearch {
	class Solution {


	    public boolean exist(char[][] board, String word) {
	        char[] cWord = word.toCharArray();
	        for(int i=0;i<board.length;i++){
	            for(int j=0;j<board[0].length;j++){
	                if(cWord[0] == board[i][j]){// First matching char
	                    // start the DFS/BFS loop to check if there exists a word
	                    boolean[][] visited  = new boolean[board.length][board[0].length];
	                    if(dfs(board, cWord, i, j, visited, 0)){
	                        return true;
	                    }
	                }
	            }
	        }
	        return false;
	    }

	    private boolean dfs(char[][] board, char[] word, int i, int j, boolean[][] visited, int index){
	        if(index==word.length){
	            return true;
	        }
	        if(i<0|| j<0|| i>=board.length || j>=board[0].length  || visited[i][j] == true){
	            return false;
	        }

	        if(  board[i][j] != word[index]){
	            return false;
	        }
	        visited[i][j] = true;
	        // check top , bottom , left, right directions and OR it 
	        if(dfs(board, word, i-1, j, visited, index+1) || dfs(board, word, i+1, j, visited, index+1) || dfs(board, word, i, j-1, visited, index+1) || dfs(board, word, i, j+1, visited, index+1) ){
	            return true;
	        }

	        visited[i][j] = false;
	        return false;

	    }
	}
}

/**
[["A","B","C","E"],
 ["S","F","E","S"],
 ["A","D","E","E"]]
"ABCESEEEFS"
**/

