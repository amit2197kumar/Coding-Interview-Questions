# Linked List - Basic Problems (Helpers)

### 1. [Introduction to Linked List](https://www.geeksforgeeks.org/problems/introduction-to-linked-list/1)
```java
class Solution {
    static Node constructLL(int arr[]) {
        Node head = new Node(-1); //Dummy Head Node
        Node track = head; //Track Node
        
        for (int i=0; i<arr.length; i++) {
            Node newNode = new Node(arr[i]);
            track.next = newNode;
            track = newNode;
        }
        
        if (track == head) return null;
        return head.next;
    }
}

// Time complexity: O(n)
// Space complexity: O(n)
```
### 2. [Linked List Insertion](https://www.geeksforgeeks.org/problems/linked-list-insertion-1587115620/0)
```java
class Solution {
    //Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x) {
        Node newNode = new Node(x);
        
        if (head==null)
            return newNode;
            
        
        newNode.next=head;
        head = newNode;
        return head;
    }
    // TC: O(1)
    // SC: O(1)
    
    //Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        Node newNode = new Node(x);
        
        if (head==null)
            return newNode;
            
        Node track = head;
        while (track.next != null)
            track = track.next;
            
        track.next = newNode;
        return head;
    }
    // TC: O(n)
    // SC: O(1)
}
```
### 3. [Count Linked List Nodes](https://www.geeksforgeeks.org/problems/count-nodes-of-linked-list/0)
```java
class Solution {
    //Function to count nodes of a linked list.
    public static int getCount(Node head) {
        if (head==null) return 0;
        
        int count=1;
        while(head.next !=null) {
            count++;
            head = head.next;
        }
        
        return count;
    }
    //TC: O(n)
    //SC: O(1)
}
```
### 4. [Search in Linked List](https://www.geeksforgeeks.org/problems/search-in-linked-list-1664434326/1)
```java
class Solution {
    static boolean searchKey(int n, Node head, int key) {
        if (head==null) return false;
        
        while(head != null) {
            if (head.data == key)
                return true;
            head = head.next;
        }
        return false;
    }
    //TC: O(n)
    //SC: O(1)
}
```
### 5. [Delete Node in a Linked List](https://www.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1)
```java
class GfG {
    Node deleteNode(Node head, int x) {
	    if (x == 1) 
	        return head.next;
	   
	    Node track = head;   
	    while (track!=null && x!=2) {
	        track = track.next;
	        x--;
	    }
	   
	    if (track==null)
	        return head;
	    
	    track.next = track.next.next;
	    return head;
    }
    //TC: O(n)
    //TC: O(1)
}
```
### 6. [Middle of the Linked List](https://www.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1)
```java
class Solution {
    int getMiddle(Node head) {
        if (head==null)
            return -1;
            
        // Rabbit & Tortoise | Slow & Fast pointer
        Node slow = head;
        Node fast = head;
        
        while(fast!= null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow.data;
        /*
        fast.next == null meaning ODD length linked-list
        fast == null meaning EVEN length linked-list
        */
    }
    //TC: O(n)
    //SC: O(1)
}
```
### 7. [Reverse Linked List](https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1)
```java
class Solution {
    //Function to reverse a linked list.
    Node reverseList(Node head) {
        if (head==null || head.next==null)
            return head;
            
        Node prev = head;
        Node curr = head.next;
        Node next = head.next.next;
        
        prev.next = null;
        while(curr.next != null) {
            curr.next = prev;
            
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }
    //TC: O(n)
    //SC: O(1)
}
```