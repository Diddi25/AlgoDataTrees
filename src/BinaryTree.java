import java.util.Iterator;

public class BinaryTree<T> implements Iterable<Integer>{
    Node<K,V> root;
    public BinaryTree() {
        root = null;
    }
    public Iterator<Integer> iterator() {
        return new TreeIterator(this.root);
    }
    public <K,V> void add(K key, V value) {
        if(this.root == null) {
            this.root = new Node<K,V>(key, value);
        } else {
            this.root.addInNodeClass(key,value);
        }
    }
    public boolean lookup(Integer key) {
        if (this.root == null) {
            return false;
        } else {
            this.root.contains(key);
        }
        return false;
    }
    public void remove(Integer key) {
        if (this.root == null) {
            return;
        } else {
            this.root.delete(key);
        }
    }

}
