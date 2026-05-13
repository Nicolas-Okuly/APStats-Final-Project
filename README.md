# Mean Difference Between Predicted and Actual Algorithm Performance Across Programming Languages

#### Nicolas Okuly - May 12th, 2026

## Introduction

Different programming languages can have different runtime and memory performance, even when running the same algorithm. This study asks whether the actual performance of an algorithm differs from its expected Big O-based prediction, and whether that difference changes across programming languages.

The goal is not to force the data into a chi-square test. Since runtime and memory are continuous measurements, this study will focus on mean differences between predicted and observed values.

Big O notation describes how an algorithm is expected to scale. For example, if an algorithm is expected to grow linearly, then doubling the input size should roughly double the work required. In practice, the real measured runtime or memory may not match that prediction exactly.

I will run several sorting and search algorithms in multiple programming languages and collect time and memory data. For each language, I will run each algorithm 5 times and calculate the mean observed value. Then I will compare that mean to the predicted value and compute the difference. I will do this for every algorithm and then find the overall mean difference for each programming language.

This will give me a single true mean difference value for each language that shows how far the observed performance is from the predicted performance.

To keep the study structured, I will use the following algorithms and languages.

<table style="margin: 0 auto">
	<tr>
		<td valign="top">
            <table>
                <tr>
                    <th>#</th>
                    <th>Algorithm</th>
                </tr>
                <tr><td>1</td><td>Linear search</td></tr>
                <tr><td>2</td><td>Binary search</td></tr>
                <tr><td>3</td><td>Bubble sort</td></tr>
                <tr><td>4</td><td>Selection sort</td></tr>
                <tr><td>5</td><td>Insertion sort</td></tr>
                <tr><td>6</td><td>Merge sort</td></tr>
                <tr><td>7</td><td>Quick sort</td></tr>
                <tr><td>8</td><td>Heap sort</td></tr>
                <tr><td>9</td><td>Counting sort</td></tr>
                <tr><td>10</td><td>Radix sort</td></tr>
            </table>
		</td>
        <!---->
		<td valign="top">
            <table>
                <tr>
                    <th>#</th>
                    <th>Language</th>
                </tr>
                <tr><td>1</td><td>Python</td></tr>
                <tr><td>2</td><td>Java</td></tr>
                <tr><td>3</td><td>C++</td></tr>
                <tr><td>4</td><td>JavaScript</td></tr>
                <tr><td>5</td><td>C#</td></tr>
                <tr><td>6</td><td>Go</td></tr>
                <tr><td>7</td><td>Rust</td></tr>
            </table>
		</td>
	</tr>
</table>

Because this creates a large number of comparisons, I will keep the input sizes and trial conditions consistent across every language and algorithm.

The command used to track time and memory is as follows:
```bash
/usr/bin/time -v [command]
```

The output looks like the following:
```txt
User time (seconds): 0.01
System time (seconds): 0.00
Percent of CPU this job got: 92%
Elapsed (wall clock) time (h:mm:ss or m:ss): 0:00.02
Average shared text size (kbytes): 0
Average unshared data size (kbytes): 0
Average stack size (kbytes): 0
Average total size (kbytes): 0
Maximum resident set size (kbytes): 8348
Average resident set size (kbytes): 0
Major (requiring I/O) page faults: 0
Minor (reclaiming a frame) page faults: 800
Voluntary context switches: 1
Involuntary context switches: 1
Swaps: 0
File system inputs: 0
File system outputs: 0
Socket messages sent: 0
Socket messages received: 0
Signals delivered: 0
Page size (bytes): 4096
Exit status: 0
```

The values I am interested in is "Elapsed (wall clock) time (h:mm:ss or m:ss)" as the time statistic, and "Maximum resident set size (kbytes)" as the memory statistic.

## Data Collection


### Test Data
```python
[164, 29, 7, 190, 71, 63, 58, 36, 189, 27, 174, 140, 23, 152, 109, 9, 8, 24, 56, 60, 130, 155, 198, 144, 51, 167, 192, 108, 57, 115, 151, 72, 2, 41, 186, 88, 169, 40, 182, 87, 191, 183, 98, 25, 92, 89, 68, 12, 118, 138]
```

### Python Executions

#### Binary Search
Binary Search: Divides sorted array in half repeatedly to find target<br>
Time: O(log n), Space: O(1)<br>
```txt
Elapsed (wall clock) time (h:mm:ss or m:ss): 0:00.02
Maximum resident set size (kbytes): 8408
```

#### Bubble Sort
Bubble Sort: Repeatedly swaps adjacent elements if they're in wrong order<br>
Time: O(n²), Space: O(1)<br>
```txt
Elapsed (wall clock) time (h:mm:ss or m:ss): 0:00.02
Maximum resident set size (kbytes): 8540
```

#### Counting Sort
Counting Sort: Counts occurrences of each value, reconstructs sorted array<br>
Time: O(n + k) where k is range, Space: O(k)<br>
```txt
Elapsed (wall clock) time (h:mm:ss or m:ss): 0:00.02
Maximum resident set size (kbytes): 8632
```

#### Heap Sort
Heap Sort: Builds max heap, repeatedly extracts maximum element<br>
Time: O(n log n), Space: O(1)<br>
```txt
Elapsed (wall clock) time (h:mm:ss or m:ss): 0:00.02
Maximum resident set size (kbytes): 8592
```