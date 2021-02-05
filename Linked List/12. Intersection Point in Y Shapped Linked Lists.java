/*
Company Tags:   Accolite Adobe Amazon D-E-Shaw FactSet Flipkart Goldman Sachs MakeMyTrip MAQ Software Microsoft Qualcomm
Snapdeal Visa VMWare
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1
*/

/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}
*/

class Intersect
{
    int intersectPoint(Node headA, Node headB)
    {
        int ll1len = linkedListLength(headA);
        int ll2len = linkedListLength(headB);
        int diff = Math.abs(ll1len-ll2len);

        if (ll1len > ll2len) {
            while (diff > 0) {
                headA = headA.next;
                diff --;
            }
        } else {
            while (diff > 0) {
                headB = headB.next;
                diff --;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA.data;
    }

    int linkedListLength(Node ll) {
        int count = 0;
        while (null != ll) {
            ll = ll.next;
            count++;
        }
        return count;
    }
}


/*
Time Complexity: O(m+n)
Auxiliary Space: O(1)
*/