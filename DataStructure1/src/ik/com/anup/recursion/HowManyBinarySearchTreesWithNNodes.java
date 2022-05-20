package ik.com.anup.recursion;

/*Write a function that returns the number of distinct binary search trees that can be constructed
 *  with n nodes. For the purpose of this exercise, do solve the problem using recursion first even if you
 *   see some non-recursive approaches.

Example One
{
"n": 1
}
Output:

1
Example Two
{
"n": 2
}
Output:

2
Suppose the values are 1 and 2, then the two trees that are possible are

   (2)            (1)
  /       and       \
(1)                  (2)
Example Three
{
"n": 3
}
Output:

5
Suppose the values are 1, 2, 3 then the possible trees are

       (3)
      /
    (2)
   /
(1)

   (3)
  /
(1)
   \
   (2)

(1)
   \
    (2)
      \
       (3)

(1)
   \
    (3)
   /
(2)

   (2)
  /   \
(1)    (3)
Notes
Constraints:

1 <= n <= 16
*/
public class HowManyBinarySearchTreesWithNNodes {
    
	static long how_many_bsts(int n) {
        // Write your code here.
        // Write your code here.
        long[] dp = new long[n+1];
      return helper(dp, n);
  }

  static long helper(long[] dp, int n) {
      if (n == 0) return 1;// used for passing memo[n]>>>>>>>>>>>. constraint is 1 as lowest 
      if (n <= 2 ) return n;//// used for passing memo[n]
    

      long result = 0;
      for (int i=0; i<n; i++) {
    	  
          long left = helper(dp, i);//f(0)
          
          long right = helper(dp, n -i - 1);//n-(i+1)// f(n-i)
          
          result += left*right;  // f(n) = summuation of i to n {(f(i-1)*f(n-1))  }
      }
      dp[n] = result;
      return dp[n];
  } 
}


/*
 * The number of binary search trees can be seen as a recursive solution. i.e.,
 * Number of binary search trees = (Number of Left binary search sub-trees) *
 * (Number of Right binary search sub-trees) * (Ways to choose the root)
 * 
 * In a BST, only the relative ordering between the elements matter. So, without
 * any loss on generality, we can assume the distinct elements in the tree are
 * 1, 2, 3, 4, ...., n. Also, let the number of BST be represented by f(n) for n
 * elements.
 * 
 * Now we have the multiple cases for choosing the root.
 * 
 * choose 1 as root, no element can be inserted on the left sub-tree. n-1
 * elements will be inserted on the right sub-tree. Choose 2 as root, 1 element
 * can be inserted on the left sub-tree. n-2 elements can be inserted on the
 * right sub-tree. Choose 3 as root, 2 element can be inserted on the left
 * sub-tree. n-3 elements can be inserted on the right sub-tree. ......
 * Similarly, for i-th element as the root, i-1 elements can be on the left and
 * n-i on the right.
 * 
 * These sub-trees are itself BST, thus, we can summarize the formula as:
 * 
 * f(n) = f(0)f(n-1) + f(1)f(n-2) + .......... + f(n-1)f(0)
 */


//https://stackoverflow.com/questions/3042412/with-n-no-of-nodes-how-many-different-binary-and-binary-search-trees-possib#:~:text=For%20n%20%3D%204%20%2D%2D%3E%20336%20Binary%20Search%20Trees%20are%20possible.