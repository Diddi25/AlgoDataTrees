import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {
    private Node next;
    private Stack<Node> stack;
    public TreeIterator(Node root) {
        this.next = root;
        this.stack = new Stack<>();
        newAttempt(this.next);
    }
    private void newAttempt(Node current) {
        if(current == null) {
            return;
        }
        newAttempt(current.left);
        stack.push(current.value);
        newAttempt(current.right);
    }
    @Override
    public boolean hasNext() {
        return stack.pop() != -1 || next != null;
    }
    @Override
    public Integer next() {
        return stack.pop();
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
