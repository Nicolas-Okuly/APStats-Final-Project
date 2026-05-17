// Radix Sort: Sorts by processing individual digits using counting sort
// Time: O(d * (n + k)) where d is digits, Space: O(n + k)

import java.io.IOException;
import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] arr) {
        if (arr.length == 0) return;

        int max = Arrays.stream(arr).max().getAsInt();

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) throws IOException {
        int[] data = DatasetReader.readDataset("../large_dataset.txt");
        radixSort(data);
        System.out.println("Sorted: " + Arrays.toString(data));
    }
}