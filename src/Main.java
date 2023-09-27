public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();

        /*
        tree.add(5, 105);
        tree.add(2, 102);
        tree.add(7, 107);
        tree.add(1, 101);
        tree.add(6, 108);
        tree.add(12, 110);
        tree.add(11, 106);
        tree.add(10, 112);
        tree.add(13, 124);
         */
        int[] randomKeys = GenerateArray.unSorted(790, 1000);
        int[] randomValues = GenerateArray.unSorted(100, 10);
        for (int i = 0; i < 100; i++) {
            tree.add(randomKeys[i], randomValues[i]);
        }


        for (Node<Integer, Integer> i: tree) {
            System.out.println("next value " + i.key);
        }
    }

    private void testIterator(BinaryTree<Integer, Integer> tree) {

    }

}