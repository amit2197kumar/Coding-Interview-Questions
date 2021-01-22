/*

Company Tags:  Accolite Amazon Flipkart Knowlarity MakeMyTrip Ola Cabs Open Solutions OYO Rooms Paytm Qualcomm Samsung Snapdeal Twitter

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

/*
Idea is same as Iterative Level Order Traversal, we just read the 1st element at each level
*/
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

//Approach-02
//*********************************** Recursive *************************************

/*
We use Pre Order Traversal here, 2 varibales are used to check have we visited this level before or not
If not, then we read the root data
*/
class Tree
{
    static int currLevel = 0;
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) return arrayList;
        currLevel = 0;

        preOrderTraversal(root, arrayList, 1);

        return arrayList;
    }

    void preOrderTraversal(Node root, ArrayList<Integer> arrayList, int localLevel) {
        if (root == null)
            return;

        if (currLevel < localLevel) {
            arrayList.add(root.data);
            currLevel = localLevel;
        }

        preOrderTraversal(root.left, arrayList, localLevel+1);
        preOrderTraversal(root.right, arrayList, localLevel+1);
    }
}

//Depth First Traversals
//Time Complexity: O(n)
//Space Complexity:  O(n)