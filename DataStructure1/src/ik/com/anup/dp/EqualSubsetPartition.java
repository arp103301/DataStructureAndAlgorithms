	package ik.com.anup.dp;

import java.util.ArrayList;

import java.util.*;
/*Equal Subset Partition
Given an array s of n integers, partition it into two non-empty subsets, s1 and s2, 
such that the sum of all elements in s1 is equal to the sum of all elements in s2. Return a 
boolean array of size n where i-th element is 1 if i-th element of s belongs to s1 and 0 if it belongs to s2.

Example
{
"s": [10, -3, 7, 2, 1, 3]
}
Output:

[1, 1, 0, 0, 0, 1]
There are multiple partitionings where s1 sums up to 10 and s2 sums up to 10; they are all correct answers:

s1 = [ 10 , -3 , 3 ] and s2 = [ 7 , 2 , 1 ] (Sample output)

s1 = [ 7 , 2 , 1 ] and s2 = [ 10 , -3 , 3 ]

s1 = [10] and s2 = [-3, 3, 7, 2, 1]

s1 = [-3, 3, 7, 2, 1] and s2 = [10]

s1 = [10, -3, 2, 1] and s2 = [7, 3]

s1 = [7, 3] and s2 = [10, -3, 2, 1].

Notes
Any valid answer will be accepted.
If such partitioning is not possible, return an empty array.
Constraints:

1 <= n <= 100
-100 <= elements in s <= 100*/
public class EqualSubsetPartition {

    public static ArrayList<Boolean> equal_subset_sum_partition(ArrayList<Integer> s) {
        int posSum = 0, negSum = 0;
        for (int num: s) {
            if (num >= 0)
                posSum += num;
            else
                negSum += num;
        }
        if ((posSum + negSum) % 2 != 0) return new ArrayList<>();

        int range = posSum - negSum;

        boolean[][] dp = new boolean[s.size()][range+1];
        dp[0][s.get(0)-negSum] = true;
        for (int i = 1; i < s.size(); i++) {
            for (int j = 0; j <= range; j++) {
                if (dp[i-1][j] == true) {
                    dp[i][j] = true;
                    dp[i][j+s.get(i)] = true;
                }
            }
        }

        int target = (posSum + negSum)/2;
        target -= negSum;
        if (dp[s.size()-1][target] == false)
            return new ArrayList<>();

        //Setion 2 ::::::::::::::::::::::::::::::::try to find the list 
        
        Boolean[] finalArr = new Boolean[s.size()];
        int trueCount = 0;
        for (int i = s.size() - 1; i >= 0; i--) {
            if (i == 0) {
                finalArr[i] = dp[i][target];
                trueCount += finalArr[i] == true? 1 : 0;
            } else if (dp[i][target] == true && dp[i-1][target] == false) {
                finalArr[i] = true;
                target -= s.get(i);
                trueCount++;
            } else {
                finalArr[i] = false;
            }
        }
        if (trueCount == s.size())
            return new ArrayList<>();
        else
            return new ArrayList<>(Arrays.asList(finalArr));
    }

    
    
    
    
    
    
	  public static void main(String[] args) {
			/*
			 * EqualSubsetPartition ps = new EqualSubsetPartition(); int[] num = {1, 2, 3,
			 * 4}; List<Integer> s= new ArrayList<>(Arrays.asList(num));
			 * 
			 * System.out.println(equal_subset_sum_partition(num)); num = new int[]{1, 1, 3,
			 * 4, 7}; System.out.println(ps.equal_subset_sum_partition(num)); num = new
			 * int[]{2, 3, 4, 6}; System.out.println(ps.equal_subset_sum_partition(num));
			 */
	  }
}
