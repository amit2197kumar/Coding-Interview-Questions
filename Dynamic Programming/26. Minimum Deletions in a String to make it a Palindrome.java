/*
Company Tags:  Amazon
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/minimum-deletitions/0
*/

// PARENT PROBLEM: Longest Common Subsequence

/************************************************** Recursive Solution ************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        while (test-- > 0) {
            String s=sc.next();
            StringBuilder sb=new StringBuilder(s);
            sb.reverse();
            int l = longestCommonSubsequence(s, sb.toString(), s.length(), sb.toString().length());
            System.out.println(s.length() - l);
        }

    }

    public static int longestCommonSubsequence(String s1, String s2, int p, int q) {

        if (p==0 || q ==0)
            return 0;

        if (s1.charAt(p-1) == s2.charAt(q-1)) {
            return longestCommonSubsequence(s1, s2, p-1, q-1) + 1;
        } else {
            return Math.max(longestCommonSubsequence(s1, s2, p-1, q),
                    longestCommonSubsequence(s1, s2, p, q-1));
        }
    }
}

/*
Time Complexity: The time complexity of this recursive approach is exponential 2^n
*/

/****************************************** Memoization Solution (Top-Down) *******************************************/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        while (test-- > 0) {
            String s=sc.next();
            StringBuilder sb=new StringBuilder(s);
            sb.reverse();

            int[][] dp = new int[s.length()+1][s.length()+1];
            for (int i=0; i<s.length()+1; i++) {
                for (int j=0; j<s.length()+1; j++) {
                    dp[i][j] = -1;
                }
            }

            int l = longestCommonSubsequence(s, sb.toString(), s.length(), sb.toString().length(), dp);
            System.out.println(s.length() - l);
        }

    }

    public static int longestCommonSubsequence(String s1, String s2, int p, int q, int[][] dp) {

        if (p==0 || q ==0)
            return 0;

        if (dp[p][q] != -1)
            return dp[p][q];

        if (s1.charAt(p-1) == s2.charAt(q-1)) {
            dp[p][q] = longestCommonSubsequence(s1, s2, p-1, q-1, dp) + 1;
        } else {
            dp[p][q] = Math.max(longestCommonSubsequence(s1, s2, p-1, q, dp),
                    longestCommonSubsequence(s1, s2, p, q-1, dp));
        }
        return dp[p][q];
    }
}

/*
Time Complexity: O(n^2)
Auxiliary Space: O(n^2) (Apart from the internal stack space)
*/

/************************************************** Bottom-up Solution ************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        while (test-- > 0) {
            String s=sc.next();
            StringBuilder sb=new StringBuilder(s);
            sb.reverse();

            int l = longestCommonSubsequence(s, sb.toString(), s.length(), sb.toString().length());
            System.out.println(s.length() - l);
        }

    }

    public static int longestCommonSubsequence(String s1, String s2, int p, int q) {

        int[][] dp = new int[p+1][q+1];
        for(int i=0; i<p+1; i++)
            dp[i][0] = 0;

        for(int j=0; j<q+1; j++)
            dp[0][j] = 0;

        for (int i=1; i<p+1; i++) {
            for (int j=1; j<q+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],
                            dp[i][j-1]);
                }
            }
        }
        return dp[p][q];
    }
}

/*
Time Complexity: O(n^2)
Auxiliary Space: O(n^2)
*/
