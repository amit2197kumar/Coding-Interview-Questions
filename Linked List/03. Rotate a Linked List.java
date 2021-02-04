/*
Company Tags:  Accolite Amazon MakeMyTrip
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1
*/


//Approach 01
class Rotate {
    public Node rotate(Node head, int k) {
        if (null == head) {
            return head;
        }

        Node slow, fast;
        slow = head;
        fast = head.next;

        while (null != fast && k>1) {
            slow = fast;
            fast = fast.next;
            k--;
        }

        if (null == fast) {
            return head;
        }

        slow.next = null;
        Node newHead = fast;

        while (null != fast.next) {
            fast = fast.next;
        }

        fast.next = head;

        return newHead;
    }
}
/*
Time Complexity: O(n)
Space Complexity: O(1)
*/


//Approach 02
class Rotate{
/*
To rotate a linked list by k, we can first make the linked list circular and then moving k-1 steps forward
from head node, making it null and make kth node as head.
*/

    public Node rotate(Node head, int k) {

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = head;

        curr = head;
        while (k-- != 1) {
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;

        return head;
    }
}
/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

