/*
Company Tags: Accolite Amazon CouponDunia Flipkart OYO Rooms Paytm Walmart

Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
*/

/*
https://www.geeksforgeeks.org/bottom-view-binary-tree/

The idea is to do something similar to vertical Order Traversal. Like vertical Order Traversal, we need to put nodes of
same horizontal distance together.
Read [Vertical Traversal of Binary Tree] file
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

class Pair{
    int coloumn;
    Node node;
    Pair(int coloumn,Node node){
        this.coloumn = coloumn;
        this.node = node;
    }
}

class Tree
{
    public ArrayList <Integer> bottomView(Node root) {
        ArrayList <Integer> arrayList = new ArrayList <>();
        if (root == null) return arrayList;

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Pair pair = new Pair(0, root); //0 is the column

        Queue<Pair> queue = new LinkedList<>();
        queue.add(pair);

        while(queue.size() > 0) {
            Pair currpair= queue.poll();
            int currNodeColumn = currpair.coloumn;
            Node currNode = currpair.node;

            if (map.containsKey(currNodeColumn)) {
                ArrayList<Integer> tempList = map.get(currNodeColumn);
                tempList.add(currNode.data);
                map.put(currNodeColumn, tempList);
            } else {
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(currNode.data);
                map.put(currNodeColumn, tempList);
            }

            if (currNode.left != null) {
                queue.add(new Pair(currNodeColumn-1, currNode.left));
            }

            if (currNode.right != null) {
                queue.add(new Pair(currNodeColumn+1, currNode.right));
            }
        }

        for (Map.Entry<Integer, ArrayList<Integer>> mapValue : map.entrySet()) {
            ArrayList<Integer> currColumnList = mapValue.getValue();
            for (int i=currColumnList.size()-1; i>=0; i--) {
                if (i == currColumnList.size()-1) {
                    arrayList.add(currColumnList.get(i));
                }
            }
        }

        return arrayList;
    }
}

//Breadth First Traversals
//Time Complexity of the above implementation is O(nlogn)