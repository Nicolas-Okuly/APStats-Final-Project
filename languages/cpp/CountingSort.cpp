// Counting Sort: Counts occurrences of each value, reconstructs sorted array
// Time: O(n + k) where k is range, Space: O(k)

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void countingSort(vector<int>& arr) {
    if (arr.empty()) return;

    int maxVal = *max_element(arr.begin(), arr.end());
    int minVal = *min_element(arr.begin(), arr.end());
    int range = maxVal - minVal + 1;

    vector<int> count(range, 0);
    vector<int> output(arr.size());

    for (int num : arr) {
        count[num - minVal]++;
    }

    for (int i = 1; i < count.size(); i++) {
        count[i] += count[i - 1];
    }

    for (int i = arr.size() - 1; i >= 0; i--) {
        output[count[arr[i] - minVal] - 1] = arr[i];
        count[arr[i] - minVal]--;
    }

    arr = output;
}

int main() {
    vector<int> data = {164, 29, 7, 190, 71, 63, 58, 36, 189, 27, 174, 140, 23, 152, 109, 9, 8, 24, 56, 60, 130, 155, 198, 144, 51, 167, 192, 108, 57, 115, 151, 72, 2, 41, 186, 88, 169, 40, 182, 87, 191, 183, 98, 25, 92, 89, 68, 12, 118, 138};
    countingSort(data);
    cout << "Sorted: ";
    for (int num : data) cout << num << " ";
    cout << endl;
    return 0;
}