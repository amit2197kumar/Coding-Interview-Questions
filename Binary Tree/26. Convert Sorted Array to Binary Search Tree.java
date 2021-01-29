/*
Company Tags:  Amazon Oracle Samsung

Practice Portal:
LeetCode: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBSTHelper(int[] arr, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = sortedArrayToBSTHelper(arr, start, mid - 1);
        root.right = sortedArrayToBSTHelper(arr, mid + 1, end);

        return root;
    }
}

//Depth First Traversals
//Time Complexity: O(n)

//Iterative : https://afteracademy.com/blog/sorted-array-to-balanced-bst