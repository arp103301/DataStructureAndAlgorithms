package D.com.anup.array;

public class ReverseArray {
	
	//public static void reverse(int[] numbers, int start, int end) {
	public static void reverse(int[] numbers) {
		int start = 0;
		int end = numbers.length - 1;
		
		while(start < end) {
			int temp = numbers[start];
			numbers[start] = numbers[end];
			numbers[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void printArray(int[] arr) { 
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}  
		System.out.println(); 
	} 
 
	public static void main(String[] args) {
		int[] numbers = {47, 2, 11, 5, 10, 7, 8};
		printArray(numbers);
		//reverse(numbers, 0, numbers.length - 1);
		reverse(numbers);
		printArray(numbers);
	}
}