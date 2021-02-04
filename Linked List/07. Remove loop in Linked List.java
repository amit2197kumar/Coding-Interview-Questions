/*
Company Tags:   Adobe Amazon Goldman Sachs Kuliza MakeMyTrip Microsoft Morgan Stanley Netskope Oracle Qualcomm Snapdeal VMWare Walmart
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
*/

//Using Floyd’s Cycle-Finding Algorithm
class solver
{
    public static void removeTheLoop(Node head)
    {
        if (null != head && null != head.next) {
            Node fast, slow;
            fast = head;
            slow = head;

            while (null != fast && null != fast.next) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    break;
                }
            }

            if (null != fast && null != fast.next) {
                fast = head;
                while (fast.next != slow.next) {
                    fast = fast.next;
                    slow = slow.next;
                }

                slow.next = null;
            }
        }
    }
}

/*
Time complexity: O(n).
Auxiliary Space:O(1).
*/