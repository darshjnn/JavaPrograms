/*
Friends Pairing Problem

Given n friends, each one can remain single or can be paired up with some other friend. 
Each friend can be paired only once. Find out the total number of ways in which friends can
remain single or can be paired up.

Example:
Input  : n = 3
Output : 4
Explanation:
{1}, {2}, {3} : all single
{1}, {2, 3} : 2 and 3 paired but 1 is single.
{1, 2}, {3} : 1 and 2 are paired but 3 is single.
{1, 3}, {2} : 1 and 3 are paired but 2 is single.
Note that {1, 2} and {2, 1} are considered same.

*/

package Recursion;

public class FriendsPairing {
    public static int friendsPair(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int singlePersons = friendsPair(n - 1);
        int pairedPersons = (n - 1) * friendsPair(n - 2);

        return singlePersons + pairedPersons;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.print("\nTotal ways to pair " + n + " friends: ");
        
        System.out.println(friendsPair(n) + "\n");
    }
}
