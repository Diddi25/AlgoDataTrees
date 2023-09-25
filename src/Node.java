public class Node {
    public Integer key;
    public Integer value;
    public Node left, right;
    public Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
        this.left = this.right = null;
    }

    public void addInNodeClass(Integer key,Integer value) {
        if (this.key.equals(key)) {
            this.value = value ;
            return;
        }
        if (this.key > key) {
            if (this.left == null) {
                this.left = new Node(key, value);
            } else {
                this.left.addInNodeClass(key, value);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(key, value);
            } else {
                this.right.addInNodeClass(key, value);
            }
        }
    }

    public boolean contains(Integer key) {
        if (this.key.equals(key)) {
            return true;
        }
        if (this.key > key) {
            if (this.left == null) {
                return false;
            } else {
                this.left.contains(key);
            }
        } else {
            if (this.right == null) {
                return false;
            } else {
                this.right.contains(key);
            }
        }
        return false;
    }

}
