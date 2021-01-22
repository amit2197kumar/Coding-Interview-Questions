/*
Company Tags: Morgan Stanley Snapdeal Walmart
Practice Portal: https://practice.geeksforgeeks.org/problems/postorder-traversal/1
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
1. Go to left subtree
2. Go to right subtree
3. Read current NODE data
*/

class Tree
{
    ArrayList<Integer> postOrder(Node root)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        helper(root, arrayList);
        return arrayList;
    }

    void helper(Node root, ArrayList<Integer> arrayList) {
        if (root == null) return;
        helper(root.left, arrayList);
        helper(root.right, arrayList);
        arrayList.add(root.data);
    }
}


//Depth First Traversals
//Time Complexity: O(n)
//Auxiliary Space : If we don’t consider size of stack for function calls then O(1) otherwise O(n).

//Approach-02
//***********************************Iterative Solution*************************************

/*
1. Push root to first stack.
2. Loop while first stack is not empty
   2.1 Pop a node from first stack and push it to second stack
   2.2 Push left and right children of the popped node to first stack
3. Print contents of second stack
*/

class Tree
{
    ArrayList<Integer> postOrder(Node root)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null)
            return arrayList;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);

        while (stack1.size() > 0) {
            Node curr = stack1.pop();
            stack2.push(curr);

            if (curr.left != null)
                stack1.push(curr.left);
            if (curr.right != null)
                stack1.push(curr.right);
        }

        while (stack2.size() > 0) {
            Node curr = stack2.pop();
            arrayList.add(curr.data);
        }
        return arrayList;
    }
}

//Depth First Traversals
//Time Complexity: O(n)
//Auxiliary Space: O(N)