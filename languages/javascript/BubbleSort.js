// Bubble Sort: Repeatedly swaps adjacent elements if they're in wrong order
// Time: O(n²), Space: O(1)

function bubbleSort(arr) {
  const n = arr.length;
  for (let i = 0; i < n; i++) {
    let swapped = false;
    for (let j = 0; j < n - i - 1; j++) {
      if (arr[j] > arr[j + 1]) {
        [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
        swapped = true;
      }
    }
    if (!swapped) break;
  }
  return arr;
}

const data = [
  164, 29, 7, 190, 71, 63, 58, 36, 189, 27, 174, 140, 23, 152, 109, 9, 8, 24,
  56, 60, 130, 155, 198, 144, 51, 167, 192, 108, 57, 115, 151, 72, 2, 41, 186,
  88, 169, 40, 182, 87, 191, 183, 98, 25, 92, 89, 68, 12, 118, 138,
];
const result = bubbleSort([...data]);
console.log(`Sorted: ${result}`);
