### Important Data Structures
<hr/>
<hr/>

### 2D Arrays
<hr/>

* a[i][j] - i is row and j is column
* Traversing or Searching is `O(m*n)`, other operations are `O(1)` mostly

<hr/>
<hr/>

### Linked Lists
* adding at head - O(1)
* adding at middle - O(n)
* deleting at the end / start - O(1)
* deleting at the middle - O(n)
* search by value/index - O(n)
```
operations & concepts:
------------------------
node class (value, next)
Constructor (head, tail, length)
append
prepend
insert
removeFirst
removeLast
get(index)
set(index, value)
insert(index, value)
remove(index)
reverse()
```
<hr/>
<hr/>

### Doubly Linked Lists

```
operations & concepts:
------------------------
node class (value, next, prev)
Constructor (head, tail, length)
append
prepend
insert (index, value)
removeFirst
removeLast
get(index)
set(index,value)
remove(index)
```

<hr/>
<hr/>

### Stack

* push and pop - O(1)

```
operations & concepts:
------------------------
Node class (value, next)
Constructor(top,height)
pop()
push(value)
getTop()
getHeight()
printStack

```

<hr/>
<hr/>

### Queue - Last in First out

* enqueue and dequeue - O(1)

```
operations & concepts:
------------------------
Node class (value, next)
Constructor(first,last, length)
enqueue()
dequeue()
getFirst()
getLast()
printQueue()
getLength()
```

<hr/>
<hr/>

### Tree 
#### Binary Tree and Binary Search tree
* full and perfect tree
* Tree can have only 1 parent
* Node with no children is leaf
* insert, search, remove - O(logn)

```
operations & concepts:
------------------------
Node(value, left, right)
Constructor - root, value
insert
```

<hr/>
<hr/>

### Hash Tables

* Collision: can be managed by separate chaining or linear probing 
* hash method - O(1)
* get, set - O(1)

```
operations & concepts:
------------------------
Node - key, value, next
constructor (size, Node[])
hash()
set(key, value)
get(key)
keys()
```

<hr/>
<hr/>

### Graphs

* edge is a connection between 2 vertices (nodes)
* edge can be waited or non waited
* graphs can be implemented with adjacency matrix and adjacency list
* adj. list
  * storing - space O(v + E)
* adj. matrix
  * storing - space O(n^2)

```
operations & concepts:
------------------------
constructor - default constructor
private HashMap<String, ArrayList<String>> adjList = new HashMap<>();
Add Vertex
Add Edge
Remove Edge
Remove Vertex
printGraph
```


<hr/>
<hr/>

### heaps

* always a complete binary tree
* we can have duplicates
* leftChild = 2 * parentIndex
* rightChild = 2 * parentIndex + 1

