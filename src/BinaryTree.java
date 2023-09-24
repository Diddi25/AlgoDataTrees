public class BinaryTree implements Iterable<Integer>{
    Node root;
    public BinaryTree() {
        root = null;
    }

    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }


}
