/*
Company Tags: Accolite Amazon Samsung SAP Labs

Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
*/

/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/

//Approach-01
//*********************************** Iterartive Stack Solution *************************************

/*
ALGO:
 Inspired from Inorder Iterartive implementation
 */
class Tree
{
    public int kthLargest(Node root,int k)
    {
        Node curr = root;
        Stack<Node> stack = new Stack<Node>();
        while (curr != null || stack.size() > 0) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();

            k--;
            if (k==0) return curr.data;

            curr = curr.left;
        }
        return -1;
    }
}

//Depth First Traversals
//Time Complexity: O(n)
//Space Complexity:  O(n)

//Approach-02
//*********************************** Recursive Solution *************************************

/*
ALGO:
Inspired from Inorder Recursive implementation
 */
class Tree
{
    class NumTrack {
        int k;
        int kthValue;

        NumTrack(int k) {
            this.k = k;
        }
    }

    public int kthLargest(Node root,int k) {
        NumTrack numTrack = new NumTrack(k);
        inOrderTraversal(root, numTrack);
        return numTrack.kthValue;
    }

    public void inOrderTraversal(Node root, NumTrack numTrack) {
        if (root == null)
            return;

        inOrderTraversal(root.right, numTrack);

        numTrack.k--;
        if (numTrack.k == 0)
            numTrack.kthValue = root.data;

        inOrderTraversal(root.left, numTrack);
    }
}

//Depth First Traversals
//Time Complexity: O(n)
//Space Complexity: O(n)