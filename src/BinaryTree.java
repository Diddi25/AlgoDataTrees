public class BinaryTree implements Iterable<Integer>{
    Node root;
    public BinaryTree() {
        root = null;
    }

    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }
    public void add(Integer key, Integer value) {
        Node nextNode = this.root;
        if (nextNode == null) { //om tree är empty()
            this.root = new Node(key, value);
        }
        if (nextNode.key == key) { //om nod har samma keyvärde
            nextNode.value = value;
            return;
        }

        if (nextNode.key < key) { //om nod just nu är till vänster
            if(nextNode == null) {
                nextNode = new Node(key, value);
            } else {
                nextNode = nextNode.left;
            }
        } else { //om nod just nu är till höger
            if(nextNode == null) {
                nextNode = new Node(key, value);
            } else {
                nextNode = nextNode.right;
            }
        }
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
        if (traverseNode.key < key) {
            if (traverseNode.left == null) {
                return traverseNode;
            } else {
                traverse(key, traverseNode.left);
            }
        } else {
            if (traverseNode.right == null) {
                return traverseNode;
            } else {
                traverse(key, traverseNode.right);
            }
        }
        return null;
    }


}
