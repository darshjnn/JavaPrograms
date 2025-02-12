/*
Keypad Combinations

*/

package Recursion;

import java.util.ArrayList;

public class KeypadCombinations {
    public static String[] keypad = {".,-", "abc", "def", "ghi", "jkl", "mno",
                                        "pqr", "stu", "vwx", "yz"};
    
    public static void combine(String str, int idx, String result, ArrayList<String> list) {
        if (idx >= str.length() || idx < 0) {
            list.add(result);
            return;
        }
        
        int len = keypad[str.charAt(idx) - '0'].length();
        for (int i = 0; i < len; i++) {
            char c = keypad[str.charAt(idx) - '0'].charAt(i);
            combine(str, idx + 1, result + c, list);
        }
    }
    
    public static ArrayList<String> getCombinations(String str) {
        ArrayList<String> combinations = new ArrayList<>();
        combine(str, 0, "", combinations);
        return combinations;
    }
    
    public static void main(String[] args) {
        String str = "689";
        System.out.println("\nCombinations for the sequence: " + str);
        
        ArrayList<String> list = getCombinations(str);
        System.out.println("Total combinations: " + list.size());
        System.out.println(list);
    }
}