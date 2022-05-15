package ik.com.anup.strings;
/*
 * https://stackoverflow.com/questions/39519288/which-is-a-better-implementation-to-implement-a-trie-nodes-children-array-or
NOTE: Memory required by unordered_map is 5 times, and map is 6 (to 8) times - more than the memory required by array
*/
public class Trie {
	 
	private class TrieNode {
		private TrieNode[] children;
		private boolean isEndOfWord;

		public TrieNode() {
			this.children = new TrieNode[26]; // storing english words - a -> z
			this.isEndOfWord = false;
		}
	}
		
	    private static TrieNode root;
		
	    public Trie() {
		root = new TrieNode(); // root is empty 
	    }
		
	   
		
	    public void insert(String word) {
		if(word == null || word.isEmpty()) {
		    throw new IllegalArgumentException("Invalid input");
		}
			
		word = word.toLowerCase();
			
		TrieNode current = root;
		for(int i = 0; i < word.length(); i++) {
		    char c = word.charAt(i);
		    
			/*
			 * Assuming key contains only lower case English letters, key.charAt(i) = 'a'
			 * maps each lower case letter to an index between 0 (for 'a') and 25 (for 'z').
			 */
			/*
			 * Substracting in java character is always done usingASCII so it is valid
			 */
		    int index = c - 'a';
		    
		    if(current.children[index] == null) {
			TrieNode node = new TrieNode();
			current.children[index] = node;
			current = node;
		    } else {
			current = current.children[index];
		    }
		}
		current.isEndOfWord = true;
			
	    }
		
	 // Returns true if key presents in trie, else false 
	    static boolean search(String key) 
	    { 
	        int level; 
	        int length = key.length(); 
	        int index; 
	        TrieNode current = root; 
	       
	        for (level = 0; level < length; level++) 
	        { 
	            index = key.charAt(level) - 'a'; 
	       
	            if (current.children[index] == null) 
	                return false; 
	       
	            current = current.children[index]; 
	        } 
	       
	        return (current != null && current.isEndOfWord); 
	    } 
	    
	    
	    public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("cat");
		trie.insert("cab");
		trie.insert("son");
		trie.insert("so");
		System.out.println("Values inserted successfully !!!");
		boolean result = trie.search("son");
		System.out.println("Values found "+result);
	    }
	
}
