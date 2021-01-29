/*
Company Tags:  Amazon Cadence India Directi MakeMyTrip Microsoft Oracle OYO Rooms Philips PropTiger Salesforce Snapdeal VMWare

Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
Leetcode: https://leetcode.com/problems/diameter-of-binary-tree/
*/

/*
The diameter of a tree T is the largest of the following quantities:
the diameter of T’s left subtree.
the diameter of T’s right subtree.
the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)

Implementation: https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
Time Complexity: O(n2)
*/

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

class Tree {
    class Max{
        int max;
        Max() {
            max = 0;
        }
    }

    int diameter(Node root) {
        Max maxObj = new Max();
        int random=diameterHelper(root, maxObj);
        return maxObj.max;
    }

    int diameterHelper (Node root, Max maxObj) {
        if (root == null)
            return 0;
        int left = diameterHelper(root.left, maxObj);
        int right = diameterHelper(root.right, maxObj);

        maxObj.max = left+right+1 > maxObj.max ? left+right+1 : maxObj.max;

        return left > right ? left+1 : right+1;
    }
}

//Depth First Traversals
//Time Complexity: O(n)
