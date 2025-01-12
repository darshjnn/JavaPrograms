// To find first and last occurrence of an element using recursion
package Recursion;

public class Occurrence {
	// First & Last Occurrence in an Array
	public static void getIndices(String str, char key, int[] arr, int index) {
		if (index >= str.length() || index < 0) {
			return;
		}
		
		if (str.charAt(index) == key) {
			if (arr[0] == -1) {
				arr[0] = index;
			} else {
				arr[1] = index;
			}
		}
		
		getIndices(str, key, arr, index + 1);
	}
	
	// First Occurrence
	public static int firstOccurrence(String str, char key, int index) {
		if (index >= str.length() || index < 0) {
			return -1;
		}
		
		if (str.charAt(index) == key) {
			return index;
		}
		
		return firstOccurrence(str, key, index + 1);
	}
	
	public static int lastOccurrence(String str, char key, int index) {
		if (index >= str.length() || index < 0) {
			return -1;
		}
		
		int isFound = lastOccurrence(str, key, index + 1);
		if (isFound == -1 && str.charAt(index) == key) {
			return index;
		}
		
		return isFound;
	}
	
	public static void main(String[] args) {
		char target = 'e';
		String str = "Mentos Life is Savage...";
		System.out.println("\n" + str + "\n");
		
		int[] occurrence = {-1, -1};
		getIndices(str, target, occurrence, 0);
		System.out.println("First & Last Occurrence: " + occurrence[0] + "  " + occurrence[1]);
		
		System.out.println();
		
		System.out.println("First Occurrence: " + firstOccurrence(str, target, 0));
		System.out.println("Last Occurrence: " + lastOccurrence(str, target, 0));
	}
}
