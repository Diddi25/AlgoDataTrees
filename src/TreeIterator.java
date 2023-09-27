import java.util.Iterator;

public class TreeIterator implements Iterator<Node> {
    private Node next;
    private Stack<Node> stack;
    public TreeIterator(Node root) {
        this.next = root;
        this.stack = new Stack<>();
        pushAllLeftNodes(this.next);
    }
    private void pushAllLeftNodes(Node current) {
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
    public Node next() {
        Node current = stack.pop();
        pushAllLeftNodes(current.right);
        return current;
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
