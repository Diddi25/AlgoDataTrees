
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(7,105);
        tree.add(2,102);
        tree.add(10,107);
        tree.add(1,101);
        tree.add(11,108);
        tree.add(9,106);
        tree.add(8,103);

        tree.remove(10);

        for (int i : tree) {
            System.out.println("next value " + i);
        }
    }

    private void testIterator() {

    }

}