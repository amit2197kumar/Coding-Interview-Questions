/*
Company Tags:  Amazon Facebook Housing.com Microsoft Oracle Samsung

Practice Portal:
LeetCode: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
*/

/************************************************Recursive Solution****************************************************/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        while (root != null) {
            if (root.left != null) {
                TreeNode tempLeftNode = root.left;

                while (tempLeftNode.right != null)
                    tempLeftNode = tempLeftNode.right;

                tempLeftNode.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}

//Depth First Traversals
//Time Complexity: O(n)

/************************************************Iterative Solution****************************************************/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (stack.size() > 0) {
            TreeNode currNode = stack.pop();

            if (currNode.right != null)
                stack.push(currNode.right);

            if (currNode.left != null)
                stack.push(currNode.left);

            if (stack.size() > 0)
                currNode.right = stack.peek();
            currNode.left = null;
        }
    }
}

//Depth First Traversals
//Time Complexity: O(n)

