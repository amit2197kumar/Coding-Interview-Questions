/*
Company Tags: Adobe Amazon BankBazaar Flipkart Goldman Sachs MakeMyTrip Microsoft Oracle Rockstand Samsung
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
*/

/*
Keeping Track of all ancestor is important here.
In a directed graph their will be a cycle only when from current node(edge) an vertex go backward, that means
an vertex pointing to one of the ancestor of current node(edge)

Checkout : https://youtu.be/dc5Pn-YEPVY?list=PLNxqWc8Uj2LTb6VYJG3Kebwift2oaBFvE
*/


class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] ancestor = new boolean[V];

        // Need to check all edges as graph can be disconnected graph
        for (int i=0; i<V; i++) {
            if (visited[i] == false) {
                if (dfsOfGraph(adj, i, visited, ancestor))
                    return true;
            }
        }

        return false;
    }

    public boolean dfsOfGraph(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, boolean[] ancestor) {

        visited[node] = true;
        ancestor[node] = true;

        for (int currNode : adj.get(node)) {
            if (ancestor[currNode] == true) {
                return true;
            } else {
                if (visited[currNode] == false && dfsOfGraph(adj, currNode, visited, ancestor)) {
                    return true;
                }
            }
        }
        ancestor[node] = false;
        return false;
    }
}

/***************************************** Another Way (Same above Code) ***********************************************/


class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] ancestor = new boolean[V];

        // Need to check all edges as graph can be disconnected graph
        for (int i=0; i<V; i++) {
            if (visited[i] == false) {
                if (dfsOfGraph(adj, i, visited, ancestor))
                    return true;
            }
        }

        return false;
    }

    public boolean dfsOfGraph(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, boolean[] ancestor) {

        // Checking ancestor and visited should be in same order
        if (ancestor[node])
            return true;

        if (visited[node])
            return false;

        visited[node] = true;
        ancestor[node] = true;

        for (int currNode : adj.get(node)) {
            if (dfsOfGraph(adj, currNode, visited, ancestor)) {
                return true;
            }
        }
        ancestor[node] = false;
        return false;
    }
}

/*
Complexity Analysis:

Time Complexity: O(V+E).
Time Complexity of this method is same as time complexity of DFS traversal which is O(V+E).
Space Complexity: O(V).
To store the visited and recursion stack O(V) space is needed.
*/