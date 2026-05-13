// Binary Search: Divides sorted array in half repeatedly to find target
// Time: O(log n), Space: O(1)

package main

import (
    "fmt"
    "sort"
)

func binarySearch(arr []int, target int) int {
    left, right := 0, len(arr)-1

    for left <= right {
        mid := left + (right-left)/2
        if arr[mid] == target {
            return mid
        } else if arr[mid] < target {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return -1
}

func main() {
    data := []int{164, 29, 7, 190, 71, 63, 58, 36, 189, 27, 174, 140, 23, 152, 109, 9, 8, 24, 56, 60, 130, 155, 198, 144, 51, 167, 192, 108, 57, 115, 151, 72, 2, 41, 186, 88, 169, 40, 182, 87, 191, 183, 98, 25, 92, 89, 68, 12, 118, 138}
    sort.Ints(data)
    target := 88
    result := binarySearch(data, target)
    fmt.Printf("Target %d found at index: %d\n", target, result)
}