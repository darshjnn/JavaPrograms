/*
696. Count Binary Substrings

Given a binary string s, return the number of non-empty substrings that have the same
number of 0's and 1's, and all the 0's and all the 1's in these substrings are 
grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

Example 1:
Input: s = "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's:
                "0011", "01", "1100", "10", "0011", and "01".
Notice that some of these substrings repeat and are counted the number of times they
occur.
Also, "00110011" is not a valid substring because all the 0's (and 1's) are not
grouped together.

Example 2:
Input: s = "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of
consecutive 1's and 0's.

*/

package Strings.LeetCode;

public class CountBinarySubstrings {
    public static int countBinarySubstrings(String str) {
        int len = str.length();
        int ans = 0;

        int prev = 0; // Length of previous group
        int curr = 1; // Current group has at least one character

        for (int i = 1; i < len; i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                ++curr;
            } else {
                ans += Math.min(curr, prev);
                prev = curr;
                curr = 1;
            }
        }

        ans += Math.min(prev, curr);

        return ans;
    }

    public static void main(String[] args) {
        String str = "10101";

        System.out.println(countBinarySubstrings(str));
    }
}