/*
Company Tags:  Amazon BankBazaar FactSet Microsoft Walmart

Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1
*/

/************************************************Recursive Solution****************************************************/

/*
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

class Sol
{
    Node first = null, second = null, third = null, prev = null;
    public Node correctBST(Node root) {
        if (root == null) return root;
        inorderBST(root);

        if (third == null) {
            swapNode(first, second);
        } else {
            swapNode(first, third);
        }
        return root;
    }

    public void inorderBST(Node root) {
        if (root == null) return;
        inorderBST(root.left);
        if (prev != null) {
            if (prev.data > root.data) {
                if (first == null) {
                    first = prev;
                    second = root;
                } else {
                    third = root;
                }
            }
        }
        prev = root;
        inorderBST(root.right);
    }

    public void swapNode(Node first, Node second) {
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }
}

//Depth First Traversals
//Time Complexity: O(n)