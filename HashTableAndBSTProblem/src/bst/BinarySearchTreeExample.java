package bst;

class MyBinaryNode<K extends Comparable<K>> {
    K key;
    MyBinaryNode<K> left;
    MyBinaryNode<K> right;

    public MyBinaryNode(K key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

class MyBinarySearchTree<K extends Comparable<K>> {
    private MyBinaryNode<K> root;

    public void add(K key) {
        this.root = addRecursively(root, key);
    }

    private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key) {
        if (current == null) {
            return new MyBinaryNode<>(key);
        }

        if (key.compareTo(current.key) < 0) {
            current.left = addRecursively(current.left, key);
        } else if (key.compareTo(current.key) > 0) {
            current.right = addRecursively(current.right, key);
        }

        return current;
    }

    public int size() {
        return sizeRecursively(root);
    }

    private int sizeRecursively(MyBinaryNode<K> current) {
        return current == null ? 0 : 1 + sizeRecursively(current.left) + sizeRecursively(current.right);
    }

    public boolean search(K key) {
        return searchRecursively(root, key);
    }

    private boolean searchRecursively(MyBinaryNode<K> current, K key) {
        if (current == null) {
            return false;
        }

        if (key.equals(current.key)) {
            return true;
        } else if (key.compareTo(current.key) < 0) {
            return searchRecursively(current.left, key);
        } else {
            return searchRecursively(current.right, key);
        }
    }
}

public class BinarySearchTreeExample {

    public static void main(String[] args) {
        MyBinarySearchTree<Integer> bst1 = new MyBinarySearchTree<>();
        bst1.add(56);
        bst1.add(30);
        bst1.add(70);
        System.out.println("Size of BST1: " + bst1.size());

        MyBinarySearchTree<Integer> bst2 = new MyBinarySearchTree<>();
        bst2.add(56);
        bst2.add(30);
        bst2.add(70);
        bst2.add(22);
        bst2.add(40);
        bst2.add(11);
        bst2.add(3);
        bst2.add(16);
        bst2.add(60);
        bst2.add(95);
        bst2.add(65);
        bst2.add(63);
        bst2.add(67);

        System.out.println("\nSize of BST2: " + bst2.size());

        boolean isKeyPresent = bst2.search(63);
        System.out.println("\nIs 63 present in BST2 " + isKeyPresent); 
    }
}

