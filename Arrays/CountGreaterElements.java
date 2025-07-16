/*
Count Greater Elements

Given an integer array Arr of size N the task is to find the count of elements whose value is
greater than all of its prior elements.

Note: First element of the array should be considered in the count of the result.

Example 1:
Input: arr[]= {7,4,8,2,9}
Output: 3
Explanation:
As 7 is the first element, it will consider in the result.
8 and 9 are also the elements that are greater than all of its previous elements.
Since total of 3 elements are present in the array that meets the condition.

Example 2:
Input: arr[]= {3,4,5,8,9}
Output: 5

*/

package Arrays;

public class CountGreaterElements {
	public static int countGreaterElements(int[] arr) {
		int count = 1;
		int max = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				++count;
				max = arr[i];
			}
		}
		
		return  count;
	}
	
	public static void main(String[] args) {
		int[] arr = {7, 4, 8, 2, 9};
		
		System.out.println(countGreaterElements(arr));
	}
}
