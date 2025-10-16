/*
646. Maximum Length of Pair Chain

You are given an array of n pairs where pairs[i] = [left[i], right[i]] and left[i] < right[i].

A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this
fashion.

Return the length longest chain which can be formed.

You do not need to use up all the given intervals. You can select pairs in any order.

Example 1:
Input: pairs = [[1,2],[2,3],[3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4].

Example 2:
Input: pairs = [[1,2],[7,8],[4,5]]
Output: 3
Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].

*/

package Arrays.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthPairChain {
    public static int findLongestChain(int[][] pairs) {
        int chain = 1;
        Arrays.sort(pairs, Comparator.comparingInt(p -> p[1]));

        for (int i = 0; i < pairs.length - 1; i++) {
            if (pairs[i][1] < pairs[i + 1][0]) {
              ++chain;
            }
        }

        return chain;
    }

    public static void main(String[] args) {
		int[][] pairs = {{1, 2}, {3, 4}, {2, 3}};
		System.out.println(findLongestChain(pairs));
    }
}
