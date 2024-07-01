# Stack & Queue Using Java Collections

## Stack

[Stack Class in Java](https://www.geeksforgeeks.org/stack-class-in-java/)

[Link for below code on editor](https://ide.geeksforgeeks.org/online-java-compiler/08791685-eb9e-42dc-933f-3fe710fbd600)

```java
import java.util.Stack;
public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        //Adds an item to the top of the stack.
        stack.push(1); // O(1)
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        System.out.println(stack); 
        
        //Removes and returns the item at the top of the stack. Throws EmptyStackException if the stack is empty.
        System.out.println(stack.pop()); // O(1)
      
        //Returns the item at the top of the stack without removing it. Throws EmptyStackException if the stack is empty.
        System.out.println(stack.peek()); // O(1)
         
        //Tests if the stack is empty.
        System.out.println(stack.empty()); // O(1)
        
        //Returns the number of elements in the stack.
        System.out.println(stack.size()); // O(1)
        
        //Returns the 1-based position from the top of the stack where the object is located; the top-most item is at position 1. Returns -1 if the object is not found.
        System.out.println(stack.search(9)); // O(n)
        System.out.println(stack.search(2));
        
        //Removes all elements from the stack, effectively emptying it.
        stack.clear(); // O(n)
    }
}

/***** OUTPUT *******
[1, 2, 3, 4]
4
3
false
3
-1
2
*********************/
```

## Queue

[Queue Interface In Java](https://www.geeksforgeeks.org/queue-interface-java/)

[Link for below code on editor](https://ide.geeksforgeeks.org/online-java-compiler/6364782d-e74f-4afa-a65a-cefaffc87461)

```java
/*package whatever //do not write package name here */

import java.io.*;

import java.util.LinkedList;
import java.util.Queue;

class GFG {
	public static void main (String[] args) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1); // O(1)
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		
		System.out.println(queue); // O(1)
		
		// remove the element at the front of the queue
        int front = queue.remove(); // O(1)
        System.out.println(front);
		
		// peek at the element at the front of the queue
		int peeked = queue.peek(); // O(1)
        System.out.println(peeked);
        
        // size of cirrect queue
        int size = queue.size(); // O(1)
        System.out.println(size);

        // Check is queue empty
        System.out.println(queue.isEmpty()); // O(1)
        
        //Clear
        queue.clear(); // O(1)
        System.out.println(queue.size());
	}
}

/***** OUTPUT *******
[1, 2, 3, 4, 5]
1
2
4
false
0

*********************/
```