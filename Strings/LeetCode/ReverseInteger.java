/*
7. Reverse Integer

Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1],
then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21

*/

package Strings.LeetCode;

public class ReverseInteger {
	public static int reverse(int x) {
		long num = 0;
		
		while (x != 0) {
			int pop = x % 10;
			x = x / 10;
			num = (num * 10) + pop;
		}
		
		if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
			return 0;
		}
		
		return (int) num;
	}
	
	public static void main(String[] args) {
		int x = -123;
		int rev = reverse(x);
		System.out.println(rev);
	}
}

/*
Alternate Approach:

class Solution {
    public int reverse(int x) {
        int rev = 0;
        
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            
            rev = rev * 10 + pop;
        }
        
        return rev;
    }
}
 */