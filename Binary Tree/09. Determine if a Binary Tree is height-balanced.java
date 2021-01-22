/*

Company Tags: Amazon, Belzabar, Goldman Sachs, InMobi, Intel, Microsoft, Paytm, Synopsys, Walmart, Zillious

Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
LeetCode: https://leetcode.com/problems/balanced-binary-tree/
*/

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

//*********************************** Recursive *************************************
/*
ALGO:
We Do a POSTORDER traversal
We find the left & right subtree hight on the go, in each recursive call.
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (isBalancedHelper(root) != -1) {
            return true;
        }
        return false;
    }

    public int isBalancedHelper(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = isBalancedHelper(root.left);
        if (leftHeight == -1)
            return leftHeight;

        int rightHeight = isBalancedHelper(root.right);
        if (rightHeight == -1)
            return rightHeight;

        if (Math.abs(leftHeight-rightHeight) > 1)
            return -1;

        return leftHeight>rightHeight ? leftHeight + 1 : rightHeight + 1;
    }
}


//Depth First Traversals
//Time Complexity: O(n)
//Space Complexity:  O(n)