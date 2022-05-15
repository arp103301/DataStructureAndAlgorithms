package D.com.anup.trie;

public class InsertInTrie {
	
    private TrieNode root;
	
    public InsertInTrie() {
	root = new TrieNode(); // root is empty 
    }
	
    private class TrieNode {
	private TrieNode[] children;
	private boolean isWord;
		
	public TrieNode() {
	    this.children = new TrieNode[26]; // storing english words - a -> z    	    this.isWord = false;
	}
    }
	
    public void insert(String word) {
	if(word == null || word.isEmpty()) {
	    throw new IllegalArgumentException("Invalid input");
	}
		
	word = word.toLowerCase();
		
	TrieNode current = root;
	for(int i = 0; i < word.length(); i++) {
	    char c = word.charAt(i);
	    int index = c - 'a';///////////************////////////
	    if(current.children[index] == null) {
		TrieNode node = new TrieNode();
		current.children[index] = node;// add new Node
		current = node;
	    } else {
		current = current.children[index];// iterate to current from root
	    }
	}
	current.isWord = true;
		
    }
	
    public boolean search(String word) {
	return false;
    }
 
    public static void main(String[] args) {
	InsertInTrie trie = new InsertInTrie();
	trie.insert("cat");
	trie.insert("cab");
	trie.insert("son");
	trie.insert("so");
	System.out.println("Values inserted successfully !!!");
    }
}