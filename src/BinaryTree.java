import java.util.Iterator;
public class BinaryTree<K extends Comparable<K>, V> implements Iterable<Node<K,V>>{
    Node<K,V> root;
    public BinaryTree() {
        root = null;
    }
    public Iterator<Node<K,V>> iterator() {
        return new TreeIterator<>(this.root);
    }
    public void add(K key, V value) {
        if(this.root == null) {
            this.root = new Node<>(key, value);
        } else {
            this.root.addInNodeClass(key,value);
        }
    }
    public boolean lookup(K key) {
        if (this.root == null) {
            return false;
        } else {
            return this.root.contains(key);
        }
    }
    public void remove(K key) {
        if (this.root == null) {
            return;
        } else {
            this.root.delete(key);
        }
    }

}