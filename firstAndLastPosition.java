package commonInterviewQuestions;

import java.util.Arrays;

public class firstAndLastPosition {

	// Given a sorted array of integer arr and an integer target,
	// find the index of the first and last position of target in arr.
	// If target can't be found, return [-1,-1]
	public static void main(String[] args) {
		int[] arr1 = { 2, 4, 5, 5, 5, 5, 5, 7, 9, 9 };
		int target1 = 5;
		firstAndLastPosition f = new firstAndLastPosition();
		f.execute(arr1, target1); // expected output: [2,6]
	}

	private void execute(int[] a, int b) {
		int[] ans = find(a, b);
		System.out.println("The output was: " + Arrays.toString(ans));
	}

	private int[] find(int[] arr, int target) {
		int first = findFirst(arr, target);
		int last = findLast(arr, target);
		int[] def = { first, last };
		return def;
	}

	private int findFirst(int[] arr, int target) {
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]==target)
				return i;
		}
		// default case
		return -1;
	}

	private int findLast(int[] arr, int target) {
		int last = -1;
		for(int i = 0; i<arr.length;i++) {
			if(arr[i]==target)
				last = i;
		}
		//default case
		return last;
	}
}
