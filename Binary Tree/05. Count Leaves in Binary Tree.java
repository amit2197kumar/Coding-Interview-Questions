/*
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
