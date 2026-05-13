// Counting Sort: Counts occurrences of each value, reconstructs sorted array
// Time: O(n + k) where k is range, Space: O(k)

package main

import "fmt"

func countingSort(arr []int) {
    if len(arr) == 0 {
        return
    }

    maxVal, minVal := arr[0], arr[0]
    for _, num := range arr {
        if num > maxVal {
            maxVal = num
        }
        if num < minVal {
            minVal = num
        }
    }

    rangeSize := maxVal - minVal + 1
    count := make([]int, rangeSize)
    output := make([]int, len(arr))

    for _, num := range arr {
        count[num-minVal]++
    }

    for i := 1; i < len(count); i++ {
        count[i] += count[i-1]
    }

    for i := len(arr) - 1; i >= 0; i-- {
        output[count[arr[i]-minVal]-1] = arr[i]
        count[arr[i]-minVal]--
    }

    copy(arr, output)
}

func main() {
    data := []int{164, 29, 7, 190, 71, 63, 58, 36, 189, 27, 174, 140, 23, 152, 109, 9, 8, 24, 56, 60, 130, 155, 198, 144, 51, 167, 192, 108, 57, 115, 151, 72, 2, 41, 186, 88, 169, 40, 182, 87, 191, 183, 98, 25, 92, 89, 68, 12, 118, 138}
    countingSort(data)
    fmt.Printf("Sorted: %v\n", data)
}