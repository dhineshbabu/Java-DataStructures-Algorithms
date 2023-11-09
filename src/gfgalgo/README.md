### Asymptotic Analysis
* Does not depend upon machine
  * n^2 - quadratic
  * n - linear
  * 1 - constant
  * logn - logarithmic
* cases
  * best case
  * average case
  * worst case - mostly used
* Big O: Exact or Upper
* Big ø: Exact
* Big Ω: Exact or Lower

<hr />

### Bit Manipulation

* AND: &
* Negative numbers are represented as 2's complement form
  * Direct formula: 2^n - x

<hr />

### Recursion

* base cases are used in recursion to break the recursions run indefinitely
  * recursion termination condition
* Applications of Recursion
  * Many algorithm techniques
    * Dynamic Programming
    * Backtracking
    * Divide and Conquer
  * Many problems inherently recursive
    * Tower of Honoi
    * DFS based Traversals
* Tail Recursion:
  * when there is nothing happens after recursive call in a function, then the function is tail recursive
  * Modern compilers recognize the tail recursions, then it will replace with below code
    * ```n=n-1 then go to start:```
    * <b>This is called tail call elimination</b>
    * This is the reason quick sort is faster than merge sort

<hr />

### Arrays

* Random Access - accessing elements are O(1)
* When arrays used, modern processors prefetch the items in cache

* Array Types:
  * Fixed Size Arrays
  * Dynamic Sized Arrays (ArrayList)
* Sliding window technique
  * compute the sum of current window using sum of previous window

<hr />

### Binary Search

* Binary Search is a powerful and efficient algorithm for finding elements in sorted arrays.
* Go to the middle and check if the element is higher than search on the left else search on the right
* o(logn) is the typical time complexity
* max no of iteration = height of the tree in worst case