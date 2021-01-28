/*
Company Tags:  Accolite Amazon BrowserStack Dell Flipkart Grofers MakeMyTrip Netskope Walmart

Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
LeetCode: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
*/

/*
Recursive Brute-force solution : https://www.geeksforgeeks.org/print-binary-tree-vertical-order/
The idea is to traverse the tree once and get the minimum and maximum horizontal distance with respect to root
Once we have maximum and minimum distances from root, we iterate for each vertical line at distance minimum to maximum from root,
and for each vertical line traverse the tree and print the nodes which lie on that vertical line.

Time complexity : O(w * n) where w is width of Binary Tree and n is number of nodes in Binary Tree. In worst case,
the value of w can be O(n) (consider a complete tree for example) and time complexity can become O(n^2).

***********************************************************************************************************************

Map based Method: https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
We need to check the Horizontal Distances from the root for all nodes. If two nodes have the same Horizontal Distance (HD),
then they are on the same vertical line. We can do preorder traversal of the given Binary Tree. While traversing the tree,
we can recursively calculate HDs. We initially pass the horizontal distance as 0 for root.
For every HD value, we maintain a list of nodes in a hash map. Whenever we see a node in traversal, we go to the hash map
entry and add the node to the hash map using HD as a key in a map.

Time Complexity of hashing based solution can be considered as O(n) under the assumption that we have good hashing function
that allows insertion and retrieval operations in O(1) time.

Note that the above solution may not print nodes in same vertical order as they appear in tree.

***********************************************************************************************************************

Using Level Order Traversal & TreeMap : https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/

Treemap: Java TreeMap class is a red-black tree based implementation. It provides an efficient means of storing key-value pairs in sorted order.
https://www.javatpoint.com/java-treemap
https://www.geeksforgeeks.org/treemap-in-java/

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

class BinaryTree
{
    static ArrayList <Integer> verticalOrder(Node root) {

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
            for(Integer value : currColumnList) {
                arrayList.add(value);
            }
        }

        return arrayList;
    }
}

//Time Complexity of the above implementation is O(n Log n).