/*
72. Edit Distance

Given two strings word1 and word2, return the minimum number of operations required to convert
word1 to word2.

You have the following three operations permitted on a word:
    1. Insert character
    2. Delete character
    3. Replace character
 

Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
    horse -> rorse (replace 'h' with 'r')
    rorse -> rose (remove 'r')
    rose -> ros (remove 'e')
    
Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
    intention -> inention (remove 't')
    inention -> enention (replace 'i' with 'e')
    enention -> exention (replace 'n' with 'x')
    exention -> exection (replace 'n' with 'c')
    exection -> execution (insert 'u')

*/

package DynamicProgramming.LeetCode;

public class EditDistance {
	public static int minDistance(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n + 1][m + 1];
		
		// Initialise Array
		// Length of s1 is 0: number of add operations to convert to s2 = length of s2
		for (int j = 0; j < m + 1; j++) {
			dp[0][j] = j;
		}
		
		// Length of s2 is 0: number of delete operations to covert to s2 = length of s1
		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = i;
		}
		
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				// Both characters are equal
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int add = dp[i][j - 1] + 1;
					int delete = dp[i - 1][j] + 1;
					int replace = dp[i - 1][j - 1] + 1;
					
					dp[i][j] = Math.min(Math.min(add, delete), replace);
				}
			}
		}
		
		return dp[n][m];
	}
	
	public static void main(String[] args) {
		String str1 = "intention";
		String str2 = "execution";
		
		System.out.println(minDistance(str1, str2));
	}
}