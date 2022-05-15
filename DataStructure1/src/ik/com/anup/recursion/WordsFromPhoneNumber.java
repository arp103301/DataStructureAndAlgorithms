package ik.com.anup.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*Given a seven-digit phone number, return all the character combinations that can be generated according to the following mapping:

Graph

Return the combinations in the lexicographical order.

Example
{
"phone_number": "1234567"
}
Output:

[
"adgjmp",
"adgjmq",
"adgjmr",
"adgjms",
"adgjnp",
...
"cfilns",
"cfilop",
"cfiloq",
"cfilor",
"cfilos"
]
First string "adgjmp" in the first line comes from the first characters mapped to digits 2, 3, 4, 5, 6 and 7 respectively. Since digit 1 maps to nothing, nothing is appended before 'a'. Similarly, the fifth string "adgjnp" generated from first characters of 2, 3, 4, 5 second character of 6 and first character of 7. All combinations generated in such a way must be returned in the lexicographical order.

Notes
Return an array of the generated string combinations in the lexicographical order. If nothing can be generated, return an array with one string "-1".
Digits 0 and 1 map to nothing. Other digits map to either three or four different characters each.
Constraints:

Input string is 7 characters long; each character is a digit.*/
public class WordsFromPhoneNumber {

    static ArrayList<String> get_words_from_phone_number(String phone_number) {
        Map<Character, String> map = new HashMap<>();
        
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        ArrayList<String> result = new ArrayList<>();
        phoneNumberHelper(phone_number, new StringBuilder(), map, result, 0);
        
        if (result.size() ==0) 
            result.add("-1");
        
        return result;
    }
    
    static void phoneNumberHelper(String input, StringBuilder slate,  Map<Character, String> digiMap, ArrayList<String> result, int startIndx) {
        if (startIndx == input.length()) {
            if (slate.length()>0)
                result.add(slate.toString());
            return;
        }
        
        String str = digiMap.get(input.charAt(startIndx));
        
        if (str != null) {// remember 1 do not map to any string and input might start with 1
            for (int i=0; i<str.length(); i++) {
            	//include the character and recurse
                slate.append(str.charAt(i));
                phoneNumberHelper(input, slate, digiMap, result, startIndx+1);
                slate.deleteCharAt(slate.length()-1);
            }
        } else {//move forward if first character is 1:: 
            phoneNumberHelper(input, slate, digiMap, result, startIndx+1);
        }
    }
}

/*
Asymptotic complexity in terms of `n` =  size of the input string:
* Time: O(4^n).
* Auxiliary space: O(n).
* Total space: O(4^n).
*/
