package ik.com.anup.dp;

import java.util.ArrayList;

/*There is a staircase with n steps. A person standing at the 0-th step wants to reach the n-th one. 
 * They are capable of jumping up by certain numbers of steps at a time.

Given how the person can jump, count the number of ways they can reach the top.

Example One
{
"steps": [1, 2],
"n": 1
}
Output:

1
The person can jump up by either 1 or 2 steps at a time. The only way to reach step 1 from step 0 is to jump up one step once.

Example Two
{
"steps": [1, 2],
"n": 2
}
Output:

2
There are two distinct ways to reach step 2: {1, 1}, {2}.

Example Three
{
"steps": [2, 3],
"n": 7
}
Output:

3
There are three distinct ways to reach step 7 from step 0: {2, 2, 3}, {2, 3, 2}, {3, 2, 2}.

Notes
Constraints:

1 <= n <= 10000
1 <= length of the given list steps <= 100
1 <= element of the given list steps <= 10000
Answer will fit in a 64-bit integer*/
public class CountWaysToReachTheNthStep {
    /*
    Asymptotic complexity in terms of `n` and size of steps `m`:
    * Time: O(n * m).
    * Auxiliary space: O(n).
    * Total space: O(n + m).
    */
    static Long count_ways_to_climb(ArrayList<Integer> steps, Integer n) {
        /*
         * We will store counts till every step.
         */
        long table[] = new long[n + 1];
        
        // There is one way to reach till zero, as we start from 0
        table[0] = 1;
        
        
        for (int currStair = 1; currStair <= n; currStair++) {//i for target
            // Find the ways that you can reach here from current step
            for (int step : steps) {//j
                int previousStep = currStair - step;//////////int previousVal = amount[i - coins[j]];
                if (previousStep >= 0) {
                    table[currStair] += table[previousStep];
                    //  On RHS --- table[currStair]  is for current step cost which is added to previous optimum step soluction
                }
            }
        }

        // Ways to reach the nth step
        return table[n];
    }
}
