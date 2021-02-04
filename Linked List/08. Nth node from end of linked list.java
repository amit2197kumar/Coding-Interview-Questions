/*
Company Tags:  Accolite Adobe Amazon Citicorp Epic Systems FactSet Hike MAQ Software Monotype Solutions
Morgan Stanley OYO Rooms Qualcomm Samsung Snapdeal
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
*/

class GfG
{
    int getNthFromLast(Node head, int n)
    {
        if (null == head || n<1) {
            return -1;
        }

        Node fast, slow;
        fast = head;
        slow = head;

        while (n != 1 && null != fast) {
            fast = fast.next;
            n--;
        }

        if (null == fast) {
            return -1;
        }

        while (null != fast.next) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.data;
    }
}

//    Time Complexity: O(n) where n is the length of linked list.