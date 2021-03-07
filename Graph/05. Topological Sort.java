/*
Company Tags:  Accolite Amazon Flipkart Microsoft Moonfrog Labs Morgan Stanley OYO Rooms Samsung Visa D-E-Shaw
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/topological-sort/1
*/

/*
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u v,
vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
*/

// Checkout: https://youtu.be/eMVg3Gvnva4?list=PLNxqWc8Uj2LTb6VYJG3Kebwift2oaBFvE


class Solution {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                dfsOfGraph(i, adj, visited, stack);
            }
        }

        int[] topoElements = new int[V];
        int index = 0;
        while (!stack.isEmpty()) {
            topoElements[index++] = stack.pop();
        }

        return topoElements;
    }

    static void dfsOfGraph(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for(int currNode : adj.get(node)) {
            if (!visited[currNode]) {
                dfsOfGraph(currNode, adj, visited, stack);
            }
        }

        stack.push(node);
    }
}

/*
Complexity Analysis:

Time Complexity: O(V+E).
The above algorithm is simply DFS with an extra stack. So time complexity is the same as DFS which is.
Auxiliary space: O(V).
The extra space is needed for the stack.
*/
