/*
Binary Strings Problem

Given an integer N , Print all binary strings of size N which do not contain consecutive 1s.

Example 1:
Input: N = 3
Output: [000 , 001 , 010 , 100 , 101]
Explanation: None of the above strings contain consecutive 1s. "110" is not an answer as
it has '1's occurring consecutively.

*/

package Recursion;

import java.util.ArrayList;

public class BinaryStrings {
    public static void binaryString(ArrayList<String> list, String str, int n) {
        if (n == 0) {
            list.add(str);
            return;
        }

        if (str.isEmpty()) {
            binaryString(list, str + "0", n - 1);
            binaryString(list, str + "1", n - 1);
        } else {
            if (str.charAt(str.length() - 1) == '0') {
                binaryString(list, str + "0", n - 1);
                binaryString(list, str + "1", n - 1);
            } else {
                binaryString(list, str + "0", n - 1);
            }
        }
    }

    public static ArrayList<String> generateBinaryStrings(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        ArrayList<String> list = new ArrayList<>();
        binaryString(list, "", n);
        return list;
    }

    public static void main(String[] args) {
        int n = 3;
        ArrayList<String> list = generateBinaryStrings(n);

        System.out.println("\nBinary Strings of length " + n + " without consecutive 1s: ");
        System.out.println(list);
    }
}
