import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {
    private Node next;
    private Stack<Node> stack;
    public TreeIterator(Node root) {
        this.next = root;
        this.stack = new Stack<>();
        //newAttempt(this.next);
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
        return this.stack.isEmpty();
    }
    @Override
    public Integer next() {
        Integer item = null;
        do {
            if (this.next != null) {
                this.stack.push(this.next.value);
                this.next = this.next.left;
            } else {
                this.next.value = stack.pop();
                item = this.next.value;
                break;
            }
        } while (!this.stack.isEmpty());
        return item;
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
