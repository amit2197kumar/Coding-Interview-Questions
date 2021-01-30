/*
Company Tags:  Amazon BankBazaar OYO Rooms Paytm Samsung Morgan Stanley
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1
*/

// PARENT PROBLEM: Longest Increasing Subsequence

/************************************************** Recursive Solution ************************************************/

class Solution
{
    public int maxSumIS(int arr[], int n)  {
        return maxSumISHelper(arr, n, -1);
    }

    public int maxSumISHelper(int arr[], int curr, int prev) {
        if (curr <= 0)
            return 0;

        //case 1: exclude the current element
        int exclude = maxSumISHelper(arr, curr-1, prev);

        //case 2: include the current element
        int include = 0;
        if (prev == -1 || arr[prev-1] > arr[curr-1]) {
            include = maxSumISHelper(arr, curr-1, curr) + arr[curr-1];
        }

        return Math.max(exclude, include);
    }
}

/*
Time Complexity: O(2^n)
*/

/****************************************** Memoization Solution (Top-Down) *******************************************/

class Solution
{
    public int maxSumIS(int arr[], int n)  {
        int[][] dp = new int[n+1][n+1];
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<n+1; j++) {
                dp[i][j] = -1;
            }
        }
        return maxSumISHelper(arr, n, -1, dp);
    }

    public int maxSumISHelper(int arr[], int curr, int prev, int[][] dp) {
        if (curr <= 0)
            return 0;

        if (prev != -1 && dp[curr][prev] != -1)
            return dp[curr][prev];

        //case 1: exclude the current element
        int exclude = maxSumISHelper(arr, curr-1, prev, dp);

        //case 2: include the current element
        int include = 0;
        if (prev == -1 || arr[prev-1] > arr[curr-1]) {
            include = maxSumISHelper(arr, curr-1, curr, dp) + arr[curr-1];
        }

        if (prev != -1)
            dp[curr][prev] = Math.max(exclude, include);
        return Math.max(exclude, include);
    }
}

/*
Time Complexity: O(n^2)
Auxiliary Space: O(n^2)
*/

/************************************************** Bottom-up Solution ************************************************/

class Solution
{
    public int maxSumIS(int arr[], int n)  {
        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            dp[i] = arr[i];
        }

        int maxSum = dp[0];

        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = dp[j] + arr[i];
                    maxSum = Math.max(maxSum, dp[i]);
                }
            }
        }
        return maxSum;
    }
}

/*
Time Complexity: O(n^2)
Auxiliary Space: O(n)
*/
