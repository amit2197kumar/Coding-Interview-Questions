/*
Company Tags:    Amazon Google Microsoft
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1
*/

/*
Approach 01:
Do InOrder Traversal for both Trees T1 and T2
Save InOrder Traversal data in array
Mearge Array & sort

Time Complexity : O(nlogn)
*/

/*
Approach 02:
Use Priority Queue.

Time Complexity : O(nlogn)
*/

/**
 * Approach 03: [Iterative 2 Stack]
 *
 * Best linear approach using 2 stacks with O(m+n) runtime and O(h1+h2) spacetime
 * iterative inorder approach using 2 stacks for both trees
 * whenever we encounter elements from stacks we do 2 things
 * step 1. compare them, print smaller one, and make it traverse
 * step 2. push back the bigger one back to stack for next comparison.
 * Runtime: O(m+n) where m,n = nodes on tree1 and tree2
 * Spacetime: O(h1+h2) where h1,h2 = heights of tree1 and tree2
 */

/************************************************Iterative Solution****************************************************/

/*
// A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution{
    public List<Integer> merge(Node root1,Node root2)
    {
        List<Integer> list = new ArrayList<Integer>();

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        while (root1 != null || root2 != null || (s1.isEmpty() != true && s2.isEmpty() != true)) {

            while(root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            }

            while(root2 != null) {
                s2.push(root2);
                root2 = root2.left;
            }

            if (s1.peek().data < s2.peek().data) {
                Node curr = s1.pop();
                list.add(curr.data);
                root1 = curr.right;
            } else {
                Node curr = s2.pop();
                list.add(curr.data);
                root2 = curr.right;
            }
        }

        if (s1.isEmpty() != true) {
            inOrderFromStack(s1, list);
        }

        if (s2.isEmpty() != true) {
            inOrderFromStack(s2, list);
        }

        return list;
    }

    public void inOrderFromStack(Stack<Node> stack, List<Integer> list) {
        Node curr = null;
        while (curr != null || stack.isEmpty() != true) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            list.add(curr.data);
            curr = curr.right;
        }
    }
}

/*
* Runtime: O(m+n) where m,n = nodes on tree1 and tree2
* Spacetime: O(h1+h2) where h1,h2 = heights of tree1 and tree2
*/
