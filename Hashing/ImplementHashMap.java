/*
LinkedHashMaps maintains the insertion order of elements, which is not in the case of HashMaps.

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

public class ImplementHashMap {
	public static class HashMaps<K, V> {
		private class Node {
			K key;
			V value;
			
			Node(K key, V value) {
				this.key = key;
				this.value = value;
			}
		}
		
		private LinkedList<Node>[] bucket;
		private int n, N;
		
		@SuppressWarnings("unchecked")
		public HashMaps() {
			this.bucket = new LinkedList[4];
			this.N = this.bucket.length;
			this.n = 0;
			for (int i = 0; i < this.N; i++) {
				this.bucket[i] = new LinkedList<>();
			}
		}
		
		private int hash(K key) {
			return Math.abs(key.hashCode() % this.N);
		}
		
		private int searchLL(K key, int bucketInd) {
			int dataInd = 0;
			LinkedList<Node> list = this.bucket[bucketInd];
			for (Node node : list) {
				if (node.key == key) {
					return dataInd;
				}
				++dataInd;
			}
			return -1;
		}
		
		@SuppressWarnings("unchecked")
		private void reHash() {
			LinkedList<Node>[] oldBucket = this.bucket;
			this.N *= 2;
			this.bucket = new LinkedList[N];
			for (int i = 0; i < this.N; i++) {
				bucket[i] = new LinkedList<>();
			}
			for (LinkedList<Node> list : oldBucket) {
				for (Node node : list) {
					this.put(node.key, node.value);
				}
			}
		}
		
		public void put(K key, V value) {
			int bucketInd = this.hash(key);
			int dataInd = this.searchLL(key, bucketInd);
			if (dataInd != -1) {
				this.bucket[bucketInd].get(dataInd).value = value;
			} else {
				this.bucket[bucketInd].add(new Node(key, value));
				++n;
			}
			double threshold = 2.0;
			double lambda = (double) n / N;
			if (lambda > threshold) {
				this.reHash();
			}
		}
		
		public boolean containsKey(K key) {
			int bucketInd = this.hash(key);
			int dataInd = this.searchLL(key, bucketInd);
			return dataInd != -1;
		}
		
		public V get(K key) {
			int bucketInd = this.hash(key);
			int dataInd = this.searchLL(key, bucketInd);
			if (dataInd != -1) {
				return this.bucket[bucketInd].get(dataInd).value;
			}
			return null;
		}
		
		public V remove(K key) {
			int bucketInd = this.hash(key);
			int dataInd = this.searchLL(key, bucketInd);
			if (dataInd != -1) {
				--n;
				return this.bucket[bucketInd].remove(dataInd).value;
			}
			return null;
		}
		
		public ArrayList<K> keySet() {
			ArrayList<K> keys = new ArrayList<>();
			for (LinkedList<Node> list : this.bucket) {
				for (Node node : list) {
					keys.add(node.key);
				}
			}
			return keys;
		}
		
		public boolean isEmpty() {
			return this.n == 0;
		}
		
		public int size() {
			return this.n;
		}
	}
	
	public static void main(String[] args) {
		HashMaps<String, Integer> map = new HashMaps<>();
		map.put("India", 100);
		map.put("France", 200);
		map.put("Germany", 300);
		map.put("United States", 400);
		
		ArrayList<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println("Key: " + key + "; Value: " + map.get(key));
		}
		
		System.out.println("\nSize: " + map.size());
		System.out.println("Contains key: " + map.containsKey("India"));
		System.out.println("Get value: " + map.get("India"));
		System.out.println("Remove key: " + map.remove("India"));
		System.out.println("Is empty: " + map.isEmpty() + "\n");
		ArrayList<String> newKeys = map.keySet();
		for (String key : newKeys) {
			System.out.println("Key: " + key + "; Value: " + map.get(key));
		}
	}
}