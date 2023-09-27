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

        for(int n: treeSizes) {
            int[] randomKeys = GenerateArray.unSorted(n, 10);
            int[] randomValues = GenerateArray.unSorted(n, 100);
            int[] randomLookupElements = GenerateArray.unSorted(n, 100);
            BinaryTree<Integer, Integer> tree = new BinaryTree<>();

            restoreMinAndMax();
            System.out.printf("%5d", n);
            float min1 = benchmarkAddMethod(tree, randomKeys, randomValues, n);
            System.out.printf("%10.0f", min1);

            restoreMinAndMax();
            float min2 = benchmarkLookup(tree, randomLookupElements);
            System.out.printf("%10.0f", min2);

            restoreMinAndMax();
            float min3 = benchmarkTraverse(tree);
            System.out.printf("%10.0f\n", min3);
        }
    }
    private static float benchmarkAddMethod(BinaryTree<Integer, Integer> tree, int[] randomKeys, int[] randomValues, int n) {
        for (int i = 0; i < tries; i++) {
            long t0 = System.nanoTime();
            for (int j = 0; j < n; j++) {
                tree.add(randomKeys[j], randomValues[j]);
            }
            long t1 = System.nanoTime();
            long t = t1 - t0;
            if(t < min) {
                min = t;
            }
            if(t > max) {
                max = t;
            }
        }
        return (max + min) / 2;
    }
    private static float benchmarkLookup(BinaryTree<Integer, Integer> tree, int[] randomLookupElements) {
        for (int i = 0; i < tries; i++) {
            long t0 = System.nanoTime();
            tree.lookup(randomLookupElements[i]);
            long t1 = System.nanoTime();
            long t = t1 - t0;
            if(t < min) {
                min = t;
            }
            if(t > max) {
                max = t;
            }
        }
        return (max + min) / 2;
    }
    private static float benchmarkTraverse(BinaryTree<Integer, Integer> tree) {
        for (int i = 0; i < tries; i++) {
            long t0 = System.nanoTime();
            for (Node<Integer, Integer> j: tree) {
                //System.out.println("next value " + j.value);
            }
            long t1 = System.nanoTime();
            long t = t1 - t0;
            if(t < min) {
                min = t;
            }
            if(t > max) {
                max = t;
            }
        }
        return (max + min) / 2;
    }
    private static void restoreMinAndMax() {
        min = Float.POSITIVE_INFINITY;
        max = -1;
    }
}
