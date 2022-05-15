package ik.com.anup.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*Given a list of strings words, of size n, check if there is any pair of words that can be joined (in any order) to form a palindrome then return the pair of words forming palindrome.
We will refer to the size of list words as n and maximum length of words in words as l.
Example One
{
"words": ["bat", "tab", "zebra"]
}
Output:

["bat", "tab"]
As "bat" + "tab" = "battab", which is a palindrome.

Example Two
{
"words": ["ant", "dog", "monkey"]
}
Output:

["NOTFOUND", "DNUOFTON"]
As for each 6 combinations of string of words, there is no single generated word which is a palindrome hence result list will be ["NOTFOUND", "DNUOFTON"].

Notes
If there are multiple correct answers, return any one.
In case of no answer return list ["NOTFOUND", "DNUOFTON"].
Constraints:

1 <= length of a word <= 30
2 <= n <= 20000
Words consist of characters ['a'-'z'], ['A'-'Z'], ['0'-'9']*/
public class JoinWordsToMakeAPalindrome {
	static ArrayList<String> join_words_to_make_a_palindrome(ArrayList<String> words) {
        // Write your code here.
   Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < words.size(); i++){
            map.put(words.get(i), i);
        }
        
        ArrayList<String> output = new ArrayList<String>();
        
        for(int i = 0; i < words.size(); i++){
            String word = words.get(i);
            String reverse = new StringBuilder(word).reverse().toString();
            for(int j = word.length(); j > 0; j--){
                String prefix = reverse.substring(0, j);
                String suffix = reverse.substring(j);
                if(map.containsKey(prefix) && map.get(prefix) != i){
                    StringBuilder builder = new StringBuilder();
                    builder.append(prefix);
                    builder.append(word);
                    if(checkPalindrome(builder.toString())){
                        output.add(word);
                        output.add(prefix);
                        break;
                    }
                }
                else if(map.containsKey(suffix) && map.get(suffix) != i){
                    StringBuilder builder = new StringBuilder();
                    builder.append(word);
                    builder.append(suffix);
                    if(checkPalindrome(builder.toString())){
                        output.add(word);
                        output.add(suffix);
                        break;
                    }
                }
            }
            if(output.size() != 0){
                break;
            }
        }
        
        if (output.size() == 0){
            output.add("NOTFOUND");
            output.add("DNUOFTON");
        }
        return output;
    }
    
    private static Boolean checkPalindrome(String pattern){
        for(int i = 0, j = pattern.length()-1; i <= j; i++, j--){
            if(pattern.charAt(i) != pattern.charAt(j)){
                return false;
            }
        }
        return true;
    }

}
