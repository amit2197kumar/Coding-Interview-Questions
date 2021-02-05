/*
Company Tags:   Adobe Amazon Flipkart GE Hike IgniteWorld MAQ Software Microsoft Morgan Stanley Nagarro Netskope Payu
Qualcomm Samsung SAP Labs Veritas VMWare Wipro Zoho
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1
*/

/************************************************** Iterative Solution ************************************************/

/*
Traverse linked list using two pointers. Move one pointer by one and the other pointers by two.
When the fast pointer reaches the end slow pointer will reach the middle of the linked list.
*/

/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class GFG
{
    int getMiddle(Node head)
    {
        if (null == head) {
            return -1;
        }

        Node slow, fast;
        slow = head;
        fast = head;

        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }
}

//Time Complexity: O(n)
//Auxiliary Space: O(1)

/*
Initialize mid element as head and initialize a counter as 0. Traverse the list from head, while traversing increment the
counter and change mid to mid->next whenever the counter is odd. So the mid will move only half of the total length of the list.
*/
/************************************************** Recursive Solution ************************************************/