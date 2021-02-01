/*
Company Tags:   Adobe Amazon Hike
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1
LeetCode: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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

//************************************************Recursive Solution****************************************************

//Check <Construct Binary Tree from Preorder and Inorder Traversal> for this approch

/*
As we are searching in getInorderIndex()
Time Complexity: O(n^2). Worst case occurs when tree is left skewed. Example Preorder and Inorder traversals for worst
case are {A, B, C, D} and {D, C, B, A}.
*/

//************************************************Recursive Solution****************************************************

class Solution {
    int currIndexPost;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        currIndexPost = inorder.length - 1;
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(postorder, inorder, 0, inorder.length-1, map);
    }

    public TreeNode buildTreeHelper(int[] postorder, int[] inorder, int start, int end, HashMap<Integer, Integer> map) {
        if (start > end) return null;
        TreeNode node = new TreeNode(postorder[currIndexPost--]);
        if (start == end) return node;

        int currNodeIndexInOrder = map.get(node.val);

        node.right = buildTreeHelper(postorder, inorder, currNodeIndexInOrder+1, end, map);
        node.left = buildTreeHelper(postorder, inorder, start, currNodeIndexInOrder-1, map);

        return node;
    }

}

/*
Time Complexity : O(n)
*/