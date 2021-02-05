/*
Company Tags:   Accolite Amazon Flipkart MakeMyTrip Microsoft Morgan Stanley Qualcomm Snapdeal
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
*/

/* node for linked list
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Add {
    Node addTwoLists(Node first, Node second) {

        if (null == first) {
            return second;
        }
        if (null == second) {
            return first;
        }

        Node ll1 = first;
        Node ll2 = second;
        Node third = null;
        Node last = null;
        int sum, carry;
        carry = 0;

        while (null != ll1 && null != ll2) {
            sum = ll1.data + ll2.data + carry;
            Node ll3 = new Node(sum  % 10);
            carry = sum/10;

            if (null == third) {
                third = ll3;
                last = ll3;
            } else {
                last.next = ll3;
                last = last.next;
            }

            ll1 = ll1.next;
            ll2 = ll2.next;
        }

        while (null != ll1) {
            sum = ll1.data + carry;
            Node ll3 = new Node(sum % 10);
            carry = sum/10;

            last.next = ll3;
            last = last.next;

            ll1 = ll1.next;
        }

        while (null != ll2) {
            sum = ll2.data + carry;
            Node ll3 = new Node(sum % 10);
            carry = sum/10;

            last.next = ll3;
            last = last.next;

            ll2 = ll2.next;
        }

        if (carry != 0) {
            Node ll3 = new Node(carry);
            last.next = ll3;
            last = last.next;
        }

        return third;
    }
}

//Time Complexity: O(m+n) where m and n are the sizes of given two linked lists.