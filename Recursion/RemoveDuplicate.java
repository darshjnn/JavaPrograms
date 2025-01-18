/*
Remove Duplicate Characters in a String

*/

package Recursion;

public class RemoveDuplicate {
    public static StringBuilder helper(String str, int index, boolean[] flag) {
        if (index == str.length()) {
            return new StringBuilder();
        }
        
        if (flag[str.charAt(index) - 'a']) {
            return helper(str, (index + 1), flag);
        }
        
        flag[str.charAt(index) - 'a'] = true;
        return helper(str, (index + 1), flag).append(str.charAt(index));
    }
    
    public static String removeDuplicates(String str) {
        boolean[] flag = new boolean[26];
        return helper(str, 0, flag).reverse().toString();
    }
    
    public static void main(String[] args) {
        String str = "cbacdcbc";
        System.out.println(removeDuplicates(str));
    }
}