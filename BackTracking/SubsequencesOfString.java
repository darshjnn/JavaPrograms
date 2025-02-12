/*
Generate all Subsequences of a String.

Time Complexity: O(n * 2^n).

Space Complexity: O(n)

*/

package BackTracking;

import java.util.*;

public class SubsequencesOfString {
    static void sub(String s, int i, StringBuilder sb, ArrayList<String> l) {
        if (i < 0) {
            return;
        }
        
        if (i >= s.length()) {
            l.add(sb.toString());
            return;
        }

        sb.append(s.charAt(i));
        sub(s, i + 1, sb, l);
        sb.deleteCharAt(sb.length() - 1);

        sub(s, i + 1, sb, l);
    }

    public static ArrayList<String> subsequences(String str) {
        ArrayList<String> result = new ArrayList<>();
        sub(str, 0, new StringBuilder(), result);
        return result;
    }
    
    public static void main(String[] args) {
        String str = "abcd";
        ArrayList<String> arr = subsequences(str);
        System.out.println("\n" + Arrays.toString(arr.toArray()));
    }
}