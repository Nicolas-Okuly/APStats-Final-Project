// Binary Search: Divides sorted array in half repeatedly to find target
// Time: O(log n), Space: O(1)

import java.io.IOException;
import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) throws IOException {
        int[] data = DatasetReader.readDataset("../large_dataset.txt");
        Arrays.sort(data);
        int target = 88;
        int result = binarySearch(data, target);
        System.out.println("Target " + target + " found at index: " + result);
    }
}