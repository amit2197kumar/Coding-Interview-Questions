/*
Company Tags:  Amazon

Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1
*/

/*
The idea is to use a queue to store only the left child of current node. After printing the data of current node make the
current node to its right child, if present.
A delimiter NULL is used to mark the starting of next diagonal.
*/

class Tree
{
    public ArrayList<Integer> diagonal(Node root) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<Node> que = new LinkedList<>();

        que.offer(root);
        while(que.size() != 0){

            Node currNode = que.poll();

            while(currNode != null) {
                list.add(currNode.data);
                if(currNode.left != null){
                    que.add(currNode.left);
                }
                currNode = currNode.right;
            }
        }
        return list;
    }
}

//Breadth First Traversals
//Time Complexity: O(n) where n is the number of nodes in binary tree.