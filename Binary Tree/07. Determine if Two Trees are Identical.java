/*
Company Tags: Amazon Microsoft

Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1
LeetCode: https://leetcode.com/problems/same-tree/
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
1. If both trees are empty then return 1.
2. Else If both trees are non -empty
     (a) Check data of the root nodes (tree1->data ==  tree2->data)
     (b) Check left subtrees recursively  i.e., call sameTree(
          tree1->left_subtree, tree2->left_subtree)
     (c) Check right subtrees recursively  i.e., call sameTree(
          tree1->right_subtree, tree2->right_subtree)
     (d) If a,b and c are true then return 1.
3  Else return 0 (one is empty and other is not)
*/

class Solution {
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}


//Depth First Traversals
//Time Complexity: Complexity of the isSameTree() will be according to the tree with lesser number of nodes. Let number of nodes in two trees be m and n then complexity of isSameTree() is O(m) where m < n.
//Space Complexity: Complexity of the isSameTree() will be according to the tree with lesser number of nodes. Let number of nodes in two trees be m and n then complexity of isSameTree() is O(m) where m < n.

//Approach-02
//*********************************** Iterartive *************************************

/*
ALGO:
1. We use Level Order Iterative Approch
*/
class Solution {
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
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

            if (curr1.left != null && curr2.left != null) {
                queue1.add(curr1.left);
                queue2.add(curr2.left);
            } else if (curr1.left != null || curr2.left != null) {
                return false;
            }

            if (curr1.right != null && curr2.right != null) {
                queue1.add(curr1.right);
                queue2.add(curr2.right);
            } else if (curr1.right != null || curr2.right != null) {
                return false;
            }
        }
        return true;
    }
}

//Breadth First Traversals
//Time Complexity: Complexity of the isSameTree() will be according to the tree with lesser number of nodes. Let number of nodes in two trees be m and n then complexity of isSameTree() is O(m) where m < n.
//Space Complexity: Complexity of the isSameTree() will be according to the tree with lesser number of nodes. Let number of nodes in two trees be m and n then complexity of isSameTree() is O(m) where m < n.
