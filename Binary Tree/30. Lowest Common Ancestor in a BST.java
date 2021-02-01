/*
Company Tags: Accolite Amazon Flipkart MAQ Software Microsoft Samsung Synopsys
Practice Portal:
GFG: https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
LeetCode: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
*/

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

//************************************************Recursive Solution****************************************************

class BST
{
    Node LCA(Node root, int n1, int n2) {
        if (root == null)
            return root;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if(root.data>n1 && root.data>n2)
            return(LCA(root.left, n1, n2)) ;

        // If both n1 and n2 are greater than root, then LCA lies in right
        if(root.data<n1 && root.data<n2)
            return(LCA(root.right, n1, n2)) ;

        return root ;
    }
}

/*
Time Complexity: O(h).
The time Complexity of the above solution is O(h), where h is the height of the tree.
Space Complexity: O(1).
If recursive stack space is ignored, the space complexity of the above solution is constant.
*/

//************************************************Iterative Solution****************************************************

class BST
{
    Node LCA(Node root, int n1, int n2) {

        while (root != null) {

            // If both n1 and n2 are smaller than root, then LCA lies in left
            if (root.data > n1 && root.data > n2)
                root = root.left;

                // If both n1 and n2 are greater than root, then LCA lies in right
            else if (root.data < n1 && root.data < n2)
                root = root.right;

            else
                break;
        }

        return root;
    }
}

/*
Time Complexity: O(h).
The time Complexity of the above solution is O(h), where h is the height of the tree.
Space Complexity: O(1).
If recursive stack space is ignored, the space complexity of the above solution is constant.
*/
