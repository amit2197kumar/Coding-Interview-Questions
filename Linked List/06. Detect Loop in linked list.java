/*
Company Tags:   Accolite Amazon D-E-Shaw Hike Lybrate Mahindra Comviva MakeMyTrip MAQ Software OYO Rooms Paytm
Qualcomm Samsung SAP Labs Snapdeal Veritas VMWare Walmart
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
*/


//Floyd’s Cycle-Finding Algorithm
class Solution {
    public int detectLoop(Node head) {

        Node fast, slow;
        slow = head;
        fast = head;

        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return 1;
            }
        }
        return 0;
    }
}

/*
Time complexity: O(n).
Only one traversal of the loop is needed.
Auxiliary Space:O(1).
There is no space required.
*/