// Radix Sort: Sorts by processing individual digits using counting sort
// Time: O(d * (n + k)) where d is digits, Space: O(n + k)

package main

import "fmt"

func radixSort(arr []int) {
    if len(arr) == 0 {
        return
    }

    maxVal := arr[0]
    for _, num := range arr {
        if num > maxVal {
            maxVal = num
        }
    }

    for exp := 1; maxVal/exp > 0; exp *= 10 {
        countingSortByDigit(arr, exp)
    }
}

func countingSortByDigit(arr []int, exp int) {
    n := len(arr)
    output := make([]int, n)
    count := make([]int, 10)

    for i := 0; i < n; i++ {
        digit := (arr[i] / exp) % 10
        count[digit]++
    }

    for i := 1; i < 10; i++ {
        count[i] += count[i-1]
    }

    for i := n - 1; i >= 0; i-- {
        digit := (arr[i] / exp) % 10
        output[count[digit]-1] = arr[i]
        count[digit]--
    }

    copy(arr, output)
}

func main() {
    data := []int{164, 29, 7, 190, 71, 63, 58, 36, 189, 27, 174, 140, 23, 152, 109, 9, 8, 24, 56, 60, 130, 155, 198, 144, 51, 167, 192, 108, 57, 115, 151, 72, 2, 41, 186, 88, 169, 40, 182, 87, 191, 183, 98, 25, 92, 89, 68, 12, 118, 138}
    radixSort(data)
    fmt.Printf("Sorted: %v\n", data)
}