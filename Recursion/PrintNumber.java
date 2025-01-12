package Recursion;

public class PrintNumber {
    public static void reverseOrder(int n) {
        if (n < 0) {
            return;
        }
        
        System.out.print(n + "  ");
        reverseOrder(n - 1);
    }
    
    public static void forwardOrder(int n) {
        if (n < 0) {
            return;
        }
        
        forwardOrder(n - 1);
        System.out.print(n + "  ");
    }
    
    public static void main(String[] args) {
        int n = 15;
        reverseOrder(n);
        
        System.out.println();
        
        forwardOrder(n);
    }
}