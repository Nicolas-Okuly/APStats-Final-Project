// Radix Sort: Sorts by processing individual digits using counting sort
// Time: O(d * (n + k)) where d is digits, Space: O(n + k)

function radixSort(arr) {
  if (arr.length === 0) return arr;

  const maxVal = Math.max(...arr);

  for (let exp = 1; Math.floor(maxVal / exp) > 0; exp *= 10) {
    countingSortByDigit(arr, exp);
  }

  return arr;
}

function countingSortByDigit(arr, exp) {
  const n = arr.length;
  const output = new Array(n);
  const count = new Array(10).fill(0);

  for (let i = 0; i < n; i++) {
    const digit = Math.floor((arr[i] / exp) % 10);
    count[digit]++;
  }

  for (let i = 1; i < 10; i++) {
    count[i] += count[i - 1];
  }

  for (let i = n - 1; i >= 0; i--) {
    const digit = Math.floor((arr[i] / exp) % 10);
    output[count[digit] - 1] = arr[i];
    count[digit]--;
  }

  for (let i = 0; i < n; i++) {
    arr[i] = output[i];
  }
}

const data = [
  164, 29, 7, 190, 71, 63, 58, 36, 189, 27, 174, 140, 23, 152, 109, 9, 8, 24,
  56, 60, 130, 155, 198, 144, 51, 167, 192, 108, 57, 115, 151, 72, 2, 41, 186,
  88, 169, 40, 182, 87, 191, 183, 98, 25, 92, 89, 68, 12, 118, 138,
];
const result = radixSort([...data]);
console.log(`Sorted: ${result}`);
