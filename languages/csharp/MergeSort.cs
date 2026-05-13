// Merge Sort: Divides array in half, recursively sorts, then merges sorted halves
// Time: O(n log n), Space: O(n)

using System;

class MergeSort {
    static void MergeSortFunc(int[] arr) {
        MergeSortHelper(arr, 0, arr.Length - 1);
    }

    static void MergeSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            MergeSortHelper(arr, left, mid);
            MergeSortHelper(arr, mid + 1, right);
            Merge(arr, left, mid, right);
        }
    }

    static void Merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int iIdx = 0, jIdx = 0, k = left;
        while (iIdx < n1 && jIdx < n2) {
            if (L[iIdx] <= R[jIdx]) {
                arr[k++] = L[iIdx++];
            } else {
                arr[k++] = R[jIdx++];
            }
        }

        while (iIdx < n1) arr[k++] = L[iIdx++];
        while (jIdx < n2) arr[k++] = R[jIdx++];
    }

    static void Main() {
        int[] data = {164, 29, 7, 190, 71, 63, 58, 36, 189, 27, 174, 140, 23, 152, 109, 9, 8, 24, 56, 60, 130, 155, 198, 144, 51, 167, 192, 108, 57, 115, 151, 72, 2, 41, 186, 88, 169, 40, 182, 87, 191, 183, 98, 25, 92, 89, 68, 12, 118, 138};
        MergeSortFunc(data);
        Console.WriteLine($"Sorted: {string.Join(", ", data)}");
    }
}