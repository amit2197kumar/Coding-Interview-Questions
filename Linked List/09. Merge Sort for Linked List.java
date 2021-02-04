/*
Company Tags:   Accolite Adobe Amazon MAQ Software Microsoft Paytm Veritas
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/sort-a-linked-list/1
*/


class LinkedList
{
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
}

//Time Complexity: O(n Log n)


