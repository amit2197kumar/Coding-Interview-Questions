/*
Company Tags: Adobe Amazon Flipkart Microsoft Ola Cabs Samsung SAP Labs
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
*/

class Solution
{
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //To keep track of visited nodes
        boolean[] isVisited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();
        int node = 0;
        queue.add(node);

        ArrayList<Integer> storeBSF = new ArrayList<>();

        while (queue.size() > 0) {
            int curr = queue.poll();
            storeBSF.add(curr);

            for (int i=0; i<adj.get(curr).size(); i++) {
                if (isVisited[adj.get(curr).get(i)] == false) {
                    isVisited[adj.get(curr).get(i)] = true;
                    queue.add(adj.get(curr).get(i));
                }
            }
        }
        return storeBSF;
    }
}

//Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.