/*
Company Tags:  Accolite Amazon Morgan Stanley Oracle Paytm Samsung Snapdeal Synopsys Visa
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/number-of-coins1824/1
LeetCode: https://leetcode.com/problems/coin-change/
*/

// PARENT PROBLEM: Unbounded Knapsack

/************************************************** Recursive Solution ************************************************/

class Solution {
    //Recursive Solution
    public int coinChange(int[] coins, int amount) {

        int value = minCoinsHelper(coins, coins.length, amount);
        if (value == Integer.MAX_VALUE-1)
            return -1;

        return value;
    }

    public int minCoinsHelper(int coins[], int n, int amount) {
        if (amount==0)
            return 0;
        if (n<=0)
            return Integer.MAX_VALUE-1;

        if (amount < coins[n-1]) {
            return minCoinsHelper(coins, n-1, amount);
        } else {
            return Math.min(minCoinsHelper(coins, n-1, amount),
                    minCoinsHelper(coins, n, amount-coins[n-1]) + 1); // + 1 as we picking the current coin
        }
    }
}

/****************************************** Memoization Solution (Top-Down) *******************************************/

class Solution {
    //Memoization Solution (Top-Down) : Recursive Call + DP Matrix
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i=0; i<coins.length + 1; i++) {
            for (int j=0; j<amount + 1; j++) {
                dp[i][j] = -1;
            }
        }

        int value = minCoinsHelper(coins, coins.length, amount, dp);
        if (value == Integer.MAX_VALUE-1)
            return -1;

        return value;
    }

    public int minCoinsHelper(int coins[], int n, int amount, int dp[][]) {
        if (amount==0)
            return 0;
        if (n<=0)
            return Integer.MAX_VALUE-1;

        if (dp[n][amount] != -1)
            return dp[n][amount];

        if (amount < coins[n-1]) {
            dp[n][amount] = minCoinsHelper(coins, n-1, amount, dp);
        } else {
            dp[n][amount] = Math.min(minCoinsHelper(coins, n-1, amount, dp),
                    minCoinsHelper(coins, n, amount-coins[n-1], dp) + 1);
            // + 1 as we picking the current coin
        }

        return dp[n][amount];
    }
}

/************************************************** Bottom-up Solution ************************************************/

class Solution {
    //Bottom-up Solution
    public int coinChange(int[] coins, int amount) {
        int row = coins.length + 1;
        int col = amount + 1;

        int [][] dp = new int [row][col];

        for (int i = 1; i<row; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j<col; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1; //-1 so that it don't go out of INT range
        }

        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {

                if (j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j],
                            dp[i][j-coins[i-1]] + 1); // + 1 as we picking the current coin
            }
        }

        if (dp[row-1][col-1] == Integer.MAX_VALUE-1)
            return -1;
        else
            return dp[row-1][col-1];
    }
}