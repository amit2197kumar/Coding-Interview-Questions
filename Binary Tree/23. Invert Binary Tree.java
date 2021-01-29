/*
Company Tags:  Amazon Facebook

Practice Portal:
LeetCode: https://leetcode.com/problems/invert-binary-tree/
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        //swap
        TreeNode temp = root.left;
        root.left = right;
        root.right = temp;

        return root;
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);

        while (que.size() > 0) {
            TreeNode curr = que.remove();

            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if (curr.left != null) {
                que.add(curr.left);
            }

            if (curr.right != null) {
                que.add(curr.right);
            }
        }

        return root;
    }
}

//Breadth First Traversals
//Time Complexity: O(n)

