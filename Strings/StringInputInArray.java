package Strings;

import java.util.*;

public class StringInputInArray {
    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){
            int s, i;
            
            System.out.print("Enter Size of the array: ");
            s = sc.nextInt();
            
            String[] ar = new String[s];
            
            System.out.println("Enter elements: ");
            for(i=0; i<s; i++){
                ar[i] = sc.next();
            }
            
            System.out.println("You entered: ");
            for(i=0; i<s; i++){
                System.out.print(ar[i]);
            }
        }        
    }
}
