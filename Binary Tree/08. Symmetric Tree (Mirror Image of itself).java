/*
Company Tags: Amazon

Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/symmetric-tree/1
LeetCode: https://leetcode.com/problems/symmetric-tree/
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
//*********************************** Recursive *************************************
/*
ALGO:
We use the Logic of Recursive isSameTree(Check if 2 trees are identical)
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root, root);
    }

    public boolean isSymmetricHelper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        return isSymmetricHelper(root1.left, root2.right) && isSymmetricHelper(root1.right, root2.left);
    }
}


//Depth First Traversals
//Time Complexity: O(n)
//Space Complexity:  O(n)

//Approach-02
//*********************************** Iterartive *************************************


/*
ALGO:
We use the Logic of Iterartive isSameTree(Check if 2 trees are identical)
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root, root);
    }

    public boolean isSymmetricHelper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(root1);
        queue2.add(root2);

        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode curr1 = queue1.remove();
            TreeNode curr2 = queue2.remove();

            if (curr1.val != curr2.val)
                return false;

            if (curr1.left != null && curr2.right != null) {
                queue1.add(curr1.left);
                queue2.add(curr2.right);
            } else if (curr1.left != null || curr2.right != null) {
                return false;
            }

            if (curr1.right != null && curr2.left != null) {
                queue1.add(curr1.right);
                queue2.add(curr2.left);
            } else if (curr1.right != null || curr2.left != null) {
                return false;
            }
        }
        return true;
    }
}

//Breadth First Traversals
//Time Complexity: O(n)
//Space Complexity: O(n)