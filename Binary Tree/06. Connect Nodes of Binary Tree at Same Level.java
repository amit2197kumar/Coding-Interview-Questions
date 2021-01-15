/*
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1 (Better to try here for this Q)
LeetCode: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

//Approach-01 (This will ONLY work on LeetCode due to its Constraints)
//*********************************** Recursive *************************************

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;

        if (root.left != null)
            root.left.next = root.right;

        if (root.right != null && root.next != null)
            root.right.next = root.next.left;

        connect(root.left);
        connect(root.right);
        return root;
    }
}


//Depth First Traversals
//Time Complexity: O(n)
//Space Complexity: O(n)

//Approach-02
//*********************************** Iterartive *************************************

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int index=1; index<=size; index++) {
                Node currNode = queue.remove();
                if (index < size) {
                    currNode.next = queue.peek();
                } else {
                    currNode.next = null;
                }

                if (currNode.left != null)
                    queue.add(currNode.left);
                if (currNode.right != null)
                    queue.add(currNode.right);
            }
        }
        return root;
    }
}

//Breadth First Traversals
//Time Complexity: O(n)
//Space Complexity: O(n)
