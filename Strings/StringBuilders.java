/*
String Builders are MUTABLE.

If a string is modified, then it takes O(n) time,
where n = length of string
This is because, for each modification, modification is in the same string.

*/

package Strings;

public class StringBuilders {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            s1.append(ch);
        }
        System.out.println(s1);
        
        StringBuilder s2 = new StringBuilder("Hello");
        
        System.out.println(s2.append(s1));
        System.out.println(s1.length());
        
        int n = 10;
        String s3 = Integer.toString(n);
        s3 += "a";
        System.out.println(s3);
    }
}