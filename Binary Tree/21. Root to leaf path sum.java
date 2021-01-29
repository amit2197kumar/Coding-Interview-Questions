/*
Company Tags:   Accolite Adobe Amazon CouponDunia FactSet Goldman Sachs Housing.com Microsoft Oracle Samsung

Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/root-to-leaf-path-sum/1
Leetcode: https://leetcode.com/problems/path-sum/
*/

/*
// A Binary Tree node
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Tree {
    /*you are required to complete this function */
    boolean hasPathSum(Node root, int sum) {
        // Your code here
        if (root == null && sum != 0) return false;
        if (root == null && sum == 0) return true;

        Boolean left = hasPathSum(root.left, sum-root.data);
        Boolean right = hasPathSum(root.right, sum-root.data);

        if(left || right) {
            return true;
        }
        return false;
    }
}

//Depth First Traversals
//Time Complexity: O(n)

//For Iterative solution check : https://afteracademy.com/blog/path-sum-in-binary-tree