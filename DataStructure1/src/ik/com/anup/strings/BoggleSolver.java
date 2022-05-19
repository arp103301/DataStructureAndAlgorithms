package ik.com.anup.strings;
// this is word search2 >>https://www.youtube.com/watch?v=DDk_ljoWd28&t=11s
//https://github.com/Sunchit/Coding-Decoded/blob/master/October2021/WordSearchII.java

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*You are given a dictionary set dictionary that contains dictionaryCount distinct words and a matrix mat of size n * m.
Your task is to find all possible words that can be formed by a sequence of adjacent characters in the matrix mat.
Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of the same cell of the matrix.

Example
{
"dictionary": ["bst", "heap", "tree"],
"mat": ["bsh", "tee", "arh"]
}
Output:

["bst", "tree"]
The input matrix is represented below:

bsh
tee
arh

Assume here top left-most corner is at (0,0) and bottom right-most corner is (2,2).
Presence of "bst" is marked bold in the below representation:
(0,0) -> (0,1) -> (1,0)

bsh
tee
arh

Presence of "tree" is marked bold in the below representation:
(1,0) -> (2,1) -> (1,1) -> (1,2)

bsh
tee
arh

Notes
Same dictionary word can be found in the matrix multiple times. We only need to check the
 existence of the dictionary word in the matrix. Hence, for multiple existences for the same 
 word only add it once in the list of all found words.
Constraints:

1 <= dictionaryCount <= 1000
1 <= n * m <= 100000
1 <= length of words in dictionary <= 100
All the characters in mat and in the dictionary words are lower case English letters*/
class BoggleSolver {
	private class TrieNode {
		private TrieNode[] children;
		private String word;

		TrieNode() {
			children = new TrieNode[26];
		}
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		TrieNode root = buildTrie(words);
		int m = board.length, n = board[0].length;

		// System.out.println(" Value is " + root.children['o' -'c']);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, i, j, root, res);
			}
		}
		return res;
	}

	public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
		char c = board[i][j];
		if (c == ';' || p.children[c - 'a'] == null)
			return;
		p = p.children[c - 'a'];
		if (p.word != null) { // found one
			res.add(p.word);
			p.word = null; // de-duplicate
		}

		board[i][j] = ';';
		if (i > 0)
			dfs(board, i - 1, j, p, res);
		if (j > 0)
			dfs(board, i, j - 1, p, res);
		if (i < board.length - 1)
			dfs(board, i + 1, j, p, res);
		if (j < board[0].length - 1)
			dfs(board, i, j + 1, p, res);
		board[i][j] = c;
	}

	public TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String w : words) {
			TrieNode curr = root;
			for (char c : w.toCharArray()) {
				int index = c - 'a';
				if (curr.children[index] == null)
					curr.children[index] = new TrieNode();
				curr = curr.children[index];
			}
			curr.word = w;
		}
		return root;
	}
}

	/*
	 * static int[][] dirs={{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,-1},{-1,1}};
	 * static TrieNode root; public static ArrayList<String>
	 * boggle_solver(ArrayList<String> dictionary, ArrayList<String> mat) {
	 * 
	 * ArrayList<String> resList = new ArrayList<>(); root = buildTrie(dictionary);
	 * 
	 * int m = mat.size(); int n = mat.get(0).length(); char[][] board = new
	 * char[m][n]; for (int i=0; i < m; i++){ for (int j=0; j < n; j++){ board[i][j]
	 * = mat.get(i).charAt(j); } }
	 * 
	 * for(int i=0; i< m; i++){ for(int j=0; j< n; j++){ dfs (board, i, j, root,
	 * resList,dictionary);
	 * 
	 * } } return resList; }
	 * 
	 * public static void dfs(char[][] board, int i, int j, TrieNode p,
	 * ArrayList<String> res,ArrayList<String> dict) { char c = board[i][j]; if (c
	 * == '#' || !p.next.containsKey(c)) return; p = p.next.get(c); if (p.word !=
	 * null) { res.add(p.word); String remIndex = p.word; p.word=null;
	 * remove(root,remIndex,0); }
	 * 
	 * board[i][j] = '#'; for(int[] dir:dirs){ int x=i+dir[0]; int y=j+dir[1];
	 * if(x<0 || x>=board.length || y<0 || y>=board[0].length){ continue; }
	 * dfs(board, x, y, p, res,dict); } board[i][j] = c; }
	 * 
	 * public static TrieNode buildTrie(ArrayList<String> words) { TrieNode root =
	 * new TrieNode(); for (int k = 0;k<words.size();k++) { String w = words.get(k);
	 * TrieNode p = root; for (char c : w.toCharArray()) { if
	 * (!p.next.containsKey(c)) { p.next.put(c,new TrieNode()); } p = p.next.get(c);
	 * } p.word = w; } return root; }
	 * 
	 * static boolean remove(TrieNode p,String str, int i){ if(i== str.length()){
	 * if(p.next.size() ==0){ return true; }else{ p.word= null; return false; } }
	 * Character ch = str.charAt(i); if(remove(p.next.get(ch), str, i+1)){
	 * p.next.remove(ch); return p.next.size() ==0; }else{ return false; } }
	 * 
	 * static class TrieNode { Map<Character,TrieNode> next = new HashMap<>();
	 * String word = null; }
	 */


