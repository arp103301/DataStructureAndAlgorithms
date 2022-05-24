package ik.com.anup.dp;

//LC 935 ::935. Knight Dialer>>> MOves= {+-2,+-1}

import java.util.ArrayList;

/*Given a phone keypad as shown below:

1 2 3
4 5 6
7 8 9
– 0 –

How many different phone numbers of given length can be formed starting from the given digit? 
The constraint is that the movement from one digit to the next is similar to the movement of the Knight in chess.

For example, if we are at 1, then the next digit can be either 6 or 8; if we are at 6 then the 
next digit can be 1, 7 or 0.

Repetition of digits is allowed, e.g. 1616161616 is a valid number.
There is no need to list all possible numbers, just find how many they are.
Find a polynomial-time solution, based on Dynamic Programming.

Example One
{
"startdigit": 1,
"phonenumberlength": 2
}
Output:

2
Two possible numbers of length 2: 16, 18.

Example Two
{
"startdigit": 1,
"phonenumberlength": 3
}
Output:

5
The possible numbers of length 3: 160, 161, 167, 181, 183

Notes
There are two input parameters: startdigit and phonenumberlength, denoting the starting digit and the required length respectively.
Output is a long integer denoting the total number of valid phone numbers that can be formed.
Constraints:

0 <= startdigit <= 9
1 <= phonenumberlength <= 30*/
public class KnightsTourOnAPhoneKeypad {
    /*
    Asymptotic complexity in terms of `phonenumberlength`:
    * Time: O(phonenumberlength).
    * Auxiliary space: O(phonenumberlength).
    * Total space: O(phonenumberlength).
    */

    static Long count_phone_numbers_of_given_length(Integer startdigit, Integer phonenumberlength) {

        // List of where integers where you can go from a particular integer
        ArrayList<ArrayList<Integer>> validMoves = new ArrayList<>();// {+-2,+-1}
      //listOfNext= [4,6],[6,8],[7,9]...[4,2]]
        // 0
        validMoves.add(new ArrayList<Integer>());
        validMoves.get(0).add(4);
        validMoves.get(0).add(6);

        // 1
        validMoves.add(new ArrayList<Integer>());
        validMoves.get(1).add(6);
        validMoves.get(1).add(8);

        // 2
        validMoves.add(new ArrayList<Integer>());
        validMoves.get(2).add(7);
        validMoves.get(2).add(9);

        // 3
        validMoves.add(new ArrayList<Integer>());
        validMoves.get(3).add(4);
        validMoves.get(3).add(8);

        // 4
        validMoves.add(new ArrayList<Integer>());
        validMoves.get(4).add(3);
        validMoves.get(4).add(9);
        validMoves.get(4).add(0);

        // 5
        validMoves.add(new ArrayList<Integer>());

        // 6
        validMoves.add(new ArrayList<Integer>());
        validMoves.get(6).add(1);
        validMoves.get(6).add(7);
        validMoves.get(6).add(0);

        // 7
        validMoves.add(new ArrayList<Integer>());
        validMoves.get(7).add(2);
        validMoves.get(7).add(6);

        // 8
        validMoves.add(new ArrayList<Integer>());
        validMoves.get(8).add(1);
        validMoves.get(8).add(3);

        // 9
        validMoves.add(new ArrayList<Integer>());
        validMoves.get(9).add(4);
        validMoves.get(9).add(2);

        long dp[][] = new long[phonenumberlength][10];//similar to equal subset problem..rows= phonenumber and col=digits
        
        // First digit is already given. So we can only form one number of length 1.
        dp[0][startdigit] = 1;

        for(int i = 1; i < phonenumberlength; i++){
           
        	for(int digit = 0; digit < 10; digit++){
               
            	for(int vm : validMoves.get(digit)){//[4,6],[6,8],[7,9]..]
                	
                    // We can come to num from all its neighbors.
                    // So we will add all possible numbers of length (i - 1) that are neighnours of num.
                   // dp[i][digit] += dp[i - 1][vm];
                    dp[i][digit] =dp[i][digit]+ dp[i - 1][vm];// include+exclude the currentValue
                }
            }
        }

        long ans = 0;
        // Sum all possible ending of length phonenumberlength
        for(int num = 0; num < 10; num++){
            ans += dp[phonenumberlength - 1][num];
        }
        return ans;
    }

}
/*
Asymptotic complexity in terms of `phonenumberlength`:
* Time: O(phonenumberlength).
* Auxiliary space: O(phonenumberlength).
* Total space: O(phonenumberlength).
*/
