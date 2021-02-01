/*
Company Tags:
Practice Portal:
LeetCode: https://leetcode.com/problems/path-sum-ii/
*/

//************************************************Recursive Solution****************************************************

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result  = new LinkedList<List<Integer>>();
        List<Integer> currentResult  = new LinkedList<Integer>();
        pathSum(root,sum,currentResult,result);
        return result;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        currentResult.add(root.val);
        sum = sum - root.val;

        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<Integer>(currentResult));
        }

        pathSum(root.left, sum, currentResult, result);
        pathSum(root.right, sum, currentResult, result);
    }
}

/*
Time Complexity: O(n).
*/