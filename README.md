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

### System Requirements (Debian/Linux)

```bash
sudo apt install g++ mono-mcs default-jdk golang rustc nodejs python3
```

### Test Data - n = 100,000
Dataset is in dataset.txt.

All data will be stored in /languages/DATA.md

**Because of how fast C++ and Rust is, they had to be removed from this study. All counts showed 0.00s which is unusable.**

### C++

Average Actual Runtime
```math
(0.00 + 0.00 + 0.00 + 0.00 + 0.00 + 0.00 + 0.00 + 0.00 + 0.00 + 0.00) / 10 = 0.00
```

Average Actual Memory
```math
(3452 + 3448 + 3488 + 3452 + 3452 + 3448 + 3512 + 3488 + 3452 + 3452) / 10 = 3464.4
```

### C#

Average Actual Runtime
```math
(0.03 + 0.05 + 0.03 + 0.06 + 0.05 + 0.05 + 0.06 + 0.05 + 0.07 + 0.05) / 10 = 0.05
```

Average Actual Memory
```math
(16664 + 16688 + 17996 + 16948 + 16876 + 16760 + 16736 + 16632 + 17752 + 16788) / 10 = 16984.0
```

### Go

Average Actual Runtime
```math
(0.33 + 0.36 + 0.33 + 0.33 + 0.37 + 0.33 + 0.32 + 0.32 + 0.32 + 0.33) / 10 = 0.334
```

Average Actual Memory
```math
(41184 + 42024 + 42040 + 42288 + 42412 + 42160 + 42184 + 39732 + 42200 + 42436) / 10 = 41866.0
```

### Java

Average Actual Runtime
```math
(0.18 + 0.17 + 0.18 + 0.17 + 0.20 + 0.18 + 0.17 + 0.16 + 0.18 + 0.16) / 10 = 0.175
```

Average Actual Memory
```math
(40828 + 40368 + 41056 + 40664 + 40576 + 40928 + 40212 + 39996 + 41152 + 40800) / 10 = 40658.0
```

### JavaScript

Average Actual Runtime
```math
(0.06 + 0.08 + 0.06 + 0.07 + 0.07 + 0.04 + 0.06 + 0.06 + 0.07 + 0.07) / 10 = 0.064
```

Average Actual Memory
```math
(42300 + 49812 + 42212 + 49248 + 47880 + 42088 + 43004 + 47828 + 42524 + 49612) / 10 = 45650.8
```

### Python

Average Actual Runtime
```math
(0.03 + 0.04 + 0.03 + 0.03 + 0.05 + 0.03 + 0.03 + 0.03 + 0.03 + 0.04) / 10 =  0.034
```

Average Actual Memory
```math
(8968 + 8960 + 9104 + 9072 + 9016 + 8808 + 9244 + 8928 + 9260 + 9056) / 10 = 9041.6
```

### Rust

Average Actual Runtime
```math
(0.00 + 0.00 + 0.00 + 0.00 + 0.00 + 0.00 + 0.00 + 0.00 + 0.00 + 0.00) / 10 = 0.00
```

Average Actual Memory
```math
(2040 + 1896 + 2020 + 2020 + 2036 + 2024 + 1896 + 2044 + 2020 + 2040) / 10 = 2003.6
```
