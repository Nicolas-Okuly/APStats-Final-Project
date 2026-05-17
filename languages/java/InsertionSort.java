// Insertion Sort: Builds sorted array one element at a time by inserting into correct position
// Time: O(n^2), Space: O(1)

import java.io.IOException;
import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) throws IOException {
        int[] data = DatasetReader.readDataset("../large_dataset.txt");
        insertionSort(data);
        System.out.println("Sorted: " + Arrays.toString(data));
    }
}