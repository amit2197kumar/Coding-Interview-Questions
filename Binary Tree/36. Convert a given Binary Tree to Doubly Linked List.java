/*
Company Tags:   Accolite Amazon Goldman Sachs Microsoft Morgan Stanley Salesforce Snapdeal
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
*/

/* class Node
class Node
{
	Node left, right;
	int data;

	Node(int d)
	{
		data = d;
		left = right = null;
	}

}*/

//This function should return head to the DLL

/*
We know we need to do Inorder traversal looking at the ask of output.
We need to keep track of prev Node to assigne the right(pointer) to previous node.
We need to save the head pointer, as that need to be returned in the end.
*/

class GfG
{
    class NodeInfo {
        Node prev;
        Node headOfDLL;
    }

    Node bToDLL(Node root) {
        NodeInfo nodeInfo = new NodeInfo();
        binaryTreeToDLLUtil(root, nodeInfo);
        return nodeInfo.headOfDLL;
    }

    void binaryTreeToDLLUtil(Node root, NodeInfo nodeInfo) {
        if (root == null)
            return;

        binaryTreeToDLLUtil(root.left, nodeInfo);

        if (nodeInfo.prev == null) {
            nodeInfo.headOfDLL = root;
            nodeInfo.prev = root;
        } else {
            root.left = nodeInfo.prev;
            nodeInfo.prev.right = root;
            nodeInfo.prev = root;
        }

        binaryTreeToDLLUtil(root.right, nodeInfo);
    }
}

// Time Complexity is same as that of InOrder Traversal.
// Time Complexity: O(n), as the solution does a single traversal of given Binary Tree.
