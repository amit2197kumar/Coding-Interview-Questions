# Doubly Linked List Problems

### 1. [Introduction to Doubly Linked List](https://www.geeksforgeeks.org/problems/introduction-to-doubly-linked-list/1)
```java
class Solution {
    Node constructDLL(int arr[]) {
        if (arr.length==0)
            return null;
        
        Node head = new Node(-1); 
        Node track = head;
        for (int i=0; i<arr.length; i++) {
            Node newNode = new Node(arr[i]);
            track.next=newNode;
            newNode.prev=track;
            
            track=track.next;
        }
        return head.next;
    }
    // TC: O(n)
    // SC: O(n)
}
```
### 2. [Doubly linked list Insertion at given position](https://www.geeksforgeeks.org/problems/insert-a-node-in-doubly-linked-list/1)
```java
class GfG {
    //Function to insert a new node at given position in doubly linked list.
    void addNode(Node head, int pos, int data) {
		while(pos!=0) {
		    head=head.next;
		    pos--;
		}
		Node newNode = new Node(data);
		
		if (head.next==null) {
		    head.next=newNode;
		    newNode.prev=head;
		    return;
		}
		
		newNode.next=head.next;
		head.next.prev=newNode;
		newNode.prev=head;
		head.next=newNode;
	}
	// TC: O(n)
	// SC: O(1)
}
```
### 3. [Delete node in Doubly Linked List](https://www.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1)
```java
class Solution {
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x) {
        Node track=head;
	    while(x!=1) {
	        track=track.next;
	        x--;
	    }
	    
	    if(track.next==null) {
	        track.prev.next=null;
	        track.prev=null;
	        return head;
	    }
	    
	    if (track.prev==null) {
	        head=track.next;
	        head.prev=null;
	        track.next=null;
	        return head;
	    }
	    
	    Node temp=track.next;
	    track.prev.next=temp;
	    temp.prev=track.prev;
	    
	    return head;
    }
    // TC: O(n)
    // SC: O(1)
}
```
### 4. [Reverse a Doubly Linked List](https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1)
```java
public static Node reverseDLL(Node  head) {
    Node prev=null;
    Node curr=head;
    Node next=head.next;
    
    while(next!=null) {
        curr.next=prev;
        curr.prev=next;
        
        prev=curr;
        curr=next;
        next=next.next;
    }
    curr.next=prev;
    curr.prev=next;
    
    return curr;
}
// TC: O(n)
// SC: O(1)
```
### 5. [Delete all occurrences of a given key in a doubly linked list](https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1)
```java
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        Node dummy=new Node();
        dummy.next=head;
        head.prev=dummy;
        
        head=dummy;
        while(head.next!=null) {
            if (head.next.data==x) {
                Node temp=head.next;
                head.next=temp.next;
                if(temp.next!=null)
                    temp.next.prev=head;
            } else {
                head=head.next;
            }
        }
        return dummy.next;
    }
    // TC: O(n)
    // SC: O(1)
}
```
### 6. [Find pairs with given sum in doubly linked list](https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1)
```java
class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> pair = new ArrayList<>();

        Node left = head;
        Node right = head;

        while (right.next != null) {
            right = right.next;
        }

        while (left.data < right.data) {
            if (left.data + right.data == target) {
                ArrayList<Integer> sumPair = new ArrayList<>();
                sumPair.add(left.data);
                sumPair.add(right.data);
                pair.add(sumPair);
                
                left = left.next;
                right = right.prev;
            } else {
                if (left.data + right.data < target) {
                    left = left.next;
                } else {
                    right = right.prev;
                }
            }
        }

        return pair;
    }
    // TC: O(n)
    // SC: O(1)
}
    
```
### 7. [Remove duplicates from a sorted doubly linked list](https://www.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list/1)
```java
class Solution{
    Node removeDuplicates(Node head){
        if (head==null || head.next==null)
            return head;
            
        Node temp=head;
        while(temp.next!=null) {
            if (temp.data==temp.next.data) {
                Node dummy=temp.next;
                
                temp.next=dummy.next;
                if (dummy.next!=null)
                    dummy.next.prev=temp;
                
                dummy.next=null;
                dummy.prev=null;
            } else {
                temp=temp.next;
            }
        }
        return head;
    }
    //TC: O(n)
    //SC: O(1)
}
```