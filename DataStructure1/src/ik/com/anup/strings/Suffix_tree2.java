//package ik.com.anup.strings;
//
//import java.util.LinkedList; 
//import java.util.List;
//
//import ik.com.anup.strings.Trie.TrieNode;
//
//
//
//public class Suffix_tree2{
//	
//
//class SuffixTrieNode { 
//	final static int MAX_CHAR = 256; 
//	  
//    SuffixTrieNode[] children;// = new SuffixTrieNode[MAX_CHAR]; 
//    List<Integer> indexes; ;
//
//	public SuffixTrieNode() {
//		  indexes = new LinkedList<Integer>(); 
//		  children = new SuffixTrieNode[MAX_CHAR]; 
//	        // Initialize all child pointers as NULL 
//	        for (int i = 0; i < MAX_CHAR; i++) 
//	            children[i] = null; 
//		
//	}
//
//
//}
//
//
//SuffixTrieNode root = new SuffixTrieNode(); 
//
//	public Suffix_tree2() {
//	 root = new SuffixTrieNode(); // root is empty 
//    }
//	
//public void insert(String word) {
//	 // Consider all suffixes of given string and 
//    // insert them into the Suffix Trie using  
//    // recursive function insertSuffix() in  
//    // SuffixTrieNode class 
//    for (int i = 0; i < word.length(); i++) 
//        root.insertSuffix(word.substring(i), i);
//}
//
//	//A recursive function to insert a suffix of  
//	// the text in subtree rooted with this node 
//	public void insertSuffix(String s, int index) { 
//	// TODO Auto-generated method stub
//        // Store index in linked list 
//        indexes.add(index); 
//  
//        // If string has more characters 
//        if (s.length() > 0) { 
//          
//            // Find the first character 
//            char cIndex = s.charAt(0); 
//  
//            // If there is no edge for this character, 
//            // add a new edge 
//            if (children[cIndex] == null) 
//                children[cIndex] = new SuffixTrieNode(); 
//  
//            // Recur for next suffix 
//            children[cIndex].insertSuffix(s.substring(1), 
//                                              index + 1); 
//        } 
//	
//}
//
//
//}