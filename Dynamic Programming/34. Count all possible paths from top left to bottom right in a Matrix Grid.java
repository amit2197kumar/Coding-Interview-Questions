/*
Company Tags:  Amazon Cisco Linkedin Ola Cabs Paytm Walmart
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/count-all-possible-paths-from-top-left-to-bottom-right3011/1
*/

// PARENT PROBLEM: This is a Parent Problem

/************************************************** Recursive Solution ************************************************/

class Solution
{
    long numberOfPaths(int m, int n)
    {
        return numberOfPaths(m, n, m, n);
    }

    long numberOfPaths(int m, int n, int row, int col) {

        if (m < 0 || n < 0 || m > row || n > col) {
            return 0;
        }

        // Botton right grid will be [1][1] when be subtract  m & n for every step in path
        if (m == 1 && n == 1) {
            return 1;
        }

        long currVal = numberOfPaths(m-1, n, row, col) + numberOfPaths(m, n-1, row, col);

        // This Module is just needed for online platform IDE
        currVal = currVal % 1000000007;
        return currVal;
    }
}

/*
Time Limit Exceeded
Time Complexity: O(2^n)
*/

/****************************************** Memoization Solution (Top-Down) *******************************************/

class Solution
{
    long numberOfPaths(int m, int n)
    {
        long[][] dp = new long[m+1][n+1];
        for (int i=0; i<m+1; i++) {
            for (int j=0; j<n+1; j++) {
                dp[i][j] = -1;
            }
        }

        return numberOfPaths(m, n, dp);
    }

    long numberOfPaths(int m, int n, long[][] dp) {

        if (m < 0 || n < 0 || m > dp.length || n > dp[0].length) {
            return 0;
        }

        // Botton right grid will be [1][1] when be subtract  m & n for every step in path
        if (m == 1 && n == 1) {
            return 1;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        dp[m][n] = numberOfPaths(m-1, n, dp) + numberOfPaths(m, n-1, dp);

        // This Module is just needed for online platform IDE
        dp[m][n] = dp[m][n] % 1000000007;
        return dp[m][n];
    }
}

/*
Time Complexity: O(m * n)
Auxiliary Space: O(m * n)
*/

/************************************************** Bottom-up Solution ************************************************/

class Solution
{
    long numberOfPaths(int m, int n)
    {
        int[][] count = new int[m][n];

        for (int i=0; i<m ; i++) {
            count[i][0] = 1;
        }

        for (int j=0; j<n; j++) {
            count[0][j] = 1;
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                count[i][j] = count[i-1][j] + count[i][j-1];
                count[i][j] = count[i][j] % 1000000007;
            }
        }

        return count[m-1][n-1];
    }
}

/*
Time Complexity: O(m * n)
Auxiliary Space: O(m * n)
*/