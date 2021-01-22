/*

Company Tags: Accolite Amazon Google

Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1
LeetCode: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
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

//Approach-01
//*********************************** Iterartive Stack Solution *************************************

/*
ALGO:
 Inspired from Inorder Iterartive implementation
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;

        while (!stack.isEmpty() || currNode != null) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();

            k--;
            if (k == 0)
                return currNode.val;

            currNode = currNode.right;
        }
        return -1;
    }
}


//Depth First Traversals
//Time Complexity: O(n)
//Space Complexity:  O(n)

//Approach-02
//*********************************** Recursive Solution *************************************

/*
ALGO:
Inspired from Inorder Recursive implementation
 */
class Solution {
    class NumTrack {
        int k;
        int kthValue;

        NumTrack(int k) {
            this.k = k;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        NumTrack numTrack = new NumTrack(k);
        inOrderTraversal(root, numTrack);
        return numTrack.kthValue;
    }

    public void inOrderTraversal(TreeNode root, NumTrack numTrack) {
        if (root == null)
            return;

        inOrderTraversal(root.left, numTrack);

        numTrack.k--;
        if (numTrack.k == 0)
            numTrack.kthValue = root.val;

        inOrderTraversal(root.right, numTrack);
    }
}

//Depth First Traversals
//Time Complexity: O(n)
//Space Complexity: O(n)