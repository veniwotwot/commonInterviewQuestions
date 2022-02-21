package commonInterviewQuestions;

import java.util.Arrays;

public class kthLargestElement {

	// Given an array of integers arr and an integer k, find the
	// kth largest element
	public static void main(String[] args) {
		int[] arr = {4,2,9,7,5,6,7,1,3};
		int k = 4;		//expected output 6
		kthLargestElement a = new kthLargestElement();
		a.execute(arr, k);
	}
	
	private void execute(int[] arr, int k) {
		Arrays.sort(arr);	//sort the array
		
		int ans = arr[arr.length-k];
		System.out.println("The k-th largest is: "+ans);
	}

}
