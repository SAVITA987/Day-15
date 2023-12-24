package HashTable;

import java.util.LinkedList;

	class MyMapNode<K, V> {
	    K key;
	    V value;

	    public MyMapNode(K key, V value) {
	        this.key = key;
	        this.value = value;
	    }
	}

	class MyHashTable<K, V> {
	    private LinkedList<MyMapNode<K, V>>[] buckets;

	    public MyHashTable(int size) {
	        this.buckets = new LinkedList[size];
	        for (int i = 0; i < size; i++) {
	            buckets[i] = new LinkedList<>();
	        }
	    }

	    public void insert(K key, V value) {
	        int index = getIndex(key);
	        LinkedList<MyMapNode<K, V>> list = buckets[index];

	        for (MyMapNode<K, V> node : list) {
	            if (node.key.equals(key)) {
	                node.value = value;
	                return;
	            }
	        }

	        list.add(new MyMapNode<>(key, value));
	    }

	    public V get(K key) {
	        int index = getIndex(key);
	        LinkedList<MyMapNode<K, V>> list = buckets[index];

	        for (MyMapNode<K, V> node : list) {
	            if (node.key.equals(key)) {
	                return node.value;
	            }
	        }
              return null; 
	    }

	    public void remove(K key) {
	        int index = getIndex(key);
	        LinkedList<MyMapNode<K, V>> list = buckets[index];

	        for (MyMapNode<K, V> node : list) {
	            if (node.key.equals(key)) {
	                list.remove(node);
	                return;
	            }
	        }
	    }

	    private int getIndex(K key) {
	        int hashCode = key.hashCode();
	        return Math.abs(hashCode) % buckets.length;
	    }
	}

	public class HashTableExample {

	    public static void main(String[] args) {
	        MyHashTable<String, Integer> wordFrequencyTable = new MyHashTable<>(10);
	        String sentence1 = "To be or not to be";
	        String[] words1 = sentence1.split(" ");

	        for (String word : words1) {
	            Integer frequency = wordFrequencyTable.get(word);
	            if (frequency == null) {
	                frequency = 1;
	            } else {
	                frequency++;
	            }
	            wordFrequencyTable.insert(word, frequency);
	        }

	        System.out.println("Use Case 1 - Word Frequency:");
	        System.out.println(wordFrequencyTable.get("To")); 
	        System.out.println(wordFrequencyTable.get("be")); 
	        System.out.println(wordFrequencyTable.get("or")); 

	        MyHashTable<String, Integer> paragraphFrequencyTable = new MyHashTable<>(20);
	        String paragraph = "Paranoids are not paranoid because they are paranoid but " +
	                "because they keep putting themselves deliberately into paranoid avoidable situations";
	        String[] words2 = paragraph.split(" ");

	        for (String word : words2) {
	            Integer frequency = paragraphFrequencyTable.get(word);
	            if (frequency == null) {
	                frequency = 1;
	            } else {
	                frequency++;
	            }
	            paragraphFrequencyTable.insert(word, frequency);
	        }

	        System.out.println("\nUse Case 2 - Word Frequency in Paragraph:");
	        System.out.println(paragraphFrequencyTable.get("Paranoids")); 
	        System.out.println(paragraphFrequencyTable.get("are")); 
	        System.out.println(paragraphFrequencyTable.get("not")); 
	        System.out.println(paragraphFrequencyTable.get("paranoid")); 

	        paragraphFrequencyTable.remove("avoidable");

	        System.out.println("\nUse Case 3 - Word Removal in Paragraph:");
	        System.out.println(paragraphFrequencyTable.get("avoidable"));
	        System.out.println(paragraphFrequencyTable.get("situations")); 
	    }
	}

