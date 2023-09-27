import java.util.Iterator;

public class TreeIterator<K extends Comparable <K>,V> implements Iterator<Node<K,V>> {
    private final Stack<K,V> stack;
    public TreeIterator(Node<K,V> root) {
        this.stack = new Stack<>();
        pushAllLeftNodes(root);
    }
    private void pushAllLeftNodes(Node<K,V> current) {
        while(current != null) {
            stack.push(current);
            current = current.left;
        }
    }
    @Override
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }
    @Override
    public Node<K,V> next() {
        Node<K,V> current = stack.pop();
        pushAllLeftNodes(current.right);
        return current;
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
