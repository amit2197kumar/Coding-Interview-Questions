/*
Company Tags:
Practice Portal:
LeetCode: https://leetcode.com/problems/target-sum/
*/

// PARENT PROBLEM: Count number of subset with given difference & Count of subsets with sum equal to X

/************************************************** Recursive Solution ************************************************/

class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int sum = 0;
        int count0 = 0;
        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];

            if (arr[i] == 0)
                count0++;
        }

        if (target > sum)
            return 0;

        int subSetSum = (target + sum);
        if (subSetSum%2!=0)
            return 0;

        subSetSum = subSetSum/2;

        int subSetSumCount = subSetSumHelper(arr, subSetSum, arr.length);

        return (int)Math.pow(2,count0) * subSetSumCount;
    }

    //Recursive Solution
    public int subSetSumHelper(int[] arr, int sum, int currIndex) {
        if (sum == 0)
            return 1;

        if (currIndex <= 0)
            return 0;

        if (sum >= arr[currIndex-1]) {
            return subSetSumHelper(arr, sum, currIndex-1) +
                    subSetSumHelper(arr, sum-arr[currIndex-1], currIndex-1);
        } else {
            return subSetSumHelper(arr, sum, currIndex-1);
        }
    }
}

/****************************************** Memoization Solution (Top-Down) *******************************************/

class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int sum = 0;
        int count0 = 0;
        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];

            if (arr[i] == 0)
                count0++;
        }

        if (target > sum)
            return 0;

        int subSetSum = (target + sum);
        if (subSetSum%2!=0)
            return 0;

        subSetSum = subSetSum/2;

        int[][] dp = new int[arr.length + 1][subSetSum + 1];

        for (int i=0; i<arr.length+1; i++) {
            for (int j=0; j<subSetSum+1; j++) {
                dp[i][j] = -1;
            }
        }

        int subSetSumCount = subSetSumHelper(arr, subSetSum, arr.length, dp);

        return (int)Math.pow(2,count0) * subSetSumCount;
    }

    //Memoization Solution (Top-Down) : Recursive Call + DP Matrix
    public int subSetSumHelper(int[] arr, int sum, int currIndex, int[][] dp) {
        if (sum == 0)
            return 1;
        if (currIndex <= 0)
            return 0;

        if (dp[currIndex][sum] != -1)
            return dp[currIndex][sum];

        if (sum >= arr[currIndex-1]) {
            dp[currIndex][sum] = subSetSumHelper(arr, sum, currIndex-1, dp) +
                    subSetSumHelper(arr, sum-arr[currIndex-1], currIndex-1, dp);
        } else {
            dp[currIndex][sum] = subSetSumHelper(arr, sum, currIndex-1, dp);
        }

        return dp[currIndex][sum];
    }
}

/************************************************** Bottom-up Solution ************************************************/

class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int sum = 0;
        int count0 = 0;
        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];

            if (arr[i] == 0)
                count0++;
        }

        if (target > sum)
            return 0;

        int subSetSum = (target + sum);
        if (subSetSum%2!=0)
            return 0;

        subSetSum = subSetSum/2;

        int subSetSumCount = subSetSumHelper(arr, subSetSum, arr.length);

        return (int)Math.pow(2,count0) * subSetSumCount;
    }

    //Bottom-up Solution
    public int subSetSumHelper(int[] arr, int sum, int currIndex) {
        int row = currIndex+1;
        int col = sum+1;

        int[][] dp = new int[row][col];

        for (int i=0; i<row; i++)
            dp[i][0] = 1;

        for (int j=1; j<col; j++)
            dp[0][j] = 0;


        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {
                if ( j >= arr[i-1]) {
                    dp[i][j] = dp[i-1][j] +
                            dp[i-1][j-arr[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[row-1][col-1];
    }
}