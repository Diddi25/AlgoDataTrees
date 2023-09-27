import java.util.Random;
public class GenerateArray {
    public static int[] unSorted(int n, int range) {
        int[] unSortedArray = new int[n];
        for (int i = 0; i < n; i++) {
            unSortedArray[i] = new Random().nextInt(range);
        }
        return unSortedArray;
    }
}
