import java.util.Random;
public class GenerateArray {
    public static int[] sorted(int n, int range) {
        int[] sortedArray = new int[n];
        int next = new Random().nextInt(range);
        for (int i = 0; i < n; i++) {
            sortedArray[i] = next;
            next = new Random().nextInt(range) + 1;
        }
        return sortedArray;
    }
    public static int[] unSorted(int n, int range) {
        int[] unSortedArray = new int[n];
        for (int i = 0; i < n; i++) {
            unSortedArray[i] = new Random().nextInt(range);
        }
        return unSortedArray;
    }
}
