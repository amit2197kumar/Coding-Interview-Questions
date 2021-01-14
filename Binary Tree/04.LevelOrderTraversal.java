/*
Practice Portal: https://practice.geeksforgeeks.org/problems/level-order-traversal/1
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
//***********************************Iterartive Queue Solution*************************************

class Level_order_traversal
{
    //You are required to complete this method
    static ArrayList <Integer> levelOrder(Node root)
    {
        ArrayList <Integer> arrayList = new ArrayList <>();
        Queue <Node> queue = new LinkedList<>();

        if (root == null) return arrayList;
        queue.add(root);

        while(queue.size() > 0) {
            Node curr = queue.poll();
            arrayList.add(curr.data);

            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
        }

        return arrayList;
    }
}



//Breadth First Traversals
//Time Complexity: O(n)
//Space Complexity: O(n)

//Approach-02
//***********************************Recursive Map Solution*************************************
class Level_order_traversal
{
    //You are required to complete this method
    static ArrayList <Integer> levelOrder(Node root)
    {
        ArrayList <Integer> arrayList = new ArrayList <>();
        if (root == null)
            return arrayList;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        preOrderTraversal(root, map, 1);

        for (Map.Entry<Integer, ArrayList<Integer>> mapValue : map.entrySet()) {
            ArrayList<Integer> levelValue = mapValue.getValue();
            for(Integer value : levelValue) {
                arrayList.add(value);
            }
        }

        return arrayList;
    }


    static void preOrderTraversal(Node root, Map<Integer, ArrayList<Integer>> map, int level) {
        if (root == null)
            return;

        map.putIfAbsent(level, new ArrayList<Integer>());
        map.get(level).add(root.data);

        preOrderTraversal(root.left, map, level+1);
        preOrderTraversal(root.right, map, level+1);
    }
}

//Time Complexity: O(n)
//Auxiliary Space: O(n)