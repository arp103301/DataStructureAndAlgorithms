package D.com.anup.array;

public class FindMinumumElementofArray {
	
	public int findMinimum(int[] arr) {
		// edge case
		if(arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		
		int min = arr[0]; // min will hold the minimum of array
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
 
	public static void main(String[] args) {
		int[] arr = {18,9005, 9, 23, 1015, 190, 24};
		FindMinumumElementofArray ma = new FindMinumumElementofArray();
		//System.out.println(ma.findMinimum(new int[0]));
		System.out.println(ma.findMinimum(arr));
	}
}