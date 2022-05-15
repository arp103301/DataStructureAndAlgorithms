package ik.com.anup.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*Given some text and a bunch of words, find where each of the words appear in the text.

Function must return a list of lists of integers. One list for each one of the words. i-th list must contain all indices of characters in text where i-th word starts, in the ascending order. If i-th word isn’t found in the text at all, then i-th list must be [-1].

Example
{
"text": "you are very very smart",
"words": ["you", "are", "very", "handsome"]
}
Output:

[ [0], [4], [8, 13], [-1] ]

"you" is found in the given text starting at the index 0.
"are" is found in the given text starting at the index 4.
"very" is found in the given text two times, starting at the indices 8 and 13.
"handsome" isn’t found in the given text.

Notes
Constraints:

text and words may contain a-z, A-Z, 0-9, "$", "#", "@", "?", ";".
text may contain spaces, too, but never two or more spaces consecutively. Spaces separate words in the text string.
text won’t start or end with a space.
Indexing of characters in text is zero-based.
words list will contain unique strings.
1 <= number of characters in text <= 1000000
1 <= number of words <= 100000
1 <= length of any word in words or in text <= 10*/
public class IndicesOfWordsInTextString {
    /*
    * Asymptotic complexity in terms of number of words in `text` `n`, number of words in `words` `w`,
        and the maximum length of a word `l`.
    * Time: O((n + w) * l).
    * Auxiliary space: O((n * l) + w).
    * Total space: O((n + w) * l).
    */

	 static ArrayList<ArrayList<Integer>> find_words(String text, ArrayList<String> words) {
	        String[] wordsInText = text.split(" ");

	        // {word -> [index1, index2]}
	        HashMap<String, ArrayList<Integer>> textIndex = new HashMap<>();
	        int currentIndex = 0;
	        for (String word : wordsInText) {
	            ArrayList<Integer> indexes = textIndex.get(word);
	            if (indexes == null) {
	                indexes = new ArrayList<>();
	            }
	            indexes.add(currentIndex);
	            textIndex.put(word, indexes);
	            currentIndex += word.length() + 1;
	        }

	        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
	        for (String word : words) {
	            ArrayList<Integer> indexes = textIndex.get(word);
	            if (indexes == null) {
	                indexes = new ArrayList<>(Collections.singleton(-1));
	            }
	            answer.add(indexes);
	        }

	        return answer;
	    }

}
/*
 * optimal_solution1.java In this solution we preprocess text and create its
 * index, see textIndex variable. By the time that’d done, each word from the
 * text has the list of its starting indices pre-compiled. All that’s left is to
 * look up those lists of indexes for every word from words.
 * 
 * Time Complexity O((n + w) * l). It takes O(I) time to calculate hashcode or
 * to compare two strings up to l characters long. Thus populating the hashmap
 * with n words will take O(n * l), making w searches in that hashmap will take
 * O(w * l). Total time is the sum of those: O(n * l) + O(w * l) = O((n + w) *
 * l).
 * 
 * Auxiliary Space Used O((n * l) + w). Hashmap which we pre-compute takes O(n *
 * l) space. The list of lists that we return takes O(w + n) space (see
 * explanation in Auxiliary space section for brute_force_solution.java).
 * Summing up the two gives O(n * l) + O(w + n) = O((n * l) + w).
 * 
 * Space Complexity O((n + w) * l). text input takes O(n * l) and words take O(w
 * * l). Adding up those two and the auxiliary space we get the total space
 * complexity: O(n * l) + O(w * l) + O((n * l) + w) = O((n + w) * l).
 */