/*
Company Tags:   Accolite Amazon Belzabar Brocade FactSet Flipkart MakeMyTrip Microsoft OATS Systems Oracle Samsung Synopsys Zoho
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
*/

/************************************************** Reverse Solution ************************************************/

/* Structure of class Node is
class Node
{
	int data;
	Node next;

	Node(int d)
	{
		data = d;
		next = null;
	}
}*/
class Palindrome
{
    boolean isPalindrome(Node head) {
        if (null == head || null == head.next) {
            return true;
        }

        Node middle = getMiddle(head);
        Node second = middle.next;
        middle.next = null;

        second = reverseList(second);

        while (head != null && second != null) {
            if (head.data != second.data)  {
                return false;
            }
            head = head.next;
            second = second.next;
        }

        return true;
    }

    Node getMiddle(Node head)
    {
        if (null == head) {
            return head;
        }

        Node slow, fast;
        slow = head;
        fast = head.next;

        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    Node reverseList(Node head)
    {
        if (null == head || null == head.next) {
            return head;
        }

        Node x, y, z;
        x = head;
        y = head.next;
        z = head.next.next;

        x.next = null;

        while (null != z) {
            y.next = x;

            x = y;
            y = z;
            z = z.next;
        }

        y.next = x;

        return y;
    }
}
// Time complexity: O(n).
// Auxiliary Space: O(1)

/************************************************** Stack Solution **************************************************/

/* Structure of class Node is
class Node
{
	int data;
	Node next;

	Node(int d)
	{
		data = d;
		next = null;
	}
}*/
class Palindrome
{
    boolean isPalindrome(Node head)
    {
        if (head == null || head.next == null) {
            return true;
        }

        Stack<Node> stack = new Stack<>();

        Node curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            if (head.data != temp.data) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
}
// Time complexity: O(n).