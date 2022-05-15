package ik.com.anup.strings;

import java.util.ArrayList;

/*A word can be written in a vertical zigzag fashion in a given number of lines, e.g. KICKSTART in three lines looks like this:

K     S    T
I  K  T  R
C     A
Reading this text line by line gives us KSTIKTRCA.

Given a word and a number of lines for zigzagging, return that line-by-line representation.

Example One
{
"nlines": 4,
"word": "INTERVIEW"
}
Output:

"IINVETRWE"
Because zigzagging INTERVIEW in four lines gives this:

I        I
N     V  E
T  R     W
E
Example Two
{
"nlines": 1,
"word": "KICKSTART"
}
Output:

"KICKSTART"
Notes
Constraints:

1 <= word length <= 100000
1 <= number of lines <= 100000
Word consists of characters a..z, A..Z, 0..9*/
public class ZigzagAWord {
	  static String zigzag(Integer nlines, String word) {

	        if (nlines==1) return word;
	        ArrayList<StringBuilder> level = new ArrayList<>();

	        boolean down = true;

	        for (int i=0; i<nlines; i++) {
	            level.add(new StringBuilder());
	        }
	        int row = -1, col=0;

	        for (int i=0; i<word.length(); i++) {
	            if (down) {
	                row++;
	                if(row==nlines-1) {
	                    down=!down;
	                }
	            } else {
	                row--;
	                col++;
	                if(row==0) {
	                    down=!down;
	                }
	            }
	            level.get(row).append(word.charAt(i));
	        }
	        StringBuilder result = new StringBuilder();
	        for (StringBuilder s : level) {
	            result.append(s);
	        }
	        return result.toString();
	    }
}
