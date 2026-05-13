// Radix Sort: Sorts by processing individual digits using counting sort
// Time: O(d * (n + k)) where d is digits, Space: O(n + k)

using System;
using System.Linq;

class RadixSort {
    static void RadixSortFunc(int[] arr) {
        if (arr.Length == 0) return;

        int max = arr.Max();

        for (int exp = 1; max / exp > 0; exp *= 10) {
            CountingSortByDigit(arr, exp);
        }
    }

    static void CountingSortByDigit(int[] arr, int exp) {
        int n = arr.Length;
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

        Array.Copy(output, arr, n);
    }

    static void Main() {
        int[] data = {164, 29, 7, 190, 71, 63, 58, 36, 189, 27, 174, 140, 23, 152, 109, 9, 8, 24, 56, 60, 130, 155, 198, 144, 51, 167, 192, 108, 57, 115, 151, 72, 2, 41, 186, 88, 169, 40, 182, 87, 191, 183, 98, 25, 92, 89, 68, 12, 118, 138};
        RadixSortFunc(data);
        Console.WriteLine($"Sorted: {string.Join(", ", data)}");
    }
}