public class Benchmark {
    public static void main(String[] args) {
        System.out.printf("#%4s%8s%12s%15s\n", "n", "add()", "lookup()", "traverse()\n");
        benchmark();
    }
    private static final int tries = 20;
    private static float min = Float.POSITIVE_INFINITY;
    private static float max = -1;
    private static void benchmark() {
        int[] treeSizes = {100, 250, 500, 1000, 2500, 4000, 5500};
        for(int treeSize: treeSizes) {
            System.out.printf("%5d", treeSize);
            float min1 = benchmarkAddMethod(treeSize);
            System.out.printf("%10.0f", min1);

            restoreMinAndMax();
            float min2 = benchmarkLookup(treeSize);
            System.out.printf("%10.0f", min2);

            restoreMinAndMax();
            float min3 = benchmarkTraverse(treeSize);
            System.out.printf("%10.0f\n", min3);
        }
    }
    private static BinaryTree<Integer, Integer> fillTreeWithNewNodes(int treeSize) {
        int[] randomKeys = GenerateArray.unSorted(treeSize, 100);
        int[] randomValues = GenerateArray.unSorted(treeSize, 10);
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int i = 0; i < treeSize; i++) {
            tree.add(randomKeys[i], randomValues[i]);
        }
        return tree;
    }
    private static float benchmarkAddMethod(int treeSize) {
        float takeTime = 0;
        for (int i = 0; i < tries; i++) {
            int[] randomKeys = GenerateArray.unSorted(treeSize, 1000);
            int[] randomValues = GenerateArray.unSorted(treeSize, 10);
            BinaryTree<Integer, Integer> tree = new BinaryTree<>();
            long t0 = System.nanoTime();
            for (int j = 0; j < treeSize; j++) {
                tree.add(randomKeys[j], randomValues[j]);
            }
            long t1 = System.nanoTime();
            takeTime = averageTime(t1 - t0);
        }
        return takeTime;
    }
    private static float benchmarkLookup(int treeSize) {
        long t0 = 0;
        long t1 = 0;
        float takeTime = 0;
        for (int i = 0; i < tries; i++) {
            int[] randomLookupElements = GenerateArray.unSorted(treeSize, 1000);
            BinaryTree<Integer, Integer> tree = fillTreeWithNewNodes(treeSize);
            for (int j = 0; j < treeSize; j++) {
                t0 = System.nanoTime();
                tree.lookup(randomLookupElements[j]);
                t1 = System.nanoTime();
            }
            takeTime = averageTime(t1 - t0);
        }
        return takeTime;
    }
    private static float benchmarkTraverse(int n) {
        float takeTime = 0;
        for (int i = 0; i < tries; i++) {
            BinaryTree<Integer, Integer> tree = fillTreeWithNewNodes(n);
            long t0 = System.nanoTime();
            for (Node<Integer, Integer> j: tree) {
                Integer value = j.value;
                //System.out.println("next value " + j.value);
            }
            long t1 = System.nanoTime();
            takeTime = averageTime(t1 - t0);
        }
        return takeTime;
    }
    private static float averageTime(long t) {
        if (t < min) {
            min = t;
        }
        if (t > max) {
            max = t;
        }
        return (max + min) / 2;
    }
    private static void restoreMinAndMax() {
        min = Float.POSITIVE_INFINITY;
        max = -1;
    }
}
