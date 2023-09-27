public class Node<K extends Comparable<K>, V> implements Comparable<K> {
    public K key;
    public V value;
    public Node<K,V> left, right;
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = this.right = null;
    }
    public void addInNodeClass(K key,V value) {
        if (this.key.equals(key)) {
            this.value = value ;
            return;
        }
        if (this.compareTo(key) > 0) {
            if (this.left == null) {
                this.left = new Node<>(key, value);
            } else {
                this.left.addInNodeClass(key, value);
            }
        } else {
            if (this.right == null) {
                this.right = new Node<>(key, value);
            } else {
                this.right.addInNodeClass(key, value);
            }
        }
    }

    public boolean contains(K key) {
        if (this.key.equals(key)) {
            return true;
        }
        if (this.compareTo(key) > 0) {
            if (this.left == null) {
                return false;
            } else {
                return this.left.contains(key);
            }
        } else {
            if (this.right == null) {
                return false;
            } else {
                return this.right.contains(key);
            }
        }
    }
    public void delete(K key) {
        if (this.left.key.equals(key)) {
            Node<K,V> foundedLargestKey = this.left.left.findLargestLeafInLeft();
            if (foundedLargestKey != null) {
                Node<K, V> save2right = this.left.right;
                Node<K, V> save2left = this.left.left;
                this.left = foundedLargestKey;
                this.left.left = save2left;
                this.left.right = save2right;
            }
            return;
        }
        if (this.right.key.equals(key)) {
            Node<K,V> foundedSmallestKey = this.right.right.findSmallestLeafInRight();
            if (foundedSmallestKey != null) {
                Node<K,V> save2Right = this.right.right;
                Node<K,V> save2Left = this.right.left;
                this.right = foundedSmallestKey;
                this.right.right = save2Right;
                this.right.left = save2Left;
            }
            return;
        }
        if (this.compareTo(key) > 0) {
            if (this.left == null) {
                return;
            } else {
                this.left.delete(key);
            }
        } else {
            if (this.right == null) {
                return;
            } else {
                this.right.delete(key);
            }
        }
    }
    private Node<K,V> findSmallestLeafInRight() {
        if (this.left.left == null) {
            return this.left;
        } else {
            return this.left.findSmallestLeafInRight();
        }
    }

    private Node<K,V> findLargestLeafInLeft() {
        if (this.right.right == null) {
            return this.right;
        } else {
            return this.right.findLargestLeafInLeft();
        }
    }

    @Override
    public int compareTo(K otherKey) {
        return this.key.compareTo(otherKey);
    }
}
