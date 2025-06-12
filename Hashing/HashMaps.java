/*
LinkedHashMaps maintains the insertion order of elements, which is not in the case of HashMaps.
Performance of LinkedHashMaps in less than HashMaps because of the operations performed to
maintain the insertion order of the elements; although, time complexity remains the same.

In TreeMaps, keys are sorted, due to which Time Complexity of insertion, deletion and getting the
element node is O(logn), which is O(1) or O(lambda) in case of HashMaps or LinkedHashMaps.

The Worst Time Complexity of HashMaps can be O(n) in some rare cases when all the nodes are added
on the same bucket index. But in most cases, it is O(1) or O(lambda).

Singly Linked Lists are used to implement HashMaps.
Doubly Linked Lists are used to implement LinkedHashMaps.
Red-Black Trees are used to implement TreeMaps.

*/


package Hashing;

import java.util.*;

public class HashMaps {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		
		// Insertion
		map.put("India", 120);
		map.put("France", 80);
		map.put("Germany", 50);
		
		System.out.println(map);
		
		// Update
		// map.put() creates new pair if the key is not present.
		// If the key is already present, then it updates that key with new value.
		map.put("France", 55);
		
		// Search or Lookup for a key
		if (map.containsKey("India")) {
			System.out.println("Key is present");
		} else {
			System.out.println("Key is not present");
		}
		
		System.out.println();
		
		// Search or Lookup for value corresponding to the key
		System.out.println(map.get("India"));
		System.out.println(map.get("Indonesia"));
		
		System.out.println();
		
		// Iterate
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		System.out.println();
		
		// Another way to Iterate
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
		
		System.out.println();
		
		// Removing key
		map.remove("India");
	}
}