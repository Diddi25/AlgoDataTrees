import java.util.Iterator;

public class BinaryTree implements Iterable<Integer>{
    Node root;
    public BinaryTree() {
        root = null;
    }
    public Iterator<Integer> iterator() {
        return new TreeIterator(this.root);
    }
    public void add(Integer key, Integer value, int valuable) {
        Node nextNode = this.root;
        if (nextNode == null) { //om tree är empty()
            this.root = new Node(key, value);
            return;
        }
        Node leafParent = traverse(key, nextNode);
        if(leafParent.key.equals(key)) {

        }
        if(key < leafParent.key) {
            leafParent.left = new Node(key, value);
        } else {
            leafParent.right = new Node(key, value);
        }
    }
    public void add(Integer key, Integer value) {
        if(this.root == null) {
            this.root = new Node(key, value);
        } else {
            this.root.addi(key,value);
        }
    }
    private Node traverse(Integer key, Node traverseNode) {
        if (traverseNode.key.equals(key)) { //om nod har samma keyvärde
            return traverseNode;
        }
        if (traverseNode.key > key) {
            if (traverseNode.left == null || traverseNode.right == null) {
                return traverseNode;
            } else {
                traverse(key, traverseNode.left);
            }
        } else {
            if (traverseNode.left == null || traverseNode.right == null) {
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

    /*
    @Override
    public int compareTo(K o) {
        return 0;
    }
    */

    /*
    public void remove(Integer key) {
        Node nextNode = this.root;
        if(lookup(key)) {
            if (nextNode.key.equals(key)) {
                nextNode.right
                this.root =
            } else if (nextNode.key < key) {
                if (nextNode.left == null) {
                    return false;
                } else if (nextNode.right == null) {
                    return false;
                } else {
                    search(key, nextNode.left);
                }
            } else {
                if (nextNode.left == null) {
                    return false;
                } else if (nextNode.right == null) {
                    return false;
                } else {
                    search(key, nextNode.right);
                }
            }
        }
    }
    */
    /*
    public Node remove(Integer key) {
        if(key == key) {
            if(key > key) {
                if(left != null) {
                    left = left.delete(key);
                }
                return this;
            } else {
                if(right != null) {
                    right = right.delete(key);
                }
                return this;
            }
        }
    }
    */

}
