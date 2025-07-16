/*
71. Simplify Path

You are given an absolute path for a Unix-style file system, which always begins with a slash '/'.
Your task is to transform this absolute path into its simplified canonical path.

The rules of a Unix-style file system are as follows:
A single period '.' represents the current directory.
A double period '..' represents the previous/parent directory.
Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
Any sequence of periods that does not match the rules above should be treated as a valid
directory or file name. For example, '...' and '....' are valid directory or file names.

The simplified canonical path should follow these rules:
The path must start with a single slash '/'.
Directories within the path must be separated by exactly one slash '/'.
The path must not end with a slash '/', unless it is the root directory.
The path must not have any single or double periods ('.' and '..') used to denote current or
parent directories.

Return the simplified canonical path.

Example 1:
Input: path = "/home/"
Output: "/home"
Explanation: The trailing slash should be removed.

Example 2:
Input: path = "/home//foo/"
Output: "/home/foo"
Explanation: Multiple consecutive slashes are replaced by a single one.

Example 3:
Input: path = "/home/user/Documents/../Pictures"
Output: "/home/user/Pictures"
Explanation: A double period ".." refers to the directory up a level (the parent directory).

Example 4:
Input: path = "/../"
Output: "/"
Explanation: Going one level up from the root directory is not possible.

Example 5:
Input: path = "/.../a/../b/c/../d/./"
Output: "/.../b/d"
Explanation: "..." is a valid name for a directory in this problem.

*/

package Stacks.LeetCode;

import java.util.*;

public class SimplifyPath {
    @SuppressWarnings("UnnecessaryContinue")
    public static String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (String s : arr) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (s.equals(".") || s.isEmpty()) {
                continue;
            } else {
                stack.push(s);
            }
        }
        
        int i = 0;
        while (!stack.isEmpty()) {
            arr[i++] = stack.pop();
        }
        
        StringBuilder result = new StringBuilder();
        result.append("/");
        
        for (int j = i - 1; j >= 0; j--) {
            result.append(arr[j]);
            if (j != 0) {
                result.append("/");
            }
        }
        
        /*
        A Simpler way:
        
        for (String c: stack) {
        result.append(c);
        result.append("/");
        }
        
        return result.substring(0, result.length() - 1).toString();
        
        */
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        String path = "/a//./b/../../c/";
        System.out.println(path);
        System.out.println(simplifyPath(path));
    }
}