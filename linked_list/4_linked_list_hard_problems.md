# Linked List - Hard Problems

### 1. [Reverse a sublist of a linked list](https://www.geeksforgeeks.org/problems/reverse-a-sublist-of-a-linked-list/1)
```java
class Solution {
    public static Node reverseBetween(Node head, int m, int n) {
        if (head==null)
            return head;
            
        // head-tail1 | head2-tail2 | head3
        
        Node curr=head;
        Node currPrev=null;
        while (m!=1) {
            currPrev=curr;
            curr=curr.next;
            m--;
        }
        Node tail1=currPrev;
        Node head2=curr;
        
        curr=head;
        while (n!=1) {
            curr=curr.next;
            n--;
        }
        Node tail2=curr;
        Node head3=curr.next;
        
        if (tail1!=null) //Corner case: m=1
            tail1.next=null;
        tail2.next=null;
        
        head2=reversell(head2);
        
        if (head3!=null) {
            curr=head2;
            while(curr.next!=null)
                curr=curr.next;
            curr.next=head3;
        }
        
        if (tail1!=null) {
            tail1.next=head2;
        } else { //Corner case: m=1, head will be pointing to incorrect node
            head=head2;
        }
        
        return head;
    }
    
    public static Node reversell(Node head) {
        if (head==null || head.next==null)
            return head;
            
        Node prev = null;
        Node curr = head;
        Node next = head.next;
        
        while(next != null) {
            curr.next = prev;
            
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }
    // TC: O(n)
    // SC: O(1)
}
```
### 2. [Merge Sort for Linked List](https://www.geeksforgeeks.org/problems/sort-a-linked-list/1)
```java
class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head) {
        if (null == head || null == head.next) {
            return head;
        }
        
        Node middleNode = findMiddleNode(head);
        Node firstHalf, secondHalf;
        firstHalf = head;
        secondHalf = middleNode.next;
        
        middleNode.next = null;
        
        Node first = mergeSort(firstHalf);
        Node second = mergeSort(secondHalf);
        
        return sortBothHalf(first, second);
    }
    
    static Node sortBothHalf(Node ll1, Node ll2) {
        if (null == ll1) return ll2;
        if (null == ll2) return ll1;
        
        Node ll3, ll3last;
        if(ll1.data<ll2.data) {
            ll3 = ll1;
            ll1 = ll1.next;
        } else {
            ll3 = ll2;
            ll2 = ll2.next;
        }
        ll3last = ll3;
        
        while(ll1 != null && ll2 != null) {
            if(ll1.data<ll2.data) {
                ll3last.next = ll1;
                ll1 = ll1.next;
            } else {
                ll3last.next = ll2;
                ll2 = ll2.next;
            }
            ll3last = ll3last.next;
        }
        
        if (ll1 != null) ll3last.next = ll1;
        if (ll2 != null) ll3last.next = ll2;
        
        return ll3;
    }
    
    static Node findMiddleNode(Node head) {
        if (null == head || null == head.next) {
            return head;
        }
        
        Node slow, fast;
        slow = head;
        fast = head.next;
        
        while(null != fast && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
// Time Complexity: O(nlogn)
// Space Complexity: O(logn) (due to recursion stack)
}
```
### 3. [Reverse a Linked List in Groups](https://www.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1) | [Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/description/)
```java
class Solution {
    public static Node reverse(Node head, int k) {
        if (head==null || k==1)
            return head;
            
        Node dummy=head;
        int temp=k;
        
        while(dummy!=null && temp!=0) {
            dummy=dummy.next;
            temp--;
        }
   
        Node prev=null;
        Node curr=head;
        Node next=head.next;
        
        while(next!=dummy) {
            curr.next=prev;
            
            prev=curr;
            curr=next;
            next=next.next;
        }
        curr.next=prev;
        
        head.next=reverse(dummy, k); // Tricky corner case
        return curr;
    }
    //Time Complexity: O(n)
    //Space Complexity: O(n/k)
}
```
```java
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || k==1)
            return head;
            
        ListNode dummy=head;
        int temp=k;
        
        while(dummy!=null && temp!=0) {
            dummy=dummy.next;
            temp--;
        }
        
        if (dummy==null && temp!=0) // Tricky corner case
            return head;
            
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=head.next;
        
        while(next!=dummy) {
            curr.next=prev;
            
            prev=curr;
            curr=next;
            next=next.next;
        }
        curr.next=prev;
        
        head.next=reverseKGroup(dummy, k); // Tricky corner case
        return curr;
    }
    //Time Complexity: O(n)
    //Space Complexity: O(n/k)
}
```
### 4. [Flattening a Linked List](https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1)
```java
class GfG {
    Node flatten(Node head) {
	    if(head==null || head.next==null) {
            return head;
        }

        Node list2 = flatten(head.next);
        Node list1 = head;
        return mergeTwoLists(list1 ,list2);
    }
    
    Node mergeTwoLists(Node l1,Node l2) {
        Node temp = new Node(0);
        Node currHead = temp;

        while(l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                temp.bottom=l1;
                l1=l1.bottom;
            } else {
                temp.bottom=l2;
                l2=l2.bottom;
            }
            temp=temp.bottom;
        }

        if (l1 != null) {
            temp.bottom = l1;
        } else {
            temp.bottom = l2;
        }
        return currHead.bottom;
    }
    //Time Complexity: O(N*n), where N is the total number of nodes and n is the number of lists.
    //Space Complexity: O(n), due to the recursion stack.
}
```
### 5. [Copy List with Random Pointer](https://www.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1)
```java
class Clone {
    //Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        if (head == null) 
            return head;
        
        // Adding new copy node in the original list
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.data);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        //Adding random/arb pointers to newly added nodes
        temp = head;
        while(temp != null) {
            Node copyNode = temp.next;
            if (temp.arb == null) {
                copyNode.arb = null;
            } else {
                copyNode.arb = temp.arb.next;
            }           
            temp = temp.next.next;
        }

        //Separate  out the newly created list
        temp = head;
        Node head2 = temp.next;

        while (temp != null) {
            Node copyNode = temp.next;
            Node originalNext = copyNode.next;

            if (originalNext == null) {
                copyNode.next = null;
                temp.next = originalNext;
                break;
            }

            copyNode.next = originalNext.next;
            temp.next = originalNext;
            temp = temp.next;
        }
        
        return head2;
    }
    // TC: O(n)
    // SC: O(1)
}
```