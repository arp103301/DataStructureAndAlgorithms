package Z.com.anup.companiesSamples;

public class CountBinarySubstrings {
	public int countBinarySubstrings(String s) {
		// current count of consecutive 1 or 0
		int curCountOfOneOrZero = 1;
		// prev count of consecutive 1 or 0
		int prevCountOfOneOrZero = 0;
		int binaryStrCount = 0;
		for (int i = 1; i < s.length(); i++) {
			// if the prev and cur element is the same update cur count
			if (s.charAt(i) == s.charAt(i - 1)) {
				curCountOfOneOrZero++;
			} else {
				// if the the cur element is different update the new current count and prev count
				prevCountOfOneOrZero = curCountOfOneOrZero;
				curCountOfOneOrZero = 1;
			}
			// now if we know the prev consectutive count and current count
			// then we know that if the curCount is less than or equal to prev count, there is atleast 1
			// substring that has the same 1s and 0s consecutively grouped therefore whenever
			// this condition is true increment the count
			if (prevCountOfOneOrZero >= curCountOfOneOrZero) {
				binaryStrCount++;
			}
		}
		return binaryStrCount;
	}
}
