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

* to check even and odd , we can use bitwise & operator
* to divide a number, we can do rightshift 1 digit (n >> 1)

* AND: &
* OR: |
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
* Arrays are stored in heap in java
* It is recommended to use ArrayList whenever possible
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
        * It uses dual-pivot quick sort
        * primitive not allowed with comparator
            * For reverse order
                * ```Arrays.sort(arr, Collections.reverseOrder())```
        * For non primitives
            * Comparable (implements compareTo(Point p))
            * Comparator (implements compare(Point p1, Point p2)) - will be external class and we need to pass the
              objects in Collections.sort()
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
                * For searching, we will stop in 3 cases
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
                * ```Map.Entry<String , Integer> e: m.entrySet()```
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
* Methods in String Class:
    * str.length()
    * str.chatAt(3)
    * str.subString(2)
    * str.subString(2, 5)
    * s1.equals(s2)
    * s1.contains(s2)
    * s1.compareTo(s2) - Lexicographically compare 2 strings
    * s1.indexOf(s1)
    * s1.indexOf(s1, 1)
    * s1.lastIndexOf(s2)
    * s1.concat(s2 )

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
    * insertion and deletion in the middle are O(1)
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

<hr />

### Stacks

* first in first out
* Operations:
    * isEmpty()
    * push()
    * pop()
    * peek()
    * size()
* conditions
    * overflow
    * underflow
* Applications of Stack:
    * Function calls
    * Balanced Parenthesis
    * Reversing Items
    * Infix to Postfix / Prefix
    * Evaluation of Postfix
    * Stack span problem
    * Undo/Redo or Forward / Backward

* Stack in Java Collection Interface
    * List -> Vector -> Stack
    * Queue -> Deque -> ArrayDeque  (Recommended)

* Infix: x+y
* Postfix: xy+
* Prefix: +xy

<hr />

### Queue

* First in First Out
    * Operations:
        * enqueue()
        * dequeue()
        * getFront()
        * getRear()
        * size()
        * isEmpty()
* Applications
    * Pub Sub Models
    * Synchronization
    * OS (FCFS Scheduling, Spooling)
    * Networking(Routes / Switches and Mail Queues)
    * Variations:
        * Deque
        * Priority Queue
        * Double Ended Priority Queue

* In Java , Queue Implementations are
    * LinkedList (Doubly)
    * ArrayDeque

<hr />

### Deque

* insert and delete can be done at the both the ends
* operations
    * insertFront()
    * insertRear()
    * deleteFront()
    * deleteRear
    * getFront()
    * getRear()
    * isFull()
    * isEmpty()
    * size()

* Deque can be implemented using
    * LinkedList  (Doubly linked list)
    * Array (Circular Array)

* Applications
    * can be used as both stack and queue
    * Browser history of action
    * Steal processor scheduling algorithm
    * Implementing a priority queue with two types of priorities
    * Max and Minimum of all subarrays of size k in an array

<hr />

### Tree Data Structure

* Data structure used to implement hierarchy
* Top is root node
* Bottom are the leaf nodes
* Tree can contain many subtrees
* descendants - all elements in the sub tree of a node
* ancestors - all the parent nodes

* Applications:
    * org structure
    * folders
    * html/xml content
    * In OOP (inheritance)
* Binary Search Tree
* Binary Heap
* B and B+ trees in DBMS
* Spanning and shortest path trees in computer networks
* Parse Tree and Expression Tree
* Trie, Suffix Tree, Binary Index Tree, Segment Tree

* Binary Tree:
    * every node has atmost 2 children
    * every node will have pointers to left and right child
    * leaf node pointer will point to null
* Traversal:
    * BFS or level order
    * DFS
        * Inorder (Left Root Right)
        * PreOrder ( Root Left Right)
        * PostOrder (Left Right Root )
* Height of binary tree:
    * Max number of nodes from root to leaf

<hr />

### Binary Search Tree

* most of the operations are O(logn) and search is O(n)
* all the values on the left of root are smaller and on the right are greater
* All keys are typically considered as distinct
* Implementation in Java: (self balancing BST)
    * Tree set
    * Tree Map
* order to be maintained after deletion

