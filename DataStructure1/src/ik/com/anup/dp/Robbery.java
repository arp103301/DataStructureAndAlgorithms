package ik.com.anup.dp;

import java.util.ArrayList;
import java.util.Arrays;

/*There are n houses built in a line, each of which contains some value in it. A thief is going to steal the maximal value in these houses, but he cannot steal in two adjacent houses because the owner of a stolen house will tell his two neighbours on the left and right side. What is the maximal stolen value?

For example, if there are four houses with values [6, 1, 2, 7], the maximal stolen value is 13, when the first and fourth houses are stolen.

Example
{
"values": [6, 1, 2, 7]
}
Output:

13
Steal from the first and the last house.

Notes
Constraints:

1 <= n <= 105
1 <= values[i] <= 104, for all i.*/
public class Robbery {
	   /*
    Asymptotic complexity in terms of the size of `values` `n`:
    * Time: O(n).
    * Auxiliary space: O(n).
    * Total space: O(n).
    */

    static Integer maximum_stolen_value(ArrayList<Integer> values) {
        int dp[] = new int[values.size()];
        Arrays.fill(dp, -1);
        return maxStolenTill(values.size() - 1, values, dp);/// starting index is from last col
    }

    private static int maxStolenTill(int index, ArrayList<Integer> values, int[] dp_table) {
        if (index < 0) {
            return 0;
        }
        if (dp_table[index] != -1) {
            return dp_table[index];
        }
        if (index == 0) {
            return dp_table[index] = values.get(0);
        }
        if (index == 1) {
            return dp_table[index] = Math.max(values.get(0), values.get(1));// ideally would have values(1) but this index might be lower than values(0) so taking max
        }
        return dp_table[index] = Math.max(maxStolenTill(index - 1, values, dp_table),
                                      maxStolenTill(index - 2, values, dp_table) + values.get(index));
    }
}


//target is also unknown(=dynamic) hence need recursion  
//but if target was given sep or one of the elements of the array.. we can do DP
