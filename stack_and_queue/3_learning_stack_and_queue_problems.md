# Stack & Queue Basic Problems

### 1. [Implement stack using array](https://www.geeksforgeeks.org/problems/implement-stack-using-array/1)
```java
class MyStack {
    int top;
	int arr[] = new int[1000];

    MyStack() {
		top = -1;
	}
	
	//Function to push an integer into the stack.
    void push(int a) { // O(1)
	    arr[++top]=a;
	} 
	
    //Function to remove an item from top of the stack.
	int pop() { // O(1)
	    if (top==-1)
	        return top;
	        
        return arr[top--];
	}
}
```
### 2. [Implement Queue using array](https://www.geeksforgeeks.org/problems/implement-queue-using-array/1)
```java
class MyQueue {

    int front, rear;
	int arr[] = new int[100005];
	int count;

    MyQueue() {
		front=0;
		rear=0;
		count=0;
	}
	
	//Function to push an element x in a queue.
	void push(int x) { //O(1)
	    if (count < arr.length) {
	        arr[rear % arr.length] = x; // circular-array
	        rear++;
	        count++;
	    } else {
	        // Arr full - no space for more item
	        return;
	    }
	} 

    //Function to pop an element from queue and return that element.
	int pop() { // O(1)
		if (front==rear) 
		    return -1;
		int val = arr[front];
		front++;
		count--;
		
		return val;
	} 
}
```
### 3. [Implement Stack using Queues](https://www.geeksforgeeks.org/problems/stack-using-two-queues/1)
```java
class Queues {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    //Function to push an element into stack using two queues.
    void push(int a) { //O(n)
	    //add in empty Q2, push always happnes in q2
	    q2.add(a);
	    
	    //push all element of Q1
	    while(!q1.isEmpty()) {
	        q2.add(q1.remove());
	    }
	    
	    //swap name of queue
	    Queue<Integer> temp = q1;
	    q1 = q2;
	    q2 = temp;
    }
    
    //Function to pop an element from stack using two queues. 
    int pop() { //O(1)
        //pop always happnes in q1
	    if (!q1.isEmpty()) {
	        return q1.remove();
	    }
	    return -1;
    }
}
```
### 4. [Implement Queue using Stacks](https://www.geeksforgeeks.org/problems/queue-using-two-stacks/1)
```java
class StackQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    void Push(int x) { //O(n)
       //push all existing value from s1 -> s2, then push new value
	   while(!s1.isEmpty()) {
	       s2.push(s1.pop());
	   }
	   s2.push(x);
	   
	   //push all s2 value back to s1
	   while(!s2.isEmpty()) {
	       s1.push(s2.pop());
	   }
    }
    
    //Function to pop an element from queue by using 2 stacks.
    int Pop() { //O(1)
	   //pop always from q1
	   if (!s1.isEmpty()) {
	        return s1.pop();
	   }
	   return -1;
    }
}
```
### 5. [Implement Stack using Linked List](https://www.geeksforgeeks.org/problems/implement-stack-using-linked-list/1)
```java
class MyStack {
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }   
    StackNode top;
    
    //Function to push an integer into the stack.
    void push(int a) { //O(1)
        StackNode node = new StackNode(a);
        if (top==null) {
            top = node;
            return;
        }
        
        node.next = top;
        top = node;
    }
    
    //Function to remove an item from top of the stack.
    int pop() { //O(1)
        if (top == null)
            return -1;
            
        int val = top.data;
        top = top.next;
        return val;
    }
}
```
### 6. [Implement Queue using Linked List](https://www.geeksforgeeks.org/problems/implement-queue-using-linked-list/1)
```java
/*The structure of the node of the queue is
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}*/

class MyQueue {
    QueueNode front, rear;
    
    //Function to push an element into the queue.
	void push(int a) { //O(1)
        QueueNode node = new QueueNode(a);
        if (front==null) {
            front = node;
            rear = node;
            return;
        }
        
        rear.next = node;
        rear = node;
	}
	
    //Function to pop front element from the queue.
	int pop() { //O(1)
        if (front == null)
            return -1;
            
        int val = front.data;
        front = front.next;
        return val;
	}
}
```
### 7. [Valid Parentheses](https://www.geeksforgeeks.org/problems/parenthesis-checker2744/1)
```java
class Solution {
    //Function to check if brackets are balanced or not.
    static boolean ispar(String s) {
        if (s.length()==0 || s.length()%2!=0)
            return false;

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            Character ch = s.charAt(i);

            if (ch == '(') stack.push(')');
            else if (ch == '[') stack.push(']');
            else if (ch == '{') stack.push('}');
            else {
                if (stack.isEmpty()) return false;
                if (stack.pop() != ch) return false;
            }
        }
        return stack.isEmpty();
    }
    //TC: O(n)
    //SC: O(1)
}
```
### 8. [Min Stack](https://www.geeksforgeeks.org/problems/get-minimum-element-from-stack/1)
```java
class GfG {
    int minEle;
    Stack<Integer> stack;
    
    // Constructor    
    GfG() {
        stack = new Stack<>();
        minEle = Integer.MAX_VALUE;
	}
	
    /*returns min element from stack*/
    int getMin() { // O(1)
        if (minEle == Integer.MAX_VALUE) //Corner Case
            return -1;
	    return minEle;
    }
    
    /*returns poped element from stack*/
    int pop() { // O(1)
        if (stack.isEmpty()) {
            return -1;
        } else if (stack.peek() == minEle) {
	        int val = stack.pop();
	        minEle = stack.pop();
	        return val;
	    } else {
	        return stack.pop();
	    }
    }

    /*push element val into the stack*/
    void push(int val) { // O(1)
	    if (val <= minEle) {
	        stack.push(minEle);
	        stack.push(val);
	        minEle = val;
	    } else {
	        stack.push(val);
	    }
    }	
}
```