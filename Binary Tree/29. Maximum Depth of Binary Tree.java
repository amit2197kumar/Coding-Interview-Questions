/*
Company Tags: Accolite Adobe Amazon

Practice Portal:
LeetCode: https://leetcode.com/problems/maximum-depth-of-binary-tree/
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
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return (left>right?left:right) + 1;
    }
}

//Depth First Traversals
//Time Complexity: O(n)