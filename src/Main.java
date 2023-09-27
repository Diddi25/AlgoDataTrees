import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();

        tree.add(5, 105);
        tree.add(2, 102);
        tree.add(7, 107);
        tree.add(1, 101);
        tree.add(6, 108);
        tree.add(12, 110);
        tree.add(11, 106);
        tree.add(10, 112);
        tree.add(13, 124);


        //tree.print();

        /*
        for (Iterator<Node> it = iterator; it.hasNext(); ) {
            Node i = it.next();
            System.out.println("next value " + i.value);
        }

         */

        for (Integer i: tree) {
            System.out.println("next value " + i);
        }

    }

    private void testIterator() {

    }

}