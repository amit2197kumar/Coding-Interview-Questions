/*
Company Tags:  Accolite Amazon Microsoft Morgan Stanley OYO Rooms Paytm Samsung Snapdeal
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/coin-change2448/1
*/

// PARENT PROBLEM: Unbounded Knapsack

/************************************************** Recursive Solution ************************************************/
// In recursion, at every index, we have 2 choices, either to pick the current VAL or leave the current VAL
// If we pick Current VAL we can pick that again, as duplicate are allowed, so we do recursive call with same index

class Solution
{
    //Recursive Solution
    public long count(int coin[], int index, int target)
    {
        if (index<=0)
            return 0;
        if (target<=0)
            return 1;

        if (target<coin[index-1])
            return count(coin,index-1,target);
        else
            return count(coin,index-1,target) +
                    count(coin,index,target-coin[index-1]);
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

class Solution
{
    //Memoization Solution (Top-Down) : Recursive Call + DP Matrix
    public long count(int coin[], int index, int target)
    {
        long[][] dp = new long[index+1][target+1];
        for (int i=0; i< index+1; i++) {
            for (int j=0; j< target+1; j++) {

                dp[i][j] = -1L;
            }
        }

        return coinCount(coin, index, target, dp);
    }

    public long coinCount(int coin[], int index, int target, long dp[][])
    {
        if (index<=0)
            return 0;
        if (target<=0)
            return 1;

        if (dp[index][target] != -1)
            return dp[index][target];

        if (target<coin[index-1])
            dp[index][target] = coinCount(coin, index-1, target, dp);
        else
            dp[index][target] = coinCount(coin, index-1, target, dp) +
                    coinCount(coin, index, target-coin[index-1], dp);

        return dp[index][target];
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

class Solution
{
    //Bottom-up Solution
    public long count(int coin[], int index, int target)
    {
        int row = index+1;
        int col = target+1;

        long[][] dp = new long[row][col];

        for (int i=0; i<row; i++){
            dp[i][0] = 1;
        }

        for (int i=1; i<col; i++){
            dp[0][i] = 0;
        }


        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {
                if (j<coin[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coin[i-1]];
                }
            }
        }

        return dp[row-1][col-1];
    }
}