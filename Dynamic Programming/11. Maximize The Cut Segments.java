/*
Company Tags:  Amazon OYO Rooms
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/cutted-segments1642/1
*/

// PARENT PROBLEM: Unbounded Knapsack & Minimum Coin Change

/************************************************** Recursive Solution ************************************************/

class Solution
{
    //Recursive Solution
    public int maximizeCuts(int n, int x, int y, int z) {
        int[] cuts = {x, y, z};
        int value = maximizeCutsHelper(cuts, n, 3);
        if (value < 0)
            return 0;
        return value;
    }

    public int maximizeCutsHelper(int cuts[], int segment, int index) {
        if (segment == 0)
            return 0;
        if (index <= 0)
            return Integer.MIN_VALUE;

        if (segment < cuts[index - 1]) {
            return maximizeCutsHelper(cuts, segment, index-1);
        } else {
            return Math.max(maximizeCutsHelper(cuts, segment, index-1),
                    maximizeCutsHelper(cuts, segment - cuts[index-1], index) + 1);
                    // +1 as we picking the current coin
        }
    }
}

/****************************************** Memoization Solution (Top-Down) *******************************************/

class Solution
{
    //Memoization Solution (Top-Down) : Recursive Call + DP Matrix
    public int maximizeCuts(int n, int x, int y, int z) {
        int[] cuts = {x, y, z};

        int[][] dp = new int[3+1][n+1];
        for (int i=0; i<3+1; i++) {
            for (int j=0; j<n+1; j++) {
                dp[i][j] = -1;
            }
        }

        int value = maximizeCutsHelper(cuts, n, 3, dp);
        if (value < 0)
            return 0;
        return value;
    }

    public int maximizeCutsHelper(int cuts[], int segment, int index, int[][] dp) {
        if (segment == 0)
            return 0;
        if (index <= 0)
            return Integer.MIN_VALUE;

        if (dp[index][segment] != -1)
            return dp[index][segment];

        if (segment < cuts[index - 1]) {
            dp[index][segment] = maximizeCutsHelper(cuts, segment, index-1, dp);
        } else {
            dp[index][segment] =  Math.max(maximizeCutsHelper(cuts, segment, index-1, dp),
                                           maximizeCutsHelper(cuts, segment - cuts[index-1], index, dp) + 1);
                                           // +1 as we picking the current coin
        }

        return dp[index][segment];
    }
}

/************************************************** Bottom-up Solution ************************************************/

class Solution
{
    //Bottom-up Solution
    public int maximizeCuts(int n, int x, int y, int z) {
        int[] cuts = {x, y, z};

        int row = 3+1;
        int col = n+1;
        int[][] dp = new int[row][col];

        for (int i = 1; i<row; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j<col; j++) {
            dp[0][j] = Integer.MIN_VALUE;
        }

        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {

                if (j < cuts[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],
                            dp[i][j-cuts[i-1]] + 1); // +1 as we picking the current coin
                }
            }
        }

        if (dp[row-1][col-1] < 0)
            return 0;
        return dp[row-1][col-1];
    }
}