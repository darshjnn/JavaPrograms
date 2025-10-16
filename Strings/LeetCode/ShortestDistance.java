/*
821. Shortest Distance to a Character

Given a string s and a character c that occurs in s, return an array of integers answers where
answer.length == s.length and answer[i] is the distance from index i to the closest occurrence
of character c in s.

The distance between two indices i and j is abs(i - j), where abs is the absolute value
function.

Example 1:
Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
Explanation: 
The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance
is still the same: abs(4 - 3) == abs(4 - 5) = 1.
The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.

Example 2:
Input: s = "aaab", c = "b"
Output: [3,2,1,0]

*/

package Strings.LeetCode;

import java.util.Arrays;

public class ShortestDistance {
    // Normal Zindagi
    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] dist = new int[n];
        int flag = n;

        for (int i = 0; i < n; i++) {
            if (flag == n || flag < i) {
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) == c && Math.abs(flag - i) >= Math.abs(j - i)) {
                        flag = j;
                        break;
                    }
                }
            }

            dist[i] = Math.abs(flag - i);
        }

        return dist;
    }

    // Mentos Zindagi
    public static int[] shortestToCharOpt(String s, char c) {
        int n = s.length();
        int[] dist = new int[n];

        // First Occurrence of c 
        int firstOcc = s.indexOf(c);
        findAndPopulateDistance(dist, 0, firstOcc, firstOcc);

        // Second Occurrence of c
        int secondOcc = s.indexOf(c, firstOcc + 1);

        int mid;
        while (secondOcc > 0) {
            mid = firstOcc + ((secondOcc - firstOcc) / 2);
            findAndPopulateDistance(dist, firstOcc, mid, firstOcc);
            findAndPopulateDistance(dist, mid + 1, secondOcc, secondOcc);

            firstOcc = secondOcc;
            secondOcc = s.indexOf(c, firstOcc + 1);
        }

        findAndPopulateDistance(dist, firstOcc, n - 1, firstOcc);

        return dist;
    }

    public static void findAndPopulateDistance(int[] dist, int start, int end, int charPos) {
        for (int i = start; i <= end; i++) {
            dist[i] = Math.abs(i - charPos);
        }
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';

        System.out.println(Arrays.toString(shortestToChar(s, c)));
        System.out.println(Arrays.toString(shortestToCharOpt(s, c)));
    }
}