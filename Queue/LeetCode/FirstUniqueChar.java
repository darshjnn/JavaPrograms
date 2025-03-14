/*
387. First Unique Character in a String

Given a string s, find the first non-repeating character in it and return its index.
If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1

*/

package Queue.LeetCode;

import java.util.Queue;
import java.util.LinkedList;

public class FirstUniqueChar {
    public static int firstUniqChar(String s) {
        Queue<Integer> q = new LinkedList<>();
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (count[ch - 'a'] == 0) {
                q.offer(i);
            }
            ++count[ch - 'a'];
        }

        while (!q.isEmpty()){
            int temp = q.poll();
            if (count[s.charAt(temp) - 'a'] == 1) {
                return temp;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
		System.out.println(firstUniqChar(s));
    }
}
