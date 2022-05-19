package ik.com.anup.strings;

//https://www.youtube.com/watch?v=pEku6cp_J80

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

		    	 //Define StringBuilders
		        StringBuilder[] rowSb = new StringBuilder[nlines];
		     // string bulder for each RowSb and eachrow elements need to be populated.
		        for(int i = 0; i < nlines; i++){
		            rowSb[i] = new StringBuilder();
		        }
		        
		        //Define Variables
		        char[] arr = word.toCharArray();
		        int n = arr.length;
		        int index = 0;
		        
		        //Traverse zig zag
		        while(index < n){
		            //Go down
		            for(int j = 0; j < nlines && index < n; j++){
		                rowSb[j].append(arr[index]); index++;
		            }
		            //Go Up before start
		            for(int j = nlines - 2; j > 0 && index < n; j--){//nlines-1 is lastRow so we only go 1 row above it
		                rowSb[j].append(arr[index]); index++;
		            }
		        }
		        
		        //Combine all stringbuilders into one
		        StringBuilder res = rowSb[0];
		        for(int i = 1; i < nlines; i++){
		            res.append(rowSb[i].toString());  System.out.println(rowSb[i]);
		        }
		        return res.toString();
		    
		    }

		    
		    
		    
		    
		    
		    
		    public static void main(String[] args)
		    {
		      // Driver Code
		      String str = "PAYPALISHIRING";
		      int N = 3;
		      zigzag(N,str);
		    }
}

//O(n)