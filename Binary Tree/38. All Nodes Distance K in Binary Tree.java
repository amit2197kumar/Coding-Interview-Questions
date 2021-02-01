/*
Company Tags:    Accolite Amazon Flipkart Goldman Sachs Hike Ola Cabs Samsung Walmart
Practice Portal:
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1
LeetCode: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
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
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> listOfElements = new ArrayList<Integer>();
        distanceKUtil(root, target, k, listOfElements);
        return listOfElements;
    }

    /*
    Algo:
    1. First step will be to find the target element in the tree recursively.
    2. When Target is found we first print all the node at k distnce that are below the target node in left/right subtree.
    3. Now we go each level up, first we return k-1.
    4. Now returned value becomes the new k for the ancestor nodes of target.
    5. At each ancestor
        i) If updated retued k value is ZERO, that means ancestor is also the k'th element.
        ii) If target was found in left/right subtree we find updated k-1(th) elemets in the other right/left subtree.

    */

    public int distanceKUtil(TreeNode root, TreeNode target, int k, List<Integer> listOfElements) {
        //Base Case
        if (root == null)
            return -1;

        //We found the target
        if (root == target) {
            printDownDistanceKElement(root, k, listOfElements);
            return k-1;
        }

        int leftDistance = distanceKUtil(root.left, target, k, listOfElements);
        //leftDistance is the new k

        if (leftDistance > -1) {
            if (leftDistance == 0) {
                listOfElements.add(root.val);
            } else {
                printDownDistanceKElement(root.right, leftDistance-1, listOfElements);
            }
            //As we return, we go one level up, so value of k become one less
            return leftDistance-1;
        }

        int rightDistance = distanceKUtil(root.right, target, k, listOfElements);
        //rightDistance is the new k

        if (rightDistance > -1) {
            if (rightDistance == 0) {
                listOfElements.add(root.val);
            } else {
                printDownDistanceKElement(root.left, rightDistance-1, listOfElements);
            }
            //As we return, we go one level up, so value of k become one less
            return rightDistance-1;
        }

        // Target not found in either left side nor right side
        return -1;
    }

    public void printDownDistanceKElement(TreeNode root, int k, List<Integer> listOfElements) {
        //Base Case
        if (root == null || k < 0)
            return;

        if (k == 0) {
            listOfElements.add(root.val);
            return;
        }

        printDownDistanceKElement(root.left, k-1, listOfElements);
        printDownDistanceKElement(root.right, k-1, listOfElements);
    }
}

/*
Time Complexity: At first look the time complexity looks more than O(n), but if we take a closer look, we can observe
that no node is traversed more than twice. Therefore the time complexity is O(n).
*/
