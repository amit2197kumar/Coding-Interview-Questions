/*
Company Tags: Amazon Directi Flipkart GreyOrange Microsoft Mobicip Morgan Stanley Oracle Payu Snapdeal Visa
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
*/

// 0-1 Knapsack Problem is a PARENT PROBLEM

/************************************************** Recursive Solution ************************************************/

// In recursion, at every index, we have 2 choices, either to pick the current VAL or leave the current VAL

class Knapsack
{
    //Recursive Solution
    static int knapSack(int W, int wt[], int val[], int n) {

        //Base condition for recursion
        if (W <= 0 || n <= 0)
            return 0;

        if (W >= wt[n-1]) {
            return Math.max(knapSack(W, wt, val, n-1),
                    knapSack(W - wt[n-1], wt, val, n-1) + val[n-1]);
        } else {
            return knapSack(W, wt, val, n-1);
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

class Knapsack
{
    //Memoization Solution (Top-Down) : Recursive Call + DP Matrix
    static int knapSack(int W, int wt[], int val[], int n) {

        int[][] dp = new int[n+1][W+1];
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<W+1; j++) {
                dp[i][j] = -1;
            }
        }

        return knapSackHelper(W, wt, val, n, dp);
    }

    static int knapSackHelper(int W, int wt[], int val[], int n, int[][] dp) {

        //Base condition for recursion
        if (W <= 0 || n <= 0)
            return 0;

        if (dp[n][W] != -1)
            return dp[n][W];

        if (W >= wt[n-1]) {
            dp[n][W] = Math.max(knapSackHelper(W, wt, val, n-1, dp),
                    knapSackHelper(W - wt[n-1], wt, val, n-1, dp) + val[n-1]);
        } else {
            dp[n][W] = knapSackHelper(W, wt, val, n-1, dp);
        }

        return dp[n][W];
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

class Knapsack
{
    //Bottom-up Solution
    static int knapSack(int W, int wt[], int val[], int n) {

        int[][] dp = new int[n+1][W+1];

        for (int i=0; i<n+1; i++) {
            for (int j=0; j<W+1; j++) {
                if (i==0)
                    dp[i][j] = 0;
                if (j==0)
                    dp[i][j] = 0;
            }
        }

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<W+1; j++) {
                if (j >= wt[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j],
                            dp[i-1][j-wt[i-1]] + val[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }
}