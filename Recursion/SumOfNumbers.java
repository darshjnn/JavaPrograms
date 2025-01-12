package Recursion;

public class SumOfNumbers {
	public static int sumOfNaturalNumbers(int n) {
		if (n <= 0) {
			return 0;
		}
		
		return n + sumOfNaturalNumbers(n - 1);
	}
	
	public static int rangeSum(int lower, int upper) {
		if (lower > upper) {
			return 0;
		}
		
		return upper + rangeSum(lower, upper - 1);
	}
	
	public static void main(String[] args) {
		int n = -5;
		
		System.out.println("Sum of numbers between 1 and " + n + " : " + sumOfNaturalNumbers(n));
		
		int upper = -4;
		int lower = -5;
		
		System.out.print("Sum in range " + upper + " & " + lower + " : ");
		System.out.println( rangeSum(lower,	upper));
	}
}