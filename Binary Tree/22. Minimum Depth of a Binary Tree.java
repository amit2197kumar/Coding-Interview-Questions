/*
Company Tags:  Amazon Facebook

Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/minimum-depth-of-a-binary-tree/1
*/

/************************************************Recursive Solution****************************************************/

/*
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

class Tree
{
    int minDepth(Node root)
    {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        // If left subtree is NULL, recur for right subtree
        if (root.left == null)
            return minDepth(root.right) + 1;

        // If right subtree is NULL, recur for right subtree
        if (root.right == null)
            return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}

//Depth First Traversals
//Time Complexity: O(n)

/************************************************Iterative Solution****************************************************/

/*
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

class Tree
{
    class NodeDepth {
        Node node;
        int depth;

        NodeDepth(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    int minDepth(Node root) {
        if (root == null)
            return 0;

        Queue<NodeDepth> que = new LinkedList<NodeDepth>();
        NodeDepth nodeD = new NodeDepth(root, 1);
        que.add(nodeD);

        while(que.size() > 0) {
            NodeDepth curr = que.remove();

            if (curr.node.left == null && curr.node.right == null)
                return curr.depth;

            if (curr.node.left != null) {
                NodeDepth leftNodeD = new NodeDepth(curr.node.left, curr.depth+1);
                que.add(leftNodeD);
            }

            if (curr.node.right != null) {
                NodeDepth rightNodeD = new NodeDepth(curr.node.right, curr.depth+1);
                que.add(rightNodeD);
            }
        }

        return -1;
    }
}

//Breadth First Traversals
//Time Complexity: O(n)

