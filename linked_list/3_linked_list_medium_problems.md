# Linked List - Medium Problems

### 1. [Remove Nth Node From End of List](https://www.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1)
```java
class Solution {

    // Function to find the data of kth node from
    // the end of a linked list.
    int getKthFromLast(Node head, int k) {
        
        // Rabbit & Tortoise | Slow & Fast pointer
        Node first = head;
        Node second = head;
        
        while(first!=null && k!=1) {
            first = first.next;
            k--;
        }
        
        if (first==null) return -1;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        
        return second.data;
    }
    //TC: O(n)
    //SC: O(1)
}
```
### 2. [Segregate even and odd nodes in a Linked List](https://www.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1)
```java
class Solution{
    Node divide(int N, Node head){
        if (head==null || head.next==null)
            return head;
            
        Node dummy = new Node(-1); //Dummy head node
        dummy.next = head;
        head = dummy;
        
        Node trackLL1 = head;
        
        Node headLL2 = new Node(-1);
        Node trackLL2 = headLL2;
        
        while(trackLL1.next != null) {
            if (trackLL1.next.data%2 == 0) {
                trackLL1 = trackLL1.next;
            } else {
                Node temp = trackLL1.next;
                trackLL1.next = trackLL1.next.next;
                temp.next = null;
                
                trackLL2.next = temp;
                trackLL2 = trackLL2.next;
            }
        }
        
        trackLL1.next = headLL2.next;
        return head.next;
    }
    // TC: O(n)
    // SC: O(1)
}
```
### 3. [Odd Even Linked List - Rearrange a linked list](https://www.geeksforgeeks.org/problems/rearrange-a-linked-list/1)
```java
class Solution {

   // Should rearrange given linked list such that all even
   // positioned Nodes are before odd positioned.
   // Returns nothing
    void rearrangeEvenOdd(Node head) {
        if (head == null || head.next == null)
            return;
            
        Node headll2 = new Node(-1); //dummy head
        Node trackll2 = headll2;
            
        while(head.next != null) {
            Node temp = head.next;
            head.next = head.next.next;
            
            if (head.next != null) //IMP: corner case for EVEN length LL
                head = head.next;
            
            temp.next = null;
            trackll2.next = temp;
            trackll2 = trackll2.next;
        }
        
        head.next = headll2.next;
     }
     // TC: O(n)
     // SC: O(1)
}
```
### 4. [Pairwise swap elements of a linked list](https://www.geeksforgeeks.org/problems/pairwise-swap-elements-of-a-linked-list-by-swapping-data/1)
```java
class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head) {
        if (head==null || head.next==null)
            return head;
        
        Node dummy=new Node(-1);
        dummy.next=head;
        head=dummy;
        
        Node curr=head;
        while(curr.next!=null && curr.next.next!=null) {
            Node temp=curr.next;
            curr.next=temp.next;
            
            curr=curr.next;
            temp.next=curr.next;
            curr.next=temp;
            
            curr=curr.next;
        }
        return head.next;
    }
    // TC: O(n)
    // SC: O(1)
}
```
### 5. [Delete the Middle Node of a Linked List](https://www.geeksforgeeks.org/problems/delete-middle-of-linked-list/1)
```java
class Solution {
    Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        if (head==null || head.next == null)
            return null;
        
        Node fast = head.next.next;
        Node slow = head;
        
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
    // TC: O(n)
    // SC: O(1)
}
```
### 6. [Sort a linked list of 0s, 1s and 2s](https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1)
```java
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        if (head == null || head.next == null)
            return head;

        Node dummy = new Node(-1);
        dummy.next = head;
        Node zeroHead = new Node(-1);
        Node zeroTail = zeroHead;
        Node oneHead = new Node(-1);
        Node oneTail = oneHead;
        Node twoHead = new Node(-1);
        Node twoTail = twoHead;

        while (dummy.next != null) {
            Node temp = dummy.next;
            dummy.next = dummy.next.next;
            temp.next = null;

            if (temp.data == 0) {
                zeroTail.next = temp;
                zeroTail = zeroTail.next;
            } else if (temp.data == 1) {
                oneTail.next = temp;
                oneTail = oneTail.next;
            } else {
                twoTail.next = temp;
                twoTail = twoTail.next;
            }
        }

        oneTail.next = twoHead.next;
        zeroTail.next = oneHead.next;
        return zeroHead.next;
    }
    // TC: O(n)
    // SC: O(1)
}
```
### 7. [Detect Loop in linked list](https://www.geeksforgeeks.org/problems/detect-loop-in-linked-list/1)
```java
class Solution {
    //Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head){
        if (head == null || head.next == null)
            return false;

        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            if (slow == fast) 
                return true;
            
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
    // TC: O(n)
    // SC: O(1)
}
```
### 8. [Find the first node of loop in linked list](https://www.geeksforgeeks.org/problems/find-the-first-node-of-loop-in-linked-list--170645/1)
```java
class Solution {
    //Function to find first node if the linked list has a loop.
    public static int findFirstNode(Node head){
        if (head == null || head.next == null) 
            return -1;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) 
                break; // Loop Present
        }

        if (fast == null || fast.next == null)
            return -1; // No Loop Present

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return head.data;
    }
    // TC: O(n)
    // SC: O(1)
}
```
### 9. [Find length of Loop](https://www.geeksforgeeks.org/problems/find-length-of-loop/1)
```java
class Solution {
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head) {
        if (null == head || null == head.next) {
	        return 0;
	    }
	    
	    Node fast, slow;
	    fast = head;
	    slow = head;
	    
	    while (null != fast && null != fast.next) {
	        slow = slow.next;
	        fast = fast.next.next;
	        
	        if (fast == slow) {
	            break;
	        }
	    }
	    
	    if (null == fast || null == fast.next) { // No Loop
	        return 0;
	    }
	    
	    fast = fast.next;
	    int count = 1;
	    
	    while (fast != slow) {
	        count++;
	        fast = fast.next;
	    }
	    
	    return count;
    }
    // TC: O(n)
    // SC: O(1)
}
```
### 10. [Palindrome Linked List](https://www.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1)
```java
class Solution {
    //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        if (null == head || null == head.next) {
            return true;
        }
        
        Node middleNode = findMiddleNode(head);
        Node secondHalf = middleNode.next;
        middleNode.next = null;
        
        secondHalf = reverseLinkedList(secondHalf);
        
        while (null != head && null != secondHalf) {
            if (head.data != secondHalf.data) {
                return false;
            }
            head = head.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }    
    
    Node findMiddleNode(Node head) {
        Node fast, slow;
        fast = head.next;
        slow = head;
        
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    Node reverseLinkedList(Node head) {
        if (null == head || null == head.next) {
            return head;
        }
        
        Node prev = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        
        return prev;
    }
    // TC: O(n)
    // SC: O(1)
    // Node: Originl LL distorted
}
```
### 11. [Add 1 to a number represented as linked list](https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1)
```java
class Solution {
    public static Node addOne(Node head) { 
        head=reverseLinkedList(head);
        Node track=head;
        int carry=1;
        while(track.next!=null) {
            int sum = track.data + carry;
            track.data = sum%10;
            carry = sum/10;
            
            track=track.next;
        }
        
        if (carry!=0) { // Corner Case 1
            int sum = track.data + carry;
            track.data = sum%10;
            carry = sum/10;
            
            if (carry!=0) { // Corner Case 2
                Node newNode = new Node(carry);
                track.next = newNode;   
            }
        }
        
        return reverseLinkedList(head);
    }
    
    public static Node reverseLinkedList(Node head) {
        if (head==null || head.next==null)
            return head;
            
        Node prev, curr, next;
        prev = head;
        curr = head.next;
        next = head.next.next;
        
        prev.next = null;
        
        while(curr.next!=null) {
            curr.next=prev;
            
            prev=curr;
            curr=next;
            next=next.next;
        }
        curr.next=prev;
        return curr;
    }
    //TC: O(n) Multiple iteration
    //SC: O(1)
}
```
### 12. [Add Two Numbers](https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1)
```java
class Solution {
    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node head1, Node head2) {
        if (head1==null && head2==null)
            return new Node(0);
            
        if (head1==null)
            return head2;
        if (head2==null)
            return head1;
        
        head1=reverseLinkedList(head1);
        head2=reverseLinkedList(head2);
        
        Node track1=head1;
        Node track2=head2;
        
        
        int carry=0;
        int sum=0;
        while(track1.next!=null && track2.next!=null) {
            sum = track1.data + track2.data + carry;
            track1.data = sum%10;
            carry = sum/10;
            
            track1 = track1.next;
            track2 = track2.next;
        }
        
        sum = track1.data + track2.data + carry;
        track1.data = sum%10;
        carry = sum/10;
        
        if (track1.next==null) {
            track2 = track2.next;
            Node temp = track2;
            
            while(carry!=0 && track2!=null) {
                sum = track2.data + carry;
                track2.data = sum%10;
                carry = sum/10;
                
                track2=track2.next;
            }
            
            track1.next=temp;
        } else {
            track1 = track1.next;
            while(carry!=0 && track1!=null) {
                sum = track1.data + carry;
                track1.data = sum%10;
                carry = sum/10;
                
                track1=track1.next;
            }
        }
        
        if (carry!=0) {
            track1=head1;
            while(track1.next!=null)
                track1=track1.next;
            
            Node newNode = new Node(carry);
            track1.next=newNode;
        }
        
        head1=reverseLinkedList(head1);
        while(head1!=null && head1.data==0) { // Corner case: remove leading 0
            head1=head1.next;
        }
        
        if (head1==null) { // Corner case
            return new Node(0);
        }
        return head1;
    }
    
    static Node reverseLinkedList(Node head) {
        if (head==null || head.next==null)
            return head;
            
        Node prev=head;
        Node curr=head.next;
        Node next=head.next.next;
        
        prev.next=null;
        
        while(curr.next!=null) {
            curr.next=prev;
            
            prev=curr;
            curr=next;
            next=next.next;
        }
        curr.next=prev;
        return curr;
   }
   
   //TC: O(n+m)
   //SC: O(1)
}
```
### 13. [Merge two sorted linked lists](https://www.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1)
```java
class LinkedList
{
    //Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {
        if (head1==null&&head2==null)
            return null;
        if (head1==null)
            return head2;
        if (head2==null)
            return head1;
            
        Node dummy1=new Node(-1);
        dummy1.next=head1;
        head1=dummy1;
        
        Node dummy2=new Node(-1);
        dummy2.next=head2;
        head2=dummy2;
        
        Node track1=head1;
        Node track2=head2;
        
        while(track1.next!=null && track2.next!=null) {
            if (track1.next.data > track2.next.data) {
                Node temp=track2.next;
                track2.next=temp.next;
                
                temp.next=track1.next;
                track1.next=temp;
                track1=track1.next;
            } else {
                track1=track1.next;
            }
        }
        
        if (track2.next!=null) { 
            if (track2.data==-1) { // Corner case: All elements of l2 is larger then l1, need to skeep dummy node.
                track1.next=track2.next;
            } else {
                track1.next=track2;
            }
        }
        
        return head1.next;
   } 
   //TC: O(n+m)
   //SC: O(1)
}
```
### 14. [Reorder List](https://www.geeksforgeeks.org/problems/reorder-list/1)
```java
class Solution {
    void reorderlist(Node head) {
        if (head==null) 
            return;
            
        Node midNode = getMiddle(head);
        Node head2 = midNode.next;
        midNode.next = null;
        
        head2=reversell(head2);
        
        Node curr=head;
        while(curr.next!=null) {
            Node temp=head2;
            head2=head2.next;
            
            temp.next=curr.next;
            curr.next=temp;
            curr=temp.next;
        }
        
        if (head2!=null)
            curr.next=head2;
    }
    
    Node getMiddle(Node head) {
        Node fast=head.next;
        Node slow=head;
        
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    
    Node reversell(Node head) {
        if (head==null || head.next==null)
            return head;
            
        Node prev=head;
        Node curr=head.next;
        Node next=head.next.next;
        
        prev.next=null;
        while(curr.next!=null) {
            curr.next=prev;
            
            prev=curr;
            curr=next;
            next=next.next;
        }
        curr.next=prev;
        return curr;
    }
    // TC: O(n)
    // SC: O(1)
}
```
### 15. [Intersection Point in Y-Shaped Linked Lists](https://www.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1)
```java
class Intersect {
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2) {
	    if (head1==null || head2==null) 
	        return -1;
	        
        int len1=getLength(head1);
        int len2=getLength(head2);
        
        Node largeLL, smallLL;
        if (len1>len2) {
            largeLL = head1;
            smallLL = head2;
        } else {
            largeLL = head2;
            smallLL = head1;
        }
        
        int diff=Math.abs(len1-len2);
        while(diff!=0) {
            largeLL=largeLL.next;
            diff--;
        }
        
        while(largeLL!=null && smallLL!=null && (largeLL != smallLL)) {
            largeLL=largeLL.next;
            smallLL= smallLL.next;
        }
        
        if (largeLL==null || smallLL==null)
            return -1;
        
        return largeLL.data;
	}
	
	int getLength(Node head) {
	    if (head==null)
	        return 0;
	        
	    int len=1;
	    while(head!=null) {
	        head=head.next;
	        len++;
	    }
	    return len;
	}
	// TC: O(n+m)
	// SC: O(1)
}
```
### 16. [Rotate List](https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1)
```java
class Solution{
    //Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        if (head==null || k==0)
            return head;
            
        Node curr=head;
        Node currPrev=null;
        while(k!=0) {
            currPrev=curr;
            curr=curr.next;
            k--;
        }
        
        if (curr==null)
            return head;
        
        currPrev.next=null;
        Node head2=curr;
        
        curr=head2;
        while(curr.next!=null) 
            curr=curr.next;
            
        curr.next=head;
        return head2;
    }
    // TC: O(n)
    // SC: O(1)
}
```