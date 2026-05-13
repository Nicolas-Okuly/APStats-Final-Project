# Counting Sort: Counts occurrences of each value, reconstructs sorted array
# Time: O(n + k) where k is range, Space: O(k)

def counting_sort(arr):
    if not arr:
        return arr
    
    max_val = max(arr)
    min_val = min(arr)
    range_size = max_val - min_val + 1
    
    count = [0] * range_size
    output = [0] * len(arr)
    
    for num in arr:
        count[num - min_val] += 1
    
    for i in range(1, len(count)):
        count[i] += count[i - 1]
    
    for i in range(len(arr) - 1, -1, -1):
        output[count[arr[i] - min_val] - 1] = arr[i]
        count[arr[i] - min_val] -= 1
    
    return output

if __name__ == "__main__":
    data = [164, 29, 7, 190, 71, 63, 58, 36, 189, 27, 174, 140, 23, 152, 109, 9, 8, 24, 56, 60, 130, 155, 198, 144, 51, 167, 192, 108, 57, 115, 151, 72, 2, 41, 186, 88, 169, 40, 182, 87, 191, 183, 98, 25, 92, 89, 68, 12, 118, 138]
    result = counting_sort(data.copy())
    print(f"Sorted: {result}")