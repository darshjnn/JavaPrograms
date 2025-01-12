package Recursion;

public class FibonacciSeries {
	public static int fibonacciTerm(int n) {
		if (n <= 1) {
			return 0;
		}
		
		if (n == 2) {
			return 1;
		}
		
		return fibonacciTerm(n - 1) + fibonacciTerm(n - 2);
	}
	
	public static void fibonacciSeries(int n, int a, int b) {
		if (n < 1) {
			return;
		}
		
		System.out.print(a + "  ");
		fibonacciSeries((n - 1), (a + b), a);
	}
	
	public static void main(String[] args) {
		int n = 7;
		
		System.out.println(n + " term of Fibonacci series is: " + fibonacciTerm(n));
		
		System.out.println();
		
		System.out.print(n + " terms from Fibonacci series are: ");
		fibonacciSeries(n, 0, 1);
	}
}
