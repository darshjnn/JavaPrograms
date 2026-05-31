/*
Find HCF of two numbers

*/

package Maths;

public class HCF {
    // Normal Zindagi
    public static int hcf(int n, int m) {
        if (n <= 1 || m <= 1) {
            return 1;
        }

        if (m > n) {
            for (int i = n; i > 0; i--) {
                if (m % i == 0) {
                    return i;
                }
            }
        }

        for (int i = m; i > 0; i--) {
            if (n % i == 0) {
                return i;
            }
        }

        return 1;
    }

    // Mentos Zindagi
    public static int hcfOptimized(int n, int m) {
        if (n >= m) {
            if (n % m == 0) {
                return m;
            }

            n = m % n;

            return hcfOptimized(m, n);
        } else {
            return hcfOptimized(m, n);
        }
    }

    public static void main(String[] args) {
        int x = 4;
        int y = 8;

        System.out.println(hcf(x, y));
        System.out.println(hcfOptimized(y, x));
    }
}