/*
Company Tags:   Accolite Amazon Goldman Sachs Microsoft
Practice Portal:
LeetCode: https://leetcode.com/problems/binary-tree-maximum-path-sum/
*/

/*
ALGO:
There can only be four different cases when a particular node is involved in the max path.

Its the only Node
Max path through Left Child + Node
Max path through Right Child + Node
Max path through Left Child + Node + Right Child
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
class Solution {
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return maxValue;
    }

    public int maxPathSumUtil(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = maxPathSumUtil(root.left);
        int rightSum = maxPathSumUtil(root.right);

        int currMaxPathTowardsUp = Math.max(root.val, root.val + Math.max(leftSum, rightSum));
        int currMaxLine = Math.max(currMaxPathTowardsUp, root.val + leftSum + rightSum);

        maxValue = Math.max(maxValue, currMaxLine);
        return currMaxPathTowardsUp;
    }
}

//Time Complexity: O(n) where n is number of nodes in Binary Tree.