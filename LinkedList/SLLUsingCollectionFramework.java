/*
Single Linked List using Collection Framework

*/

package LinkedList;

import java.util.LinkedList;

public class SLLUsingCollectionFramework {
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>();
        
        list.addFirst("a");
        list.addFirst("is");
        System.out.println(list);
        
        list.addFirst("this");
        list.addLast("list");
        System.out.println(list);
        System.out.println(list.size());
	    
	    for (String s : list) {
		    System.out.print(s + " -> ");
	    }
        System.out.println("null");

         list.removeFirst();
         System.out.println(list);

         list.removeLast();
         System.out.println(list);

        list.remove(2);
        System.out.println(list);
    }
}
