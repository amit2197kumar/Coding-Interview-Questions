/*
Company Tags:    Accolite Adobe Amazon Cisco Cognizant D-E-Shaw Goldman Sachs IgniteWorld Intuit Mahindra Comviva MakeMyTrip
Microsoft Paytm Qualcomm Samsung SAP Labs Snapdeal Tejas Network Teradata VMWare Walmart Zoho
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
*/

/************************************************** Iterative Solution ************************************************/
/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/
class ReverseLL
{
    Node reverseList(Node head)
    {
        if (null == head || null == head.next) return head;
        Node one = head;
        Node two = one.next;
        Node three = two.next;
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
Time Complexity: O(n)
Space Complexity: O(1)
*/

/************************************************** Recursive Solution ************************************************/
/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/
class ReverseLL
{
    Node reverseList(Node head)
    {
        return reverseListHelper(head, null);
    }

    Node reverseListHelper(Node head, Node prev) {
        if (head == null)
            return prev;

        Node temp = head.next;
        head.next = prev;

        return reverseListHelper(temp, head);
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

// Can solve this Q using Stack as well