/*
Company Tags:
Practice Portal:
Geeksforgeeks:
LeetCode: https://leetcode.com/problems/longest-palindromic-subsequence/
*/

// PARENT PROBLEM: Longest Common Subsequence

/************************************************** Recursive Solution ************************************************/

class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        return longestCommonSubsequence(s, sb.toString(), s.length(), sb.toString().length());
    }

    public int longestCommonSubsequence(String s1, String s2, int l1, int l2) {
        if (l1<=0 || l2<=0) return 0;

        if (s1.charAt(l1-1) == s2.charAt(l2-1))
            return 1 + longestCommonSubsequence(s1, s2, l1-1, l2-1);
        else
            return Math.max(longestCommonSubsequence(s1, s2, l1-1, l2), longestCommonSubsequence(s1, s2, l1, l2-1));
    }
}

/*
Time Complexity: The time complexity of this recursive approach is exponential as there is a case of overlapping subproblems
as explained in the recursive tree diagram above.
Auxiliary Space: O(1). No external space used for storing values apart from the internal stack space.
*/

/****************************************** Memoization Solution (Top-Down) *******************************************/

class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();

        int row = s.length();
        int col = sb.toString().length();

        int[][] dp = new int[row + 1][col + 1];
        for (int i=0; i<row+1; i++) {
            for (int j=0; j<col+1; j++) {
                dp[i][j] = -1;
            }
        }

        return longestCommonSubsequence(s, sb.toString(), s.length(), sb.toString().length(), dp);
    }

    public int longestCommonSubsequence(String s1, String s2, int l1, int l2, int[][] dp) {
        if (l1<=0 || l2<=0) return 0;

        if (dp[l1][l2] != -1)
            return dp[l1][l2];

        if (s1.charAt(l1-1) == s2.charAt(l2-1))
            dp[l1][l2] = 1 + longestCommonSubsequence(s1, s2, l1-1, l2-1, dp);
        else
            dp[l1][l2] = Math.max(longestCommonSubsequence(s1, s2, l1-1, l2, dp),
                    longestCommonSubsequence(s1, s2, l1, l2-1, dp));

        return dp[l1][l2];
    }
}

/*
Time Complexity: O(n^2)
Auxiliary Space: O(n^2) (Apart from the internal stack space)
*/

/************************************************** Bottom-up Solution ************************************************/

class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        return longestCommonSubsequence(s, sb.toString(), s.length(), sb.toString().length());
    }

    public int longestCommonSubsequence(String s1, String s2, int p, int q) {
        int[][] arr=new int[p+1][q+1];

        for (int row=0; row<p+1; row++) {
            for (int colomn=0;colomn<q+1;colomn++) {
                arr[row][colomn] = 0;
            }
        }

        for (int row=1; row<p+1; row++) {
            for (int colomn=1; colomn<q+1; colomn++) {
                if (s1.charAt(row-1) != s2.charAt(colomn-1)) {
                    arr[row][colomn] = Math.max(arr[row-1][colomn],
                            arr[row][colomn-1]);
                } else {
                    arr[row][colomn] = arr[row-1][colomn-1] + 1;
                }
            }
        }
        return arr[p][q];
    }
}

/*
Time Complexity: O(n^2)
Auxiliary Space: O(n^2)
*/
