/*
Company Tags: Amazon Microsoft Morgan Stanley
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1
*/

// PARENT PROBLEM: Longest Common Subsequence

/************************************************** Recursive Solution ************************************************/

class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        return longestCommonSubstrHelper(s1, s2, n, m, 0);
    }

    int longestCommonSubstrHelper(String s1, String s2, int n, int m, int length) {
        if (n==0 || m==0)
            return length;

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return longestCommonSubstrHelper(s1, s2, n-1, m-1, length+1);
        } else {
            return Math.max(length, Math.max(longestCommonSubstrHelper(s1, s2, n-1, m, 0),
                    longestCommonSubstrHelper(s1, s2, n, m-1, 0)));
        }
    }
}

/****************************************** Memoization Solution (Top-Down) *******************************************/

/************************************************** Bottom-up Solution ************************************************/

class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        int row = n+1;
        int col = m+1;
        int[][] dp = new int[row][col];

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (i==0 || j==0)
                    dp[i][j] = 0 ;
            }
        }

        int maxLen = 0;
        for (int i=1 ;i<row; i++) {
            for (int j=1; j<col; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        return maxLen;
    }
}
