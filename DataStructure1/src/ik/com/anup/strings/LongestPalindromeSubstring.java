package ik.com.anup.strings;

public class LongestPalindromeSubstring {
	public static String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2) {
			return s;
		}

		String result = "";

		for (int i = 0; i < s.length() - 1; i++) {
			// central is 1 char
			int oddLength = expandWindow(s, i, i);
			// central is 2 chars
			int evenLength = expandWindow(s, i, i + 1);

			int longerLength = Math.max(oddLength, evenLength);

			if (longerLength > result.length()) {
				result = s.substring(i - (longerLength - 1) / 2, i + longerLength / 2 + 1);
			}
		}

		return result;
	}

	// given string s, expand from given central
	private static int expandWindow(String s, int start, int end) {
		int left = start;
		int right = end;

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {// palindrome check
			//sliding window using 1 and 2 																		
			left--;//1.reduce left
			right++;//2. increase right 
		}
		/*
		 * Because there are strings with odd length and even length, we need to expand
		 * from one central or from two central, so there are n + n-1 central in total.
		 */
		return right - left - 1;// maxLength
	}
	
	public static void main(String[] args) {
		//System.out.println(longestPalindrome("BABAD"));
		System.out.println(longestPalindrome("ACBABD"));
		//System.out.println(longestPalindrome("CBBDB"));
	}
}
