/*
Company Tags:  Accolite Amazon American Express Cisco Expedia Flipkart MakeMyTrip Microsoft OYO Rooms PayPal Payu Snapdeal Times Internet Twitter
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
LeetCode: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
Note:
This solution take assumption that both p and q lies in the Binary Tree.
This solution take assumption that both p and q are different.
This solution take assumption that all elements are unique in the Binary Tree. [IMPORTANT]
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;

        if (root == p)
            return root;
        if (root == q)
            return root;

        TreeNode checkNodeInLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode checkNodeInRight = lowestCommonAncestor(root.right, p, q);

        if (checkNodeInLeft != null && checkNodeInRight != null)
            return root;

        if (checkNodeInLeft != null)
            return checkNodeInLeft;
        else
            return checkNodeInRight;
    }
}

/*
Time Complexity: The time complexity of the above solution is O(n) as the method does a simple tree traversal in a
bottom-up fashion
*/