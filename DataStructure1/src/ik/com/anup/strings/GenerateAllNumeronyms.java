package ik.com.anup.strings;

import java.util.ArrayList;

/*Given a word, generate all possible numeronyms for it.

What is a numeronym?

A numeronym is a word where a number is used to form an abbreviation.

A numeronym for a word is another word with two or more contiguous letters replaced with their number. Exactly one set of contiguous letters is replaced by a number. First or last letter in the initial word are never omitted/replaced when forming a numeronym for it.

Example
{
"word": "nailed"
}
Output:

["n4d", "na3d", "n3ed", "n2led", "na2ed", "nai2d"]
"n4d" is an abbreviation of "nailed" where substring "aile" is replaced by the number of letters in it, 4.

"na3d" is an abbreviation of "nailed" where substring "ile"is replaced by number of letters in it, 3.

And so on.

Notes
Order of strings in the output is not important.
If no numeronyms can be generated for the word, return an empty list.
Constraints:

Possible characters in the word: [a-z] and [A-Z]
1 <= length of the word <= 120*/
public class GenerateAllNumeronyms {

    static ArrayList<String> generate_all_numeronyms(String word) {
        // Write your code here.
    	 ArrayList<String> result = new ArrayList<>();
         
         if(word.length()<2){
             return result;
         }
         
         for(int i=1;i<word.length()-1;i++){
             for(int j=2;j<word.length()-i;j++){
                 StringBuilder sb = new StringBuilder();
                 sb.append(word.substring(0,i));
                 sb.append(j);
                 sb.append(word.substring(i+j));
                 result.add(sb.toString());
             }
             
         }
         return result;
    }



}
