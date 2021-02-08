/*
Company Tags:  Accolite Amazon Intuit Samsung
Practice Portal:
Geeksforgeeks:https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
*/


class Solution
{
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] isVisited = new boolean[V];
        ArrayList<Integer> storeDFS = new ArrayList<Integer>();
        dfsOfGraphHelper(0, adj, isVisited, storeDFS);
        return storeDFS;
    }

    public void dfsOfGraphHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] isVisited, ArrayList<Integer> storeDFS) {
        isVisited[node] = true;
        storeDFS.add(node);

        for (int i=0; i<adj.get(node).size(); i++) {
            if (isVisited[adj.get(node).get(i)] == false)
                dfsOfGraphHelper(adj.get(node).get(i), adj, isVisited, storeDFS);
        }
    }
}

/*
Time complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
Space Complexity: O(V).
Since, an extra visited array is needed of size V.
*/