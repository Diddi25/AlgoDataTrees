import java.util.Iterator;

public class BinaryTree implements Iterable<Integer>{
    Node root;
    public BinaryTree() {
        root = null;
    }
    public Iterator<Integer> iterator() {
        return new TreeIterator(this.root);
    }

    public void add(Integer key, Integer value) {
        if(this.root == null) {
            this.root = new Node(key, value);
        } else {
            this.root.addInNodeClass(key,value);
        }
    }

    public boolean lookup(Integer key) {
        if (this.root == null) {
            return false;
        } else {
            this.root.contains(key);
        }
        return false;
    }

    public void remove(Integer key) {
        if(this.root == null) {
            //egen metod
        } else {

        }
    }


    /*
    @Override
    public int compareTo(K o) {
        return 0;
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
