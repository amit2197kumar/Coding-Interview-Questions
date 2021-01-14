// class Node{
//     int data;
//     Node left,right;
//     Node(int d){
//         data=d;
//         left=right=null;
//     }
// }

class BinaryTree
{
    /* Computes the number of nodes in a tree. */
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