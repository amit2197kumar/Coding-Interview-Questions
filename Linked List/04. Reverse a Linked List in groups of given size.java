/*
Company Tags:   Accolite Adobe Amazon Goldman Sachs Hike MakeMyTrip Microsoft Paytm SAP Labs Snapdeal VMWare Walmart
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1
*/

/************************************************** Recursive Solution ************************************************/

class gfg
{
    Node reverse(Node head, int k)
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

/*
Time Complexity: O(n).
Traversal of list is done only once and it has ‘n’ elements.
Auxiliary Space: O(n/k).
For each Linked List of size n, n/k or (n/k)+1 calls will be made during the recursion.
*/

/************************************************** Iterative Solution ************************************************/

class GfG
{
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

/*
Time Complexity: O(n).
Traversal of list is done only once and it has ‘n’ elements.
This algorithm uses O(k) extra space
*/
