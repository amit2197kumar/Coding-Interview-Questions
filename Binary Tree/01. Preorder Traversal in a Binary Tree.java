/*
Company Tags: Amazon Walmart
Practice Portal: https://practice.geeksforgeeks.org/problems/preorder-traversal/1
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

/*
ALGO:
1. Read current NODE data
2. Go to left subtree
3. Go to right subtree
*/

class BinaryTree {
    static ArrayList<Integer> preorder(Node root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        preOrderHelper(root, arrayList);
        return arrayList;
    }

    static void preOrderHelper(Node root, ArrayList<Integer> arrayList) {
        if (root == null) return;

        arrayList.add(root.data);
        preOrderHelper(root.left, arrayList);
        preOrderHelper(root.right, arrayList);
    }
}

//Depth First Traversals
//Time Complexity: O(n)
//Auxiliary Space : If we don’t consider size of stack for function calls then O(1) otherwise O(n).

//Approach-02
//***********************************Iterative Solution*************************************

/*
ALGO:
1. Push root to Stack
2. Till Stack is not empty :
    2.1. Pop Stack
    2.2. Read popped Node data
    2.3. If popped Node has left node push to Stack
    2.4. If popped Node has left node push to Stack
*/
class BinaryTree {
    static ArrayList<Integer> preorder(Node root) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null)
            return arrayList;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(stack.size() > 0) {
            Node currNode = stack.pop();
            arrayList.add(currNode.data);

            if (currNode.right != null)
                stack.push(currNode.right);
            if (currNode.left != null)
                stack.push(currNode.left);
        }
        return arrayList;
    }
}

//Depth First Traversals
//Time Complexity: O(n)
//Auxiliary Space: O(N), where N is the total number of nodes in the tree

//Approach-03
//***********************************Iterative Solution*************************************

//TIP: This approch will help to understand Iterative Inorder traversal faster.
/*
ALGO:
1. while curr node(root) OR queue is not null or empty
    1.1. Read curr Node data
    1.2. If curr Node has right node, push to Stack
    1.3. keep moving in left subtree
    1.4. If reached null in left direction, pop element from Stack
*/

class BinaryTree {
    static ArrayList<Integer> preorder(Node root) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null)
            return arrayList;

        Stack<Node> stack = new Stack<>();
        Node currNode = root;

        while(stack.size() > 0 || currNode != null) {
            while (currNode != null) {
                arrayList.add(currNode.data);
                if (currNode.right != null)
                    stack.push(currNode.right);

                currNode = currNode.left;
            }
            if (stack.size() > 0)
                currNode = stack.pop();
        }
        return arrayList;
    }
}

//Depth First Traversals
//Time Complexity: O(n)
//Auxiliary Space: O(H), where H is the height of the tree