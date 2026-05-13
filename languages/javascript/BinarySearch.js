// Linear Search: Sequentially checks each element until target is found
// Time: O(n), Space: O(1)

function linearSearch(arr, target) {
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === target) {
      return i;
    }
  }
  return -1;
}

const data = [
  164, 29, 7, 190, 71, 63, 58, 36, 189, 27, 174, 140, 23, 152, 109, 9, 8, 24,
  56, 60, 130, 155, 198, 144, 51, 167, 192, 108, 57, 115, 151, 72, 2, 41, 186,
  88, 169, 40, 182, 87, 191, 183, 98, 25, 92, 89, 68, 12, 118, 138,
];
const target = 88;
const result = linearSearch(data, target);
console.log(`Target ${target} found at index: ${result}`);
