package ik.com.anup.graphs;
//wordladder

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*You are given a dictionary called words and two string arguments called start and stop. All given strings have equal length.

Transform string start to string stop one character per step using words from the dictionary. For example, "abc" → "abd" is a valid transformation step because only one character is changed ("c" → "d"), but "abc" → "axy" is not a valid one because two characters are changed ("b" → "x" and "c" → "y").

You need to find the shortest possible sequence of strings (two or more) such that:

First string is start.
Last string is stop.
Every string (except the first one) differs from the previous one by exactly one character.
Every string (except, possibly, first and last ones) are in the dictionary of words.
Example One
{
"words": ["cat", "hat", "bad", "had"],
"start": "bat",
"stop": "had"
}
Output:

["bat", "bad", "had"]
OR

["bat", "hat", "had"]
In "bat", change "t" → "d" to get "bad".
In "bad", change "b" → "h"to get "had".

OR

In "bat", change "b" → "h" to get "hat".
In "hat", change "t" → "d" to get "had".

Example Two
{
"words": [],
"start": bbb,
"stop": bbc
}
Output:

["bbb", "bbc"]
In "bbb", the last character to "b" and get "bbc".

Example Three
{
"words": [],
"start": "zzzzzz",
"stop": "zzzzzz"
}
Output:

["-1"]
No sequence of strings exists that would satisfy all requirements. For example, ["zzzzzz", "zzzzzz"] does not satisfy requirement #3. In such situations, ["-1"] is the correct answer.

Notes
If two or more such sequences exist, return any.
If no such sequence is there to be found, ["-1"] (a sequence of one string, "-1") is the correct answer.
Constraints:

All input strings consist of lowercase English letters
0 <= total number of characters in all dictionary words combined <= 105
Strings in words are not in any particular order
There may be duplicates in words*/
public class ShortestStringTransformationUsingADictionary {

    static ArrayList<String> string_transformation(ArrayList<String> words, String start, String stop) {
        // Write your code here.
        Set<String> dnry = new HashSet<>(words);
        if(start.equals(stop) && dnry.contains(start)){
            return new ArrayList<>(Arrays.asList("-1"));
        }
        dnry.remove(start);
        dnry.remove(stop);
        return bfs(start, stop, dnry);
    }
    
    static ArrayList<String> bfs(String start, String stop, Set<String> dnry){
        Map<String, String> parents = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(start);
        queue.add(start);
        
        while(!queue.isEmpty()){
         String current = queue.poll();
         Set<String> nbrs = new HashSet<>();
         if(26 * current.length() < dnry.size()){
            nbrs = getNeighbor(dnry, current, stop);
         }
         else 
          {
           nbrs = getNeighborDnry(dnry, current, stop);    
          }
          for(String ng : nbrs){
              if(ng.equals(stop)){
                  return fromParents(parents, current, stop);
              }
              if(!visited.contains(ng)){
                  visited.add(ng);
                  parents.put(ng, current);
                  queue.add(ng);
              } 
              
          }
        }
        return new ArrayList<String>(Arrays.asList("-1"));
    }
    
   static Set<String> getNeighbor(Set<String> dnry, String current, String stop){
       Set<String> neighbors = new HashSet<>();
       for(int i = 0; i< current.length(); i++){
           char[] candidate = current.toCharArray();
           char orig = candidate[i];
           for(char ch = 'a' ; ch < 'z'; ch++){
               if(ch != orig){
                   candidate[i] = ch;
                  String candStr = String.valueOf(candidate);
                  if(dnry.contains(candStr) || candStr.equals(stop)){
                      neighbors.add(candStr);
                  }
               }
           }
           
           
           
       }
       
       return neighbors;
   }
    
    static Set<String> getNeighborDnry(Set<String> drny, String current, String stop){
     Set<String> n = new HashSet<>();
     if(wordDifferbyOneChar(current, stop)){
         n.add(stop);
     }
        
     for(String w : drny){
         if(wordDifferbyOneChar(current, w)){
         n.add(w);
       }  
     }
     return n;
    } 
    
    static boolean wordDifferbyOneChar(String word1,String word2){
        int diff =0;
        int i =0;
        while(i < word1.length() && i < word2.length()){
            if(word1.charAt(i) != word2.charAt(i)){
               diff++; 
            }
            if(diff > 1){
                return false;
            }
            i++;
        }
        return diff==1;
    }
    
    static ArrayList<String> fromParents(Map<String, String> parents, String n, String stop){
     ArrayList<String> res = new ArrayList<>();
        String path = n;
        res.add(stop);
        while(path != null){
            res.add(path);
            path = parents.get(path);
        }
        Collections.reverse(res);
        return res;
    }
    

}
