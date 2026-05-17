// Linear Search: Sequentially checks each element until target is found
// Time: O(n), Space: O(1)

import java.io.IOException;

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        int[] data = DatasetReader.readDataset("../large_dataset.txt");
        int target = 88;
        int result = linearSearch(data, target);
        System.out.println("Target " + target + " found at index: " + result);
    }
}