// Counting Sort: Counts occurrences of each value, reconstructs sorted array
// Time: O(n + k) where k is range, Space: O(k)

using System;
using System.Linq;

class CountingSort {
    static void CountingSortFunc(int[] arr) {
        if (arr.Length == 0) return;

        int max = arr.Max();
        int min = arr.Min();
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[arr.Length];

        foreach (int num in arr) {
            count[num - min]++;
        }

        for (int i = 1; i < count.Length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.Length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        Array.Copy(output, arr, arr.Length);
    }

    static void Main() {
        int[] data = {164, 29, 7, 190, 71, 63, 58, 36, 189, 27, 174, 140, 23, 152, 109, 9, 8, 24, 56, 60, 130, 155, 198, 144, 51, 167, 192, 108, 57, 115, 151, 72, 2, 41, 186, 88, 169, 40, 182, 87, 191, 183, 98, 25, 92, 89, 68, 12, 118, 138};
        CountingSortFunc(data);
        Console.WriteLine($"Sorted: {string.Join(", ", data)}");
    }
}