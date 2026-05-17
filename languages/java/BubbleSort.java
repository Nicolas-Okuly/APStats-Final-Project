// Bubble Sort: Repeatedly swaps adjacent elements if they're in wrong order
// Time: O(n^2), Space: O(1)

import java.io.IOException;
import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) throws IOException {
        int[] data = DatasetReader.readDataset("../large_dataset.txt");
        bubbleSort(data);
        System.out.println("Sorted: " + Arrays.toString(data));
    }
}