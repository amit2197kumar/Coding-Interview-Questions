/*
Company Tags:   Accolite Adobe Amazon Flipkart InMobi Linkedin MAQ Software Microsoft Paytm Quikr Yahoo
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1
LeetCode: https://leetcode.com/problems/serialize-and-deserialize-bst/
*/

/*********************************************** Geeksforgeeks ********************************************************/

/*Complete the given function
Node is as follows:
class Tree{
	int data;
	Tree left,right;
	Tree(int d){
		data=d;
		left=right=null;
	}
}*/
//This Code is developed by: Suman Rana

/*
Reason to choose PREORDER traversal: deSerialize recursive is possible in PREORDER
*/

class Tree {
    Integer index = 0;
    final Integer NULL_NODE = -1;

    public void serialize(Node root, ArrayList<Integer> list) {
        if (root == null) {
            list.add(NULL_NODE);
            return;
        }

        list.add(root.data);
        serialize(root.left, list);
        serialize(root.right, list);
    }

    public Node deSerialize(ArrayList<Integer> list){
        if (list.get(index) == NULL_NODE) {
            index++;
            return null;
        }

        Node newNode = new Node(list.get(index++));
        newNode.left = deSerialize(list);
        newNode.right = deSerialize(list);
        return newNode;
    }
};

/************************************************** LeetCode **********************************************************/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (currNode == null) {
                list.add("#");
            } else {
                list.add("" + currNode.val);
                queue.add(currNode.left);
                queue.add(currNode.right);
            }
        }

        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if (arr[0].equals("#")) {
            return null;
        }

        int index = 0;

        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (currNode != null) {
                TreeNode left = null;
                if (!arr[index].equals("#")) {
                    left = new TreeNode(Integer.parseInt(arr[index]));
                }
                currNode.left = left;
                queue.add(left);
                index++;

                TreeNode right = null;
                if (!arr[index].equals("#")) {
                    right = new TreeNode(Integer.parseInt(arr[index]));
                }
                currNode.right = right;
                queue.add(right);
                index++;
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;

/*
Time Complexity: O(N).
Auxiliary Space: O(N).
*/