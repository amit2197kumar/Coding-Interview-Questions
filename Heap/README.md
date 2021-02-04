# In A Complete Binary Tree:

1. Parent Index:
    1. If heap array start with index 0 then parent will be at: **(index-1)/2**
    2. If heap array start with index 1 then parent will be at: **index/2**
2. Left Index:
    1. If heap array start with index 0 then left child will be at: **index * 2**
    2. If heap array start with index 1 then left child will be at: **(index * 2) + 1**
3. Right Index:
    1. If heap array start with index 0 then right child will be at: **(index * 2) + 1**
    2. If heap array start with index 1 then right child will be at: **(index * 2) + 2**
4. Parent Nodes:
    1. If heap array start with index 0 then parent index will be between: **0 to (n/2) - 1**
    2. If heap array start with index 1 then parent index will be between: **1 to (n/2)**
5. Leaf Nodes:
    1. If heap array start with index 0 then leaf index will be between: **n/2 to n-1**
    2. If heap array start with index 1 then parent index will be between: **(n/2) + 1 to n**

# Heap Basic:

- [Heaps/Priority Queues](https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/tutorial/)
- [Max Heap in Java](https://www.geeksforgeeks.org/max-heap-in-java/) (Using Array & PriorityQueue)
- [Min Heap in Java](https://www.geeksforgeeks.org/min-heap-in-java/) (Using Array & PriorityQueue)
- [PriorityQueue in Java](https://www.geeksforgeeks.org/priority-queue-class-in-java-2/) (Code)
- [Priority Queue and Heap (Playlist)[Understanding]](https://www.youtube.com/watch?v=wptevk0bshY&list=PLDV1Zeh2NRsCLFSHm1nYb9daYf60lCcag)
- [Deeply Understanding Logarithms In Time Complexities](https://www.youtube.com/watch?v=M4ubFru2O80&t=1s)
- [Priority Queues & Comparable](https://www.freecodecamp.org/news/priority-queue-implementation-in-java/)
- [Convert A Min Heap To Max Heap in O(n). HOW!!](https://afteracademy.com/blog/convert-a-min-heap-to-a-max-heap)
- [Theoretical HEAP interview questions](https://www.fullstack.cafe/blog/heap-interview-questions)

# Time Complexity(Heap & Priority Queue):

- Binary Heap Construction : **O(n)**
- Poll : **O(log(n))**
- Peek : **O(1)**
- Add : **O(log(n))**
- Native Remove : **O(n)**
- Native Contains : **O(n)**

# Identifications of HEAP problems:

1. Keyword K present in the problem.
2. Keyword smallest & largest in problem with K.
3. Sorting might be involve.

# Coding Questions:

1. [Binary Heap Operations](https://practice.geeksforgeeks.org/problems/operations-on-binary-min-heap/1)
2. [Heap Sort](https://practice.geeksforgeeks.org/problems/heap-sort/1)
3. [Rearrange characters](https://practice.geeksforgeeks.org/problems/rearrange-characters/0) ([Reorganize String](https://leetcode.com/problems/reorganize-string/))
4. [Kth largest element in a stream](https://practice.geeksforgeeks.org/problems/kth-largest-element-in-a-stream/0) **
5. [Merge K sorted linked lists](https://practice.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1)
6. [Find median in a stream](https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1)
7. [K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)
8. [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)
9. [Last Stone Weight](https://leetcode.com/problems/last-stone-weight/)
10. [Nearly Sorted Algorithm](https://practice.geeksforgeeks.org/problems/nearly-sorted-algorithm/0)
11. [Sorting Elements of an Array by Frequency](https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency/0)
12. [Task Scheduler](https://leetcode.com/problems/task-scheduler/)
13. [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
14. [Top k numbers in a stream](https://practice.geeksforgeeks.org/problems/top-k-numbers3425/1)
15. [Convert a min heap to max heap](https://afteracademy.com/problems/convert-a-min-heap-to-max-heap)
16. [K Pairs with Smallest Sums](https://afteracademy.com/problems/k-pairs-with-smallest-sums)
17. [Sliding window maximum](https://afteracademy.com/problems/sliding-window-maximum)

# Article

1. [Find k closest numbers in an unsorted array](https://www.geeksforgeeks.org/find-k-closest-numbers-in-an-unsorted-array/)
2. [Minimum Cost to Connect Sticks](https://carlosbf.medium.com/top-amazon-questions-minimum-cost-to-connect-sticks-lc-1167-6e547e1715ac)
3. [Convert BST to Min Heap](https://www.geeksforgeeks.org/convert-bst-min-heap/)