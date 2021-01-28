/*
Company Tags: Accolite Amazon FactSet Hike Kritikal Solutions Microsoft Morgan Stanley OYO Rooms Payu Samsung Snapdeal

Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
*/

/*
Logic:
We break the problem in 3 parts:
1. Print the left boundary in top-down manner.
2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
    2.1 Print all leaf nodes of left sub-tree from left to right.
    2.2 Print all leaf nodes of right subtree from left to right.
3. Print the right boundary in bottom-up manner.
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

class Solution
{
    ArrayList <Integer> printBoundary(Node root) {
        ArrayList <Integer> arrayList = new ArrayList <>();
        if (root == null) return arrayList;
        //return arrayList;
        arrayList.add(root.data);

        getLeftView(root.left, arrayList);
        getLeafView(root.left, arrayList);
        getLeafView(root.right, arrayList);
        getRightView(root.right, arrayList);

        return arrayList;
    }

    void getLeftView(Node root, ArrayList <Integer> arrayList) {
        if (root == null) return;

        if (root.left != null) {
            arrayList.add(root.data);
            getLeftView(root.left, arrayList);
        } else if (root.right != null){
            arrayList.add(root.data);
            getLeftView(root.right, arrayList);
        }
    }

    void getLeafView(Node root, ArrayList <Integer> arrayList) {
        if (root == null) return;

        getLeafView(root.left, arrayList);
        if (root.left == null && root.right == null) {
            arrayList.add(root.data);
        }
        getLeafView(root.right, arrayList);
    }

    void getRightView(Node root, ArrayList <Integer> arrayList) {
        if (root == null) return;

        if (root.right != null) {
            getRightView(root.right, arrayList);
            arrayList.add(root.data);
        } else if (root.left != null){
            getRightView(root.left, arrayList);
            arrayList.add(root.data);
        }
    }
}

//Depth First Traversals
//Time Complexity: O(n) where n is the number of nodes in binary tree.