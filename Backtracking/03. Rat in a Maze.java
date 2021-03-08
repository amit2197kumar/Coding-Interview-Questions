/*
Company Tags:  Amazon Microsoft
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
*/

// m is the given matrix and n is the order of matrix
class Solution {
    static ArrayList<String> result;
    static boolean visited[][];

    public static ArrayList<String> findPath(int[][] m, int n) {
        result = new ArrayList<String>();
        visited = new boolean[n][n];

        // 0,0 is start point
        // "" is current past path
        dfs(0, 0, "", n, m);

        return result;
    }

    static void dfs(int x, int y, String path, int n, int[][] m){
        // Can't move on 0, only on 1
        if( m[x][y] == 0 ){
            return ;
        }

        //Reched destination
        if( n-1 == x && n-1 == y ){
            result.add(path.toString());
            return;
        }

        //Alredy visited in past
        if( visited[x][y] ){
            return;
        }

        visited[x][y] = true;

        if( x+1 < n  ) {
            dfs(x+1, y, path +'D', n ,m);
        }
        if( y-1 >= 0 ) {
            dfs(x, y-1, path +'L', n ,m);
        }

        if( y+1 < n  ) {
            dfs(x, y+1, path + 'R', n ,m);
        }
        if( x-1 >= 0  ) {
            dfs(x-1, y, path + 'U', n ,m);
        }

        visited[x][y] = false;
    }
}

/*
Complexity Analysis:

Time Complexity: O(2^(n^2)).
The recursion can run upper-bound 2^(n^2) times.
Space Complexity: O(n^2).
Output matrix is required so an extra space of size n*n is needed.
*/

