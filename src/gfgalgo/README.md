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

<hr />

### Sorting

* some common problems and sorting algorithms
  * Binary Array - Partition Algorithm using quick sort
  * Array with 3 possible values - Partition Algorithm using quick sort
  * Array of size n and small ranged values - counting sort
  * Array of size n and range is of size n^2 or n^3 or closer - radix sort
  * Array of uniformly distributed data over a range - Bucket Sort
  * When memory writes are costly - Selection Sort / Cycle Sort
  * When adjacent swaps are allowed - bubble sort
  * When array of small size - insertion sort
  * when available extra memory is less - she ll sort

* Sorting in java:
  * Arrays.sort
    * primitive not allowed with comparator
      * For reverse order
        * ```Arrays.sort(arr, Collections.reverseOrder())```
    * For non primitives
      * Comparable (implements compareTo(Point p))
      * Comparator (implements compare(Point p1, Point p2)) - will be external class and we need to pass the objects in Collections.sort()
        * Arrays.sort(arr, new MyComp())
      * 
  * Collections.sort (For lists)
    * only for ArrayList or LinkedList
  * Stability in Sorting Algorithm
    * if 2 items are there, then both items should be appearing as per original array if 2 items have same value
    * stability is important for sorting objects (non-primitives)
      * stable algos: Bubble , Insertion, Merge
      * Unstable algos: Selection, Quick, Heap

<hr />

### Multi-Dimensional Array

* arr[2][3] - 2 rows and 3 elements each
* ```int[][] arr = new int[m][n]```
* jagged arrays can be created using ```int[][] arr = new int[m][]```

<hr />

### Hashing

* input -> hash function -> use as index in hash table
* it should generate the same value for same input
* uniformly distribute the input keys into hash table slots
* Universal Hashing: 
  * pick a random from available hash functions
* Collision Handling:
  * if we know keys in advance, then we can use "perfect hashing"
  * if we do not know keys, then we can use one of the following
    * Chaining
      * Array of linkedlist will be used as hash table
      * Load factor = (no of keys)/ (no of slots)
      * Data structures to store the chains
        * Linked List
        * Dynamic Sized Arrays (ArrayList)
        * Self balancing BST (AVL Tree, Red Black Tre  )
    * open addressing
      * Linear probing
        * No of slots in the hash table >= no of keys to be inserted
        * if collision, linearly search for the next empty slot
        * For searching,  we will stop in 3 cases
          * if found
          * if empty slots reached
          * if table end reached
          * clustering is the problem
      * Quadratic Probing
        * hash(key, i) = (h(key)+ (i^2)) %m
      * Double Hashing
        * hash(key, i) = (h1(key)+ i * h2(key)) %m
  * Example data structures in Java
    * HashSet
      * add()
      * remove()
      * size()
      * contains()
      * clear()
      * hs.iterator()
    * HashMap
      * put()
      * size()
      * get()
      * containsKey()
      * clear()
      * containsValue()
      * remove() - value will be returned or null
        *  ```Map.Entry<String , Integer> e: m.entrySet()```
        * ```e.getKey() , e.getValue()```

<hr />

### String

* 128 ascii characters
* UTF-16 , stored using 16 bits
* ascii for 
  * a - 97
  * A - 65
* ways to create strings in java
  * ```char[] arr = ['l','f']```
  * String class - this is immutable
  * StringBuffer class - mutable and threadsafe
  * StringBuilder class - mutable and not threadsafe - good for single threaded programs
* pattern searching algorithms (Naive, Improved Naive for Distinct, Rabin Karp and KMP).

<hr />

### Linked Lists

* Problems with Arrays
  * insertions in middle is costly


* Singly Linked Lists:
  * Memory of nodes need not be contiguous
  * Each node will have
    * data
    * pointer to next node
  * No need to pre-allocate the space
  * Linked list node refers another node instance , this is called self referential data structures
* Applications of LL:
  * insertion at the beginning : O(1)
  * deletion at the beginning : O(1)
  * insertion and deletion in the middle are  O(1)
  * Round robin implementation (e.g) CPU queues
  * Merging 2 sorted linked lists are faster than arrays
  * Implementation of simple memory manager where we need to link free blocks
  * Easier implementation of Queue and Deque data structures

* Doubly Linked Lists:
  * can be traversed in both directions
  * inserting deleting at both end is O(1)
  * Disadv:
    * Extra space for prev
    * code becomes more complex
* Circular linked list
  * last node next will be head node
  * we can reuse the same singly or doubly linked list Node class
  * Adv:
    * used in like algorithms such as round robin
  * Circular Doubly Linked List:
    * previous of head is last node
    * next of last node is head