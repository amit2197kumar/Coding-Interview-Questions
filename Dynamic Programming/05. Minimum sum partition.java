/*
Company Tags:  Amazon Samsung Tower Research Uber
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1
InterviewBit: https://www.interviewbit.com/problems/minimum-difference-subsets/
*/

// PARENT PROBLEM: Subset Sum Problem & 0-1 Knapsack

/*
LOGIC:
We need to minimize the difference between two subset that are made from the sum of elements of the array
Let say the 2 subset sum are S1 and S2.
Let say sum of all elements of array is SUM.

S1 + S2 = SUM
     S2 = SUM - S1

Aim : abs(S2 - S1) minimize

-> abs (S2 - S1) minimize
-> abs ((SUM - S1) - S1) minimize
-> abs (SUM - S1 - S1) minimize
-> abs (SUM - 2S1) minimize

In below Recursive and Memoization Solution (Top-Down) approch we will try to minimize abs (SUM - 2S1)

*/

/************************************************** Recursive Solution ************************************************/

class Solution
{
    public int minDiffernce(int arr[], int n)
    {
        int sum=0;
        for(int i=0; i<n; i++)
            sum += arr[i];

        return minDiffernceHelper(arr, sum, n-1, 0);
    }

    //Recursive Solution
    public int minDiffernceHelper(int arr[], int sum, int index, int currSum) {
        if (index < 0)
            return Math.abs(sum - 2*currSum);

        return Math.min(minDiffernceHelper(arr, sum, index -1, currSum),
                minDiffernceHelper(arr, sum, index -1, currSum + arr[index]));
    }
}

/****************************************** Memoization Solution (Top-Down) *******************************************/

class Solution
{
    public int minDiffernce(int arr[], int n)
    {
        int sum=0;
        for(int i=0; i<n; i++)
            sum += arr[i];

        int[][] dp = new int[n+1][sum+1];
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<sum+1; j++) {
                dp[i][j] = -1;
            }
        }
        return minDiffernceHelper(arr, sum, n-1, 0, dp);
    }

    //Memoization Solution (Top-Down) : Recursive Call + DP Matrix
    public int minDiffernceHelper(int[] arr, int sum, int index, int currSum, int[][] dp) {
        if (index < 0)
            return Math.abs(sum - 2*currSum);

        if (dp[index][currSum] != -1)
            return dp[index][currSum];

        dp[index][currSum] = Math.min(minDiffernceHelper(arr, sum, index -1, currSum, dp),
                                      minDiffernceHelper(arr, sum, index -1, currSum + arr[index], dp));
        return dp[index][currSum];
    }
}

/************************************************** Bottom-up Solution ************************************************/

class Solution
{
    public int minDiffernce(int arr[], int n)
    {
        int sum=0;
        for(int i=0; i<n; i++)
            sum += arr[i];

        return minDiffernceHelper(arr, sum, n);
    }

    //Bottom-up Solution
    public int minDiffernceHelper(int[] arr, int sum, int size) {
        int row = size+1;
        int col = sum+1;
        int[][] dp = new int[row][col];

        for (int i=0; i<col; i++) {
            dp[0][i] = 0;
        }

        for (int i=0; i<row; i++) {
            dp[i][0] = 1;
        }

        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {
                if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i-1]]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j=0; j<= sum/2; j++) {
            if (dp[row-1][j] == 1) {
                min = Math.min(min, sum-2*j);
            }
        }
        return min;
    }
}