* Self-balancing BST:
    * keep the height as O(log n)
    * if we have keys in advance, then we can make a perfectly balanced BST
        * How to make the tree balanced with random inserts and deletions?
            * with some custom restructuring with either left or right rotation
    * Implementations:
        * AVL Trees
            * strict in balance
                * diff of left height and right height should not be more than 1
                    * This is balance factor
        * Red Black Trees
            * Mostly used in real time
            * not much strict like AVL Trees
            * Every node in either Red or Black
            * Root is always black
            * No two consecutive reds
            * Number of black nodes from every node to all of its descendant leaves should be same
        * Applications of self-balancing BST
            * To maintain sorted stream of data
            * To implement doubly ended priority queue
            * To solve problems like
                * count smaller / greater in a stream
                * Floor / Ceiling / Greater / Smaller in a stream

<hr />

### Heaps

* always a complete binary tree
* we can have duplicates
* Binary Heap is stored as an array
* leftChild = 2 * parentIndex
* rightChild = 2 * parentIndex + 1
* Parent node index = childIndex-1 // 2
* PriorityQueue is implementation of Binary Heap in Java
* Two types:
    * Min Heap
    * Max Heap

<hr/>

### Graphs

* G = (V, E)
    * Directed Graphs
        * Indegree - No of incoming vertices
        * outdegree - No of outgoing vertices
    * Undirected Graph
        * degree of edge - no of edges to other edge
* Complete Graph:
    * All the nodes are connected to each other
* Walk:
    * v1, v2, v4, v2
* Path:
    * connection between 2 nodes (v1 -> v2 -> v4)
* Cyclic:
    * There exists a walk that begins and end with same vertex
        * Applicable to both directed and undirected
* Acyclic:
    * Opposite to Cyclic
    * Applicable to both directed and undirected
* Weighted Graphs
    * will have weight from node1 to node2
* Unweighted Graphs

* GRAPH REPRESENTATION
    * Adjacency Matrix
        * Dynamic Sized Arrays
        * Linked Lists
    * Adjacency List

* Graph Traversal:
    * BFS
        * Level order traversal
    * DFS
        * Applications of DFS
            * Cycle Detection
            * Topological Sorting
            * Strongly Connected components
            * Solving merge and similar puzzles
            * Path Finding

<hr />

### Greedy Algorithms

* useful for optimization problems
    * shortest path
    * minimum combinations
* Greedy algorithm may not work always
* Some problems can be solved
    * Activity selection
    * Fractional Knapsack
    * JOb sequencing
    * Prim's Algorithm
    * Kruskal Algorithm
    * Dijikstra's Algorithm
    * Huffman coding

<hr />

### Backtracking

* Permutations
* Rat in a Maze
* N queen Problem
* Sudoku Problem

<hr />

### Dynamic Programming

* In simple words, it is an optimization over plain recursion
* idea is to reuse the solution of sub-problem when there are overlapping subproblem
    * Memoization(Top down)
    * Tabulation (Bottom up)
* Applications
    * Bellman Ford Algorithm
    * Floyd Warshall Algorithm
    * Diff Utility
    * Search closed words (Edit Distance)
    * Resource Application (0-1 knapsack)
    * Longest Common Subsequence
        * Some variations of LCS
            * Diff Utility
            * Minimum insertion and deletions to convert s1 into s2
            * Shortest Common Subsequence
            * Longest palindromic subsequence
            * Longest Repeating subsequence
            * space optimized DP solution of LCS
            * Printing LCS

<hr />

### Trie

* Efficient for the following operations on words in a dictionary
    * Search
    * Insert
    * Delete
    * Prefix Search
    * Lexicographical ordering of words

<hr />

### Segment Tree

* used for fixed sized arrays and following types of operations
    * Range Query: O(log n) typically
    * Update a value: O(log n) typically
* Requires O(n) preprocessing time and O(n) auxiliary space
* Building segment tree
    * Each parent will have the sum of children
    * leaf nodes will be the elements (values) from the source array
    * We can maintain some dummy nodes to keep the tree a complete binary tree
    * size of array needed to store the nodes: 2*2^(log2n) - 1
        * or simply it should be 4n atleast for building segment tree
        *

<hr />

### Binary Indexed Tree

* used for fixed input array and multiple queries of the following types
    * Prefix operations(Sum, product, XOR, OR, etc)
    * update a values
* It is actually an array, but the concept is tree based
* Requires O(n logn) preprocessing time an ø(n) auxiliary space
* Also known as Fenwick tree

<hr />

### Disjoint Set

* operations
    * find(x) - we will get same representative element for all the elements
    * union(x, y)