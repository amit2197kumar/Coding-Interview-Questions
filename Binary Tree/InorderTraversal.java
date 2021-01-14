/*
Practice Portal: https://practice.geeksforgeeks.org/problems/inorder-traversal/1
*/

/*
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
//***********************************Recursive Solution*************************************
class Tree
{
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        helper(root, arrayList);
        return arrayList;
    }

    void helper(Node root, ArrayList<Integer> arrayList) {
        if (root == null) return;
        helper(root.left, arrayList);
        arrayList.add(root.data);
        helper(root.right, arrayList);
    }
}

//Depth First Traversals
//Time Complexity: O(n)
//Auxiliary Space : If we don’t consider size of stack for function calls then O(1) otherwise O(n).

//Approach-02
//***********************************Iterative Solution*************************************

//TIP: This approch is similar to Iterative Preorder traversal: https://github.com/kumar2197/DSA/blob/master/Binary%20Tree/PreorderTraversal.java
class Tree {
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null)
            return arrayList;

        Stack<Node> stack = new Stack<>();
        Node currNode = root;

        while(stack.size() > 0 || currNode != null) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            if(stack.size() > 0) {
                currNode = stack.pop();
                arrayList.add(currNode.data);
                currNode = currNode.right;
            }
        }

        return arrayList;
    }
}

//Depth First Traversals
//Time Complexity: O(n)
//Auxiliary Space: O(N), where N is the total number of nodes in the tree