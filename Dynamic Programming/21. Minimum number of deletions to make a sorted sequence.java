/*
Company Tags:
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-to-make-a-sorted-sequence3248/1
*/

// PARENT PROBLEM: Longest Increasing Subsequence

/************************************************** Recursive Solution ************************************************/

class Solution
{
    public int minDeletions(int arr[], int size)
    {
        int lis = longestSubsequence(size, arr, -1);
        return size - lis;
    }

    public int longestSubsequence(int curr, int arr[], int prev) {
        if (curr <= 0)
            return 0;

        //case 1: exclude the current element
        int exclude = longestSubsequence(curr-1, arr, prev);

        //case 2: include the current element
        int include = 0;
        if (prev == -1 || arr[curr-1] < arr[prev-1]) {
            include = longestSubsequence(curr-1, arr, curr) + 1;
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
    public int minDeletions(int arr[], int size)
    {
        int[][] dp = new int[size+1][ size+1];
        for (int i=0; i<size+1; i++) {
            for (int j=0; j<size+1; j++) {
                dp[i][j] = -1;
            }
        }

        int lis = longestSubsequence(size, arr, -1, dp);
        return size - lis;
    }

    public int longestSubsequence(int curr, int arr[], int prev, int[][] dp) {
        if (curr <= 0)
            return 0;

        if (prev != -1 && dp[curr][prev] != -1)
            return dp[curr][prev];

        //case 1: exclude the current element
        int exclude = longestSubsequence(curr-1, arr, prev, dp);

        //case 2: include the current element
        int include = 0;
        if (prev == -1 || arr[curr-1] < arr[prev-1]) {
            include = longestSubsequence(curr-1, arr, curr, dp) + 1;
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
    public int minDeletions(int arr[], int n)
    {
        int lis = lengthOfLIS(arr);
        return n-lis;
    }

    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        int max = 1;

        for (int i=0; i<size; i++) {
            dp[i] = 1;
        }

        for (int i=1; i<size; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}

/*
Time Complexity: O(n^2)
Auxiliary Space: O(n)
*/
