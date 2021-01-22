/*

Company Tags: Accolite Adobe Amazon Flipkart Hike Housing.com MakeMyTrip Microsoft Morgan Stanley Ola Cabs Payu Teradata Walmart

Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1 (Try here)
LeetCode: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
*/

/*
// A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

//Approach-01
//*********************************** Iterative *************************************

/*
ALGO:
The idea is to use two stacks. We can use one stack for printing from left to right and other stack for printing from right to left.
In every iteration, we have nodes of one level in one of the stacks. We print the nodes, and push nodes of next level in other stack.
*/
class Spiral
{
    ArrayList<Integer> findSpiral(Node root)
    {
        ArrayList <Integer> arrayList = new ArrayList <>();
        if (root == null) return arrayList;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.add(root);

        while(!stack1.empty() || !stack2.empty()) {
            while(!stack1.empty()) {
                Node curr = stack1.pop();
                arrayList.add(curr.data);

                if (curr.right!=null) stack2.add(curr.right);
                if (curr.left!=null) stack2.add(curr.left);
            }

            while(!stack2.empty()) {
                Node curr = stack2.pop();
                arrayList.add(curr.data);

                if (curr.left!=null) stack1.add(curr.left);
                if (curr.right!=null) stack1.add(curr.right);
            }
        }

        return arrayList;
    }
}


//Time Complexity: O(n)
//Space Complexity:  O(n)

//Approach-02 (LeetCode specific Solution)
//*********************************** Iterative *************************************

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

/*
ALGO:
level.add(0, node.val) is used to add elements from front & level.add(node.val) is used to add elemets from back
zigzag flag is used to toggel.
*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        if (root == null) return finalList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean zigzag = false;

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                if (zigzag) {
                    level.add(0, node.val);
                }
                else {
                    level.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            finalList.add(level);
            zigzag = !zigzag;
        }
        return finalList;
    }
    // How level.add(0, node.val) is working, find here : https://ide.geeksforgeeks.org/beuAZ8aTIl
}

//Time Complexity: O(n)
//Space Complexity: O(n)