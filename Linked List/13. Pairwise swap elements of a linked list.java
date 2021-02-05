/*
Company Tags:  Amazon Intuit Microsoft Moonfrog Labs
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/pairwise-swap-elements-of-a-linked-list-by-swapping-data/1
*/

// This Q is dependent on : Reverse a Linked List in groups of given size.
// Try here: https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1

/************************************************** Recursive Solution ************************************************/

/* node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node pairwiseSwap(Node head)
    {
        return reverse(head, 2);
    }

    public static Node reverse(Node head, int k)
    {
        if(head==null||head.next==null)
            return head ;

        if(k==1)
            return head ;

        int i=2 ;

        Node one=head ;
        Node two=one.next ;
        Node three=two.next ;

        one.next=null ;
        two.next=one ;

        while(i!=k&&three!=null)
        {
            one=two ;
            two=three ;
            three=three.next ;

            two.next=one ;
            i++ ;
        }

        if(three!=null)
            head.next=reverse(three,k) ;

        return two ;
    }
}

/************************************************** Iterative Solution ************************************************/

/* node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node pairwiseSwap(Node head)
    {
        return reverse(head, 2);
    }

    public static Node reverse(Node node, int k)
    {
        if (node == null || k <= 1)
            return node;

        Stack<Node> stack = new Stack<>();
        Node prev = null;
        Node curr = node;
        Node newHead = null;
        int count;

        while (curr != null) {

            count = 0;
            while (curr !=null && count < k) {
                stack.push(curr);
                curr = curr.next;
                count++;
            }

            while (stack.size() > 0) {
                Node temp = stack.pop();

                if (prev == null) {
                    newHead = temp;
                } else {
                    prev.next = temp;
                }

                prev = temp;
            }
        }
        prev.next = null;
        return newHead;
    }
}