/*
Company Tags:   24*7 Innovation Labs Amazon Drishti-Soft Flipkart Goldman Sachs Microsoft Paytm Payu Qualcomm Snapdeal Visa
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
*/

/*************************************************** Using PriorityQueue ***********************************************/
/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;

	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
class GfG
{
    Node flatten(Node head)
    {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.data - b.data;
            }
        });

        Node curr;

        while (head != null) {
            curr = head.bottom;
            while(curr != null) {
                minHeap.add(curr);
                curr = curr.bottom;
            }
            minHeap.add(head);
            head = head.next;
        }

        head = minHeap.remove();
        curr = head;

        while(minHeap.size() > 0) {
            Node temp = minHeap.remove();
            curr.bottom = temp;
            curr = curr.bottom;
        }

        return head;
    }
}

// Time Complexity = ?? (Think)
/*************************************************** Using PriorityQueue ***********************************************/

/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;

	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
class GfG
{
    Node flatten(Node head)
    {
        if (head == null || head.next == null)
            return head;

        Node last = flatten(head.next);
        return mergeTwoLists(head, last);
    }

    Node mergeTwoLists(Node list1, Node list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        Node start, end;

        if (list1.data < list2.data) {
            start = list1;
            list1 = list1.bottom;
        } else {
            start = list2;
            list2 = list2.bottom;
        }

        end = start;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                end.bottom = list1;
                list1 = list1.bottom;
            } else {
                end.bottom = list2;
                list2 = list2.bottom;
            }
            end = end.bottom;
        }

        if (list1 != null) {
            end.bottom = list1;
        }

        if (list2 != null) {
            end.bottom = list2;
        }

        return start;
    }
}

/*
Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(1)
*/