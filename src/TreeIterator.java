import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {
    private Node next;
    private Stack<Node> stack;
    public TreeIterator(Node root) {
        this.next = root;
        Node preliminary = this.next;
        stack.push(preliminary.value);
        traverse(preliminary);
    }
    private void traverse(Node preliminary) {
        if (preliminary.left != null) {
            stack.push(preliminary.value);
            traverse(preliminary.left);
        }
        if (preliminary.right != null) {
            stack.push(preliminary.value);
            traverse(preliminary.right);
        }
    }
    @Override
    public boolean hasNext() {
        return stack.pop() != -1 ;
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
