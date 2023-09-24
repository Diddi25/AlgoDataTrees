public class BinaryTree implements Iterable<Integer>{
    Node root;
    public BinaryTree() {
        root = null;
    }

    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }
    public void add(Integer key, Integer value) {
        Node newNode = new Node(key, value);
        Node nextNode = this.root;
        if(nextNode == null) {
            this.root = newNode;
        }
        Node foundedNode = traverse(key, nextNode);
        foundedNode.right = nextNode;
    }
    public boolean lookup(Integer key) {
        Node nextNode = this.root;
        Node foundedNode = traverse(key, nextNode);
        if(foundedNode == null){
            return false;
        } else {
            return true;
        }
    }

    private Node traverse(Integer key, Node traverseNode) {
        if(traverseNode.key < key) {
            if (traverseNode.left == null) {
                return traverseNode;
            } else {
                traverse(key, traverseNode.left);
            }
        } else {
            if(traverseNode.right == null) {
                return traverseNode;
            } else {
                traverse(key, traverseNode.right);
            }
        }
        return null;
    }


}
