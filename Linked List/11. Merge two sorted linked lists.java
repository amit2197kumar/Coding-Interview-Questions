/*
Company Tags:   Accolite Amazon Belzabar Brocade FactSet Flipkart MakeMyTrip Microsoft OATS Systems Oracle Samsung Synopsys Zoho
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
*/

/************************************************** Iterative Solution ************************************************/

class LinkedList
{
    Node sortedMerge(Node headA, Node headB) {
        if (null == headA) return headB;
        if (null == headB) return headA;

        Node headC, curr;
        if (headA.data > headB.data) {
            headC = headB;
            headB = headB.next;
        } else {
            headC = headA;
            headA = headA.next;
        }
        curr = headC;

        while (null != headA && null != headB) {
            if (headA.data < headB.data) {
                curr.next = headA;
                headA = headA.next;
            } else {
                curr.next = headB;
                headB = headB.next;
            }
            curr = curr.next;
        }

        if (null != headA) curr.next = headA;
        if (null != headB) curr.next = headB;

        return headC;
    }
}

/*
Time Complexity : O(n+m)
Auxilliary Space : O(1)
*/

/************************************************** Recursive Solution ************************************************/

class LinkedList
{
    Node sortedMerge(Node headA, Node headB) {
        if (headA == null)
            return headB;
        if (headB == null)
            return headA;

        if (headA.data < headB.data) {
            headA.next = sortedMerge(headA.next, headB);
            return headA;
        } else {
            headB.next = sortedMerge(headA, headB.next);
            return headB;
        }
    }
}

//  time complexity is O(m+n)