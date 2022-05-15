package ik.com.anup.strings;

import java.util.ArrayList;

/*Convert given string sinusoidally. Return the sinusoidal representation as three strings.

Example
{
"s": "InterviewKickstart"
}
Output:

[
"  t   i   i   t   ",
" n e v e K c s a t",
"I   r   w   k   r "
]
As you can see in the output, in the sinusoidal format:

you return three strings,
character #1 is printed in the first column of the third string,
character #2 is printed in the second column of the second string,
character #3 is printed in the third column of the first string,
character #4 is printed in the fourth column of the second string,
character #5 is printed in the fifth column of the third string,
character #6 is printed in the sixth column of the second string,
all other characters are spaces,
and the same pattern repeats.
Length of all three strings you return is the same.

Notes
All three strings must be of the same length, so some of them may end with space character(s).
Constraints:

String s consists of alphanumeric characters. No spaces.
3 <= length of s <= 105*/
public class ConvertStringSinusoidally {
	static ArrayList<String> convert_string_sinusoidally(String s) {

        StringBuffer[] strBuf = new StringBuffer[3];
        strBuf[0] = new StringBuffer();
        strBuf[1] = new StringBuffer();
        strBuf[2] = new StringBuffer();

        boolean up = true;
        int row = 2;
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            for(int j = 0; j < 3; j++) {
                if (j == row) {
                    strBuf[j].append(ch);
                }
                else {
                    strBuf[j].append(' ');
                }
            }

            row = up ? (row - 1) : (row + 1);
            if (row < 0) {
                row = 1;
                up = false;
            }
            else if (row > 2) {
                row = 1;
                up  = true;
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < 3; i++)
            result.add(strBuf[i].toString());
        return result;
    }

}
