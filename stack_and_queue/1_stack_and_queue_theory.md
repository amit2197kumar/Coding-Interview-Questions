# Stack & Queue Theory

## Stack

A **stack** is a data structure that stores objects in which the most recently stored objects are the first ones to be removed, (LIFO: last in, first out). An example to help you remember the mechanics of a stack is to associate it with stacks in real life. With a stack of plates, the plates that are placed on top of a stack will be the first ones that are removed from the top!

It is important to be comfortable with the common operations of a stack.

- push: the function that is used to add elements into the stack
- pop: the function that is used to remove elements from the stack
- top (peek): a function that returns the first value (what is on top of the stack), but does not remove it
- isEmpty: a function that checks if the stack is empty or not — helpful when trying to clear all the elements from a stack
- size: a function that returns the number of elements that are in a stack at any given time

If recursion is banned, then use stacks. Because of its last-in-first-out (LIFO) property, it has many advantages over other data structures, such as it can be used in cases where we only need to access or remove elements from one end.

A stack can be implemented using linked lists. We can use a list instead of a dynamic array. The head of the linked list will be the top element of the stack. We can dynamically push elements in it and also pop elements from it using delete a node and insert new node operations in linked lists.

## Queue

A **queue** is a data structure that stores objects in which the most stored objects are the first ones to be removed. A helpful acronym associated with queues is FIFO, first in first out. An example to help you remember the mechanics of a queue is to associate it with queues in real life. With a queue of people waiting to get a seat in a restaurant, the first people to get in the queue will be the first people seated at that restaurant.

It is important to be comfortable with the common operations of a queue.

- enqueue: the function that is used to add elements into the queue
- dequeue: the function that is used to remove the first element from the stack
- peek: a function that returns the first value (what is first in the queue), but does not remove it
- isEmpty: a function that checks if the queue is empty or not — helpful when trying to clear all the elements from a queue
- size: a function that returns the number of elements that are in a queue at any given time

## Key takeaways

- Stacks are very useful for it's backtracking features. For example, parsing questions tend to use stacks because of the LIFO property.
- Stacks can be used to implement recursive solutions iteratively.
- Queues are useful when the ordering of the data matters as it preserves that ordering. For example, they're used for caching.

## Time Complexity 

**Stacks Time Complexity**

|  | Average Case | Worst Case |
| --- | --- | --- |
| Access | O(n) | O(n) |
| Search | O(n) | O(n) |
| Insertion | O(1) | O(1) |
| Deletion | O(1) | O(1) |

**Queues Time Complexity**

|  | Average Case | Worst Case |
| --- | --- | --- |
| Access | O(n) | O(n) |
| Search | O(n) | O(n) |
| Insertion | O(1) | O(1) |
| Deletion | O(1) | O(1) |
