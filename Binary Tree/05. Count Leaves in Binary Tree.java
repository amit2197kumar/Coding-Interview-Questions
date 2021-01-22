/*
Company Tags: Ola Cabs Samsung
Practice Portal: https://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1
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

//Approach-01
//*********************************** Recursive *************************************

/*
ALGO:
getLeafCount(node)
1) If node is NULL then return 0.
2) Else If left and right child nodes are NULL return 1.
3) Else recursively calculate leaf count of the tree using below formula.
    Leaf count of a tree = Leaf count of left subtree + Leaf count of right subtree
*/
class Tree
{
    int countLeaves(Node root)  {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        return countLeaves(root.left) + countLeaves(root.right);
    }
}



//Depth First Traversals
//Time Complexity: O(n)
//Space Complexity: O(n)

//Approach-02
//*********************************** Iterartive *************************************

/*
ALGO:
1. We do level Order Iterative traversal
2. We check for every poped node If left and right child nodes are NULL, and count that number
 */
class Tree
{
    int countLeaves(Node root)  {
        if (root == null)
            return 0;

        int leafCount = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            Node curr = queue.remove();

            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);

            if (curr.left == null && curr.right == null)
                leafCount++;
        }
        return leafCount;
    }
}

//Breadth First Traversals
//Time Complexity: O(n)
//Space Complexity: O(n)
