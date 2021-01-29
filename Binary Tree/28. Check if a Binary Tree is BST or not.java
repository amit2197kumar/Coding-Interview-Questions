/*
Company Tags: Accolite Adobe Amazon Boomerang Commerce FactSet Flipkart Goldman Sachs GreyOrange Hike Linkedin MakeMyTrip
MAQ Software Microsoft Ola Cabs OYO Rooms Qualcomm Samsung Snapdeal VMWare Walmart Wooker

Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/check-for-bst/1
*/

/************************************************Recursive Solution****************************************************/

/*
Structure of Node:
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

public class Tree
{
    // return true if the given tree is a BST, else return false
    boolean isBST(Node root) {
        if (root == null)
            return true;
        int currMin = Integer.MIN_VALUE;
        int currMax = Integer.MAX_VALUE;

        return isBSTHelper(root, currMin, currMax);
    }

    boolean isBSTHelper(Node root, int currMin, int currMax) {
        if (root == null) return true;

        if (root.data <= currMin || root.data >= currMax)
            return false;

        return isBSTHelper(root.left, currMin, root.data) &&
                isBSTHelper(root.right, root.data, currMax);
    }
}

//Depth First Traversals
//Time Complexity: O(n)

/************************************************Iterative Solution****************************************************/

/*
Structure of Node:
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

public class Tree
{
    // return true if the given tree is a BST, else return false
    boolean isBST(Node root)    {
        if (root == null)
            return true;

        Stack<Node> stack = new Stack<Node>();
        Node prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (prev != null && root.data <= prev.data) {
                return false;
            }

            prev = root;
            root = root.right;
        }

        return true;
    }
}

//Depth First Traversals
//Time Complexity: O(n)

