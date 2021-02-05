/*
Company Tags:  Amazon MakeMyTrip Microsoft
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
*/
/************************************************** Working but not good Solution ******************************************/

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class LinkedList
{
    static Node segregate(Node head)
    {
        int zero, one, two;
        zero = 0;
        one = 0;
        two = 0;

        Node node = head;
        while(null != node) {
            if (node.data == 0) {
                zero++;
            } else if (node.data == 1) {
                one++;
            } else if (node.data == 2) {
                two++;
            }
            node = node.next;
        }

        node = head;
        while(zero != 0) {
            node.data = 0;
            node = node.next;
            zero--;
        }

        while(one != 0) {
            node.data = 1;
            node = node.next;
            one--;
        }

        while(two != 0) {
            node.data = 2;
            node = node.next;
            two--;
        }

        return head;
    }
}

// Time complexity: O(n).
// Auxiliary Space: O(1)

/************************************************** Better Solution ************************************************/


/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class LinkedList
{
    static Node segregate(Node head)
    {
        if (head == null || head.next == null)
            return head;

        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);

        Node zeroE, oneE, twoE;
        zeroE = zero;
        oneE = one;
        twoE = two;

        while (head != null) {
            if (head.data == 0) {
                zeroE.next = head;
                zeroE = zeroE.next;
                head = head.next;
            } else if (head.data == 1) {
                oneE.next = head;
                oneE = oneE.next;
                head = head.next;
            } else {
                twoE.next = head;
                twoE = twoE.next;
                head = head.next;
            }
        }

        zeroE.next = null;
        oneE.next = null;
        twoE.next = null;


        if (two.next != null) {
            oneE.next = two.next;
        }

        if (one.next != null) {
            zeroE.next = one.next;
        }

        return zero.next;
    }
}

// Time complexity: O(n).
// Auxiliary Space: O(1)

