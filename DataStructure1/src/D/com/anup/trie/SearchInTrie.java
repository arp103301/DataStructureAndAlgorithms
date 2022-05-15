package D.com.anup.trie;

/*
 * https://stackoverflow.com/questions/39519288/which-is-a-better-implementation-to-implement-a-trie-nodes-children-array-or
NOTE: Memory required by unordered_map is 5 times, and map is 6 (to 8) times - more than the memory required by array
*/
public class SearchInTrie {
	 private TrieNode root;
		
	    public SearchInTrie() {
		root = new TrieNode(); // root is empty 
	    }
		
	    private class TrieNode {
		private TrieNode[] children;
		private boolean isEndOfWord;
			
		public TrieNode() {
		    this.children = new TrieNode[26]; // storing english words - a -> z    	    
		    this.isEndOfWord = false;
		}
	    }
		
	    
	    
	    public void insert(String word) {
		if(word == null || word.isEmpty()) {
		    throw new IllegalArgumentException("Invalid input");
		}
			
		word = word.toLowerCase();
			
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			/*
			 * Assuming key contains only lower case English letters, key.charAt(i) = 'a'
			 * maps each lower case letter to an index between 0 (for 'a') and 25 (for 'z').
			 */
			/*
			 * Substracting in java character is always done usingASCII so it is valid
			 */
			int index = c - 'a';
			if (current.children[index] == null) {
				TrieNode node = new TrieNode();
				current.children[index] = node;
				current = node;
			} else {//find the existing node
				current = current.children[index];
			}
		}//after the node is created ,mark this as endofword for this node
		current.isEndOfWord = true;
			
	    }
		
		/*
		 * public boolean search(String word) { return false; }
		 */
	 
	 // Returns true if key presents in trie, else false 
	    public boolean search(String key) 
	    { 
	        int level; 
	        int length = key.length(); 
	        int index; 
	       TrieNode current = root; 
	       
	        for (level = 0; level < length; level++) { 
	            index = key.charAt(level) - 'a'; ////////***********//////////
	       
	            if (current.children[index] == null) 
	                return false; 
	       
	            current = current.children[index]; //iterate
	        } 
	       
	        return (current != null && current.isEndOfWord); 
	    } 
	    
		/*
		 * public boolean startsWith (String prefix) { return getNode(Prefix)!=null; }
		 */
	    
	    
	    public static void main(String[] args) {
		InsertInTrie trie = new InsertInTrie();
		trie.insert("cat");
		trie.insert("cab");
		trie.insert("son");
		trie.insert("so");
		System.out.println("Values inserted successfully !!!");
		 String searchKey ="tina";
		 boolean found = trie.search(searchKey);
		 System.out.println("search is "+found);
		 
	    }
}
