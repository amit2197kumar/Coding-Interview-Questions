/*
Company Tags:  Accolite Amazon Microsoft
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/construct-tree-1/1
LeetCode: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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

class Solution {
    int currIndexPre = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;
        TreeNode node = new TreeNode(preorder[currIndexPre++]);
        if (start == end) return node;

        int currNodeIndexInOrder = getInorderIndex(inorder, node.val);
        if (currNodeIndexInOrder < 0) return node;

        node.left = buildTreeHelper(preorder, inorder, start, currNodeIndexInOrder-1);
        node.right = buildTreeHelper(preorder, inorder, currNodeIndexInOrder+1, end);

        return node;
    }

    public int getInorderIndex(int[] inorder, int value) {
        for (int i=0; i<inorder.length; i++) {
            if (value == inorder[i]) return i;
        }
        return -1;
    }
}

/*
As we are searching in getInorderIndex()
Time Complexity: O(n^2). Worst case occurs when tree is left skewed. Example Preorder and Inorder traversals for worst
case are {A, B, C, D} and {D, C, B, A}.
*/

//************************************************Recursive Solution****************************************************

class Solution {
    int currIndexPre;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        currIndexPre = 0;
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder, 0, inorder.length-1, map);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int start, int end, HashMap<Integer, Integer> map) {
        if (start > end) return null;
        TreeNode node = new TreeNode(preorder[currIndexPre++]);
        if (start == end) return node;

        int currNodeIndexInOrder = map.get(node.val);

        node.left = buildTreeHelper(preorder, inorder, start, currNodeIndexInOrder-1, map);
        node.right = buildTreeHelper(preorder, inorder, currNodeIndexInOrder+1, end, map);

        return node;
    }
}

/*
Time Complexity : O(n)
*/