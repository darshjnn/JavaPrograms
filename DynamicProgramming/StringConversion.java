/*
String Conversion (Similar to Edit Distance)

Convert String1 to String2 with only insertion and deletion.
Print number of deletions and insertions.

Example 1:
Input: str1 = "pear" str2 ="sea"
Output: 2
Explanation: delete 'p', insert 's', delete 'r'

*/

package DynamicProgramming;

public class StringConversion {
	public static int stringConversion(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n + 1][m + 1];
		
		int lcs = lcs(s1, s2, dp);
		
		int deletes = n - lcs;
		int inserts = m - lcs;
		
		System.out.println("Delete Operations: " + deletes);
		System.out.println("Insert Operations: " + inserts);
		
		return deletes + inserts;
	}
	
	// Finding Longest Common Subsequence
	public static int lcs(String s1, String s2, int[][] dp) {
		int n = s1.length();
		int m = s2.length();
		
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		
		return dp[n][m];
	}
	
	public static void main(String[] args) {
		String str1 = "pear";
		String str2 = "sea";
		
		System.out.println(stringConversion(str1, str2));
	}
}
