import java.util.Iterator;

public class BinaryTree implements Iterable<Integer>{
    Node root;
    public BinaryTree() {
        root = null;
    }
    public Node getRoot() {
        return this.root;
    }
    public Iterator<Integer> iterator() {
        return new TreeIterator(this.root);
    }
    public void add(Integer key, Integer value) {
        Node nextNode = this.root;
        if (nextNode == null) { //om tree är empty()
            this.root = new Node(key, value);
            return;
        }
        if (nextNode.key.equals(key)) { //om nod har samma keyvärde
            nextNode.value = value;
            return;
        }
        Node leaf = traverse(key, nextNode);
        leaf = new Node(key, value);
    }
    private Node traverse(Integer key, Node traverseNode) {
        if (traverseNode.key < key) {
            if (traverseNode.left == null) {
                return traverseNode;
            } else if (traverseNode.right == null) {
                return traverseNode;
            } else {
                traverse(key, traverseNode.left);
            }
        } else {
            if (traverseNode.left == null) {
                return traverseNode;
            } else if (traverseNode.right == null) {
                return traverseNode;
            } else {
                traverse(key, traverseNode.right);
            }
        }
        return null;
    }
    public boolean lookup(Integer key) {
        Node nextNode = this.root;
        return search(key, nextNode);
    }
    private boolean search(Integer key, Node traverseNode) {
        if (traverseNode.key.equals(key)) {
            return true;
        } else if (traverseNode.key < key) {
            if (traverseNode.left == null) {
                return false;
            } else if (traverseNode.right == null) {
                return false;
            } else {
                search(key, traverseNode.left);
            }
        } else {
            if (traverseNode.left == null) {
                return false;
            } else if (traverseNode.right == null) {
                return false;
            } else {
                search(key, traverseNode.right);
            }
        }
        return false;
    }

}
