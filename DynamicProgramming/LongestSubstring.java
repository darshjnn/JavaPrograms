/*
Longest Common Substring

Given two strings 's1' and 's2', find the length of the longest common substring.

A substring is a contiguous sequence of characters within a string.

Example 1:
Input: s1 = "GeeksForGeeks", s2 = "GeeksQuiz" 
Output : 5 
Explanation: The longest common substring is "Geeks" and is of length 5.

Example 2:
Input: s1 = "abcdxyz", s2 = "xyzabcd" 
Output : 4
Explanation: The longest common substring is "abcd" and is of length 4.

Example 3:
Input: s1 = "abc", s2 = "" 
Output : 0

*/

package DynamicProgramming;

public class LongestSubstring {
    public static int longestCommonSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n == 0 || m == 0) {
            return 0;
        }

        int[][] dp = new int[n + 1][m + 1];
		int maxLen = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "abcdxyz";
        String s2 = "xyzabcd";

        System.out.println(longestCommonSubstring(s1, s2));
    }
}
