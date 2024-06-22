# Linked List Cheat Sheet

## Common routines

Many linked list questions make use of one or more of these routines in the solution:

- Counting the number of nodes in the linked list
- Reversing a linked list in place
- Finding the middle node of the linked list using two pointers (fast/slow)
- Merging two linked lists

---

## Techniques

### **1. Dummy nodes[](https://www.techinterviewhandbook.org/algorithms/linked-list/#sentineldummy-nodes)**

Adding a sentinel/dummy node at the head and/or tail might help to handle many edge cases where operations have to be performed at the head or the tail. The presence of dummy nodes essentially ensures that operations will never be done on the head or the tail, thereby removing a lot of headaches in writing conditional checks to deal with null pointers. Be sure to remember to remove them at the end of the operation.

### **2. Two pointers[](https://www.techinterviewhandbook.org/algorithms/linked-list/#two-pointers)**

Two-pointer approaches are also common for linked lists. This approach is used for many classic linked list problems.

- Getting the k from the last node
- Detecting cycles
- Getting the middle node

### **3. Using space**

Many linked list problems can be easily solved by creating a new linked list and adding nodes to the new linked list with the final result. However, this takes up extra space and makes the question much less challenging. The interviewer will usually request that you modify the linked list in-place and solve the problem without additional storage.

### 4. Multiple passes/ traversal of Linked List

Check if multiple iteration over a list helps.

### 5. Copy the Content of a node to another

Helpful in case we are stranding on a node that itself needs to be deleted.

Example: [Delete the Middle Node of a Linked List](https://www.geeksforgeeks.org/problems/delete-middle-of-linked-list/1) and [Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/description/)

---

## Corner cases

- Empty linked list (head is `null`)
- Single node
- Two nodes
- Linked list has cycles. **Tip:** Clarify beforehand with the interviewer whether there can be a cycle in the list. Usually the answer is no and you don't have to handle it in the code
- Will my code handle a totally empty linked list?
- If there is a really high number of nodes, am I loading them all into memory?
- Will even vs. odd number of nodes affect my algorithm?
    - If there is an even number, where is the middle?
- For a given problem, try to think of all the cases and types of LL. and post thinking of a pseudo-code, try dry-running all the cases, this way we find all the corner cases.

---

## Time Complexity

### Singly Linked List

| Accessing the head | O(1) |
| --- | --- |
| Accessing the tail | O(n) / O(1) |
| Accessing the middle node | O(n) |
| Insert/Remove the head | O(1) |
| Insert/Remove the tail | O(n) |
| Insert/Remove the middle node | O(n) |
| Searching for a value | O(n) |

### Doubly Linked List

| Accessing the head | O(1) |
| --- | --- |
| Accessing the tail | O(1) |
| Accessing the middle node | O(n) |
| Insert/Remove the head | O(1) |
| Insert/Remove the tail | O(1) |
| Insert/Remove the middle node | O(n) |
| Searching for a value | O(n) |

Note that all the Linked List problems can be done with iteration and recursion as well.

While using recursion, time complexity will remain the same but keep in mind the auxiliary stack space will be used for recursion tech stack.

---

## What are some common questions we should ask our interviewer?

- Is it a singly linked list or a doubly linked list?
- If the example given is sorted, is the list always sorted?
- Can I create a new list?
- What should the method return?
    - A pointer to a head? A brand new list? Nothing?
- What kind of data does the linked list hold?
    - Might affect how you check for equality between strings, integers, etc
- Does the linked list have a maximum (or minimum) number of nodes?
- Could there be cycles in the linked list?
- Iterative vs recursive approve, recursion stack add to space.



