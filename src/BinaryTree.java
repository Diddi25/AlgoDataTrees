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
        Node nextNode = root;
        if(nextNode == null) {
            newNode = newNode;
        }
        if(nextNode.key.equals(key)) {
            nextNode.value = newNode.value;
        }
    }
    public boolean lookup(Integer key) {
        Node nextNode = root;
        while(nextNode != null) {
            if(nextNode.key < key) {
                nextNode = nextNode.left;
                if(nextNode.key == key) {
                    return true;
                }
            }
            if(nextNode.key > key) {
                nextNode = nextNode.right;
                if(nextNode.key == key) {
                    return true;
                }
            }
        }
        return false;
    }

    private Node traverse(Integer key) {
        int pointer = 0;

    }


}
