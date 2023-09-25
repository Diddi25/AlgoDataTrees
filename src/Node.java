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
    public void delete(Integer key) {
        if (this.left.key.equals(key)) {
            Node foundedSmallestKey = this.right.findSmallest();
            if(foundedSmallestKey == null) {
                return;
            } else {
                this.key = foundedSmallestKey.key;
                this.value = foundedSmallestKey.value;
                this.left = this.left.left;
                this.right = this.right.right;
                return;
            }
        }
        if (this.right.key.equals(key)) {
            Node foundedSmallestKey = this.right.left.findSmallest();
            if(foundedSmallestKey == null) {
                return;
            } else {
                this.key = foundedSmallestKey.key;
                this.value = foundedSmallestKey.value;
                this.left = this.left.left;
                this.right = this.right.right;
                return;
            }
        }
        if (this.key > key) {
            if (this.left == null) {
                return;
            } else {
                this.left.delete(key);
            }
        } else {
            if (this.right == null) {
                return;
            } else {
                this.right.delete(key);
            }
        }
    }
    private Node findSmallest() {
        if (this.left == null) {
            return this;
        } else {
            this.left.findSmallest();
        }
        return null;
    }
    public void deleteNr2(Integer key) {
        if (this.key.equals(key)) {
            Node whatDoIDoWithThis = this.promote();
        } else {
            if(this.key > key) {
                if(this.left == null) {
                    return; //didnt find that integer to the left
                } else {
                    this.delete(key);
                }
            } else {
                if(this.right == null) {
                    return; //didnt find that integer to the right
                } else {
                    this.delete(key);
                }
            }
        }
    }
    private Node promote() {
        if (this.left == null) {
            return this;
        }
        Node current = this;
        while (current.left.left != null) {
            current = current.left;
        }
        Node aNode = current.left;
        current.left = current.left.right;
        aNode.right = this;
        return aNode;
    }

}
