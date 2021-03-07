/*
Company Tags:  Adobe Amazon Flipkart MakeMyTrip Oracle Samsung Microsoft
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
*/


/*
If an edge is connected to any edge, except his parent node, then it's a cycle in a graph.

Checkout: https://youtu.be/GLGsIZGLvA0?list=PLNxqWc8Uj2LTb6VYJG3Kebwift2oaBFvE
*/

class Solution
{
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        for (int i=0; i<V; i++) {
            if (visited[i] == false) {
                // -1 is send as parent.
                if (dfsOfGraph(i, -1, adj, visited))
                    return true;
            }
        }
        return false;
    }

    public boolean dfsOfGraph(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for (int currNode : adj.get(node)) {
            if (visited[currNode] == false) {
                if  (dfsOfGraph(currNode, node, adj, visited))
                    return true;
            } else if (currNode != parent) {
                // an edge is connected to another edge, and that other edge is not his parent
                // its a cycle
                return true;
            }
        }

        return false;
    }
}

/*
Complexity Analysis:

Time Complexity: O(V+E).
The program does a simple DFS Traversal of the graph which is represented using adjacency list. So the time complexity is O(V+E).
Space Complexity: O(V).
To store the visited array O(V) space is required.
*/