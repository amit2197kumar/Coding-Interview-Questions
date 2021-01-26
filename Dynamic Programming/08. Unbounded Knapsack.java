/*
Company Tags: Amazon Google
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
*/

// Unbounded Knapsack is a PARENT PROBLEM

/************************************************** Recursive Solution ************************************************/
// In recursion, at every index, we have 2 choices, either to pick the current VAL or leave the current VAL
// If we pick Current VAL we can pick that again, as duplicate are allowed, so we do recursive call with same index

class Solution{
    //Recursive Solution
    static int knapSack(int N, int W, int val[], int wt[])  {
        if (W <= 0)
            return 0;
        if (N <= 0)
            return 0;

        if (W >= wt[N-1]) {
            return Math.max(knapSack(N-1, W, val, wt),
                    knapSack(N, W-wt[N-1], val, wt) + val[N-1]);
        } else {
            return knapSack(N-1, W, val, wt);
        }
    }
}

/****************************************** Memoization Solution (Top-Down) *******************************************/

/*
Recursive Solution can be converted into Memoization Solution
1. We pass a Memoization matrix with -1 filled.
2. Recursive Solution remain exactly same, just added one if() to check if we have alredy solved this subproblem,
if TRUE return its value directly,
if FALSE, then after getting ans save in the Memoization matrix.
*/

class Solution{
    //Memoization Solution (Top-Down) : Recursive Call + DP Matrix
    static int knapSack(int N, int W, int val[], int wt[])  {

        int[][] dp = new int[N+1][W+1];
        for (int i=0; i<N+1; i++) {
            for (int j=0; j<W+1; j++) {
                dp[i][j] = -1;
            }
        }
        return knapSackHelper(N, W, val, wt, dp);
    }

    static int knapSackHelper(int N, int W, int val[], int wt[], int dp[][]) {
        if (W <= 0)
            return 0;
        if (N <= 0)
            return 0;

        if (dp[N][W] != -1)
            return dp[N][W];

        if (W >= wt[N-1]) {
            dp[N][W] = Math.max(knapSackHelper(N-1, W, val, wt, dp),
                                knapSackHelper(N, W-wt[N-1], val, wt, dp) + val[N-1]);
        } else {
            dp[N][W] = knapSackHelper(N-1, W, val, wt, dp);
        }

        return dp[N][W];
    }
}

/************************************************** Bottom-up Solution ************************************************/

/*
Memoization Solution (Top-Down) can be converted into Bottom-up Solution
ROW are always n i.e. Size of the array.
1. We create a Bottom-up DP matrix.
2. Bottom-up DP matrix inicialization is done based on Base condition for recursion
3. From Memoization Solution
    3.1. n -> i
    3.2. W -> j
*/

class Solution{
    //Bottom-up Solution
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int row = N+1;
        int col = W+1;

        int[][] dp = new int[row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++)
                dp[i][j] = 0;
        }

        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {

                if (j >= wt[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j],
                                        dp[i][j-wt[i-1]] + val[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[row-1][col-1];
    }
}