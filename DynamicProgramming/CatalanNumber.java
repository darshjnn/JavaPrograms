/*
Catalan's Number

C0 = 1
C1 = 1
C2 = C0.C1 + C1.C0 = 2
C3 = C0.C2 + C1.C1 + C2.C0 = 5
Cn = C0.Cn + C1.C(n-1) + ... + Cn.C0

*/

package DynamicProgramming;

import java.util.Arrays;

public class CatalanNumber {
	public static int catalanNumberRec(int n) {
		// Recursive Approach to Calculate Catalan's Number
		if (n == 0 || n == 1) {
			return 1;
		}
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += catalanNumberRec(i) * catalanNumberRec(n - i - 1);
		}
		
		return ans;
	}
	
	// Memoization Approach to Calculate Catalan's Number
	public static int catalanNumberMem(int n, int[] dp) {
		if (n == 0 || n == 1) {
			return dp[n] = 1;
		}
		
		if (dp[n] != -1) {
			return dp[n];
		}
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += catalanNumberMem(i, dp) * catalanNumberMem(n - i - 1, dp);
		}
		
		return dp[n] = ans;
	}
	
	// Tabulation Approach to Calculate Catalan's Number
	public static int catalanNumberTab(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		
		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		int n = 6;
		
		System.out.println(catalanNumberRec(n));
		
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(catalanNumberMem(n, dp));
		
		System.out.println(catalanNumberTab(n));
	}
}
