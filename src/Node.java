public class Node {
    public Integer key;
    public Integer value;
    public Node left, right;
    public Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
        this.left = this.right = null;
    }

    public void addi(Integer key,Integer value) {
        if (this.key.equals(key)) {
            this.value = value ;
            return;
        }
        if (this.key > key)
            if (this.left != null)
                this.left.addi(key, value);
            else
                this.left = new Node (key,value);
        else {
            if(this.right != null) {
                this.right.addi(key, value);
            } else {
                this.right = new Node(key, value);
            }
        }
    }

}
