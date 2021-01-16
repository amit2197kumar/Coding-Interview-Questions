/*
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
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

// Idea is same as Iterative Level Order Traversal
class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) return arrayList;

        Queue <Node> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size() > 0) {
            int size = queue.size();
            for (int i=0; i<size; i++) {

                Node curr = queue.poll();
                if (i==0) arrayList.add(curr.data);

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }

        return arrayList;
    }
}

//Breadth First Traversals
//Time Complexity: O(n)
//Space Complexity:  O(n)