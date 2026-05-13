// Quick Sort: Picks pivot, partitions array around it, recursively sorts partitions
// Time: O(n log n) average, O(n²) worst, Space: O(log n)

function quickSort(arr) {
  if (arr.length <= 1) return arr;

  const pivot = arr[Math.floor(arr.length / 2)];
  const left = arr.filter((x) => x < pivot);
  const middle = arr.filter((x) => x === pivot);
  const right = arr.filter((x) => x > pivot);

  return [...quickSort(left), ...middle, ...quickSort(right)];
}

const data = [
  164, 29, 7, 190, 71, 63, 58, 36, 189, 27, 174, 140, 23, 152, 109, 9, 8, 24,
  56, 60, 130, 155, 198, 144, 51, 167, 192, 108, 57, 115, 151, 72, 2, 41, 186,
  88, 169, 40, 182, 87, 191, 183, 98, 25, 92, 89, 68, 12, 118, 138,
];
const result = quickSort([...data]);
console.log(`Sorted: ${result}`);
