/*
Tower of Hanoi

Object of the game is to move all the disks over to Tower 3 from Tower 1.
But, a larger disk cannot be placed onto a smaller disk.

*/

package Recursion;

public class TowerOfHanoi {
    public static void solveTower(int n, String src, String help, String des) {
        if (n <= 1) {
            System.out.println("Transfer Disk " + n + " from " + src + " to " + des);
            return;
        }

        solveTower(n - 1, src, des, help);

        System.out.println("Transfer Disk " + n + " from " + src + " to " + des);

        solveTower(n - 1, help, src, des);
    }

    public static void main(String[] args) {
        int n = 3;

        System.out.println();

        solveTower(n, "S", "H", "D");
        
    }
}