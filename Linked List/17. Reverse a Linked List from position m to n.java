/*
Company Tags:  Amazon Facebook Microsoft
Practice Portal:
Leetcode: https://leetcode.com/problems/reverse-linked-list-ii/
*/

// https://afteracademy.com/blog/reverse-a-linked-list-from-position-m-to-n

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode mPrev=null, nNext=null, mNode=null, nNode=null;
        m++;
        n++;

        ListNode temp = new ListNode(0);//dummy node
        temp.next = head;
        head = temp;

        ListNode curr = head;
        while (curr.next != null && n != 0) {
            m--;
            n--;

            // finding mth position node
            if (m == 1) {
                mPrev = curr;
                mNode = curr.next;
            }

            // finding nth position node
            if (n == 0) {
                nNode = curr;
                nNext = curr.next;
            }
            curr = curr.next;
        }

        // In case nth node is the last node of LL
        if (curr.next == null && n > 0) {
            nNode = curr;
            nNext = null;
        }

        nNode.next = null;

        mPrev.next = reverse(mNode);

        curr = mPrev.next;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = nNext;
        return head.next;
    }

    public ListNode reverse(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode one = head;
        ListNode two = one.next;
        ListNode three = two.next;
        one.next= null;

        while(null != two.next) {
            two.next = one;
            one = two;
            two = three;
            three = three.next;
        }
        two.next = one;
        return two;
    }
}

/*
Time Complexity: O(L), where L is the length of the linked list.
Space Complexity: O(1)
*/