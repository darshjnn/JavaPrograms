/*
1081. Smallest Subsequence of Distinct Characters

Given a string s, return the lexicographically smallest subsequence of s that contains all 
the distinct characters of s exactly once.

Example 1:
Input: s = "bcabc"
Output: "abc"

Example 2:
Input: s = "cbacdcbc"
Output: "acdb"

*/

package Strings.LeetCode;

public class SmallestSubsequence {
    public static String smallestSubsequence(String str) {
        int n = str.length();
        int[] count = new int[26];
        boolean[] flag = new boolean[26];

        for (int i = 0; i < n; i++) {
            ++count[str.charAt(i) - 'a'];
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            --count[c - 'a'];
            if (!flag[c - 'a']) {
                while (!result.isEmpty() && c < result.charAt(result.length() - 1) &&
                        count[result.charAt(result.length() - 1) - 'a'] > 0) {
                    flag[result.charAt(result.length() - 1) - 'a'] = false;
                    result.deleteCharAt(result.length() - 1);
                }

                flag[c - 'a'] = true;
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "cbacdcbc";
        System.out.println(smallestSubsequence(str));
    }
}
