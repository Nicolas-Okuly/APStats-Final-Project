// Counting Sort: Counts occurrences of each value, reconstructs sorted array
// Time: O(n + k) where k is range, Space: O(k)

import java.io.IOException;
import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int num : arr) {
            count[num - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) throws IOException {
        int[] data = DatasetReader.readDataset("../large_dataset.txt");
        countingSort(data);
        System.out.println("Sorted: " + Arrays.toString(data));
    }
}